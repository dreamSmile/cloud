/*
 Navicat Premium Data Transfer

 Source Server         : localMysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : cloud_pay

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 22/03/2020 21:30:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shop_payment
-- ----------------------------
DROP TABLE IF EXISTS `shop_payment`;
CREATE TABLE `shop_payment`  (
  `payment_id` bigint(20) NOT NULL COMMENT 'ID',
  `serial_num` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流水号',
  `order_id` bigint(20) NOT NULL COMMENT '订单号',
  `paid_flag` int(2) NOT NULL COMMENT '1支付成功 0支付失败',
  `pay_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  PRIMARY KEY (`payment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付订单记录表，记录支付历史' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
