CREATE DATABASE  IF NOT EXISTS `cretbase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cretbase`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: cretbase
-- ------------------------------------------------------
-- Server version	5.6.16-log

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
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_data` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `Name` varchar(45) DEFAULT NULL COMMENT '字典名称',
  `Value` varchar(45) DEFAULT NULL COMMENT '字典值',
  `TypeId` int(11) DEFAULT NULL COMMENT '字典类型',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `FK_GROUP_ID_idx` (`TypeId`),
  CONSTRAINT `FK_TYPE_ID` FOREIGN KEY (`TypeId`) REFERENCES `sys_dict_type` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='字典数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` VALUES (1,'超级管理员','1',1,NULL,NULL,0),(2,'系统用户','2',1,NULL,NULL,0),(3,'普通用户','3',1,NULL,NULL,0),(4,'女','0',2,NULL,NULL,0),(5,'男','1',2,NULL,NULL,0);
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_type` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `Name` varchar(45) NOT NULL COMMENT '字典类型',
  `Code` varchar(45) NOT NULL COMMENT '类型编码',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `GroupCode_UNIQUE` (`Code`),
  UNIQUE KEY `GroupName_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='字典类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` VALUES (1,'用户类型','userTypes','2014-05-02 00:00:00',1,0),(2,'性别类','sexTypes','2014-05-03 17:13:19',NULL,4),(4,'区域类','areaTypes',NULL,NULL,0),(5,'证件类','cardTypes',NULL,NULL,0);
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_function`
--

DROP TABLE IF EXISTS `sys_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_function` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `Name` varchar(45) NOT NULL COMMENT '功能名称',
  `Code` varchar(45) NOT NULL COMMENT '功能编码',
  `Type` int(11) NOT NULL COMMENT '显示类型',
  `Url` varchar(300) DEFAULT NULL COMMENT '链接地址',
  `Script` varchar(300) DEFAULT NULL COMMENT '脚本',
  `Sort` int(11) DEFAULT NULL COMMENT '显示排序',
  `MenuId` int(11) NOT NULL COMMENT '隶属菜单',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name_UNIQUE` (`Name`),
  UNIQUE KEY `Code_UNIQUE` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统功能';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_function`
--

LOCK TABLES `sys_function` WRITE;
/*!40000 ALTER TABLE `sys_function` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_group`
--

DROP TABLE IF EXISTS `sys_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_group` (
  `Id` int(11) NOT NULL COMMENT '标识',
  `Name` varchar(45) DEFAULT NULL COMMENT '组名称',
  `Desc` varchar(200) DEFAULT NULL COMMENT '组描述',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编组';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_group`
--

LOCK TABLES `sys_group` WRITE;
/*!40000 ALTER TABLE `sys_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_group_role`
--

DROP TABLE IF EXISTS `sys_group_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_group_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `GroupId` int(11) NOT NULL COMMENT '组标识',
  `RoleId` int(11) NOT NULL COMMENT '角色标识',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色组';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_group_role`
--

LOCK TABLES `sys_group_role` WRITE;
/*!40000 ALTER TABLE `sys_group_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_group_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_group_user`
--

DROP TABLE IF EXISTS `sys_group_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_group_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `GroupId` int(11) NOT NULL COMMENT '组标识',
  `UserId` int(11) NOT NULL COMMENT '用户标识',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_group_user`
--

LOCK TABLES `sys_group_user` WRITE;
/*!40000 ALTER TABLE `sys_group_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_group_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `Id` int(11) NOT NULL COMMENT '标识',
  `Name` varchar(45) NOT NULL COMMENT '菜单名称',
  `Code` varchar(45) NOT NULL COMMENT '菜单编码',
  `Url` varchar(300) DEFAULT NULL COMMENT '菜单链接',
  `Target` varchar(45) DEFAULT NULL COMMENT '目标窗口',
  `Sort` int(11) NOT NULL COMMENT '排序',
  `ModuleId` int(11) DEFAULT NULL COMMENT '隶属模块',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `name_UNIQUE` (`Name`),
  UNIQUE KEY `Code_UNIQUE` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_module`
--

DROP TABLE IF EXISTS `sys_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_module` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `Name` varchar(45) NOT NULL COMMENT '模块名称',
  `Code` varchar(45) NOT NULL COMMENT '模块编码',
  `Sort` int(11) DEFAULT NULL COMMENT '模块排序',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Code_UNIQUE` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统模块';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_module`
--

LOCK TABLES `sys_module` WRITE;
/*!40000 ALTER TABLE `sys_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_pm_func`
--

DROP TABLE IF EXISTS `sys_pm_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_pm_func` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PrivMenuId` int(11) NOT NULL COMMENT '权限菜单关系标识',
  `FuncId` int(11) NOT NULL COMMENT '功能标识',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单到按钮 多对多';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_pm_func`
--

LOCK TABLES `sys_pm_func` WRITE;
/*!40000 ALTER TABLE `sys_pm_func` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_pm_func` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_priv`
--

DROP TABLE IF EXISTS `sys_priv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_priv` (
  `Id` int(11) NOT NULL COMMENT '标识',
  `Name` varchar(45) NOT NULL COMMENT '权限名称',
  `Desc` varchar(200) DEFAULT NULL COMMENT '权限描述',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `name_UNIQUE` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_priv`
--

LOCK TABLES `sys_priv` WRITE;
/*!40000 ALTER TABLE `sys_priv` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_priv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_priv_menu`
--

DROP TABLE IF EXISTS `sys_priv_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_priv_menu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PrivId` int(11) NOT NULL COMMENT '权限标识',
  `MenuId` int(11) NOT NULL COMMENT '菜单标识',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限到菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_priv_menu`
--

LOCK TABLES `sys_priv_menu` WRITE;
/*!40000 ALTER TABLE `sys_priv_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_priv_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `Id` int(11) NOT NULL COMMENT '标识',
  `Name` varchar(45) NOT NULL COMMENT '角色名称',
  `Desc` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `name_UNIQUE` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_priv`
--

DROP TABLE IF EXISTS `sys_role_priv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_priv` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `RoleId` int(11) NOT NULL COMMENT '角色标识',
  `PrivId` int(11) NOT NULL COMMENT '权限标识',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_priv`
--

LOCK TABLES `sys_role_priv` WRITE;
/*!40000 ALTER TABLE `sys_role_priv` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_priv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `UserName` varchar(45) NOT NULL COMMENT '登录名称',
  `Password` varchar(32) NOT NULL COMMENT '密码',
  `NickName` varchar(45) DEFAULT NULL COMMENT '昵称',
  `Telphone` varchar(15) DEFAULT NULL COMMENT '电话',
  `Email` varchar(45) DEFAULT NULL COMMENT '邮件',
  `RefId` int(11) NOT NULL COMMENT '关系信息标识',
  `CreateDate` datetime DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `Version` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `uName_UNIQUE` (`UserName`),
  UNIQUE KEY `NickName_UNIQUE` (`NickName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','4122be942bf44d78','超级管理员',NULL,NULL,0,NULL,NULL,0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-11 14:39:08
