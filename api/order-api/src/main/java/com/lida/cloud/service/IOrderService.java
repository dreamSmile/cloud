package com.lida.cloud.service;

import com.lida.cloud.domain.OrderForm;

/**
 * @author: 杜利达
 * @date: 2020/3/13 14:20
 */
public interface IOrderService {
    /**
     * 确认订单（下单）
     * @param orderForm
     * @return
     */
    boolean confirmOrder(OrderForm orderForm);
}
