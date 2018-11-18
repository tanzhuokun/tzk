/*
Navicat MySQL Data Transfer

Source Server         : 1232
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : health_platform

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-30 10:28:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for `tbl_admin_account`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_admin_account`;
CREATE TABLE `tbl_admin_account` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `isremove` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除:1、已删除;0、未删除',
  `serial` varchar(100) NOT NULL COMMENT '编号',
  `subtime` varchar(20) DEFAULT NULL COMMENT '新增时间:格式（2015-12-23 10:12:10）',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间:格式（2015-12-23 10:12:10）',
  `address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `city` varchar(100) DEFAULT NULL COMMENT '市区',
  `county` varchar(100) DEFAULT NULL COMMENT '县',
  `province` varchar(100) DEFAULT NULL COMMENT '省份',
  `region` varchar(200) DEFAULT NULL COMMENT '地区（省市县区）',
  `account` varchar(30) NOT NULL COMMENT '用户账号',
  `account_pic` varchar(200) NOT NULL COMMENT '账号图像',
  `birth` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `lastip` varchar(24) DEFAULT NULL COMMENT '上次登录ip地址',
  `lastlogin` varchar(20) DEFAULT NULL COMMENT '上次登录时间:格式（2015-12-23 10:12:10）',
  `mail` varchar(30) DEFAULT NULL COMMENT '用户邮箱',
  `nickname` varchar(10) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(200) DEFAULT NULL COMMENT '登录密码',
  `phone` varchar(12) DEFAULT NULL COMMENT '用户手机号:不能为null',
  `password_strength` int(2) NOT NULL DEFAULT '0' COMMENT '密码强度:默认值为0',
  `regtime` varchar(20) DEFAULT NULL COMMENT '注册时间:格式（2015-12-23 10:12:10）',
  `salt` varchar(12) NOT NULL DEFAULT '20481218' COMMENT '密码盐:默认值为20481218',
  `adac_realname` varchar(10) NOT NULL COMMENT '管理员真实姓名',
  `adac_role` varchar(255) DEFAULT NULL,
  `adac_role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_admin_account
-- ----------------------------
INSERT INTO `tbl_admin_account` VALUES ('1', '0', '20181016143131107522261509184', '2018-10-16 14:31:31', null, null, null, null, null, null, 'ynzs2016', 'http://www.baidu.com', '2014年12月18日', '男', '0:0:0:0:0:0:0:1', '2018-10-16 14:31:31', '111111111@qq.com', null, '07eda1f755125dc118c6c878dac2f523', '11111111111', '0', '2018-10-16 14:31:31', '20491', '默认', null, null);

-- ----------------------------
-- Table structure for `tbl_server`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_server`;
CREATE TABLE `tbl_server` (
  `s_id` int(11) NOT NULL,
  `cpu` varchar(50) DEFAULT NULL,
  `hdd` varchar(50) DEFAULT NULL,
  `ram` varchar(50) DEFAULT NULL,
  `rate` varchar(50) DEFAULT NULL,
  `subTime` varchar(50) DEFAULT NULL,
  `serverName` varchar(50) DEFAULT NULL,
  `ss_id` int(11) DEFAULT NULL,
  `profiler` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_server
-- ----------------------------
INSERT INTO `tbl_server` VALUES ('1', '50%', '50%', '50%', '70%', '2018-10-23 02:00:00', '一号机', '1001', '正常');
INSERT INTO `tbl_server` VALUES ('2', '60%', '60%', '60%', '80%', '2018-10-24 02:00:00', '一号机', '1001', '正常');
INSERT INTO `tbl_server` VALUES ('3', '55%', '55%', '50%', '65%', '2018-10-25 02:00:00', '一号机', '1001', '正常');
INSERT INTO `tbl_server` VALUES ('4', '40%', '40%', '40%', '65%', '2018-10-26 02:00:00', '一号机', '1001', '正常');
INSERT INTO `tbl_server` VALUES ('5', '45%', '45%', '45%', '60%', '2018-10-28 02:00:00', '一号机', '1001', '正常');
INSERT INTO `tbl_server` VALUES ('6', '50%', '50%', '60%', '70%', '2018-10-30 02:00:00', '一号机', '1001', '正常');
INSERT INTO `tbl_server` VALUES ('7', '40%', '50%', '505', '70%', '2018-10-27 02:00:00', '一号机', '1001', '正常');
INSERT INTO `tbl_server` VALUES ('8', '43%', '50%', '40%', '70%', '2018-10-29 02:00:00', '一号机', '1001', '正常');

-- ----------------------------
-- Table structure for `tbl_sms`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sms`;
CREATE TABLE `tbl_sms` (
  `id` int(11) NOT NULL,
  `sms_code` varchar(6) DEFAULT NULL,
  `sms_count` int(11) DEFAULT NULL,
  `sms_endtime` varchar(20) DEFAULT NULL,
  `sms_key` varchar(255) DEFAULT NULL,
  `sms_phone` varchar(11) DEFAULT NULL,
  `sms_platform` varchar(255) DEFAULT NULL,
  `sms_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_sms
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_syslog`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_syslog`;
CREATE TABLE `tbl_syslog` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `isremove` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除:1、已删除;0、未删除',
  `serial` varchar(100) NOT NULL COMMENT '编号',
  `subtime` varchar(20) DEFAULT NULL COMMENT '新增时间:格式（2015-12-23 10:12:10）',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间:格式（2015-12-23 10:12:10）',
  `clazz` varchar(50) DEFAULT NULL,
  `loglevel` varchar(50) DEFAULT NULL,
  `logmsg` text,
  `method` varchar(255) DEFAULT NULL,
  `optype` varchar(50) DEFAULT NULL,
  `respones` bigint(20) DEFAULT NULL,
  `userip` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `ss_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=MyISAM AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_syslog
-- ----------------------------
INSERT INTO `tbl_syslog` VALUES ('1', '0', '20181016141410106481240796867', '2018-10-16 01:14:10', '2018-10-16 14:14:10', null, 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor]', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('2', '0', '20181016141521106552714028980', '2018-10-16 01:15:21', '2018-10-16 14:15:21', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor]', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('3', '0', '20181016141524106555281960874', '2018-10-16 01:15:24', '2018-10-16 14:15:24', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('4', '0', '20181016142222106973054585476', '2018-10-16 01:22:22', '2018-10-16 14:22:22', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1] ingErrorHandler$DefaultExceptionStrategy', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('5', '0', '20181016142222106973064935465', '2018-10-16 02:22:22', '2018-10-16 14:22:22', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1] ingErrorHandler$DefaultExceptionStrategy', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('6', '0', '20181016142606107197517071262', '2018-10-16 02:22:22', '2018-10-16 14:26:06', null, 'DEBUG', 'Fatal message conversion error; message rejected; it will be dropped or routed to a dead letter exchange, if so configured: (Body:\'[B@39fa4a5a(byte[113])\' MessageProperties [headers={}, contentType=application/x-java-serialized-object, contentLength=0, receivedDeliveryMode=PERSISTENT, priority=0, redelivered=false, receivedExchange=, receivedRoutingKey=lyhTest1, deliveryTag=1, consumerTag=amq.ctag-Zu5LtG_JeMP4yIUN2G1SNQ, consumerQueue=lyhTest1])', '[cTaskExecutor-1] ingErrorHandler$DefaultExceptionStrategy', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('7', '0', '20181016142606107197606511744', '2018-10-16 02:22:22', '2018-10-16 14:26:06', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('8', '0', '20181016142635107226495066097', '2018-10-16 02:26:35', '2018-10-16 14:26:35', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('9', '0', '20181016142642107233200938562', '2018-10-16 02:22:22', '2018-10-16 14:26:42', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('10', '0', '20181016143113107504304563885', '2018-10-16 03:31:13', '2018-10-16 14:31:13', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1001', '1001');
INSERT INTO `tbl_syslog` VALUES ('11', '0', '20181017164304201817187629156', '2018-10-16 03:31:1', '2018-10-17 16:43:04', null, 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1002', '1001');
INSERT INTO `tbl_syslog` VALUES ('12', '0', '20181017164304201817277458263', '2018-10-16 03:31:1', '2018-10-17 16:43:04', null, 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor]', null, '1000', '186.231.1.1', '1002', '1001');
INSERT INTO `tbl_syslog` VALUES ('13', '0', '20181017164304201817280632041', '2018-10-16 03:31:1', '2018-10-17 16:43:04', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1002', '1001');
INSERT INTO `tbl_syslog` VALUES ('14', '0', '20181017164304201817283394574', '2018-10-16 03:31:1', '2018-10-17 16:43:04', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1002', '1001');
INSERT INTO `tbl_syslog` VALUES ('15', '0', '20181023154141455586537238280', '2018-10-23 04:41:41', '2018-10-23 15:41:41', null, 'WARN', 'Fatal message conversion error', '[cTaskExecutor]', null, '1000', '186.231.1.1', '1002', '1001');
INSERT INTO `tbl_syslog` VALUES ('16', '0', '20181023154415455740651321897', '2018-10-23 04:41:41', '2018-10-23 15:44:15', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', '1001');
INSERT INTO `tbl_syslog` VALUES ('17', '0', '20181026150735712754131565149', '2018-10-23 04:41:41', '2018-10-26 15:07:35', null, 'WARN', 'Fatal message conversion error', '[Main]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('18', '0', '20181026150752712770955802417', '2018-10-23 04:41:41', '2018-10-26 15:07:52', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-2]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('19', '0', '20181026150758712777227068179', '2018-10-24 05:07:58', '2018-10-26 15:07:58', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('20', '0', '20181026150804712782658728428', '2018-10-24 05:07:58', '2018-10-26 15:08:04', null, 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('21', '0', '20181026150810712788761871886', '2018-10-24 05:07:58', '2018-10-26 15:08:10', null, 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('22', '0', '20181026150819712798082746708', '2018-10-246 05:07:58', '2018-10-26 15:08:19', null, 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('23', '0', '20181026150827712805860919853', '2018-10-24 06:08:27', '2018-10-26 15:08:27', null, 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('24', '0', '20181026150840712819446347368', '2018-10-24 06:08:27', '2018-10-26 15:08:40', null, 'ERROR', 'Fatal message conversion error', '[Main]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('25', '0', '20181026150915712853920175190', '2018-10-24 06:08:27', '2018-10-26 15:09:15', null, 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('26', '0', '20181026151017712915658380926', '2018-10-24 06:08:27', '2018-10-26 15:10:17', null, 'WARN', 'Fatal message conversion error', '[cTaskExecutor-2]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('27', '0', '20181026151024712922743119091', '2018-10-24 07:10:24', '2018-10-26 15:10:24', null, 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', null, '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('28', '0', '20181026151027712925950662876', '2018-10-24 07:10:24', '2018-10-26 15:10:27', '', 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('29', '0', '20181026151031712930478120196', '2018-10-24 07:10:24', '2018-10-26 15:10:31', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('30', '0', '20181026151034712933440802237', '2018-10-24 07:10:24', '2018-10-26 15:10:34', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('31', '0', '20181026151038712936846713377', '2018-10-24 08:10:38', '2018-10-26 15:10:38', '', 'WARN', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('32', '0', '20181026151042712941039335632', '2018-10-24 08:10:38', '2018-10-26 15:10:42', '', 'ERROR', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('33', '0', '20181026151045712944082943078', '2018-10-24 08:10:38', '2018-10-26 15:10:45', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('34', '0', '20181026151049712948287682168', '2018-10-24 08:10:38', '2018-10-26 15:10:49', '', 'ERROR', 'Fatal message conversion error', '[cTaskExecutor]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('35', '0', '20181026151054712952541364101', '2018-10-24 09:10:54', '2018-10-26 15:10:54', '', 'WARN', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('36', '0', '20181026151120712978802982044', '2018-10-24 09:10:54', '2018-10-26 15:11:20', '', 'ERROR', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('37', '0', '20181026151120712978965422991', '2018-10-24 09:10:54', '2018-10-26 15:11:20', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('38', '0', '20181026151120712979104409580', '2018-10-24 09:10:54', '2018-10-26 15:11:20', '', 'ERROR', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('39', '0', '20181026151120712979256559108', '2018-10-24 10:11:20', '2018-10-26 15:11:20', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('40', '0', '20181026151120712979403247297', '2018-10-24 10:11:20', '2018-10-26 15:11:20', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('41', '0', '20181026151121712979575372562', '2018-10-24 10:11:20', '2018-10-26 15:11:21', '', 'INFO', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('42', '0', '20181026151121712979722161506', '2018-10-24 10:11:20', '2018-10-26 15:11:21', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('43', '0', '20181026151121712979873272126', '2018-10-24 11:11:21', '2018-10-26 15:11:21', '', 'ERROR', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('44', '0', '20181026151121712980032876508', '2018-10-24 11:11:21', '2018-10-26 15:11:21', '', 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('45', '0', '20181026151121712980184818358', '2018-10-24 11:11:21', '2018-10-26 15:11:21', '', 'INFO', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('46', '0', '20181026151121712980356885535', '2018-10-25 11:11:21', '2018-10-26 15:11:21', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('47', '0', '20181026151121712980514456307', '2018-10-25 12:11:21', '2018-10-26 15:11:21', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('48', '0', '20181026151122712980691211683', '2018-10-25 12:11:21', '2018-10-26 15:11:22', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('49', '0', '20181026151122712980843461967', '2018-10-25 12:11:21', '2018-10-26 15:11:22', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('50', '0', '20181026151122712981000550555', '2018-10-25 12:11:21', '2018-10-26 15:11:22', '', 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('51', '0', '20181026151122712981169708684', '2018-10-25 13:11:22', '2018-10-26 15:11:22', '', 'ERROR', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('52', '0', '20181026151122712981333656846', '2018-10-24 13:11:22', '2018-10-26 15:11:22', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('53', '0', '20181026151122712981491111442', '2018-10-24 13:11:22', '2018-10-26 15:11:22', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('54', '0', '20181026151123712981649309878', '2018-10-24 15:11:23', '2018-10-26 15:11:23', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('55', '0', '20181026151123712981817311893', '2018-10-245 14:11:23', '2018-10-26 15:11:23', '', 'ERROR', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('56', '0', '20181026151123712981983367175', '2018-10-24 14:11:23', '2018-10-26 15:11:23', '', 'INFO', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('57', '0', '20181026151123712982159682518', '2018-10-24 14:11:23', '2018-10-26 15:11:23', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('58', '0', '20181026151123712982305486529', '2018-10-24 14:11:23', '2018-10-26 15:11:23', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('59', '0', '20181026151123712982474574746', '2018-10-24 15:11:23', '2018-10-26 15:11:23', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('60', '0', '20181026151124712982644991286', '2018-10-24 15:11:24', '2018-10-26 15:11:24', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('61', '0', '20181026151124712982808988284', '2018-10-24 15:11:24', '2018-10-26 15:11:24', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('62', '0', '20181026151124712982972406454', '2018-10-24 15:11:24', '2018-10-26 15:11:24', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('63', '0', '20181026151124712983149334553', '2018-10-24 16:11:24', '2018-10-26 15:11:24', '', 'WARN', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('64', '0', '20181026151124712983309507482', '2018-10-24 16:11:24', '2018-10-26 15:11:24', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('65', '0', '20181026151124712983458448267', '2018-10-24 16:11:24', '2018-10-26 15:11:24', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('66', '0', '20181026151125712983609419578', '2018-10-24 16:11:24', '2018-10-26 15:11:25', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('67', '0', '20181026151125712983771791642', '2018-10-24 17:11:25', '2018-10-26 15:11:25', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('68', '0', '20181026151125712983937434650', '2018-10-24 17:11:25', '2018-10-26 15:11:25', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('69', '0', '20181026151125712984113717094', '2018-10-24 17:11:25', '2018-10-26 15:11:25', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('70', '0', '20181026151125712984275620338', '2018-10-24 17:11:25', '2018-10-26 15:11:25', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('71', '0', '20181026151125712984444827816', '2018-10-24 18:11:25', '2018-10-26 15:11:25', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('72', '0', '20181026151126712984617414191', '2018-10-24 18:11:25', '2018-10-26 15:11:26', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('73', '0', '20181026151126712984794462579', '2018-10-24 18:11:25', '2018-10-26 15:11:26', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('74', '0', '20181026151126712984953904519', '2018-10-24 19:11:26', '2018-10-26 15:11:26', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('75', '0', '20181026151126712985133336075', '2018-10-245 19:11:26', '2018-10-26 15:11:26', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('76', '0', '20181026151126712985305943011', '2018-10-245 19:11:26', '2018-10-26 15:11:26', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('77', '0', '20181026151126712985484427160', '2018-10-24 20:11:26', '2018-10-26 15:11:26', '', 'INFO', 'Fatal message conversion error', 'v', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('78', '0', '20181026151127712985658979802', '2018-10-24 20:11:26', '2018-10-26 15:11:27', '', 'WARN', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('79', '0', '20181026151127712985836932931', '2018-10-24 20:11:26', '2018-10-26 15:11:27', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('80', '0', '20181026151127712986005000231', '2018-10-24 20:11:26', '2018-10-26 15:11:27', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('81', '0', '20181026151127712986174573204', '2018-10-24 21:11:27', '2018-10-26 15:11:27', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('82', '0', '20181026151127712986335066390', '2018-10-24 21:11:27', '2018-10-26 15:11:27', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('83', '0', '20181026151127712986504795636', '2018-10-24 21:11:27', '2018-10-26 15:11:27', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('84', '0', '20181026151128712986676922444', '2018-10-24 21:11:27', '2018-10-26 15:11:28', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('85', '0', '20181026151128712986849232256', '2018-10-24 22:11:28', '2018-10-26 15:11:28', '', 'WARN', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('86', '0', '20181026151128712987026345929', '2018-10-24 22:11:28', '2018-10-26 15:11:28', '', 'WARN', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('87', '0', '20181026151128712987204477435', '2018-10-24 22:11:28', '2018-10-26 15:11:28', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('88', '0', '20181026151128712987364800468', '2018-10-24 22:11:28', '2018-10-26 15:11:28', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('89', '0', '20181026151129712987540494831', '2018-10-24 23:11:29', '2018-10-26 15:11:29', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('90', '0', '20181026151129712987713969495', '2018-10-24 23:11:29', '2018-10-26 15:11:29', '', 'WARN', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('91', '0', '20181026151129712987889874621', '2018-10-24 23:11:29', '2018-10-26 15:11:29', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('92', '0', '20181026151129712988068619911', '2018-10-24 23:11:29', '2018-10-26 15:11:29', '', 'INFO', 'Fatal message conversion error', '[cTaskExecutor]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('93', '0', '20181026151129712988228033578', '2018-10-24 24:11:29', '2018-10-26 15:11:29', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('94', '0', '20181026151129712988406239622', '2018-10-24 24:11:29', '2018-10-26 15:11:29', '', 'INFO', 'Fatal message conversion error', '[Main]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('95', '0', '20181026151130712988562062087', '2018-10-24 24:11:29', '2018-10-26 15:11:30', '', 'WARN', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('96', '0', '20181026151130712988722505410', '2018-10-24 24:11:29', '2018-10-26 15:11:30', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('97', '0', '20181026151130712988865616277', '2018-10-24 24:11:29', '2018-10-26 15:11:30', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-1]', '', '1000', '186.231.1.1', '1002', null);
INSERT INTO `tbl_syslog` VALUES ('98', '0', '20181026151130712989009353779', '2018-10-24 24:11:29', '2018-10-26 15:11:30', '', 'DEBUG', 'Fatal message conversion error', '[cTaskExecutor-2]', '', '1000', '186.231.1.1', '1002', null);
