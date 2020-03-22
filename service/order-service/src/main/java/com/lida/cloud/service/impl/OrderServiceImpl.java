package com.lida.cloud.service.impl;

import com.lida.cloud.domain.*;
import com.lida.cloud.enums.OrderStatus;
import com.lida.cloud.enums.PayStatus;
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
    public Long confirmOrder(OrderForm orderForm) {
        // 1.减库存
        Product product = productService.reduce(orderForm.getProductId(), orderForm.getProductNumber());
        // 2.减优惠券
        Coupon coupon = null;
        BigDecimal couponPrice = BigDecimal.ZERO;
        if (orderForm.getCouponId() != null) {
            coupon = couponService.use(orderForm.getCouponId());
            couponPrice = coupon.getCouponPrice();
        }
        // 3.下订单
        Order order = new Order();
        BeanUtils.copyProperties(orderForm, order);
        order.setAddTime(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.OK.getV());
        order.setPayStatus(PayStatus.NOT.getV());
        order.setProductPrice(product.getProductPrice());
        // 商品总价
        BigDecimal allProductPrice = product.getProductPrice().multiply(BigDecimal.valueOf(orderForm.getProductNumber()));
        order.setProductAmount(allProductPrice);
        // 订单价格
        BigDecimal orderPrice = allProductPrice.add(orderForm.getShippingFee());
        order.setOrderAmount(orderPrice);
        if (orderForm.getCouponId() != null && coupon != null) {
            order.setCouponId(coupon.getCouponId());
            order.setCouponPaid(couponPrice);
        }
        // 支付金额
        BigDecimal payMount = orderPrice.subtract(couponPrice);
        order.setPayMount(payMount);
        order.setOrderId(idWorker.nextId());
        orderMapper.insert(order);
        return order.getOrderId();
    }

}
