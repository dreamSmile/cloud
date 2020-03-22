package com.lida.cloud.service.impl;

import com.lida.cloud.domain.Coupon;
import com.lida.cloud.domain.CouponForm;
import com.lida.cloud.exception.ServiceException;
import com.lida.cloud.mapper.CouponMapper;
import com.lida.cloud.service.ICouponService;
import com.lida.cloud.utils.IDWorker;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * @author: 杜利达
 * @date: 2020/3/15 14:33
 */
@Service(version = "0.0.1")
public class CouponServiceImpl implements ICouponService {

    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private IDWorker idWorker;

    @Override
    public Coupon add(CouponForm couponForm) {
        Coupon coupon = new Coupon();
        coupon.setCouponId(idWorker.nextId());
        coupon.setCouponPrice(couponForm.getCouponPrice());
        coupon.setUserId(couponForm.getUserId());
        coupon.setCreateTime(LocalDateTime.now());
        coupon.setUsedFlag(0);
        int num = couponMapper.insert(coupon);
        if(num == 1) {
            return coupon;
        } else {
            throw new ServiceException("发优惠券失败");
        }
    }

    @Override
    public Coupon use(Long couponId) {
        Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
        if (coupon == null) {
            throw new ServiceException("优惠券不存在");
        }
        coupon.setUsedFlag(1);
        coupon.setUsedTime(LocalDateTime.now());
        int resultNum = couponMapper.updateByPrimaryKey(coupon);
        if (resultNum != 1) {
            throw new ServiceException("使用优惠券失败");
        }

        return coupon;
    }

    @Override
    public Coupon findById(Long couponId) {
        return couponMapper.selectByPrimaryKey(couponId);
    }
}
