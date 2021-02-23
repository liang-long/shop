# Host: localhost  (Version 5.6.35-log)
# Date: 2020-06-10 14:12:22
# Generator: MySQL-Front 6.0  (Build 1.153)


#
# Structure for table "cart"
#

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

#
# Data for table "cart"
#

INSERT INTO `cart` VALUES (9,1,1,1,'2020-04-13'),(10,3,1,1,'2020-04-13'),(16,1,4,1,'2020-04-14'),(17,2,4,1,'2020-04-14'),(18,3,4,1,'2020-04-14'),(22,2,1,1,'2020-04-21'),(23,4,1,1,'2020-04-21');

#
# Structure for table "order"
#

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(300) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

#
# Data for table "order"
#

INSERT INTO `order` VALUES (8,'e8e2e0b36b5d4720947b4cdee5ffdb77',1,1036.5,'2020-03-31 10:03:56',1),(9,'6021d33c9acc47eb91db0b630be277fd',1,1247.5,'2020-03-31 10:06:31',-1),(10,'91057ae2bdd54d0d871175476928471e',1,9876,'2020-04-02 09:20:03',0),(11,'222782eba343411e9decaccfde354e68',1,162.79999,'2020-04-02 09:23:30',0),(12,'492cd38643c24de5950a2b289857192d',1,162.79999,'2020-04-02 09:25:33',0),(13,'37656d6ea5e04d63bff1e8d2fc7c883b',1,100,'2020-04-15 09:20:50',1),(14,'5d1972a2413647c3b341daedbb48947a',1,103,'2020-04-15 10:01:47',1);

#
# Structure for table "order_item"
#

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

#
# Data for table "order_item"
#

INSERT INTO `order_item` VALUES (10,1,5,126,8),(11,6,8,31.8,8),(12,7,9,16.9,8),(13,10,5,89.9,9),(14,15,2,399,9),(15,13,3,2999,10),(16,2,10,87.9,10),(17,1,1,126,11),(18,3,1,14.9,11),(19,8,1,21.9,11),(20,1,1,126,12),(21,3,1,14.9,12),(22,8,1,21.9,12),(23,1,1,NULL,13),(24,3,1,NULL,13),(25,7,1,NULL,13),(26,1,1,NULL,13),(27,3,1,NULL,13),(28,1,1,34.5,14),(29,2,1,12.5,14),(30,3,1,56,14);
