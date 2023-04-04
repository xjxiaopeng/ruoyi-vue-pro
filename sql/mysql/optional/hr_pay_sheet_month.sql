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

 Date: 02/04/2023 23:38:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hr_pay_sheet_month
-- ----------------------------
DROP TABLE IF EXISTS `hr_pay_sheet_month`;
CREATE TABLE `hr_pay_sheet_month`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `wage_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '工资表名称',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '部门',
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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '月工资表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hr_pay_sheet_month
-- ----------------------------
INSERT INTO `hr_pay_sheet_month` VALUES (1, '2023年4月', '郑伊柯', '文宣部', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-02 11:36:31', '1', '2023-04-02 11:36:31', b'0', 1);
INSERT INTO `hr_pay_sheet_month` VALUES (2, '2023年4月', '王建飞', '风控部', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-02 11:36:31', '1', '2023-04-02 11:36:31', b'0', 1);
INSERT INTO `hr_pay_sheet_month` VALUES (3, '2023年4月', '成丹娜', '人事部', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-02 11:36:31', '1', '2023-04-02 11:36:31', b'0', 1);
INSERT INTO `hr_pay_sheet_month` VALUES (4, '2023年4月', '钟晓华', '财务部', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-02 11:36:31', '1', '2023-04-02 11:36:31', b'0', 1);
INSERT INTO `hr_pay_sheet_month` VALUES (5, '2023年4月', '张飞霞', '财务部', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-02 11:36:31', '1', '2023-04-02 11:36:31', b'0', 1);
INSERT INTO `hr_pay_sheet_month` VALUES (6, '2023年4月', '肖诗婷', '行政部', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, '1', '2023-04-02 11:36:31', '1', '2023-04-02 11:36:31', b'0', 1);
INSERT INTO `hr_pay_sheet_month` VALUES (7, '2023年4月', '刘明兰', '行政部', 15000.00, 0.00, 0.00, 0.00, 5000.00, 206.25, 0.00, 0.00, 0.00, 720.00, 360.00, 112.50, 22.50, 0.00, '1', '2023-04-02 11:36:31', '1', '2023-04-02 11:36:31', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
