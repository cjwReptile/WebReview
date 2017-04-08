# Host: localhost  (Version 5.7.13-log)
# Date: 2017-04-08 18:17:22
# Generator: MySQL-Front 5.4  (Build 1.23)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "cjw_image"
#

DROP TABLE IF EXISTS `cjw_image`;
CREATE TABLE `cjw_image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(50) NOT NULL DEFAULT '',
  `image_name` varchar(50) DEFAULT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`image_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `cjw_image_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `cjw_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "cjw_image"
#

