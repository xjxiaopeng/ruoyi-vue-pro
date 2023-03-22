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

 Date: 21/03/2023 23:09:04
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
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_users
-- ----------------------------
INSERT INTO `system_users` VALUES (1, 'admin', '$2a$10$mRMIYLDtRHlf6.9ipiqH1.Z.bh/R9dO9d5iHiGYPigi6r5KOoR2Wm', '肖鹏', '管理员', 124, '[1]', '', '', 1, 'http://test.yudao.iocoder.cn/88f2488850f41ad477a1fcf142e769486638309112c4982d830c085b8c8b9af1.jpg', 0, '0:0:0:0:0:0:0:1', '2023-03-21 20:29:37', 'admin', '2021-01-05 17:03:47', NULL, '2023-03-21 20:29:37', b'0', 1);
INSERT INTO `system_users` VALUES (100, 'yudao', '$2a$10$11U48RhyJ5pSBYWSn12AD./ld671.ycSzJHbyrtpeoMeYiw31eo8a', '芋道', '不要吓我', 104, '[1]', 'yudao@iocoder.cn', '15601691300', 1, '', 1, '127.0.0.1', '2022-07-09 23:03:33', '', '2021-01-07 09:07:17', NULL, '2022-07-09 23:03:33', b'0', 1);
INSERT INTO `system_users` VALUES (103, 'yuanma', '$2a$10$YMpimV4T6BtDhIaA8jSW.u8UTGBeGhc/qwXP4oxoMr4mOw9.qttt6', '源码', NULL, 106, NULL, 'yuanma@iocoder.cn', '15601701300', 0, '', 0, '127.0.0.1', '2022-07-08 01:26:27', '', '2021-01-13 23:50:35', NULL, '2022-07-08 01:26:27', b'0', 1);
INSERT INTO `system_users` VALUES (104, 'test', '$2a$10$GP8zvqHB//TekuzYZSBYAuBQJiNq1.fxQVDYJ.uBCOnWCtDVKE4H6', '测试号', NULL, 107, '[1,2,4]', '111@qq.com', '15601691200', 1, '', 0, '127.0.0.1', '2022-05-28 15:43:17', '', '2021-01-21 02:13:53', '1', '2023-02-10 18:04:02', b'0', 1);
INSERT INTO `system_users` VALUES (107, 'admin107', '$2a$10$dYOOBKMO93v/.ReCqzyFg.o67Tqk.bbc2bhrpyBGkIw9aypCtr2pm', '芋艿', NULL, NULL, NULL, '', '15601691300', 0, '', 0, '', NULL, '1', '2022-02-20 22:59:33', '1', '2022-02-27 08:26:51', b'0', 118);
INSERT INTO `system_users` VALUES (108, 'admin108', '$2a$10$y6mfvKoNYL1GXWak8nYwVOH.kCWqjactkzdoIDgiKl93WN3Ejg.Lu', '芋艿', NULL, NULL, NULL, '', '15601691300', 0, '', 0, '', NULL, '1', '2022-02-20 23:00:50', '1', '2022-02-27 08:26:53', b'0', 119);
INSERT INTO `system_users` VALUES (109, 'admin109', '$2a$10$JAqvH0tEc0I7dfDVBI7zyuB4E3j.uH6daIjV53.vUS6PknFkDJkuK', '芋艿', NULL, NULL, NULL, '', '15601691300', 0, '', 0, '', NULL, '1', '2022-02-20 23:11:50', '1', '2022-02-27 08:26:56', b'0', 120);
INSERT INTO `system_users` VALUES (110, 'admin110', '$2a$10$mRMIYLDtRHlf6.9ipiqH1.Z.bh/R9dO9d5iHiGYPigi6r5KOoR2Wm', '小王', NULL, NULL, NULL, '', '15601691300', 0, '', 0, '127.0.0.1', '2022-09-25 22:47:33', '1', '2022-02-22 00:56:14', NULL, '2022-09-25 22:47:33', b'0', 121);
INSERT INTO `system_users` VALUES (111, 'test', '$2a$10$mExveopHUx9Q4QiLtAzhDeH3n4/QlNLzEsM4AqgxKrU.ciUZDXZCy', '测试用户', NULL, NULL, '[]', '', '', 0, '', 0, '', NULL, '110', '2022-02-23 13:14:33', '110', '2022-02-23 13:14:33', b'0', 121);
INSERT INTO `system_users` VALUES (112, 'newobject', '$2a$10$jh5MsR.ud/gKe3mVeUp5t.nEXGDSmHyv5OYjWQwHO8wlGmMSI9Twy', '文宣1', NULL, 121, '[8]', '', '', 1, '', 0, '', NULL, '1', '2022-02-23 19:08:03', '1', '2023-02-20 12:09:47', b'0', 1);
INSERT INTO `system_users` VALUES (113, 'aoteman', '$2a$10$0acJOIk2D25/oC87nyclE..0lzeu9DtQ/n3geP4fkun/zIVRhHJIO', '芋道', NULL, NULL, NULL, '', '15601691300', 0, '', 0, '127.0.0.1', '2022-03-19 18:38:51', '1', '2022-03-07 21:37:58', NULL, '2022-03-19 18:38:51', b'0', 122);
INSERT INTO `system_users` VALUES (114, 'hrmgr', '$2a$10$TR4eybBioGRhBmDBWkqWLO6NIh3mzYa8KBKDDB5woiGYFVlRAi.fu', '风控1', NULL, 123, '[7]', '', '', 2, '', 0, '127.0.0.1', '2022-03-19 22:15:43', '1', '2022-03-19 21:50:58', '1', '2023-02-20 12:08:59', b'0', 1);
INSERT INTO `system_users` VALUES (115, 'rensi', '$2a$10$39BqG.0MWOiwq1Xke3JcGulypjYqoUJnelDxZQPFQJG/2Kw7D3mIK', '人事1', '11', 119, '[]', '', '', 2, '', 0, '0:0:0:0:0:0:0:1', '2023-03-20 21:41:08', '1', '2022-04-30 02:55:43', NULL, '2023-03-20 21:41:08', b'0', 1);
INSERT INTO `system_users` VALUES (116, '15601691302', '$2a$10$L5C4S0U6adBWMvFv1Wwl4.DI/NwYS3WIfLj5Q.Naqr5II8CmqsDZ6', '小豆', NULL, NULL, NULL, '', '', 0, '', 0, '', NULL, '1', '2022-05-17 10:07:10', '1', '2022-05-17 10:07:10', b'0', 124);
INSERT INTO `system_users` VALUES (117, 'chuna', '$2a$10$2A3gdQrFFLShaznEyEWvb.LyhK2zReQC0xQftgOjvzTfKMyBhcavu', '出纳', '', 112, '[4]', '', '', 2, '', 0, '0:0:0:0:0:0:0:1', '2023-03-20 21:19:33', '1', '2022-07-09 17:40:26', NULL, '2023-03-20 21:19:33', b'0', 1);
INSERT INTO `system_users` VALUES (118, 'kuaiji', '$2a$10$hb/8T52968RG4xqFpGcPcOMaRBXYKdSVHiS1o.kexlsNQujYxunoW', '会计', NULL, 112, '[2]', '', '', 2, '', 0, '0:0:0:0:0:0:0:1', '2023-03-20 21:31:11', '1', '2022-07-09 17:44:43', NULL, '2023-03-20 21:31:11', b'0', 1);
INSERT INTO `system_users` VALUES (119, 'admin', '$2a$10$AheSOpxeWQYhEO/gGZhDz.oifdX5zt.kprWNHptPiiStUx4mXmHb.', '12', NULL, NULL, NULL, '', '', 0, '', 0, '', NULL, '1', '2022-12-30 11:32:04', '1', '2022-12-30 11:32:04', b'0', 125);
INSERT INTO `system_users` VALUES (120, 'admin', '$2a$10$D.xFtcgma/NJ3SyYlUj3bORcs0mwOD6Zu.4I7GCI/8/25/QSn4qJC', '12', NULL, NULL, NULL, '', '', 0, '', 0, '', NULL, '1', '2022-12-30 11:33:42', '1', '2022-12-30 11:33:42', b'0', 126);
INSERT INTO `system_users` VALUES (121, 'admin', '$2a$10$R2guBf7TyERjjW9lm0Pd0Osut6vt7NuH2Vx6fkOI5.VgSvJK2Xb82', '12', NULL, NULL, NULL, '', '', 0, '', 0, '', NULL, '1', '2022-12-30 11:33:49', '1', '2022-12-30 11:33:49', b'0', 127);
INSERT INTO `system_users` VALUES (122, 'admin', '$2a$10$pwxqUUza61HBgx3FTjp2d.Mc2UKalikXxP91wUdP4bFe7Hl.lfmeq', '12', NULL, NULL, NULL, '', '', 0, '', 0, '', NULL, '1', '2022-12-30 11:47:52', '1', '2022-12-30 11:47:52', b'0', 129);
INSERT INTO `system_users` VALUES (123, 'liuminglan', '$2a$10$vDSSvpvTEfvALhBB.P1SVus9E2q5GfKDok8d8aPCcEWEF/Hy59fXm', '刘明兰', NULL, 100, '[1]', '', '', 2, '', 0, '0:0:0:0:0:0:0:1', '2023-03-20 23:31:39', '1', '2023-02-12 00:24:43', NULL, '2023-03-20 23:31:39', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
