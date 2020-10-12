/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : userinfo

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 08/03/2020 21:38:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` tinyint(255) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zsy', '男', 26, NULL, '123a', '123@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (3, 'zsy', '男', 26, NULL, '123a', '123@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (4, 'zsy', '男', 26, NULL, '123a', '123@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (5, 'zsy', '男', 26, NULL, '123a', '123@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (6, 'zsy', '男', 26, NULL, '123a', '123@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (7, 'zsy', '男', 26, NULL, '123a', '123@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (8, 'zsy', '男', 26, NULL, '123a', '123@qq.com', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
