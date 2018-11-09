-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2018 at 07:57 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scmdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `psnNo` char(8) NOT NULL,
  `pw` char(32) NOT NULL,
  `prv` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`psnNo`, `pw`, `prv`) VALUES
('MGR00001', 'e10adc3949ba59abbe56e057f20f883e', 'M'),
('MGR00002', 'e10adc3949ba59abbe56e057f20f883e', 'M'),
('SUP00001', 'e10adc3949ba59abbe56e057f20f883e', 'S'),
('SUP00002', 'e10adc3949ba59abbe56e057f20f883e', 'S'),
('SUP00003', 'e10adc3949ba59abbe56e057f20f883e', 'S'),
('SUP00004', 'e10adc3949ba59abbe56e057f20f883e', 'S');

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

CREATE TABLE `material` (
  `matNo` char(8) NOT NULL,
  `matNm` varchar(30) NOT NULL,
  `des` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `material`
--

INSERT INTO `material` (`matNo`, `matNm`, `des`) VALUES
('MAT00001', 'Limestone', 'Powdered  limstone / calcium crabonate'),
('MAT00002', 'Clay', 'Powdered clay'),
('MAT00003', 'Marl', 'silica sand'),
('MAT00004', 'Shale', 'alumina and ferric oxide'),
('MAT00005', 'fly ash', 'Pulverised Fuel Ash (PFA)'),
('MAT00006', 'ironstone', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `psnNo` char(8) NOT NULL,
  `psnNm` varchar(90) NOT NULL,
  `gndr` char(1) NOT NULL,
  `dob` date NOT NULL,
  `nic` char(10) NOT NULL,
  `email` varchar(70) DEFAULT NULL,
  `adr` varchar(200) DEFAULT NULL,
  `tp` char(12) DEFAULT NULL,
  `post` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`psnNo`, `psnNm`, `gndr`, `dob`, `nic`, `email`, `adr`, `tp`, `post`) VALUES
('MGR00001', 'Lalith Fonseka\r\n', 'M', '1981-02-20', '813165897V', 'lalith@postlime.lk', '56B, Canal Road, Galle\r\n', '+94112525689', 'Area Manager'),
('MGR00002', 'Supuni Samaranayaka', 'F', '1979-10-29', '792567896V', 'supuni.samaranayaka@postlime.co.lk', '115C, Union Avenue, Kandy\r\n', '+94780069745', 'Area Manager'),
('SUP00001', 'Lahiru Vithana', 'M', '1993-01-15', '933162897V', 'lahiru@gmail.com', '25/5, High Level Road, Colombo 6 ', '+94777589620', 'Supervisor'),
('SUP00002', 'Kavindya Ganegama\r\n', 'F', '1997-11-10', '975623488V', 'kavindya@ymail.com', '5/25, High Level Road, Colombo 6', '+94782569785', 'Supervisor'),
('SUP00003', 'Hashan de Silva\r\n', 'M', '1989-02-05', '891256389V', 'hashan.de@y2kmail.com', '89/125, Green Street, Galle\r\n', '+94725689712', 'Supervisor'),
('SUP00004', 'Kamani Athapaththu\r\n', 'F', '1985-05-08', '855678944V', 'kamani.att@hotmail.com', '12D, Palace road, Kandy\r\n', '+94765589325', 'Supervisor');

-- --------------------------------------------------------

--
-- Table structure for table `sply_mat`
--

CREATE TABLE `sply_mat` (
  `splNo` char(8) NOT NULL,
  `matNo` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sply_mat`
--

INSERT INTO `sply_mat` (`splNo`, `matNo`) VALUES
('SPL00001', 'MAT00001'),
('SPL00001', 'MAT00002'),
('SPL00001', 'MAT00005'),
('SPL00002', 'MAT00003'),
('SPL00002', 'MAT00004'),
('SPL00002', 'MAT00005'),
('SPL00003', 'MAT00001'),
('SPL00003', 'MAT00005'),
('SPL00003', 'MAT00006'),
('SPL00004', 'MAT00001'),
('SPL00004', 'MAT00002'),
('SPL00005', 'MAT00003'),
('SPL00005', 'MAT00004'),
('SPL00006', 'MAT00003'),
('SPL00006', 'MAT00005'),
('SPL00006', 'MAT00006');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `whNo` char(6) NOT NULL,
  `matNo` char(10) NOT NULL,
  `qty` double NOT NULL,
  `ordLvl` double NOT NULL,
  `maxQty` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`whNo`, `matNo`, `qty`, `ordLvl`, `maxQty`) VALUES
('WH0001', 'MAT00001', 21000, 7000, 26000),
('WH0001', 'MAT00002', 22526, 6000, 25000),
('WH0001', 'MAT00003', 18000, 15000, 32000),
('WH0002', 'MAT00003', 29289, 9000, 31000),
('WH0002', 'MAT00004', 22689, 11000, 25000),
('WH0003', 'MAT00005', 21000, 10000, 21000),
('WH0003', 'MAT00006', 18106, 8000, 30000),
('WH0004', 'MAT00001', 20418, 80000, 29000),
('WH0004', 'MAT00002', 27225, 10000, 30000);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `splNo` char(8) NOT NULL,
  `splNm` varchar(75) NOT NULL,
  `adr` varchar(200) NOT NULL,
  `email` varchar(75) NOT NULL,
  `tp` char(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`splNo`, `splNm`, `adr`, `email`, `tp`) VALUES
('SPL00001', 'ACME chemicals co. USA', '711-2880 Nulla St., Mankato, Mississippi, USA 96522', 'cecilia.chapman@order.acme.co.us', '+115756374015'),
('SPL00002', 'Westmore pvt Ltd. UK', 'Fusce Rd., Frederick, Scotland 4FG 2KL, UK', 'iris.watson@sply.westmore.com', '+441675002784'),
('SPL00003', 'ZEN YUAN co. CHINA', '1 Zhongshan, West Road, Hohhot, CHINA', 'yin.xu@sup.zenyuan.com', '+8641693112245'),
('SPL00004', 'JIN SUCHI Chemicals pvt Ltd. CHINA', '17 Quan Cheng Road, Jinan, CHINA', 'sam.suchi@jinsuchi.com', '+861622737901'),
('SPL00005', 'Jinasena group co.', '12/B Union Place, Colombo 7', 'saman.wijitha@jinasena.co.lk', '+94112356897'),
('SPL00006', 'Lium Chemicals co.', '13/A Canal road, Galle', 'kamal.fernando@liumchemicals.lk', '+94917856328');

-- --------------------------------------------------------

--
-- Table structure for table `supply`
--

CREATE TABLE `supply` (
  `grnNo` char(10) NOT NULL,
  `splNo` char(8) NOT NULL,
  `matNo` char(8) NOT NULL,
  `whNo` char(6) NOT NULL,
  `unt` double NOT NULL,
  `untPrc` double NOT NULL,
  `dtTm` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supply`
--

INSERT INTO `supply` (`grnNo`, `splNo`, `matNo`, `whNo`, `unt`, `untPrc`, `dtTm`) VALUES
('GRN0000001', 'SPL00001', 'MAT00001', 'WH0001', 6000, 12500, '2018-01-02 12:24:34'),
('GRN0000001', 'SPL00001', 'MAT00002', 'WH0001', 9562, 35698, '2017-12-24 13:13:02'),
('GRN0000002', 'SPL00002', 'MAT00003', 'WH0002', 5986, 65896, '2017-12-24 13:32:26'),
('GRN0000002', 'SPL00002', 'MAT00004', 'WH0002', 10256, 16589, '2017-12-24 13:32:26'),
('GRN0000003', 'SPL00003', 'MAT00005', 'WH0003', 11256, 18759, '2017-12-24 13:34:22'),
('GRN0000003', 'SPL00003', 'MAT00006', 'WH0003', 5689, 23698, '2017-12-24 13:34:22'),
('GRN0000004', 'SPL00004', 'MAT00001', 'WH0004', 8568, 36897, '2017-12-24 13:35:51'),
('GRN0000004', 'SPL00004', 'MAT00002', 'WH0004', 12987, 13568, '2017-12-24 13:35:51'),
('GRN0000005', 'SPL00003', 'MAT00001', 'WH0001', 8000, 1250, '2018-01-02 12:26:01'),
('GRN0000006', 'SPL00004', 'MAT00002', 'WH0001', 6000, 11256, '2018-01-08 00:16:49'),
('GRN0000007', 'SPL00002', 'MAT00003', 'WH0002', 12500, 4562, '2018-01-08 00:19:59'),
('GRN0000008', 'SPL00006', 'MAT00005', 'WH0003', 12500, 6523, '2018-01-08 00:22:17'),
('GRN0000008', 'SPL00006', 'MAT00006', 'WH0003', 11250, 2563, '2018-01-08 00:22:29'),
('GRN0000009', 'SPL00005', 'MAT00003', 'WH0001', 18000, 11250, '2018-01-08 00:23:54'),
('GRN0000010', 'SPL00001', 'MAT00001', 'WH0004', 7850, 11586, '2018-01-08 00:26:23'),
('GRN0000010', 'SPL00001', 'MAT00002', 'WH0004', 12200, 10256, '2018-01-08 00:26:03');

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `whNo` char(6) NOT NULL,
  `strgSpc` double NOT NULL,
  `adr` varchar(200) NOT NULL,
  `supNo` char(8) NOT NULL,
  `mgrNo` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `warehouse`
--

INSERT INTO `warehouse` (`whNo`, `strgSpc`, `adr`, `supNo`, `mgrNo`) VALUES
('WH0001', 600000, '125/9, Steven Street, Hambanthota\r\n', 'SUP00001', 'MGR00001'),
('WH0002', 750000, '89/125, Magalla, Galle\r\n', 'SUP00002', 'MGR00001'),
('WH0003', 580000, '12/5, Main Street, Colombo 11\r\n', 'SUP00003', 'MGR00002'),
('WH0004', 950000, 'No.89/125, Silawathura, Puttalam\r\n', 'SUP00004', 'MGR00002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`psnNo`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`matNo`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`psnNo`),
  ADD UNIQUE KEY `nic` (`nic`);

--
-- Indexes for table `sply_mat`
--
ALTER TABLE `sply_mat`
  ADD PRIMARY KEY (`splNo`,`matNo`),
  ADD KEY `FK_sply_mat_matNo` (`matNo`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`whNo`,`matNo`),
  ADD KEY `FK_stock_matNo` (`matNo`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`splNo`);

--
-- Indexes for table `supply`
--
ALTER TABLE `supply`
  ADD PRIMARY KEY (`grnNo`,`matNo`),
  ADD KEY `FK_supply_supNo` (`splNo`),
  ADD KEY `FK_supply_matNo` (`matNo`),
  ADD KEY `FK_supply_whNo` (`whNo`);

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`whNo`),
  ADD UNIQUE KEY `supNo` (`supNo`),
  ADD KEY `FK_warehouse_mgrNo` (`mgrNo`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `FK_login_psnNo` FOREIGN KEY (`psnNo`) REFERENCES `person` (`psnNo`);

--
-- Constraints for table `sply_mat`
--
ALTER TABLE `sply_mat`
  ADD CONSTRAINT `FK_sply_mat_matNo` FOREIGN KEY (`matNo`) REFERENCES `material` (`matNo`),
  ADD CONSTRAINT `FK_sply_mat_supNo` FOREIGN KEY (`splNo`) REFERENCES `supplier` (`splNo`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `FK_stock_matNo` FOREIGN KEY (`matNo`) REFERENCES `material` (`matNo`),
  ADD CONSTRAINT `FK_stock_whNo` FOREIGN KEY (`whNo`) REFERENCES `warehouse` (`whNo`);

--
-- Constraints for table `supply`
--
ALTER TABLE `supply`
  ADD CONSTRAINT `FK_supply_matNo` FOREIGN KEY (`matNo`) REFERENCES `material` (`matNo`),
  ADD CONSTRAINT `FK_supply_supNo` FOREIGN KEY (`splNo`) REFERENCES `supplier` (`splNo`),
  ADD CONSTRAINT `FK_supply_whNo` FOREIGN KEY (`whNo`) REFERENCES `warehouse` (`whNo`);

--
-- Constraints for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD CONSTRAINT `FK_warehouse_mgrNo` FOREIGN KEY (`mgrNo`) REFERENCES `person` (`psnNo`),
  ADD CONSTRAINT `FK_warehouse_supNo` FOREIGN KEY (`supNo`) REFERENCES `person` (`psnNo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
