/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.36 : Database - wurenzu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wurenzu` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `wurenzu`;

/*Table structure for table `award` */

DROP TABLE IF EXISTS `award`;

CREATE TABLE `award` (
  `aid` int(20) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) DEFAULT NULL,
  `price` int(32) DEFAULT NULL,
  `workid` int(20) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `award` */

insert  into `award`(`aid`,`aname`,`price`,`workid`) values (1,'白玉兰奖',5000,NULL),(2,'鲁班奖',3000,NULL),(3,'上海市优秀奖',1500,NULL);

/*Table structure for table `expertscore_manager` */

DROP TABLE IF EXISTS `expertscore_manager`;

CREATE TABLE `expertscore_manager` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `expertscore` int(20) DEFAULT NULL COMMENT '单个评委给单个作品的评分',
  `managerid` int(20) DEFAULT NULL COMMENT '评委的id',
  `workid` int(20) DEFAULT NULL COMMENT '作品的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

/*Data for the table `expertscore_manager` */

insert  into `expertscore_manager`(`id`,`expertscore`,`managerid`,`workid`) values (98,80,141,55),(99,80,141,56),(100,90,141,57),(101,80,142,55),(102,80,142,56),(103,90,142,57);

/*Table structure for table `firmuser` */

DROP TABLE IF EXISTS `firmuser`;

CREATE TABLE `firmuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '公司商标',
  `regtime` datetime DEFAULT NULL COMMENT '公司注册时间',
  `salt` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `firmName` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '公司名',
  `firmDetail` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '公司简介',
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT 'varchar',
  `represent` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '法人代表',
  `address` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `firmuser` */

insert  into `firmuser`(`id`,`name`,`password`,`image`,`regtime`,`salt`,`firmName`,`firmDetail`,`email`,`phone`,`represent`,`address`) values (72,'lily','6D844056EB6D464DBFA9D89E41CFFBA5','/firmuser/e2355344-ffc5-42ed-a2bf-ce87b75a5c47ThuJul04155251CST201972.jpg',NULL,'81ba391b','coco','coco','123456789@qq.com','1234567899','lily','天津'),(73,'lilu','3AF72306A986B498B9C35008BB4CCAD9','/firmuser/ca5063d5-0234-4e4c-a2f3-87d676b528fbThuJul04163230CST201973.jpg',NULL,'fcd23a9a','COCO2','COCO2','123456789@qq.com','1234567','LILU','天津'),(74,'nacy','098B0598371E310AA05B713E8F62743B','/firmuser/46509f73-2448-4d7b-82a3-bf1fb2109599ThuJul04163350CST201974.jpg',NULL,'e00ea9df','COCO3','COCO3','123456789@qq.com','1234567899','NACY','天津'),(75,'lilu11','8C3BDA5B5D8615C6BB2EC05C18FC9FF7',NULL,NULL,'52b2126c',NULL,NULL,NULL,'varchar',NULL,NULL);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `signature` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `regtime` datetime DEFAULT NULL,
  `salt` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `roleid` int(20) DEFAULT NULL,
  `details` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `manager` */

insert  into `manager`(`id`,`name`,`password`,`nick_name`,`sex`,`signature`,`image`,`regtime`,`salt`,`roleid`,`details`,`phone`,`email`) values (1,'admin','FBA2C9DD3B1DD37C19342A7E9E8CC79F','admin4','女','哈哈4','/expert/architect1.png','2017-09-01 16:35:32','51777121',1,NULL,'1234567','1234567897695@qq.com'),(141,'aa','DBDB9CA2DA19EBACFF095997AC89901D',NULL,'男',NULL,'/expert/19ac37eb-68dc-417b-99df-11a25e4b2a28ThuJul04160315CST2019aa.png',NULL,'d0ead60f',2,'评委1号12233','123456789','12345688');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menuid` int(20) NOT NULL AUTO_INCREMENT,
  `pid` int(20) NOT NULL,
  `menuname` varchar(30) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`menuid`,`pid`,`menuname`,`url`) values (1,0,'个人管理','#'),(2,1,'查看信息','/myselfinfo.html'),(3,1,'修改信息','/updateselfinfo.html'),(4,0,'比赛管理','#'),(5,4,'发布比赛','/ releaseRace.html'),(6,4,'修改比赛','/updateRace.html'),(7,0,'评委管理','#'),(8,7,'添加评委','/addExport.html'),(9,7,'修改评委','/update_Export.html'),(10,0,'评分管理','#'),(11,10,'作品评分','/giveScore.html'),(12,10,'查看评分','/viewScore.html'),(13,0,'最终排名','#'),(15,13,'查看排名','/viewRank.html'),(16,0,'奖品管理','#'),(17,16,'发布奖品','/ReleaseAward.html'),(18,16,'获奖作品','/viewAward.html'),(19,1,'修改密码','/updatePassword.html'),(20,7,'查看评委信息','/viewExport.html'),(21,7,'删除评委','/deleteExport.html'),(22,4,'查看比赛信息','/viewRace.html'),(23,4,'停止比赛','/stopRace.html'),(25,0,'图表分析','#'),(26,25,'参赛者分析','/count.html');

/*Table structure for table `raceinfo` */

DROP TABLE IF EXISTS `raceinfo`;

CREATE TABLE `raceinfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `raceName` varchar(20) DEFAULT NULL,
  `details` varchar(20) DEFAULT NULL,
  `period` int(20) DEFAULT NULL,
  `status` int(20) DEFAULT NULL COMMENT '表示比赛状态,0表示已结束，1表示正在进行',
  `imgUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*Data for the table `raceinfo` */

insert  into `raceinfo`(`id`,`raceName`,`details`,`period`,`status`,`imgUrl`) values (68,'第一期','第一期比赛1',1,0,'/race/12ef4b97-08f9-44b0-9644-1683a957e3f5ThuJul04162235CST2019第一期.jpg'),(69,'第二期','第二期比赛aaaa',2,0,'/race/a5615945-a20a-480a-9e1c-1ecae1594c9cThuJul04174030CST2019第二期.jpg');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleid` int(20) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleid`,`rolename`) values (1,'管理员'),(2,'评委');

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `roleid` int(20) DEFAULT NULL,
  `menuid` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `role_menu` */

insert  into `role_menu`(`id`,`roleid`,`menuid`) values (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,2,10),(11,2,11),(13,1,13),(14,1,14),(15,1,15),(16,1,16),(17,1,17),(18,1,18),(19,2,1),(20,2,2),(21,2,3),(22,1,19),(23,2,19),(24,1,20),(25,1,21),(26,1,22),(27,1,23),(28,1,25),(29,1,26);

/*Table structure for table `work` */

DROP TABLE IF EXISTS `work`;

CREATE TABLE `work` (
  `workid` int(20) NOT NULL AUTO_INCREMENT,
  `workname` varchar(20) DEFAULT NULL,
  `imgUrl` varchar(100) DEFAULT NULL COMMENT '图片地址',
  `grade` varchar(20) DEFAULT NULL,
  `firmUserid` int(20) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `period` int(20) DEFAULT NULL COMMENT '第几期',
  `status` int(20) DEFAULT NULL COMMENT '表示作品的状态,0表示删除或下架，1表示正常',
  `aid` int(20) DEFAULT NULL,
  PRIMARY KEY (`workid`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Data for the table `work` */

insert  into `work`(`workid`,`workname`,`imgUrl`,`grade`,`firmUserid`,`details`,`period`,`status`,`aid`) values (55,'work1','/work/e7321526-f343-45d5-8394-c4ee5c603b4aThuJul04163636CST201974.jpg','80',74,'work1',1,0,NULL),(56,'work2','/work/49824be6-8da8-4316-ba24-6034bd8cfc3fThuJul04164446CST201972.jpg','80',72,'work2',1,0,NULL),(58,'work4','/work/bfe3b0ff-aa08-41a5-b0c8-4677bfe26cc4ThuJul04172826CST201973.jpg',NULL,73,'work4',1,0,NULL),(59,'work5','/work/1e5e518a-3b11-4a29-add9-24f3f2cb5c3eThuJul04175021CST201972.jpg',NULL,72,'work5',2,0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
