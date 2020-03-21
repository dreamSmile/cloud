package com.lida.cloud.controller;

import com.lida.cloud.service.impl.IOrderService;
import com.lida.cloud.common.ReMsg;
import com.lida.cloud.domain.OrderForm;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 杜利达
 * @date: 2020/3/11 13:12
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Reference
    private IOrderService orderService;

    @PostMapping("/confirm")
    public ReMsg confirmOrder(@RequestBody OrderForm orderForm){
        return orderService.confirmOrder(orderForm);
    }
}
