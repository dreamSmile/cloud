package com.lida.cloud.service.impl;

import com.lida.cloud.domain.*;
import com.lida.cloud.exception.ServiceException;
import com.lida.cloud.mapper.OrderMapper;
import com.lida.cloud.service.ICouponService;
import com.lida.cloud.service.IOrderService;
import com.lida.cloud.service.IProductService;
import com.lida.cloud.service.IUserService;
import com.lida.cloud.utils.IDWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: 杜利达
 * @date: 2020/3/13 16:41
 */
@Slf4j
@Service(version = "0.0.1")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Reference(version = "0.0.1")
    private IProductService productService;
    @Reference(version = "0.0.1")
    private IUserService userService;
    @Reference(version = "0.0.1")
    private ICouponService couponService;
    @Autowired
    private IDWorker idWorker;

    /**
     * 不考虑太复杂的逻辑，只为seata
     * @param orderForm
     * @return
     */
    @Override
    public boolean confirmOrder(OrderForm orderForm) {
        // 1.减库存
        productService.reduce(orderForm.getProductId(), orderForm.getProductNumber());
        // 2.减优惠券
        if (orderForm.getCouponId() != null) {
            couponService.use(orderForm.getCouponId());
        }
        // 3.下订单
        Order order = new Order();
        BeanUtils.copyProperties(orderForm, order);


        return false;
    }

}
