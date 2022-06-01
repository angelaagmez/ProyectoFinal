-- MariaDB dump 10.19  Distrib 10.6.4-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: plataformaexamenes
-- ------------------------------------------------------
-- Server version	10.6.4-MariaDB-1:10.6.4+maria~focal

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
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignatura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `curso` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `id_grado` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa0jdgb99wks5ow8nr45ormu7m` (`id_grado`),
  CONSTRAINT `FKa0jdgb99wks5ow8nr45ormu7m` FOREIGN KEY (`id_grado`) REFERENCES `grado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES (1,1,'Estudio de la cavidad oral',17),(2,2,'Dosimetría física y clínica',16),(4,1,'Ensayos fisicoquímicos',4),(5,2,'Ensayos biotecnológicos',15),(7,2,'Desarrollo web en entorno servidor',1),(8,1,'Bases de Datos',1);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examen`
--

DROP TABLE IF EXISTS `examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` date NOT NULL,
  `num_preguntas` int(11) DEFAULT NULL,
  `id_asignatura` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqq57kbxu6jbrrewxti6ttwj9k` (`id_asignatura`),
  KEY `FK1u52492jgrdp4m3iphfr0skpt` (`id_usuario`),
  CONSTRAINT `FK1u52492jgrdp4m3iphfr0skpt` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKqq57kbxu6jbrrewxti6ttwj9k` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examen`
--

LOCK TABLES `examen` WRITE;
/*!40000 ALTER TABLE `examen` DISABLE KEYS */;
INSERT INTO `examen` VALUES (2,'2021-04-06',3,7,1),(3,'2022-05-26',2,4,1),(4,'2020-04-10',0,8,3),(6,'2022-06-04',0,1,3);
/*!40000 ALTER TABLE `examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grado`
--

DROP TABLE IF EXISTS `grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `departamento` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grado`
--

LOCK TABLES `grado` WRITE;
/*!40000 ALTER TABLE `grado` DISABLE KEYS */;
INSERT INTO `grado` VALUES (1,'Informática','Desarrollo de Aplicaciones Web'),(2,'Informática','Administracion de Sistemas Informáticos en Red'),(3,'Química','Química Industrial'),(4,'Química','Laboratorio de Análisis y de Control de Calidad'),(5,'Hostelería y Turismo','Agencias de Viajes y Gestión de Eventos'),(6,'Hostelería y Turismo','Dirección de Cocina'),(7,'Hostelería y Turismo','Guía, Información y Asistencias Turísticas'),(8,'Actividades Físicas y Deportivas ','Enseñanza y Animación Sociodeportiva'),(9,'Actividades Físicas y Deportivas ','Acondicionamiento Físico'),(10,'Administración y Gestión ','Administración y Finanzas'),(11,'Comercio y Marketing ','Marketing y Publicidad'),(12,'Comercio y Marketing ','Comercio Internacional'),(13,'Electricidad y Electrónica ','Sistemas de Telecomunicaciones e Informáticos'),(14,'Electricidad y Electrónica ','Automatización y Robótica Industrial'),(15,'Sanidad','Laboratorio Clínico y Biomédico'),(16,'Sanidad','Radioterapia y Dosimetría'),(17,'Sanidad','Higiene Bucodental'),(18,'Sanidad','Dietética'),(19,'Sanidad','Anatomía Patológica y Citodiagnóstico'),(20,'Transporte y Mantenimiento de Vehículos ','Automoción'),(21,'Servicios Socioculturales y a la Comunidad ','Educación Infantil'),(22,'Servicios Socioculturales y a la Comunidad ','Integración Social');
/*!40000 ALTER TABLE `grado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricularse`
--

DROP TABLE IF EXISTS `matricularse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricularse` (
  `num_alumnos` int(11) NOT NULL,
  `id_usuario` bigint(20) NOT NULL,
  `id_asignatura` bigint(20) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_asignatura`),
  KEY `FKelu6camvy5mds8uktri53ia7o` (`id_asignatura`),
  CONSTRAINT `FKelu6camvy5mds8uktri53ia7o` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id`),
  CONSTRAINT `FKnscj5dstbjulk8x9df0u350bj` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricularse`
--

LOCK TABLES `matricularse` WRITE;
/*!40000 ALTER TABLE `matricularse` DISABLE KEYS */;
INSERT INTO `matricularse` VALUES (14,1,4),(20,1,7),(10,3,1),(13,3,2),(17,3,8);
/*!40000 ALTER TABLE `matricularse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregunta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num_pregunta` int(11) NOT NULL,
  `preguntas` varchar(255) NOT NULL,
  `respuestas` varchar(255) NOT NULL,
  `id_examen` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr5h0q267ur6wgli5kkjopx4sh` (`id_examen`),
  CONSTRAINT `FKr5h0q267ur6wgli5kkjopx4sh` FOREIGN KEY (`id_examen`) REFERENCES `examen` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (5,1,'¿Qué es MySQL?',' 	Un sistema de gestión de bases de datos relacionales de código abierto respaldado por Oracle y basado en el lenguaje de consulta estructurado (SQL).',2),(6,2,'¿Qué es Spring Framework?','Es un framework Open Source que facilita la creación de aplicaciones de todo tipo en Java, Kotlin y Groovy.',2),(7,1,'¿Qué es un elemento químico?','Aquella sustancia que no se puede descomponer en otras más sencillas por métodos químicos ordinarios.',3),(8,2,'¿Qué es un número atómico?','En todo átomo el número de protones del núcleo es igual al de electrones de sus orbitales, se llama ‘número atómico’, es característico de cada elemento y es el ordinal de la casilla que ocupa en la Tabla Periódica. ',3),(9,3,'¿Qué es bootstrap?','Bootstrap es un framework front-end utilizado para desarrollar aplicaciones web y sitios mobile first, o sea, con un layout que se adapta a la pantalla del dispositivo utilizado por el usuario.',2);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
  UNIQUE KEY `UK_863n1y3x0jalatoir4325ehal` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'Bonilla','angela.bonilla@gmail.com','Angela','$2a$15$hmGnwX3WYzLa/Eo7JbWCLuNQM9JgL57dRmqa/L5yYHLQmzv7a3gHa','ROLE_USER','angela'),(2,1,'Admin','admin.examenes@gmail.com','Admin','$2a$15$5hmti0AwNioD/pVyHg.uWu/y/uaSof/VtWNyllTq/6LeAxsRNOQIq','ROLE_ADMIN','admin'),(3,1,'Waack Carneado','gonzalo.wc98@gmail.com','Gonzalo','$2a$15$JJxRXKJIdw507lcIq2uHaep0CHzu4dKh54m836QfZZU95k28T/Yq2','ROLE_USER','gonzalo');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-01 16:14:35
