/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : cloud

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 23/03/2020 17:29:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shop_coupon
-- ----------------------------
DROP TABLE IF EXISTS `shop_coupon`;
CREATE TABLE `shop_coupon`  (
  `coupon_id` bigint(0) NOT NULL,
  `coupon_price` decimal(10, 2) NOT NULL,
  `user_id` bigint(0) NOT NULL,
  `used_flag` int(0) NOT NULL COMMENT '1 已使用 0未使用',
  `used_time` datetime(0) NULL DEFAULT NULL COMMENT '使用时间',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`coupon_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_coupon
-- ----------------------------
INSERT INTO `shop_coupon` VALUES (439062253434703872, 1.50, 439044593238020096, 0, NULL, '2020-03-22 11:17:44');

-- ----------------------------
-- Table structure for shop_order
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order`  (
  `order_id` bigint(0) NOT NULL,
  `user_id` bigint(0) NOT NULL,
  `order_status` int(0) NOT NULL COMMENT '订单状态0已确认1已取消2已关闭',
  `pay_status` int(0) NOT NULL COMMENT '支付状态0未支付1已支付2退款中3已退款',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `consignee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人',
  `product_id` bigint(0) NOT NULL,
  `product_number` int(0) NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_amount` decimal(10, 2) NOT NULL COMMENT '商品总价',
  `order_amount` decimal(10, 2) NOT NULL COMMENT '订单价格（商品总价+运费）',
  `pay_mount` decimal(10, 2) NOT NULL COMMENT '支付金额（订单价格-优惠券）',
  `add_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `pay_time` timestamp(0) NULL DEFAULT NULL COMMENT '支付时间',
  `coupon_id` bigint(0) NULL DEFAULT NULL COMMENT '优惠券id',
  `coupon_paid` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠券金额',
  `shipping_fee` decimal(10, 2) NOT NULL COMMENT '运费',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_payment
-- ----------------------------
DROP TABLE IF EXISTS `shop_payment`;
CREATE TABLE `shop_payment`  (
  `payment_id` bigint(0) NOT NULL COMMENT 'ID',
  `serial_num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流水号',
  `order_id` bigint(0) NOT NULL COMMENT '订单号',
  `paid_flag` int(0) NOT NULL COMMENT '1支付成功 0支付失败',
  `pay_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  PRIMARY KEY (`payment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付订单记录表，记录支付历史' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_product
-- ----------------------------
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE `shop_product`  (
  `product_id` bigint(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_number` int(0) NOT NULL COMMENT '商品库存',
  `product_price` decimal(10, 2) NOT NULL COMMENT '单价',
  `product_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品描述',
  `add_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_product
-- ----------------------------
INSERT INTO `shop_product` VALUES (439057955120353280, '足球', 10, 90.00, '足球', '2020-03-22 11:00:39');

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user`  (
  `user_id` bigint(0) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_score` int(0) NOT NULL COMMENT '积分',
  `user_reg_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES (439044593238020096, 'user001', '000000', '15027766011', 0, '2020-03-22 10:07:34');
INSERT INTO `shop_user` VALUES (439057692196212736, 'user002', '000000', '15027766011', 0, '2020-03-22 10:59:37');

SET FOREIGN_KEY_CHECKS = 1;
