# Host: localhost  (Version 5.7.13-log)
# Date: 2017-04-08 18:17:48
# Generator: MySQL-Front 5.4  (Build 1.23)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "cjw_user"
#

DROP TABLE IF EXISTS `cjw_user`;
CREATE TABLE `cjw_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `pass_word` varchar(255) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

#
# Data for table "cjw_user"
#

