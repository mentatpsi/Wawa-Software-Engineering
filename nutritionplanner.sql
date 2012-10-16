-- phpMyAdmin SQL Dump
-- version 2.11.11.3
-- http://www.phpmyadmin.net
--
-- Host: 50.63.244.74
-- Generation Time: Oct 05, 2012 at 09:46 AM
-- Server version: 5.0.92
-- PHP Version: 5.1.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nutritionplanner`
--

-- --------------------------------------------------------

--
-- Table structure for table `Hoagies`
--

CREATE TABLE `Hoagies` (
  `Name` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Ingredient` varchar(255) NOT NULL,
  `ImageUrl` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Hoagies`
--


-- --------------------------------------------------------

--
-- Table structure for table `Ingredients`
--

CREATE TABLE `Ingredients` (
  `Name` varchar(255) NOT NULL,
  `Nutrition` varchar(1024) NOT NULL,
  `ServingSize` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Ingredients`
--


-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Role` set('Guest','Admin','Manger') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

