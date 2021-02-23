# Host: localhost  (Version 5.6.35-log)
# Date: 2020-06-10 14:12:31
# Generator: MySQL-Front 6.0  (Build 1.153)


#
# Structure for table "customer"
#

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "customer"
#

INSERT INTO `customer` VALUES (1,'张三','zhangsan','123456','13112345678','北京',1,'2020-03-25 10:30:26'),(2,'侯一','zhangsanfeng','1234567','13112345678','fd',1,'2020-03-25 11:18:41'),(3,'奇才','zhangsansi','123456','13112345678','胜多负少',1,'2020-03-26 08:47:05'),(4,'侯四','zhang','123','131123','sd',1,'2020-04-08 23:24:56'),(5,'张四','zhangsi','12345678','13112345679','北京海淀',1,'2020-06-01 14:52:43'),(7,'三丰','sanfeng','12345678','13112345690','北京大兴',1,'2020-06-02 15:25:21');
