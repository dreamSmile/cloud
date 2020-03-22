package com.lida.cloud.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: 杜利达
 * @date: 2020/3/15 14:26
 */
@Data
public class CouponForm implements Serializable {

    @NotNull(message = "产品单价不得为空")
    private BigDecimal couponPrice;

    @NotNull(message = "所属用户不得为空")
    private Long userId;
}
