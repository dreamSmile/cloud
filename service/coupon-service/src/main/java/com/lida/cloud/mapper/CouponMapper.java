package com.lida.cloud.mapper;

import com.lida.cloud.domain.Coupon;

/**
 * @author: 杜利达
 * @date: 2020/3/21 23:52
 */
public interface CouponMapper {
    int deleteByPrimaryKey(Long couponId);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Long couponId);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}