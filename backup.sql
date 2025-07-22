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
  `jobid` int(11) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKls6sryk64ga8o5t4bym8qu3vm` (`job_id`),
  KEY `FK8kcfa12qn4soj6ygtveduvvb2` (`user_user_id`),
  KEY `FK61f0ef4d99u1newn8cwx30j98` (`jobid`),
  KEY `FK3ga1nw5lk8in7w6tn5d00s9vm` (`userid`),
  CONSTRAINT `FK3ga1nw5lk8in7w6tn5d00s9vm` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK61f0ef4d99u1newn8cwx30j98` FOREIGN KEY (`jobid`) REFERENCES `job` (`job_id`),
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
  `deadline` date DEFAULT NULL,
  `experience_level` varchar(255) DEFAULT NULL,
  `job_type` varchar(255) DEFAULT NULL,
  `posted_date` date DEFAULT NULL,
  `salary` double NOT NULL,
  `user_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FKtdctvjuwshux1vuw4xk1u92yb` (`user_user_id`),
  CONSTRAINT `FKtdctvjuwshux1vuw4xk1u92yb` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(2,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(3,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(4,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(5,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(6,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(7,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(8,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(9,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(10,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(11,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(12,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(13,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(14,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(15,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(16,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(17,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(18,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(19,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(20,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(21,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(22,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(23,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(24,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(25,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(26,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(27,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(28,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(29,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(30,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(31,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(32,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(33,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(34,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(35,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(36,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(37,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(38,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(39,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(40,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(41,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(42,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(43,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(44,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(45,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(46,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(47,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(48,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(49,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(50,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(51,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(52,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(53,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(54,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(55,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(56,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(57,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(58,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(59,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(60,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(61,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(62,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(63,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(64,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(65,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(66,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(67,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(68,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(69,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(70,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(71,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(72,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(73,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(74,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(75,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(76,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL),(77,'Tech Corp','Develop and maintain software','New York','Software Developer',NULL,NULL,NULL,NULL,0,NULL);
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

-- Dump completed on 2025-07-22 19:32:17
