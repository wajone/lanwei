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

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(32) NOT NULL COMMENT '角色主键',
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `role` */

/*Table structure for table `role_perm` */

DROP TABLE IF EXISTS `role_perm`;

CREATE TABLE `role_perm` (
  `role_id` int(32) NOT NULL COMMENT '角色主键',
  `perm_id` int(32) DEFAULT NULL COMMENT '权限主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `role_perm` */

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

/*Table structure for table `t_bom` */

DROP TABLE IF EXISTS `t_bom`;

CREATE TABLE `t_bom` (
  `bom_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `material_id` bigint(20) DEFAULT NULL,
  `product_unit_id` bigint(20) DEFAULT NULL,
  `material_num` bigint(20) DEFAULT NULL,
  `material_unit_id` bigint(20) DEFAULT NULL,
  `maker` varchar(50) DEFAULT NULL,
  `material_comment` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`customer_id`,`customer_name`,`person_name`,`person_tel`,`area`,`email`,`zip_code`,`customer_desc`,`create_time`,`update_time`) values 
(3,'CA','CA','CA','CA','CA@163.COM','CA','',NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_material` */

insert  into `t_material`(`material_id`,`material_no`,`material_name`,`material_cate_id`,`material_cate_name`,`material_desc`,`material_size`,`flag`,`create_time`,`update_time`) values 
(1,'LWY20210413001A','皮革PU',2,'原材料','','3*5',1,'2021-04-13 11:14:02','2021-04-13 11:14:02');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_material_cate` */

insert  into `t_material_cate`(`material_cate_id`,`material_cate_name`,`parent_cate_id`,`material_cate_desc`,`flag`,`create_time`,`update_time`) values 
(1,'物料分类',0,'',1,'2021-04-13 11:11:00','2021-04-13 11:11:00'),
(2,'原材料',1,'',1,'2021-04-13 11:11:07','2021-04-13 11:11:07'),
(3,'辅料',1,NULL,1,'2021-04-13 11:12:54','2021-04-13 11:12:56'),
(10,'asdf',1,'asdfasd',1,'2021-04-14 08:59:32','2021-04-14 08:59:32');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_product` */

insert  into `t_product`(`product_id`,`product_no`,`image_url`,`product_name`,`product_size`,`attach_info`,`product_cate_id`,`product_cate_name`,`product_desc`,`flag`,`create_time`,`update_time`) values 
(1,'lwa20210412001NBK','/upload/lwa202103170001e.jpg','新款方向盘套','M','内圈37.5',1,'方向盘套','',1,'2021-04-12 12:35:48','2021-04-12 12:35:48'),
(2,'lwa20210317001ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','L','38内圈',1,'方向盘套','',1,'2021-04-12 13:44:01','2021-04-12 13:44:01'),
(3,'lwa20210317002ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','L','38内圈',1,'方向盘套',NULL,1,NULL,NULL),
(4,'lwa20210317003ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','L','38内圈',1,'方向盘套',NULL,1,NULL,NULL),
(5,'lwa20210317004ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','L','38内圈',1,'方向盘套',NULL,1,NULL,NULL),
(6,'lwa20210317005ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','L','38内圈',1,'方向盘套',NULL,1,NULL,NULL),
(7,'lwa20210317006ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','M','38内圈',1,'方向盘套',NULL,1,NULL,NULL),
(8,'lwa20210317007ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','L','38内圈',1,'方向盘套',NULL,1,NULL,NULL),
(9,'lwa20210317009ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','X','38内圈',1,'方向盘套',NULL,1,NULL,NULL),
(10,'lwa20210317010ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','L','38内圈',1,'方向盘套',NULL,1,NULL,NULL),
(11,'lwa20210317011ERD','/upload/lwa202103170001e.jpg','毛绒方向盘','L','38内圈',1,'方向盘套',NULL,1,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_product_cate` */

insert  into `t_product_cate`(`product_cate_id`,`product_cate_name`,`parent_cate_id`,`product_cate_desc`,`flag`,`create_time`,`update_time`) values 
(1,'方向盘套',0,'方向盘套',1,'2021-04-12 12:34:17','2021-04-12 12:34:17');

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
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`production_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_production` */

insert  into `t_production`(`production_id`,`production_no`,`contact_no`,`export_no`,`customer_id`,`order_time`,`advance_time`,`real_time`,`is_completed`,`level`,`maker`,`comment`,`create_time`,`update_time`) values 
(1,'z200201020221',NULL,NULL,NULL,'2021-04-07 13:50:50','2021-04-14 13:50:22','2021-04-30 13:50:24',0,1,'许玉静','测试','2021-04-14 13:50:44','2021-04-14 13:50:54');

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
(1,1,'3-1',200,'红色','工艺描述'),
(1,2,'3-2',100,'红色','工艺描述');

/*Table structure for table `t_progress` */

DROP TABLE IF EXISTS `t_progress`;

CREATE TABLE `t_progress` (
  `production_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `proce_id` bigint(20) DEFAULT NULL,
  `completed_num` bigint(20) DEFAULT NULL,
  `goal_num` bigint(20) DEFAULT NULL,
  `proce_price` float DEFAULT NULL,
  `proce_comment` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `finishd_time` datetime DEFAULT NULL,
  KEY `production_id` (`production_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_progress` */

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_unit` */

insert  into `t_unit`(`unit_id`,`unit_name`,`unit_desc`,`create_time`,`update_time`) values 
(5,'个','数量单位','2021-04-12 12:32:22','2021-04-12 12:32:22'),
(6,'米','长度单位','2021-04-12 12:32:31','2021-04-12 12:32:31'),
(7,'公斤','重量单位','2021-04-12 12:32:42','2021-04-12 12:32:42');

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
(0,'root','weijiang');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(32) NOT NULL COMMENT '用户主键',
  `role_id` int(32) NOT NULL COMMENT '角色主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
