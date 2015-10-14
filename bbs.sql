/*
Navicat MySQL Data Transfer

Source Server         : huangxj
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-10-14 22:17:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bbs_group
-- ----------------------------
DROP TABLE IF EXISTS `bbs_group`;
CREATE TABLE `bbs_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_group
-- ----------------------------
INSERT INTO `bbs_group` VALUES ('1', '游客', 'E');
INSERT INTO `bbs_group` VALUES ('2', '普通会员', null);
INSERT INTO `bbs_group` VALUES ('3', '版主', null);
INSERT INTO `bbs_group` VALUES ('4', '分区版主', null);
INSERT INTO `bbs_group` VALUES ('5', '超级版主', 'A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q');
INSERT INTO `bbs_group` VALUES ('6', '管理员', 'A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q');

-- ----------------------------
-- Table structure for bbs_user
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_74c73ajgxwqhq220m4odm0dcx` (`group_id`),
  CONSTRAINT `FK_74c73ajgxwqhq220m4odm0dcx` FOREIGN KEY (`group_id`) REFERENCES `bbs_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_user
-- ----------------------------
