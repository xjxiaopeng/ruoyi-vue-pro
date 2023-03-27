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

 Date: 27/03/2023 21:22:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_users
-- ----------------------------
DROP TABLE IF EXISTS `system_users`;
CREATE TABLE `system_users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户昵称',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `post_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '岗位编号数组',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` tinyint(4) NULL DEFAULT 0 COMMENT '用户性别',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '头像地址',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '帐号状态（0正常 1停用）',
  `login_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username`, `update_time`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_users
-- ----------------------------
INSERT INTO `system_users` VALUES (1, 'admin', '$2a$10$pF60ws5UCKvum0Dzz7V14uvopOcIOMyXphbe0zVoJud/x93b7SQ9S', '肖鹏', '管理员', 124, '[]', '', '', 1, 'http://test.yudao.iocoder.cn/88f2488850f41ad477a1fcf142e769486638309112c4982d830c085b8c8b9af1.jpg', 0, '127.0.0.1', '2023-03-27 12:20:38', 'admin', '2021-01-05 17:03:47', NULL, '2023-03-27 12:20:38', b'0', 1);
INSERT INTO `system_users` VALUES (112, 'zhengyike', '$2a$10$jh5MsR.ud/gKe3mVeUp5t.nEXGDSmHyv5OYjWQwHO8wlGmMSI9Twy', '郑伊柯', NULL, 121, '[8]', '', '', 2, '', 0, '', NULL, '1', '2022-02-23 19:08:03', '1', '2023-03-27 21:21:26', b'0', 1);
INSERT INTO `system_users` VALUES (114, 'wangjianfei', '$2a$10$TR4eybBioGRhBmDBWkqWLO6NIh3mzYa8KBKDDB5woiGYFVlRAi.fu', '王建飞', NULL, 123, '[7]', '', '', 1, '', 0, '127.0.0.1', '2022-03-19 22:15:43', '1', '2022-03-19 21:50:58', '1', '2023-03-27 21:20:57', b'0', 1);
INSERT INTO `system_users` VALUES (115, 'chengdanna', '$2a$10$39BqG.0MWOiwq1Xke3JcGulypjYqoUJnelDxZQPFQJG/2Kw7D3mIK', '成丹娜', '11', 119, '[5]', '', '', 2, '', 0, '0:0:0:0:0:0:0:1', '2023-03-20 21:41:08', '1', '2022-04-30 02:55:43', '1', '2023-03-27 21:20:27', b'0', 1);
INSERT INTO `system_users` VALUES (117, 'zhongxiaohua', '$2a$10$2A3gdQrFFLShaznEyEWvb.LyhK2zReQC0xQftgOjvzTfKMyBhcavu', '钟晓华', '', 112, '[4]', '', '', 2, '', 0, '127.0.0.1', '2023-03-27 11:47:51', '1', '2022-07-09 17:40:26', '1', '2023-03-27 21:18:54', b'0', 1);
INSERT INTO `system_users` VALUES (118, 'zhangfeixia', '$2a$10$hb/8T52968RG4xqFpGcPcOMaRBXYKdSVHiS1o.kexlsNQujYxunoW', '张飞霞', NULL, 112, '[2]', '', '', 2, '', 0, '127.0.0.1', '2023-03-27 11:48:23', '1', '2022-07-09 17:44:43', '1', '2023-03-27 21:12:52', b'0', 1);
INSERT INTO `system_users` VALUES (123, 'liuminglan', '$2a$10$CTS5eI9qd6XgOV4XiiHa9e0tzVRUN8qIsc0IxOUn5cYCSEihpdPMC', '刘明兰', NULL, 100, '[1]', '', '', 2, '', 0, '127.0.0.1', '2023-03-27 12:08:05', '1', '2023-02-12 00:24:43', NULL, '2023-03-27 12:08:05', b'0', 1);
INSERT INTO `system_users` VALUES (124, 'xiaoshiting', '$2a$10$ZhEd/kSV.lQYsw3Jsb6lxOc1DSGLWgbczUlNFHV7Z5OJTxpIbK5na', '肖诗婷', NULL, 120, '[6]', '', '', 2, '', 0, '', NULL, '1', '2023-03-27 21:09:44', '1', '2023-03-27 21:12:13', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
