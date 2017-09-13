-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2017 at 02:45 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `avioletovi`
--

-- --------------------------------------------------------

--
-- Table structure for table `aerodrom`
--

CREATE TABLE `Airport` (
  `Airport_Id` varchar(10) NOT NULL,
  `Airport_Name` varchar(30) NOT NULL,
  `Airport_City` varchar(20) NOT NULL,
  `Airport_Country` varchar(20) NOT NULL,
  `Airport_PistsNumber` int(11) NOT NULL,
  `Airport_TerminalsNumber` int(11) NOT NULL,
   PRIMARY KEY (`Airport_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `Airport`
  MODIFY `Airport_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Dumping data for table `aerodrom`
--

INSERT INTO `Airport` (`Airport_Name`, `Airport_Id`, `Airport_City`, `Airport_Country`, `Airport_PistsNumber`, `Airport_TerminalsNumber`) VALUES
('Nikola Tesla', 'BEG', 'Beograd', 'Srbija', 1, 2),
('John F. Kennedy', 'JFK', 'New York', 'New York, USA', 7, 6);

-- --------------------------------------------------------

--
-- Table structure for table `aviokompanija`
--

CREATE TABLE `Airline` (
  `Airline_Id` int(11) NOT NULL,
  `Airline_Name` varchar(30) NOT NULL,
  `Airline_Address` varchar(30) NOT NULL,
  `Airline_Country` varchar(30) NOT NULL,
  `Airline_Site` varchar(30) NOT NULL,
  `Airline_Email` varchar(30) NOT NULL,
   PRIMARY KEY (`Airline_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `Airline`
  MODIFY `Airline_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Dumping data for table `aviokompanija`
-- nn

INSERT INTO `Airline` (`Airline_Id`, `Airline_Name`, `Airline_Address`, `Airline_Country`, `Airline_Site`, `Airline_Email`) VALUES
(2, 'Air Serbia', 'Neka', 'Srbija', 'www.airserbia.com', 'noreply@airserbia.com');

-- --------------------------------------------------------

--
-- Table structure for table `avion`
--

CREATE TABLE `Airplane` (
  `Airplane_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Airplane_Name` varchar(20) NOT NULL,
  `Airplane_AirplaneTypeId` int(11) NOT NULL,
  `Airplane_ManufacturerId` int(11) NOT NULL,
  `Airplane_AirlineId` int(11) NOT NULL,
   PRIMARY KEY (`Airplane_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `Airplane`
  MODIFY `Airplane_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Dumping data for table `avion`
--

INSERT INTO `Airplane` (`Airplane_Id`, `Airplane_Name`, `Airplane_AirplaneTypeId`, `Airplane_ManufacturerId`, `Airline_AirlineId`) VALUES
(0, 'Novak Djokovic', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `gate`
--

CREATE TABLE `Gate` (
  `Gate_AirportId` int(11) NOT NULL,
  `Gate_Terminal` int(11) NOT NULL,
  `Gate_Name` varchar(5) NOT NULL,
   PRIMARY KEY (`Gate_AirportId`,`Gate_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `let`
--

CREATE TABLE `Flight` (
  `Flight_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Flight_Number` varchar(15) NOT NULL,
  `Flight_ExpectedAirportIdTo` varchar(10) NOT NULL,
  `Flight_AirportIdTo` varchar(10) NOT NULL,
  `Flight_AirportIdFrom` varchar(10) NOT NULL,
  `Flight_AirplaneId` int(11) NOT NULL,
  `Flight_Duration` time NOT NULL,
  `Flight_TakeOffTime` datetime NOT NULL,
  `Flight_ExpectedLandingTime` datetime NOT NULL,
  `Flight_LandingTime` datetime NOT NULL,
  `Flight_AvailableSeatsNumber` int(11) NOT NULL,
  `Flight_PilotId` varchar(20) NOT NULL,
  `Flight_CopilotId` varchar(20) NOT NULL,
  `Flight_StewardessId_1` varchar(20) NOT NULL,
  `Flight_StewardessId_2` varchar(20) NOT NULL,
  `Flight_StewardessId_3` varchar(20) NOT NULL,
  `Flight_StewardessId_4` varchar(20) NOT NULL,
  `Flight_StewardessId_5` varchar(20) NOT NULL,
  `Flight_IsReturnFlight` tinyint(1) NOT NULL,
   PRIMARY KEY (`Flight_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `Flight`
  MODIFY `Flight_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Dumping data for table `let`
--

INSERT INTO `Flight` (`Flight_Id`, `Flight_Number`, `Flight_AirportIdFrom`, `Flight_AirportIdTo`, `Flight_AirplaneId`, `Flight_Duration`,
 `Flight_TakeOffTime`, `Flight_ExpectedLandingTime`, `Flight_LandingTime`, `Flight_PilotId`, `Flight_CopilotId`, `Flight_StewardessId_1`, `Flight_StewardessId_2`, `Flight_StewardessId_3`,
 `Flight_StewardessId_4`, `Flight_StewardessId_5`, `Flight_ExpectedAirportIdTo`, `Flight_IsReturnFlight`, `Flight_AvailableSeatsNumber`) VALUES
(1, 'YU122', 'BEG', 'JFK', 0, '08:00:00', '2017-08-10 05:00:00', '2017-08-10 13:00:00', '2017-08-10 13:22:00', 'dd', 'tasha', 'dd', 'tasha', 'tasha', 'tasha', 'tasha', 'JFK', 0, 97);

-- --------------------------------------------------------

--
-- Table structure for table `licenca_pilota`
--

CREATE TABLE `PilotLicence` (
  `PilotLicence_UserName` varchar(20) NOT NULL,
  `PilotLicence_Licence` varchar(9) NOT NULL,
  PRIMARY KEY (`PilotLicence_UserName`,`PilotLicence_Licence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `proizvodjac`
--

CREATE TABLE `Manufacturer` (
  `Manufacturer_Id` int(11) NOT NULL,
  `Manufacturer_UserName` varchar(20) NOT NULL,
  `Manufacturer_City` varchar(20) NOT NULL,
  `Manufacturer_Country` varchar(20) NOT NULL,
   PRIMARY KEY (`Manufacturer_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `Manufacturer`
  MODIFY `Manufacturer_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Dumping data for table `proizvodjac`
--

INSERT INTO `Manufacturer` (`Manufacturer_Id`, `Manufacturer_UserName`, `Manufacturer_City`, `Manufacturer_Country`) VALUES
(1, 'Boeing', 'Chicago', 'Illinois');

-- --------------------------------------------------------

--
-- Table structure for table `tip_aviona`
--

CREATE TABLE `AirplaneType` (
  `AirplaneType_Id` int(11) NOT NULL,
  `AirplaneType_Name` varchar(20) NOT NULL,
  `AirplaneType_ManufacturerId` int(11) NOT NULL,
  `AirplaneType_Licence` varchar(2) NOT NULL,
  `AirplaneType_SeatsNumber` int(11) NOT NULL,
   PRIMARY KEY (`AirplaneType_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `AirplaneType`
  MODIFY `AirplaneType_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Dumping data for table `tip_aviona`
--

INSERT INTO `AirplaneType` (`AirplaneType_Id`, `AirplaneType_Name`, `AirplaneType_ManufacturerId`, `AirplaneType_Licence`, `AirplaneType_SeatsNumber`) VALUES
(1, '737-300', 1, 'BS', 149);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `User` (
  `User_UserName` varchar(20) NOT NULL,
  `User_Password` varchar(30) NOT NULL,
  `User_Name` varchar(30) NOT NULL,
  `User_Surname` varchar(40) NOT NULL,
  `User_Gender` char(1) NOT NULL,
  `User_DayOfBirth` date DEFAULT NULL,
  `User_Email` varchar(30) NOT NULL,
  `User_AirlineId` int(11) NOT NULL,
  `User_TypeOfUser` varchar(20) NOT NULL,
  `User_AccountValid` tinyint(1) NOT NULL DEFAULT '0',
   PRIMARY KEY (`User_UserName`),
   UNIQUE KEY(`User_Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_UserName`, `User_Password`, `User_Name`, `User_Surname`, `User_Gender`, `User_DayOfBirth`, `User_Email`, `User_AirlineId`, `User_TypeOfUser`, `User_AccountValid`) VALUES
('dd', 'aa', 'joca', 'jocic', 'm', '1987-08-16', 'fasofjofef@gmail.com', 1, '', 0),
('tasha', 'tasha', 'Tamara', 'Sekularac', 'Z', '1994-11-03', 'tashasekularac@gmail.com', 1, 'S', 1);

--
-- Indexes for table `avion`
--
ALTER TABLE `Airplane`
  ADD KEY `AirplaneManufacturer` (`Airplane_ManufacturerId`),
  ADD KEY `AirplaneAirline` (`Airplane_AirlineId`),
  ADD KEY `AirplaneType` (`Airplane_AirplaneTypeId`);

--
-- Indexes for table `let`
--
ALTER TABLE `Flight`
  ADD KEY `FlightAirplane` (`Flight_AirplaneId`),
  ADD KEY `FlightPilot` (`Flight_PilotId`),
  ADD KEY `FlightCopilot` (`Flight_CopilotId`),
  ADD KEY `FlightStewardeess1` (`Flight_StewardessId_1`),
  ADD KEY `FlightStewardeess2` (Flight_StewardessId_2),
  ADD KEY `FlightStewardeess3` (`Flight_StewardessId_3`),
  ADD KEY `FlightStewardeess4` (Flight_StewardessId_4),
  ADD KEY `FlightStewardeess5` (`Flight_StewardessId_5`),
  ADD KEY `FlightAirportFrom` (Flight_AirportIdFrom),
  ADD KEY `FlightAirportTo` (`Flight_AirportIdTo`),
  ADD KEY `FlightExpectedAirportTo` (`Flight_ExpectedAirportIdTo`);

--
-- Indexes for table `tip_aviona`
--
ALTER TABLE `AirplaneType`
  ADD KEY `AirplaneTypeManufacturer` (`AirplaneType_ManufacturerId`);

--
-- Indexes for table `user`
--
ALTER TABLE `User`
  ADD KEY `UserAirline` (`User_AirlineId`);

--
-- Constraints for table `avion`
-- dsdsdsds
ALTER TABLE `Airplane`
  ADD CONSTRAINT `AirplaneAirline` FOREIGN KEY (`Airline_AirlineId`) REFERENCES `Airline` (`Airline_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `AirplaneType` FOREIGN KEY (`Airplane_AirplaneTypeId`) REFERENCES `AirplaneType` (`AirplaneType_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `AirplineManufacturer` FOREIGN KEY (`Airplane_ManufacturerId`) REFERENCES `Manufacturer` (`Manufacturer_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `let`
--
ALTER TABLE `Flight`
  ADD CONSTRAINT `FlightPilot` FOREIGN KEY (`Flight_PilotId`) REFERENCES `user` (`User_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightCopilot` FOREIGN KEY (`Flight_CopilotId`) REFERENCES `user` (`User_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightStewardess1` FOREIGN KEY (`Flight_StewardessId_1`) REFERENCES `user` (`User_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightStewardess2` FOREIGN KEY (`Flight_StewardessId_2`) REFERENCES `user` (`User_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightStewardess3` FOREIGN KEY (`Flight_StewardessId_3`) REFERENCES `user` (`User_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightStewardess4` FOREIGN KEY (`Flight_StewardessId_4`) REFERENCES `user` (`User_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightStewardess5` FOREIGN KEY (`Flight_StewardessId_5`) REFERENCES `user` (`User_UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightAirplane` FOREIGN KEY (`Flight_AirplaneId`) REFERENCES `Airplane` (`Airplane_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightAirportTo` FOREIGN KEY (`Flight_AirportIdTo`) REFERENCES `Airport` (`Airport_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightAirportFromt` FOREIGN KEY (`Flight_AirportIdFrom`) REFERENCES `Airport` (`Airport_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FlightAirportExpectedTo` FOREIGN KEY (`Flight_ExpectedAirportIdTo`) REFERENCES `Airport` (`Airport_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
--
-- Constraints for table `licenca_pilota`
--
ALTER TABLE `PilotLicence`
  ADD CONSTRAINT `PilotUser` FOREIGN KEY (`PilotLicence_UserName`) REFERENCES `User` (`User_UserName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tip_aviona`
--
ALTER TABLE `AirplaneType`
  ADD CONSTRAINT `AirplaneTypeManufacturer` FOREIGN KEY (`AirplaneType_ManufacturerId`) REFERENCES `Manufacturer` (`Manufacturer_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `User`
  ADD CONSTRAINT `UserAirline` FOREIGN KEY (`User_AirlineId`) REFERENCES `Airline` (`Airline_Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
