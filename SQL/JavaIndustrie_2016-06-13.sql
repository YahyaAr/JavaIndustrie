-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 15, 2016 at 02:40 AM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `JavaIndustrie`
--

-- --------------------------------------------------------

--
-- Table structure for table `box`
--

CREATE TABLE `box` (
  `id` varchar(255) NOT NULL,
  `hauteur` int(11) DEFAULT NULL,
  `longueur` int(11) DEFAULT NULL,
  `prixBox` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE `commande` (
  `id` varchar(255) NOT NULL,
  `dEnvoi` int(11) DEFAULT NULL,
  `dEnvoiPrevue` int(11) DEFAULT NULL,
  `nb` int(11) DEFAULT NULL,
  `penalite` double DEFAULT NULL,
  `stockMin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `commandeDetails`
--

CREATE TABLE `commandeDetails` (
  `id` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `idCommande` varchar(255) DEFAULT NULL,
  `idProduit` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instanceBox`
--

CREATE TABLE `instanceBox` (
  `id` int(11) NOT NULL,
  `libre` int(11) DEFAULT NULL,
  `num_box` int(11) DEFAULT NULL,
  `idBox` varchar(255) DEFAULT NULL,
  `idCommandeDetails` int(11) DEFAULT NULL,
  `idProduitBaked` int(11) DEFAULT NULL,
  `idProduit` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ligne_production`
--

CREATE TABLE `ligne_production` (
  `id` int(11) NOT NULL,
  `nbLignes` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id` varchar(255) NOT NULL,
  `hauteur` int(11) DEFAULT NULL,
  `longueur` int(11) DEFAULT NULL,
  `nbEmpileMax` int(11) DEFAULT NULL,
  `t_production` int(11) DEFAULT NULL,
  `t_setup` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produitBaked`
--

CREATE TABLE `produitBaked` (
  `id` int(11) NOT NULL,
  `dateDebutProd` int(11) DEFAULT NULL,
  `idCommandeDetails` int(11) DEFAULT NULL,
  `nbLigne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SEQUENCE`
--

CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `box`
--
ALTER TABLE `box`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `commandeDetails`
--
ALTER TABLE `commandeDetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_commandeDetails_idProduit` (`idProduit`),
  ADD KEY `FK_commandeDetails_idCommande` (`idCommande`);

--
-- Indexes for table `instanceBox`
--
ALTER TABLE `instanceBox`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_instanceBox_idCommandeDetails` (`idCommandeDetails`),
  ADD KEY `FK_instanceBox_idProduitBaked` (`idProduitBaked`),
  ADD KEY `FK_instanceBox_idProduit` (`idProduit`),
  ADD KEY `FK_instanceBox_idBox` (`idBox`);

--
-- Indexes for table `ligne_production`
--
ALTER TABLE `ligne_production`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produitBaked`
--
ALTER TABLE `produitBaked`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_produitBaked_idCommandeDetails` (`idCommandeDetails`),
  ADD KEY `FK_produitBaked_nbLigne` (`nbLigne`);

--
-- Indexes for table `SEQUENCE`
--
ALTER TABLE `SEQUENCE`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `produitBaked`
--
ALTER TABLE `produitBaked`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `commandeDetails`
--
ALTER TABLE `commandeDetails`
  ADD CONSTRAINT `FK_commandeDetails_idCommande` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `FK_commandeDetails_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`id`);

--
-- Constraints for table `instanceBox`
--
ALTER TABLE `instanceBox`
  ADD CONSTRAINT `FK_instanceBox_idBox` FOREIGN KEY (`idBox`) REFERENCES `box` (`id`),
  ADD CONSTRAINT `FK_instanceBox_idCommandeDetails` FOREIGN KEY (`idCommandeDetails`) REFERENCES `commandeDetails` (`id`),
  ADD CONSTRAINT `FK_instanceBox_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `FK_instanceBox_idProduitBaked` FOREIGN KEY (`idProduitBaked`) REFERENCES `produitBaked` (`id`);

--
-- Constraints for table `produitBaked`
--
ALTER TABLE `produitBaked`
  ADD CONSTRAINT `FK_produitBaked_nbLigne` FOREIGN KEY (`nbLigne`) REFERENCES `ligne_production` (`id`),
  ADD CONSTRAINT `FK_produitBaked_idCommandeDetails` FOREIGN KEY (`idCommandeDetails`) REFERENCES `commandeDetails` (`id`);
