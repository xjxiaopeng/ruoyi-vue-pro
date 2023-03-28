/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50726 (5.7.26)
 Source Host           : localhost:3306
 Source Schema         : ruoyi-vue-pro3

 Target Server Type    : MySQL
 Target Server Version : 50726 (5.7.26)
 File Encoding         : 65001

 Date: 28/03/2023 11:58:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES (1, 1, 1, '', '2022-01-11 13:19:45', '', '2022-05-12 12:35:17', b'0', 1);
INSERT INTO `system_user_role` VALUES (2, 2, 2, '', '2022-01-11 13:19:45', '', '2022-05-12 12:35:13', b'0', 1);
INSERT INTO `system_user_role` VALUES (4, 100, 101, '', '2022-01-11 13:19:45', '', '2023-03-27 21:06:17', b'1', 1);
INSERT INTO `system_user_role` VALUES (5, 100, 1, '', '2022-01-11 13:19:45', '', '2023-03-27 21:06:17', b'1', 1);
INSERT INTO `system_user_role` VALUES (6, 100, 2, '', '2022-01-11 13:19:45', '', '2023-03-27 21:06:17', b'1', 1);
INSERT INTO `system_user_role` VALUES (10, 103, 1, '1', '2022-01-11 13:19:45', '1', '2023-03-27 21:06:08', b'1', 1);
INSERT INTO `system_user_role` VALUES (11, 107, 106, '1', '2022-02-20 22:59:33', '1', '2022-02-20 22:59:33', b'0', 118);
INSERT INTO `system_user_role` VALUES (12, 108, 107, '1', '2022-02-20 23:00:50', '1', '2022-02-20 23:00:50', b'0', 119);
INSERT INTO `system_user_role` VALUES (13, 109, 108, '1', '2022-02-20 23:11:50', '1', '2022-02-20 23:11:50', b'0', 120);
INSERT INTO `system_user_role` VALUES (14, 110, 109, '1', '2022-02-22 00:56:14', '1', '2022-02-22 00:56:14', b'0', 121);
INSERT INTO `system_user_role` VALUES (15, 111, 110, '110', '2022-02-23 13:14:38', '110', '2022-02-23 13:14:38', b'0', 121);
INSERT INTO `system_user_role` VALUES (16, 113, 111, '1', '2022-03-07 21:37:58', '1', '2022-03-07 21:37:58', b'0', 122);
INSERT INTO `system_user_role` VALUES (17, 114, 101, '1', '2022-03-19 21:51:13', '1', '2023-03-28 11:15:03', b'1', 1);
INSERT INTO `system_user_role` VALUES (18, 1, 2, '1', '2022-05-12 20:39:29', '1', '2022-05-12 20:39:29', b'0', 1);
INSERT INTO `system_user_role` VALUES (19, 116, 113, '1', '2022-05-17 10:07:10', '1', '2022-05-17 10:07:10', b'0', 124);
INSERT INTO `system_user_role` VALUES (20, 104, 101, '1', '2022-05-28 15:43:57', '1', '2023-03-27 21:05:59', b'1', 1);
INSERT INTO `system_user_role` VALUES (22, 115, 2, '1', '2022-07-21 22:08:30', '1', '2023-03-20 12:05:48', b'1', 1);
INSERT INTO `system_user_role` VALUES (24, 120, 115, '1', '2022-12-30 11:33:42', '1', '2022-12-30 11:33:42', b'0', 126);
INSERT INTO `system_user_role` VALUES (25, 121, 116, '1', '2022-12-30 11:33:49', '1', '2022-12-30 11:33:49', b'0', 127);
INSERT INTO `system_user_role` VALUES (26, 122, 118, '1', '2022-12-30 11:47:53', '1', '2022-12-30 11:47:53', b'0', 129);
INSERT INTO `system_user_role` VALUES (27, 112, 101, '1', '2023-02-09 23:18:51', '1', '2023-03-28 11:15:13', b'1', 1);
INSERT INTO `system_user_role` VALUES (28, 117, 119, '1', '2023-03-20 12:05:25', '1', '2023-03-20 12:05:25', b'0', 1);
INSERT INTO `system_user_role` VALUES (30, 115, 120, '1', '2023-03-20 12:05:49', '1', '2023-03-20 12:05:49', b'0', 1);
INSERT INTO `system_user_role` VALUES (31, 123, 121, '1', '2023-03-20 23:30:55', '1', '2023-03-20 23:30:55', b'0', 1);
INSERT INTO `system_user_role` VALUES (32, 119, 119, '1', '2023-03-28 11:14:29', '1', '2023-03-28 11:14:29', b'0', 1);
INSERT INTO `system_user_role` VALUES (33, 114, 119, '1', '2023-03-28 11:15:04', '1', '2023-03-28 11:15:04', b'0', 1);
INSERT INTO `system_user_role` VALUES (34, 112, 119, '1', '2023-03-28 11:15:14', '1', '2023-03-28 11:15:14', b'0', 1);
INSERT INTO `system_user_role` VALUES (35, 118, 119, '1', '2023-03-28 11:38:20', '1', '2023-03-28 11:38:20', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
