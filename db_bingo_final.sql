CREATE DATABASE  IF NOT EXISTS `bingo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bingo`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bingo
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `current_game`
--

DROP TABLE IF EXISTS `current_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `current_game` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_game` int NOT NULL,
  `letter` varchar(45) NOT NULL,
  `number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_game`
--

LOCK TABLES `current_game` WRITE;
/*!40000 ALTER TABLE `current_game` DISABLE KEYS */;
INSERT INTO `current_game` VALUES (1,1,'O',74),(2,1,'I',16),(3,1,'G',46),(4,1,'O',68),(5,1,'I',21),(6,1,'O',64),(7,1,'I',20),(8,1,'O',71),(9,1,'O',75),(10,1,'O',70),(11,1,'N',34),(12,1,'I',27),(13,1,'B',15),(14,1,'B',6),(15,1,'N',39),(16,1,'O',61),(17,1,'N',43),(18,1,'O',73),(19,1,'B',13),(20,1,'B',11),(21,1,'I',25),(22,1,'N',42),(23,1,'B',5),(24,1,'G',56),(25,1,'G',59),(26,1,'G',58),(27,1,'N',45),(28,1,'G',47),(29,1,'G',50),(30,1,'G',51),(31,1,'N',36),(32,1,'B',12),(33,1,'N',35),(34,1,'N',37),(35,1,'O',67),(36,1,'B',14),(37,1,'O',63),(38,1,'I',22),(39,1,'N',32),(40,1,'I',26),(41,1,'O',66),(42,1,'G',54),(43,1,'G',55),(44,1,'O',72),(45,1,'N',44),(46,1,'G',48),(47,1,'I',29),(48,1,'O',69),(49,1,'B',8),(50,1,'B',10),(51,1,'B',3),(52,1,'G',57),(53,1,'I',17),(54,1,'I',24),(55,1,'I',23),(56,1,'B',9),(57,1,'N',31),(58,1,'I',28),(59,1,'B',1),(60,1,'O',62),(61,1,'N',33),(62,1,'B',7),(63,1,'G',60),(64,1,'N',38),(65,1,'G',53),(66,1,'N',40);
/*!40000 ALTER TABLE `current_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `current_user_ballot`
--

DROP TABLE IF EXISTS `current_user_ballot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `current_user_ballot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `id_game` int NOT NULL,
  `letter` varchar(45) NOT NULL,
  `number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_user_ballot`
--

LOCK TABLES `current_user_ballot` WRITE;
/*!40000 ALTER TABLE `current_user_ballot` DISABLE KEYS */;
INSERT INTO `current_user_ballot` VALUES (1,'62e76e97d8d69b057004e257',1,'O',74),(2,'62e76e97d8d69b057004e257',1,'G',46),(3,'62e76e89d8d69b057004e254',1,'I',21),(4,'62e76e97d8d69b057004e257',1,'O',70),(5,'62e76e89d8d69b057004e254',1,'B',5),(6,'62e76e89d8d69b057004e254',1,'B',6),(7,'62e76e89d8d69b057004e254',1,'B',13),(8,'62e76e89d8d69b057004e254',1,'G',59),(9,'62e76e89d8d69b057004e254',1,'O',64),(10,'62e76e89d8d69b057004e254',1,'I',25),(11,'62e76e89d8d69b057004e254',1,'G',47),(12,'62e76e89d8d69b057004e254',1,'O',71),(13,'62e76e97d8d69b057004e257',1,'B',5),(14,'62e76e97d8d69b057004e257',1,'N',39),(15,'62e76e97d8d69b057004e257',1,'O',61),(16,'62e76e97d8d69b057004e257',1,'O',67),(17,'62e76e97d8d69b057004e257',1,'G',47),(18,'62e76e97d8d69b057004e257',1,'B',12),(19,'62e76e97d8d69b057004e257',1,'I',22),(20,'62e76e97d8d69b057004e257',1,'N',34),(21,'62e76e97d8d69b057004e257',1,'B',14),(22,'62e76e97d8d69b057004e257',1,'N',35),(23,'62e76e97d8d69b057004e257',1,'G',58),(24,'62e76e89d8d69b057004e254',1,'G',46),(25,'62e76e89d8d69b057004e254',1,'O',73),(26,'62e76e97d8d69b057004e257',1,'N',33),(27,'62e76e97d8d69b057004e257',1,'B',1),(28,'62e76e97d8d69b057004e257',1,'I',17),(29,'62e76e97d8d69b057004e257',1,'O',69),(30,'62e76e89d8d69b057004e254',1,'B',3),(31,'62e76e89d8d69b057004e254',1,'B',9),(32,'62e76e89d8d69b057004e254',1,'I',23);
/*!40000 ALTER TABLE `current_user_ballot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `idgame` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint DEFAULT '0',
  `idwinner` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idgame`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'2022-08-01 01:03:39',0,'nana='),(2,'2022-08-01 01:17:50',0,'asdasdasd1235123='),(3,'2022-08-01 01:21:15',0,'nataliaAcosta='),(4,'2022-08-01 04:32:18',0,'natalia='),(5,'2022-08-01 05:01:44',0,'luisqwe='),(6,'2022-08-01 06:05:33',0,'luis='),(7,'2022-08-01 06:11:21',0,'pedro=');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `usergameid` varchar(45) DEFAULT NULL,
  `winner` tinyint DEFAULT '0',
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'62e76e89d8d69b057004e254',0),(2,'62e76e97d8d69b057004e257',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `b` varchar(45) NOT NULL,
  `i` varchar(45) NOT NULL,
  `n` varchar(45) NOT NULL,
  `g` varchar(45) NOT NULL,
  `o` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'62e76e97d8d69b057004e257','1,8,12,5,14','17,19,22,25,30','33,35,40,34,39','47,60,58,46,49','74,67,70,61,69'),(2,'62e76e89d8d69b057004e254','5,6,3,9,13','21,25,17,29,23','38,37,31,44,41','59,51,56,46,47','65,64,73,71,72');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-01  1:58:16
