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
  `id` int(11) NOT NULL,
  `application_date` date DEFAULT NULL,
  `location_preference` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `years_of_experience` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `user_user_id` bigint(20) DEFAULT NULL,
  `application_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKls6sryk64ga8o5t4bym8qu3vm` (`job_id`),
  KEY `FK8kcfa12qn4soj6ygtveduvvb2` (`user_user_id`),
  CONSTRAINT `FK8kcfa12qn4soj6ygtveduvvb2` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKls6sryk64ga8o5t4bym8qu3vm` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
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
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'Tech Corp','Develop and maintain software','New York','Software Developer'),(2,'Tech Corp','Develop and maintain software','New York','Software Developer'),(3,'Tech Corp','Develop and maintain software','New York','Software Developer'),(4,'Tech Corp','Develop and maintain software','New York','Software Developer'),(5,'Tech Corp','Develop and maintain software','New York','Software Developer'),(6,'Tech Corp','Develop and maintain software','New York','Software Developer'),(7,'Tech Corp','Develop and maintain software','New York','Software Developer'),(8,'Tech Corp','Develop and maintain software','New York','Software Developer'),(9,'Tech Corp','Develop and maintain software','New York','Software Developer'),(10,'Tech Corp','Develop and maintain software','New York','Software Developer'),(11,'Tech Corp','Develop and maintain software','New York','Software Developer'),(12,'Tech Corp','Develop and maintain software','New York','Software Developer'),(13,'Tech Corp','Develop and maintain software','New York','Software Developer'),(14,'Tech Corp','Develop and maintain software','New York','Software Developer'),(15,'Tech Corp','Develop and maintain software','New York','Software Developer'),(16,'Tech Corp','Develop and maintain software','New York','Software Developer'),(17,'Tech Corp','Develop and maintain software','New York','Software Developer'),(18,'Tech Corp','Develop and maintain software','New York','Software Developer'),(19,'Tech Corp','Develop and maintain software','New York','Software Developer'),(20,'Tech Corp','Develop and maintain software','New York','Software Developer'),(21,'Tech Corp','Develop and maintain software','New York','Software Developer'),(22,'Tech Corp','Develop and maintain software','New York','Software Developer'),(23,'Tech Corp','Develop and maintain software','New York','Software Developer'),(24,'Tech Corp','Develop and maintain software','New York','Software Developer'),(25,'Tech Corp','Develop and maintain software','New York','Software Developer'),(26,'Tech Corp','Develop and maintain software','New York','Software Developer'),(27,'Tech Corp','Develop and maintain software','New York','Software Developer'),(28,'Tech Corp','Develop and maintain software','New York','Software Developer'),(29,'Tech Corp','Develop and maintain software','New York','Software Developer'),(30,'Tech Corp','Develop and maintain software','New York','Software Developer'),(31,'Tech Corp','Develop and maintain software','New York','Software Developer'),(32,'Tech Corp','Develop and maintain software','New York','Software Developer'),(33,'Tech Corp','Develop and maintain software','New York','Software Developer'),(34,'Tech Corp','Develop and maintain software','New York','Software Developer'),(35,'Tech Corp','Develop and maintain software','New York','Software Developer'),(36,'Tech Corp','Develop and maintain software','New York','Software Developer'),(37,'Tech Corp','Develop and maintain software','New York','Software Developer'),(38,'Tech Corp','Develop and maintain software','New York','Software Developer'),(39,'Tech Corp','Develop and maintain software','New York','Software Developer'),(40,'Tech Corp','Develop and maintain software','New York','Software Developer'),(41,'Tech Corp','Develop and maintain software','New York','Software Developer'),(42,'Tech Corp','Develop and maintain software','New York','Software Developer'),(43,'Tech Corp','Develop and maintain software','New York','Software Developer'),(44,'Tech Corp','Develop and maintain software','New York','Software Developer'),(45,'Tech Corp','Develop and maintain software','New York','Software Developer'),(46,'Tech Corp','Develop and maintain software','New York','Software Developer'),(47,'Tech Corp','Develop and maintain software','New York','Software Developer'),(48,'Tech Corp','Develop and maintain software','New York','Software Developer'),(49,'Tech Corp','Develop and maintain software','New York','Software Developer'),(50,'Tech Corp','Develop and maintain software','New York','Software Developer'),(51,'Tech Corp','Develop and maintain software','New York','Software Developer'),(52,'Tech Corp','Develop and maintain software','New York','Software Developer'),(53,'Tech Corp','Develop and maintain software','New York','Software Developer'),(54,'Tech Corp','Develop and maintain software','New York','Software Developer'),(55,'Tech Corp','Develop and maintain software','New York','Software Developer'),(56,'Tech Corp','Develop and maintain software','New York','Software Developer'),(57,'Tech Corp','Develop and maintain software','New York','Software Developer'),(58,'Tech Corp','Develop and maintain software','New York','Software Developer'),(59,'Tech Corp','Develop and maintain software','New York','Software Developer'),(60,'Tech Corp','Develop and maintain software','New York','Software Developer'),(61,'Tech Corp','Develop and maintain software','New York','Software Developer'),(62,'Tech Corp','Develop and maintain software','New York','Software Developer'),(63,'Tech Corp','Develop and maintain software','New York','Software Developer'),(64,'Tech Corp','Develop and maintain software','New York','Software Developer'),(65,'Tech Corp','Develop and maintain software','New York','Software Developer'),(66,'Tech Corp','Develop and maintain software','New York','Software Developer'),(67,'Tech Corp','Develop and maintain software','New York','Software Developer'),(68,'Tech Corp','Develop and maintain software','New York','Software Developer'),(69,'Tech Corp','Develop and maintain software','New York','Software Developer'),(70,'Tech Corp','Develop and maintain software','New York','Software Developer'),(71,'Tech Corp','Develop and maintain software','New York','Software Developer'),(72,'Tech Corp','Develop and maintain software','New York','Software Developer'),(73,'Tech Corp','Develop and maintain software','New York','Software Developer'),(74,'Tech Corp','Develop and maintain software','New York','Software Developer'),(75,'Tech Corp','Develop and maintain software','New York','Software Developer'),(76,'Tech Corp','Develop and maintain software','New York','Software Developer'),(77,'Tech Corp','Develop and maintain software','New York','Software Developer');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$7CgjStvaSXsaY2wQIi5nYOPnWrwzfBVgRuYSlniWA3/vi1mSmVwc2','ADMIN','rahul123');
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

-- Dump completed on 2025-07-22 17:04:57
