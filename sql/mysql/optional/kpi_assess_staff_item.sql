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

 Date: 22/03/2023 00:13:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for kpi_assess_staff_item
-- ----------------------------
DROP TABLE IF EXISTS `kpi_assess_staff_item`;
CREATE TABLE `kpi_assess_staff_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `issue_id` bigint(20) NOT NULL COMMENT '考核发布ID',
  `todolist_id` bigint(20) NOT NULL COMMENT '考核待办ID',
  `assess_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '考核名称',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '考核指标',
  `standard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '考核标准',
  `score` tinyint(4) NOT NULL DEFAULT 0 COMMENT '考核分值',
  `staff` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '自评人',
  `staff_time` datetime NULL DEFAULT NULL COMMENT '自评日期',
  `staff_complete_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '自评完成状态（1未完成 2部分完成 3完成 ）',
  `staff_score` tinyint(4) NOT NULL DEFAULT 0 COMMENT '自评分值',
  `staff_remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '自评备注',
  `reviewer` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '考评人',
  `reviewer_time` datetime NULL DEFAULT NULL COMMENT '考评日期',
  `reviewer_complete_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '考评完成状态（1未完成 2部分完成 3完成 ）',
  `reviewer_score` tinyint(4) NOT NULL DEFAULT 0 COMMENT '考评分值',
  `reviewer_remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '考评备注',
  `decider` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '终评人',
  `decider_time` datetime NULL DEFAULT NULL COMMENT '终评日期',
  `decider_complete_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '终评完成状态（1未完成 2部分完成 3完成 ）',
  `decider_score` tinyint(4) NOT NULL DEFAULT 0 COMMENT '考评分值',
  `decider_remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '终评备注',
  `post` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '岗位',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '考核状态（1自评 2考评 3终评 4考核结束）',
  `fixed` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否必选（0必选 1可选）',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '考核评分表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kpi_assess_staff_item
-- ----------------------------
INSERT INTO `kpi_assess_staff_item` VALUES (1, 4, 1, '2023年02月考核', '建立健全出纳各种账目，保证账款相符，掌握银行资金进出数目清楚明了，银行现金帐做到准确无误。\n', '出现差错扣5分/次；', 10, '出纳1', '2023-03-13 08:42:25', 0, 10, NULL, '人事1', '2023-03-13 08:42:28', 0, 9, NULL, '刘明兰', '2023-03-13 08:42:31', 0, 10, NULL, '出纳', 4, 1, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:31', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (2, 4, 1, '2023年02月考核', '做好LAW WIT收费信息审核、出票审核、收费状态审核（含客户名称、客户收费、信息对比、出票规范、出票数量、已收、开票、归档状态等）\n', '出现差错扣5分/次；', 5, '出纳1', '2023-03-13 08:42:25', 0, 5, NULL, '人事1', '2023-03-13 08:42:28', 0, 5, NULL, '刘明兰', '2023-03-13 08:42:31', 0, 5, NULL, '出纳', 4, 1, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:31', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (3, 4, 1, '2023年02月考核', '律所创收目标达成率', '\"目标达成率=实际创收额/计划创收额*100%，\n目标达成率达到50%，该项得满分\n40%≤目标达成率﹤50%，得15分\n30%≤目标达成率﹤40%，得10分\n目标达成率﹤30%，该项不得分\n目标达成率高于80%按照比例计算得分\"', 20, '出纳1', '2023-03-13 08:42:25', 0, 18, NULL, '人事1', '2023-03-13 08:42:28', 0, 20, NULL, '刘明兰', '2023-03-13 08:42:31', 0, 18, NULL, '出纳', 4, 0, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:31', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (4, 4, 1, '2023年02月考核', '纪律与着装', '工作时间，非工作事宜不得随意串岗闲聊，工作日期间必须着正装，佩戴工牌，否则扣2分/次，扣完为止。', 5, '出纳1', '2023-03-13 08:42:25', 0, 3, NULL, '人事1', '2023-03-13 08:42:28', 0, 5, NULL, '刘明兰', '2023-03-13 08:42:31', 0, 5, NULL, '出纳', 4, 0, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:31', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (5, 4, 1, '2023年02月考核', '工作态度', '工作日期间必须语言文雅，言辞得当，在办公场所保持和谐,责任心强，工作态度积极，工作零失误得5分，失误一次扣2分，扣完为止；\n', 5, '出纳1', '2023-03-13 08:42:25', 0, 5, NULL, '人事1', '2023-03-13 08:42:28', 0, 4, NULL, '刘明兰', '2023-03-13 08:42:31', 0, 3, NULL, '出纳', 4, 0, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:31', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (6, 4, 1, '2023年02月考核', '考勤', '当月考勤无缺勤、请假及迟到早退现象得5分，否则以上情况出现一次扣2分，扣完为止；\n', 5, '出纳1', '2023-03-13 08:42:25', 0, 3, '出纳自评3', '人事1', '2023-03-13 08:42:28', 0, 4, '123', '刘明兰', '2023-03-13 08:42:30', 0, 5, NULL, '出纳', 4, 0, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:31', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (7, 4, 2, '2023年02月考核', '了解当地税收政策，认真研究税法，负责参与拟定财务计划，审核、分析、监督预算和财务计划的执行情况', '出现差错扣5分/次', 10, '财务1', '2023-03-13 08:42:15', 0, 8, NULL, '人事1', '2023-03-13 08:42:18', 0, 10, NULL, '刘明兰', '2023-03-13 08:42:21', 0, 10, NULL, '会计', 4, 1, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:22', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (8, 4, 2, '2023年02月考核', '内外账目登记准确无误，账表相符；账本、凭证、纳税申报表单妥善保管，无外泄；保证财务流程正常运行，无造成经济损失；各项财务报表真实可靠、全面完整。', '出现差错，或未及时完成扣5分/次；', 10, '财务1', '2023-03-13 08:42:15', 0, 9, NULL, '人事1', '2023-03-13 08:42:18', 0, 9, NULL, '刘明兰', '2023-03-13 08:42:21', 0, 10, NULL, '会计', 4, 1, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:22', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (9, 4, 2, '2023年02月考核', '律所创收目标达成率', '\"目标达成率=实际创收额/计划创收额*100%，\n目标达成率达到50%，该项得满分\n40%≤目标达成率﹤50%，得15分\n30%≤目标达成率﹤40%，得10分\n目标达成率﹤30%，该项不得分\n目标达成率高于80%按照比例计算得分\"', 20, '财务1', '2023-03-13 08:42:15', 0, 19, NULL, '人事1', '2023-03-13 08:42:18', 0, 19, NULL, '刘明兰', '2023-03-13 08:42:21', 0, 20, NULL, '会计', 4, 0, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:22', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (10, 4, 2, '2023年02月考核', '纪律与着装', '工作时间，非工作事宜不得随意串岗闲聊，工作日期间必须着正装，佩戴工牌，否则扣2分/次，扣完为止。', 5, '财务1', '2023-03-13 08:42:15', 0, 3, NULL, '人事1', '2023-03-13 08:42:18', 0, 3, NULL, '刘明兰', '2023-03-13 08:42:21', 0, 5, NULL, '会计', 4, 0, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:22', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (11, 4, 2, '2023年02月考核', '工作态度', '工作日期间必须语言文雅，言辞得当，在办公场所保持和谐,责任心强，工作态度积极，工作零失误得5分，失误一次扣2分，扣完为止；\n', 5, '财务1', '2023-03-13 08:42:15', 0, 4, NULL, '人事1', '2023-03-13 08:42:18', 0, 4, NULL, '刘明兰', '2023-03-13 08:42:21', 0, 5, NULL, '会计', 4, 0, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:22', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (12, 4, 2, '2023年02月考核', '考勤', '当月考勤无缺勤、请假及迟到早退现象得5分，否则以上情况出现一次扣2分，扣完为止；\n', 5, '财务1', '2023-03-13 08:42:15', 0, 3, '肖鹏自评3', '人事1', '2023-03-13 08:42:18', 0, 5, '人事考核', '刘明兰', '2023-03-13 08:42:21', 0, 5, NULL, '会计', 4, 0, '1', '2023-02-25 13:52:57', '1', '2023-03-13 08:42:22', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (13, 5, 3, '2023年03月考核', '建立健全出纳各种账目，保证账款相符，掌握银行资金进出数目清楚明了，银行现金帐做到准确无误。\n', '出现差错扣5分/次；', 10, '出纳', '2023-03-20 21:20:05', 0, 9, NULL, '人事1', '2023-03-20 22:35:06', 0, 10, NULL, '刘明兰', '2023-03-21 00:09:10', 0, 10, NULL, '出纳', 4, 1, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:09:11', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (14, 5, 3, '2023年03月考核', '做好LAW WIT收费信息审核、出票审核、收费状态审核（含客户名称、客户收费、信息对比、出票规范、出票数量、已收、开票、归档状态等）\n', '出现差错扣5分/次；', 5, '出纳', '2023-03-20 21:20:05', 0, 4, NULL, '人事1', '2023-03-20 22:35:06', 0, 5, NULL, '刘明兰', '2023-03-21 00:09:10', 0, 5, NULL, '出纳', 4, 1, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:09:10', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (15, 5, 3, '2023年03月考核', '律所创收目标达成率', '\"目标达成率=实际创收额/计划创收额*100%，\n目标达成率达到50%，该项得满分\n40%≤目标达成率﹤50%，得15分\n30%≤目标达成率﹤40%，得10分\n目标达成率﹤30%，该项不得分\n目标达成率高于80%按照比例计算得分\"', 20, '出纳', '2023-03-20 21:20:05', 0, 19, NULL, '人事1', '2023-03-20 22:35:06', 0, 19, NULL, '刘明兰', '2023-03-21 00:09:10', 0, 20, NULL, '出纳', 4, 0, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:09:10', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (16, 5, 3, '2023年03月考核', '纪律与着装', '工作时间，非工作事宜不得随意串岗闲聊，工作日期间必须着正装，佩戴工牌，否则扣2分/次，扣完为止。', 5, '出纳', '2023-03-20 21:20:05', 0, 4, NULL, '人事1', '2023-03-20 22:35:06', 0, 5, NULL, '刘明兰', '2023-03-21 00:09:10', 0, 5, NULL, '出纳', 4, 0, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:09:10', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (17, 5, 3, '2023年03月考核', '工作态度', '工作日期间必须语言文雅，言辞得当，在办公场所保持和谐,责任心强，工作态度积极，工作零失误得5分，失误一次扣2分，扣完为止；\n', 5, '出纳', '2023-03-20 21:20:05', 0, 4, NULL, '人事1', '2023-03-20 22:35:06', 0, 3, NULL, '刘明兰', '2023-03-21 00:09:10', 0, 3, NULL, '出纳', 4, 0, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:09:10', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (18, 5, 3, '2023年03月考核', '考勤', '当月考勤无缺勤、请假及迟到早退现象得5分，否则以上情况出现一次扣2分，扣完为止；\n', 5, '出纳', NULL, 0, 4, NULL, '人事1', NULL, 0, 5, '人事考评出纳', '刘明兰', '2023-03-21 00:09:10', 0, 3, '刘明兰终评出纳', '出纳', 4, 0, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:09:10', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (19, 5, 4, '2023年03月考核', '了解当地税收政策，认真研究税法，负责参与拟定财务计划，审核、分析、监督预算和财务计划的执行情况', '出现差错扣5分/次', 10, '会计', '2023-03-20 21:31:58', 0, 10, NULL, '人事1', '2023-03-20 22:35:06', 0, 10, NULL, '刘明兰', '2023-03-21 00:06:44', 0, 10, NULL, '会计', 4, 1, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:06:45', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (20, 5, 4, '2023年03月考核', '内外账目登记准确无误，账表相符；账本、凭证、纳税申报表单妥善保管，无外泄；保证财务流程正常运行，无造成经济损失；各项财务报表真实可靠、全面完整。', '出现差错，或未及时完成扣5分/次；', 10, '会计', '2023-03-20 21:31:58', 0, 10, NULL, '人事1', '2023-03-20 22:35:06', 0, 10, NULL, '刘明兰', '2023-03-21 00:06:44', 0, 10, NULL, '会计', 4, 1, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:06:45', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (21, 5, 4, '2023年03月考核', '律所创收目标达成率', '\"目标达成率=实际创收额/计划创收额*100%，\n目标达成率达到50%，该项得满分\n40%≤目标达成率﹤50%，得15分\n30%≤目标达成率﹤40%，得10分\n目标达成率﹤30%，该项不得分\n目标达成率高于80%按照比例计算得分\"', 20, '会计', '2023-03-20 21:31:58', 0, 19, NULL, '人事1', '2023-03-20 22:35:06', 0, 20, NULL, '刘明兰', '2023-03-21 00:06:44', 0, 20, NULL, '会计', 4, 0, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:06:45', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (22, 5, 4, '2023年03月考核', '纪律与着装', '工作时间，非工作事宜不得随意串岗闲聊，工作日期间必须着正装，佩戴工牌，否则扣2分/次，扣完为止。', 5, '会计', '2023-03-20 21:31:58', 0, 5, NULL, '人事1', '2023-03-20 22:35:06', 0, 5, NULL, '刘明兰', '2023-03-21 00:06:44', 0, 5, NULL, '会计', 4, 0, '1', '2023-03-20 11:20:43', '123', '2023-03-21 00:06:45', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (23, 5, 4, '2023年03月考核', '工作态度', '工作日期间必须语言文雅，言辞得当，在办公场所保持和谐,责任心强，工作态度积极，工作零失误得5分，失误一次扣2分，扣完为止；\n', 5, '会计', '2023-03-20 21:31:57', 0, 5, NULL, '人事1', '2023-03-20 22:35:06', 0, 3, NULL, '刘明兰', '2023-03-21 00:06:44', 0, 5, NULL, '会计', 4, 0, '1', '2023-03-20 11:20:44', '123', '2023-03-21 00:06:45', b'0', 1);
INSERT INTO `kpi_assess_staff_item` VALUES (24, 5, 4, '2023年03月考核', '考勤', '当月考勤无缺勤、请假及迟到早退现象得5分，否则以上情况出现一次扣2分，扣完为止；\n', 5, '会计', '2023-03-20 21:31:57', 0, 4, '会计自评', '人事1', '2023-03-20 22:35:06', 0, 4, '人事考评会计', '刘明兰', '2023-03-21 00:06:44', 0, 3, '刘明兰终评会计', '会计', 4, 0, '1', '2023-03-20 11:20:44', '123', '2023-03-21 00:06:45', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
