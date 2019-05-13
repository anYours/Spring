/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2019-05-13 17:51:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `released` datetime(6) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `sal` float DEFAULT NULL,
  `times` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '三国演义', '2019-02-15 16:39:45.000000', '四大名著', '罗贯中', '20', null);
INSERT INTO `book` VALUES ('2', '水浒传', '2019-02-15 16:40:43.000000', '四大名著', '施耐庵', '30', null);
INSERT INTO `book` VALUES ('3', '红楼梦', '2019-02-15 16:41:13.000000', '四大名著', '曹雪芹', '40', null);
INSERT INTO `book` VALUES ('4', '西游记', '2019-02-15 16:41:37.000000', '四大名著', '吴承恩', '50', null);
INSERT INTO `book` VALUES ('7', '武动乾坤', '2019-02-18 16:49:46.000000', '玄幻', '天蚕土豆', '60', null);
INSERT INTO `book` VALUES ('8', '三国演义', null, '四大名著', '罗贯中', '20', null);
INSERT INTO `book` VALUES ('10', '水浒传', null, '四大名著', '施耐庵', '30', null);
INSERT INTO `book` VALUES ('11', '红楼梦', null, '四大名著', '曹雪芹', '40', null);
INSERT INTO `book` VALUES ('12', '西游记', null, '四大名著', '吴承恩', '50', null);
INSERT INTO `book` VALUES ('13', '武动乾坤', null, '玄幻', '天蚕土豆', '60', null);
INSERT INTO `book` VALUES ('14', '三国演义', null, '四大名著', '罗贯中', '20', null);
INSERT INTO `book` VALUES ('19', '测试', '2019-04-11 00:00:00.000000', '打发', '测试', '123', null);
INSERT INTO `book` VALUES ('20', '测试', '2019-04-11 00:00:00.000000', '彩色', '测试', '1231', null);
INSERT INTO `book` VALUES ('21', '测试1', '2019-04-11 00:00:00.000000', '富士达', '厕所', '1234', null);
INSERT INTO `book` VALUES ('23', '测试', '2019-04-11 00:00:00.000000', '发撒旦', '发送', '12312', null);
INSERT INTO `book` VALUES ('24', '测试', '2019-04-11 00:00:00.000000', '富士达', '范德萨', '123', null);
INSERT INTO `book` VALUES ('25', '范德萨', '2019-04-11 00:00:00.000000', '发的', '213', '2342', null);
INSERT INTO `book` VALUES ('26', '二', '2019-04-11 00:00:00.000000', '都是', '等分', '343', null);
INSERT INTO `book` VALUES ('27', '二1', '2019-04-11 00:00:00.000000', '都是', '等分', '343', null);
INSERT INTO `book` VALUES ('28', '432', '2019-04-11 00:00:00.000000', '21312', '11', '22', null);
INSERT INTO `book` VALUES ('29', '42', '2019-04-11 00:00:00.000000', '534534', '234', '2345', null);
INSERT INTO `book` VALUES ('30', '565', '2019-04-11 00:00:00.000000', '34543', '34', '35', null);
INSERT INTO `book` VALUES ('31', 'ocmp', '2019-04-11 00:00:00.000000', '21312', '1231', '1231', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `pwd` varchar(200) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `headImg` varchar(1000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('41', '32432', null, '423', '423', '2017-03-02', '', null, '2019-03-08 13:08:23', '1');
INSERT INTO `user` VALUES ('42', '22', '9eff7916726cf22042abe2e23b3e2bf6', '31', '13', '2017-03-16', '', '2017-03-01 10:09:36', '2017-03-01 10:09:36', '1');
INSERT INTO `user` VALUES ('43', '321', '9eff7916726cf22042abe2e23b3e2bf6', '3123', '11', '2017-03-18', '', '2017-03-01 10:09:45', '2017-03-01 10:09:45', '1');
INSERT INTO `user` VALUES ('44', '11', '9eff7916726cf22042abe2e23b3e2bf6', '212', '21', '2017-03-24', '', '2017-03-01 10:09:54', '2017-03-01 10:09:54', '1');
INSERT INTO `user` VALUES ('45', '3123', '9eff7916726cf22042abe2e23b3e2bf6', '11', '11', '2017-03-24', '', '2017-03-01 10:10:02', '2017-03-01 10:10:02', '1');
INSERT INTO `user` VALUES ('46', '13123', '9eff7916726cf22042abe2e23b3e2bf6', '3123', '1231', '2017-03-24', '', '2017-03-01 10:10:10', '2017-03-01 10:10:10', '1');
INSERT INTO `user` VALUES ('47', '3123', '9eff7916726cf22042abe2e23b3e2bf6', '3123', '132', '2017-03-03', '', '2017-03-01 10:10:17', '2017-03-01 10:10:17', '1');
INSERT INTO `user` VALUES ('48', '312', '9eff7916726cf22042abe2e23b3e2bf6', '312', '312', '2017-03-09', '', '2017-03-01 10:10:26', '2019-03-08 13:07:11', '0');
INSERT INTO `user` VALUES ('49', '3123', '9eff7916726cf22042abe2e23b3e2bf6', '3123', '312', '2017-03-03', '', '2017-03-01 10:10:34', '2017-03-01 10:10:34', '1');
INSERT INTO `user` VALUES ('50', '3123', null, '312', '312', '2017-03-03', '', null, '2019-03-08 13:08:16', '0');
INSERT INTO `user` VALUES ('51', '1321', '9eff7916726cf22042abe2e23b3e2bf6', '321', '321', '2017-03-02', '', '2017-03-01 10:10:49', '2017-03-01 10:10:49', '1');
