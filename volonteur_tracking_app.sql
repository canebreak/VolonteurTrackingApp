-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2018 at 02:59 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

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
  `name` text NOT NULL,
  `date` date NOT NULL,
  `start_time` text NOT NULL,
  `volonteur_number` int(5) NOT NULL,
  `end_time` varchar(6) NOT NULL,
  `hours_duration` float NOT NULL,
  `place` text NOT NULL,
  `is_deleted` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `name`, `date`, `start_time`, `volonteur_number`, `end_time`, `hours_duration`, `place`, `is_deleted`) VALUES
(1, 'DDk', '2018-06-12', '10:00', 5, '14:00', 4, 'Vukasoviceva 21dj', 0),
(2, 'Dodela paketica', '2017-12-31', '12:00', 15, '17:00', 5, 'Prostorije CK Vozdovac', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(5) NOT NULL,
  `name` text NOT NULL,
  `last_name` text NOT NULL,
  `birthday` date NOT NULL,
  `total_hours` int(5) NOT NULL,
  `start_year` int(5) NOT NULL,
  `password` text NOT NULL,
  `is_deleted` int(11) NOT NULL,
  `is_admin` int(1) NOT NULL,
  `nickname` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `last_name`, `birthday`, `total_hours`, `start_year`, `password`, `is_deleted`, `is_admin`, `nickname`) VALUES
(1, 'test', 'test', '2018-06-06', 0, 2012, 'test', 0, 0, ''),
(2, 'tset2', 'test2', '2018-06-20', 0, 2015, 'pass', 0, 0, 'tset.test'),
(3, 'Blagoje', 'Stankovic', '0000-00-00', 4, 2012, '123123123', 0, 0, 'bstankovic95'),
(4, 'Nemanja', 'Aleksandrovic', '2018-06-13', 0, 2007, '123', 0, 0, 'n.a'),
(5, 'Dusan', 'Milinkovic', '2018-01-15', 0, 2009, '123', 0, 0, 'd.m');

-- --------------------------------------------------------

--
-- Table structure for table `user_event_xref`
--

CREATE TABLE `user_event_xref` (
  `id` int(11) NOT NULL,
  `hours` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  `is_deleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_event_xref`
--

INSERT INTO `user_event_xref` (`id`, `hours`, `user_id`, `event_id`, `is_deleted`) VALUES
(1, 2, 3, 1, 0),
(2, 2, 5, 2, 0),
(3, 2, 4, 1, 0),
(4, 5, 4, 2, 0),
(6, 2, 1, 1, 1),
(7, 2, 1, 1, 1);

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
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_event_xref`
--
ALTER TABLE `user_event_xref`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
