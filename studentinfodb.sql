/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : studentinfodb

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-06-16 17:09:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `number` varchar(255) COLLATE gbk_bin NOT NULL,
  `name` varchar(255) COLLATE gbk_bin DEFAULT NULL,
  `password` varchar(255) COLLATE gbk_bin DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COLLATE=gbk_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('20150101', '李四', '456');
INSERT INTO `admin` VALUES ('20150102', '张三', '123');
INSERT INTO `admin` VALUES ('20150103', '超人', '123');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` varchar(12) COLLATE gbk_bin NOT NULL,
  `name` varchar(20) COLLATE gbk_bin DEFAULT NULL,
  `type` varchar(20) COLLATE gbk_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COLLATE=gbk_bin;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '音乐部', '艺术类');
INSERT INTO `department` VALUES ('2', '书法部', '艺术类');
INSERT INTO `department` VALUES ('3', '文艺部', '艺术类');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `number` varchar(20) COLLATE gbk_bin NOT NULL,
  `name` varchar(20) COLLATE gbk_bin DEFAULT NULL,
  `password` varchar(20) COLLATE gbk_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(16) COLLATE gbk_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE gbk_bin DEFAULT NULL,
  `department` varchar(20) COLLATE gbk_bin DEFAULT NULL,
  PRIMARY KEY (`number`),
  KEY `a1` (`department`),
  CONSTRAINT `a1` FOREIGN KEY (`department`) REFERENCES `department` (`name`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk COLLATE=gbk_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '李四', '123', '20', '男', '123213312', '书法部');
INSERT INTO `student` VALUES ('3', '张三', '123', '20', '男', '1231231312', '书法部');
