package com.lida.cloud.controller;

import com.lida.cloud.common.ReMsg;
import com.lida.cloud.domain.Coupon;
import com.lida.cloud.domain.CouponForm;
import com.lida.cloud.service.ICouponService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 杜利达
 * @date: 2020/3/22 11:08
 */
@RestController
@RequestMapping(value = "/coupon")
public class CouponController {

    @Reference(version = "0.0.1")
    private ICouponService couponService;

    @PostMapping(value = "/add")
    public ReMsg<Coupon> add(@Validated @RequestBody CouponForm couponForm) {
        return ReMsg.ok(couponService.add(couponForm));
    }

}
