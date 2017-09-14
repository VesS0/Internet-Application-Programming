CREATE DATABASE  IF NOT EXISTS `avioflights` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `avioflights`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: avioflights
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airline`
--

DROP TABLE IF EXISTS `airline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airline` (
  `airline_Id` int(11) NOT NULL,
  `airline_Name` varchar(30) NOT NULL,
  `airline_Address` varchar(30) NOT NULL,
  `airline_Country` varchar(30) NOT NULL,
  `airline_Site` varchar(30) NOT NULL,
  `airline_Email` varchar(30) NOT NULL,
  PRIMARY KEY (`airline_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airline`
--

LOCK TABLES `airline` WRITE;
/*!40000 ALTER TABLE `airline` DISABLE KEYS */;
INSERT INTO `airline` VALUES (1,'AirlineVesic','Mira Popare 52','Serbia','Belgrade','vvesic@yahoo.com'),(2,'AirlineVladimir','Mira Popare 24','Serbia','Novi Sad','vvvesic@yahoo.com'),(3,'AirlineVesa','MemeVeme','Zerrg','Naqq','KOOOOOOOOO'),(4,'KO ZIVI','U ANANASU','NA DNU','MORA','SUNDJER'),(5,'AirlineVesa','AirlineVesa','AirlineVesa','AirlineVesa','AirlineVesa'),(6,'bla','bla','bla','bla','bla'),(7,'blaaa','blaaa','blaaa','blaaa','blaaa'),(8,'NOCOMPANY','NOCOMPANY','NOCOMPANY','NOCOMPANY','NOCOMPANY');
/*!40000 ALTER TABLE `airline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airplane` (
  `airplane_Id` int(11) NOT NULL AUTO_INCREMENT,
  `airplane_Name` varchar(20) NOT NULL,
  `airplane_AirplaneTypeId` int(11) NOT NULL,
  `airplane_ManufacturerId` int(11) NOT NULL,
  `airplane_AirlineId` int(11) NOT NULL,
  PRIMARY KEY (`airplane_Id`),
  KEY `AirplaneManufacturer` (`airplane_ManufacturerId`),
  KEY `AirplaneType` (`airplane_AirplaneTypeId`),
  KEY `airplaneAirline_idx` (`airplane_AirlineId`),
  CONSTRAINT `airplaneAirline` FOREIGN KEY (`airplane_AirlineId`) REFERENCES `airline` (`airline_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `manufAirplane` FOREIGN KEY (`airplane_ManufacturerId`) REFERENCES `manufacturer` (`manufacturer_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `planeManuf` FOREIGN KEY (`airplane_AirplaneTypeId`) REFERENCES `airplanetype` (`airplaneType_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES (1,'MirkoBrzi',1,1,5),(2,'MirkoSpori',2,1,1),(3,'MirkoMirko',3,2,5),(4,'HOOCCCKXH',1,2,3),(5,'JEROJ',2,3,1),(6,'CHOKOLADA',3,2,2),(7,'SOKO',2,3,1),(8,'BlaZaProdavanje',3,3,7),(9,'bjjjj',3,2,4),(10,'hkkj',1,1,3),(11,'hkkj',1,1,3),(12,'buuu',1,1,1),(13,'raspor',3,2,8),(14,'rrrr',2,3,8),(15,'taa',3,2,1),(16,'taam',3,3,8);
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airplanetype`
--

DROP TABLE IF EXISTS `airplanetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airplanetype` (
  `airplaneType_Id` int(11) NOT NULL AUTO_INCREMENT,
  `airplaneType_Name` varchar(20) NOT NULL,
  `airplaneType_ManufacturerId` int(11) NOT NULL,
  `airplaneType_Licence` varchar(2) NOT NULL,
  `airplaneType_SeatsNumber` int(11) NOT NULL,
  PRIMARY KEY (`airplaneType_Id`),
  KEY `AirplaneTypeManufacturer` (`airplaneType_ManufacturerId`),
  CONSTRAINT `AirplaneTypeManufacturer` FOREIGN KEY (`airplaneType_ManufacturerId`) REFERENCES `manufacturer` (`manufacturer_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplanetype`
--

LOCK TABLES `airplanetype` WRITE;
/*!40000 ALTER TABLE `airplanetype` DISABLE KEYS */;
INSERT INTO `airplanetype` VALUES (1,'dobarVion',1,'LI',3),(2,'LosVion',2,'LI',232),(3,'ZaoVion',3,'ZA',9392);
/*!40000 ALTER TABLE `airplanetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airport` (
  `airport_Id` varchar(30) NOT NULL,
  `airport_Name` varchar(30) NOT NULL,
  `airport_City` varchar(20) NOT NULL,
  `airport_Country` varchar(20) NOT NULL,
  `airport_PistsNumber` int(11) NOT NULL,
  `airport_TerminalsNumber` int(11) NOT NULL,
  PRIMARY KEY (`airport_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES ('Airport','Airprot','Airport','Airport',5,0),('avion','avio','avi','avi',2,0),('DRG','Keks','Valjevo','Srbija',32,22),('GRK','Keks','Kekisc','Keksonja',4,0),('passingTest','passing','passing','passing',3,0),('PRV','Srbija','Beogra','Srbija',23,32),('pss','pss','pss','pss',3,0),('teeest','teeest','teest','teest',2,0),('test','test','test','test',5,0),('test1','test1','test1','test1',3,0),('test2','test2','test2','test1',6,0),('test3','test3','test2','test2',3,0),('test4','test2','test3','test2',4,0),('test5','test4','test3','test2',4,0),('test6','test6','test5','test5',3,0),('test7','tes4','test2','test1',4,0),('test8','test6','test4','test2',1,0),('testest','testest','testtest','testest',2,0),('TRC','Beogradi','Valjevo','Bec',22,12);
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `flight_Id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_Number` varchar(15) NOT NULL,
  `flight_ExpectedAirportIdTo` varchar(30) NOT NULL,
  `flight_AirportIdTo` varchar(30) NOT NULL,
  `flight_AirportIdFrom` varchar(30) NOT NULL,
  `flight_AirplaneId` int(11) NOT NULL,
  `flight_Duration` time NOT NULL,
  `flight_TakeOffTime` datetime NOT NULL,
  `flight_ExpectedLandingTime` datetime NOT NULL,
  `flight_LandingTime` datetime NOT NULL,
  `flight_AvailableSeatsNumber` int(11) NOT NULL,
  `flight_PilotId` varchar(45) NOT NULL,
  `flight_CopilotId` varchar(45) NOT NULL,
  `flight_StewardessId_1` varchar(45) NOT NULL,
  `flight_StewardessId_2` varchar(45) NOT NULL,
  `flight_StewardessId_3` varchar(45) NOT NULL,
  `flight_StewardessId_4` varchar(45) NOT NULL,
  `flight_StewardessId_5` varchar(45) NOT NULL,
  `flight_IsReturnFlight` tinyint(1) NOT NULL,
  `flight_GateIdFrom` int(11) DEFAULT NULL,
  `flight_GateIdTo` int(11) DEFAULT NULL,
  `flight_IsCharter` tinyint(1) DEFAULT NULL,
  `flight_TerminalIdTo` int(11) DEFAULT NULL,
  `flight_TerminalIdFrom` int(11) DEFAULT NULL,
  PRIMARY KEY (`flight_Id`),
  KEY `FlightAirplane` (`flight_AirplaneId`),
  KEY `FlightCopilot` (`flight_CopilotId`),
  KEY `FlightStewardeess1` (`flight_StewardessId_1`),
  KEY `FlightStewardeess2` (`flight_StewardessId_2`),
  KEY `FlightStewardeess3` (`flight_StewardessId_3`),
  KEY `FlightStewardeess4` (`flight_StewardessId_4`),
  KEY `FlightStewardeess5` (`flight_StewardessId_5`),
  KEY `fghjhg_idx` (`flight_GateIdFrom`),
  KEY `ccc_idx` (`flight_GateIdTo`),
  KEY `nng_idx` (`flight_PilotId`),
  KEY `flightAirport_idx` (`flight_AirportIdTo`),
  KEY `FlightAirportt_idx` (`flight_ExpectedAirportIdTo`),
  KEY `flightairporteowko_idx` (`flight_AirportIdFrom`),
  KEY `terminal_idx` (`flight_TerminalIdTo`),
  KEY `terminalId_idx` (`flight_TerminalIdFrom`),
  CONSTRAINT `D2211D` FOREIGN KEY (`flight_StewardessId_4`) REFERENCES `user` (`user_UserName`) ON UPDATE CASCADE,
  CONSTRAINT `DSSSSSS` FOREIGN KEY (`flight_StewardessId_5`) REFERENCES `user` (`user_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FlightAirportt` FOREIGN KEY (`flight_ExpectedAirportIdTo`) REFERENCES `airport` (`airport_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `GDDDD` FOREIGN KEY (`flight_StewardessId_2`) REFERENCES `user` (`user_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `HGHG` FOREIGN KEY (`flight_StewardessId_1`) REFERENCES `user` (`user_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bbb` FOREIGN KEY (`flight_CopilotId`) REFERENCES `user` (`user_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ccc` FOREIGN KEY (`flight_GateIdTo`) REFERENCES `gate` (`gate_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fghjhg` FOREIGN KEY (`flight_GateIdFrom`) REFERENCES `gate` (`gate_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `flightAirport` FOREIGN KEY (`flight_AirportIdTo`) REFERENCES `airport` (`airport_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `flightairporteowko` FOREIGN KEY (`flight_AirportIdFrom`) REFERENCES `airport` (`airport_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nng` FOREIGN KEY (`flight_PilotId`) REFERENCES `user` (`user_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stew3` FOREIGN KEY (`flight_StewardessId_3`) REFERENCES `user` (`user_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `terminal` FOREIGN KEY (`flight_TerminalIdTo`) REFERENCES `terminal` (`terminal_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `terminalId` FOREIGN KEY (`flight_TerminalIdFrom`) REFERENCES `terminal` (`terminal_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vvv` FOREIGN KEY (`flight_AirplaneId`) REFERENCES `airplane` (`airplane_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'1','PRV','DRG','TRC',1,'00:03:23','2018-12-31 00:00:00','2018-12-31 00:00:00','2018-12-31 00:00:00',23,'ffaa','ffaa','vlaa','vlaa','vlaa','vlaa','vesaa',0,1,2,NULL,2,3),(2,'1','DRG','TRC','DRG',2,'00:32:32','2012-12-31 00:00:00','2019-12-31 00:00:00','2018-12-31 00:00:00',32,'ffaa','ffaa','vlaa','vlaa','vlaa','vlaa','vlaa',1,2,1,NULL,3,2),(3,'2','PRV','DRG','PRV',3,'00:32:32','2012-12-31 00:00:00','2012-12-31 00:00:00','2012-12-31 00:00:00',32,'ffaa','ffaa','vesaa','vlaa','vlaa','vlaa','vlaa',3,3,3,NULL,3,3),(4,'3','DRG','DRG','PRV',2,'00:32:32','2014-12-31 00:00:00','2014-12-31 00:00:00','2014-12-31 00:00:00',32,'ffaa','ffaa','vlaa','vesaa','vlaa','vlaa','vlaa',2,2,2,NULL,2,2),(5,'34','TRC','TRC','TRC',12,'00:55:44','2017-12-30 00:00:00','2012-12-31 00:00:00','2012-12-31 00:00:00',23,'ffaa','ffaa','vlaa','vlaa','vlaa','vlaa','vlaa',0,3,2,1,2,1);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flightstate`
--

DROP TABLE IF EXISTS `flightstate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flightstate` (
  `flightState_Id` int(11) NOT NULL AUTO_INCREMENT,
  `flightState_Status` varchar(45) DEFAULT NULL,
  `flightState_RadarId` int(11) DEFAULT NULL,
  `flightState_FlightId` int(11) DEFAULT NULL,
  PRIMARY KEY (`flightState_Id`),
  KEY `ghghhjhjhjhj_idx` (`flightState_RadarId`),
  KEY `zzzaazaaa_idx` (`flightState_FlightId`),
  CONSTRAINT `ghghhjhjhjhj` FOREIGN KEY (`flightState_RadarId`) REFERENCES `radarcenter` (`radarCenter_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `zzzaazaaa` FOREIGN KEY (`flightState_FlightId`) REFERENCES `flight` (`flight_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flightstate`
--

LOCK TABLES `flightstate` WRITE;
/*!40000 ALTER TABLE `flightstate` DISABLE KEYS */;
/*!40000 ALTER TABLE `flightstate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gate`
--

DROP TABLE IF EXISTS `gate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gate` (
  `gate_AirportId` varchar(30) NOT NULL,
  `gate_TerminalId` int(11) NOT NULL,
  `gate_Name` varchar(5) NOT NULL,
  `gate_Id` int(11) NOT NULL,
  PRIMARY KEY (`gate_Id`),
  KEY `saa_idx` (`gate_AirportId`),
  KEY `xaxaxa_idx` (`gate_TerminalId`),
  CONSTRAINT `gateAirport` FOREIGN KEY (`gate_AirportId`) REFERENCES `airport` (`airport_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `xaxaxa` FOREIGN KEY (`gate_TerminalId`) REFERENCES `terminal` (`terminal_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gate`
--

LOCK TABLES `gate` WRITE;
/*!40000 ALTER TABLE `gate` DISABLE KEYS */;
INSERT INTO `gate` VALUES ('PRV',1,'GaNam',1),('PRV',2,'Dss',2),('DRG',3,'wew',3),('TRC',4,'ew',4),('PRV',2,'Rdd',5),('pss',14,'pss',6);
/*!40000 ALTER TABLE `gate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturer` (
  `manufacturer_Id` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer_UserName` varchar(20) NOT NULL,
  `manufacturer_City` varchar(20) NOT NULL,
  `manufacturer_Country` varchar(20) NOT NULL,
  PRIMARY KEY (`manufacturer_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'ManuFakTURAA','Beograd','Srbija'),(2,'Fakturaa','Bec','Beeeecch'),(3,'Prodavanje','Magle','Hehe');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pilotlicence`
--

DROP TABLE IF EXISTS `pilotlicence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pilotlicence` (
  `pilotLicence_UserName` varchar(20) NOT NULL,
  `pilotLicence_Licence` varchar(9) NOT NULL,
  PRIMARY KEY (`pilotLicence_UserName`,`pilotLicence_Licence`),
  CONSTRAINT `PilotUser` FOREIGN KEY (`pilotLicence_UserName`) REFERENCES `user` (`user_UserName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pilotlicence`
--

LOCK TABLES `pilotlicence` WRITE;
/*!40000 ALTER TABLE `pilotlicence` DISABLE KEYS */;
INSERT INTO `pilotlicence` VALUES ('ffaa','UX3456789'),('tata','ZA');
/*!40000 ALTER TABLE `pilotlicence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radarcenter`
--

DROP TABLE IF EXISTS `radarcenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `radarcenter` (
  `radarCenter_Id` int(11) NOT NULL,
  `radarCenter_City` varchar(45) DEFAULT NULL,
  `radarCenter_FlightId` int(11) DEFAULT NULL,
  PRIMARY KEY (`radarCenter_Id`),
  KEY `saaaaqqqq_idx` (`radarCenter_FlightId`),
  CONSTRAINT `saaaaqqqq` FOREIGN KEY (`radarCenter_FlightId`) REFERENCES `flight` (`flight_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radarcenter`
--

LOCK TABLES `radarcenter` WRITE;
/*!40000 ALTER TABLE `radarcenter` DISABLE KEYS */;
/*!40000 ALTER TABLE `radarcenter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent` (
  `Rent_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Rent_AirlineId` int(11) DEFAULT NULL,
  `Rent_Price` int(11) DEFAULT NULL,
  `Rent_DateFrom` datetime DEFAULT NULL,
  `Rent_DateTo` datetime DEFAULT NULL,
  `Rent_AirplaneId` int(11) DEFAULT NULL,
  `Rent_IsAccepted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Rent_Id`),
  KEY `bnmjhhh_idx` (`Rent_AirplaneId`),
  KEY `RentAriline_idx` (`Rent_AirlineId`),
  CONSTRAINT `RentAirline` FOREIGN KEY (`Rent_AirlineId`) REFERENCES `airline` (`airline_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bnmjhhh` FOREIGN KEY (`Rent_AirplaneId`) REFERENCES `airplane` (`airplane_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
INSERT INTO `rent` VALUES (1,1,1,'2000-09-09 00:00:00','2000-09-09 00:00:00',12,0);
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminal`
--

DROP TABLE IF EXISTS `terminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminal` (
  `terminal_Id` int(11) NOT NULL,
  `terminal_Naziv` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `terminal_AirportId` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`terminal_Id`),
  UNIQUE KEY `terminal_Id_UNIQUE` (`terminal_Id`),
  KEY `sasass_idx` (`terminal_AirportId`),
  CONSTRAINT `sasas` FOREIGN KEY (`terminal_AirportId`) REFERENCES `airport` (`airport_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminal`
--

LOCK TABLES `terminal` WRITE;
/*!40000 ALTER TABLE `terminal` DISABLE KEYS */;
INSERT INTO `terminal` VALUES (1,'Hhh',NULL),(2,'ee',NULL),(3,'eww',NULL),(4,'eww',NULL),(5,'ggg',NULL),(6,'Beograd',NULL),(7,'teesttt','test6'),(8,'term','test7'),(9,'test8','test8'),(10,'avioterm','avion'),(11,'testestest','testest'),(12,'teeeest','teeest'),(13,'passing','passingTest'),(14,'pss','pss');
/*!40000 ALTER TABLE `terminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_UserName` varchar(20) NOT NULL,
  `user_Password` varchar(30) NOT NULL,
  `user_Name` varchar(30) NOT NULL,
  `user_Surname` varchar(40) NOT NULL,
  `user_Gender` char(1) NOT NULL,
  `user_DayOfBirth` date DEFAULT NULL,
  `user_Email` varchar(30) NOT NULL,
  `user_AirlineId` int(11) NOT NULL,
  `user_TypeOfUser` varchar(20) NOT NULL,
  `user_AccountValid` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_UserName`),
  UNIQUE KEY `user_Email` (`user_Email`),
  KEY `UserAirline_idx` (`user_AirlineId`),
  CONSTRAINT `UserAirline` FOREIGN KEY (`user_AirlineId`) REFERENCES `airline` (`airline_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Admin','Admin','Admin','Admin','F','2017-06-15','Admin@Admin.Admin',2,'Admin',1),('dd','aa','dd','aa','0','2017-06-15','dd',1,'Employee',0),('ffaa','ffaa','ffaa','ffaa','M',NULL,'ffaa',3,'Pilot',1),('pilot','pilot','pilot','pilot','M','2017-06-15','pilot',1,'Pilot',0),('tata','tata','tata','tata','M','2017-06-15','tataaa',3,'Pilot',1),('vesaa','vesaa','vesaa','vesaa','M',NULL,'vesaa',7,'Stewardess',0),('vlaa','vlaaadd','vlaa','daa','M',NULL,'vlaa',1,'Stewardess',1),('vlada','vlada','vlaa','daa','M','2017-06-15','vlada',1,'Pilot',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-14  8:56:26
