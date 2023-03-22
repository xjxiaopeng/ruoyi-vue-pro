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

 Date: 22/03/2023 00:14:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for kpi_assess_store
-- ----------------------------
DROP TABLE IF EXISTS `kpi_assess_store`;
CREATE TABLE `kpi_assess_store`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '考核指标',
  `standard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '考核标准',
  `score` tinyint(4) NOT NULL DEFAULT 0 COMMENT '考核分值',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `post_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT '岗位编号',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '指标状态（0正常 1停用）',
  `fixed` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否必选（0必选 1可选）',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_unique`(`update_time`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '考核指标库' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kpi_assess_store
-- ----------------------------
INSERT INTO `kpi_assess_store` VALUES (1, '考勤', '当月考勤无缺勤、请假及迟到早退现象得5分，否则以上情况出现一次扣2分，扣完为止；\n', 5, NULL, 00000000000000000000, 0, 0, '1', '2023-02-19 20:35:10', '1', '2023-02-20 11:52:13', b'0', 1);
INSERT INTO `kpi_assess_store` VALUES (2, '工作态度', '工作日期间必须语言文雅，言辞得当，在办公场所保持和谐,责任心强，工作态度积极，工作零失误得5分，失误一次扣2分，扣完为止；\n', 5, NULL, 00000000000000000000, 0, 0, '1', '2023-02-20 11:54:17', '1', '2023-02-20 11:54:17', b'0', 1);
INSERT INTO `kpi_assess_store` VALUES (3, '纪律与着装', '工作时间，非工作事宜不得随意串岗闲聊，工作日期间必须着正装，佩戴工牌，否则扣2分/次，扣完为止。', 5, NULL, 00000000000000000000, 0, 0, '1', '2023-02-20 14:10:58', '1', '2023-02-20 14:10:58', b'0', 1);
INSERT INTO `kpi_assess_store` VALUES (4, '律所创收目标达成率', '\"目标达成率=实际创收额/计划创收额*100%，\n目标达成率达到50%，该项得满分\n40%≤目标达成率﹤50%，得15分\n30%≤目标达成率﹤40%，得10分\n目标达成率﹤30%，该项不得分\n目标达成率高于80%按照比例计算得分\"', 20, NULL, 00000000000000000000, 0, 0, '1', '2023-02-20 14:27:22', '1', '2023-03-20 11:05:35', b'0', 1);
INSERT INTO `kpi_assess_store` VALUES (5, '内外账目登记准确无误，账表相符；账本、凭证、纳税申报表单妥善保管，无外泄；保证财务流程正常运行，无造成经济损失；各项财务报表真实可靠、全面完整。', '出现差错，或未及时完成扣5分/次；', 10, NULL, 00000000000000000002, 0, 1, '1', '2023-02-20 14:29:54', '1', '2023-02-20 14:36:27', b'0', 1);
INSERT INTO `kpi_assess_store` VALUES (6, '了解当地税收政策，认真研究税法，负责参与拟定财务计划，审核、分析、监督预算和财务计划的执行情况', '出现差错扣5分/次', 10, NULL, 00000000000000000002, 0, 1, '1', '2023-02-20 14:39:34', '1', '2023-02-20 14:39:34', b'0', 1);
INSERT INTO `kpi_assess_store` VALUES (7, '做好LAW WIT收费信息审核、出票审核、收费状态审核（含客户名称、客户收费、信息对比、出票规范、出票数量、已收、开票、归档状态等）\n', '出现差错扣5分/次；', 5, NULL, 00000000000000000004, 0, 1, '1', '2023-02-20 14:41:16', '1', '2023-02-22 12:31:31', b'0', 1);
INSERT INTO `kpi_assess_store` VALUES (8, '建立健全出纳各种账目，保证账款相符，掌握银行资金进出数目清楚明了，银行现金帐做到准确无误。\n', '出现差错扣5分/次；', 10, NULL, 00000000000000000004, 0, 1, '1', '2023-02-20 14:41:52', '1', '2023-02-22 13:56:19', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
