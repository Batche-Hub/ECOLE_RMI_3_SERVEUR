CREATE DATABASE  IF NOT EXISTS `doranco_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `doranco_db`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: doranco_db
-- ------------------------------------------------------
-- Server version	5.6.48-log

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
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adresse` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `numero` int(3) DEFAULT NULL,
  `ville` varchar(20) NOT NULL,
  `codePostal` int(5) DEFAULT NULL,
  `etudiant_id` int(5) DEFAULT NULL,
  `enseignant_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `etudiant_id_idx` (`etudiant_id`),
  KEY `enseignant_id_idx` (`enseignant_id`),
  CONSTRAINT `enseignant_id` FOREIGN KEY (`enseignant_id`) REFERENCES `enseignant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `etudiant_id` FOREIGN KEY (`etudiant_id`) REFERENCES `etudiant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cours` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `titre` varchar(20) NOT NULL,
  `duree` int(2) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours`
--

LOCK TABLES `cours` WRITE;
/*!40000 ALTER TABLE `cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enseignant` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `age` int(2) DEFAULT NULL,
  `telephone` varchar(17) DEFAULT 'Non renseigné',
  `email` varchar(30) DEFAULT 'Non renseigné',
  `poste` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enseignant`
--

LOCK TABLES `enseignant` WRITE;
/*!40000 ALTER TABLE `enseignant` DISABLE KEYS */;
/*!40000 ALTER TABLE `enseignant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etudiant` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `age` int(2) DEFAULT NULL,
  `telephone` varchar(17) DEFAULT 'Non renseigné',
  `email` varchar(30) DEFAULT 'Non renseigné',
  `specialite` varchar(20) NOT NULL,
  `section` varchar(20) DEFAULT 'Non renseignée',
  `groupe` varchar(5) DEFAULT 'NR',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiant`
--

LOCK TABLES `etudiant` WRITE;
/*!40000 ALTER TABLE `etudiant` DISABLE KEYS */;
INSERT INTO `etudiant` VALUES (2,'Cherif','BADAD',NULL,'Non renseigné','Non renseigné','Science','Non renseignée','NR'),(3,'John','Michel',NULL,'Non renseigné','Non renseigné','Science','3D','NR'),(4,'Cherif','BADAD',NULL,'Non renseigné','Non renseigné','Science','Non renseignée','NR'),(7,'ALBERT','Paul',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(9,'ALBERT','Paul',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(11,'ALBERT','Paul',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(13,'ALBERT','Paul',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(15,'ALBERT','Paul',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(16,'ALBERT','Paul',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(18,'Zinédine','Zidane',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(19,'Zinédine','Zidane',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(20,'Zinédine','Zidane',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR'),(21,'Zinédine','Zidane',NULL,'Non renseigné','Non renseigné','Histoire','Non renseignée','NR');
/*!40000 ALTER TABLE `etudiant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suivi_cours`
--

DROP TABLE IF EXISTS `suivi_cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suivi_cours` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `cours_suivi_id` int(5) NOT NULL,
  `etudiant_suivi_id` int(5) DEFAULT NULL,
  `enseignant_suivi_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `cours_suivi_id_idx` (`cours_suivi_id`),
  KEY `etudiant_suivi_id_idx` (`etudiant_suivi_id`),
  KEY `enseignant_suivi_id_idx` (`enseignant_suivi_id`),
  CONSTRAINT `cours_suivi_id` FOREIGN KEY (`cours_suivi_id`) REFERENCES `cours` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `enseignant_suivi_id` FOREIGN KEY (`enseignant_suivi_id`) REFERENCES `enseignant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `etudiant_suivi_id` FOREIGN KEY (`etudiant_suivi_id`) REFERENCES `etudiant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suivi_cours`
--

LOCK TABLES `suivi_cours` WRITE;
/*!40000 ALTER TABLE `suivi_cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `suivi_cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'doranco_db'
--

--
-- Dumping routines for database 'doranco_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-11 16:18:17
