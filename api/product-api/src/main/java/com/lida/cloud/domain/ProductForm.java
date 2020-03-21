package com.lida.cloud.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: 杜利达
 * @date: 2020/3/11 14:49
 */
@Data
public class ProductForm implements Serializable {

    @NotBlank(message = "产品名称不得为空")
    private String productName;

    /**
     * 商品库存
     */
    @NotNull(message = "产品数量不得为空")
    @Min(value = 1, message = "产品数量不得小于1")
    private Integer productNumber;

    /**
     * 单价
     */
    @NotNull(message = "产品单价不得为空")
    private BigDecimal productPrice;

    /**
     * 商品描述
     */
    private String productDesc;

}
