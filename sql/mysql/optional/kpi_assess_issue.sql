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

 Date: 28/03/2023 15:07:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for kpi_assess_issue
-- ----------------------------
DROP TABLE IF EXISTS `kpi_assess_issue`;
CREATE TABLE `kpi_assess_issue`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `assess_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '考核名称',
  `user_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户编号数组',
  `reviewer` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '考评人',
  `decider` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '终评人',
  `assess_start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '考核开始时间',
  `assess_end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '考核结束时间',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '发布状态（1未发布 0发布）',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_unique`(`update_time`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '考核发布' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kpi_assess_issue
-- ----------------------------
INSERT INTO `kpi_assess_issue` VALUES (4, '2023年02月考核', '[117,118]', '人事1', '刘明兰', '2023-02-16 00:00:00', '2023-02-23 00:00:00', 1, '1', '2023-02-16 13:30:26', '123', '2023-03-27 12:20:18', b'0', 1);
INSERT INTO `kpi_assess_issue` VALUES (5, '2023年03月考核', '[117,118]', '人事1', '刘明兰', '2023-03-20 00:00:00', '2023-03-27 00:00:00', 1, '1', '2023-03-20 11:10:39', '123', '2023-03-27 12:20:16', b'0', 1);
INSERT INTO `kpi_assess_issue` VALUES (6, '2023年03-1月考核', '[115,117,118,119]', '成丹娜', '刘明兰', '2023-03-28 00:00:00', '2023-04-04 00:00:00', 1, '123', '2023-03-28 11:11:48', '1', '2023-03-28 14:19:19', b'0', 1);
INSERT INTO `kpi_assess_issue` VALUES (7, '2023年03-2月考核', '[115]', '成丹娜', '刘明兰', '2023-03-28 00:00:00', '2023-04-04 00:00:00', 0, '1', '2023-03-28 14:19:41', '1', '2023-03-28 14:19:48', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
