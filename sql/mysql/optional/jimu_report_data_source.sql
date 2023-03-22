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

 Date: 22/03/2023 10:59:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for jimu_report_data_source
-- ----------------------------
DROP TABLE IF EXISTS `jimu_report_data_source`;
CREATE TABLE `jimu_report_data_source`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源名称',
  `report_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报表_id',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `db_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据库类型',
  `db_driver` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '驱动类',
  `db_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源地址',
  `db_username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `db_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新日期',
  `connect_times` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '连接失败次数',
  `tenant_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '多租户标识',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型(report:报表;drag:仪表盘)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_jmdatasource_report_id`(`report_id`) USING BTREE,
  INDEX `idx_jmdatasource_code`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jimu_report_data_source
-- ----------------------------
INSERT INTO `jimu_report_data_source` VALUES ('1324261983692902402', 'jeewx', '1324261770294071296', '', NULL, 'MYSQL', 'com.mysql.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/jeewx-boot?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8', 'root', 'root', 'jeecg', '2020-11-05 16:07:15', NULL, '2020-11-05 16:07:15', 0, NULL, 'report');
INSERT INTO `jimu_report_data_source` VALUES ('26d21fe4f27920d2f56abc8d90a8e527', 'oracle', '1308645288868712448', '', NULL, 'ORACLE', 'oracle.jdbc.OracleDriver', 'jdbc:oracle:thin:@192.168.1.199:1521:helowin', 'jeecgbootbpm', 'jeecg196283', 'admin', '2021-01-05 19:26:24', NULL, '2021-01-05 19:26:24', 1, NULL, 'report');
INSERT INTO `jimu_report_data_source` VALUES ('796749220114022400', '本地数据源', '796748840047165440', '', NULL, 'MYSQL5.7', 'com.mysql.cj.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/ruoyi-vue-pro3?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&tinyInt1isBit=false', 'root', '@JimuReportMfBQgOSZwslqB6iIZI+5ug==', '1', '2023-03-18 00:43:47', NULL, NULL, 0, NULL, 'report');
INSERT INTO `jimu_report_data_source` VALUES ('8f90daf47d15d35ca6cf420748b8b9ba', 'localhost', '1316944968992034816', '', NULL, 'MYSQL5.7', 'com.mysql.cj.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/jeecg-boot?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8', 'root', 'root', 'admin', '2021-01-13 14:34:00', NULL, '2021-01-13 14:34:00', 0, NULL, 'report');

SET FOREIGN_KEY_CHECKS = 1;
