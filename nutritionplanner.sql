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

CREATE TABLE `Sandwiches` (
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
-- Table structure for table `Sandwich_Ingredient`
--

CREATE TABLE `Sandwich_Ingredient` (
  `Sandwich_id` varchar(255) NOT NULL,
  `Ingredient_id` varchar(255) NOT NULL,
  `CountNum` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Sandwich_Ingredient`
--


-- --------------------------------------------------------

--
-- Table structure for table `Ingredients`
--

CREATE TABLE `Ingredients` (
  `NameID` varchar(255) NOT NULL,
  `ServingSize` int(11) NOT NULL,
  `Calories` int(11) NOT NULL,
  `TotalFat` int(11) NOT NULL,
  `SaturatedFat` int(11) NOT NULL,
  `Carbohydrates` varchar(11) NOT NULL,
  `Sodium` int(11) NOT NULL,
  `Protein` int(11) NOT NULL,
  `Fiber` int(11) NOT NULL,
  `TransFat` int(11) NOT NULL
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
  `Role` set('Guest','Admin','Manager') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

