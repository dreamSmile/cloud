package com.lida.cloud.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: 杜利达
 * @date: 2020/3/22 0:03
 */
@AllArgsConstructor
@Getter
public enum OrderStatus {

    /**
     * 已确认
     */
    OK(0),
    /**
     *已取消
     */
    CANCEL(1),
    /**
     * 已关闭
     */
    CLOSE(2),

    ;
    private Integer v;



}
