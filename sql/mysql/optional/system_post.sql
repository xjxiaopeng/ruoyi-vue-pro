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

 Date: 28/03/2023 12:02:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_post
-- ----------------------------
DROP TABLE IF EXISTS `system_post`;
CREATE TABLE `system_post`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '岗位编码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '岗位名称',
  `sort` int(11) NOT NULL COMMENT '显示顺序',
  `status` tinyint(4) NOT NULL COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '岗位信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_post
-- ----------------------------
INSERT INTO `system_post` VALUES (1, 'ceo', '执行主任', 1, 0, '', 'admin', '2021-01-06 17:03:48', '1', '2023-02-12 00:25:52', b'0', 1);
INSERT INTO `system_post` VALUES (2, 'kj', '会计', 2, 0, '', 'admin', '2021-01-05 17:03:48', '1', '2023-02-12 00:26:20', b'0', 1);
INSERT INTO `system_post` VALUES (4, 'cn', '出纳', 4, 0, '111', 'admin', '2021-01-05 17:03:48', '1', '2023-02-12 00:26:53', b'0', 1);
INSERT INTO `system_post` VALUES (5, 'rz', '人资', 3, 0, NULL, '1', '2023-02-20 12:04:04', '1', '2023-03-22 23:47:21', b'0', 1);
INSERT INTO `system_post` VALUES (6, 'qt', '前台', 5, 0, NULL, '1', '2023-02-20 12:05:45', '1', '2023-02-20 12:05:45', b'0', 1);
INSERT INTO `system_post` VALUES (7, 'fk', '风控', 6, 0, NULL, '1', '2023-02-20 12:06:26', '1', '2023-02-20 12:06:26', b'0', 1);
INSERT INTO `system_post` VALUES (8, 'wx', '文宣', 7, 0, NULL, '1', '2023-02-20 12:07:20', '1', '2023-02-20 12:07:20', b'0', 1);

SET FOREIGN_KEY_CHECKS = 1;
