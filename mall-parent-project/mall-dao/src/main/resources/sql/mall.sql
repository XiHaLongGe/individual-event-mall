DROP DATABASE
IF
	EXISTS mall;
CREATE DATABASE mall CHARSET utf8;
USE mall;
DROP TABLE 
IF
	EXISTS customer_login;
CREATE TABLE customer_login (
	customer_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户登录ID',
	login_account VARCHAR ( 20 ) COMMENT '用户登录账号',
	login_name VARCHAR ( 20 ) COMMENT '用户昵称',
	login_password VARCHAR ( 32 ) COMMENT '用户登录密码',
	activate_code VARCHAR(50) COMMENT '账号注册激活码',
	user_stats BIT DEFAULT 0 COMMENT '用户账号状态(0:"未激活",1:"激活")',
	creation_time DATETIME COMMENT '用户账号创建日期' 
) COMMENT '用户登录信息表';
-- 密码默认六个1
INSERT INTO customer_login(login_account, login_name, login_password, activate_code, user_stats, creation_time) VALUES
('18546320231', 'xiha1', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('28546320232', 'xiha2', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('38546320233', 'xiha3', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('48546320234', 'xiha4', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('58546320235', 'xiha5', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('68546320236', 'xiha6', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('78546320237', 'xiha7', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('87546320238', 'xiha8', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('828546320239', 'xiha9', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('98546320230', 'xiha10', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW()),
('108546320211', 'xiha11', '9db06bcff9248837f86d1a6bcf41c9e7', '42fa4af762b843dca0393605a1feba30', 1, NOW())
DROP TABLE
IF
	EXISTS customer_inf;
CREATE TABLE customer_inf (
	customer_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户个人信息ID',
	customer_id INT NOT NULL COMMENT '用户登录ID',
	customer_inf_name VARCHAR ( 20 ) COMMENT '用户姓名',
	customer_inf_gender BIT DEFAULT 0 COMMENT '用户性别(0:"女",1:"男")',
	customer_inf_card VARCHAR ( 20 ) COMMENT '用户身份证号',
	customer_inf_phone VARCHAR ( 20 ) COMMENT '用户手机号',
	customer_inf_email VARCHAR ( 20 ) COMMENT '用户邮箱'
) COMMENT '用户个人信息表';
INSERT INTO customer_inf(customer_id, customer_inf_name, customer_inf_gender, customer_inf_card, customer_inf_phone, customer_inf_email) VALUES
(1, '李一', 1, '362432201804673847', '18128364756', '1612364756@qq.com'),
(2, '李二', 0, '362432201704673847', '18228364756', '1627064756@qq.com'),
(3, '李三', 1, '362432201604673847', '18328364756', '1627964756@qq.com'),
(4, '李四', 0, '362432201504673847', '18428364756', '1627864756@qq.com'),
(5, '李五', 1, '362432201404673847', '18528364756', '1627764756@qq.com'),
(6, '李流', 0, '362432201304673847', '18628364756', '1627664756@qq.com'),
(7, '李期', 1, '362432201204673847', '18728364756', '162754756@qq.com'),
(8, '李把', 0, '362432201104673847', '18828364756', '16274364756@qq.com'),
(9, '李就', 1, '362432201004673847', '18928364756', '1627364756@qq.com'),
(10, '李是', 0, '362432200904673847', '18028364756', '1622364756@qq.com'),
(11, '李十一', 1, '362432200804673847', '13128364756', '1127364756@qq.com')
DROP TABLE
IF
	EXISTS product_category;
CREATE TABLE product_category(
  category_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '分类ID',
  category_name VARCHAR(10) COMMENT '分类名称',
  category_level INT DEFAULT 1 COMMENT '分类层级',
	parent_id INT DEFAULT 0 COMMENT '父分类ID'
)ENGINE = innodb COMMENT '商品分类表';
INSERT INTO product_category(category_name, category_level, parent_id) VALUES
('运动',1,0),
('户外',1,0),
('乐器',1,0),
('家电',1,0),
('数码',1,0),
('手机',1,0),
('美食',1,0),
('生鲜',1,0),
('羽毛球',2,1),
('足球',2,1),
('篮球',2,1),
('背包',2,2),
('登山鞋',2,2),
('钢琴',2,3),
('口琴',2,3),
('尤格里里',2,3),
('电视',2,4),
('冰箱',2,4),
('空调',2,4),
('相机',2,5),
('无人机',2,5),
('笔记本',2,5),
('小米',2,6),
('华为',2,6),
('巧克力',2,7),
('蜂蜜',2,7),
('龙虾',2,8)

DROP TABLE
IF
	EXISTS sidebar_category;
CREATE TABLE sidebar_category(
  sidebar_category_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '分类ID',
  sidebar_category_name VARCHAR(10) COMMENT '分类名称',
	sidebar_category_describe VARCHAR(60) COMMENT '分类描述',
  sidebar_category_level INT DEFAULT 1 COMMENT '分类层级',
	parent_id INT DEFAULT 0 COMMENT '父分类ID'
)ENGINE = innodb COMMENT '侧边栏分类表';
INSERT INTO sidebar_category(sidebar_category_name, sidebar_category_describe, sidebar_category_level, parent_id) VALUES
('热销商品','HOT-SALE',1,0),
('户外出行','OUTDOORS & AUTOMOTIVE',1,0),
('潮电酷玩','ELECTRONICS',1,0),
('居家生活','GROCERY & HEALTH',1,0),
('休闲美食','LEISURE-FOOD',1,0),
('生鲜水果','FRESH & FRUIT',1,0),
('图书影像','LIBRARY & VIDEO',1,0),
('背包','',2,2),
('鞋子','',2,2),
('手机','',2,3),
('电脑','',2,3),
('游戏机','',2,3)

DROP TABLE
IF
	EXISTS brand_inf;
CREATE TABLE brand_inf(
  brand_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '品牌ID',
  brand_name VARCHAR(50) COMMENT '品牌名称',
	category_id INT COMMENT '类型id'
)ENGINE = innodb COMMENT '品牌信息表';
INSERT INTO brand_inf(brand_name, category_id) VALUES
('远行客',2),
('德芙',7),
('HUAWEI',6),
('LENOVO',5)

DROP TABLE
IF
	EXISTS product_inf;
CREATE TABLE product_inf(
	product_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
	brand_id INT COMMENT '品牌ID',
	category_id INT COMMENT '商品类型ID',
	hot_sale BIT DEFAULT 0 COMMENT '是否属于热销商品：(0:"不属于",1:"属于")',
	sidebar_category_id INT DEFAULT 0 COMMENT '侧边分类栏ID',
	product_name VARCHAR(50) COMMENT '商品名称',
	product_describe VARCHAR(50) COMMENT '商品描述',
  product_price DECIMAL(8,2) COMMENT '商品价格',
	product_sales INT COMMENT '商品销量',
	product_status BIT DEFAULT 0 COMMENT '上下架状态：(0:"下架",1:"上架")'
)ENGINE = innodb COMMENT '商品信息表';
INSERT INTO product_inf(brand_id, category_id, sidebar_category_id, hot_sale, product_name, product_describe, product_price, product_sales, product_status) VALUES
(1,12,8,0,'远行客登山包双肩男户外背包40L50L徒步旅行包60升','',268.00,1,1),
(1,13,9,0,'Topsky户外高帮登山鞋男鞋运动徒步爬山鞋防泼水登山靴旅游骑行鞋','玩转户外 攀山涉水 防水袜套 护踝高帮设计',159.00,2,1),
(2,25,0,1,'德芙礼盒装丝滑牛奶纯黑白夹心巧克力3碗排块送女友小零食喜糖果','热销600万碗 多种组合可选 纵享丝滑',89.97,3,1),
(3,24,10,1,'Huawei/华为P30 Pro手机官方旗舰店曲面屏麒麟980智能商务手机mate20x5g正版','直降500 再享优惠200元 6期免息 延保2年',4899.00,4,1),
(4,22,11,1,'联想ThinkBook 14/15 .6英寸十代酷睿i5/i7独显轻薄便携','金属机身 轻薄高颜值 读秒开机',4699,5,1)
DROP TABLE
IF
	EXISTS picture_type;
CREATE TABLE picture_type(
	picture_type_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '图片类型ID',
	picture_type_name VARCHAR(20) COMMENT '图片类型名称'
)ENGINE=innodb COMMENT '图片类型表';
INSERT INTO picture_type(picture_type_name) VALUES
('轮播图'),
('公告图'),
('热销图'),
('海报图'),
('主图'),
('款式图')


DROP TABLE
IF
	EXISTS picture_inf;
CREATE TABLE picture_inf(
	picture_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '图片ID',
	product_id INT COMMENT '商品ID',
	picture_type_id INT COMMENT '图片类型ID',
	picture_inf_url VARCHAR(200) COMMENT '图片路径',
  picture_inf_order INT DEFAULT 0 COMMENT '图片排序',
  picture_inf_status BIT DEFAULT 0 COMMENT '图片是否展示：(0:"不展示",1:"展示")'
)ENGINE=innodb COMMENT '图片信息表';
INSERT INTO picture_inf(product_id, picture_type_id, picture_inf_url, picture_inf_order, picture_inf_status) VALUES
(1,1,'/static/home/images/登山包.jpg',0,1),
(1,3,'/static/home/images/登山包.jpg',0,1),
(1,4,'/static/home/images/登山包.jpg',0,1),
(1,5,'/static/home/images/登山包.jpg',1,1),
(1,5,'/static/home/images/登山包.jpg',2,1),
(1,5,'/static/home/images/登山包.jpg',3,1),
(1,5,'/static/home/images/登山包.jpg',4,1),
(1,5,'/static/home/images/登山包.jpg',5,1),
(1,6,'/static/home/images/登山包.jpg',1,1),
(1,6,'/static/home/images/登山包.jpg',2,1),
(2,1,'/static/home/images/登山鞋.jpg',0,1),
(2,3,'/static/home/images/登山鞋.jpg',0,1),
(2,4,'/static/home/images/登山鞋.jpg',0,1),
(2,5,'/static/home/images/登山鞋.jpg',1,1),
(2,5,'/static/home/images/登山鞋.jpg',2,1),
(2,5,'/static/home/images/登山鞋.jpg',3,1),
(2,5,'/static/home/images/登山鞋.jpg',4,1),
(2,5,'/static/home/images/登山鞋.jpg',5,1),
(2,6,'/static/home/images/登山鞋.jpg',1,1),
(2,6,'/static/home/images/登山鞋.jpg',2,1),
(3,1,'/static/home/images/德芙巧克力.jpg',0,1),
(3,2,'/static/home/images/德芙巧克力.jpg',0,1),
(3,3,'/static/home/images/德芙巧克力.jpg',0,1),
(3,4,'/static/home/images/德芙巧克力.jpg',0,1),
(3,5,'/static/home/images/德芙巧克力.jpg',1,1),
(3,5,'/static/home/images/德芙巧克力.jpg',2,1),
(3,5,'/static/home/images/德芙巧克力.jpg',3,1),
(3,5,'/static/home/images/德芙巧克力.jpg',4,1),
(3,5,'/static/home/images/德芙巧克力.jpg',5,1),
(3,6,'/static/home/images/德芙巧克力.jpg',1,1),
(3,6,'/static/home/images/德芙巧克力.jpg',2,1),
(4,1,'/static/home/images/HUAWEI_P30_Pro.jpg',0,1),
(4,3,'/static/home/images/HUAWEI_P30_Pro.jpg',0,1),
(4,4,'/static/home/images/HUAWEI_P30_Pro.jpg',0,1),
(4,5,'/static/home/images/HUAWEI_P30_Pro.jpg',1,1),
(4,5,'/static/home/images/HUAWEI_P30_Pro.jpg',2,1),
(4,5,'/static/home/images/HUAWEI_P30_Pro.jpg',3,1),
(4,5,'/static/home/images/HUAWEI_P30_Pro.jpg',4,1),
(4,5,'/static/home/images/HUAWEI_P30_Pro.jpg',5,1),
(4,6,'/static/home/images/HUAWEI_P30_Pro.jpg',1,1),
(4,6,'/static/home/images/HUAWEI_P30_Pro.jpg',2,1),
(5,1,'/static/home/images/ThinkBook.jpg',0,1),
(5,3,'/static/home/images/ThinkBook.jpg',0,1),
(5,4,'/static/home/images/ThinkBook.jpg',0,1),
(5,5,'/static/home/images/ThinkBook.jpg',1,1),
(5,5,'/static/home/images/ThinkBook.jpg',2,1),
(5,5,'/static/home/images/ThinkBook.jpg',3,1),
(5,5,'/static/home/images/ThinkBook.jpg',4,1),
(5,5,'/static/home/images/ThinkBook.jpg',5,1),
(5,6,'/static/home/images/ThinkBook.jpg',1,1),
(5,6,'/static/home/images/ThinkBook.jpg',2,1)


DROP TABLE
IF
	EXISTS product_cart;
CREATE TABLE product_cart(
	product_cart_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '购物车ID',
  customer_inf_id INT COMMENT '用户ID',
	product_id INT COMMENT '商品ID',
	product_cart_num INT COMMENT '商品数量',
	add_time DATETIME COMMENT '加入购物车时间'
)ENGINE=innodb COMMENT '购物车表';
INSERT INTO product_cart(customer_inf_id, product_id, product_cart_num, add_time) VALUES
(1,1,1,NOW()),
(1,2,1,NOW()),
(1,3,1,NOW()),
(2,2,2,NOW()),
(3,3,3,NOW()),
(4,4,4,NOW()),
(5,5,5,NOW())




DROP TABLE
IF
	EXISTS label_inf;
CREATE TABLE label_inf(
	label_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '收货标签id',
  customer_inf_id INT COMMENT '用户ID',
	label_inf_name VARCHAR(6) COMMENT '收货标签名称'
)ENGINE=innodb COMMENT '收货标签表';

INSERT INTO label_inf
									(customer_inf_id, 
									label_inf_name)
VALUES
			(1, '我家'),
			(1, '我弟弟家');

DROP TABLE
IF
	EXISTS receiving_inf;
CREATE TABLE receiving_inf(
	receiving_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '收获信息ID',
  customer_inf_id INT COMMENT '用户ID',
  receiving_inf_name VARCHAR(10) COMMENT '收货人姓名',
  receiving_inf_phone VARCHAR(11) COMMENT '收货人手机号',
	receiving_inf_province VARCHAR(10) COMMENT '收货人省份/自治区',
	receiving_inf_city VARCHAR(10) COMMENT '收货人城市/地区/自治州',
	receiving_inf_district VARCHAR(10) COMMENT '收货人区/县',
	receiving_inf_address VARCHAR(100) COMMENT '收货人详细地址',
	postal_code VARCHAR(6) COMMENT '收货人邮政编码'
)ENGINE=innodb COMMENT '收货信息表';
INSERT INTO receiving_inf
									(customer_inf_id, 
									receiving_inf_name, 
									receiving_inf_phone,
									receiving_inf_province,
									receiving_inf_city,
									receiving_inf_district,
									receiving_inf_address,
									postal_code)
VALUES
			(1, '李一', '18128364756', '江西', '吉安市', '井冈山市', '鹅岭乡白石街88号', '343600'),
			(1, '李一弟弟', '18493857463', '江西', '吉安市', '井冈山市', '鹅岭乡白石街89号', '343600')

DROP TABLE
IF
	EXISTS label_receiving_relevance;
CREATE TABLE label_receiving_relevance(
	relevance_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '关联ID',
	receiving_inf_id INT COMMENT '收货信息ID',
	label_inf_id INT COMMENT '收货标签id'
)ENGINE=innodb COMMENT '收货信息收获标签关联表';

INSERT INTO label_receiving_relevance
									(label_inf_id, 
									receiving_inf_id)
VALUES
			(1, 1),
			(2, 2);


DROP TABLE
IF
	EXISTS product_order;
CREATE TABLE product_order(
	product_order_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
  customer_inf_id INT COMMENT '用户ID',
	receiving_inf_id INT COMMENT '收获信息ID',
  product_id INT COMMENT '商品ID',
	product_cart_num INT COMMENT '商品数量',
	payment INT DEFAULT 0 COMMENT '支付方式：0未支付，1支付宝，2微信，3现金',
	submit_time DATETIME COMMENT '提交订单时间',
	payment_time DATETIME COMMENT '付款时间',
	product_order_state INT DEFAULT 1 COMMENT '订单状态：1待付款，2待收货，3已收货',
	product_order_number VARCHAR(18) COMMENT '订单编号'
)ENGINE=innodb COMMENT '商品订单表';

INSERT INTO product_order
									(customer_inf_id, 
									receiving_inf_id, 
									product_id,
									product_cart_num,
									payment,
									submit_time,
									payment_time,
									product_order_state,
									product_order_number)
VALUES
			(1, 1, 1, 1, 0, '2019-12-19 08:40:40', null, 1, '283948566858674324')
								






DROP TABLE
IF
	EXISTS affiche_type;
CREATE TABLE affiche_type(
	affiche_type_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '公告类型ID',
  affiche_type_name VARCHAR(4) COMMENT '公告类型名称'
)ENGINE=innodb COMMENT '公告类型表';
INSERT INTO affiche_type(affiche_type_name) VALUES
('优选'),
('最新'),
('热评'),
('HOT')
DROP TABLE
IF
	EXISTS affiche_inf;
CREATE TABLE affiche_inf(
	affiche_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '公告ID',
  affiche_type_id INT COMMENT '公告类型ID',
	affiche_state BIT DEFAULT 0 COMMENT '公告状态(0:"未推送",1:"推送")',
	affiche_inf_title VARCHAR(50) COMMENT '公告标题',
	affiche_inf_content TEXT COMMENT '公告内容',
	affiche_time DATETIME COMMENT '公告发布时间'
)ENGINE=innodb COMMENT '公告信息表';
INSERT INTO affiche_inf(affiche_type_id, affiche_state, affiche_inf_title, affiche_inf_content, affiche_time) VALUES
(1,1,'第一条公告标题','第一条公告内容',NOW()),
(2,1,'第二条公告标题','第二条公告内容',NOW()),
(3,1,'第三条公告标题','第三条公告内容',NOW()),
(4,1,'第四条公告标题','第四条公告内容',NOW()),
(1,1,'第五条公告标题','第五条公告内容',NOW()),
(2,1,'第六条公告标题','第六条公告内容',NOW()),
(3,1,'第七条公告标题','第七条公告内容',NOW())



