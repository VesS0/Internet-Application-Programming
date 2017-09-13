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

CREATE TABLE `aerodrom` (
  `naziv` varchar(30) NOT NULL,
  `id_aerodroma` varchar(10) NOT NULL,
  `grad` varchar(20) NOT NULL,
  `drzava` varchar(20) NOT NULL,
  `br_pisti` int(11) NOT NULL,
  `br_terminala` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aerodrom`
--

INSERT INTO `aerodrom` (`naziv`, `id_aerodroma`, `grad`, `drzava`, `br_pisti`, `br_terminala`) VALUES
('Nikola Tesla', 'BEG', 'Beograd', 'Srbija', 1, 2),
('John F. Kennedy', 'JFK', 'New York', 'New York, USA', 7, 6);

-- --------------------------------------------------------

--
-- Table structure for table `aviokompanija`
--

CREATE TABLE `aviokompanija` (
  `id` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  `adresa` varchar(30) NOT NULL,
  `zemlja` varchar(30) NOT NULL,
  `sajt` varchar(30) NOT NULL,
  `mail` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aviokompanija`
--

INSERT INTO `aviokompanija` (`id`, `naziv`, `adresa`, `zemlja`, `sajt`, `mail`) VALUES
(1, 'Air Serbia', 'Neka', 'Srbija', 'www.airserbia.com', 'noreply@airserbia.com');

-- --------------------------------------------------------

--
-- Table structure for table `avion`
--

CREATE TABLE `avion` (
  `id_aviona` int(11) NOT NULL,
  `naziv` varchar(20) NOT NULL,
  `tip` int(11) NOT NULL,
  `proizvodjac` int(11) NOT NULL,
  `aviokompanija` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `avion`
--

INSERT INTO `avion` (`id_aviona`, `naziv`, `tip`, `proizvodjac`, `aviokompanija`) VALUES
(0, 'Novak Djokovic', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `gate`
--

CREATE TABLE `gate` (
  `id_aerodroma` int(11) NOT NULL,
  `terminal` int(11) NOT NULL,
  `naziv` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `let`
--

CREATE TABLE `let` (
  `id_leta` int(11) NOT NULL,
  `broj_leta` varchar(15) NOT NULL,
  `odlazni_aerodrom` varchar(10) NOT NULL,
  `dolazni_aerodrom` varchar(10) NOT NULL,
  `id_aviona` int(11) NOT NULL,
  `duzina_trajanja_leta` time NOT NULL,
  `vreme_polaska` datetime NOT NULL,
  `ocekivano_vreme_dolaska` datetime NOT NULL,
  `vreme_dolaska` datetime NOT NULL,
  `id_kapetana` varchar(20) NOT NULL,
  `id_kopilota` varchar(20) NOT NULL,
  `stjuardesa1` varchar(20) NOT NULL,
  `stjuardesa2` varchar(20) NOT NULL,
  `stjuardesa3` varchar(20) NOT NULL,
  `stjuardesa4` varchar(20) NOT NULL,
  `stjuardesa5` varchar(20) NOT NULL,
  `planirani_dolazni_aerodrom` varchar(10) NOT NULL,
  `povratni` tinyint(1) NOT NULL,
  `br_slobodnih_mesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `let`
--

INSERT INTO `let` (`id_leta`, `broj_leta`, `odlazni_aerodrom`, `dolazni_aerodrom`, `id_aviona`, `duzina_trajanja_leta`, `vreme_polaska`, `ocekivano_vreme_dolaska`, `vreme_dolaska`, `id_kapetana`, `id_kopilota`, `stjuardesa1`, `stjuardesa2`, `stjuardesa3`, `stjuardesa4`, `stjuardesa5`, `planirani_dolazni_aerodrom`, `povratni`, `br_slobodnih_mesta`) VALUES
(1, 'YU122', 'BEG', 'JFK', 0, '08:00:00', '2017-08-10 05:00:00', '2017-08-10 13:00:00', '2017-08-10 13:22:00', 'dd', 'tasha', 'dd', 'tasha', 'tasha', 'tasha', 'tasha', 'JFK', 0, 97);

-- --------------------------------------------------------

--
-- Table structure for table `licenca_pilota`
--

CREATE TABLE `licenca_pilota` (
  `korisnicko_ime` varchar(20) NOT NULL,
  `letacka_licenca` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `proizvodjac`
--

CREATE TABLE `proizvodjac` (
  `id_proizvodjaca` int(11) NOT NULL,
  `naziv` varchar(20) NOT NULL,
  `grad` varchar(20) NOT NULL,
  `drzava` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proizvodjac`
--

INSERT INTO `proizvodjac` (`id_proizvodjaca`, `naziv`, `grad`, `drzava`) VALUES
(1, 'Boeing', 'Chicago', 'Illinois');

-- --------------------------------------------------------

--
-- Table structure for table `tip_aviona`
--

CREATE TABLE `tip_aviona` (
  `id` int(11) NOT NULL,
  `naziv` varchar(20) NOT NULL,
  `id_proizvodjaca` int(11) NOT NULL,
  `licenca` varchar(2) NOT NULL,
  `br_sedista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tip_aviona`
--

INSERT INTO `tip_aviona` (`id`, `naziv`, `id_proizvodjaca`, `licenca`, `br_sedista`) VALUES
(1, '737-300', 1, 'BS', 149);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `korisnicko_ime` varchar(20) NOT NULL,
  `lozinka` varchar(30) NOT NULL,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(40) NOT NULL,
  `pol` char(1) NOT NULL,
  `datum_rodjenja` date DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `aviokompanija` int(11) NOT NULL,
  `tip_korisnika` varchar(20) NOT NULL,
  `nalog_odobren` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`korisnicko_ime`, `lozinka`, `ime`, `prezime`, `pol`, `datum_rodjenja`, `email`, `aviokompanija`, `tip_korisnika`, `nalog_odobren`) VALUES
('dd', 'aa', 'joca', 'jocic', 'm', '1987-08-16', 'fasofjofef@gmail.com', 1, '', 0),
('tasha', 'tasha', 'Tamara', 'Sekularac', 'Z', '1994-11-03', 'tashasekularac@gmail.com', 1, 'S', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aerodrom`
--
ALTER TABLE `aerodrom`
  ADD PRIMARY KEY (`id_aerodroma`);

--
-- Indexes for table `aviokompanija`
--
ALTER TABLE `aviokompanija`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`id_aviona`),
  ADD KEY `proizvodjacAviona` (`proizvodjac`),
  ADD KEY `avionAviokompanija` (`aviokompanija`),
  ADD KEY `aviontip` (`tip`);

--
-- Indexes for table `gate`
--
ALTER TABLE `gate`
  ADD PRIMARY KEY (`id_aerodroma`,`naziv`);

--
-- Indexes for table `let`
--
ALTER TABLE `let`
  ADD KEY `avionlet` (`id_aviona`),
  ADD KEY `avion_kapetan` (`id_kapetana`),
  ADD KEY `avion_kopilot` (`id_kopilota`),
  ADD KEY `avion_stjuardesa1` (`stjuardesa1`),
  ADD KEY `avion_stjuardesa2` (`stjuardesa2`),
  ADD KEY `avion_stjuardesa3` (`stjuardesa3`),
  ADD KEY `avion_stjuardesa4` (`stjuardesa4`),
  ADD KEY `avion_stjuardesa5` (`stjuardesa5`),
  ADD KEY `dolazniAerodrom` (`dolazni_aerodrom`),
  ADD KEY `odlazniAerodrom` (`odlazni_aerodrom`),
  ADD KEY `planDolazniAerodrom` (`planirani_dolazni_aerodrom`);

  CREATE TABLE `Flight` (
  `Flight_Id` int(11) NOT NULL,
  `Flight_Number` varchar(15) NOT NULL,
  `Flight_ExpectedAirportIdTo` varchar(10) NOT NULL,
  `Flight_AirportIdTo` varchar(10) NOT NULL,
  `Flight_AirportIdFrom` varchar(10) NOT NULL,
  `Flight_AirplaneId` int(11) NOT NULL,
  `Flight_Duration` time NOT NULL,
  `Flight_TakeOffTime` datetime NOT NULL,
  `Flight_ExpectedLandingTime` datetime NOT NULL,
  `Flight_LandingTime` datetime NOT NULL,
  `Flight_AvailableSeatsNumber` int(11) NOT NULL
  `Flight_PilotId` varchar(20) NOT NULL,
  `Flight_CopilotId` varchar(20) NOT NULL,
  `Flight_Stewardess_1` varchar(20) NOT NULL,
  `Flight_Stewardess_2` varchar(20) NOT NULL,
  `Flight_Stewardess_3` varchar(20) NOT NULL,
  `Flight_Stewardess_4` varchar(20) NOT NULL,
  `Flight_Stewardess_5` varchar(20) NOT NULL,
  `Flight_IsReturnFlight` tinyint(1) NOT NULL,
   PRIMARY KEY (`Flight_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`korisnicko_ime`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `useraviokompanija` (`aviokompanija`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aviokompanija`
--
ALTER TABLE `aviokompanija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `let`
--
ALTER TABLE `let`
  MODIFY `id_leta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `proizvodjac`
--
ALTER TABLE `proizvodjac`
  MODIFY `id_proizvodjaca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tip_aviona`
--
ALTER TABLE `tip_aviona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `avion`
--
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
-- Constraints for table `licenca_pilota`
--
ALTER TABLE `licenca_pilota`
  ADD CONSTRAINT `userLicenca` FOREIGN KEY (`korisnicko_ime`) REFERENCES `user` (`korisnicko_ime`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tip_aviona`
--
ALTER TABLE `tip_aviona`
  ADD CONSTRAINT `tipProizvodjac` FOREIGN KEY (`id_proizvodjaca`) REFERENCES `proizvodjac` (`id_proizvodjaca`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `useraviokompanija` FOREIGN KEY (`aviokompanija`) REFERENCES `aviokompanija` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
