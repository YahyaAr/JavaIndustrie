# ************************************************************
# Sequel Pro SQL dump
# Version 4135
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.42)
# Database: JavaIndustrie
# Generation Time: 2016-06-13 15:21:38 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table box
# ------------------------------------------------------------

DROP TABLE IF EXISTS `box`;

CREATE TABLE `box` (
  `id` varchar(255) NOT NULL,
  `hauteur` int(11) DEFAULT NULL,
  `longueur` int(11) DEFAULT NULL,
  `prixBox` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `box` WRITE;
/*!40000 ALTER TABLE `box` DISABLE KEYS */;

INSERT INTO `box` (`id`, `hauteur`, `longueur`, `prixBox`, `quantite`)
VALUES
	('B001',300,190,41.1,NULL),
	('B002',150,290,41,NULL),
	('B003',130,190,42.6,NULL);

/*!40000 ALTER TABLE `box` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table commande
# ------------------------------------------------------------

DROP TABLE IF EXISTS `commande`;

CREATE TABLE `commande` (
  `id` varchar(255) NOT NULL,
  `dEnvoi` int(11) DEFAULT NULL,
  `dEnvoiPrevue` int(11) DEFAULT NULL,
  `nb` int(11) DEFAULT NULL,
  `penalite` double DEFAULT NULL,
  `stockMin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;

INSERT INTO `commande` (`id`, `dEnvoi`, `dEnvoiPrevue`, `nb`, `penalite`, `stockMin`)
VALUES
	('C001',0,348,NULL,0.4,5),
	('C002',0,1402,NULL,0.2,6),
	('C003',0,6939,NULL,0.4,15),
	('C004',0,1210,NULL,0.2,18),
	('C005',0,2383,NULL,0.3,9),
	('C006',0,404,NULL,0.5,9),
	('C007',0,3687,NULL,0.5,9),
	('C008',0,998,NULL,0.4,8),
	('C009',0,2483,NULL,0.35,5),
	('C010',0,6870,NULL,0.3,7),
	('C011',0,4793,NULL,0.2,12),
	('C012',0,2130,NULL,0.45,15),
	('C013',0,2309,NULL,0.4,11),
	('C014',0,1759,NULL,0.4,16),
	('C015',0,543,NULL,0.2,10),
	('C016',0,2006,NULL,0.35,5),
	('C017',0,1064,NULL,0.2,10),
	('C018',0,3564,NULL,0.25,6),
	('C019',0,5259,NULL,0.5,9),
	('C020',0,2537,NULL,0.5,12),
	('C021',0,686,NULL,0.35,12),
	('C022',0,3579,NULL,0.5,13),
	('C023',0,3491,NULL,0.2,19),
	('C024',0,780,NULL,0.45,19),
	('C025',0,1962,NULL,0.45,8),
	('C026',0,5707,NULL,0.45,7),
	('C027',0,5328,NULL,0.2,12),
	('C028',0,4568,NULL,0.4,16),
	('C029',0,3230,NULL,0.1,6),
	('C030',0,4486,NULL,0.25,15),
	('C031',0,6276,NULL,0.3,5),
	('C032',0,1682,NULL,0.25,8),
	('C033',0,3533,NULL,0.25,8),
	('C034',0,5415,NULL,0.4,11),
	('C035',0,5614,NULL,0.25,18),
	('C036',0,4300,NULL,0.35,6),
	('C037',0,1525,NULL,0.4,11),
	('C038',0,1634,NULL,0.4,8),
	('C039',0,5250,NULL,0.4,10),
	('C040',0,7330,NULL,0.2,19),
	('C041',0,5642,NULL,0.3,19),
	('C042',0,3408,NULL,0.45,6),
	('C043',0,2488,NULL,0.25,11),
	('C044',0,5983,NULL,0.35,6),
	('C045',0,114,NULL,0.3,12),
	('C046',0,234,NULL,0.5,16),
	('C047',0,1168,NULL,0.1,18),
	('C048',0,4510,NULL,0.35,13),
	('C049',0,1022,NULL,0.2,6),
	('C050',0,4254,NULL,0.3,5),
	('C051',0,6158,NULL,0.35,11),
	('C052',0,2627,NULL,0.35,13),
	('C053',0,2078,NULL,0.1,12),
	('C054',0,4547,NULL,0.25,16),
	('C055',0,4534,NULL,0.9,17),
	('C056',0,3079,NULL,0.4,17),
	('C057',0,7762,NULL,0.35,13),
	('C058',0,5199,NULL,0.3,18),
	('C059',0,3420,NULL,0.5,19),
	('C060',0,5730,NULL,0.25,10),
	('C061',0,4728,NULL,0.35,11),
	('C062',0,4450,NULL,0.15,15),
	('C063',0,578,NULL,0.6,8),
	('C064',0,3616,NULL,0.45,6),
	('C065',0,6931,NULL,0.35,13),
	('C066',0,5669,NULL,0.45,15),
	('C067',0,2500,NULL,0.35,12),
	('C068',0,5544,NULL,0.2,12),
	('C069',0,1220,NULL,0.35,8),
	('C070',0,4850,NULL,0.5,19),
	('C071',0,3405,NULL,0.25,18),
	('C072',0,6284,NULL,0.45,7),
	('C073',0,1406,NULL,0.35,19),
	('C074',0,2905,NULL,0.4,9),
	('C075',0,2200,NULL,0.2,8),
	('C076',0,586,NULL,0.2,16),
	('C077',0,3894,NULL,0.4,5),
	('C078',0,4709,NULL,0.25,7),
	('C079',0,7659,NULL,0.2,11),
	('C080',0,896,NULL,0.2,19),
	('C081',0,3736,NULL,0.15,13),
	('C082',0,4295,NULL,0.3,13),
	('C083',0,1435,NULL,0.45,5),
	('C084',0,6717,NULL,0.35,10),
	('C085',0,516,NULL,0.3,9),
	('C086',0,1239,NULL,0.3,6),
	('C087',0,7457,NULL,0.3,12),
	('C088',0,1407,NULL,0.35,18),
	('C089',0,4764,NULL,0.35,10),
	('C090',0,6021,NULL,0.3,19),
	('C091',0,880,NULL,0.2,14),
	('C092',0,366,NULL,0.35,18),
	('C093',0,6262,NULL,0.3,10),
	('C094',0,1700,NULL,0.25,11),
	('C095',0,2890,NULL,0.4,7),
	('C096',0,4207,NULL,0.5,15),
	('C097',0,6921,NULL,0.25,12),
	('C098',0,6210,NULL,0.25,18),
	('C099',0,661,NULL,0.3,17),
	('C100',0,2407,NULL,0.3,15);

/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table commandeDetails
# ------------------------------------------------------------

DROP TABLE IF EXISTS `commandeDetails`;

CREATE TABLE `commandeDetails` (
  `id` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `idCommande` varchar(255) DEFAULT NULL,
  `idProduit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_commandeDetails_idProduit` (`idProduit`),
  KEY `FK_commandeDetails_idCommande` (`idCommande`),
  CONSTRAINT `FK_commandeDetails_idCommande` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`id`),
  CONSTRAINT `FK_commandeDetails_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `commandeDetails` WRITE;
/*!40000 ALTER TABLE `commandeDetails` DISABLE KEYS */;

INSERT INTO `commandeDetails` (`id`, `quantite`, `idCommande`, `idProduit`)
VALUES
	(1,2,'C001','P003'),
	(2,2,'C001','P005'),
	(3,3,'C002','P003'),
	(4,1,'C002','P006'),
	(5,3,'C003','P003'),
	(6,1,'C003','P005'),
	(7,5,'C003','P006'),
	(8,2,'C003','P007'),
	(9,3,'C004','P003'),
	(10,1,'C004','P006'),
	(11,6,'C004','P007'),
	(12,1,'C005','P001'),
	(13,1,'C005','P002'),
	(14,1,'C006','P002'),
	(15,1,'C006','P003'),
	(16,1,'C006','P004'),
	(17,1,'C006','P005'),
	(18,1,'C006','P006'),
	(19,1,'C007','P002'),
	(20,3,'C007','P003'),
	(21,1,'C007','P004'),
	(22,2,'C007','P005'),
	(23,2,'C007','P006'),
	(24,1,'C008','P001'),
	(25,1,'C008','P004'),
	(26,1,'C008','P005'),
	(27,3,'C008','P006'),
	(28,2,'C008','P007'),
	(29,2,'C009','P001'),
	(30,2,'C009','P002'),
	(31,1,'C010','P001'),
	(32,1,'C010','P002'),
	(33,1,'C010','P003'),
	(34,1,'C010','P006'),
	(35,2,'C010','P007'),
	(36,1,'C011','P002'),
	(37,5,'C011','P003'),
	(38,1,'C011','P006'),
	(39,6,'C011','P007'),
	(40,1,'C012','P002'),
	(41,1,'C012','P005'),
	(42,1,'C012','P006'),
	(43,3,'C013','P002'),
	(44,1,'C013','P003'),
	(45,1,'C013','P004'),
	(46,2,'C013','P006'),
	(47,2,'C013','P007'),
	(48,1,'C014','P001'),
	(49,2,'C014','P003'),
	(50,3,'C014','P004'),
	(51,4,'C014','P006'),
	(52,1,'C014','P007'),
	(53,3,'C015','P004'),
	(54,3,'C015','P007'),
	(55,1,'C016','P001'),
	(56,1,'C016','P003'),
	(57,1,'C016','P004'),
	(58,1,'C016','P005'),
	(59,1,'C016','P006'),
	(60,1,'C017','P005'),
	(61,2,'C017','P007'),
	(62,1,'C018','P002'),
	(63,1,'C019','P001'),
	(64,2,'C019','P002'),
	(65,3,'C019','P004'),
	(66,1,'C019','P005'),
	(67,2,'C019','P007'),
	(68,2,'C020','P001'),
	(69,1,'C020','P002'),
	(70,2,'C020','P004'),
	(71,2,'C020','P006'),
	(72,2,'C020','P007'),
	(73,3,'C021','P003'),
	(74,4,'C021','P004'),
	(75,1,'C021','P005'),
	(76,1,'C021','P006'),
	(77,1,'C021','P007'),
	(78,1,'C022','P001'),
	(79,2,'C022','P003'),
	(80,2,'C022','P004'),
	(81,5,'C022','P006'),
	(82,4,'C022','P007'),
	(83,2,'C023','P003'),
	(84,1,'C023','P005'),
	(85,5,'C024','P002'),
	(86,2,'C024','P005'),
	(87,1,'C025','P001'),
	(88,1,'C025','P002'),
	(89,3,'C025','P003'),
	(90,1,'C025','P006'),
	(91,1,'C026','P003'),
	(92,2,'C026','P004'),
	(93,1,'C026','P006'),
	(94,1,'C027','P004'),
	(95,1,'C027','P006'),
	(96,5,'C027','P007'),
	(97,2,'C028','P001'),
	(98,5,'C028','P003'),
	(99,2,'C028','P006'),
	(100,8,'C028','P007'),
	(101,1,'C029','P002'),
	(102,1,'C030','P002'),
	(103,3,'C030','P003'),
	(104,4,'C030','P007'),
	(105,2,'C031','P002'),
	(106,2,'C031','P003'),
	(107,1,'C031','P004'),
	(108,1,'C031','P006'),
	(109,1,'C032','P002'),
	(110,3,'C033','P002'),
	(111,3,'C034','P002'),
	(112,1,'C034','P003'),
	(113,1,'C034','P004'),
	(114,2,'C034','P006'),
	(115,5,'C034','P007'),
	(116,3,'C035','P003'),
	(117,1,'C035','P004'),
	(118,6,'C035','P007'),
	(119,1,'C036','P001'),
	(120,2,'C036','P002'),
	(121,1,'C037','P001'),
	(122,1,'C037','P002'),
	(123,2,'C037','P006'),
	(124,4,'C037','P007'),
	(125,3,'C038','P003'),
	(126,1,'C038','P004'),
	(127,3,'C038','P005'),
	(128,1,'C038','P006'),
	(129,1,'C039','P003'),
	(130,1,'C039','P004'),
	(131,3,'C039','P005'),
	(132,1,'C039','P006'),
	(133,3,'C039','P007'),
	(134,2,'C040','P002'),
	(135,1,'C040','P004'),
	(136,4,'C040','P007'),
	(137,1,'C041','P003'),
	(138,4,'C041','P004'),
	(139,1,'C041','P007'),
	(140,1,'C042','P001'),
	(141,2,'C042','P002'),
	(142,2,'C042','P003'),
	(143,2,'C042','P004'),
	(144,1,'C042','P006'),
	(145,8,'C042','P007'),
	(146,5,'C043','P003'),
	(147,1,'C043','P004'),
	(148,1,'C043','P006'),
	(149,7,'C043','P007'),
	(150,1,'C044','P001'),
	(151,2,'C044','P002'),
	(152,1,'C044','P003'),
	(153,1,'C044','P004'),
	(154,2,'C045','P003'),
	(155,2,'C045','P005'),
	(156,1,'C045','P006'),
	(157,3,'C045','P007'),
	(158,4,'C046','P002'),
	(159,1,'C046','P003'),
	(160,2,'C046','P004'),
	(161,4,'C046','P007'),
	(162,4,'C047','P003'),
	(163,3,'C047','P007'),
	(164,1,'C048','P003'),
	(165,2,'C048','P005'),
	(166,1,'C048','P006'),
	(167,1,'C048','P007'),
	(168,1,'C049','P001'),
	(169,1,'C049','P003'),
	(170,1,'C049','P004'),
	(171,1,'C050','P001'),
	(172,2,'C050','P003'),
	(173,1,'C050','P004'),
	(174,2,'C050','P007'),
	(175,2,'C051','P001'),
	(176,1,'C051','P003'),
	(177,2,'C051','P004'),
	(178,2,'C052','P003'),
	(179,4,'C052','P004'),
	(180,7,'C052','P007'),
	(181,1,'C053','P003'),
	(182,1,'C053','P006'),
	(183,1,'C054','P001'),
	(184,1,'C054','P006'),
	(185,3,'C055','P001'),
	(186,1,'C055','P002'),
	(187,3,'C056','P001'),
	(188,1,'C056','P003'),
	(189,1,'C056','P005'),
	(190,1,'C056','P006'),
	(191,6,'C056','P007'),
	(192,2,'C057','P003'),
	(193,1,'C057','P004'),
	(194,2,'C057','P005'),
	(195,1,'C057','P006'),
	(196,1,'C058','P001'),
	(197,3,'C058','P003'),
	(198,2,'C058','P004'),
	(199,2,'C058','P007'),
	(200,3,'C059','P003'),
	(201,5,'C059','P004'),
	(202,1,'C059','P005'),
	(203,1,'C059','P006'),
	(204,4,'C059','P007'),
	(205,1,'C060','P002'),
	(206,7,'C060','P003'),
	(207,1,'C060','P004'),
	(208,1,'C060','P006'),
	(209,9,'C060','P007'),
	(210,1,'C061','P001'),
	(211,1,'C061','P002'),
	(212,3,'C061','P003'),
	(213,2,'C061','P004'),
	(214,14,'C061','P007'),
	(215,4,'C062','P003'),
	(216,5,'C062','P007'),
	(217,4,'C063','P001'),
	(218,1,'C063','P004'),
	(219,1,'C064','P002'),
	(220,4,'C064','P003'),
	(221,3,'C064','P004'),
	(222,3,'C064','P006'),
	(223,1,'C065','P001'),
	(224,1,'C065','P002'),
	(225,4,'C065','P003'),
	(226,1,'C065','P004'),
	(227,2,'C065','P006'),
	(228,5,'C065','P007'),
	(229,4,'C066','P002'),
	(230,1,'C066','P003'),
	(231,3,'C066','P004'),
	(232,2,'C066','P005'),
	(233,2,'C066','P007'),
	(234,1,'C067','P001'),
	(235,2,'C067','P002'),
	(236,3,'C067','P003'),
	(237,1,'C067','P006'),
	(238,6,'C067','P007'),
	(239,3,'C068','P003'),
	(240,1,'C069','P002'),
	(241,1,'C069','P004'),
	(242,2,'C069','P006'),
	(243,2,'C069','P007'),
	(244,2,'C070','P001'),
	(245,2,'C070','P003'),
	(246,1,'C070','P004'),
	(247,3,'C070','P006'),
	(248,1,'C071','P001'),
	(249,4,'C071','P003'),
	(250,1,'C071','P006'),
	(251,2,'C071','P007'),
	(252,2,'C072','P001'),
	(253,2,'C072','P006'),
	(254,1,'C073','P003'),
	(255,1,'C073','P004'),
	(256,2,'C073','P006'),
	(257,1,'C074','P001'),
	(258,1,'C074','P002'),
	(259,3,'C074','P003'),
	(260,2,'C074','P006'),
	(261,2,'C074','P007'),
	(262,1,'C075','P002'),
	(263,1,'C075','P004'),
	(264,1,'C076','P005'),
	(265,2,'C076','P007'),
	(266,1,'C077','P001'),
	(267,1,'C077','P002'),
	(268,1,'C077','P003'),
	(269,1,'C077','P004'),
	(270,1,'C077','P006'),
	(271,3,'C077','P007'),
	(272,1,'C078','P001'),
	(273,4,'C078','P003'),
	(274,3,'C078','P004'),
	(275,4,'C078','P007'),
	(276,1,'C079','P002'),
	(277,6,'C079','P003'),
	(278,1,'C079','P006'),
	(279,7,'C079','P007'),
	(280,1,'C080','P003'),
	(281,3,'C080','P007'),
	(282,1,'C081','P004'),
	(283,4,'C081','P007'),
	(284,1,'C082','P001'),
	(285,2,'C082','P002'),
	(286,4,'C082','P003'),
	(287,10,'C082','P007'),
	(288,1,'C083','P001'),
	(289,1,'C083','P002'),
	(290,2,'C083','P003'),
	(291,1,'C083','P004'),
	(292,3,'C083','P005'),
	(293,2,'C083','P007'),
	(294,1,'C084','P002'),
	(295,2,'C084','P003'),
	(296,2,'C084','P005'),
	(297,11,'C084','P007'),
	(298,1,'C085','P003'),
	(299,1,'C085','P004'),
	(300,1,'C085','P005'),
	(301,2,'C085','P006'),
	(302,1,'C086','P003'),
	(303,1,'C086','P005'),
	(304,1,'C086','P006'),
	(305,1,'C087','P001'),
	(306,1,'C087','P002'),
	(307,2,'C087','P003'),
	(308,1,'C087','P004'),
	(309,2,'C087','P007'),
	(310,2,'C088','P001'),
	(311,2,'C089','P001'),
	(312,1,'C089','P002'),
	(313,3,'C089','P003'),
	(314,2,'C089','P004'),
	(315,3,'C089','P006'),
	(316,8,'C089','P007'),
	(317,1,'C090','P005'),
	(318,1,'C091','P001'),
	(319,1,'C091','P003'),
	(320,2,'C091','P007'),
	(321,2,'C092','P003'),
	(322,1,'C092','P004'),
	(323,1,'C092','P005'),
	(324,1,'C092','P006'),
	(325,5,'C092','P007'),
	(326,6,'C093','P003'),
	(327,1,'C093','P005'),
	(328,1,'C093','P006'),
	(329,11,'C093','P007'),
	(330,1,'C094','P001'),
	(331,2,'C094','P002'),
	(332,5,'C094','P003'),
	(333,3,'C094','P007'),
	(334,3,'C095','P003'),
	(335,4,'C095','P004'),
	(336,2,'C095','P006'),
	(337,2,'C095','P007'),
	(338,2,'C096','P001'),
	(339,3,'C096','P002'),
	(340,1,'C096','P004'),
	(341,1,'C096','P006'),
	(342,1,'C097','P002'),
	(343,2,'C097','P003'),
	(344,6,'C097','P007'),
	(345,3,'C098','P002'),
	(346,1,'C099','P003'),
	(347,1,'C099','P005'),
	(348,3,'C099','P006'),
	(349,3,'C099','P007'),
	(350,2,'C100','P004'),
	(351,2,'C100','P006'),
	(352,4,'C100','P007');

/*!40000 ALTER TABLE `commandeDetails` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table instanceBox
# ------------------------------------------------------------

DROP TABLE IF EXISTS `instanceBox`;

CREATE TABLE `instanceBox` (
  `id` int(11) NOT NULL,
  `libre` int(11) DEFAULT NULL,
  `num_box` int(11) DEFAULT NULL,
  `idBox` varchar(255) DEFAULT NULL,
  `idProduit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_instanceBox_idProduit` (`idProduit`),
  KEY `FK_instanceBox_idBox` (`idBox`),
  CONSTRAINT `FK_instanceBox_idBox` FOREIGN KEY (`idBox`) REFERENCES `box` (`id`),
  CONSTRAINT `FK_instanceBox_idProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table ligne_production
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ligne_production`;

CREATE TABLE `ligne_production` (
  `id` int(11) NOT NULL,
  `nbLignes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `ligne_production` WRITE;
/*!40000 ALTER TABLE `ligne_production` DISABLE KEYS */;

INSERT INTO `ligne_production` (`id`, `nbLignes`)
VALUES
	(1,1),
	(2,2);

/*!40000 ALTER TABLE `ligne_production` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table produit
# ------------------------------------------------------------

DROP TABLE IF EXISTS `produit`;

CREATE TABLE `produit` (
  `id` varchar(255) NOT NULL,
  `hauteur` int(11) DEFAULT NULL,
  `longueur` int(11) DEFAULT NULL,
  `nbEmpileMax` int(11) DEFAULT NULL,
  `t_production` int(11) DEFAULT NULL,
  `t_setup` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;

INSERT INTO `produit` (`id`, `hauteur`, `longueur`, `nbEmpileMax`, `t_production`, `t_setup`)
VALUES
	('P001',115,165,2,9,14),
	('P002',85,160,3,12,11),
	('P003',95,50,1,19,10),
	('P004',95,95,1,7,24),
	('P005',105,180,2,10,17),
	('P006',115,125,1,16,16),
	('P007',55,70,4,16,11);

/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table produitBaked
# ------------------------------------------------------------

DROP TABLE IF EXISTS `produitBaked`;

CREATE TABLE `produitBaked` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCommandeDetails` int(11) NOT NULL,
  `dateDebutProd` int(11) DEFAULT NULL,
  `nbLigne` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idCommandeDetail` (`idCommandeDetails`),
  KEY `fk_ligneProd` (`nbLigne`),
  CONSTRAINT `produitbaked_ibfk_2` FOREIGN KEY (`nbLigne`) REFERENCES `ligne_production` (`id`),
  CONSTRAINT `produitbaked_ibfk_1` FOREIGN KEY (`idCommandeDetails`) REFERENCES `commandeDetails` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table SEQUENCE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `SEQUENCE`;

CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `SEQUENCE` WRITE;
/*!40000 ALTER TABLE `SEQUENCE` DISABLE KEYS */;

INSERT INTO `SEQUENCE` (`SEQ_NAME`, `SEQ_COUNT`)
VALUES
	('SEQ_GEN',400);

/*!40000 ALTER TABLE `SEQUENCE` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
