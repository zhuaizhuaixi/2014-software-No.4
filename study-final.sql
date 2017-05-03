/*
Navicat MySQL Data Transfer

Source Server         : zx
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-04-27 18:16:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `exercises`
-- ----------------------------
DROP TABLE IF EXISTS `exercises`;
CREATE TABLE `exercises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) NOT NULL,
  `A` varchar(255) NOT NULL,
  `B` varchar(255) NOT NULL,
  `C` varchar(255) NOT NULL,
  `D` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercises
-- ----------------------------
INSERT INTO `exercises` VALUES ('1', '“软件危机”是指( )', '计算机病毒的出现', '利用计算机进行经济犯罪活动', '软件开发和维护中出现的一系列问题', '人们过分迷恋计算机系统', 'C');
INSERT INTO `exercises` VALUES ('2', 'DFD中的每个加工至少需要( )', '一个输入流', '一个输出流', '一个输入或输出流', '一个输入流和一个输出流', 'D');
INSERT INTO `exercises` VALUES ('3', '为了提高模块的独立性，模块之间最好是( )', '控制耦合', '性能需求', '内容耦合', '数据耦合', 'D');
INSERT INTO `exercises` VALUES ('4', '下面关于PDL语言不正确的说法是( )', 'PDL是描述处理过程怎么做', 'PDL是只描述加工做什么', 'PDL也称为伪码', 'PDL的外层语法应符合一般程序设计语言常用的语法规则', 'B');
INSERT INTO `exercises` VALUES ('5', '详细设计与概要设计衔接的图形工具是( ) ', ' DFD图', '程序图', 'PAD图', 'SC图', 'D');
INSERT INTO `exercises` VALUES ('6', '不适合作为数据处理与数据库应用的语言是( )', 'SQL', 'Cobol', '4GL', 'Lisp', 'D');
INSERT INTO `exercises` VALUES ('7', '下列关于功能性注释不正确的说法是( )', '功能性注释嵌在源程序中，用于说明程序段或语句的功能以及数据的状态', '注释用来说明程序段，需要在每一行都要加注释', '可使用空行或缩进，以便很容易区分注释和程序', '修改程序也应修改注释', 'B');
INSERT INTO `exercises` VALUES ('8', '下列关于效率的说法不正确的是( )', '效率是一个性能要求，其目标应该在需求分析时给出', '提高程序效率的根本途径在于选择良好的设计方法，数据结构与算法', '效率主要指处理机时间和存储器容量两个方面', '程序的效率与程序的简单性无关', 'D');
INSERT INTO `exercises` VALUES ('9', '测试的关键问题是( )', '如何组织对软件的评审', '如何验证程序的正确性', '如何采用综合策略', '如何选择测试用例', 'D');
INSERT INTO `exercises` VALUES ('10', '结构化维护与非结构化维护的主要区别在于( )', '软件是否结构化', '软件配置是否完整', '程序的完整性', '文档的完整性', 'D');
INSERT INTO `exercises` VALUES ('11', '软件维护困难的主要原因是( )', '费用低', '人员少', '开发方法的缺陷', '得不到用户支持', 'C');
INSERT INTO `exercises` VALUES ('12', '可维护性的特性中，相互矛盾的是( )', '可理解性与可测试性', '效率与可修改性', '可修改性和可理解性', '可理解性与可读性', 'B');
INSERT INTO `exercises` VALUES ('13', '快速原型是利用原型辅助软件开发的一种新思想，它是在研究( )的方法和技术中产生的。', '需求阶段', '设计阶段', '测试阶段', '软件开发的各个阶段', 'A');
INSERT INTO `exercises` VALUES ('14', '从目前情况来看，增量模型存在的主要问题是( )', '用户很难适应这种系统开发方法', '该方法的成功率很低', '缺乏丰富而强有力的软件工具和开发环境', '缺乏对开发过程中的问题和错误具有应付变化的机制', 'C');
INSERT INTO `exercises` VALUES ('15', '下列有关软件工程的标准，属于行业标准的是( )', 'GB', 'DIN', 'ISO', 'IEEE', 'D');
INSERT INTO `exercises` VALUES ('16', '下列文档与维护人员有关的有( )', '软件需求说明书', '项目开发计划', '概要设计说明书', '操作手册', 'C');
INSERT INTO `exercises` VALUES ('17', '在屏蔽软件错误的冗错技术中，冗余附加件的构成包括( )', '关键程序和数据的冗余存储和调用', '为检测或纠正信息在运算或传输中的错误须外加的一部分信息', '检测、表决、切换、重构、纠错和复算的实现', '实现错误检测和错误恢复的程序', 'D');
INSERT INTO `exercises` VALUES ('18', '( )是为了确保每个开发过程的质量，防止把软件差错传递到下一个过程而进行的工作。', '质量检测', '软件容错', '软件维护', '系统容错', 'A');
INSERT INTO `exercises` VALUES ('19', '表示对象相互行为的模型是模型( )', '动态模型', '功能模型', '对象模型', '静态模型', 'A');
INSERT INTO `exercises` VALUES ('20', 'CASE工具的表示集成是指CASE工具提供相同的( )', '编程环境', '用户界面', '过程模型', '硬件\r\n/\r\n操作系统', 'B');
INSERT INTO `exercises` VALUES ('21', '1+1', '2', '3', '4', '5', 'A');

-- ----------------------------
-- Table structure for `experiment`
-- ----------------------------
DROP TABLE IF EXISTS `experiment`;
CREATE TABLE `experiment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `experiment` varchar(255) NOT NULL,
  `requires` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of experiment
-- ----------------------------
INSERT INTO `experiment` VALUES ('1', '实验1', '完善性维护一个已有的库存清单系统，新增一个能在每天送给采购员一份订货报表的功能。新增该功能共投资了5000元，系统维护后能及时订货，消除零件短缺问题，每年可节约2500元，若系统生存期为5年,年利率为5％,请计算：①.货币的时间价值；②纯收入00');
INSERT INTO `experiment` VALUES ('2', '实验2', '假设某软件生命周期为5年。现在投资20万，年利率为3％。从每一年年底收入5万元，请计算该项目的①.货币的时间价值；②投资回收期(保留小数点后两位)。');
INSERT INTO `experiment` VALUES ('3', '实验3', '某计算机系统投入使用后，5年内每年可节省人民币 2O0O元，假设系统的投资额为5000元，年利率为 12％。试计算投资回收期和纯收入。(保留小数点后两位）。\r\n');
INSERT INTO `experiment` VALUES ('4', '实验4', '某计算机系统共投资了5.5万元，系统投入使用后每年可节约2万元，若系统生存期为4年,年利率为5％,请计算：①.货币的时间价值；②.投资回收期；③.纯收入。');
INSERT INTO `experiment` VALUES ('5', '实验5', '画出下面用\r\nPDL\r\n写出的程序的\r\nPAD\r\n图。<br/>\r\n \r\nWHILE P DO<br/>  \r\n     IF A >O THEN A1 ELSE A2 ENDIF;<br/> \r\n     S1;<br/>  \r\n     IF B>0 THEN B1;<br/>  \r\n          WHILE C DO S2;<br/>S3 <br/>ENDWHILE;<br/> \r\n     ELSE B2 <br/>\r\n     ENDIF;<br/> \r\n     B3  \r\n     E');
INSERT INTO `experiment` VALUES ('6', '实验6', '请画出求1 + 3 + 5 +„+ n的PAD图。');
INSERT INTO `experiment` VALUES ('7', '实验7', '请使用PAD图描述在数组A（1）～A（10）中找最大数的算法。');
INSERT INTO `experiment` VALUES ('8', '实验8', '某商场在“五一”期间，顾客购物时收费有4种情况：普通顾客一次购物累计少于100元，按A类标准费（不打折，一次购物累计多于或等于100元，按B类标准收费（打9折）；会员顾客一次购物累计少于1000元，按C类标准收费（打8折），一次购物累计等于或多于1000元，按D类标准收费7折）。请使用PAD图来设计收费算法。');
INSERT INTO `experiment` VALUES ('9', '实验9', '请用判定表画出以下问题的行为逻辑：人们往往根据气情况决定出门时的行装；天气可能下雨，也可能不下雨；天气可能变冷，也可能不变冷。如果天气要下雨，出门时带上雨伞；如果天气变冷，出门时要穿上大衣。');

-- ----------------------------
-- Table structure for `historical_rudiment`
-- ----------------------------
DROP TABLE IF EXISTS `historical_rudiment`;
CREATE TABLE `historical_rudiment` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `operator` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `operator` (`operator`),
  CONSTRAINT `historical_rudiment_ibfk_1` FOREIGN KEY (`operator`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of historical_rudiment
-- ----------------------------
INSERT INTO `historical_rudiment` VALUES ('1', '221400101', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('2', '221400102', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('3', '221400103', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('4', '221400104', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('5', '221400105', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('6', '221400106', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('7', '221400107', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('8', '221400108', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('9', '221400109', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('10', '221400110', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('11', '221400111', '提交作业', '2017-04-01');
INSERT INTO `historical_rudiment` VALUES ('12', '221400112', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('13', '221400113', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('14', '221400114', '提交作业', '2017-04-26');
INSERT INTO `historical_rudiment` VALUES ('15', '221400115', '提交作业', '2017-04-26');

-- ----------------------------
-- Table structure for `message_board`
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `author` int(11) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `author` (`author`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_board
-- ----------------------------
INSERT INTO `message_board` VALUES ('1', '作业是什么？', '221400101', '2017-04-23 00:00:00');
INSERT INTO `message_board` VALUES ('2', '作业是实验1', '221400104', '2017-04-23 00:00:00');
INSERT INTO `message_board` VALUES ('3', '什么时候交作业', '221400109', '2017-04-26 00:00:00');
INSERT INTO `message_board` VALUES ('4', '这次作业怎么做啊', '221400112', '2017-04-26 00:00:00');
INSERT INTO `message_board` VALUES ('5', '你们作业做完了吗', '221400102', '2017-04-26 00:00:00');
INSERT INTO `message_board` VALUES ('6', '有人约电影吗~', '221400115', '2017-04-26 00:00:00');
INSERT INTO `message_board` VALUES ('7', '明天下大雨', '221400103', '2017-04-26 00:00:00');
INSERT INTO `message_board` VALUES ('8', '求推荐电影电视剧~', '221400112', '2017-04-26 00:00:00');
INSERT INTO `message_board` VALUES ('9', '求大神教我作业', '221400104', '2017-04-26 00:00:00');
INSERT INTO `message_board` VALUES ('13', '666', '221400210', '2017-04-26 20:25:15');
INSERT INTO `message_board` VALUES ('15', '66666', '22001', '2017-04-26 20:46:32');
INSERT INTO `message_board` VALUES ('16', '111', '221400210', '2017-04-27 14:49:21');
INSERT INTO `message_board` VALUES ('17', '888', '221400210', '2017-04-27 14:53:34');
INSERT INTO `message_board` VALUES ('18', '真是666', '22001', '2017-04-27 17:45:20');

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` int(11) NOT NULL,
  `time` date NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `score` double NOT NULL,
  `expid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student` (`student`),
  KEY `expid` (`expid`),
  CONSTRAINT `report_ibfk_1` FOREIGN KEY (`student`) REFERENCES `student` (`id`),
  CONSTRAINT `report_ibfk_2` FOREIGN KEY (`expid`) REFERENCES `experiment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '221400101', '2017-04-18', '221400101_实验1', '221400101_实验1', '-1', '1');
INSERT INTO `report` VALUES ('2', '221400102', '2017-04-26', '221400102_实验1', '221400102_实验1', '82', '1');
INSERT INTO `report` VALUES ('3', '221400103', '2017-04-26', '221400103_实验1', '221400103_实验1', '83', '1');
INSERT INTO `report` VALUES ('4', '221400104', '2017-04-26', '221400104_实验1', '221400104_实验1', '77', '1');
INSERT INTO `report` VALUES ('5', '221400105', '2017-04-26', '221400105_实验1', '221400105_实验1', '69', '1');
INSERT INTO `report` VALUES ('6', '221400106', '2017-04-26', '221400106_实验1', '221400106_实验1', '85', '1');
INSERT INTO `report` VALUES ('7', '221400107', '2017-04-26', '221400107_实验1', '221400107_实验1', '87', '1');
INSERT INTO `report` VALUES ('8', '221400108', '2017-04-26', '221400108_实验1', '221400108_实验1', '88', '1');
INSERT INTO `report` VALUES ('9', '221400109', '2017-04-26', '221400109_实验1', '221400109_实验1', '78', '1');
INSERT INTO `report` VALUES ('10', '221400110', '2017-04-26', '221400110_实验1', '221400110_实验1', '92', '1');
INSERT INTO `report` VALUES ('11', '221400111', '2017-04-26', '221400111_实验1', '221400111_实验1', '77', '1');
INSERT INTO `report` VALUES ('12', '221400112', '2017-04-26', '221400112_实验1', '221400112_实验1', '75', '1');
INSERT INTO `report` VALUES ('13', '221400113', '2017-04-26', '221400113_实验1', '221400113_实验1', '95', '1');
INSERT INTO `report` VALUES ('14', '221400114', '2017-04-26', '221400114_实验1', '221400114_实验1', '98', '1');
INSERT INTO `report` VALUES ('15', '221400115', '2017-04-26', '221400115_实验1', '221400115_实验1', '90', '1');
INSERT INTO `report` VALUES ('16', '221400102', '2017-04-27', 'zzzx', 'zx<br/>zx<br/>z<br/>x<br/>xc<br/>v<br/>v', '-1', '2');
INSERT INTO `report` VALUES ('17', '221400102', '2017-04-27', 'zzx', '21<br/>232<br/>22<br/>2<br/>', '-1', '7');
INSERT INTO `report` VALUES ('18', '221400102', '2017-04-27', '121', '120<br/>3<br/>3<br/>3<br/>3<br/>', '-1', '4');
INSERT INTO `report` VALUES ('19', '221400102', '2017-04-27', '222', '22222<br/>2<br/>2<br/>2<br/>2<br/>', '99', '5');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `last_login` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=221400211 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('221400101', '221400101', '林青', '女', '2017-04-23');
INSERT INTO `student` VALUES ('221400102', '221400102', '游少飞', '男', '2017-04-23');
INSERT INTO `student` VALUES ('221400103', '221400103', '曾志贤', '男', '2017-04-23');
INSERT INTO `student` VALUES ('221400104', '221400104', '李家亮', '男', '2017-04-23');
INSERT INTO `student` VALUES ('221400105', '221400105', '陈一路', '男', '2017-04-23');
INSERT INTO `student` VALUES ('221400106', '221400106', '陈凯伦', '男', '2017-04-23');
INSERT INTO `student` VALUES ('221400107', '221400107', '林逸可', '男', '2017-04-23');
INSERT INTO `student` VALUES ('221400108', '221400108', '林怡菲', '女', '2017-04-23');
INSERT INTO `student` VALUES ('221400109', '221400109', '刘星', '男', '2017-04-23');
INSERT INTO `student` VALUES ('221400110', '221400110', '朱星宇', '男', '2017-04-23');
INSERT INTO `student` VALUES ('221400111', '221400111', '夏雨', '男', '2017-04-26');
INSERT INTO `student` VALUES ('221400112', '221400112', '夏雪', '女', '2017-04-26');
INSERT INTO `student` VALUES ('221400113', '221400113', '陈方莉', '女', '2017-04-26');
INSERT INTO `student` VALUES ('221400114', '221400114', '陈雅静', '女', '2017-04-26');
INSERT INTO `student` VALUES ('221400115', '221400115', '林毅', '男', '2017-04-26');
INSERT INTO `student` VALUES ('221400210', '221400210', '郑鑫', '男', '1900-01-01');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `last_login` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('22001', '22001', '林毅', '男', '2017-04-23');
INSERT INTO `teacher` VALUES ('22002', '22002', '李鑫可', '男', '2017-04-23');
INSERT INTO `teacher` VALUES ('22003', '22003', '林巧灵', '女', '2017-04-23');
INSERT INTO `teacher` VALUES ('22004', '22004', '刘琳', '女', '2017-04-23');
INSERT INTO `teacher` VALUES ('22005', '22005', '陈凯', '男', '2017-04-23');

-- ----------------------------
-- Table structure for `teaching_programme`
-- ----------------------------
DROP TABLE IF EXISTS `teaching_programme`;
CREATE TABLE `teaching_programme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `year` year(4) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teaching_programme
-- ----------------------------
INSERT INTO `teaching_programme` VALUES ('1', '2015教学大纲', '2015教学大纲', '2015', '2015-04-23');
INSERT INTO `teaching_programme` VALUES ('2', '2016教学大纲', '2016教学大纲', '2016', '2016-04-18');
INSERT INTO `teaching_programme` VALUES ('12', '120', '20120<br/>2<br/>2<br/>2<br/>', '2001', '2017-04-27');
