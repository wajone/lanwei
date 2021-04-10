/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.5.68-MariaDB : Database - oa_2021
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oa_2021` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `oa_2021`;

/*Table structure for table `perm` */

DROP TABLE IF EXISTS `perm`;

CREATE TABLE `perm` (
  `perm_id` int(32) NOT NULL COMMENT '权限主键',
  `perm_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '权限url',
  `perm_description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`perm_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `perm` */

insert  into `perm`(`perm_id`,`perm_url`,`perm_description`) values 
(1,'/user/*','拥有对用户的所有操作权限');

/*Table structure for table `proce_cate` */

DROP TABLE IF EXISTS `proce_cate`;

CREATE TABLE `proce_cate` (
  `proce_cate_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `proce_cate_name` varchar(128) DEFAULT NULL,
  `parent_cate_id` bigint(11) DEFAULT '0',
  `proce_cate_desc` varchar(255) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`proce_cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `proce_cate` */

insert  into `proce_cate`(`proce_cate_id`,`proce_cate_name`,`parent_cate_id`,`proce_cate_desc`,`flag`,`create_time`,`update_time`) values 
(1,'工序',0,'生产工序分类',1,'2021-03-28 10:12:00','2021-03-28 10:12:00'),
(2,'下料',1,'下料排料等工序',1,'2021-03-28 10:13:01','2021-03-28 10:13:04'),
(3,'拼缝',1,'普通拼缝,三角针,高架车...',1,'2021-03-28 10:14:22','2021-03-28 10:14:26'),
(4,'高频',1,'高频-盘套',1,'2021-03-28 10:14:24','2021-03-28 10:14:28'),
(5,'套圈',1,'单层套圈,双层套圈',1,'2021-03-28 10:14:30','2021-03-28 10:14:32'),
(6,'包圈',1,'折边包圈',1,'2021-03-28 10:14:34','2021-03-28 10:14:36'),
(7,'验收',1,'验收',1,'2021-03-28 10:14:38','2021-03-28 10:14:40'),
(8,'包装',1,'包装打箱',1,'2021-03-28 10:14:42','2021-03-28 10:14:44');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(32) NOT NULL COMMENT '角色主键',
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`,`role_description`) values 
(1,'超级管理员','超级管理员');

/*Table structure for table `role_perm` */

DROP TABLE IF EXISTS `role_perm`;

CREATE TABLE `role_perm` (
  `role_id` int(32) NOT NULL COMMENT '角色主键',
  `perm_id` int(32) DEFAULT NULL COMMENT '权限主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `role_perm` */

insert  into `role_perm`(`role_id`,`perm_id`) values 
(1,1);

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `dept_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) DEFAULT NULL,
  `dept_parent_id` bigint(11) DEFAULT '1',
  `dept_parent_name` varchar(50) DEFAULT NULL,
  `dept_desc` varchar(128) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`dept_name`,`dept_parent_id`,`dept_parent_name`,`dept_desc`,`flag`,`create_time`,`update_time`) values 
(1,'蓝威',0,'无','公司总部',1,'2021-03-19 16:35:52','2021-04-02 07:34:59'),
(2,'企管部',1,'蓝威','人事行政',1,'2021-03-19 16:43:45','2021-03-19 16:43:45'),
(3,'品技部',1,'蓝威','阿斯顿发',1,'2021-03-19 16:43:52','2021-03-20 11:11:32'),
(4,'生产部',1,'蓝威','',1,'2021-03-19 16:43:59','2021-03-19 16:43:59'),
(5,'销售部',1,'蓝威','',1,'2021-03-19 16:44:09','2021-03-19 16:44:09'),
(6,'财务部',1,'蓝威','',1,'2021-03-19 16:44:24','2021-03-19 16:44:24'),
(7,'财务部',1,'蓝威','财务相关',1,'2021-03-20 11:11:22','2021-03-20 11:11:22'),
(8,'什么部门',1,'蓝威','',1,'2021-03-20 15:19:32','2021-03-23 16:04:30'),
(9,'阿什顿',1,'蓝威','',1,'2021-03-20 15:19:40','2021-03-23 16:08:49'),
(10,'暗示法',1,'蓝威','',0,'2021-03-20 15:19:46','2021-03-23 15:51:33'),
(11,'阿斯顿发',1,'蓝威','',0,'2021-03-20 15:19:51','2021-03-23 15:50:33');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MENU_PARENT_ID` bigint(20) DEFAULT NULL,
  `MENU_NAME` varchar(24) DEFAULT NULL,
  `MENU_TYPE` smallint(6) DEFAULT NULL,
  `MENU_URL` varchar(255) DEFAULT NULL,
  `MENU_DESC` varchar(128) DEFAULT NULL,
  `IS_PUBLIC` tinyint(1) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

/*Table structure for table `sys_org` */

DROP TABLE IF EXISTS `sys_org`;

CREATE TABLE `sys_org` (
  `ORG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORG_PARENT_ID` bigint(20) DEFAULT NULL,
  `ORG_PARENT_NAME` varchar(24) DEFAULT NULL,
  `ORG_NAME` varchar(24) NOT NULL,
  `ORG_DESC` varchar(128) DEFAULT NULL,
  `FLAG` tinyint(1) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ORG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `sys_org` */

insert  into `sys_org`(`ORG_ID`,`ORG_PARENT_ID`,`ORG_PARENT_NAME`,`ORG_NAME`,`ORG_DESC`,`FLAG`,`CREATE_TIME`,`UPDATE_TIME`) values 
(1,-1,'蓝威','总经办','总经办',1,'2021-01-26 13:30:20','2021-01-26 13:30:23'),
(2,-1,'蓝威','企管部','企业管理部门',1,'2021-01-28 09:07:10','2021-01-28 09:07:13'),
(3,-1,'蓝威','营销部','行销部',1,'2021-01-28 09:07:10','2021-01-28 09:07:13'),
(4,-1,'蓝威','品技部','品技',1,'2021-01-28 09:07:10','2021-01-28 09:07:13'),
(18,NULL,'??','????','???',1,NULL,NULL),
(19,NULL,'???','??','??',1,'2021-02-05 13:06:11','2021-02-05 13:06:11'),
(20,NULL,'??','???','?????',0,'2021-02-05 14:13:50','2021-02-05 14:13:50'),
(21,NULL,'asfasfasfsaf','asfdsdfasfd','asfasfsafasfsafsaf',1,'2021-02-06 08:26:50','2021-02-06 08:26:50'),
(22,NULL,'蓝威','科技部','阿斯顿发',1,'2021-02-06 08:27:14','2021-02-06 08:27:14');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(24) DEFAULT NULL,
  `ROLE_DESC` varchar(128) DEFAULT NULL,
  `FLAG` tinyint(1) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORG_ID` bigint(20) DEFAULT NULL,
  `USER_NAME` varchar(12) NOT NULL,
  `USER_PASSWORD` char(64) NOT NULL,
  `PHONE` char(11) DEFAULT NULL,
  `EMAIL` varchar(128) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `SEX` tinyint(1) DEFAULT NULL,
  `IMAGE_URL` varchar(255) DEFAULT NULL,
  `HOBBY` varchar(24) DEFAULT NULL,
  `PROVINCE_ID` int(11) DEFAULT NULL,
  `PROVINCE_NAME` varchar(12) DEFAULT NULL,
  `CITY_ID` int(11) DEFAULT NULL,
  `CITY_NAME` varchar(12) DEFAULT NULL,
  `COUNTRY_ID` int(11) DEFAULT NULL,
  `COUNTRY_NAME` varchar(12) DEFAULT NULL,
  `CREATE_TIEM` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`USER_ID`,`ORG_ID`,`USER_NAME`,`USER_PASSWORD`,`PHONE`,`EMAIL`,`BIRTHDAY`,`SEX`,`IMAGE_URL`,`HOBBY`,`PROVINCE_ID`,`PROVINCE_NAME`,`CITY_ID`,`CITY_NAME`,`COUNTRY_ID`,`COUNTRY_NAME`,`CREATE_TIEM`,`UPDATE_TIME`) values 
(1,NULL,'root','weijiang',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_bom` */

DROP TABLE IF EXISTS `t_bom`;

CREATE TABLE `t_bom` (
  `bom_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `production_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `material_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`bom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_bom` */

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `person_name` varchar(20) DEFAULT NULL,
  `person_tel` varchar(50) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  `customer_desc` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`customer_id`,`customer_name`,`person_name`,`person_tel`,`area`,`email`,`zip_code`,`customer_desc`,`create_time`,`update_time`) values 
(1,'CA','doris','15215823304','American','doris@163.com','317200','美国大客户','2021-04-08 14:45:40',NULL);

/*Table structure for table `t_emp` */

DROP TABLE IF EXISTS `t_emp`;

CREATE TABLE `t_emp` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(100) DEFAULT NULL,
  `emp_name` varchar(50) DEFAULT NULL,
  `emp_birthday` date DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `dept_name` varchar(50) DEFAULT NULL,
  `on_job` tinyint(1) DEFAULT '1',
  `hiredate` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_emp` */

insert  into `t_emp`(`emp_id`,`emp_no`,`emp_name`,`emp_birthday`,`dept_id`,`dept_name`,`on_job`,`hiredate`,`update_time`) values 
(1,'50004','干伟江','2021-04-06',2,'企管部',1,'2021-04-08 12:33:31',NULL);

/*Table structure for table `t_good_cate` */

DROP TABLE IF EXISTS `t_good_cate`;

CREATE TABLE `t_good_cate` (
  `good_cate_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `good_cate_name` varchar(255) DEFAULT NULL,
  `parent_cate_id` bigint(20) DEFAULT NULL,
  `good_cate_desc` varchar(255) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`good_cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_good_cate` */

insert  into `t_good_cate`(`good_cate_id`,`good_cate_name`,`parent_cate_id`,`good_cate_desc`,`flag`,`create_time`,`update_time`) values 
(1,'产品分类',0,'产品分类',1,'2021-03-30 12:42:22','2021-03-30 12:42:24'),
(2,'方向盘套',1,'各类方向盘套',NULL,'2021-03-30 12:51:21','2021-03-30 12:51:21'),
(3,'护肩套',1,'各类护肩套',NULL,'2021-03-30 12:51:41','2021-03-30 12:51:41'),
(4,'椅套',1,'各类椅套',NULL,'2021-03-30 12:51:54','2021-03-30 12:51:54');

/*Table structure for table `t_labor` */

DROP TABLE IF EXISTS `t_labor`;

CREATE TABLE `t_labor` (
  `labor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_id` bigint(20) DEFAULT NULL,
  `emp_name` varchar(50) DEFAULT NULL,
  `production_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `proce_id` bigint(20) DEFAULT NULL,
  `proce_name` varchar(50) DEFAULT NULL,
  `submit_num` bigint(20) DEFAULT NULL,
  `submit_emp_name` varchar(50) DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`labor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_labor` */

/*Table structure for table `t_material` */

DROP TABLE IF EXISTS `t_material`;

CREATE TABLE `t_material` (
  `material_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `material_no` varchar(100) DEFAULT NULL,
  `material_name` varchar(128) DEFAULT NULL,
  `material_cate_id` bigint(11) DEFAULT NULL,
  `material_cate_name` varchar(255) DEFAULT NULL,
  `material_desc` varchar(255) DEFAULT NULL,
  `material_size` char(10) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_material` */

insert  into `t_material`(`material_id`,`material_no`,`material_name`,`material_cate_id`,`material_cate_name`,`material_desc`,`material_size`,`flag`,`create_time`,`update_time`) values 
(1,'365254125544','改革及',6,'纸箱','阿斯顿发',NULL,0,NULL,'2021-04-02 16:43:16');

/*Table structure for table `t_material_cate` */

DROP TABLE IF EXISTS `t_material_cate`;

CREATE TABLE `t_material_cate` (
  `material_cate_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `material_cate_name` varchar(255) DEFAULT NULL,
  `parent_cate_id` bigint(11) DEFAULT NULL,
  `material_cate_desc` varchar(255) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`material_cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_material_cate` */

insert  into `t_material_cate`(`material_cate_id`,`material_cate_name`,`parent_cate_id`,`material_cate_desc`,`flag`,`create_time`,`update_time`) values 
(1,'物料分类',0,'物料分类',1,'2021-03-28 16:51:17','2021-03-28 16:51:19'),
(2,'辅料',1,'辅料',1,'2021-03-29 12:35:23','2021-03-29 12:35:25'),
(3,'原材料',1,'原材料',1,'2021-03-29 12:40:49','2021-03-29 12:40:51'),
(4,'印刷绣花',1,'印刷绣花',1,'2021-03-29 12:40:53','2021-03-29 12:40:55'),
(5,'橡胶圈',1,'橡胶圈',1,'2021-03-29 12:40:57','2021-03-29 12:40:59'),
(6,'纸箱',1,'纸箱',1,'2021-03-29 12:41:01','2021-03-29 12:41:03'),
(7,'包装材料',1,'包装材料',1,'2021-03-29 12:41:06','2021-03-29 12:41:08');

/*Table structure for table `t_procedure` */

DROP TABLE IF EXISTS `t_procedure`;

CREATE TABLE `t_procedure` (
  `proce_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `proce_no` varchar(255) DEFAULT NULL,
  `proce_name` varchar(20) DEFAULT NULL,
  `proce_cate_id` bigint(11) DEFAULT '0',
  `proce_cate_name` varchar(255) DEFAULT NULL,
  `proce_desc` varchar(255) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`proce_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_procedure` */

insert  into `t_procedure`(`proce_id`,`proce_no`,`proce_name`,`proce_cate_id`,`proce_cate_name`,`proce_desc`,`flag`,`create_time`,`update_time`) values 
(1,'GX20210328001','下料-裁高发泡',2,'下料','裁高发泡',1,'2021-03-28 14:50:48','2021-03-28 14:50:48'),
(2,'GX20210328002','下料-切金属条',2,'下料','切金属条',1,'2021-03-28 14:51:15','2021-03-28 14:51:15'),
(3,'GX20210328003','手剪加修边',2,'下料','手剪加修边',1,'2021-03-28 14:51:40','2021-03-28 14:51:40'),
(4,'GX20210328004','普通拼缝',3,'拼缝','普通拼缝',1,'2021-03-28 14:52:17','2021-03-28 14:52:17'),
(5,'GX20210328005','三角针',3,'拼缝','三角针',1,'2021-03-28 14:52:33','2021-03-28 14:52:33'),
(6,'GX20210328006','高架车',3,'拼缝','高架车',1,'2021-03-28 14:52:48','2021-03-28 14:52:48'),
(7,'GX20210328007','剪海绵',3,'拼缝','剪海绵',1,'2021-03-28 14:53:01','2021-03-28 14:53:01'),
(8,'GX20210328008','双针车',3,'拼缝','双针车',1,'2021-03-28 14:53:24','2021-03-28 14:53:24'),
(9,'GX20210328009','频-盘套',4,'高频','频-盘套',1,'2021-03-28 14:53:42','2021-03-28 14:53:42'),
(10,'GX20210328010','高频-BB胶',4,'高频','高频-BB胶',1,'2021-03-28 14:53:55','2021-03-28 14:53:55'),
(11,'GX20210328011','单层套圈',5,'套圈','单层套圈',1,'2021-03-28 14:54:09','2021-03-28 14:54:09'),
(12,'GX20210328012','双层套圈',5,'套圈','双层套圈',1,'2021-03-28 14:54:22','2021-03-28 14:54:22'),
(13,'GX20210328013','折边包圈',6,'包圈','折边包圈',1,'2021-03-28 14:55:05','2021-03-28 14:55:05'),
(14,'GX20210328014','验收',7,'验收','验收',1,'2021-03-28 14:55:28','2021-03-28 14:55:28'),
(15,'GX20210328015','普通包装',8,'包装','普通包装',1,'2021-03-28 14:55:43','2021-03-28 14:55:43'),
(16,'GX20210328016','打箱',8,'包装','打箱',1,'2021-03-28 14:55:59','2021-03-28 14:55:59');

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_no` varchar(50) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `product_size` char(10) DEFAULT NULL,
  `attach_info` varchar(100) DEFAULT NULL,
  `product_cate_id` bigint(20) DEFAULT NULL,
  `product_cate_name` varchar(100) DEFAULT NULL,
  `product_desc` varchar(255) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `UNIQUE` (`product_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_product` */

insert  into `t_product`(`product_id`,`product_no`,`image_url`,`product_name`,`product_size`,`attach_info`,`product_cate_id`,`product_cate_name`,`product_desc`,`flag`,`create_time`,`update_time`) values 
(1,'lwa202103170001e','/upload/lwa202103170001e.jpg','蓝威方向盘套','L','37.5内圈',2,'方向盘套','方向盘套',1,'2021-04-02 11:18:23','2021-04-02 11:18:23'),
(2,'lwa202103170002e','/upload/lwa202103170001e.jpg','蓝威方向盘套2','M',NULL,NULL,NULL,NULL,0,NULL,'2021-04-09 13:57:38'),
(4,'问我','/upload/44504DA4-EDD5-4514-837F-6135DC342265.jpeg','啥事','S','',3,'椅套','',0,'2021-04-08 14:33:33','2021-04-08 14:33:43');

/*Table structure for table `t_product_cate` */

DROP TABLE IF EXISTS `t_product_cate`;

CREATE TABLE `t_product_cate` (
  `product_cate_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `product_cate_name` varchar(100) DEFAULT NULL,
  `parent_cate_id` bigint(11) DEFAULT NULL,
  `product_cate_desc` varchar(255) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_product_cate` */

insert  into `t_product_cate`(`product_cate_id`,`product_cate_name`,`parent_cate_id`,`product_cate_desc`,`flag`,`create_time`,`update_time`) values 
(1,'产品分类',0,'产品分类',1,'2021-04-02 10:13:50','2021-04-02 10:13:51'),
(2,'方向盘套',1,'方向盘套',1,'2021-04-02 10:14:11','2021-04-02 10:14:11'),
(3,'椅套',1,'椅套',1,'2021-04-02 10:15:09','2021-04-02 10:15:09');

/*Table structure for table `t_production` */

DROP TABLE IF EXISTS `t_production`;

CREATE TABLE `t_production` (
  `production_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `production_no` varchar(100) DEFAULT NULL,
  `contact_no` varchar(100) DEFAULT NULL,
  `export_no` varchar(100) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `advance_time` datetime DEFAULT NULL,
  `real_time` datetime DEFAULT NULL,
  `is_completed` tinyint(1) DEFAULT '0',
  `level` int(3) DEFAULT '1',
  `maker` varchar(100) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`production_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_production` */

insert  into `t_production`(`production_id`,`production_no`,`contact_no`,`export_no`,`customer_id`,`order_time`,`advance_time`,`real_time`,`is_completed`,`level`,`maker`,`comment`,`create_time`) values 
(1,'Z2001-25-555T','465456465','31312',1,'2021-04-06 07:39:34','2021-04-06 07:39:36','2021-04-24 07:39:38',0,1,NULL,NULL,NULL);

/*Table structure for table `t_production_detail` */

DROP TABLE IF EXISTS `t_production_detail`;

CREATE TABLE `t_production_detail` (
  `production_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_serial` char(5) DEFAULT NULL,
  `product_num` bigint(20) DEFAULT NULL,
  `product_color` char(6) DEFAULT NULL,
  `production_desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_production_detail` */

insert  into `t_production_detail`(`production_id`,`product_id`,`product_serial`,`product_num`,`product_color`,`production_desc`) values 
(1,1,'3-1',100,'黑色',NULL),
(1,2,'3-2',200,'红色','asdf');

/*Table structure for table `t_progress` */

DROP TABLE IF EXISTS `t_progress`;

CREATE TABLE `t_progress` (
  `production_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `proce_id` bigint(20) DEFAULT NULL,
  `completed_num` bigint(20) DEFAULT NULL,
  `goal_num` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `finishd_time` datetime DEFAULT NULL,
  KEY `production_id` (`production_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_progress` */

insert  into `t_progress`(`production_id`,`product_id`,`proce_id`,`completed_num`,`goal_num`,`create_time`,`finishd_time`) values 
(1,1,1,50,100,NULL,NULL),
(1,1,2,60,100,NULL,NULL),
(1,1,4,70,200,NULL,NULL);

/*Table structure for table `t_purchase` */

DROP TABLE IF EXISTS `t_purchase`;

CREATE TABLE `t_purchase` (
  `purchase_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `material_no` varchar(100) DEFAULT NULL,
  `material_name` varchar(100) DEFAULT NULL,
  `purchase_num` bigint(20) DEFAULT NULL,
  `pruchase_desc` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_purchase` */

/*Table structure for table `t_stock` */

DROP TABLE IF EXISTS `t_stock`;

CREATE TABLE `t_stock` (
  `stock_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `material_no` varchar(100) DEFAULT NULL,
  `material_name` varchar(100) DEFAULT NULL,
  `material_cate_id` bigint(20) DEFAULT NULL,
  `material_cate_name` varchar(255) DEFAULT NULL,
  `stock_num` bigint(20) DEFAULT NULL,
  `unit_id` bigint(20) DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_stock` */

/*Table structure for table `t_unit` */

DROP TABLE IF EXISTS `t_unit`;

CREATE TABLE `t_unit` (
  `unit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(255) DEFAULT NULL,
  `unit_desc` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_unit` */

insert  into `t_unit`(`unit_id`,`unit_name`,`unit_desc`,`create_time`,`update_time`) values 
(1,'个','数量单位','2021-04-09 10:01:01','2021-04-09 10:01:01'),
(2,'只','数量单位','2021-04-09 14:52:50','2021-04-09 14:52:50'),
(3,'米','长度单位','2021-04-09 14:54:55','2021-04-09 14:54:55'),
(4,'匹','布匹单位','2021-04-09 14:55:34','2021-04-09 14:55:34');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(32) NOT NULL COMMENT '用户主键',
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码（存储加密后的密码）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`user_id`,`username`,`password`) values 
(0,'jimmy','weijiang'),
(1,'root','weijiang');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(32) NOT NULL COMMENT '用户主键',
  `role_id` int(32) NOT NULL COMMENT '角色主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values 
(1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
