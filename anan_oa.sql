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

/*Table structure for table `auth_user` */

DROP TABLE IF EXISTS `auth_user`;

CREATE TABLE `auth_user` (
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

/*Data for the table `auth_user` */

insert  into `auth_user`(`id`,`account`,`password`,`name`,`sex`,`email`,`phone`,`last_ip`,`last_time`,`create_time`,`update_time`) values 
(1,'admin','$2a$04$1OiUa3yEchBXQBJI8JaMyuKZNlwzWvfeQjKAHnwAEQwnacjt6ukqu','admin',0,NULL,NULL,NULL,'2018-08-23 10:36:37','2018-08-23 10:36:37','2018-08-23 10:36:37'),
(3,'aa','$2a$10$DKX3M4JbQJMMAUZ/LidzUeYwmyUJ7eXVMk/aclrRv1cUHJYjEG/rG','name',NULL,'email','123456789',NULL,'2018-12-28 16:38:02','2018-12-28 16:29:06','2018-12-28 16:38:02'),
(5,'aaa0','$2a$10$w2gj07AHutOvFZxpfR/NPe8zvkTHIoVqapNYGgB2q7nDnw8lwWWe6','name',NULL,'email','123456789',NULL,'2018-12-28 16:36:09','2018-12-28 16:36:09','2018-12-28 16:36:09'),
(6,'aaa1','$2a$10$6rf18s505R1LIgz2sNXb4uZvg8eExTStUK3FyL.ymWEK7xQry5UmG','name',NULL,'email','123456789',NULL,'2018-12-28 16:36:30','2018-12-28 16:36:30','2018-12-28 16:36:30'),
(7,'aaa2','$2a$10$pzCi0B.OCZgHjfAhOtOK3OFE7iteGNvnlPVTRxNqIPkirO8trYwx2','name',NULL,'email','123456789',NULL,'2018-12-28 16:36:30','2018-12-28 16:36:30','2018-12-28 16:36:30'),
(8,'aaa3','$2a$10$t6gp7KUtarvAs3ntRYY0zurrJOO3SxgOyRzTEnyghs3ZB9pdV45Lu','name',NULL,'email','123456789',NULL,'2018-12-28 16:36:30','2018-12-28 16:36:30','2018-12-28 16:36:30'),
(9,'aaa4','$2a$10$xPdJehq0mqQTRIYCcfWna.Jtqw8NVK26NNk73tlvcEvLT7J90O/Xy','name',NULL,'email','123456789',NULL,'2018-12-28 16:36:30','2018-12-28 16:36:30','2018-12-28 16:36:30'),
(18,'1801','$2a$10$DKimRahu.Ly/WGFfTy4BDe.eKuJdhWnuvn8aA0i76K/8kDvguVAXa','name',NULL,'email','123456789',NULL,'2018-12-28 18:00:41','2018-12-28 18:00:41','2018-12-28 18:00:41'),
(20,'1803','$2a$10$qAEvkVPN.KySIYQXmlY49u4VpG2rwIkkHZmP81iSNvMPRBcwU2Zw.','name',NULL,'email','123456789',NULL,'2018-12-28 18:00:48','2018-12-28 18:00:48','2018-12-28 18:00:48'),
(21,'1804','$2a$10$IqoGPyuyO6PPT98ZUQU/iep.gFNSEJU9YQ/x8BIihH4ZKsD4Spj.O','name',NULL,'email','123456789',NULL,'2018-12-28 18:00:51','2018-12-28 18:00:51','2018-12-28 18:00:51');

/*Table structure for table `auth_user_role` */

DROP TABLE IF EXISTS `auth_user_role`;

CREATE TABLE `auth_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT 'auth_user的主键',
  `role_id` int(11) NOT NULL COMMENT 'auth_role的主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `auth_user_role` */

/*Table structure for table `dict` */

DROP TABLE IF EXISTS `dict`;

CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(64) NOT NULL COMMENT '字典类型',
  `option_value` varchar(64) NOT NULL COMMENT '选项值',
  `label` varchar(64) NOT NULL COMMENT '选项文本',
  `ex1` varchar(64) DEFAULT NULL COMMENT '扩展字段a',
  `ex2` varchar(64) DEFAULT NULL COMMENT '扩展字段b',
  `remark` varchar(256) DEFAULT NULL COMMENT '选项备注',
  `show_order` int(11) DEFAULT NULL COMMENT '排序',
  `editable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可编辑(含删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_type` (`type`,`option_value`),
  FULLTEXT KEY `sys_dict_option` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COMMENT='选项字典dictionary\r\n（用来存储role+menu+流程状态）';

/*Data for the table `dict` */

insert  into `dict`(`id`,`type`,`option_value`,`label`,`ex1`,`ex2`,`remark`,`show_order`,`editable`) values 
(1,'ac_menu_type','SYSTEM','系统',NULL,NULL,NULL,1,1),
(2,'ac_menu_type','MODULE','模块',NULL,NULL,NULL,2,1),
(3,'ac_menu_type','PAGE','页面',NULL,NULL,NULL,3,1),
(4,'ac_menu_type','BUTTON','按钮',NULL,NULL,NULL,4,1),
(12,'mgr_back_order_status','DRAFT','草稿',NULL,NULL,NULL,1,0),
(13,'mgr_back_order_status','DONE','完成',NULL,NULL,NULL,2,0),
(14,'mgr_back_order_status','INVALID','作废',NULL,NULL,NULL,3,0),
(34,'mgr_check_type','NORMAL','正常',NULL,NULL,NULL,1,1),
(35,'mgr_check_type','LATE','迟到',NULL,NULL,NULL,3,1),
(37,'mgr_check_type','EARLY','早退',NULL,NULL,NULL,4,1),
(38,'mgr_check_type','OUT','外勤',NULL,NULL,NULL,7,1),
(39,'mgr_check_type','REPAIR','补卡',NULL,NULL,NULL,8,1),
(40,'mgr_check_type','LACK','缺卡',NULL,NULL,NULL,2,1),
(48,'mgr_holiday_type','STATUTORY','法定节假日',NULL,NULL,NULL,1,1),
(49,'mgr_holiday_type','PUBLIC','公休',NULL,NULL,NULL,2,1),
(50,'mgr_holiday_type','ACTIVITY','活动',NULL,NULL,NULL,3,1),
(51,'mgr_nature_type','RELAX','休息',NULL,NULL,NULL,1,1),
(52,'mgr_nature_type','CLASS','补班',NULL,NULL,NULL,2,1),
(54,'mgr_leave_type','SICK','病假','','','',1,0),
(55,'mgr_leave_type','BUSY','事假','','','',2,0),
(58,'mgr_shift_type','ONTIME','上班',NULL,NULL,NULL,1,1),
(59,'mgr_shift_type','OFFTIME','下班',NULL,NULL,NULL,2,1),
(62,'mgr_duty_type','CHIEF','正级',NULL,NULL,NULL,1,1),
(63,'mgr_duty_type','DEPUTY','副级',NULL,NULL,NULL,2,1),
(68,'mgr_leave_type','FAMILY','探亲假',NULL,NULL,'',3,0),
(70,'mgr_approver_type','PASS','通过',NULL,NULL,NULL,1,1),
(71,'mgr_approver_type','FAIL','不通过',NULL,NULL,NULL,2,1),
(72,'mgr_fieldwork_time_period','AM','上午',NULL,NULL,NULL,1,1),
(73,'mgr_fieldwork_time_period','PM','下午',NULL,NULL,NULL,2,1),
(74,'mgr_fieldwork_time_period','ALL','全天',NULL,NULL,NULL,3,1),
(78,'mgr_sync_cron','0 30 9,21 * * ? ','每日9点半，21点半',NULL,NULL,NULL,NULL,0),
(79,'mgr_sync_cron1','0 0/1 * * * ?','每分钟',NULL,NULL,NULL,NULL,1),
(82,'mgr_leave_type','MARRY','婚假',NULL,NULL,'',1,1),
(84,'mgr_on_leave_type','MATERNITY','产假',NULL,NULL,NULL,1,0),
(85,'mgr_on_leave_type','ANNUAL','年假',NULL,NULL,NULL,2,0),
(86,'mgr_on_leave_type','OTHER','其他',NULL,NULL,NULL,3,0),
(87,'mgr_fieldwork_type','TRAVEL','出差',NULL,NULL,NULL,1,1),
(88,'mgr_fieldwork_type','OTHER','其他',NULL,NULL,NULL,2,1),
(89,'mgr_order_status','DRAFT','草稿',NULL,NULL,NULL,1,1),
(90,'mgr_order_status','UNAPP','待审批',NULL,NULL,NULL,2,1),
(91,'mgr_order_status','UNREV','待审核',NULL,NULL,NULL,3,1),
(92,'mgr_order_status','FAILED','不通过',NULL,NULL,NULL,4,1),
(93,'mgr_order_status','FINISHED','完成',NULL,NULL,NULL,5,1),
(94,'mgr_leave_order_status','DRAFT','草稿',NULL,NULL,NULL,1,1),
(95,'mgr_leave_order_status','UNAPP','待审批',NULL,NULL,NULL,2,1),
(96,'mgr_leave_order_status','UNREV','待审核',NULL,NULL,NULL,3,1),
(97,'mgr_leave_order_status','FAILED','不通过',NULL,NULL,NULL,4,1),
(98,'mgr_leave_order_status','FINISHED','完成',NULL,NULL,NULL,5,1),
(99,'mgr_check_type','ASKLEAVE','请假',NULL,NULL,NULL,5,1),
(100,'mgr_check_type','ONLEAVE','休假',NULL,NULL,NULL,6,1);

/*Table structure for table `process` */

DROP TABLE IF EXISTS `process`;

CREATE TABLE `process` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '流程名称',
  `type_id` int(11) DEFAULT NULL COMMENT '流程类型（字段选项dict_id）',
  `schedule_id` int(11) DEFAULT NULL COMMENT '流程进度（字段选项dict_id）',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user_id` int(11) DEFAULT NULL COMMENT '更新人',
  `approval_user_id` int(11) DEFAULT NULL COMMENT '审批人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '流程备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程表';

/*Data for the table `process` */

/*Table structure for table `process_log` */

DROP TABLE IF EXISTS `process_log`;

CREATE TABLE `process_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `process_id` int(11) NOT NULL COMMENT '流程ID',
  `update_user_id` int(11) NOT NULL COMMENT '更新人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程生命表（日志表）\r\n用于记录流程的开始到审批结束';

/*Data for the table `process_log` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
