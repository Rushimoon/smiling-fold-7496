-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `bill_no` int NOT NULL AUTO_INCREMENT,
  `fixed_charge` int DEFAULT '250',
  `units_consumed` int DEFAULT NULL,
  `tax` int DEFAULT NULL,
  `tax_adjustment` int DEFAULT '0',
  `total` int DEFAULT NULL,
  `Status` varchar(10) DEFAULT 'pending',
  `Cid` int DEFAULT NULL,
  `month` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bill_no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,250,50,3,0,2500,'pending',1,NULL),(2,250,75,3,0,2500,'pending',2,NULL),(3,250,45,3,0,6500,'pending',4,NULL),(4,250,450,3,0,6400,'pending',3,NULL),(5,250,50,3,0,2500,'pending',2,NULL),(6,250,50,3,0,3000,'pending',3,NULL),(7,250,50,3,0,3000,'pending',3,'jan'),(8,250,50,3,0,2500,'pending',3,'feb'),(9,250,150,3,0,5600,'pending',3,'mar'),(10,250,150,3,0,5600,'pending',3,'mar'),(11,250,150,3,0,5600,'paid',3,'desc'),(12,250,150,3,0,5600,'disco',4,'desc');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `Cid` int NOT NULL AUTO_INCREMENT,
  `First_name` varchar(20) DEFAULT NULL,
  `Last_name` varchar(20) DEFAULT NULL,
  `User_name` varchar(20) DEFAULT NULL,
  `Mobile_Number` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `isDelete` int DEFAULT '0',
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'rushikesh','moon','rushi','987654321','rm@gmilk.com',1,'12345'),(2,'manoj','kumbahre','maonj','87654123','maonuhaok@hotmail',0,'12345'),(3,'prashant','kangane','parsha','879456321','prak@gmial.com',0,'54879132'),(4,'shrikant','kolhatksr','shrikant','98765423','shri!@gk.com',0,'123456'),(5,'jayant','sawarkar','jayu','9874121','jayu@gmial.com',0,'12345783'),(6,'rushi','moon','rushi','987654312','rm@gmil.com',0,'12345');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02 23:06:10
