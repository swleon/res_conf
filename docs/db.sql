-- MySQL dump 10.13  Distrib 8.0.26, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: orca
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `resourceconfig`
--

DROP TABLE IF EXISTS `resourceconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resourceconfig` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `resourceId` int NOT NULL COMMENT '关联资源位id',
  `metaKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '字段key',
  `metaName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字段名称',
  `dataType` int NOT NULL COMMENT '数据类型 0数字/1文案/2时间戳/3图片链接/4跳转链接/5视频链接/6单选/7多选/8下拉列表/9颜色/10前端专用-外置参数',
  `metaValue` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '一些额外字段元数据',
  `required` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否必需 0否 1是',
  `editable` tinyint unsigned NOT NULL COMMENT '是否可编辑  0否 1是',
  `sort` int unsigned NOT NULL COMMENT '展示顺序',
  `metaTips` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '提示文案',
  `defaultValue` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '默认值',
  `created` int unsigned NOT NULL COMMENT '创建时间',
  `updated` int NOT NULL,
  `isDeleted` tinyint NOT NULL,
  `creater` varchar(100) DEFAULT NULL COMMENT '创建者',
  `updater` varchar(100) DEFAULT NULL COMMENT '更新者',
  `depart` varchar(100) DEFAULT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_resourceId` (`resourceId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourceconfig`
--

LOCK TABLES `resourceconfig` WRITE;
/*!40000 ALTER TABLE `resourceconfig` DISABLE KEYS */;
INSERT INTO `resourceconfig` VALUES (1,2,'pic_url','图片链接',3,'',1,1,1,'image link',NULL,1631072852,1631072852,0,NULL,NULL,NULL),(2,2,'param','外置参数',10,'',1,1,2,'parms','',1631072852,1631072852,0,NULL,NULL,NULL),(4,3,'param','外置参数',10,NULL,1,1,2,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(5,3,'pic_url','图片链接',3,NULL,1,1,1,'',NULL,1631072852,1631072852,0,NULL,NULL,NULL),(6,4,'image','图片链接',3,NULL,1,1,1,'image link',NULL,1631072852,1631072852,0,NULL,NULL,NULL),(7,5,'siteCode','站点',1,NULL,1,1,1,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(8,5,'image','图片',3,NULL,1,1,2,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(9,6,'siteCode','站点',1,NULL,1,1,1,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(10,6,'image','图片',3,NULL,1,1,2,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(11,7,'pic_url','图片链接',3,NULL,1,1,1,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(12,7,'param','外置参数',10,NULL,1,1,2,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(13,4,'siteCode','站点标识',1,NULL,1,1,2,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(14,8,'siteCode','站点',1,NULL,1,1,1,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(15,8,'image','图片',3,NULL,1,1,1,NULL,NULL,1631072852,1631072852,0,NULL,NULL,NULL),(16,4,'param','外置参数',10,NULL,1,1,3,'',NULL,1631072852,1631072852,0,NULL,NULL,NULL),(17,5,'param','外置参数',10,NULL,1,1,3,'',NULL,1631072852,1631072852,0,NULL,NULL,NULL),(18,6,'param','外置参数',10,NULL,1,1,3,'',NULL,1631072852,1631072852,0,NULL,NULL,NULL),(19,8,'param','外置参数',10,NULL,1,1,3,'',NULL,1631072852,1631072852,0,NULL,NULL,NULL),(20,9,'pic_url','图片链接',3,NULL,1,1,1,'大图',NULL,1631072852,1631072852,0,NULL,NULL,NULL),(21,10,'mediaList','mediaList',8,NULL,0,1,1,NULL,NULL,1637051784,1637051784,0,'0','0',NULL);
/*!40000 ALTER TABLE `resourceconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourceentryrecord`
--

DROP TABLE IF EXISTS `resourceentryrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resourceentryrecord` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `resourceId` int unsigned NOT NULL,
  `status` int unsigned NOT NULL DEFAULT '0' COMMENT '素材状态 0 测试 1上线',
  `startTime` int unsigned NOT NULL COMMENT '开始时间',
  `endTime` int unsigned NOT NULL DEFAULT '0' COMMENT '结束时间',
  `metaName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '元字段名称',
  `metaValue` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '投放内容',
  `sort` int NOT NULL DEFAULT '0' COMMENT '素材顺序',
  `extend` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '扩展属性',
  `term` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '完全匹配字段',
  `strategy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '策略',
  `strategyValue` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '策略值',
  `type` int DEFAULT NULL COMMENT '类型',
  `siteCode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '站点标识',
  `siteName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '站点名称',
  `created` int unsigned NOT NULL,
  `updated` int unsigned NOT NULL,
  `isDeleted` tinyint unsigned NOT NULL,
  `creater` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  `updater` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  `depart` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属部门',
  `describer` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_resourceId_status_startTime` (`resourceId`,`status`,`startTime`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourceentryrecord`
--

LOCK TABLES `resourceentryrecord` WRITE;
/*!40000 ALTER TABLE `resourceentryrecord` DISABLE KEYS */;
INSERT INTO `resourceentryrecord` VALUES (2,2,1,1631087130,1759201200,NULL,'{\n  \"param\": \"sourceSite=3541&siteCode=hallowshack\",\n  \"pic_url\": \"https://site-image.azureedge.net/08092021_9bcf90f7afff4d6abbbd0343472d33a5_1144x100.png\"\n}',1,NULL,'','',NULL,NULL,'hallowshack','hallowshack',1631087130,1631527968,0,NULL,NULL,NULL,NULL),(3,3,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_29a905a1f60840388aaf34728dee61fd_1530x1150.png\",\r\n                    \"param\": \"sourceSite=3541&siteCode=hallowshack\"\r\n                }',1,NULL,'','',NULL,NULL,'hallowshack','hallowshack',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(4,3,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_652275ebede14e2e927c98de08f1fef8_1530x1150.png\",\r\n                    \"param\": \"sourceSite=3516&siteCode=Kalavia\"\r\n                }',2,NULL,'','',NULL,NULL,'kalavia','kalavia',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(5,3,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_34ba7f89847543e9b5ff7cbd98b21c76_1530x1150.png\",\r\n                    \"param\": \"sourceSite=3538&siteCode=Mary\"\r\n                }',3,NULL,'','',NULL,NULL,'mary','mary',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(6,3,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_45828fd696e94febb7314dc1d10ac60a_1530x1150.png\",\r\n                    \"param\": \"sourceSite=3537&siteCode=Minihug\"\r\n                }',4,NULL,'','',NULL,NULL,'minihug','minihug',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(7,3,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_40f7da8107db47438db3234d99c73f95_1530x1150.png\",\r\n                    \"param\": \"sourceSite=3543&siteCode=olikefit\"\r\n                }',5,NULL,'','',NULL,NULL,'olikefit','olikefit',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(8,3,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_d7c6abe6754f433e83ee87426dc208d3_1530x1150.png\",\r\n                    \"param\": \"sourceSite=3508&siteCode=patpat\"\r\n                }',6,NULL,'','',NULL,NULL,'patpat','patpat',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(9,2,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_3cbd5cc91d8a448fa5d63c6e8e5305c0_1154x100.png\",\r\n                    \"param\": \"sourceSite=3516&siteCode=Kalavia\"\r\n                }',2,NULL,'','',NULL,NULL,'kalavia','kalavia',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(10,2,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_3e0382ddc6914f74806aea188f6710cc_1144x100.png\",\r\n                    \"param\": \"sourceSite=3538&siteCode=Mary\"\r\n                }',3,NULL,'','',NULL,NULL,'mary','mary',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(11,2,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_21f5ab3af8cb4411a9b773ff095f93b5_1154x100.png\",\r\n                    \"param\": \"sourceSite=3537&siteCode=Minihug\"\r\n                }',4,NULL,'','',NULL,NULL,'minihug','minihug',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(12,2,1,1631087130,1759201200,NULL,'{\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_368ad46c60a247ea8d768cfd1514c9ee_1144x100.png\",\r\n                    \"param\": \"sourceSite=3543&siteCode=olikefit\"\r\n                }',5,NULL,'','',NULL,NULL,'olikefit','olikefit',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(13,2,1,1631087130,1759201200,NULL,' {\r\n                    \"pic_url\": \"https://site-image.azureedge.net/08092021_8bdada4e01af497e83ec691911570148_1144x100.png\",\r\n                    \"param\": \"sourceSite=3508&siteCode=patpat\"\r\n                }',6,NULL,'','',NULL,NULL,'patpat','patpat',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(14,4,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"kalavia\",\n    \"image\": \"https://site-image.azureedge.net/08092021_d81eadcf45044d7f9a231d5673a4af4d_560x754.png\",\n    \"param\": \"sourceSite=3516&siteCode=kalavia\"\n}',1,NULL,'','',NULL,NULL,'kalavia','kalavia',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(15,4,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"patpat\",\n    \"image\": \"https://site-image.azureedge.net/08092021_430c76643bb3444aba92dc7976028f2f_560x754.png\",\n    \"param\": \"sourceSite=3508&siteCode=patpat\"\n}',2,NULL,'','',NULL,NULL,'patpat','patpat',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(16,4,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"miniHug\",\n    \"image\": \"https://site-image.azureedge.net/08092021_40aeaeb1af3b412792e6b5719cda4cf3_560x754.png\",\n    \"param\": \"sourceSite=3537&siteCode=Minihug\"\n}',3,NULL,'','',NULL,NULL,'minihug','minihug',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(17,4,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"olikefit\",\n    \"image\": \"https://site-image.azureedge.net/08092021_63166431e1a24520be61d74ce0935b32_560x754.png\",\n    \"param\": \"sourceSite=3543&siteCode=olikefit\"\n}',4,NULL,'','',NULL,NULL,'olikefit','olikefit',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(18,4,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"hallowshack\",\n    \"image\": \"https://site-image.azureedge.net/08092021_f96564f6b7494e4db49b22bd151c0916_560x754.png\",\n    \"param\": \"sourceSite=3541&siteCode=hallowshack\"\n}',5,NULL,'','',NULL,NULL,'hallowshack','hallowshack',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(19,4,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"mary\",\n    \"image\": \"https://site-image.azureedge.net/08092021_c947370684934c48a256abff4b51f3b8_560x754.png\",\n    \"param\": \"sourceSite=3538&siteCode=Mary\"\n}',6,NULL,'','',NULL,NULL,'mary','mary',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(20,5,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"kalavia\",\n    \"image\": \"https://site-image.azureedge.net/08092021_3e70926389b34455868b1e20dda136c0_708x580.png\",\n    \"param\": \"sourceSite=3516&siteCode=kalavia\"\n}',1,NULL,'','',NULL,NULL,'kalavia','kalavia',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(21,5,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"patpat\",\n    \"image\": \"https://site-image.azureedge.net/08092021_9a387f0cf2694c1297ef30eb35b69446_708x580.png\",\n    \"param\": \"sourceSite=3508&siteCode=patpat\"\n}',2,NULL,'','',NULL,NULL,'patpat','patpat',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(22,5,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"miniHug\",\n    \"image\": \"https://site-image.azureedge.net/08092021_c6515240dafa4f29b5d6dd7c5ffde5de_708x580.png\",\n    \"param\": \"sourceSite=3537&siteCode=Minihug\"\n}',3,NULL,'','',NULL,NULL,'minihug','minihug',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(23,5,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"olikefit\",\n    \"image\": \"https://site-image.azureedge.net/08092021_a97390d8b25f4449a600dc871c7e9bb3_708x580.png\",\n    \"param\": \"sourceSite=3543&siteCode=olikefit\"\n}',4,NULL,'','',NULL,NULL,'olikefit','olikefit',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(24,5,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"hallowshack\",\n    \"image\": \"https://site-image.azureedge.net/08092021_757dcdfb8aff4facb47a47c00339533f_708x580.png\",\n    \"param\": \"sourceSite=3541&siteCode=hallowshack\"\n}',5,NULL,'','',NULL,NULL,'hallowshack','hallowshack',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(25,5,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"mary\",\n    \"image\": \"https://site-image.azureedge.net/08092021_e9177df49df54b8180f362f952cc9fa2_708x580.png\",\n    \"param\": \"sourceSite=3538&siteCode=Mary\"\n}',6,NULL,'','',NULL,NULL,'mary','mary',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(26,6,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"kalavia\",\n    \"image\": \"https://site-image.azureedge.net/08092021_fa443f398a414e7c83629c6f73fa274e_708x580.png\",\n    \"param\": \"sourceSite=3516&siteCode=kalavia\"\n}',1,NULL,'','',NULL,NULL,'kalavia','kalavia',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(27,6,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"patpat\",\n    \"image\": \"https://site-image.azureedge.net/08092021_a8cf975b570d48198f619ec8a3c3f0db_708x580.png\",\n    \"param\": \"sourceSite=3508&siteCode=patpat\"\n}',2,NULL,'','',NULL,NULL,'patpat','patpat',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(28,6,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"miniHug\",\n    \"image\": \"https://site-image.azureedge.net/08092021_14ac5ae36409464481eeb18bca444dc5_708x580.png\",\n    \"param\": \"sourceSite=3537&siteCode=Minihug\"\n}',3,NULL,'','',NULL,NULL,'minihug','minihug',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(29,6,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"olikefit\",\n    \"image\": \"https://site-image.azureedge.net/08092021_7070a696ef5f43ab9a6a9fa436166b9a_708x580.png\",\n    \"param\": \"sourceSite=3543&siteCode=olikefit\"\n}',4,NULL,'','',NULL,NULL,'olikefit','olikefit',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(30,6,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"hallowshack\",\n    \"image\": \"https://site-image.azureedge.net/08092021_24e3d28070714ed08da315fc72835daa_708x580.png\",\n    \"param\": \"sourceSite=3541&siteCode=hallowshack\"\n}',5,NULL,'','',NULL,NULL,'hallowshack','hallowshack',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(31,6,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"mary\",\n    \"image\": \"https://site-image.azureedge.net/08092021_1b9684eae692406b972c3aca19843bdf_708x580.png\",\n    \"param\": \"sourceSite=3538&siteCode=Mary\"\n}',6,NULL,'','',NULL,NULL,'mary','mary',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(32,7,1,1631087130,1759201200,NULL,'{\r\n\"pic_url\": \"https://site-image.azureedge.net/08092021_09048adfa3534387a5c169ff91b73192_3788x1200.png\",\r\n\"param\": \"sourceSite=3541&siteCode=hallowshack\"\r\n}',1,NULL,'','',NULL,NULL,'hallowshack','hallowshack',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(33,7,1,1631087130,1759201200,NULL,'{\r\n\"pic_url\": \"https://site-image.azureedge.net/08092021_a00bd4c7c31e4399817f1e6101cb30e0_3788x1200.png\",\r\n                    \"param\": \"sourceSite=3516&siteCode=Kalavia\"\r\n}',2,NULL,'','',NULL,NULL,'kalavia','kalavia',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(34,7,1,1631087130,1759201200,NULL,'{\"pic_url\": \"https://site-image.azureedge.net/08092021_6ed722c555254472a2e2190db1be85e3_3788x1200.png\",\r\n                    \"param\": \"sourceSite=3538&siteCode=Mary\"}',3,NULL,'','',NULL,NULL,'mary','mary',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(35,7,1,1631087130,1759201200,NULL,'{\"pic_url\": \"https://site-image.azureedge.net/08092021_3fec2ed2a0224b42b732c807d9f7bef7_3788x1200.png\",\r\n                    \"param\": \"sourceSite=3537&siteCode=Minihug\"}',4,NULL,'','',NULL,NULL,'minihug','minihug',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(36,7,1,1631087130,1759201200,NULL,' {\"pic_url\": \"https://site-image.azureedge.net/08092021_ad96a3eed25c4e94ac577e87f0ad100d_3788x1200.png\",\r\n                    \"param\": \"sourceSite=3543&siteCode=olikefit\"}',5,NULL,'','',NULL,NULL,'olikefit','olikefit',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(37,7,1,1631087130,1759201200,NULL,'{\"pic_url\": \"https://site-image.azureedge.net/08092021_229d449f4efb454baf289ebc3675f664_3788x1200.png\",\r\n                    \"param\": \"sourceSite=3508&siteCode=patpat\" }',6,NULL,'','',NULL,NULL,'patpat','patpat',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(38,8,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"kalavia\",\n    \"image\": \"https://site-image.azureedge.net/08092021_edfea4e08146466f9a5a13a7637f99b8_708x580.png\",\n    \"param\": \"sourceSite=3516&siteCode=kalavia\"\n}',1,NULL,'','',NULL,NULL,'kalavia','kalavia',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(39,8,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"patpat\",\n    \"image\": \"https://site-image.azureedge.net/08092021_ea5bc7423194471ea64781a7d5b10c68_708x580.png\",\n    \"param\": \"sourceSite=3508&siteCode=patpat\"\n}',2,NULL,'','',NULL,NULL,'patpat','patpat',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(40,8,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"miniHug\",\n    \"image\": \"https://site-image.azureedge.net/08092021_a03fe269a91f426ba97ead7515becbd6_708x580.png\",\n    \"param\": \"sourceSite=3537&siteCode=Minihug\"\n}',3,NULL,'','',NULL,NULL,'minihug','minihug',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(41,8,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"olikefit\",\n    \"image\": \"https://site-image.azureedge.net/08092021_c46469a155b04ed0a75de8b46120d27f_708x580.png\",\n    \"param\": \"sourceSite=3543&siteCode=olikefit\"\n}',4,NULL,'','',NULL,NULL,'olikefit','olikefit',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(42,8,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"hallowshack\",\n    \"image\": \"https://site-image.azureedge.net/08092021_7db1cf4f84964fa58329c1b267fc78d3_708x580.png\",\n    \"param\": \"sourceSite=3541&siteCode=hallowshack\"\n}',5,NULL,'','',NULL,NULL,'hallowshack','hallowshack',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(43,8,1,1631087130,1759201200,NULL,'{\n    \"siteCode\": \"mary\",\n    \"image\": \"https://site-image.azureedge.net/08092021_9ea7fcf4b4cd4f63b6205ac0603e9444_708x580.png\",\n    \"param\": \"sourceSite=3538&siteCode=Mary\"\n}',6,NULL,'','',NULL,NULL,'mary','mary',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(44,9,1,1631087130,1759201200,NULL,'{\n\"pic_url\":\"https://site-image.azureedge.net/08092021_036cb9d22f7549aa8e506007ff629195_3786x1200.png\"\n}',1,NULL,'','',NULL,NULL,'mary','mary',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(45,9,1,1631087130,1759201200,NULL,'{\n\"pic_url\":\"https://site-image.azureedge.net/08092021_597e98c629a942faa092d57da45071b5_3788x1200.png\"\n}',1,NULL,'','',NULL,NULL,'hallowshack','\nhallowshack',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(46,9,1,1631087130,1759201200,NULL,'{\n\"pic_url\":\"https://site-image.azureedge.net/08092021_6dd354b390c24925ae50bd1e8585c3a4_3788x1200.png\"\n}',1,NULL,'','',NULL,NULL,'minihug','minihug',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(47,9,1,1631087130,1759201200,NULL,'{\n\"pic_url\":\"https://site-image.azureedge.net/08092021_56d23906d72c4aa69fc06dcdf8cfbcf0_3788x1200.png\"\n}',1,NULL,'','',NULL,NULL,'olikefit','olikefit',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(48,9,1,1631087130,1759201200,NULL,'{\n\"pic_url\":\"https://site-image.azureedge.net/08092021_b0b0a172612848ae85a340d26b012358_3788x1200.png\"\n}',1,NULL,'','',NULL,NULL,'patpat','\npatpat',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(49,9,1,1631087130,1759201200,NULL,'{\n\"pic_url\":\"https://site-image.azureedge.net/08092021_a0cf12f071ab46e18efc9703ab808ac6_3788x1200.png\"\n}',1,NULL,'','',NULL,NULL,'kalavia','kalavia',1631087130,1631087130,0,NULL,NULL,NULL,NULL),(50,10,1,1632281075,1759201200,NULL,'{\n  \"mediaList\": [\n    {\n      \"uid\": \"78f9e89a-127c-460e-bf66-281e3b20bfe9\",\n      \"code\": \"1\",\n      \"name\": \"2\"\n    }\n  ]\n}',1,NULL,'','',NULL,NULL,NULL,NULL,1632974098,1637051793,0,'0','0',NULL,NULL);
/*!40000 ALTER TABLE `resourceentryrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourceniche`
--

DROP TABLE IF EXISTS `resourceniche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resourceniche` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '名字',
  `platformCode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '平台code标识',
  `platformName` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '平台名称',
  `classify` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分类标识',
  `templateCode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '模板编码',
  `describe` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '描述',
  `strategy` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '策略配置',
  `metaValue` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '扩展配置',
  `created` int unsigned NOT NULL DEFAULT '0',
  `updated` int unsigned NOT NULL DEFAULT '0',
  `isDeleted` tinyint unsigned NOT NULL DEFAULT '0',
  `creater` varchar(100) DEFAULT NULL COMMENT '创建者',
  `updater` varchar(100) DEFAULT NULL COMMENT '更新者',
  `depart` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourceniche`
--

LOCK TABLES `resourceniche` WRITE;
/*!40000 ALTER TABLE `resourceniche` DISABLE KEYS */;
INSERT INTO `resourceniche` VALUES (2,'51a6e741-1055-11ec-bc0d-50eb7130f46c','site_index_banner','site','site platform','site#pc#index#banner','0','banner','general','0',1631072082,1631700247,0,NULL,NULL,NULL),(3,'6a03d345-ed33-4aa8-91ce-ff66c5515ca3','site_index_dialogBanner','site','site platform','site#pc#index#dialogBanner','0','banner','general','0',1631072082,1631072082,0,NULL,NULL,NULL),(4,'e3b902b1-59a2-486f-aa88-94a4d8d61db7','site_h5_index_dialogBanner','site','site platform','h5#index#dialogBanner','0','banner','general','0',1631072082,1631072082,0,NULL,NULL,NULL),(5,'82706ce8-fd14-44bb-8be7-4aa12482e051','site_h5_brandCollect_banner','site','site platform','h5#brandCollect#banner','0','banner','general','0',1631072082,1631072082,0,NULL,NULL,NULL),(6,'d9d474c4-df9d-4c18-a49d-30ff9773fc6a','site_h5_brand_banner','site','site platform','h5#brand#banner','0','banner','general','0',1631072082,1631072082,0,NULL,NULL,NULL),(7,'9108c82d-1f7f-42db-a013-03b068b4c5a1','site_pc_index_partners','site','site platform','site#pc#index#partners','0','partners','general','0',1631072082,1631072082,0,NULL,NULL,NULL),(8,'fa144b6d-8842-4863-9a2f-4c616f2f43fd','site_h5_index_banner','site','site platform','h5#index#banner','0','banner','general','0',1631072082,1631072082,0,NULL,NULL,NULL),(9,'f644b341-3750-490f-b599-888f3cd563e8','site_pc_partner_header','site','site platform','site#pc#partner#header','0','banner','general','0',1631072082,1631072082,0,NULL,NULL,NULL),(10,'1a5d9664a5a945f4b71c7cec84fa029b','site-sg#media#list','site','site','site-sg#media#list',NULL,'',NULL,'',1637051768,1637051768,0,'0','0',NULL);
/*!40000 ALTER TABLE `resourceniche` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-04 21:25:16
