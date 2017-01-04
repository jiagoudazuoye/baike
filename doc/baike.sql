/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : baike

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-01-04 15:32:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bmanager
-- ----------------------------
DROP TABLE IF EXISTS `bmanager`;
CREATE TABLE `bmanager` (
  `bmanager_id` int(11) NOT NULL AUTO_INCREMENT,
  `bmanager_name` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `state` int(1) DEFAULT '1',
  PRIMARY KEY (`bmanager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `entry_id` int(11) NOT NULL COMMENT '词条编号',
  `content` text COMMENT '评论内容',
  `comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for entry
-- ----------------------------
DROP TABLE IF EXISTS `entry`;
CREATE TABLE `entry` (
  `entry_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '词条编号',
  `template_id` int(11) DEFAULT NULL COMMENT '模版编号',
  `content` text COMMENT '内容',
  `entry_name` varchar(20) DEFAULT NULL COMMENT '词条名',
  `keyword` varchar(100) DEFAULT NULL COMMENT '关键字',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(1) DEFAULT '0' COMMENT '词条状态0：未审核，1：通过，2：审核失败',
  PRIMARY KEY (`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for modify_info
-- ----------------------------
DROP TABLE IF EXISTS `modify_info`;
CREATE TABLE `modify_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `entry_id` int(11) NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `template_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `grade` int(2) DEFAULT NULL,
  `score` int(6) DEFAULT NULL,
  `state` int(1) DEFAULT '1',
  `email` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
