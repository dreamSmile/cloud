package com.lida.cloud.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author: 杜利达
 * @date: 2020/3/13 15:47
 */
@Data
public class Product implements Serializable {
    private Long productId;

    private String productName;

    /**
    * 商品库存
    */
    private Integer productNumber;

    /**
    * 单价
    */
    private BigDecimal productPrice;

    /**
    * 商品描述
    */
    private String productDesc;

    private LocalDateTime addTime;
}