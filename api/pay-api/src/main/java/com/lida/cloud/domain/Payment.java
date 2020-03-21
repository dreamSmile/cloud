package com.lida.cloud.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @author: 杜利达
 * @date: 2020/3/13 15:44
 */
@Data
public class Payment implements Serializable {
    /**
    * ID
    */
    private Long paymentId;

    /**
    * 流水号
    */
    private String serialNum;

    /**
    * 订单号
    */
    private Long orderId;

    /**
    * 1支付成功 0支付失败
    */
    private Integer paidFlag;

    /**
    * 支付金额
    */
    private BigDecimal payAmount;
}