drop database if exists trainingdb;

create database trainingdb;

use  trainingdb;
--
-- Table structure for table `location_tbl`
--
CREATE TABLE `location_tbl` (
  `locationid` int(11) NOT NULL,
  `location_name` tinytext,
  `classroom_name` tinytext,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`locationid`)
);
--
-- Dumping data for table `location_tbl`
--

INSERT INTO `location_tbl` VALUES (1,'Hinjawadi','Topaz',30),(2,'Hinjawadi','Ruby',30),(3,'Hinjawadi','Opel',40),(4,'Hinjawadi','Corel',10),(5,'Hinjawadi','Platinum',10),(6,'Aryabhatta','Nalanda',40),(7,'Aryabhatta','Takshasheela',30),(8,'Aryabhatta','Mithila',40),(9,'Nagpur','Sarawati',15),(10,'Nagpur','Sharda',20),(11,'Goa','Ganga',30),(12,'Goa','Godavari',25),(13,'Goa','Koyana',25),(14,'Bangalore','Bhaskara',30),(15,'Bangalore','Gargi',25);

--
-- Table structure for table `trainer_tbl`
--


CREATE TABLE `trainer_tbl` (
  `trainer_id` int(5) NOT NULL DEFAULT '0',
  `trainer_name` tinytext,
  `technology` tinytext,
  PRIMARY KEY (`trainer_id`)
);

--
-- Dumping data for table `trainer_tbl`
--

INSERT INTO `trainer_tbl` VALUES (101,'Vidya N','DotNet'),(102,'Revati','DotNet'),(103,'Mukta B','Java'),(104,'Archana K','QE'),(105,'Renuka K','QE'),(106,'Vaishali K','QE'),(107,'Arman I','Java'),(108,'Vivek J','Front End'),(109,'Vinay D','Java'),(110,'Teena M','Java'),(111,'Darsha T','Front End');

--
-- Table structure for table `skill_tbl`
--

CREATE TABLE `skill_tbl` (
  `skill_id` int(11) NOT NULL,
  `skill_name` tinytext,
  `skill_preference` int(11) DEFAULT NULL,
  `trainer_id` int(5) references trainer_tbl(trainer_id),
  PRIMARY KEY (`skill_id`)
) ;

--
-- Dumping data for table `skill_tbl`
--

INSERT INTO `skill_tbl` VALUES (301,'MVC',1,101),(308,'Asp.Net',2,102),(501,'Server Side Testing',1,104),(502,'Basic GUI Automation Test',1,105),(503,'Basic GUI Automation Test',4,104),(504,'Basic Perl',1,106),(505,'Basic GUI Automation Test',1,106),(701,'Basic Sql Queries',1,108),(702,'core Java',4,107),(703,'Hibernate',2,107),(704,'Restful web services',1,109),(705,'Spring',1,109),(706,'GIT',4,107),(707,'Restful web services',1,107),(708,'JavaScript',3,107),(709,'Spring',2,107),(710,'GIT',3,107),(711,'JavaScript',1,111),(712,'JQuery',1,111),(713,'HTML 5',1,111),(714,'core Java',1,109),(715,'JavaScript',2,109);



