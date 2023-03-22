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

 Date: 22/03/2023 00:14:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for kpi_assess_todolist
-- ----------------------------
DROP TABLE IF EXISTS `kpi_assess_todolist`;
CREATE TABLE `kpi_assess_todolist`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `issue_id` bigint(20) NOT NULL COMMENT '考核发布ID',
  `assess_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '考核名称',
  `staff` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '自评人',
  `staff_time` datetime NULL DEFAULT NULL COMMENT '自评日期',
  `staff_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '自评状态（1待办 0已办 2 无）',
  `reviewer` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '考评人',
  `reviewer_time` datetime NULL DEFAULT NULL COMMENT '考评日期',
  `reviewer_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '考评状态（1待办 0已办 2 无）',
  `decider` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '终评人',
  `decider_time` datetime NULL DEFAULT NULL COMMENT '终评日期',
  `decider_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '终评状态（1待办 0已办 2 无）',
  `assess_start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '考核开始时间',
  `assess_end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '考核结束时间',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '待办状态（1自评 2考评 3终评 4考核结束）',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '考核待办表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kpi_assess_todolist
-- ----------------------------
INSERT INTO `kpi_assess_todolist` VALUES (1, 4, '2023年02月考核', '出纳1', '2023-03-13 08:42:25', 0, '人事1', '2023-03-13 08:42:28', 0, '刘明兰', '2023-03-13 08:42:31', 0, '2023-02-16 00:00:00', '2023-02-23 00:00:00', 4, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:31', b'0', 1);
INSERT INTO `kpi_assess_todolist` VALUES (2, 4, '2023年02月考核', '财务1', '2023-03-13 08:42:15', 0, '人事1', '2023-03-13 08:42:18', 0, '刘明兰', '2023-03-13 08:42:21', 0, '2023-02-16 00:00:00', '2023-02-23 00:00:00', 4, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:22', b'0', 1);
INSERT INTO `kpi_assess_todolist` VALUES (3, 5, '2023年03月考核', '出纳', '2023-03-20 21:20:05', 0, '人事1', NULL, 2, '刘明兰', '2023-03-21 00:09:10', 0, '2023-03-20 00:00:00', '2023-03-27 00:00:00', 4, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:09:11', b'0', 1);
INSERT INTO `kpi_assess_todolist` VALUES (4, 5, '2023年03月考核', '会计', '2023-03-20 21:31:58', 0, '人事1', '2023-03-20 22:35:06', 0, '刘明兰', '2023-03-21 00:06:44', 0, '2023-03-20 00:00:00', '2023-03-27 00:00:00', 4, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:06:45', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
