/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50643
Source Host           : 127.0.0.1:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-05-07 13:49:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL COMMENT '管理员昵称',
  `login_name` varchar(50) DEFAULT NULL COMMENT '管理员账号',
  `passwd` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  `admin_status` int(3) DEFAULT '1' COMMENT '管理员状态1-可用 0-不可用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `clean_check`
-- ----------------------------
DROP TABLE IF EXISTS `clean_check`;
CREATE TABLE `clean_check` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '卫生检查表id',
  `dorm_room_admin_id` int(11) DEFAULT NULL COMMENT '检查人',
  `check_time` int(11) DEFAULT NULL COMMENT '检查周数',
  `grade` decimal(11,2) DEFAULT NULL COMMENT '成绩',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clean_check
-- ----------------------------

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '院系表id',
  `department_no` varchar(30) DEFAULT NULL COMMENT '院系编号',
  `department_name` varchar(40) DEFAULT NULL COMMENT '院系名称',
  `description` varchar(200) DEFAULT NULL COMMENT '院系描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------

-- ----------------------------
-- Table structure for `disciplinary_action`
-- ----------------------------
DROP TABLE IF EXISTS `disciplinary_action`;
CREATE TABLE `disciplinary_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '违纪处分表id',
  `student_id` int(11) DEFAULT NULL,
  `dorm_room_admin_id` int(11) DEFAULT NULL COMMENT '管理员id',
  `record_time` datetime DEFAULT NULL COMMENT '违纪时间',
  `disciplinary_type` int(3) DEFAULT NULL COMMENT '1-晚归 0-违纪',
  `description` varchar(200) DEFAULT NULL COMMENT '违规描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disciplinary_action
-- ----------------------------

-- ----------------------------
-- Table structure for `dorm`
-- ----------------------------
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE `dorm` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '宿舍楼id',
  `dorm_no` varchar(30) DEFAULT NULL COMMENT '宿舍楼编号',
  `dorm_name` varchar(30) DEFAULT NULL COMMENT '宿舍楼名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm
-- ----------------------------

-- ----------------------------
-- Table structure for `dorm_room`
-- ----------------------------
DROP TABLE IF EXISTS `dorm_room`;
CREATE TABLE `dorm_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '宿舍id',
  `department_id` int(11) DEFAULT NULL COMMENT '所属院系',
  `dorm_room_no` varchar(30) DEFAULT '' COMMENT '宿舍编号',
  `dorm_room_num` int(3) DEFAULT '4' COMMENT '宿舍人数',
  `drom_room_status` int(3) DEFAULT NULL COMMENT '宿舍状态 1-未满员 0-已损坏 2-已满员 ',
  `description` varchar(200) DEFAULT '可正常使用' COMMENT '宿舍描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm_room
-- ----------------------------

-- ----------------------------
-- Table structure for `dorm_room_admin`
-- ----------------------------
DROP TABLE IF EXISTS `dorm_room_admin`;
CREATE TABLE `dorm_room_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '宿舍管理员id',
  `name` varchar(30) DEFAULT NULL COMMENT '管理员姓名',
  `phone` varchar(12) DEFAULT NULL COMMENT '管理员电话',
  `status` int(3) DEFAULT NULL COMMENT '1-在职 0-离职',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm_room_admin
-- ----------------------------

-- ----------------------------
-- Table structure for `fee`
-- ----------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '费用表id',
  `dorm_room_id` int(11) DEFAULT NULL COMMENT '宿舍id',
  `dorm_room_admin_id` int(11) DEFAULT NULL COMMENT '管理员id--录入的管理员',
  `water_fee` decimal(11,2) DEFAULT NULL COMMENT '水费',
  `electricity_fee` decimal(11,2) DEFAULT NULL COMMENT '电费',
  `pay_time` datetime DEFAULT NULL COMMENT '缴纳时间',
  `fee_time` int(11) DEFAULT NULL COMMENT '缴费周数',
  `status` int(3) DEFAULT NULL COMMENT '1-已缴纳 0-未缴纳',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fee
-- ----------------------------

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `major_no` varchar(20) DEFAULT NULL COMMENT '专业编号',
  `major_name` varchar(20) DEFAULT NULL COMMENT '专业名称',
  `major_num` int(5) DEFAULT NULL COMMENT '专业招收人数',
  `study_year` int(2) DEFAULT NULL COMMENT '需要时间',
  `status` int(3) DEFAULT NULL COMMENT '1-开放 0-不开放',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------

-- ----------------------------
-- Table structure for `repair`
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '保修表id',
  `dorm_room_id` int(11) DEFAULT NULL COMMENT '保修宿舍',
  `repair_name` varchar(20) DEFAULT NULL COMMENT '报修人',
  `repair_phone` varchar(12) DEFAULT NULL COMMENT '报修人电话',
  `repair_time` datetime DEFAULT NULL COMMENT '报修时间',
  `repait_description` varchar(200) DEFAULT NULL COMMENT '报修描述',
  `deal_with_description` varchar(200) DEFAULT NULL COMMENT '维修者描述',
  `status` int(3) DEFAULT NULL COMMENT '0-未处理 1-已处理',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('18', null, null, null, null, null, null, null, null, null);
INSERT INTO `repair` VALUES ('19', null, null, null, null, null, null, null, null, null);
INSERT INTO `repair` VALUES ('20', null, null, null, null, null, null, null, null, null);
INSERT INTO `repair` VALUES ('21', null, null, null, null, null, null, null, null, null);
INSERT INTO `repair` VALUES ('22', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_class_id` int(11) DEFAULT NULL COMMENT '学生班级id',
  `stu_dorm_room_id` varchar(20) DEFAULT NULL COMMENT '学生宿舍id',
  `stu_no` varchar(40) DEFAULT NULL COMMENT '学号',
  `stu_pwd` varchar(30) DEFAULT NULL COMMENT '学生密码',
  `stu_name` varchar(30) DEFAULT NULL COMMENT '学生姓名',
  `stu_phone` varchar(12) DEFAULT NULL COMMENT '学生手机号码',
  `stu_sex` int(3) DEFAULT NULL COMMENT '学生性别 1-男 0-女',
  `major_id` int(11) DEFAULT NULL COMMENT '专业id',
  `graduation_year` varchar(20) DEFAULT NULL COMMENT '毕业年份',
  `start_year` varchar(20) DEFAULT NULL COMMENT '入学年份',
  `stu_age` int(4) DEFAULT NULL COMMENT '学生姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stu_no` (`stu_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for `stu_class`
-- ----------------------------
DROP TABLE IF EXISTS `stu_class`;
CREATE TABLE `stu_class` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '班级表id',
  `department_id` int(11) DEFAULT NULL COMMENT '院系id',
  `class_no` varchar(30) DEFAULT NULL COMMENT '班级编号',
  `class_name` varchar(30) DEFAULT NULL COMMENT '班级名称',
  `class_num` int(3) DEFAULT '30' COMMENT '班级招收学生数量',
  `class_status` int(3) DEFAULT '1' COMMENT '班级状态 1-开班 0-不开班',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_class
-- ----------------------------

-- ----------------------------
-- Table structure for `visitor`
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '来访人id',
  `visitor_name` varchar(30) DEFAULT NULL,
  `visitor_phone` varchar(12) DEFAULT NULL,
  `dorm_room_id` int(11) DEFAULT NULL COMMENT '访问宿舍',
  `student_id` int(11) DEFAULT NULL COMMENT '访问学生',
  `visitor_time` datetime DEFAULT NULL COMMENT '访问时间',
  `go_away_time` datetime DEFAULT NULL COMMENT '离开时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor
-- ----------------------------
