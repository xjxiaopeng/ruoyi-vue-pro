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

 Date: 22/03/2023 11:04:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for jimu_report_db_param
-- ----------------------------
DROP TABLE IF EXISTS `jimu_report_db_param`;
CREATE TABLE `jimu_report_db_param`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jimu_report_head_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '动态报表ID',
  `param_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数字段',
  `param_txt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数文本',
  `param_value` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数默认值',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人登录名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新日期',
  `search_flag` int(1) NULL DEFAULT NULL COMMENT '查询标识0否1是 默认0',
  `widget_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查询控件类型',
  `search_mode` int(1) NULL DEFAULT NULL COMMENT '查询模式1简单2范围',
  `dict_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典',
  `search_format` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查询时间格式化表达式',
  `ext_json` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '参数配置',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_jmrheadid`(`jimu_report_head_id`) USING BTREE,
  INDEX `idx_jrdp_jimu_report_head_id`(`jimu_report_head_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jimu_report_db_param
-- ----------------------------
INSERT INTO `jimu_report_db_param` VALUES ('078d99565feef91904c84b42b43f5174', '1273495682564534273', 'id', 'id', '1', 1, NULL, '2020-08-03 09:55:26', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('0d91170e4546cdbebbc3e9cc7879ce79', '22f025b781ee9fe4746438621e82674f', 'id', 'id', '1', 1, NULL, '2020-07-21 15:31:51', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('1324279360203526146', '1324279359998005250', 'pageSize', 'pageSize', '10', 2, NULL, '2020-08-03 15:19:54', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('1324279360220303361', '1324279359998005250', 'pageNo', 'pageNo', '1', 1, NULL, '2020-08-03 15:19:54', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('143f8c164072ddbdeafec5c5b1466827', '1272858455908073473', 'id', 'id', '1', 1, NULL, '2020-07-21 15:31:51', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('173c869cc45b683a9cfe25826110cead', '1272834687525482497', 'id', 'id', '1', 1, NULL, '2020-08-03 09:57:08', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('1805eb351a966dc3c039b5239b6faa49', '1291310198925840385', 'sex', 'sex', '男', 2, NULL, '2020-06-08 15:21:09', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('256eb2f8582ce4d74559b1fc1e2917ca', '1291310198925840385', 'id', 'id', '111', 1, NULL, '2020-06-08 15:21:09', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('3957799c20fcc696d680cca9649897bb', 'e4cec9ff15bc0ea42f536a442a6d1335', 'id', 'id', '1', 1, NULL, '2020-08-03 09:57:08', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('3a9efc51a6b6723d5a0ddf109aacb2b5', '1288038655293661186', 'pageNo', 'pageNo', '1', 1, 'admin', '2021-04-01 03:09:40', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('3ced36c7a2cce40c667cc485bf59cd11', '1291217511962902530', 'pageSize', 'pageSize', '10', 2, NULL, '2020-08-03 15:19:54', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('49bd3f212cd6c406c8584e6bb0d9cf93', '1291549569390243841', 'pageSize', 'pageSize', '10', 2, NULL, '2020-07-30 17:26:29', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('52db6da75ea733ae741c62cc54c85d92', '6011955e58d89040fca52e7f962d0bf4', 'id', 'id', '1', 1, NULL, '2020-08-03 09:55:46', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('57165a6fe5f2b700d4ef19518de4defd', '1290104038414721025', 'id', 'id', '1', 1, NULL, '2020-08-03 09:55:46', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('7569e95c1fa73d5438aceb19c1b85ef0', '1288038655293661186', 'pageSize', 'pageSize', '20', 2, 'admin', '2021-04-01 03:09:40', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('7d7765754aadaddab91bf1257447ae73', '1291549569390243841', 'pageNo', 'pageNo', '1', 1, NULL, '2020-07-30 17:26:29', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('8bff26e0c3fe48ddd41cf8d939ad4f2c', '2324fac242b35938678a05bbbba345e2', 'pageSize', 'pageSize', '10', 2, NULL, '2020-08-03 15:19:54', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('90b22a058cc331146b548bc93f09b5cd', '1289140698221678593', 'pageSize', 'pageSize', '20', 2, 'admin', '2021-04-01 03:09:23', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('944eaee4cb7639a435aadbf2ad7469a0', '2324fac242b35938678a05bbbba345e2', 'pageNo', 'pageNo', '1', 1, NULL, '2020-08-03 15:19:54', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('a29c10ed01c6608e899e1368f2d5d7e3', '1316997232402231298', 'id', 'id', '1', 1, NULL, '2021-01-13 14:31:13', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('a803707f3383dd9f4685fadc7efa07f4', '1224643501392728065', 'sex', 'sex', '男', 2, NULL, '2020-06-08 15:21:09', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('b7c34e8a3c2804715825af4bdbcf857a', '1224643501392728065', 'id', 'id', '111', 1, NULL, '2020-06-08 15:21:09', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('d8010a4ffbe567e6117e7f59641aeb7c', '1289140698221678593', 'pageNo', 'pageNo', '1', 1, 'admin', '2021-04-01 03:09:23', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('d9d94d6b09dd074f39af96d7a4696f9a', '1291217511962902530', 'pageNo', 'pageNo', '1', 1, NULL, '2020-08-03 15:19:54', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `jimu_report_db_param` VALUES ('ec09a8b27e7e9ec9dbc683fc5a38faec', 'c9bdb6b7ac68accfecb366718bf78f79', 'id', 'id', '1', 1, NULL, '2020-08-03 09:55:26', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
