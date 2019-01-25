/*
SQLyog Trial v12.4.1 (64 bit)
MySQL - 5.7.17-enterprise-commercial-advanced-log : Database - anan_oa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`anan_oa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `anan_oa`;

/*Table structure for table `manage_process` */

DROP TABLE IF EXISTS `manage_process`;

CREATE TABLE `manage_process` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '流程名称',
  `type_id` int(11) NOT NULL COMMENT '流程类型（字典表选项dict_id）',
  `schedule_id` int(11) NOT NULL COMMENT '流程进度（字典表选项dict_id）',
  `process_time` int(11) DEFAULT NULL COMMENT '流程时间段（字典表选项dict_id）',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user_id` int(11) DEFAULT NULL COMMENT '更新人',
  `approval_user_id` int(11) DEFAULT NULL COMMENT '审批人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '流程备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='流程表';

/*Data for the table `manage_process` */

insert  into `manage_process`(`id`,`name`,`type_id`,`schedule_id`,`process_time`,`create_user_id`,`update_user_id`,`approval_user_id`,`create_time`,`update_time`,`remark`) values 
(1,'aa',104,111,NULL,1,1,NULL,'2019-01-25 18:14:02','2019-01-25 18:14:11',NULL);

/*Table structure for table `manage_process_log` */

DROP TABLE IF EXISTS `manage_process_log`;

CREATE TABLE `manage_process_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `process_id` int(11) NOT NULL COMMENT '流程ID',
  `schedule_id` int(11) NOT NULL COMMENT '流程状态（读取流程实体的进度属性）',
  `update_user_id` int(11) NOT NULL COMMENT '更新人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程生命表（日志表）\r\n用于记录流程的开始到审批结束';

/*Data for the table `manage_process_log` */

/*Table structure for table `rbac_dictionary` */

DROP TABLE IF EXISTS `rbac_dictionary`;

CREATE TABLE `rbac_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_type` varchar(64) NOT NULL COMMENT '字典类型',
  `option_value` varchar(64) NOT NULL COMMENT '选项值',
  `label` varchar(64) NOT NULL COMMENT '选项文本',
  `ex1` varchar(64) DEFAULT NULL COMMENT '扩展字段a',
  `ex2` varchar(64) DEFAULT NULL COMMENT '扩展字段b',
  `remark` varchar(256) DEFAULT NULL COMMENT '选项备注',
  `show_order` int(11) DEFAULT NULL COMMENT '排序',
  `editable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可编辑(含删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_type` (`dict_type`,`option_value`),
  FULLTEXT KEY `sys_dict_option` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COMMENT='选项字典dictionary\r\n（用来存储role+menu+流程状态）';

/*Data for the table `rbac_dictionary` */

insert  into `rbac_dictionary`(`id`,`dict_type`,`option_value`,`label`,`ex1`,`ex2`,`remark`,`show_order`,`editable`) values 
(1,'ac_menu_type','SYSTEM','系统',NULL,NULL,NULL,1,1),
(2,'ac_menu_type','MODULE','模块',NULL,NULL,NULL,2,1),
(3,'ac_menu_type','PAGE','页面',NULL,NULL,NULL,3,1),
(4,'ac_menu_type','BUTTON','按钮',NULL,NULL,NULL,4,1),
(34,'mgr_check_type','NORMAL','正常',NULL,NULL,NULL,1,1),
(58,'mgr_shift_type','ONTIME','上班',NULL,NULL,NULL,1,1),
(59,'mgr_shift_type','OFFTIME','下班',NULL,NULL,NULL,2,1),
(101,'rbac_role','ADMIN','管理员',NULL,NULL,NULL,1,1),
(102,'rbac_role','USER','普通用户',NULL,NULL,NULL,1,1),
(103,'rbac_role','VIP_USER','VIP用户',NULL,NULL,NULL,1,1),
(104,'manage_process_type','MARRY','婚假',NULL,NULL,NULL,1,1),
(105,'manage_process_type','MATERNITY','产假',NULL,NULL,NULL,1,1),
(106,'manage_process_type','ANNUAL','年假',NULL,NULL,NULL,1,1),
(107,'manage_process_type','OTHER','其他',NULL,NULL,NULL,1,1),
(108,'manage_approver_type','PASS','通过',NULL,NULL,'提供审核的类型',1,1),
(110,'manage_approver_type','FAIL','不通过',NULL,NULL,'提供审核的类型',1,1),
(111,'manage_process_schedule','DRAFT','草稿',NULL,NULL,NULL,1,1),
(112,'manage_process_schedule','DONE','完成',NULL,NULL,NULL,1,1),
(113,'manage_process_schedule','INVALID','作废',NULL,NULL,NULL,1,1),
(114,'manage_process_schedule','REVIEW','审核中',NULL,NULL,NULL,1,1),
(115,'manage_process_type','SICK','病假',NULL,NULL,NULL,1,1),
(116,'manage_process_type','BUSY','事假',NULL,NULL,NULL,1,1),
(117,'manage_process_type','CLASS','补班',NULL,NULL,NULL,1,1),
(118,'manage_process_type','RELAX','休息',NULL,NULL,NULL,1,1),
(119,'manage_process_type','ACTIVITY','活动',NULL,NULL,NULL,1,1),
(120,'manage_process_type','PUBLIC','公休',NULL,NULL,NULL,1,1),
(121,'manage_process_type','STATUTORY','法定节假日',NULL,NULL,NULL,1,1),
(122,'manage_process_type','OUT','外勤',NULL,NULL,NULL,1,1),
(123,'manage_process_type','EARLY','早退',NULL,NULL,NULL,1,1),
(124,'manage_process_type','LATE','迟到',NULL,NULL,NULL,1,1),
(125,'manage_process_type','REPAIR','补卡',NULL,NULL,NULL,1,1),
(126,'manage_process_type','LACK','缺卡',NULL,NULL,NULL,1,1),
(127,'manage_process_type','FAMILY','探亲假',NULL,NULL,NULL,1,1),
(128,'manage_process_time','AM','上午',NULL,NULL,NULL,1,1),
(129,'manage_process_time','PM','下午',NULL,NULL,NULL,1,1),
(131,'manage_process_time','ALL','全天',NULL,NULL,NULL,1,1);

/*Table structure for table `rbac_menu` */

DROP TABLE IF EXISTS `rbac_menu`;

CREATE TABLE `rbac_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级Id',
  `url` varchar(255) DEFAULT NULL COMMENT 'controller',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用（1:启用，0:禁用）',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rbac_menu` */

/*Table structure for table `rbac_user` */

DROP TABLE IF EXISTS `rbac_user`;

CREATE TABLE `rbac_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '账户',
  `password` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '昵称',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别',
  `email` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机',
  `last_ip` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '上次登录IP',
  `last_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次登陆时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

/*Data for the table `rbac_user` */

insert  into `rbac_user`(`id`,`account`,`password`,`name`,`sex`,`email`,`phone`,`last_ip`,`last_time`,`create_time`,`update_time`) values 
(1,'admin','$2a$04$1OiUa3yEchBXQBJI8JaMyuKZNlwzWvfeQjKAHnwAEQwnacjt6ukqu','admin',0,NULL,NULL,NULL,'2018-08-23 10:36:37','2018-08-23 10:36:37','2018-08-23 10:36:37'),
(23,'anan1527','$2a$10$gU7PXeWhJOLA.gi34J/Ubu099mPmd9innx3aHzQSG1Jx/jcVXyJra','anan-name',NULL,NULL,NULL,NULL,'2019-01-24 15:28:08','2019-01-24 15:28:08','2019-01-24 15:28:08'),
(24,'anan1529','$2a$10$AS1fNDwjmGFaXZv6BuIgKuaWofLU5.zm/HMf9RZeDq.bfHf7xDzYO','anan-name29',NULL,NULL,NULL,NULL,'2019-01-24 15:29:53','2019-01-24 15:29:53','2019-01-24 15:29:53');

/*Table structure for table `rbac_user_role` */

DROP TABLE IF EXISTS `rbac_user_role`;

CREATE TABLE `rbac_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT 'auth_user的主键',
  `role_id` int(11) NOT NULL COMMENT 'auth_role的主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `rbac_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
