-- MySQL dump 10.13  Distrib 5.5.23, for Win32 (x86)
--
-- Host: localhost    Database: remedydb
-- ------------------------------------------------------
-- Server version	5.5.23
drop database if exists remedydb;

create database remedydb;

use remedydb;


--
-- Table structure for table `remedy_tbl`
--

DROP TABLE IF EXISTS `remedy_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remedy_tbl` (
  `remedyID` int(3) NOT NULL,
  `description` varchar(100) NOT NULL,
  `priority` varchar(50) NOT NULL,
  `remedy_type` varchar(50) NOT NULL,
  `remedy_status` varchar(50) NOT NULL,
  `raised_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `actual_resolution_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`remedyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remedy_tbl`
--


INSERT INTO `remedy_tbl` VALUES 
(1,'Install JDK1.7 on My system','HIGH','itig','resolved','2015-07-02 04:45:01','2015-07-02 06:45:01'),
(2,'Install eclipse Juno','LOW','itig','assigned','2015-07-27 07:03:14',NULL),
(3,'Query regarding PF','MEDIUM','finance','inprogress','2015-07-27 06:37:25',NULL),
(4,'Need bonafide certificate','LOW','hr','assigned','2015-07-27 06:26:11',NULL),
(5,'Network problem','HIGH','itig','inprogress','2015-07-27 06:27:55',NULL),
(6,'Query about leave and attendance policy','MEDIUM','hr','assigned','2015-07-02 04:43:01',NULL),
(7,'Query about maternity leave policy','MEDIUM','hr','new','2015-07-22 04:43:01',NULL),
(8,'Need test machine for project ','LOW','itig','inprogress','2015-07-27 06:38:24',NULL),
(9,'Need form no 16 for current financial year','HIGH','finance','assigned','2015-07-27 06:45:49',NULL),
(10,'Referral bonus not yet recieved ','MEDIUM','finance','resolved','2015-07-01 07:30:30','2015-07-25 06:30:10'),
(11,'Install Jdk 1.8','HIGH','itig','new','2015-07-22 04:43:01',NULL),
(12,'Need Locker keys ','LOW','admin','resolved','2015-07-05 03:55:30','2015-07-27 06:43:01'),
(13,'Install mysql query browser','HIGH','itig','new','2015-07-22 04:43:01',NULL),
(14,'Machine performance very slow','LOW','itig','assigned','2015-07-22 04:43:01',NULL),
(15,'Need Notice Board in cubical ','LOW','admin','new','2015-07-23 04:43:01',NULL),
(16,'Query Updating Salary Bank Account Info','LOW','finance','pending','2015-07-27 06:45:19',NULL),
(17,'Need static IP for test machine','MEDIUM','itig','new','2015-07-27 09:10:00',NULL),
(18,'Please configure outllook on my machine','LOW','itig','new','2015-07-20 13:10:00',NULL),
(19,'Need name plate','LOW','admin','pending','2015-07-05 11:55:00',NULL);


