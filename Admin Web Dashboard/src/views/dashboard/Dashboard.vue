<template>
  <div>
    <WidgetsStatsA class="mb-4" />
    <CRow>
      <CCol :md="12">
        <CCard class="mb-4">
          <CCardBody>
            <CRow>
              <CCol :sm="5">
                <h4 id="traffic" class="card-title mb-0">Monthly Pre-Booking</h4>
                <div class="small text-body-secondary">January - December 2024</div>
              </CCol>
            </CRow>
            <CRow>
              <MainChart :bookingData="bookingData" style="height: 300px; max-height: 300px; margin-top: 40px" />
            </CRow>
          </CCardBody>
          
        </CCard>
      </CCol>
    </CRow>
    <WidgetsStatsD class="mb-4" />
    
  </div>

  <div>
    <CRow>
      <CCol :md="12">
        <CCard class="mb-4">
          <CCardBody>
            <CRow>
              <CCol :sm="5">
                <h4 id="traffic" class="card-title mb-0">Monthly Active Users</h4>
                <div class="small text-body-secondary">January - December 2024</div>
              </CCol>
            </CRow>
            <CRow>
              <MainChart2 :userData="userData" style="height: 300px; max-height: 300px; margin-top: 40px" />
            </CRow>
          </CCardBody>
          
        </CCard>
      </CCol>
    </CRow>
    <WidgetsStatsD class="mb-4" />
    
  </div>
</template>

<script>
import avatar1 from '@/assets/images/avatars/1.jpg'
import avatar2 from '@/assets/images/avatars/2.jpg'
import avatar3 from '@/assets/images/avatars/3.jpg'
import avatar4 from '@/assets/images/avatars/4.jpg'
import avatar5 from '@/assets/images/avatars/5.jpg'
import avatar6 from '@/assets/images/avatars/6.jpg'
import MainChart from './MainChart'
import MainChart2 from './MainChart2.vue'
import WidgetsStatsA from './../widgets/WidgetsStatsTypeA.vue'
import WidgetsStatsD from './../widgets/WidgetsStatsTypeD.vue'
import axios from 'axios'
import { ref, onMounted } from 'vue';

export default {
  name: 'Dashboard',
  components: {
    MainChart,
    MainChart2,
    WidgetsStatsA,
    WidgetsStatsD,
  },
  setup() {

    const bookingData = ref({}); // This will hold fetched booking data

    const fetchBookingData = async () => {
      try {
        const response = await axios.get('http://18.144.20.166:8080/v1/analytics/booking', {
          params: { year: 2024, filter: 'monthly' }
        });
        bookingData.value = response.data;
      } catch (error) {
        console.error('Error fetching booking data:', error);
      }
    };

    const userData = ref({}); // This will hold fetched user data

    const fetchUserData = async () => {
      try {
        const response = await axios.get('http://18.144.20.166:8080/v1/analytics/user', {
          params: { year: 2024, filter: 'monthly' }
        });
        userData.value = response.data;
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };

    onMounted(() => {
      fetchBookingData()
      fetchUserData()
      
    })



    const progressGroupExample1 = [
      { title: 'Monday', value1: 34, value2: 78 },
      { title: 'Tuesday', value1: 56, value2: 94 },
      { title: 'Wednesday', value1: 12, value2: 67 },
      { title: 'Thursday', value1: 43, value2: 91 },
      { title: 'Friday', value1: 22, value2: 73 },
      { title: 'Saturday', value1: 53, value2: 82 },
      { title: 'Sunday', value1: 9, value2: 69 },
    ]
    const progressGroupExample2 = [
      { title: 'Male', icon: 'cil-user', value: 53 },
      { title: 'Female', icon: 'cil-user-female', value: 43 },
    ]
    const progressGroupExample3 = [
      {
        title: 'Organic Search',
        icon: 'cib-google',
        percent: 56,
        value: '191,235',
      },
      { title: 'Facebook', icon: 'cib-facebook', percent: 15, value: '51,223' },
      { title: 'Twitter', icon: 'cib-twitter', percent: 11, value: '37,564' },
      { title: 'LinkedIn', icon: 'cib-linkedin', percent: 8, value: '27,319' },
    ]
    const tableExample = [
      {
        avatar: { src: avatar1, status: 'success' },
        user: {
          name: 'Yiorgos Avraamu',
          new: true,
          registered: 'Jan 1, 2023',
        },
        country: { name: 'USA', flag: 'cif-us' },
        usage: {
          value: 100,
          period: 'Jun 11, 2023 - Jul 10, 2023',
          color: 'success',
        },
        payment: { name: 'Mastercard', icon: 'cib-cc-mastercard' },
        activity: '10 sec ago',
      },
      {
        avatar: { src: avatar2, status: 'danger' },
        user: {
          name: 'Avram Tarasios',
          new: false,
          registered: 'Jan 1, 2023',
        },
        country: { name: 'Brazil', flag: 'cif-br' },
        usage: {
          value: 22,
          period: 'Jun 11, 2023 - Jul 10, 2023',
          color: 'info',
        },
        payment: { name: 'Visa', icon: 'cib-cc-visa' },
        activity: '5 minutes ago',
      },
      {
        avatar: { src: avatar3, status: 'warning' },
        user: { name: 'Quintin Ed', new: true, registered: 'Jan 1, 2023' },
        country: { name: 'India', flag: 'cif-in' },
        usage: {
          value: 74,
          period: 'Jun 11, 2023 - Jul 10, 2023',
          color: 'warning',
        },
        payment: { name: 'Stripe', icon: 'cib-cc-stripe' },
        activity: '1 hour ago',
      },
      {
        avatar: { src: avatar4, status: 'secondary' },
        user: { name: 'Enéas Kwadwo', new: true, registered: 'Jan 1, 2023' },
        country: { name: 'France', flag: 'cif-fr' },
        usage: {
          value: 98,
          period: 'Jun 11, 2023 - Jul 10, 2023',
          color: 'danger',
        },
        payment: { name: 'PayPal', icon: 'cib-cc-paypal' },
        activity: 'Last month',
      },
      {
        avatar: { src: avatar5, status: 'success' },
        user: {
          name: 'Agapetus Tadeáš',
          new: true,
          registered: 'Jan 1, 2023',
        },
        country: { name: 'Spain', flag: 'cif-es' },
        usage: {
          value: 22,
          period: 'Jun 11, 2023 - Jul 10, 2023',
          color: 'primary',
        },
        payment: { name: 'Google Wallet', icon: 'cib-cc-apple-pay' },
        activity: 'Last week',
      },
      {
        avatar: { src: avatar6, status: 'danger' },
        user: {
          name: 'Friderik Dávid',
          new: true,
          registered: 'Jan 1, 2023',
        },
        country: { name: 'Poland', flag: 'cif-pl' },
        usage: {
          value: 43,
          period: 'Jun 11, 2023 - Jul 10, 2023',
          color: 'success',
        },
        payment: { name: 'Amex', icon: 'cib-cc-amex' },
        activity: 'Last week',
      },
    ]

    return {
      tableExample,
      progressGroupExample1,
      progressGroupExample2,
      progressGroupExample3,
      bookingData,
      userData
    }
  },
}
</script>
