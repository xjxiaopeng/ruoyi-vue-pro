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

 Date: 22/03/2023 00:13:05
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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '考核发布' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kpi_assess_issue
-- ----------------------------
INSERT INTO `kpi_assess_issue` VALUES (4, '2023年02月考核', '[117,118]', '人事1', '刘明兰', '2023-02-16 00:00:00', '2023-02-23 00:00:00', 0, '1', '2023-02-16 13:30:26', '1', '2023-03-17 20:31:23', b'0', 1);
INSERT INTO `kpi_assess_issue` VALUES (5, '2023年03月考核', '[117,118]', '人事1', '刘明兰', '2023-03-20 00:00:00', '2023-03-27 00:00:00', 0, '1', '2023-03-20 11:10:39', '1', '2023-03-20 11:20:43', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
