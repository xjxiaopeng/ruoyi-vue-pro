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

 Date: 21/03/2023 23:11:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_user_post
-- ----------------------------
DROP TABLE IF EXISTS `system_user_post`;
CREATE TABLE `system_user_post`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '岗位ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户岗位表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_user_post
-- ----------------------------
INSERT INTO `system_user_post` VALUES (112, 1, 1, 'admin', '2022-05-02 07:25:24', 'admin', '2022-05-02 07:25:24', b'0', 1);
INSERT INTO `system_user_post` VALUES (113, 100, 1, 'admin', '2022-05-02 07:25:24', 'admin', '2022-05-02 07:25:24', b'0', 1);
INSERT INTO `system_user_post` VALUES (114, 114, 3, 'admin', '2022-05-02 07:25:24', 'admin', '2023-02-20 12:08:59', b'1', 1);
INSERT INTO `system_user_post` VALUES (115, 104, 1, '1', '2022-05-16 19:36:28', '1', '2022-05-16 19:36:28', b'0', 1);
INSERT INTO `system_user_post` VALUES (116, 117, 2, '1', '2022-07-09 17:40:26', '1', '2023-02-20 12:02:30', b'1', 1);
INSERT INTO `system_user_post` VALUES (117, 118, 1, '1', '2022-07-09 17:44:44', '1', '2023-02-20 11:58:03', b'1', 1);
INSERT INTO `system_user_post` VALUES (118, 104, 2, '1', '2023-02-10 18:03:52', '1', '2023-02-10 18:03:52', b'0', 1);
INSERT INTO `system_user_post` VALUES (119, 104, 4, '1', '2023-02-10 18:03:52', '1', '2023-02-10 18:03:52', b'0', 1);
INSERT INTO `system_user_post` VALUES (120, 123, 1, '1', '2023-02-16 03:09:00', '1', '2023-02-16 03:09:00', b'0', 1);
INSERT INTO `system_user_post` VALUES (121, 118, 2, '1', '2023-02-20 11:58:03', '1', '2023-02-20 11:58:03', b'0', 1);
INSERT INTO `system_user_post` VALUES (122, 117, 4, '1', '2023-02-20 12:02:30', '1', '2023-02-20 12:02:30', b'0', 1);
INSERT INTO `system_user_post` VALUES (123, 114, 7, '1', '2023-02-20 12:08:59', '1', '2023-02-20 12:08:59', b'0', 1);
INSERT INTO `system_user_post` VALUES (124, 112, 8, '1', '2023-02-20 12:09:47', '1', '2023-02-20 12:09:47', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
