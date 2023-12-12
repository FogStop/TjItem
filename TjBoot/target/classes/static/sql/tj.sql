/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39-log)
 Source Host           : localhost:3306
 Source Schema         : tj

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39-log)
 File Encoding         : 65001

 Date: 04/12/2023 13:00:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `press` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `times` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '1月', '10001', 'fff', 3, 'qihua ', '教材', '2023-11-29 20:51:30');
INSERT INTO `book` VALUES (2, '2月', '10002', 'ccc', 5, 'beida ', '教材', '2023-11-28 20:52:09');
INSERT INTO `book` VALUES (3, '3月', '10003', '嘎尔哥', 9, '得分', '名著', '2023-11-10 20:52:57');
INSERT INTO `book` VALUES (4, '4月', '10004', '发嘎嘎人', 15, 'v染色体', '教材', '2023-11-04 20:53:30');
INSERT INTO `book` VALUES (5, '5月', '10005', '问他忽然', 4, ' 问题', '娱乐', '2023-11-30 20:54:01');
INSERT INTO `book` VALUES (6, '6月', '1006', '父亲二工区', 4, '肥肉', '夫人夫人', '2023-11-02 20:16:19');

-- ----------------------------
-- Table structure for x_employee
-- ----------------------------
DROP TABLE IF EXISTS `x_employee`;
CREATE TABLE `x_employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deleted` int(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of x_employee
-- ----------------------------
INSERT INTO `x_employee` VALUES (1, 'fog', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '1', '18677778888', 1, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_employee` VALUES (2, 'zhang', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '2', '13966667777', 1, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_employee` VALUES (3, 'lisi2', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '2', '13966667778', 0, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_employee` VALUES (4, 'wang', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '2', '13966667772', 1, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_employee` VALUES (5, 'zhao', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '3', '13966667776', 0, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_employee` VALUES (6, 'song', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '3', '13966667771', 1, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_employee` VALUES (7, '12', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '3', '123569', 0, NULL, 0);
INSERT INTO `x_employee` VALUES (8, '333', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '3', '11112121211', 1, NULL, 0);
INSERT INTO `x_employee` VALUES (9, '521', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '3', '12548', 0, NULL, 1);
INSERT INTO `x_employee` VALUES (10, 'a', '$2a$10$DwTI6ttza6DNh.gJz3H2H.YyufyvwUwc5LqKvbItVs9opnOu.G9bu', '3', '65965555', 1, NULL, 1);

-- ----------------------------
-- Table structure for x_menu
-- ----------------------------
DROP TABLE IF EXISTS `x_menu`;
CREATE TABLE `x_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `redirect` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `is_leaf` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hidden` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of x_menu
-- ----------------------------
INSERT INTO `x_menu` VALUES (1, 'Layout', '/user', '/user/list', 'userManage', '用户管理', 'userManage', 0, 'N', 0);
INSERT INTO `x_menu` VALUES (2, 'user/user', 'list', NULL, 'userList', '用户列表', 'userList', 1, 'Y', 0);
INSERT INTO `x_menu` VALUES (3, 'user/role', 'role', NULL, 'roleList', '角色列表', 'role', 1, 'Y', 0);
INSERT INTO `x_menu` VALUES (4, 'user/permission', 'permission', NULL, 'permissionList', '权限列表', 'permission', 1, 'Y', 0);

-- ----------------------------
-- Table structure for x_month
-- ----------------------------
DROP TABLE IF EXISTS `x_month`;
CREATE TABLE `x_month`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `personnel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '人员更替数量表',
  `appraise` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价整理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of x_month
-- ----------------------------
INSERT INTO `x_month` VALUES (1, '1月', 260, '163', '一般');
INSERT INTO `x_month` VALUES (2, '2月', 400, '180', '一般');
INSERT INTO `x_month` VALUES (3, '3月', 333, '190', '一般');
INSERT INTO `x_month` VALUES (4, '4月', 600, '260', '良好');
INSERT INTO `x_month` VALUES (5, '5月', 380, '240', '优秀');
INSERT INTO `x_month` VALUES (6, '6月', 250, '200', '一般');
INSERT INTO `x_month` VALUES (7, '7月', 500, '260', '优秀');
INSERT INTO `x_month` VALUES (8, '8月', 550, '280', '良好');
INSERT INTO `x_month` VALUES (9, '9月', 535, '270', '良好');
INSERT INTO `x_month` VALUES (10, '10月', 500, '265', '一般');
INSERT INTO `x_month` VALUES (11, '11月', 120, '40', '差');

-- ----------------------------
-- Table structure for x_role
-- ----------------------------
DROP TABLE IF EXISTS `x_role`;
CREATE TABLE `x_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of x_role
-- ----------------------------
INSERT INTO `x_role` VALUES (1, 'admin', '超级管理员');
INSERT INTO `x_role` VALUES (2, 'hr', '人事专员');
INSERT INTO `x_role` VALUES (3, 'normal', '普通员工');

-- ----------------------------
-- Table structure for x_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `x_role_menu`;
CREATE TABLE `x_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of x_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for x_user
-- ----------------------------
DROP TABLE IF EXISTS `x_user`;
CREATE TABLE `x_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deleted` int(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of x_user
-- ----------------------------
INSERT INTO `x_user` VALUES (1, 'fog', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', 'super@aliyun.com', '18677778888', 1, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_user` VALUES (2, 'zhangsan', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', 'zhangsan@gmail.com', '13966667777', 1, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_user` VALUES (3, 'lisi222', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', 'lisi@gmail.com', '13966667778', 0, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_user` VALUES (4, 'wangwu', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', 'wangwu@gmail.com', '13966667772', 1, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_user` VALUES (5, 'zhaoer', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', 'zhaoer@gmail.com', '13966667776', 0, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_user` VALUES (6, 'songliu', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', 'songliu@gmail.com', '13966667771', 1, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 0);
INSERT INTO `x_user` VALUES (7, '1234', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '12314', '123569', 0, NULL, 0);
INSERT INTO `x_user` VALUES (8, '1111', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '15454', '11112121211', 1, NULL, 1);
INSERT INTO `x_user` VALUES (9, '52154', '$2a$10$/4hF5BQqQ7eny0.DcFFPku2GdhU8aUJEaC0feMZu92/klUY/3vPna', '235514521', '12548', 0, NULL, 1);
INSERT INTO `x_user` VALUES (10, 'as', '$2a$10$DwTI6ttza6DNh.gJz3H2H.YyufyvwUwc5LqKvbItVs9opnOu.G9bu', 'aaaaaa', '65965555', 1, NULL, 1);
INSERT INTO `x_user` VALUES (11, 'xiaorui', '$2a$10$53onJ1O02K1xbC8q/3opL.N3JV7rwJ1GrYPxOCGk730mAI9auga.2', '121', '123456', 1, NULL, 0);
INSERT INTO `x_user` VALUES (12, '12154', '$2a$10$PjIIUvISrzXkZ5HUSd5GIObVTXm7lc2SsLd4OizWfAxne4.Cr0JBG', '12145', '18563586545', 1, NULL, 1);

-- ----------------------------
-- Table structure for x_user_role
-- ----------------------------
DROP TABLE IF EXISTS `x_user_role`;
CREATE TABLE `x_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of x_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for x_za
-- ----------------------------
DROP TABLE IF EXISTS `x_za`;
CREATE TABLE `x_za`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `board` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `times` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of x_za
-- ----------------------------
INSERT INTO `x_za` VALUES (1, 'fog', '广东', '2023最新公告', '2023-11-14 20:29:14');
INSERT INTO `x_za` VALUES (2, 'fog', '浙江', '2月新发公告', '2023-03-01 20:29:49');
INSERT INTO `x_za` VALUES (3, 'fog', '江西', '4月最新公告', '2023-05-26 20:30:24');
INSERT INTO `x_za` VALUES (4, 'fog', '山东', '8月最新公告', '2023-10-19 20:31:04');

SET FOREIGN_KEY_CHECKS = 1;
