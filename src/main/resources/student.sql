# Host: localhost  (Version: 5.7.3-m13)
# Date: 2019-05-06 18:56:53
# Generator: MySQL-Front 5.3  (Build 4.4)

/*!40101 SET NAMES utf8 */;

#
# Source for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "admin"
#


#
# Source for table "complaint"
#

DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `complaintDate` datetime DEFAULT NULL,
  `status` varchar(6) DEFAULT '0',
  `describe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "complaint"
#


#
# Source for table "fee"
#

DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `standard` varchar(50) DEFAULT NULL,
  `detail` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "fee"
#


#
# Source for table "repair"
#

DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL,
  `building_name` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `detail` varchar(200) DEFAULT NULL,
  `status` varchar(6) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `repair_type` varchar(20) DEFAULT NULL,
  `opinions` varchar(200) DEFAULT NULL,
  `repair_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Data for table "repair"
#

INSERT INTO `repair` VALUES (18,3623,'新世纪三栋','2019-05-04 00:00:00','厕所下水道堵塞','0','周亚娟','水电工',NULL,NULL),(19,3623,'新世纪三栋','2019-05-06 05:11:33','厕所灯坏了','0','周亚娟','水电工',NULL,NULL),(20,3622,'s\'fa\'d\'fa和','2019-05-06 10:16:01','阿达','0','非官方','十大',NULL,NULL),(21,3622,'s\'fa\'d\'fa和','2019-05-06 10:16:01','阿达','0','非官方','十大',NULL,NULL),(22,3622,'湘金3栋','2019-05-06 10:18:44','阿达','0','王一力','广东',NULL,NULL);

#
# Source for table "stuinfo"
#

DROP TABLE IF EXISTS `stuinfo`;
CREATE TABLE `stuinfo` (
  `sid` varchar(255) NOT NULL DEFAULT '',
  `sname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `faculty` varchar(50) DEFAULT NULL,
  `classes` varchar(20) DEFAULT NULL,
  `grade_major` varchar(255) DEFAULT NULL,
  `political_aspects` varchar(50) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "stuinfo"
#

INSERT INTO `stuinfo` VALUES ('201517070120','陈俊','男',NULL,NULL,NULL,NULL,NULL),('2015178253','wang','女',NULL,NULL,NULL,NULL,NULL),('201514070155','wangyili','sdas',NULL,NULL,NULL,NULL,NULL),('201514070159','a','d',NULL,NULL,NULL,NULL,NULL);
