package com.lida.cloud.service;

import com.lida.cloud.domain.Coupon;
import com.lida.cloud.domain.CouponForm;

/**
 * @author: 杜利达
 * @date: 2020/3/13 14:17
 */
public interface ICouponService {

    /**
     * 发优惠券
     * @param couponForm
     * @return
     */
    Coupon add(CouponForm couponForm);


    /**
     * 使用优惠券
     * @param couponId
     */
    void use(Long couponId);

    /**
     * 通过id查找
     * @param couponId
     * @return
     */
    Coupon findById(Long couponId);

}
