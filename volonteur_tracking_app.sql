-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2018 at 04:46 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `volonteur_tracking_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id` int(5) NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `start_time` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `end_time` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hours_duration` float NOT NULL,
  `place` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `is_deleted` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `name`, `date`, `start_time`, `end_time`, `hours_duration`, `place`, `is_deleted`) VALUES
(1, 'DDk', '2018-06-12', '10:00', '14:00', 4, 'Vukasoviceva 21dj', 0),
(2, 'Dodela paketica', '2017-12-31', '12:00', '17:00', 5, 'Prostorije CK Vozdovac', 0),
(3, 'tset', '2018-06-13', 'test', 'setet', 4, 'tset', 0),
(4, 'D2m global', '0122-01-03', '14:00', '17:00', 3, 'tsetset', 0),
(5, 'D2m global', '0181-02-02', '14:00', '17:00', 3, 'Adresa 21', 0),
(6, 'D2m global', '0113-12-02', '14:00', '17:00', 3, 'Adresa 21', 0),
(7, 'tertsetset', '0189-06-03', '14:00', '17:00', 3, 'Adresa 21', 0),
(8, 'D2m global', '0188-09-03', '14:00', '20:00', 6, 'tsetset', 0),
(9, 'Dodavanje akcije1', '0189-02-02', '10:15', '14:00', 4, 'Neka adresa 21', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(5) NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `start_year` int(5) NOT NULL,
  `password` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `is_deleted` int(11) NOT NULL,
  `is_admin` int(1) NOT NULL,
  `username` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `last_name`, `birthday`, `start_year`, `password`, `is_deleted`, `is_admin`, `username`) VALUES
(1, 'test', 'test', '2018-06-06', 2012, '123', 0, 1, 'test'),
(2, 'tset2', 'test2', '2018-06-20', 2015, 'pass', 0, 0, 'test.test'),
(3, 'Blagoje', 'Stankovic', '2018-06-20', 2012, '123123123', 0, 0, 'bstankovic95'),
(4, 'Nemanja', 'Aleksandrovic', '2018-06-13', 2007, '123', 0, 0, 'n.a'),
(5, 'Dusan', 'Milinkovic', '2018-01-15', 2009, '321', 0, 0, 'd.m');

-- --------------------------------------------------------

--
-- Table structure for table `user_event_xref`
--

CREATE TABLE `user_event_xref` (
  `id` int(11) NOT NULL,
  `hours` float NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  `is_deleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_event_xref`
--

INSERT INTO `user_event_xref` (`id`, `hours`, `user_id`, `event_id`, `is_deleted`) VALUES
(9, 4, 1, 1, 0),
(10, 5, 2, 2, 0),
(11, 2, 4, 1, 0),
(12, 4, 1, 8, 0),
(13, 4, 3, 1, 0),
(14, 5, 5, 1, 0),
(15, 5, 5, 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `user_event_xref`
--
ALTER TABLE `user_event_xref`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `event_id` (`event_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_event_xref`
--
ALTER TABLE `user_event_xref`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_event_xref`
--
ALTER TABLE `user_event_xref`
  ADD CONSTRAINT `user_event_xref_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `user_event_xref_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
