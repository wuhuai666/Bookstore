/*
 Navicat Premium Data Transfer

 Source Server         : wuhuai
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 27/07/2021 19:16:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `sales` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `img_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (13, '西游记', '罗贯中', 12.00, 42, 9976, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (14, '水浒传', '华仔', 33.05, 65, 45, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (15, '操作系统原理', '刘优', 133.05, 145, 165, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (16, '数据结构 java版', '封大神', 173.15, 30, 72, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (17, 'UNIX高级环境编程', '乐天', 99.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (18, 'javaScript高级编程', '国哥', 69.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (36, '呜呜', '我', 1.00, 1, 1, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (37, 'java从入门到放弃', '国哥', 80.00, 9999, 9, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (38, '数据结构与算法', '严敏君', 78.50, 6, 13, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (39, '怎样拐跑别人的媳妇', '龙伍', 68.00, 99999, 52, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (40, '木虚肉盖饭', '小胖', 16.00, 1000, 50, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (42, '蛋炒饭', '周星星', 9.90, 12, 53, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (43, '赌神', '龙伍', 66.50, 131, 529, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (44, 'Java编程思想', '阳哥', 99.50, 56, 27, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (45, 'JavaScript从入门到精通', '婷姐', 9.90, 94, 86, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (46, 'cocos2d-x游戏编程入门', '国哥', 49.00, 58, 56, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (47, 'C语言程序设计', '谭浩强', 28.00, 53, 73, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (48, 'Lua语言程序设计', '雷丰阳', 51.50, 49, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (49, '西游记', '罗贯中', 12.00, 192, 9998, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (50, '水浒传', '华仔', 33.05, 23, 87, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (51, '操作系统原理', '刘优', 133.05, 122, 188, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (52, '数据结构 java版', '封大神', 173.15, 21, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (53, 'UNIX高级环境编程', '乐天', 99.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (54, 'javaScript高级编程', '国哥', 69.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (55, '大话设计模式', '国哥', 89.15, 20, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (56, '人月神话', '刚哥', 88.15, 20, 80, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (57, 'java从入门到放弃', '国哥', 80.00, 9999, 9, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (58, '数据结构与算法', '严敏君', 78.50, 6, 13, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (59, '怎样拐跑别人的媳妇', '龙伍', 68.00, 99999, 52, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (60, '木虚肉盖饭', '小胖', 16.00, 1000, 50, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (62, '蛋炒饭', '周星星', 9.90, 12, 53, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (63, '赌神', '龙伍', 66.50, 125, 535, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (64, 'Java编程思想', '阳哥', 99.50, 47, 36, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (65, 'JavaScript从入门到精通', '婷姐', 9.90, 85, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (66, 'cocos2d-x游戏编程入门', '国哥', 49.00, 52, 62, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (68, 'Lua语言程序设计', '雷丰', 51.50, 48, 82, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (69, '西游记', '罗贯中', 12.00, 19, 9999, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (70, '水浒传', '华仔', 33.05, 22, 88, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (71, '操作系统原理', '刘优', 133.05, 122, 188, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (72, '数据结构 java版', '封大神', 173.15, 21, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (73, 'UNIX高级环境编程', '乐天', 99.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (74, 'javaScript高级编程', '国哥', 69.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (75, '大话设计模式', '国哥', 89.15, 20, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (76, '人月神话', '刚哥', 88.15, 20, 80, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (77, 'java从入门到放弃', '国哥', 80.00, 9999, 9, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (78, '数据结构与算法', '严敏君', 78.50, 6, 13, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (79, '怎样拐跑别人的媳妇', '龙伍', 68.00, 99999, 52, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (80, '木虚肉盖饭', '小胖', 16.00, 1000, 50, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (81, 'C++编程思想', '刚哥', 45.50, 14, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (82, '蛋炒饭', '周星星', 9.90, 12, 53, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (83, '赌神', '龙伍', 66.50, 125, 535, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (84, 'Java编程思想', '阳哥', 99.50, 47, 36, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (85, 'JavaScript从入门到精通', '婷姐', 9.90, 85, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (86, 'cocos2d-x游戏编程入门', '国哥', 49.00, 52, 62, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (87, 'C语言程序设计', '谭浩强', 28.00, 52, 74, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (88, 'Lua语言程序设计', '雷丰阳', 51.50, 48, 82, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (89, '西游记', '罗贯中', 12.00, 19, 9999, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (98, '11', '11', 11.00, 11, 11, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (103, '我', '1', 1.00, 1, 1, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (104, '12', '22', 2.00, 2, 2, 'static/img/default.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` date NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('16272825597816', '2021-07-26', 4010.15, 1, 6);
INSERT INTO `t_order` VALUES ('16272871891136', '2021-07-26', 472.30, 1, 6);
INSERT INTO `t_order` VALUES ('16273006190446', '2021-07-26', 351.25, 1, 6);
INSERT INTO `t_order` VALUES ('16273539472336', '2021-07-27', 306.20, 1, 6);
INSERT INTO `t_order` VALUES ('16273557043076', '2021-07-27', 339.25, 1, 6);
INSERT INTO `t_order` VALUES ('162736753057213', '2021-07-27', 306.20, 2, 13);
INSERT INTO `t_order` VALUES ('162736758231013', '2021-07-27', 349.05, 2, 13);
INSERT INTO `t_order` VALUES ('162736759367113', '2021-07-27', 264.40, 2, 13);
INSERT INTO `t_order` VALUES ('16273717164886', '2021-07-27', 339.25, 1, 6);
INSERT INTO `t_order` VALUES ('162737304363613', '2021-07-27', 351.25, 2, 13);
INSERT INTO `t_order` VALUES ('162737916337613', '2021-07-27', 306.20, 0, 13);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `total_price` decimal(11, 2) NULL DEFAULT NULL,
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES (25, '水浒传', 29, 33.05, 958.45, '16272825597816');
INSERT INTO `t_order_item` VALUES (26, '操作系统原理', 8, 133.05, 1064.40, '16272825597816');
INSERT INTO `t_order_item` VALUES (27, '数据结构 java版', 1, 173.15, 173.15, '16272825597816');
INSERT INTO `t_order_item` VALUES (28, '西游记', 1, 12.00, 12.00, '16272825597816');
INSERT INTO `t_order_item` VALUES (29, 'Java编程思想', 9, 99.50, 895.50, '16272825597816');
INSERT INTO `t_order_item` VALUES (30, 'JavaScript从入门到精通', 9, 9.90, 89.10, '16272825597816');
INSERT INTO `t_order_item` VALUES (31, 'cocos2d-x游戏编程入门', 6, 49.00, 294.00, '16272825597816');
INSERT INTO `t_order_item` VALUES (32, '赌神', 6, 66.50, 399.00, '16272825597816');
INSERT INTO `t_order_item` VALUES (33, '西游记', 1, 12.00, 12.00, '16272825597816');
INSERT INTO `t_order_item` VALUES (34, '水浒传', 1, 33.05, 33.05, '16272825597816');
INSERT INTO `t_order_item` VALUES (35, 'Lua语言程序设计', 1, 51.50, 51.50, '16272825597816');
INSERT INTO `t_order_item` VALUES (36, 'C语言程序设计', 1, 28.00, 28.00, '16272825597816');
INSERT INTO `t_order_item` VALUES (37, '操作系统原理', 2, 133.05, 266.10, '16272871891136');
INSERT INTO `t_order_item` VALUES (38, '数据结构 java版', 1, 173.15, 173.15, '16272871891136');
INSERT INTO `t_order_item` VALUES (39, '水浒传', 1, 33.05, 33.05, '16272871891136');
INSERT INTO `t_order_item` VALUES (40, '操作系统原理', 1, 133.05, 133.05, '16273006190446');
INSERT INTO `t_order_item` VALUES (41, '数据结构 java版', 1, 173.15, 173.15, '16273006190446');
INSERT INTO `t_order_item` VALUES (42, '水浒传', 1, 33.05, 33.05, '16273006190446');
INSERT INTO `t_order_item` VALUES (43, '西游记', 1, 12.00, 12.00, '16273006190446');
INSERT INTO `t_order_item` VALUES (44, '操作系统原理', 1, 133.05, 133.05, '16273539472336');
INSERT INTO `t_order_item` VALUES (45, '数据结构 java版', 1, 173.15, 173.15, '16273539472336');
INSERT INTO `t_order_item` VALUES (46, '数据结构 java版', 1, 173.15, 173.15, '16273557043076');
INSERT INTO `t_order_item` VALUES (47, '操作系统原理', 1, 133.05, 133.05, '16273557043076');
INSERT INTO `t_order_item` VALUES (48, '水浒传', 1, 33.05, 33.05, '16273557043076');
INSERT INTO `t_order_item` VALUES (49, '操作系统原理', 1, 133.05, 133.05, '162736753057213');
INSERT INTO `t_order_item` VALUES (50, '数据结构 java版', 1, 173.15, 173.15, '162736753057213');
INSERT INTO `t_order_item` VALUES (51, '操作系统原理', 1, 133.05, 133.05, '162736758231013');
INSERT INTO `t_order_item` VALUES (52, '西游记', 18, 12.00, 216.00, '162736758231013');
INSERT INTO `t_order_item` VALUES (53, '水浒传', 8, 33.05, 264.40, '162736759367113');
INSERT INTO `t_order_item` VALUES (54, '水浒传', 1, 33.05, 33.05, '16273717164886');
INSERT INTO `t_order_item` VALUES (55, '操作系统原理', 1, 133.05, 133.05, '16273717164886');
INSERT INTO `t_order_item` VALUES (56, '数据结构 java版', 1, 173.15, 173.15, '16273717164886');
INSERT INTO `t_order_item` VALUES (57, '操作系统原理', 1, 133.05, 133.05, '162737304363613');
INSERT INTO `t_order_item` VALUES (58, '数据结构 java版', 1, 173.15, 173.15, '162737304363613');
INSERT INTO `t_order_item` VALUES (59, '水浒传', 1, 33.05, 33.05, '162737304363613');
INSERT INTO `t_order_item` VALUES (60, '西游记', 1, 12.00, 12.00, '162737304363613');
INSERT INTO `t_order_item` VALUES (61, '数据结构 java版', 1, 173.15, 173.15, '162737916337613');
INSERT INTO `t_order_item` VALUES (62, '操作系统原理', 1, 133.05, 133.05, '162737916337613');

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `level` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES (1, 'admin', 'admin1', 'admin@atguigu.com', '1');
INSERT INTO `t_users` VALUES (2, 'wwwww', '111111', '111@qq.com', '0');
INSERT INTO `t_users` VALUES (3, 'wwwwww', '111111', '1@qq.com', '0');
INSERT INTO `t_users` VALUES (4, 'wuhuai', '111111', 'aaaa@qq.com', '0');
INSERT INTO `t_users` VALUES (5, 'admin11', '123456', '111@qq.com', '0');
INSERT INTO `t_users` VALUES (6, '吴淮', '111', NULL, '1');
INSERT INTO `t_users` VALUES (7, '11111', '111111', '1@qq.com', '0');
INSERT INTO `t_users` VALUES (8, '1111111', '111111', '1@qq.com', '0');
INSERT INTO `t_users` VALUES (9, '111111', '111111', '1@qq.com', '0');
INSERT INTO `t_users` VALUES (10, '123456', '111111', '1@qq.com', '0');
INSERT INTO `t_users` VALUES (11, '111111111', '111111', '111@qq.com', '0');
INSERT INTO `t_users` VALUES (12, '222222', '222222', '2@qq.com', '0');
INSERT INTO `t_users` VALUES (13, 'wharxl', '111111', '1@qq.com', '0');
INSERT INTO `t_users` VALUES (14, '11111111', '111111', '111@qq.com', '0');
INSERT INTO `t_users` VALUES (16, '廖捞', '1234', '123@guigu.com', '0');
INSERT INTO `t_users` VALUES (18, '2131231', '1234', '123@guigu.com', '0');
INSERT INTO `t_users` VALUES (20, 'qweqw', '111111', '111@qq.com', '0');

SET FOREIGN_KEY_CHECKS = 1;
