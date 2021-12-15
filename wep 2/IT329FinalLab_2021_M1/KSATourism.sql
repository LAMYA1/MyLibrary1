-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Apr 07, 2021 at 03:41 PM
-- Server version: 5.7.32
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `KSATourism`
--

-- --------------------------------------------------------

--
-- Table structure for table `City`
--

CREATE TABLE `City` (
  `cityID` int(5) NOT NULL,
  `name` text NOT NULL,
  `region` text NOT NULL,
  `attractions` text NOT NULL,
  `priceRange` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `City`
--

INSERT INTO `City` (`cityID`, `name`, `region`, `attractions`, `priceRange`) VALUES
(11111, 'Riyadh', 'Central Region', 'Historical Diriyah, Museums', 'High'),
(22222, 'Makkah', 'West Region', 'Masjid Al-Haram', 'Medium'),
(33333, 'Medina', 'West Region', 'Masjid Al-Nabawi', 'Medium'),
(44444, 'Jeddah', 'West Region', 'Red Sea, King Fahd\'s Fountain', 'High'),
(55555, 'Taif', 'West Region', 'Parks and Mountains', 'Low');

-- --------------------------------------------------------

--
-- Table structure for table `TourismStatistics`
--

CREATE TABLE `TourismStatistics` (
  `cityID` int(5) NOT NULL,
  `month` char(50) NOT NULL,
  `numberOfTourists` int(5) NOT NULL,
  `topAttraction` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TourismStatistics`
--

INSERT INTO `TourismStatistics` (`cityID`, `month`, `numberOfTourists`, `topAttraction`) VALUES
(11111, 'Feb', 2800, 'Museums'),
(11111, 'Jan', 2500, 'Museums'),
(11111, 'Mar', 2900, 'Historical Diriyah'),
(22222, 'Feb', 8700, 'Masjid Al-Haram'),
(22222, 'Jan', 8000, 'Masjid Al-Haram'),
(33333, 'Feb', 7700, 'Masjid Al-Nabawi'),
(33333, 'Jan', 7600, 'Masjid Al-Nabawi'),
(55555, 'Jan', 5360, 'Parks');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `City`
--
ALTER TABLE `City`
  ADD PRIMARY KEY (`cityID`);

--
-- Indexes for table `TourismStatistics`
--
ALTER TABLE `TourismStatistics`
  ADD PRIMARY KEY (`cityID`,`month`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `TourismStatistics`
--
ALTER TABLE `TourismStatistics`
  ADD CONSTRAINT `tourismstatistics_ibfk_1` FOREIGN KEY (`cityID`) REFERENCES `City` (`cityID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
