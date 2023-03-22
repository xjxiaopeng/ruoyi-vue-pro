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

 Date: 21/03/2023 23:16:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_dept
-- ----------------------------
DROP TABLE IF EXISTS `system_dept`;
CREATE TABLE `system_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父部门id',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `leader_user_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(4) NOT NULL COMMENT '部门状态（0正常 1停用）',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_dept
-- ----------------------------
INSERT INTO `system_dept` VALUES (100, '北京盈科（绍兴）律师事务所', 0, 0, 123, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '1', '2023-02-15 19:31:54', b'0', 1);
INSERT INTO `system_dept` VALUES (101, '深圳总公司', 100, 1, 104, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '1', '2023-02-12 00:19:22', b'1', 1);
INSERT INTO `system_dept` VALUES (102, '长沙分公司', 100, 2, NULL, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '', '2023-02-12 00:15:38', b'1', 1);
INSERT INTO `system_dept` VALUES (103, '研发部门', 101, 1, 104, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '103', '2023-02-12 00:19:20', b'1', 1);
INSERT INTO `system_dept` VALUES (104, '市场部门', 101, 2, NULL, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '1', '2023-02-12 00:19:18', b'1', 1);
INSERT INTO `system_dept` VALUES (105, '测试部门', 101, 3, NULL, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '1', '2023-02-12 00:19:17', b'1', 1);
INSERT INTO `system_dept` VALUES (106, '财务部门', 101, 4, 103, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '103', '2023-02-12 00:19:15', b'1', 1);
INSERT INTO `system_dept` VALUES (107, '运维部门', 101, 5, NULL, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '', '2023-02-12 00:15:41', b'1', 1);
INSERT INTO `system_dept` VALUES (108, '市场部门', 102, 1, NULL, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '1', '2023-02-12 00:15:35', b'1', 1);
INSERT INTO `system_dept` VALUES (109, '财务部门', 102, 2, NULL, '15888888888', 'ry@qq.com', 0, 'admin', '2021-01-05 17:03:47', '', '2023-02-12 00:15:32', b'1', 1);
INSERT INTO `system_dept` VALUES (110, '新部门', 0, 1, NULL, NULL, NULL, 0, '110', '2022-02-23 20:46:30', '110', '2022-02-23 20:46:30', b'0', 121);
INSERT INTO `system_dept` VALUES (111, '顶级部门', 0, 1, NULL, NULL, NULL, 0, '113', '2022-03-07 21:44:50', '113', '2022-03-07 21:44:50', b'0', 122);
INSERT INTO `system_dept` VALUES (112, '财务部', 100, 1, NULL, NULL, NULL, 0, '1', '2023-02-12 00:03:35', '1', '2023-02-12 00:20:52', b'0', 1);
INSERT INTO `system_dept` VALUES (113, '财务部', 112, 0, NULL, NULL, NULL, 0, '1', '2023-02-12 00:08:38', '1', '2023-02-12 00:17:07', b'1', 1);
INSERT INTO `system_dept` VALUES (114, '人事部', 112, 1, NULL, NULL, NULL, 0, '1', '2023-02-12 00:08:58', '1', '2023-02-12 00:17:05', b'1', 1);
INSERT INTO `system_dept` VALUES (115, '客管部', 112, 2, NULL, NULL, NULL, 0, '1', '2023-02-12 00:10:03', '1', '2023-02-12 00:17:03', b'1', 1);
INSERT INTO `system_dept` VALUES (116, '市场部', 112, 3, NULL, NULL, NULL, 0, '1', '2023-02-12 00:14:34', '1', '2023-02-12 00:17:01', b'1', 1);
INSERT INTO `system_dept` VALUES (117, '风控部', 112, 4, NULL, NULL, NULL, 0, '1', '2023-02-12 00:14:52', '1', '2023-02-12 00:16:59', b'1', 1);
INSERT INTO `system_dept` VALUES (118, '行政部', 112, 5, NULL, NULL, NULL, 0, '1', '2023-02-12 00:15:18', '1', '2023-02-12 00:16:57', b'1', 1);
INSERT INTO `system_dept` VALUES (119, '人事部', 100, 2, NULL, NULL, NULL, 0, '1', '2023-02-12 00:19:40', '1', '2023-02-12 00:20:59', b'0', 1);
INSERT INTO `system_dept` VALUES (120, '行政部', 100, 3, NULL, NULL, NULL, 0, '1', '2023-02-12 00:20:07', '1', '2023-02-12 00:21:05', b'0', 1);
INSERT INTO `system_dept` VALUES (121, '文宣部', 100, 4, NULL, NULL, NULL, 0, '1', '2023-02-12 00:20:38', '1', '2023-02-12 00:21:15', b'0', 1);
INSERT INTO `system_dept` VALUES (122, '客管部', 100, 5, NULL, NULL, NULL, 0, '1', '2023-02-12 00:21:37', '1', '2023-02-12 00:21:37', b'0', 1);
INSERT INTO `system_dept` VALUES (123, '风控部', 100, 6, NULL, NULL, NULL, 0, '1', '2023-02-12 00:21:51', '1', '2023-02-12 00:21:51', b'0', 1);
INSERT INTO `system_dept` VALUES (124, '市场部', 100, 7, NULL, NULL, NULL, 0, '1', '2023-02-12 00:22:09', '1', '2023-02-12 00:22:09', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
