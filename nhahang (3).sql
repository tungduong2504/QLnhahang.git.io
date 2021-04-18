-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3309
-- Generation Time: Jan 17, 2021 at 02:01 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nhahang`
--

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE IF NOT EXISTS `hoadon` (
  `idhoadon` int(11) NOT NULL AUTO_INCREMENT,
  `ngay` date NOT NULL,
  `loai` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tong` float NOT NULL,
  `idmon` int(11) DEFAULT NULL,
  PRIMARY KEY (`idhoadon`),
  KEY `fk_ma_hd` (`idmon`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`idhoadon`, `ngay`, `loai`, `tong`, `idmon`) VALUES
(6, '2021-01-16', 'Su dung ban', 104444, 2),
(5, '2021-01-16', 'Su dung ban', 134444, 2),
(4, '2021-01-16', 'Su dung ban', 400000, 3),
(3, '2021-01-16', 'Mang ve', 153333, 1),
(2, '2021-01-16', 'Mang ve', 208888, 1),
(1, '0001-01-01', 'Mang ve', 90000, 2),
(7, '2021-01-16', 'Su dung ban', 104444, 2),
(8, '2021-01-16', 'Su dung ban', 90000, 2),
(9, '2021-01-17', 'Mang ve', 1060000, 3),
(10, '2021-01-17', 'Su dung ban', 210000, 2),
(11, '2021-01-17', 'Su dung ban', 314444, 2);

-- --------------------------------------------------------

--
-- Table structure for table `qlmonan`
--

DROP TABLE IF EXISTS `qlmonan`;
CREATE TABLE IF NOT EXISTS `qlmonan` (
  `idMon` int(11) NOT NULL AUTO_INCREMENT,
  `tenMon` varchar(60) NOT NULL,
  `gia` float NOT NULL,
  PRIMARY KEY (`idMon`)
) ENGINE=MyISAM AUTO_INCREMENT=124 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qlmonan`
--

INSERT INTO `qlmonan` (`idMon`, `tenMon`, `gia`) VALUES
(2, 'Hai san', 30000),
(3, 'Thap cam3', 200000),
(1, 'Banh mi', 200000),
(4, 'Lau hai san', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `thongke`
--

DROP TABLE IF EXISTS `thongke`;
CREATE TABLE IF NOT EXISTS `thongke` (
  `idhoadon` int(11) NOT NULL,
  `tongtoanbo` float NOT NULL,
  KEY `fk_ma_tk` (`idhoadon`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
