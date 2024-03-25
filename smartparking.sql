-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 13, 2024 at 07:49 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartparking`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking_sessions`
--

DROP TABLE IF EXISTS `booking_sessions`;
CREATE TABLE IF NOT EXISTS `booking_sessions` (
  `session_id` bigint NOT NULL AUTO_INCREMENT,
  `booking_id` bigint DEFAULT NULL,
  `booking_time` datetime DEFAULT NULL,
  `calculated_bill` double DEFAULT NULL,
  `parking_out_time` datetime DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking_sessions`
--

INSERT INTO `booking_sessions` (`session_id`, `booking_id`, `booking_time`, `calculated_bill`, `parking_out_time`) VALUES
(2, 8, '2024-03-13 07:42:21', 70, '2024-01-27 22:45:00'),
(3, 9, '2024-01-27 19:30:00', 15, '2024-01-27 22:45:00');

-- --------------------------------------------------------

--
-- Table structure for table `parking`
--

DROP TABLE IF EXISTS `parking`;
CREATE TABLE IF NOT EXISTS `parking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `availableParkingSpot` int NOT NULL,
  `openSpace` tinyint(1) NOT NULL,
  `covered` tinyint(1) NOT NULL,
  `accessibleSpot` tinyint(1) NOT NULL,
  `openSpaceAvailability` int NOT NULL,
  `coveredAvailability` int NOT NULL,
  `accessibleSpotAvailability` int NOT NULL,
  `minParkTime` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `operationHour` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `accessible_spot` bit(1) NOT NULL,
  `accessible_spot_availability` int NOT NULL,
  `available_parking_spot` int NOT NULL,
  `covered_availability` int NOT NULL,
  `min_park_time` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `open_space` bit(1) NOT NULL,
  `open_space_availability` int NOT NULL,
  `operation_hour` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `parking`
--

INSERT INTO `parking` (`id`, `name`, `address`, `availableParkingSpot`, `openSpace`, `covered`, `accessibleSpot`, `openSpaceAvailability`, `coveredAvailability`, `accessibleSpotAvailability`, `minParkTime`, `operationHour`, `accessible_spot`, `accessible_spot_availability`, `available_parking_spot`, `covered_availability`, `min_park_time`, `open_space`, `open_space_availability`, `operation_hour`) VALUES
(1, 'Market Mall', '3625 Shaganappi Trail NW, Calgary, AB T3A 0E2', 120, 1, 1, 1, 80, 40, 20, '30min', '24H', b'0', 0, 0, 0, NULL, b'0', 0, NULL),
(2, 'CF Chinook Center', '6455 Macleod Trail, Calgary, AB T2H 0K8', 120, 1, 1, 1, 80, 40, 20, '30min', '24H', b'0', 0, 0, 0, NULL, b'0', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `parking_bookings`
--

DROP TABLE IF EXISTS `parking_bookings`;
CREATE TABLE IF NOT EXISTS `parking_bookings` (
  `booking_id` bigint NOT NULL AUTO_INCREMENT,
  `booking_date_time` datetime DEFAULT NULL,
  `booking_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `car_number_plate` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `parking_in_time` datetime DEFAULT NULL,
  `place_id` bigint DEFAULT NULL,
  `total_hours_stayed` bigint DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `parking_bookings`
--

INSERT INTO `parking_bookings` (`booking_id`, `booking_date_time`, `booking_type`, `car_number_plate`, `parking_in_time`, `place_id`, `total_hours_stayed`, `user_id`) VALUES
(9, '2024-01-27 19:30:00', 'Normal', 'ABC123', NULL, 1, NULL, 'user123'),
(8, '2024-03-13 07:42:21', 'VIP', 'ABC123', NULL, 1, NULL, 'user123');

-- --------------------------------------------------------

--
-- Table structure for table `parking_lot_details`
--

DROP TABLE IF EXISTS `parking_lot_details`;
CREATE TABLE IF NOT EXISTS `parking_lot_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `capacity` int NOT NULL,
  `available_parking_spot` int NOT NULL,
  `open_space` tinyint(1) NOT NULL,
  `covered` tinyint(1) NOT NULL,
  `CCTV` tinyint(1) NOT NULL,
  `gated` tinyint(1) NOT NULL,
  `accessible_spot` tinyint(1) NOT NULL,
  `open_space_availability` int NOT NULL,
  `covered_availability` int NOT NULL,
  `accessible_spot_availability` int NOT NULL,
  `min_park_time` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `operation_hour` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `parking_lot_details`
--

INSERT INTO `parking_lot_details` (`id`, `name`, `address`, `latitude`, `longitude`, `capacity`, `available_parking_spot`, `open_space`, `covered`, `CCTV`, `gated`, `accessible_spot`, `open_space_availability`, `covered_availability`, `accessible_spot_availability`, `min_park_time`, `operation_hour`) VALUES
(1, 'Market Mall', '3625 Shaganappi Trail NW, Calgary, AB T3A 0E2', 51.08469774189237, -114.15541073189554, 300, 120, 1, 1, 1, 1, 1, 80, 40, 20, '30min', '24H');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `intent` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` bigint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `full_name`, `intent`, `password`, `phone`) VALUES
(1, 'test@gmail.com', 'Hello World!', 'app', '12345678', 111111111);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
