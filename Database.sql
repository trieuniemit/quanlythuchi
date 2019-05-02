-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2019 at 12:53 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlytaichinh`
--

-- --------------------------------------------------------

--
-- Table structure for table `debts`
--

CREATE TABLE `debts` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `note` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `debts`
--

INSERT INTO `debts` (`id`, `user_id`, `title`, `note`, `amount`, `datetime`, `status`) VALUES
(7, 1, 'Nợ Khanh', '', 290000, '2019-03-09 00:00:00', 0),
(8, 1, 'Nợ Hùng', '', 500000, '2019-07-16 00:00:00', 0),
(10, 1, 'Vay Trường', '', 200008, '2019-04-15 00:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `incomes`
--

CREATE TABLE `incomes` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `note` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `incomes`
--

INSERT INTO `incomes` (`id`, `user_id`, `title`, `note`, `amount`, `datetime`) VALUES
(4, 1, 'Lương tháng 6', '', 11200000, '2019-05-25 11:35:36');

-- --------------------------------------------------------

--
-- Table structure for table `loans`
--

CREATE TABLE `loans` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` tinytext COLLATE utf8_unicode_ci NOT NULL,
  `note` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `loan_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `recover_at` datetime NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `content` longtext COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `spends`
--

CREATE TABLE `spends` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `note` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(1) NOT NULL DEFAULT '1',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`, `created_at`) VALUES
(1, 'trieuniemit', 'e10adc3949ba59abbe56e057f20f883e', 1, '2019-04-05 19:57:51'),
(3, 'huyhy', 'e10adc3949ba59abbe56e057f20f883e', 0, '2019-05-02 13:23:49');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `debts`
--
ALTER TABLE `debts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`) USING BTREE;

--
-- Indexes for table `incomes`
--
ALTER TABLE `incomes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`) USING BTREE;

--
-- Indexes for table `loans`
--
ALTER TABLE `loans`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Indexes for table `spends`
--
ALTER TABLE `spends`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `debts`
--
ALTER TABLE `debts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `incomes`
--
ALTER TABLE `incomes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `loans`
--
ALTER TABLE `loans`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `spends`
--
ALTER TABLE `spends`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `debts`
--
ALTER TABLE `debts`
  ADD CONSTRAINT `debts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `incomes`
--
ALTER TABLE `incomes`
  ADD CONSTRAINT `incomes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `loans`
--
ALTER TABLE `loans`
  ADD CONSTRAINT `loans_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `notes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `spends`
--
ALTER TABLE `spends`
  ADD CONSTRAINT `spends_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
