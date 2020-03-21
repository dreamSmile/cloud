package com.lida.cloud.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author: 杜利达
 * @date: 2020/3/21 23:52
 */
@Data
public class Coupon {
    private Long couponId;

    private BigDecimal couponPrice;

    private Long userId;

    /**
     * 1 已使用 0未使用
     */
    private Integer usedFlag;

    /**
     * 使用时间
     */
    private LocalDateTime usedTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}