-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: subjorel
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Table structure for table `categoria_joya_05`
--

DROP TABLE IF EXISTS `categoria_joya_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria_joya_05` (
  `CATEGORIA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(32) DEFAULT NULL,
  `DESCRIPCION` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`CATEGORIA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_joya_05`
--

LOCK TABLES `categoria_joya_05` WRITE;
/*!40000 ALTER TABLE `categoria_joya_05` DISABLE KEYS */;
INSERT INTO `categoria_joya_05` VALUES (1,'Joyas','--'),(2,'Aretes','--'),(3,'Reloj','--'),(4,'Otros','--');
/*!40000 ALTER TABLE `categoria_joya_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_personales_05`
--

DROP TABLE IF EXISTS `datos_personales_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_personales_05` (
  `DATOS_PERSONALES_ID` varchar(15) NOT NULL,
  `NICK` varchar(25) NOT NULL,
  `NOMBRE` varchar(64) NOT NULL,
  `APELLIDO` varchar(64) NOT NULL,
  `SEXO` varchar(1) NOT NULL,
  `DIRECCION` varchar(128) NOT NULL,
  `TELEFONO` varchar(10) NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  `EMAIL` varchar(128) NOT NULL,
  PRIMARY KEY (`DATOS_PERSONALES_ID`),
  KEY `FK_REFERENCE_9` (`NICK`),
  CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`NICK`) REFERENCES `usuario_05` (`NICK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_personales_05`
--

LOCK TABLES `datos_personales_05` WRITE;
/*!40000 ALTER TABLE `datos_personales_05` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_personales_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joya_05`
--

DROP TABLE IF EXISTS `joya_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `joya_05` (
  `JOYA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORIA_ID` int(11) NOT NULL,
  `NOMBRE` varchar(64) DEFAULT NULL,
  `IMAGEN` binary(128) DEFAULT NULL,
  `DESCRIPCION` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`JOYA_ID`),
  KEY `FK_REFERENCE_23` (`CATEGORIA_ID`),
  CONSTRAINT `FK_REFERENCE_23` FOREIGN KEY (`CATEGORIA_ID`) REFERENCES `categoria_joya_05` (`CATEGORIA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joya_05`
--

LOCK TABLES `joya_05` WRITE;
/*!40000 ALTER TABLE `joya_05` DISABLE KEYS */;
INSERT INTO `joya_05` VALUES (2,1,'awd',NULL,'wqe'),(3,2,'Aretes de oro',NULL,'--'),(4,1,'aretes de oro 24k',NULL,'oro puro'),(5,3,'reloj de puro oro 24k',NULL,'oro puro');
/*!40000 ALTER TABLE `joya_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento_05`
--

DROP TABLE IF EXISTS `movimiento_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento_05` (
  `MOVIMIENTO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NICK` varchar(32) DEFAULT NULL,
  `MONTO` decimal(8,2) DEFAULT NULL,
  `SALDO` decimal(8,2) DEFAULT NULL,
  `FECHA_MOVIMIENTO` datetime DEFAULT NULL,
  PRIMARY KEY (`MOVIMIENTO_ID`),
  KEY `FK_REFERENCE_16` (`NICK`),
  CONSTRAINT `FK_REFERENCE_16` FOREIGN KEY (`NICK`) REFERENCES `usuario_05` (`NICK`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_05`
--

LOCK TABLES `movimiento_05` WRITE;
/*!40000 ALTER TABLE `movimiento_05` DISABLE KEYS */;
INSERT INTO `movimiento_05` VALUES (1,'carlos',0.50,100.00,'2016-01-14 00:00:00');
/*!40000 ALTER TABLE `movimiento_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puja_05`
--

DROP TABLE IF EXISTS `puja_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puja_05` (
  `PUJA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MOVIMIENTO_ID` int(11) NOT NULL,
  `SUSCRIPCION_ID` int(11) DEFAULT NULL,
  `MONTO` decimal(8,2) NOT NULL,
  `FECHA` date NOT NULL,
  `ORDEN_PUJA` int(11) NOT NULL,
  PRIMARY KEY (`PUJA_ID`),
  KEY `FK_REFERENCE_12` (`MOVIMIENTO_ID`),
  KEY `FK_REFERENCE_13` (`SUSCRIPCION_ID`),
  CONSTRAINT `FK_REFERENCE_12` FOREIGN KEY (`MOVIMIENTO_ID`) REFERENCES `movimiento_05` (`MOVIMIENTO_ID`),
  CONSTRAINT `FK_REFERENCE_13` FOREIGN KEY (`SUSCRIPCION_ID`) REFERENCES `suscripcion_subasta_05` (`SUSCRIPCION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puja_05`
--

LOCK TABLES `puja_05` WRITE;
/*!40000 ALTER TABLE `puja_05` DISABLE KEYS */;
INSERT INTO `puja_05` VALUES (1,1,1,10.00,'2016-01-14',1),(2,1,1,10.00,'2016-01-14',2);
/*!40000 ALTER TABLE `puja_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subasta_05`
--

DROP TABLE IF EXISTS `subasta_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subasta_05` (
  `SUBASTA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOYA_ID` int(11) NOT NULL,
  `MOVIMIENTO_ID` int(11) DEFAULT NULL,
  `NICK` varchar(32) DEFAULT NULL,
  `PRECIO_BASE` decimal(8,2) DEFAULT NULL,
  `MONTO_FINAL` decimal(8,2) DEFAULT NULL,
  `FECHA_INICIO` datetime DEFAULT NULL,
  `FECHA_FIN` datetime DEFAULT NULL,
  `CATEGORIA` varchar(1) DEFAULT NULL,
  `TIEMPO` time DEFAULT NULL,
  `INCREMENTO` decimal(8,2) DEFAULT NULL,
  `INCREMENTO_ACTUAL` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`SUBASTA_ID`),
  KEY `FK_REFERENCE_10` (`NICK`),
  KEY `FK_REFERENCE_11` (`MOVIMIENTO_ID`),
  KEY `FK_REFERENCE_26` (`JOYA_ID`),
  CONSTRAINT `FK_REFERENCE_10` FOREIGN KEY (`NICK`) REFERENCES `usuario_05` (`NICK`),
  CONSTRAINT `FK_REFERENCE_11` FOREIGN KEY (`MOVIMIENTO_ID`) REFERENCES `movimiento_05` (`MOVIMIENTO_ID`),
  CONSTRAINT `FK_REFERENCE_26` FOREIGN KEY (`JOYA_ID`) REFERENCES `joya_05` (`JOYA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subasta_05`
--

LOCK TABLES `subasta_05` WRITE;
/*!40000 ALTER TABLE `subasta_05` DISABLE KEYS */;
INSERT INTO `subasta_05` VALUES (1,2,NULL,'carlos',50.00,NULL,NULL,'2016-01-27 00:00:00','D',NULL,NULL,NULL),(2,3,NULL,'carlos',58.00,NULL,NULL,'2016-01-15 00:00:00','D',NULL,NULL,NULL),(3,4,NULL,'carlos',32.00,NULL,NULL,'2016-01-16 00:00:00','D',NULL,26.00,26.00),(4,5,NULL,'carlos',100.00,NULL,NULL,'2016-01-16 00:00:00','D',NULL,10.00,10.00);
/*!40000 ALTER TABLE `subasta_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suscripcion_subasta_05`
--

DROP TABLE IF EXISTS `suscripcion_subasta_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suscripcion_subasta_05` (
  `SUSCRIPCION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NICK` varchar(32) NOT NULL,
  `SUBASTA_ID` int(11) NOT NULL,
  PRIMARY KEY (`SUSCRIPCION_ID`),
  KEY `FK_REFERENCE_27` (`NICK`),
  KEY `FK_REFERENCE_28` (`SUBASTA_ID`),
  CONSTRAINT `FK_REFERENCE_27` FOREIGN KEY (`NICK`) REFERENCES `usuario_05` (`NICK`),
  CONSTRAINT `FK_REFERENCE_28` FOREIGN KEY (`SUBASTA_ID`) REFERENCES `subasta_05` (`SUBASTA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suscripcion_subasta_05`
--

LOCK TABLES `suscripcion_subasta_05` WRITE;
/*!40000 ALTER TABLE `suscripcion_subasta_05` DISABLE KEYS */;
INSERT INTO `suscripcion_subasta_05` VALUES (1,'carlos',1),(2,'carlos',2);
/*!40000 ALTER TABLE `suscripcion_subasta_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_05`
--

DROP TABLE IF EXISTS `usuario_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_05` (
  `NICK` varchar(32) NOT NULL,
  `CLAVE` varchar(32) NOT NULL,
  `FECHA_CREACION` date DEFAULT NULL,
  `FECHA_ULTIMA_VISITA` date DEFAULT NULL,
  `NUMERO_VISITAS` int(11) DEFAULT NULL,
  `CREDITO` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`NICK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_05`
--

LOCK TABLES `usuario_05` WRITE;
/*!40000 ALTER TABLE `usuario_05` DISABLE KEYS */;
INSERT INTO `usuario_05` VALUES ('andres','567676',NULL,NULL,NULL,NULL),('carlos','123',NULL,NULL,NULL,NULL),('carmen','1817123',NULL,NULL,NULL,NULL),('juan','12313',NULL,NULL,NULL,NULL),('karen','19123',NULL,NULL,NULL,NULL),('katernie','45435345',NULL,NULL,NULL,NULL),('leonardo','435435',NULL,NULL,NULL,NULL),('pedro','171232',NULL,NULL,NULL,NULL),('pepe','17213',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario_05` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-14 11:17:17
