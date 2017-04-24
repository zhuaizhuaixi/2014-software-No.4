/*
Navicat MySQL Data Transfer

Source Server         : zx
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-04-19 22:11:03
*/

use study;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `exercises`
-- ----------------------------
DROP TABLE IF EXISTS `exercises`;
CREATE TABLE `exercises` (
  `id` int(11) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `A` varchar(255) NOT NULL,
  `B` varchar(255) NOT NULL,
  `C` varchar(255) NOT NULL,
  `D` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercises
-- ----------------------------
INSERT INTO `exercises` VALUES ('1', '1+1=', '1', '2', '3', '4', 'B');

-- ----------------------------
-- Table structure for `experiment`
-- ----------------------------
DROP TABLE IF EXISTS `experiment`;
CREATE TABLE `experiment` (
  `id` int(11) NOT NULL,
  `experiment` varchar(255) NOT NULL,
  `require` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of experiment
-- ----------------------------
INSERT INTO `experiment` VALUES ('1', 'Hello world', '编写hello world');

-- ----------------------------
-- Table structure for `historical_rudiment`
-- ----------------------------
DROP TABLE IF EXISTS `historical_rudiment`;
CREATE TABLE `historical_rudiment` (
  `id` int(255) NOT NULL,
  `operator` int(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of historical_rudiment
-- ----------------------------
INSERT INTO `historical_rudiment` VALUES ('1', '221000101', '提交作业', '2017-04-18');

-- ----------------------------
-- Table structure for `message_board`
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board` (
  `id` int(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `author` int(255) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_board
-- ----------------------------
INSERT INTO `message_board` VALUES ('1', '今天作业是什么', '221000101', '2017-04-18');

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL,
  `student` int(11) NOT NULL,
  `time` date NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `score` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '221000101', '2017-04-18', 'hello world', 'hello world', '78');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `last_login` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('221000101', '221000101', '张三', '男', '2017-04-16');
INSERT INTO `student` VALUES ('221000102', '221000102', '李四', '男', '2017-04-16');
INSERT INTO `student` VALUES ('221000103', '221000103', '王五', '男', '2017-04-16');
INSERT INTO `student` VALUES ('221000104', '221000104', '小明', '男', '2017-04-16');
INSERT INTO `student` VALUES ('221000105', '221000105', '小红', '女', '2017-04-16');
INSERT INTO `student` VALUES ('221000106', '221000106', '小张', '男', '2017-04-16');
INSERT INTO `student` VALUES ('221000107', '221000107', '小华', '男', '2017-04-16');
INSERT INTO `student` VALUES ('221000108', '221000108', '小燕', '女', '2017-04-16');
INSERT INTO `student` VALUES ('221000109', '221000109', '小光', '女', '2017-04-16');
INSERT INTO `student` VALUES ('221000110', '221000110', '小天', '男', '2017-04-16');
INSERT INTO `student` VALUES ('221400210', '221400210', '郑鑫', '男', '1900-01-01');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `last_login` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('22001', '22001', '王东', '男', '2017-04-16');
INSERT INTO `teacher` VALUES ('22002', '22002', '张强', '男', '2017-04-16');
INSERT INTO `teacher` VALUES ('22003', '22003', '刘军', '男', '2017-04-16');
INSERT INTO `teacher` VALUES ('22004', '22004', '刘丽', '女', '2017-04-16');

-- ----------------------------
-- Table structure for `teaching_programme`
-- ----------------------------
DROP TABLE IF EXISTS `teaching_programme`;
CREATE TABLE `teaching_programme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`,`year`),
  UNIQUE KEY `year` (`year`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teaching_programme
-- ----------------------------
INSERT INTO `teaching_programme` VALUES ('1', '2017教学大纲', '2017教学大纲', '2017', '2017-04-18');
INSERT INTO `teaching_programme` VALUES ('2', '2016教学大纲', '2016教学大纲', '2016', '2016-05-05');
INSERT INTO `teaching_programme` VALUES ('3', '2015大纲', '2222', '2015', '2017-04-19');
