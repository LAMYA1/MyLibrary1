-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Apr 07, 2021 at 12:05 PM
-- Server version: 5.7.32
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ABCPublisher`
--

-- --------------------------------------------------------

--
-- Table structure for table `Book`
--

CREATE TABLE `Book` (
  `bookID` int(5) NOT NULL,
  `category` text NOT NULL,
  `title` text NOT NULL,
  `authors` text NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Book`
--

INSERT INTO `Book` (`bookID`, `category`, `title`, `authors`, `price`) VALUES
(2222, 'Computers', 'Programming the World Wide Web', 'Robert Sebesta', 190),
(11111, 'Computers', 'Fundamentals of Web Development', 'Randy Connolly and Ricardo Hoar', 200),
(33333, 'Children', 'First 100 Words', 'Roger Priddy', 30.59),
(44444, 'Cooking', '5 Ingredients: Quick and Easy Food', 'Jamie Oliver', 126.85),
(55555, 'Children', 'Wordsearches for Clever Kids', 'Gareth Moore and Chris Dickason', 25.62);

-- --------------------------------------------------------

--
-- Table structure for table `BookOrders`
--

CREATE TABLE `BookOrders` (
  `bookID` int(5) NOT NULL,
  `bookStore` char(50) NOT NULL,
  `quantity` int(5) NOT NULL,
  `month` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `BookOrders`
--

INSERT INTO `BookOrders` (`bookID`, `bookStore`, `quantity`, `month`) VALUES
(2222, 'Best Reading', 133, 'Mar'),
(2222, 'Bookshelves', 93, 'Jan'),
(2222, 'Tech Books', 44, 'Feb'),
(11111, 'Bookshelves', 88, 'Feb'),
(11111, 'Tech Books', 59, 'Jan'),
(33333, 'Best Reading', 68, 'Apr'),
(44444, 'Best Reading', 45, 'Apr'),
(44444, 'Bookshelves', 50, 'Mar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Book`
--
ALTER TABLE `Book`
  ADD PRIMARY KEY (`bookID`);

--
-- Indexes for table `BookOrders`
--
ALTER TABLE `BookOrders`
  ADD PRIMARY KEY (`bookID`,`bookStore`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `BookOrders`
--
ALTER TABLE `BookOrders`
  ADD CONSTRAINT `bookorders_ibfk_1` FOREIGN KEY (`bookID`) REFERENCES `Book` (`bookID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
