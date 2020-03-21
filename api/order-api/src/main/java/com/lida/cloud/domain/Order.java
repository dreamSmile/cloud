package com.lida.cloud.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author: 杜利达
 * @date: 2020/3/22 0:04
 */
@Data
public class Order {
    private Long orderId;

    private Long userId;

    /**
     * 订单状态0已确认1已取消2已关闭
     */
    private Integer orderStatus;

    /**
     * 支付状态0未支付1已支付2退款中3已退款
     */
    private Integer payStatus;

    private String address;

    /**
     * 收货人
     */
    private String consignee;

    private Long productId;

    private Integer productNumber;

    private BigDecimal productPrice;

    /**
     * 商品总价
     */
    private BigDecimal productAmount;

    /**
     * 订单价格（商品总价+运费）
     */
    private BigDecimal orderAmount;

    /**
     * 支付金额（订单价格-优惠券）
     */
    private BigDecimal payMount;

    /**
     * 创建时间
     */
    private LocalDateTime addTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 优惠券金额
     */
    private BigDecimal couponPaid;

    /**
     * 运费
     */
    private BigDecimal shippingFee;
}