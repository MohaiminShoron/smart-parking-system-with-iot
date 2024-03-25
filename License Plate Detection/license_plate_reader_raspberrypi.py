import cv2
import imutils
import numpy as np
import pytesseract
import logging
# from PIL import Image
import time
from picamera2 import Picamera2,Preview
import requests
import os
import pyrebase as pyre

logger = logging.getLogger(__name__)
logging.basicConfig(format='%(asctime)s - [%(name)s] - [%(levelname)s] - %(message)s',level=logging.DEBUG)


#Picamera to detect image

logger.info("Setting up Picamera")


spring_endpoint = os.environ.get('SPRINGENDPOINT',None)
firebase_config = {
  'apiKey': "AIzaSyDF7S8ErKFMs-5-6DvvXh-wXL31vqiip_o",
  'authDomain': "capstone-156f8.firebaseapp.com",
  'databaseURL': "https://capstone-156f8-default-rtdb.firebaseio.com",
  'projectId': "capstone-156f8",
  'storageBucket': "capstone-156f8.appspot.com",
  'messagingSenderId': "978062223858",
  'appId': "1:978062223858:web:893d76954df8bd735ba36b",
  'measurementId': "G-5RSFDFNH05"
}
firebase = pyre.initialize_app(firebase_config)
firebase_db = firebase.database()
top_level_child = os.getenv('TOPLEVELCHILD','MarketMall')

def open_gate_signal():
      try:
            logger.info("Sending Open Gate signal to Firebase")
            firebase_db.child(top_level_child).child("Gate").child("VipEntry").update({"status":True})
      except Exception as err:
            logger.error("Unable to send signal to firebase.")
            raise Exception(err)

if __name__ == '__main__':
      while True and spring_endpoint is not None:
            try:
                  retries = 3
                  success = False
                  logger.info("Capturing Image")
                  picam = Picamera2()
                  config = picam.create_preview_configuration()
                  picam.configure(config)
                  picam.start_preview(Preview.QTGL)
                  picam.start()
                  time.sleep(2)
                  img = picam.capture_array("main")

                  picam.close()
                  logger.info("Image captured")
                  logger.info("Processing Image")
                  gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY) #convert to grey scale
                  gray = cv2.bilateralFilter(gray, 11, 17, 17) #Blur to reduce noise

                  edged = cv2.Canny(gray, 30, 200) #Perform Edge detection
                  logger.info("Finding contours")
                  nts = cv2.findContours(edged.copy(), cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
                  cnts = imutils.grab_contours(nts)
                  cnts = sorted(cnts, key = cv2.contourArea, reverse = True)[:10]
                  screenCnt = None

                  # loop over contours
                  for c in cnts:
                              # approximate the contour
                              peri = cv2.arcLength(c, True)
                              approx = cv2.approxPolyDP(c, 0.018 * peri, True)
                              # if our approximated contour has four points, then
                              # we can assume that we have found our screen
                              if len(approx) == 4:
                                    screenCnt = approx
                                    break
                              
                  # Masking the part other than the number plate
                  mask = np.zeros(gray.shape,np.uint8)
                  new_image = cv2.drawContours(mask,[screenCnt],0,255,-1,)
                  new_image = cv2.bitwise_and(img,img,mask=mask)

                  # Now crop
                  (x, y) = np.where(mask == 255)
                  (topx, topy) = (np.min(x), np.min(y))
                  (bottomx, bottomy) = (np.max(x), np.max(y))
                  Cropped = gray[topx:bottomx+1, topy:bottomy+1]
                  logger.info("Converting image to string")
                  #Read the number plate
                  number_plate = pytesseract.image_to_string(Cropped, config='--psm 13')
                  logger.info(f"Number plate detected is {number_plate}")
                  params_endpoint = {'licensePlateNumber':number_plate}
                  number_plate_is_valid = requests.get(spring_endpoint,params=params_endpoint)
                  if number_plate_is_valid:
                        while retries > 0 and success == False:
                              try:
                                    if retries < 3:
                                          logger.info(f"Retrying with {3 - retries} try")
                                    open_gate_signal()
                                    success = True
                                    retries = 0
                              except Exception as err:
                                    retries-=1
                                    logger.error("Unable to connect to firebase")   
                  time.sleep(5)
            except Exception as err:
                  logger.exception("Unable to detect image")
                  logger.error(err)
                  time.sleep(5)