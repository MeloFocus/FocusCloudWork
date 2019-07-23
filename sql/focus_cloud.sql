/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : focus_cloud

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2019-07-23 21:40:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_authority
-- ----------------------------
DROP TABLE IF EXISTS `base_authority`;
CREATE TABLE `base_authority` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(50) default NULL,
  `CODE` varchar(50) default NULL COMMENT 'shiro某权限标志',
  `URL` varchar(200) default NULL,
  `METHOD` varchar(50) default NULL COMMENT '请求方式',
  `CONTROLLER` varchar(50) default NULL COMMENT 'controller',
  `DES` varchar(200) default NULL,
  `CREAT_USER` varchar(50) default NULL,
  `CREAT_DATE` datetime default NULL,
  `UPDATE_USER` varchar(50) default NULL,
  `UPDATE_DATE` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_authority
-- ----------------------------
INSERT INTO `base_authority` VALUES ('06ac587d-fd07-1037-86f1-f54783bc2480', '删除用户', 'baseUser_deleteUser', 'base/baseUser/user/{userIds}', 'delete', 'BaseUserController', '', 'melo', '2019-07-21 20:55:40', 'melo', '2019-07-21 20:55:40');
INSERT INTO `base_authority` VALUES ('161331bd-fd07-1037-86f1-f54783bc2480', '用户列表', 'baseUser_userList', 'base/baseUser/user/list', 'get', 'BaseUserController', '', 'melo', '2019-07-21 20:56:06', 'melo', '2019-07-21 20:56:06');
INSERT INTO `base_authority` VALUES ('1a72eb4c-fd05-1037-86f1-f54783bc2480', '新增角色', 'baseRole_saveRole', 'base/baseRole/role', 'post', 'BaseRoleController', '', 'melo', '2019-07-21 20:41:55', 'melo', '2019-07-21 20:41:55');
INSERT INTO `base_authority` VALUES ('258a92eb-fd05-1037-86f1-f54783bc2480', '修改角色', 'baseRole_updateRole', 'base/baseRole/role', 'put', 'BaseRoleController', '', 'melo', '2019-07-21 20:42:13', 'melo', '2019-07-21 20:42:13');
INSERT INTO `base_authority` VALUES ('346dc499-fd05-1037-86f1-f54783bc2480', '删除角色', 'baseRole_deleteRole', 'base/baseRole/role', 'delete', 'BaseRoleController', '', 'melo', '2019-07-21 20:42:38', 'melo', '2019-07-21 20:42:38');
INSERT INTO `base_authority` VALUES ('4bbb0c86-fd06-1037-86f1-f54783bc2480', '首页资源', 'baseResource_indexResource', 'base/baseResource/indexResource', 'get', 'BaseRresourceController', '', 'melo', '2019-07-21 20:50:27', 'melo', '2019-07-21 20:50:27');
INSERT INTO `base_authority` VALUES ('53872bd0-fd05-1037-86f1-f54783bc2480', '给角色授权资源', 'baseRoleResource_authorize', 'base/baseRoleResource/authorize', 'post', 'BaseRoleResourceController', '', 'melo', '2019-07-21 20:43:30', 'melo', '2019-07-21 20:43:30');
INSERT INTO `base_authority` VALUES ('5b8d8848-fd07-1037-86f1-f54783bc2480', '用户详情', 'baseUser_detail', 'base/baseUser/detail', 'get', 'BaseUserController', '', 'melo', '2019-07-21 20:58:03', 'melo', '2019-07-21 20:58:03');
INSERT INTO `base_authority` VALUES ('7de33051-fd06-1037-86f1-f54783bc2480', '某模块资源', 'baseResource_resourcesInModule', 'base/baseResource/indexResource', 'get', 'BaseRresourceController', '', 'melo', '2019-07-21 20:51:51', 'melo', '2019-07-21 20:51:51');
INSERT INTO `base_authority` VALUES ('afecda90-fd07-1037-86f1-f54783bc2480', '给用户授权角色', 'baseUserRole_authorize', 'base/baseUserRole/authoiize', 'post', 'BaseUserRoleController', '', 'melo', '2019-07-21 21:00:24', 'melo', '2019-07-21 21:00:24');
INSERT INTO `base_authority` VALUES ('b4c0c384-fd06-1037-86f1-f54783bc2480', '所有资源树', 'baseResource_resourceTree', 'base/baseResource/resourceTree', 'get', 'BaseRresourceController', '', 'melo', '2019-07-21 20:53:23', 'melo', '2019-07-21 20:53:23');
INSERT INTO `base_authority` VALUES ('c6e57652-fd07-1037-86f1-f54783bc2480', '某用户的角色', 'baseUserRole_roleOfUser', 'base/baseUserRole/roleOfUser', 'get', 'BaseUserRoleController', '', 'melo', '2019-07-21 21:01:03', 'melo', '2019-07-21 21:01:03');
INSERT INTO `base_authority` VALUES ('dd48bf2a-fd06-1037-86f1-f54783bc2480', '创建用户', 'baseUser_createUser', 'base/baseUser/user', 'post', 'BaseUserController', '', 'melo', '2019-07-21 20:54:31', 'melo', '2019-07-21 20:54:31');
INSERT INTO `base_authority` VALUES ('e7891b3e-fd07-1037-86f1-f54783bc2480', '角色列表及此用户拥有的角色', 'baseUserRole_roleAuthorizeList', 'base/baseUserRole/roleList', 'get', 'BaseUserRoleController', '', 'melo', '2019-07-21 21:01:58', 'melo', '2019-07-21 21:01:58');
INSERT INTO `base_authority` VALUES ('ec20e176-fd06-1037-86f1-f54783bc2480', '修改用户', 'baseUser_updateUser', 'base/baseUser/user', 'put', 'BaseUserController', '', 'melo', '2019-07-21 20:54:56', 'melo', '2019-07-21 20:54:56');
INSERT INTO `base_authority` VALUES ('ff3a2aa7-fd04-1037-86f1-f54783bc2480', '角色列表', 'baseRole_roleList', 'base/baseRole/roleList', 'get', 'BaseRoleController', '', 'melo', '2019-07-21 20:41:09', 'melo', '2019-07-21 20:41:09');

-- ----------------------------
-- Table structure for base_image
-- ----------------------------
DROP TABLE IF EXISTS `base_image`;
CREATE TABLE `base_image` (
  `ID` varchar(50) NOT NULL,
  `URL` varchar(50) default NULL,
  `REMARK` varchar(50) default NULL,
  `CREAT_USER` varchar(50) default NULL,
  `CREAT_DATE` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_image
-- ----------------------------

-- ----------------------------
-- Table structure for base_resource
-- ----------------------------
DROP TABLE IF EXISTS `base_resource`;
CREATE TABLE `base_resource` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(20) default NULL,
  `TYPE` tinyint(2) default NULL COMMENT '1模块module,2菜单，3按钮',
  `CODE` varchar(50) default NULL COMMENT '标志,module开头模块，menu开头菜单,btn开头按钮',
  `PID` varchar(50) default NULL COMMENT '父资源id',
  `PATH` varchar(300) default NULL COMMENT '从根菜单到此菜单的路径,由code组成',
  `SORT` tinyint(2) default NULL COMMENT '序号是同级的排列',
  `PICTURE` varchar(200) default NULL,
  `DES` varchar(50) default NULL COMMENT '描述',
  `MENU_ROUTE` varchar(200) default NULL COMMENT '如果是菜单资源会有此属性,标志跳转的页面url',
  `CREAT_USER` varchar(50) default NULL,
  `CREAT_DATE` datetime default NULL,
  `UPDATE_USER` varchar(50) default NULL,
  `UPDATE_DATE` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_resource
-- ----------------------------
INSERT INTO `base_resource` VALUES ('11881cc6-ee0c-1037-941f-2ba9d11d1d3a', '部门管理', '1', 'module_department _manage', '-1', 'module_department _manage', '3', null, '部门管理模块', 'departmentManage.html', 'melo', '2019-07-02 19:23:59', 'melo', '2019-07-02 19:23:59');
INSERT INTO `base_resource` VALUES ('1422c479-f9da-1037-87fb-f895045088b8', '资源管理', '2', 'menu_resource_list', '26fb1fd0-ee0b-1037-941f-2ba9d11d1d3a', 'module_authority_manage/menu_resource_list', '2', null, '资源管理列表', 'resourceList.html', 'melo', '2019-07-17 19:56:22', 'melo', '2019-07-17 19:56:22');
INSERT INTO `base_resource` VALUES ('15834162-f2d7-1037-9a77-451bb43a0465', '修改用户', '3', 'btn_user_update', 'a59c887d-f2d6-1037-9a77-451bb43a0465', 'module_user_manage/menu_user_list/btn_user_update', '2', null, '修改用户', null, 'mleo', '2019-07-08 21:47:08', 'mleo', '2019-07-08 21:47:10');
INSERT INTO `base_resource` VALUES ('26fb1fd0-ee0b-1037-941f-2ba9d11d1d3a', '权限管理', '1', 'module_authority_manage', '-1', 'module_authority_manage', '2', null, '权限管理模块', 'authorityManage.html', 'melo', '2019-07-02 19:17:25', 'melo', '2019-07-02 19:17:25');
INSERT INTO `base_resource` VALUES ('3c9a3cee-f2d8-1037-9a77-451bb43a0465', '删除用户', '3', 'btn_user_delete', 'a59c887d-f2d6-1037-9a77-451bb43a0465', 'module_user_manage/menu_user_list/btn_user_delete', '4', null, '删除用户', null, 'mleo', '2019-07-08 21:47:08', 'mleo', '2019-07-08 21:47:08');
INSERT INTO `base_resource` VALUES ('4a9565e6-ee0c-1037-941f-2ba9d11d1213', '通知', '1', 'module_notice_manage', '-1', 'module_notice_manage', '4', null, '通知', 'noticeManage.html', 'melo', '2019-07-07 09:14:54', 'melo', '2019-07-07 09:15:00');
INSERT INTO `base_resource` VALUES ('63778271-f2d8-1037-9a77-451bb43a0465', '用户授权', '3', 'btn_user_authorize', 'a59c887d-f2d6-1037-9a77-451bb43a0465', 'module_user_manage/menu_user_list/btn_user_authorize', '5', null, '给用户授权', null, 'mleo', '2019-07-08 21:47:08', 'mleo', '2019-07-08 21:47:08');
INSERT INTO `base_resource` VALUES ('64b31eed-f9da-1037-87fb-f895045088b8', '新增角色', '3', 'btn_role_add', 'cb39f08b-f9d9-1037-87fb-f895045088b8', 'module_authority_manage/menu_role_list/btn_role_add', '1', null, '新增角色按钮', null, 'melo', '2019-07-17 19:58:37', 'melo', '2019-07-17 19:58:37');
INSERT INTO `base_resource` VALUES ('721d1b3c-f9da-1037-87fb-f895045088b8', '修改角色', '3', 'btn_role_update', 'cb39f08b-f9d9-1037-87fb-f895045088b8', 'module_authority_manage/menu_role_list/btn_role_update', '2', null, '修改角色按钮', null, 'melo', '2019-07-17 19:59:00', 'melo', '2019-07-17 19:59:00');
INSERT INTO `base_resource` VALUES ('7db94c7c-ee0a-1037-941f-2ba9d11d1d3a', '用户管理', '1', 'module_user_manage', '-1', 'module_user_manage', '1', null, '用户管理模块', 'userManage.html', 'melo', '2019-07-02 19:12:41', 'melo', '2019-07-02 19:12:41');
INSERT INTO `base_resource` VALUES ('81d1908e-f9da-1037-87fb-f895045088b8', '删除角色', '3', 'btn_role_delete', 'cb39f08b-f9d9-1037-87fb-f895045088b8', 'module_authority_manage/menu_role_list/btn_role_delete', '3', null, '删除角色按钮', null, 'melo', '2019-07-17 19:59:26', 'melo', '2019-07-17 19:59:26');
INSERT INTO `base_resource` VALUES ('95f53f07-f9da-1037-87fb-f895045088b8', '角色授权', '3', 'btn_role_authorize', 'cb39f08b-f9d9-1037-87fb-f895045088b8', 'module_authority_manage/menu_role_list/btn_role_authorize', '4', null, '授权角色按钮', null, 'melo', '2019-07-17 20:00:00', 'melo', '2019-07-17 20:00:00');
INSERT INTO `base_resource` VALUES ('a59c887d-f2d6-1037-9a77-451bb43a0465', '用户列表', '2', 'menu_user_list', '7db94c7c-ee0a-1037-941f-2ba9d11d1d3a', 'module_user_manage/menu_user_list', '1', null, '用户列表', 'userList.html', 'mleo', '2019-07-08 21:45:48', 'melo', '2019-07-08 21:45:53');
INSERT INTO `base_resource` VALUES ('cb39f08b-f9d9-1037-87fb-f895045088b8', '角色管理', '2', 'menu_role_list', '26fb1fd0-ee0b-1037-941f-2ba9d11d1d3a', 'module_authority_manage/menu_role_list', '1', null, '角色管理', 'roleList.html', 'melo', '2019-07-17 19:54:20', 'melo', '2019-07-17 19:54:20');
INSERT INTO `base_resource` VALUES ('e6b66c83-f2d6-1037-9a77-451bb43a0465', '新增用户', '3', 'btn_user_add', 'a59c887d-f2d6-1037-9a77-451bb43a0465', 'module_user_manage/menu_user_list/btn_user_add', '1', null, '新增用户', null, 'mleo', '2019-07-08 21:47:08', 'mleo', '2019-07-08 21:47:10');
INSERT INTO `base_resource` VALUES ('fd2da964-f2d7-1037-9a77-451bb43a0465', '查看用户', '3', 'btn_user_detail', 'a59c887d-f2d6-1037-9a77-451bb43a0465', 'module_user_manage/menu_user_list/btn_user_detail', '3', null, '用户详情', null, 'mleo', '2019-07-08 21:47:08', 'mleo', '2019-07-08 21:47:08');
INSERT INTO `base_resource` VALUES ('fsdfewfwefewfwefsdaf324234234234234', '首页页面', '4', 'page_index', '-1', 'page_index', '1', null, '首页页面', null, null, null, null, null);

-- ----------------------------
-- Table structure for base_resource_authority_r
-- ----------------------------
DROP TABLE IF EXISTS `base_resource_authority_r`;
CREATE TABLE `base_resource_authority_r` (
  `ID` varchar(50) NOT NULL,
  `RESOURCE_ID` varchar(50) default NULL,
  `AUTHORITY_ID` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_Reference_7` (`RESOURCE_ID`),
  KEY `Fk_Authority` (`AUTHORITY_ID`),
  CONSTRAINT `Fk_Authority` FOREIGN KEY (`AUTHORITY_ID`) REFERENCES `base_authority` (`ID`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`RESOURCE_ID`) REFERENCES `base_resource` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_resource_authority_r
-- ----------------------------
INSERT INTO `base_resource_authority_r` VALUES ('01162888-fe9b-1037-8555-ed25f14ba24d', '7db94c7c-ee0a-1037-941f-2ba9d11d1d3a', '161331bd-fd07-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('10ee19ab-fe9b-1037-8555-ed25f14ba24d', '81d1908e-f9da-1037-87fb-f895045088b8', '346dc499-fd05-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('13400306-fe99-1037-8555-ed25f14ba24d', '15834162-f2d7-1037-9a77-451bb43a0465', 'ec20e176-fd06-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('3241056f-fe9b-1037-8555-ed25f14ba24d', '95f53f07-f9da-1037-87fb-f895045088b8', '53872bd0-fd05-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('35cbf620-fe99-1037-8555-ed25f14ba24d', '15834162-f2d7-1037-9a77-451bb43a0465', '5b8d8848-fd07-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('364b4909-fe9a-1037-8555-ed25f14ba24d', 'fsdfewfwefewfwefsdaf324234234234234', '4bbb0c86-fd06-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('42f54fbe-fe9b-1037-8555-ed25f14ba24d', 'a59c887d-f2d6-1037-9a77-451bb43a0465', '161331bd-fd07-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('49df49ad-fe9a-1037-8555-ed25f14ba24d', 'fsdfewfwefewfwefsdaf324234234234234', '7de33051-fd06-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('58d7b3c7-fe9b-1037-8555-ed25f14ba24d', 'cb39f08b-f9d9-1037-87fb-f895045088b8', 'ff3a2aa7-fd04-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('69c39a50-fe9b-1037-8555-ed25f14ba24d', 'e6b66c83-f2d6-1037-9a77-451bb43a0465', 'dd48bf2a-fd06-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('7f569210-fe9b-1037-8555-ed25f14ba24d', 'fd2da964-f2d7-1037-9a77-451bb43a0465', '5b8d8848-fd07-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('a8e8aecf-fe9a-1037-8555-ed25f14ba24d', '3c9a3cee-f2d8-1037-9a77-451bb43a0465', '06ac587d-fd07-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('b63e8e96-fe9a-1037-8555-ed25f14ba24d', '63778271-f2d8-1037-9a77-451bb43a0465', 'afecda90-fd07-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('c8642a87-fe9a-1037-8555-ed25f14ba24d', '64b31eed-f9da-1037-87fb-f895045088b8', '1a72eb4c-fd05-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('de88dd48-fe9a-1037-8555-ed25f14ba24d', '721d1b3c-f9da-1037-87fb-f895045088b8', '258a92eb-fd05-1037-86f1-f54783bc2480');
INSERT INTO `base_resource_authority_r` VALUES ('ee9b341e-fe98-1037-8555-ed25f14ba24d', '1422c479-f9da-1037-87fb-f895045088b8', 'b4c0c384-fd06-1037-86f1-f54783bc2480');

-- ----------------------------
-- Table structure for base_role
-- ----------------------------
DROP TABLE IF EXISTS `base_role`;
CREATE TABLE `base_role` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(20) default NULL,
  `CODE` varchar(20) default NULL COMMENT '权限标志，用在程序中判断角色',
  `TYPE` tinyint(2) default NULL COMMENT '内置角色1，自定义角色2',
  `SORT` tinyint(3) default NULL COMMENT '序号',
  `STATUS` tinyint(2) default NULL COMMENT '状态,0是删除，1是正常',
  `DES` varchar(50) default NULL COMMENT '描述',
  `CREAT_USER` varchar(50) default NULL,
  `CREAT_DATE` datetime default NULL,
  `UPDATE_USER` varchar(50) default NULL,
  `UPDATE_DATE` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_role
-- ----------------------------
INSERT INTO `base_role` VALUES ('123', '管理员', 'administrator', '1', '1', '1', null, 'melo', null, 'melo', null);
INSERT INTO `base_role` VALUES ('77fe5872-5e2d-40c3-a42b-db1768f51ef0', '单位管理员', 'unit', '2', '3', '1', 'sdff单位管理员', '123', '2019-07-17 21:18:43', '123', '2019-07-17 21:51:04');
INSERT INTO `base_role` VALUES ('d705ad81-98dd-4550-a985-860a36bd1e02', '部门管理', 'department', '2', '4', '2', '21e', '123', '2019-07-17 21:50:40', '123', '2019-07-17 21:50:40');
INSERT INTO `base_role` VALUES ('sdfefwertfe3br1234124412312', '普通用户', 'number', '1', '2', '1', '普通用户', 'melo', '2019-07-23 20:50:54', 'melo', '2019-07-23 20:50:58');

-- ----------------------------
-- Table structure for base_role_business_r
-- ----------------------------
DROP TABLE IF EXISTS `base_role_business_r`;
CREATE TABLE `base_role_business_r` (
  `ID` varchar(50) NOT NULL,
  `ROLE_ID` varchar(50) default NULL COMMENT '角色表主键',
  `CLASS_PK` varchar(50) default NULL COMMENT '业务表主键，比如通知某个发布类型主键',
  `CLASS_NAME` varchar(20) default NULL COMMENT '业务名称,比如通知某个发布类型名称',
  PRIMARY KEY  (`ID`),
  KEY `FK_Reference_8` (`ROLE_ID`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`ROLE_ID`) REFERENCES `base_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_role_business_r
-- ----------------------------

-- ----------------------------
-- Table structure for base_role_resource_r
-- ----------------------------
DROP TABLE IF EXISTS `base_role_resource_r`;
CREATE TABLE `base_role_resource_r` (
  `ID` varchar(50) NOT NULL,
  `ROLE_ID` varchar(50) default NULL,
  `RESOURCE_ID` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_Reference_4` (`ROLE_ID`),
  KEY `FK_Reference_5` (`RESOURCE_ID`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`ROLE_ID`) REFERENCES `base_role` (`ID`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`RESOURCE_ID`) REFERENCES `base_resource` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_role_resource_r
-- ----------------------------
INSERT INTO `base_role_resource_r` VALUES ('1170bacd-fe9a-1037-8555-ed25f14ba24d', 'sdfefwertfe3br1234124412312', 'fsdfewfwefewfwefsdaf324234234234234');
INSERT INTO `base_role_resource_r` VALUES ('a93868de-a866-4f07-bae8-f71925625f54', '123', '11881cc6-ee0c-1037-941f-2ba9d11d1d3a');

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `ID` varchar(50) NOT NULL,
  `USER_TYPE` tinyint(2) default NULL COMMENT '预留给明确不同用户的场景，比如学生、老师,工作人员和客户，肯定不会有重复角色',
  `LOGIN_NAME` varchar(20) default NULL COMMENT '登录名',
  `REAL_NAME` varchar(20) default NULL COMMENT '真实姓名',
  `NICK_NAME` varchar(20) default NULL COMMENT '昵称',
  `PASSWORD` varchar(50) default NULL COMMENT '密码',
  `SEX` bit(1) default NULL,
  `IMAGE_ID` varchar(50) default NULL COMMENT '头像图片id',
  `SUPERMAN` bit(1) default NULL COMMENT '超级管理员',
  `PHONE_NUMBER` varchar(20) default NULL COMMENT '电话',
  `SIGNATURE` varchar(50) default NULL COMMENT '个性签名',
  `EMAIL` varchar(20) default NULL,
  `CREAT_USER` varchar(50) default NULL,
  `CREAT_DATE` datetime default NULL,
  `UPDATE_USER` varchar(50) default NULL,
  `UPDATE_DATE` datetime default NULL,
  `STATUS` tinyint(2) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES ('017ef0e8-f416-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '1');
INSERT INTO `base_user` VALUES ('01c84e9d-f416-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('02167b3c-f416-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('02582456-f416-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('029be2cd-f416-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('02e00142-f416-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('0329d956-f416-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('03768207-f416-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('111', '1', 'james', 'james', 'lebron', 'df49ec48e56522d11151fb9ecd683aef', '', null, '\0', null, '生活是一场修行', null, null, '2019-07-10 11:42:45', null, null, '1');
INSERT INTO `base_user` VALUES ('123', '1', 'melo', 'melo', 'cameron', 'df49ec48e56522d11151fb9ecd683aef', '', null, '', null, '我的旧约圣经也没挽回你', '825178382@qq.com', null, '2019-07-10 11:42:42', null, null, '1');
INSERT INTO `base_user` VALUES ('1ee5fc42-14e3-49fa-bee7-27f6628b0f11', '2', 'kobe', 'kobe', 'kobe', 'p123456', '\0', null, '\0', '13934184115', '', '86416416@qq.com', '123', '2019-07-11 21:15:50', '123', '2019-07-11 21:15:50', null);
INSERT INTO `base_user` VALUES ('3ca12e38-c827-4d34-a990-b3594e9baa77', '2', 'qwea', 'we', 'qwe', 'qwe454884', '\0', null, '\0', '15686099999', 'ewq', '4561941@qq.com', '123', '2019-07-13 10:00:32', '123', '2019-07-13 10:00:32', '2');
INSERT INTO `base_user` VALUES ('452c93ed-598c-4232-8289-7ecb62c05f16', '2', 'weq', 'qwee', 'qwe', 'qwe415', '\0', null, '\0', '15686097236', 'eqw', '5641@qq.com', '123', '2019-07-13 09:57:14', '123', '2019-07-13 09:57:14', '2');
INSERT INTO `base_user` VALUES ('8f09cce9-53bb-4457-9639-6082c626a927', '2', 'weq', 'qwee', 'qwe', 'qwe415', '\0', null, '\0', '15686097236', 'eqw', '5641@qq.com', '123', '2019-07-13 09:57:14', '123', '2019-07-13 09:57:14', '2');
INSERT INTO `base_user` VALUES ('b3d4ea09-d7ee-4560-9887-06b81c9b14b0', '2', 'kkk', 'ewr', 'rwer', 'p123456', '\0', null, '\0', '15686097368', 'sefs', '546545@qq.com', '123', '2019-07-13 09:50:38', '123', '2019-07-13 09:50:38', '2');
INSERT INTO `base_user` VALUES ('ba4082b3-c442-49be-b55e-92f2f5c951f1', '2', 'hiaaaaa', 'dddddddddd', 'qqqq', 'e2b23ca46cfb2e13218d0b9a34239664', '\0', null, '\0', '15689898989', '你不明白', '5614561@qq.com', '123', '2019-07-13 15:54:51', null, null, '1');
INSERT INTO `base_user` VALUES ('eb170899-9a41-4531-b8ac-ec1ede0766f6', '2', 'oo', 'hbk', 'lkh', 'p45611556', '\0', null, '\0', '15755555555', '53', '45153@qq.com', '123', '2019-07-13 10:36:23', '123', '2019-07-13 10:36:23', '2');
INSERT INTO `base_user` VALUES ('fa6536d1-211e-47af-9572-1436ee45d063', '2', 'qwe', 'qwee', 'qwe', 'pqweqw4651', '\0', null, '\0', '15688888888', 'wqe', '5612561@qq.com', '123', '2019-07-13 10:01:04', '123', '2019-07-13 10:01:04', '2');
INSERT INTO `base_user` VALUES ('fd809628-f415-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('ff51a968-f415-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');
INSERT INTO `base_user` VALUES ('ff7dfbd7-f415-1037-9f9d-5ab169fbb184', '1', '莫一夕', 'hello', '小白', 'df49ec48e56522d11151fb9ecd683aef', '\0', null, '\0', null, '此情可待成追忆', null, null, null, null, null, '2');

-- ----------------------------
-- Table structure for base_user_role_r
-- ----------------------------
DROP TABLE IF EXISTS `base_user_role_r`;
CREATE TABLE `base_user_role_r` (
  `ID` varchar(50) NOT NULL,
  `USER_ID` varchar(50) default NULL,
  `ROLE_ID` varchar(50) default NULL,
  `YW_ID` varchar(50) default NULL COMMENT '业务角色表id,业务角色才写',
  PRIMARY KEY  (`ID`),
  KEY `FK_Reference_2` (`USER_ID`),
  KEY `FK_Reference_3` (`ROLE_ID`),
  KEY `FK_Reference_9` (`YW_ID`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`USER_ID`) REFERENCES `base_user` (`ID`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`ROLE_ID`) REFERENCES `base_role` (`ID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`YW_ID`) REFERENCES `base_role_business_r` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_user_role_r
-- ----------------------------
INSERT INTO `base_user_role_r` VALUES ('48b541e3-9f3a-46a4-9b89-ef7d0399662b', '123', '123', null);
INSERT INTO `base_user_role_r` VALUES ('4fc1ae1e-85cf-4312-b7b5-da15a7d0a383', '111', '123', null);
INSERT INTO `base_user_role_r` VALUES ('770156fe-f80e-4d78-8e36-b3873ce298cf', 'ba4082b3-c442-49be-b55e-92f2f5c951f1', '123', null);
INSERT INTO `base_user_role_r` VALUES ('fafff458-a58c-4e81-8403-78433a87b9fe', '111', '77fe5872-5e2d-40c3-a42b-db1768f51ef0', null);
