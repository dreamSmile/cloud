package com.lida.cloud.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: 杜利达
 * @date: 2020/3/22 0:03
 */
@AllArgsConstructor
@Getter
public enum PayStatus {
    /**
     * 未支付
     */
    NOT(0),
    /**
     *已支付
     */
    OK(1),
    /**
     * 退款中
     */
    REFUNDING(2),
    /**
     * 已退款
     */
    REFUNDED(2),

    ;
    private Integer v;
}
