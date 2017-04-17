/*
Navicat MySQL Data Transfer

Source Server         : mysqlC
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-04-16 12:08:18
*/

SET FOREIGN_KEY_CHECKS=0;

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
