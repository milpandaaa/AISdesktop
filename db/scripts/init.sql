-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: pp
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

CREATE DATABASE pp CHARACTER SET utf8;

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id_article` int NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'рыпова');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `id_card` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) DEFAULT NULL,
  `first_name` int DEFAULT NULL,
  `patronymic` int DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `country` int DEFAULT NULL,
  `region` int DEFAULT NULL,
  `outdoors` varchar(200) DEFAULT NULL,
  `date_of_commission` datetime DEFAULT NULL,
  `place_of_commission` varchar(200) DEFAULT NULL,
  `date_of_initiation` date DEFAULT NULL,
  `office_of_initiation` int DEFAULT NULL,
  `name_of_initiation` varchar(45) DEFAULT NULL,
  `date_of_preparing_report` date DEFAULT NULL,
  `office_of_preparing_report` int DEFAULT NULL,
  `name_of_preparing_report` varchar(45) DEFAULT NULL,
  `id_article` int DEFAULT NULL,
  `date_of_decision` date DEFAULT NULL,
  `decision` varchar(45) DEFAULT NULL,
  `office_of_decision` int DEFAULT NULL,
  `name_of_decision` varchar(45) DEFAULT NULL,
  `punishment` int DEFAULT NULL,
  `sum` int DEFAULT NULL,
  `date_of_entry_into_force` date DEFAULT NULL,
  `date_sentence_enforcement` date DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`id_card`),
  KEY `gender_idx` (`gender`),
  KEY `nationality_idx` (`country`),
  KEY `office_idx` (`office_of_initiation`),
  KEY `id_article_idx` (`id_article`),
  KEY `office_of_decision_idx` (`office_of_decision`),
  KEY `punishment_idx` (`punishment`),
  KEY `first_name_idx` (`first_name`),
  KEY `patronymic_idx` (`patronymic`),
  CONSTRAINT `country_of_birth` FOREIGN KEY (`country`) REFERENCES `countries` (`id_country`),
  CONSTRAINT `first_name` FOREIGN KEY (`first_name`) REFERENCES `names` (`id_name`),
  CONSTRAINT `gender` FOREIGN KEY (`gender`) REFERENCES `gender` (`id_gender`),
  CONSTRAINT `id_article` FOREIGN KEY (`id_article`) REFERENCES `article` (`id_article`),
  CONSTRAINT `office` FOREIGN KEY (`office_of_initiation`) REFERENCES `offices` (`id_office`),
  CONSTRAINT `office_of_decision` FOREIGN KEY (`office_of_decision`) REFERENCES `offices` (`id_office`),
  CONSTRAINT `office_of_initiation` FOREIGN KEY (`office_of_initiation`) REFERENCES `offices` (`id_office`),
  CONSTRAINT `patronymic` FOREIGN KEY (`patronymic`) REFERENCES `patronymics` (`id_patronymic`),
  CONSTRAINT `punishment` FOREIGN KEY (`punishment`) REFERENCES `punishment` (`id_punishment`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,'Попова',1,1,'1995-01-01',NULL,NULL,NULL,NULL,'2020-10-10 00:00:00','Москва',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Васильева',1,1,'1999-10-10',NULL,NULL,NULL,NULL,'2020-10-10 00:00:00','Москва',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Пименова',1,1,'1993-10-09',NULL,NULL,NULL,'','2020-10-10 00:00:00','Москва',NULL,NULL,'',NULL,NULL,'',NULL,NULL,'',NULL,'',NULL,NULL,NULL,NULL,NULL),(124,'',NULL,NULL,NULL,2,2,NULL,'ljgfdfg','2020-10-10 00:00:00','Москва',NULL,NULL,'',NULL,NULL,'',NULL,NULL,'',NULL,'',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `id_country` int NOT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'Российская Федерация'),(2,'Румыния'),(3,'Республика Эль-Сальвадор');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id_gender` int NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_gender`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'мужской'),(2,'женский'),(3,'иное');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `names`
--

DROP TABLE IF EXISTS `names`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `names` (
  `id_name` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `names`
--

LOCK TABLES `names` WRITE;
/*!40000 ALTER TABLE `names` DISABLE KEYS */;
INSERT INTO `names` VALUES (1,'Анна'),(2,'Петр');
/*!40000 ALTER TABLE `names` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offices`
--

DROP TABLE IF EXISTS `offices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offices` (
  `id_office` int NOT NULL,
  `department` varchar(45) DEFAULT NULL,
  `name_office` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_office`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offices`
--

LOCK TABLES `offices` WRITE;
/*!40000 ALTER TABLE `offices` DISABLE KEYS */;
INSERT INTO `offices` VALUES (1,'МВД','МВД Невского р-на'),(2,'МВД','МВД Фрунзенского р-на');
/*!40000 ALTER TABLE `offices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patronymics`
--

DROP TABLE IF EXISTS `patronymics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patronymics` (
  `id_patronymic` int NOT NULL AUTO_INCREMENT,
  `patronymic` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_patronymic`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patronymics`
--

LOCK TABLES `patronymics` WRITE;
/*!40000 ALTER TABLE `patronymics` DISABLE KEYS */;
INSERT INTO `patronymics` VALUES (1,'Юрьевна');
/*!40000 ALTER TABLE `patronymics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punishment`
--

DROP TABLE IF EXISTS `punishment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `punishment` (
  `id_punishment` int NOT NULL,
  `name_punishment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_punishment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punishment`
--

LOCK TABLES `punishment` WRITE;
/*!40000 ALTER TABLE `punishment` DISABLE KEYS */;
INSERT INTO `punishment` VALUES (1,'штраф');
/*!40000 ALTER TABLE `punishment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referral`
--

DROP TABLE IF EXISTS `referral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referral` (
  `id_referral` int NOT NULL,
  `referral_card` int NOT NULL,
  `date_departure` date DEFAULT NULL,
  `office_departure` int DEFAULT NULL,
  `date_arrival` date DEFAULT NULL,
  `office_arrival` int DEFAULT NULL,
  PRIMARY KEY (`id_referral`),
  KEY `office_departure_idx` (`office_departure`),
  KEY `office_arrival_idx` (`office_arrival`),
  KEY `id_card_idx` (`referral_card`),
  CONSTRAINT `id_card` FOREIGN KEY (`referral_card`) REFERENCES `card` (`id_card`),
  CONSTRAINT `office_arrival` FOREIGN KEY (`office_arrival`) REFERENCES `offices` (`id_office`),
  CONSTRAINT `office_departure` FOREIGN KEY (`office_departure`) REFERENCES `offices` (`id_office`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referral`
--

LOCK TABLES `referral` WRITE;
/*!40000 ALTER TABLE `referral` DISABLE KEYS */;
/*!40000 ALTER TABLE `referral` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-15 17:21:22
