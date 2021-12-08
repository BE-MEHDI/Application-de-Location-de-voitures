-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: rent_carcar
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `ID_client` int NOT NULL AUTO_INCREMENT,
  `Nom_client` varchar(20) NOT NULL,
  `Prenom_client` varchar(20) NOT NULL,
  `CIN_client` varchar(20) NOT NULL,
  `telephone_client` int NOT NULL,
  PRIMARY KEY (`ID_client`),
  UNIQUE KEY `CIN_client_UNIQUE` (`CIN_client`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Lakbir','yassine','EE111111',600000000),(2,'Bennis','Mehdi','EE222222',611111111),(3,'Essaoudi','Imad','EE333333',622222222),(4,'aymane','essaoudi','14efe5',620521155),(8,'ayoub','rhiti','afef159',620521155),(17,'Abouhadir','Ahmed','BE145784',0);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrat`
--

DROP TABLE IF EXISTS `contrat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrat` (
  `ID_contrat` int NOT NULL AUTO_INCREMENT,
  `Nom_client` varchar(30) NOT NULL,
  `prenom_client` varchar(30) NOT NULL,
  `CIN_client` varchar(10) NOT NULL,
  `datedebut_contrat` date NOT NULL,
  `datefin_contrat` date NOT NULL,
  `montant_contrat` int NOT NULL,
  PRIMARY KEY (`ID_contrat`),
  UNIQUE KEY `CIN_client_UNIQUE` (`CIN_client`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrat`
--

LOCK TABLES `contrat` WRITE;
/*!40000 ALTER TABLE `contrat` DISABLE KEYS */;
INSERT INTO `contrat` VALUES (2,'Bikiker','Aya','BE478512','2021-02-21','2021-03-21',10000),(3,'Abouhadir','Ahmed','BE145784','2020-03-04','2021-02-22',60000);
/*!40000 ALTER TABLE `contrat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `ID_reservation` int NOT NULL AUTO_INCREMENT,
  `Nom_client` char(20) NOT NULL,
  `Prenom_client` char(20) NOT NULL,
  `marque` char(20) NOT NULL,
  `matricule` char(20) NOT NULL,
  `duree` char(20) NOT NULL,
  `Prix` int NOT NULL,
  `datereservation` date NOT NULL,
  PRIMARY KEY (`ID_reservation`),
  UNIQUE KEY `matricule_UNIQUE` (`matricule`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,'Lakbir','yassine','Ford Focus','E1234','45',120,'1999-01-04'),(7,'Abourezzak','Aymane','Dacia Logan','14-F-15874','14',500,'2021-01-26');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicule` (
  `ID_vehicule` int NOT NULL AUTO_INCREMENT,
  `marque` varchar(20) NOT NULL,
  `matricule` varchar(20) NOT NULL,
  `modele` varchar(20) NOT NULL,
  `disponibilite` int NOT NULL,
  `tarif` int NOT NULL,
  PRIMARY KEY (`ID_vehicule`),
  UNIQUE KEY `matricule` (`matricule`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicule`
--

LOCK TABLES `vehicule` WRITE;
/*!40000 ALTER TABLE `vehicule` DISABLE KEYS */;
INSERT INTO `vehicule` VALUES (6,'Range Rover','19587-A-19','2019',0,150),(8,'Ford Focus','13-A-98745','2020',1,500),(9,'Mercedes Cl E','14-E-47854','2021',1,1500),(10,'Hyandai Tucson','06-D-14752','2018',1,400),(11,'Dacia Logan','14-F-15874','2020',0,500);
/*!40000 ALTER TABLE `vehicule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-26  4:39:35
