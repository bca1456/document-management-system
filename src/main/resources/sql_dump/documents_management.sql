/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mariadb
 Source Server Type    : MariaDB
 Source Server Version : 100506
 Source Host           : localhost:3306
 Source Schema         : documents_management

 Target Server Type    : MariaDB
 Target Server Version : 100506
 File Encoding         : 65001

 Date: 13/10/2020 13:01:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for documents
-- ----------------------------
DROP TABLE IF EXISTS `documents`;
CREATE TABLE `documents`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` datetime(0) NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of documents
-- ----------------------------
INSERT INTO `documents` VALUES (1, '2020-09-30 12:58:09', 'deprecated', 'ivan', 'ivan.txt');
INSERT INTO `documents` VALUES (2, '2020-06-03 12:58:25', 'new', 'sasha', 'sasha.txt');
INSERT INTO `documents` VALUES (3, '2020-10-03 12:58:45', 'need to fix', 'petya', 'petya.txt');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
