-- phpMyAdmin SQL Dump
-- version 2.11.11.3
-- http://www.phpmyadmin.net
--
-- Host: 50.63.244.74
-- Generation Time: Nov 12, 2012 at 10:20 AM
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
-- Table structure for table `Ingredients`
--

CREATE TABLE `Ingredients` (
  `NameID` varchar(255) NOT NULL,
  `ServingSize` int(11) NOT NULL,
  `Category` varchar(255) NOT NULL,
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

INSERT INTO `Ingredients` VALUES('Salami', 0, 'Deli Meats', 25, 3, 1, '0', 110, 1, 40, 0);
INSERT INTO `Ingredients` VALUES('Provolone', 1, 'Cheese', 50, 4, 3, '0', 100, 3, 0, 0);

-- --------------------------------------------------------

--
-- Stand-in structure for view `Italian`
--
CREATE TABLE `Italian` (
`Ingredient_id` varchar(255)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `ItalianNutrition`
--
CREATE TABLE `ItalianNutrition` (
`Ingredient_id` varchar(255)
,`NameID` varchar(255)
,`ServingSize` int(11)
,`Category` varchar(255)
,`Calories` int(11)
,`TotalFat` int(11)
,`SaturatedFat` int(11)
,`Carbohydrates` varchar(11)
,`Sodium` int(11)
,`Protein` int(11)
,`Fiber` int(11)
,`TransFat` int(11)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `Nutrition`
--
CREATE TABLE `Nutrition` (
`Sandwich_id` varchar(255)
,`NameID` varchar(255)
,`ServingSize` int(11)
,`Category` varchar(255)
,`Calories` int(11)
,`TotalFat` int(11)
,`SaturatedFat` int(11)
,`Carbohydrates` varchar(11)
,`Sodium` int(11)
,`Protein` int(11)
,`Fiber` int(11)
,`TransFat` int(11)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `Nutrition1`
--
CREATE TABLE `Nutrition1` (
`Sandwich_id` varchar(255)
,`NameID` varchar(255)
,`ServingSize` int(11)
,`Category` varchar(255)
,`Calories` int(11)
,`TotalFat` int(11)
,`SaturatedFat` int(11)
,`Carbohydrates` varchar(11)
,`Sodium` int(11)
,`Protein` int(11)
,`Fiber` int(11)
,`TransFat` int(11)
);
-- --------------------------------------------------------

--
-- Table structure for table `Sandwiches`
--

CREATE TABLE `Sandwiches` (
  `Name` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `ImageUrl` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Sandwiches`
--

INSERT INTO `Sandwiches` VALUES('Italian', '', '');

-- --------------------------------------------------------

--
-- Stand-in structure for view `SandwichNutrition`
--
CREATE TABLE `SandwichNutrition` (
`Sandwich_id` varchar(255)
,`ServingSize` int(11)
,`SUM(  ``Calories`` )` decimal(32,0)
,`SUM(  ``TotalFat`` )` decimal(32,0)
,`SUM(  ``SaturatedFat`` )` decimal(32,0)
,`SUM(  ``Carbohydrates`` )` double
,`SUM(  ``Sodium`` )` decimal(32,0)
,`SUM(  ``Protein`` )` decimal(32,0)
,`SUM(  ``Fiber`` )` decimal(32,0)
,`SUM(  ``TransFat`` )` decimal(32,0)
);
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

INSERT INTO `Sandwich_Ingredient` VALUES('Italian', 'Salami', 1);
INSERT INTO `Sandwich_Ingredient` VALUES('Italian', 'Provolone', 0);

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


-- --------------------------------------------------------

--
-- Structure for view `Italian`
--
DROP TABLE IF EXISTS `Italian`;

CREATE ALGORITHM=UNDEFINED DEFINER=`nutritionplanner`@`%` SQL SECURITY DEFINER VIEW `nutritionplanner`.`Italian` AS select `nutritionplanner`.`Sandwich_Ingredient`.`Ingredient_id` AS `Ingredient_id` from `nutritionplanner`.`Sandwich_Ingredient` where (`nutritionplanner`.`Sandwich_Ingredient`.`Sandwich_id` = _utf8'Italian');

-- --------------------------------------------------------

--
-- Structure for view `ItalianNutrition`
--
DROP TABLE IF EXISTS `ItalianNutrition`;

CREATE ALGORITHM=UNDEFINED DEFINER=`nutritionplanner`@`%` SQL SECURITY DEFINER VIEW `nutritionplanner`.`ItalianNutrition` AS select `Italian`.`Ingredient_id` AS `Ingredient_id`,`nutritionplanner`.`Ingredients`.`NameID` AS `NameID`,`nutritionplanner`.`Ingredients`.`ServingSize` AS `ServingSize`,`nutritionplanner`.`Ingredients`.`Category` AS `Category`,`nutritionplanner`.`Ingredients`.`Calories` AS `Calories`,`nutritionplanner`.`Ingredients`.`TotalFat` AS `TotalFat`,`nutritionplanner`.`Ingredients`.`SaturatedFat` AS `SaturatedFat`,`nutritionplanner`.`Ingredients`.`Carbohydrates` AS `Carbohydrates`,`nutritionplanner`.`Ingredients`.`Sodium` AS `Sodium`,`nutritionplanner`.`Ingredients`.`Protein` AS `Protein`,`nutritionplanner`.`Ingredients`.`Fiber` AS `Fiber`,`nutritionplanner`.`Ingredients`.`TransFat` AS `TransFat` from (`nutritionplanner`.`Italian` join `nutritionplanner`.`Ingredients` on((`Italian`.`Ingredient_id` = `nutritionplanner`.`Ingredients`.`NameID`))) order by `Italian`.`Ingredient_id`;

-- --------------------------------------------------------

--
-- Structure for view `Nutrition`
--
DROP TABLE IF EXISTS `Nutrition`;

CREATE ALGORITHM=UNDEFINED DEFINER=`nutritionplanner`@`%` SQL SECURITY DEFINER VIEW `nutritionplanner`.`Nutrition` AS select `SI`.`Sandwich_id` AS `Sandwich_id`,`Ingr`.`NameID` AS `NameID`,`Ingr`.`ServingSize` AS `ServingSize`,`Ingr`.`Category` AS `Category`,`Ingr`.`Calories` AS `Calories`,`Ingr`.`TotalFat` AS `TotalFat`,`Ingr`.`SaturatedFat` AS `SaturatedFat`,`Ingr`.`Carbohydrates` AS `Carbohydrates`,`Ingr`.`Sodium` AS `Sodium`,`Ingr`.`Protein` AS `Protein`,`Ingr`.`Fiber` AS `Fiber`,`Ingr`.`TransFat` AS `TransFat` from ((`nutritionplanner`.`Sandwich_Ingredient` `SI` join `nutritionplanner`.`Ingredients` `Ingr`) join `nutritionplanner`.`Ingredients` on((`SI`.`Ingredient_id` = `Ingr`.`NameID`))) order by `SI`.`Sandwich_id`;

-- --------------------------------------------------------

--
-- Structure for view `Nutrition1`
--
DROP TABLE IF EXISTS `Nutrition1`;

CREATE ALGORITHM=UNDEFINED DEFINER=`nutritionplanner`@`%` SQL SECURITY DEFINER VIEW `nutritionplanner`.`Nutrition1` AS select `Nutrition`.`Sandwich_id` AS `Sandwich_id`,`Nutrition`.`NameID` AS `NameID`,`Nutrition`.`ServingSize` AS `ServingSize`,`Nutrition`.`Category` AS `Category`,`Nutrition`.`Calories` AS `Calories`,`Nutrition`.`TotalFat` AS `TotalFat`,`Nutrition`.`SaturatedFat` AS `SaturatedFat`,`Nutrition`.`Carbohydrates` AS `Carbohydrates`,`Nutrition`.`Sodium` AS `Sodium`,`Nutrition`.`Protein` AS `Protein`,`Nutrition`.`Fiber` AS `Fiber`,`Nutrition`.`TransFat` AS `TransFat` from `nutritionplanner`.`Nutrition` group by `Nutrition`.`Sandwich_id`,`Nutrition`.`NameID`;

-- --------------------------------------------------------

--
-- Structure for view `SandwichNutrition`
--
DROP TABLE IF EXISTS `SandwichNutrition`;

CREATE ALGORITHM=UNDEFINED DEFINER=`nutritionplanner`@`%` SQL SECURITY DEFINER VIEW `nutritionplanner`.`SandwichNutrition` AS select `Nutrition1`.`Sandwich_id` AS `Sandwich_id`,`Nutrition1`.`ServingSize` AS `ServingSize`,sum(`Nutrition1`.`Calories`) AS `SUM(  ``Calories`` )`,sum(`Nutrition1`.`TotalFat`) AS `SUM(  ``TotalFat`` )`,sum(`Nutrition1`.`SaturatedFat`) AS `SUM(  ``SaturatedFat`` )`,sum(`Nutrition1`.`Carbohydrates`) AS `SUM(  ``Carbohydrates`` )`,sum(`Nutrition1`.`Sodium`) AS `SUM(  ``Sodium`` )`,sum(`Nutrition1`.`Protein`) AS `SUM(  ``Protein`` )`,sum(`Nutrition1`.`Fiber`) AS `SUM(  ``Fiber`` )`,sum(`Nutrition1`.`TransFat`) AS `SUM(  ``TransFat`` )` from `nutritionplanner`.`Nutrition1` group by `Nutrition1`.`Sandwich_id`;
