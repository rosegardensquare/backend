/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50731
Source Host           : 123.57.29.77:3306
Source Database       : backend

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-12-19 00:13:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for common_user
-- ----------------------------
DROP TABLE IF EXISTS `common_user`;
CREATE TABLE `common_user` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `tel` varchar(255) DEFAULT NULL COMMENT '手机号',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别（ 1：男；2：女）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of common_user
-- ----------------------------
INSERT INTO `common_user` VALUES ('086480ab533b4a0c8fdc2b9af8675da3', '112', '123', '13685968596', '2020-12-14', null, '0', '2020-12-19 00:00:12', '2020-12-19 00:00:12', '0');
INSERT INTO `common_user` VALUES ('465b155bca7f461b9508db1807d75165', '张帅3', 'black', '13685968596', '2020-12-25', null, '1', '2020-12-12 00:18:18', '2020-12-12 00:18:18', '1');
INSERT INTO `common_user` VALUES ('49587c8990a040578ae4441921e7d65a', '张帅', 'black', '13685968596', '2020-12-29', null, '1', '2020-12-12 00:18:18', '2020-12-12 00:18:18', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(255) NOT NULL,
  `menuName` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标代码',
  `path` varchar(50) DEFAULT NULL COMMENT '路径',
  `parentId` varchar(255) DEFAULT NULL COMMENT '父id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `sort` varchar(50) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '用户管理', 'el-icon-s-claim', null, null, '2020-12-18 09:25:48', '2020-12-18 09:25:48', '0', '1');
INSERT INTO `sys_menu` VALUES ('2', '用户列表', 'el-icon-s-tools', '/list', '1', '2020-12-18 09:26:44', '2020-12-18 09:26:44', '0', '2');
INSERT INTO `sys_menu` VALUES ('3', '系统管理', 'el-icon-s-promotion', null, null, '2020-12-18 09:26:59', '2020-12-18 09:26:59', '0', '3');
INSERT INTO `sys_menu` VALUES ('4', '权限列表', 'el-icon-picture', '/manage', '3', '2020-12-18 09:27:19', '2020-12-18 09:27:19', '0', '5');
INSERT INTO `sys_menu` VALUES ('5', '用户列表', 'el-icon-s-tools', '/userList', '3', '2020-12-18 19:19:29', '2020-12-18 19:19:29', '0', '4');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(255) NOT NULL,
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `role_name` varchar(30) DEFAULT NULL COMMENT '角色名称或角色权限',
  `parent_id` varchar(255) DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN', '管理员', null);
INSERT INTO `sys_role` VALUES ('2', null, '用户管理', '1');
INSERT INTO `sys_role` VALUES ('3', null, '用户列表', '1');
INSERT INTO `sys_role` VALUES ('4', null, '系统管理', '1');
INSERT INTO `sys_role` VALUES ('5', null, '权限列表', '1');
INSERT INTO `sys_role` VALUES ('6', 'ROLE_USER', '用户', null);
INSERT INTO `sys_role` VALUES ('7', null, '用户管理', '6');
INSERT INTO `sys_role` VALUES ('8', null, '用户列表', '6');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(255) NOT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `pass_word` varchar(100) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `state` bigint(1) DEFAULT NULL,
  `del` bigint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'zs', '$2a$10$ftDcCXs54S0poQMwt81uwuA3QkwJZULxOOSeBFA5PPkRwArJfrwhK', null, null, '0', '2020-12-18 18:03:27', '2020-12-18 18:03:37');
INSERT INTO `sys_user` VALUES ('2', 'ls', '$2a$10$ftDcCXs54S0poQMwt81uwuA3QkwJZULxOOSeBFA5PPkRwArJfrwhK', '', null, '0', '2020-12-18 18:03:27', '2020-12-18 18:03:37');
INSERT INTO `sys_user` VALUES ('a472986957a14615a66d14b40bec63a8', '123', '123456', null, null, null, '2020-12-19 00:04:05', '2020-12-19 00:04:05');
INSERT INTO `sys_user` VALUES ('bc1cde74b2ae49dc95cfb0c4fb54cdf3', 'er', '$2a$10$MhGcBVm1nvQLC2xz5W/FuusjzPue4oVTc2uIG1AfX7CzY3SXxoe/.', null, null, null, '2020-12-19 00:10:48', '2020-12-19 00:10:48');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '6');
