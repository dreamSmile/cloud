package com.lida.cloud.domain;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: 杜利达
 * @date: 2020/3/11 13:38
 * 不考虑复杂的逻辑，假设一个订单一个商品id
 */
@Data
public class OrderForm implements Serializable {

    @NotNull(message = "订单用户不得为空")
    private Long userId;

    @NotBlank(message = "收货地址不得为空")
    private String address;

    /**
     * 收货人
     */
    @NotBlank(message = "收货人不得为空")
    private String consignee;

    @NotNull(message = "订单商品不得为空")
    private Long productId;

    @NotNull(message = "商品数量不得为空")
    @Min(value = 1, message = "商品数量不得小于一件")
    private Integer productNumber;

    /**
     * 运费
     */
    @NotNull(message = "运费不得为空")
    @DecimalMin(value = "0", message = "运费不得低于0元")
    private BigDecimal shippingFee;

    /**
     * 优惠券
     */
    private Long couponId;

}
