/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.5.29-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: appdb
-- ------------------------------------------------------
-- Server version	5.6.51

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `appdb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `appdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `appdb`;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `application_id` int(11) NOT NULL AUTO_INCREMENT,
  `application_date` date DEFAULT NULL,
  `location_preference` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `years_of_experience` int(11) NOT NULL,
  `jobid` int(11) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`application_id`),
  KEY `FK61f0ef4d99u1newn8cwx30j98` (`jobid`),
  KEY `FK3ga1nw5lk8in7w6tn5d00s9vm` (`userid`),
  CONSTRAINT `FK3ga1nw5lk8in7w6tn5d00s9vm` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK61f0ef4d99u1newn8cwx30j98` FOREIGN KEY (`jobid`) REFERENCES `job` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,NULL,'chennai','spring',NULL,1,NULL,NULL),(2,NULL,'hyd','spring boot',NULL,2,NULL,NULL),(3,NULL,'hyd','spring boot',NULL,3,NULL,NULL),(4,NULL,'hyd','spring boot',NULL,4,NULL,NULL),(5,NULL,'banglore','python',NULL,54,NULL,NULL),(6,NULL,'chennai','backend',NULL,12,NULL,NULL),(7,NULL,'banglore','backend',NULL,10,NULL,NULL);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_seq`
--

DROP TABLE IF EXISTS `application_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `application_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_seq`
--

LOCK TABLES `application_seq` WRITE;
/*!40000 ALTER TABLE `application_seq` DISABLE KEYS */;
INSERT INTO `application_seq` VALUES (1);
/*!40000 ALTER TABLE `application_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `experience_level` varchar(255) DEFAULT NULL,
  `job_type` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `posted_date` date DEFAULT NULL,
  `salary` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FKtdctvjuwshux1vuw4xk1u92yb` (`user_user_id`),
  CONSTRAINT `FKtdctvjuwshux1vuw4xk1u92yb` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (2,'LtiMindtree',NULL,'Spring Boot',NULL,NULL,'chennaii',NULL,0,'Java Dev',NULL),(4,'IamNeo',NULL,'Java Core Teacher',NULL,NULL,'Mumbai','2025-07-23',0,'Teacher',NULL);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$WMMhkZ5.rGfwwWMWXVZzVuHJSruCSIbvr4xtldgQvQIZ58DUFxqee','USER','abc1'),(2,'$2a$10$X1it.t0H5YhNJpe2gQJSUu9Wes1HNvsBA9fYb/UIN/NZR1jLu5ZL6','USER','abc2'),(3,'$2a$10$9iH3GBd7ic0JneZhGXpZweE05ObVwpnZlp/aDrLtS2fcoo7OOfKDm','USER','Bommi19'),(4,'$2a$10$k8.ncjUBGqXgkpw3ODxKsObTO6H9/3Rl.V2O5PiAEHaNT0RbBof02','ADMIN','anshu72'),(5,'$2a$10$8Do6zFD6yMYWzMmEJOyqreAlwS47R23XiasZOThumAabn5DW7brzm','ADMIN','User101');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (51);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-23 10:34:24
