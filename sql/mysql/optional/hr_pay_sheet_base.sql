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

 Date: 02/04/2023 23:38:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hr_pay_sheet_base
-- ----------------------------
DROP TABLE IF EXISTS `hr_pay_sheet_base`;
CREATE TABLE `hr_pay_sheet_base`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '部门名称',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '用户昵称',
  `base_pay` decimal(10, 2) NULL DEFAULT NULL COMMENT '基本工资',
  `merit_pay` decimal(10, 2) NULL DEFAULT NULL COMMENT '绩效工资',
  `overtime_pay` decimal(10, 2) NULL DEFAULT NULL COMMENT '加班工资',
  `hightemperature_subsidy` decimal(10, 2) NULL DEFAULT NULL COMMENT '高温补贴',
  `allowance` decimal(10, 2) NULL DEFAULT NULL COMMENT '补助',
  `Lunch_subsides` decimal(10, 2) NULL DEFAULT NULL COMMENT '餐补',
  `personal_leave` decimal(10, 2) NULL DEFAULT NULL COMMENT '事假',
  `sick_leave` decimal(10, 2) NULL DEFAULT NULL COMMENT '病假',
  `rests` decimal(10, 2) NULL DEFAULT NULL COMMENT '其他',
  `housing_fund` decimal(10, 2) NULL DEFAULT NULL COMMENT '住房公积金',
  `oldage_insurance` decimal(10, 2) NULL DEFAULT NULL COMMENT '养老保险',
  `medical_insurance` decimal(10, 2) NULL DEFAULT NULL COMMENT '医疗保险',
  `unemployment_insurance` decimal(10, 2) NULL DEFAULT NULL COMMENT '失业保险',
  `njury_insurance` decimal(10, 2) NULL DEFAULT NULL COMMENT '工伤保险',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '工资基础表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hr_pay_sheet_base
-- ----------------------------
INSERT INTO `hr_pay_sheet_base` VALUES (1, 112, 121, '', '郑伊柯', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-01 00:04:28', '1', '2023-04-01 00:04:28', b'0', 1);
INSERT INTO `hr_pay_sheet_base` VALUES (2, 114, 123, '', '王建飞', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-01 00:04:28', '1', '2023-04-01 00:04:28', b'0', 1);
INSERT INTO `hr_pay_sheet_base` VALUES (3, 115, 119, '', '成丹娜', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-01 00:04:28', '1', '2023-04-01 00:04:28', b'0', 1);
INSERT INTO `hr_pay_sheet_base` VALUES (4, 117, 112, '', '钟晓华', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-01 00:04:28', '1', '2023-04-01 00:04:28', b'0', 1);
INSERT INTO `hr_pay_sheet_base` VALUES (5, 118, 112, '', '张飞霞', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-01 00:04:28', '1', '2023-04-01 00:04:28', b'0', 1);
INSERT INTO `hr_pay_sheet_base` VALUES (6, 119, 120, '', '肖诗婷', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-01 00:04:28', '1', '2023-04-01 00:04:28', b'0', 1);
INSERT INTO `hr_pay_sheet_base` VALUES (7, 123, 120, '', '刘明兰', 15000.00, 0.00, 0.00, 0.00, 5000.00, 206.25, 0.00, 0.00, 0.00, 720.00, 360.00, 112.50, 22.50, 0.00, '1', '2023-04-01 00:04:28', '1', '2023-04-02 11:35:55', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
