package com.lida.cloud.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: 杜利达
 * @date: 2020/3/15 21:01
 * 不使用分布式事务，每一步错误都需要记录
 * 用于发送给mq进行回退
 */
@Data
public class OrderFailMsg implements Serializable {

    private Long orderId;
    private Long couponId;
    private Long userId;
    private BigDecimal usedUserMoney;
    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品数量
     */
    private Integer productNumber;

}
