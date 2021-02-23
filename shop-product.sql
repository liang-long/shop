# Host: localhost  (Version 5.6.35-log)
# Date: 2020-06-10 14:12:12
# Generator: MySQL-Front 6.0  (Build 1.153)


#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "category"
#

INSERT INTO `category` VALUES (1,'食品饮料',1),(2,'服装鞋帽',1),(3,'手机数码',1),(4,'家用电器',1),(5,'运动健身',1);

#
# Structure for table "product"
#

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` double DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

#
# Data for table "product"
#

INSERT INTO `product` VALUES (1,'坚果大礼包',126,'三只松鼠坚果大礼包9袋 网红零食每日坚果干果礼盒碧根果节日送礼团购火红A版1720g（新老包装混发） ','img-01.jpg',1),(2,'蒙牛纯甄',87.9,'蒙牛纯甄 常温风味酸牛奶 200g*24 礼盒装（新老包装随机发货）','img-02.jpg',1),(3,'美式薯条',14.9,'三只松鼠休闲零食膨化小吃薯条原味小贱美式薯条75g/袋 ','img-03.jpg',1),(4,'脆脆鲨',29.7,'雀巢(Nestle) 脆脆鲨 休闲零食 威化饼干 巧克力口味640g','img-04.jpg',1),(5,'港荣蒸蛋糕',39.9,'奶香味900g整箱装 饼干蛋糕 手撕面包口袋吐司 营养早餐食品 休闲零食小吃 ','img-05.jpg',1),(6,'好丽友',31.8,'好丽友 营养早餐点心零食 礼盒 巧克力派 30枚 1020g/盒（新老包装随机发货） ','img-06.jpg',1),(7,'蔓越莓曲奇',16.9,'三只松鼠蔓越莓曲奇 饼干蛋糕网红儿童零食早餐食品点心薄脆饼干100g/袋','img-07.jpg',1),(8,'酥脆薄饼',21.9,'良品铺子酥脆薄饼海苔味早餐饼干薯片儿童零食休闲零食网红食品小吃小零食300g ','img-08.jpg',1),(9,'纯牛奶',58,'君乐宝（JUNLEBAO）遇见奶牛纯牛奶250ml*24整箱装','img-09.jpg',1),(10,'特浓速溶咖啡',89.9,'麦斯威尔 特浓速溶咖啡优惠超值装90送10条（1.3KG/盒）（新老包装交替发货） ','img-10.jpg',1),(11,'无人机',19999,'DJI 大疆 无人机 悟Inspire 2 四轴专业超清航拍无人机 可变形航拍飞行器 ','img-11.jpg',3),(12,'单反相机',8299,'佳能（Canon）EOS 80D 单反相机 单反套机（EF-S 18-200mm f/3.5-5.6 IS 单反镜头）','img-12.jpg',3),(13,'智能手表',2999,'Apple Watch Series 5智能手表（GPS款 40毫米深空灰色铝金属表壳 黑色运动型表带 MWV82CH/A) ','img-01.jpg',3),(14,'运动智能手表',1488,'HUAWEI WATCH GT2（46mm）曜石黑 华为手表 运动智能手表（两周续航+高清彩屏+蓝牙通话+麒麟芯片+心脏健康） ','img-02.jpg',3),(15,'收音机',399,'猫王收音机 MW-2小王子胡桃木 创意复古便携无线蓝牙音箱可爱无线迷你小音响家用户外原木质收音机','img-03.jpg',3),(16,'游戏手柄',249,'HORI PS4/PS3 FPS PLUS游戏手柄 PS4-025 索尼playstation授权 ','img-04.jpg',3),(17,'五香牛肉干',49,'lifefun/立丰 中华老字号 休闲零食 精品五香牛肉干130g风干牛肉粒 ','img-05.jpg',1),(18,'坚果代餐棒',158,'bekind缤善黑巧可可海盐巴旦木坚果能量棒每日坚果代餐棒网红零食40g*12条 ','img-06.jpg',1),(19,'芝麻夹心海苔',30,'优选鲜峰芝麻夹心海苔罐装即食儿童零食小吃芝麻海苔片孕妇食品即食儿童头水海苔夹心脆休闲食品网红零食 芝麻味40g*2罐 80g ','img-07.jpg',1),(20,'独头黑蒜',39,'买2发3】九秋居 黑蒜 独头黑蒜 山东特产黑蒜头 精品米黑大蒜新鲜去皮发酵 实惠装打开即食 250g ','img-08.jpg',1),(21,'辣条大礼包',13.8,' 小马哥 网红辣条大礼包童年辣片零食送女友 香辣4口味组合（500g）拍2件发8袋，第2件仅9.8元，4种口味一次过瘾','img-09.jpg',1),(22,'掌心脆干脆面',24.8,'派力特 掌心脆干脆面 混合口味50包1050g整箱装 方便食品 办公室休闲零食小吃 ','img-10.jpg',1),(23,'烤面筋',17.8,'良品铺子 面筋卷烧烤味烤面筋网红辣条味小零食儿时怀旧小吃120g ','img-11.jpg',1),(24,'薯片 ',19.9,'Orion 好丽友 休闲零食 薯片 非油炸 薯愿三连罐312g/组（104g*3薯片）（新老包装随机发货） ','img-12.jpg',1),(25,'牛仔裤',158,'吉普（JEEP）牛仔裤男宽松新品春季男士直筒中腰休闲男裤子 JS0004蓝色（厚款） ','img-01.jpg',2),(26,'夹克',119,'罗蒙 夹克男 2020春夏季新款商务休闲夹克棒球领短款外套男 藏青（常规款） 175/L ','img-02.jpg',2),(27,'电饭煲',899,'松下（Panasonic）2.1L（对应日标0.7L）迷你IH电磁加热电饭煲 电饭锅 1-4人 家用多功能智能预约 SR-AC071-K','img-03.jpg',4),(28,'电热水器',1549,'美的（Midea）80升速热增容 健康抑菌 一级节能 遥控预约 防电墙电热水器 F8030-A6（HEY） ','img-04.jpg',4),(29,'登山包',1199,'多特( Deuter ) Aircontact Lite蓝精灵户外登山包徒步包越野大容量背囊背包50+10升 3340318/7403','img-05.jpg',5),(30,'麻将牌',158,'统步麻将牌 42mm麻将牌 手搓麻将牌一级正品高档家用麻将牌大号蓝色','img-06.jpg',5);
