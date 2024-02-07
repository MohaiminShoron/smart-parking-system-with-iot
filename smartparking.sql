-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 07, 2024 at 02:11 AM
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
-- Table structure for table `parking`
--

DROP TABLE IF EXISTS `parking`;
CREATE TABLE IF NOT EXISTS `parking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `availableParkingSpot` int NOT NULL,
  `openSpace` tinyint(1) NOT NULL,
  `covered` tinyint(1) NOT NULL,
  `accessibleSpot` tinyint(1) NOT NULL,
  `openSpaceAvailability` int NOT NULL,
  `coveredAvailability` int NOT NULL,
  `accessibleSpotAvailability` int NOT NULL,
  `minParkTime` varchar(10) NOT NULL,
  `operationHour` varchar(5) NOT NULL,
  `accessible_spot` bit(1) NOT NULL,
  `accessible_spot_availability` int NOT NULL,
  `available_parking_spot` int NOT NULL,
  `covered_availability` int NOT NULL,
  `min_park_time` varchar(255) DEFAULT NULL,
  `open_space` bit(1) NOT NULL,
  `open_space_availability` int NOT NULL,
  `operation_hour` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `parking`
--

INSERT INTO `parking` (`id`, `name`, `address`, `availableParkingSpot`, `openSpace`, `covered`, `accessibleSpot`, `openSpaceAvailability`, `coveredAvailability`, `accessibleSpotAvailability`, `minParkTime`, `operationHour`, `accessible_spot`, `accessible_spot_availability`, `available_parking_spot`, `covered_availability`, `min_park_time`, `open_space`, `open_space_availability`, `operation_hour`) VALUES
(1, 'Market Mall', '3625 Shaganappi Trail NW, Calgary, AB T3A 0E2', 120, 1, 1, 1, 80, 40, 20, '30min', '24H', b'0', 0, 0, 0, NULL, b'0', 0, NULL),
(2, 'CF Chinook Center', '6455 Macleod Trail, Calgary, AB T2H 0K8', 120, 1, 1, 1, 80, 40, 20, '30min', '24H', b'0', 0, 0, 0, NULL, b'0', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `intent` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` bigint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `full_name`, `intent`, `password`, `phone`) VALUES
(1, 'test@gmail.com', 'Hello World!', 'app', '12345678', 111111111);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
