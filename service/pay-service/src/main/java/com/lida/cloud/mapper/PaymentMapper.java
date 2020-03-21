package com.lida.cloud.mapper;

import com.lida.cloud.domain.Payment;

/**
 * @author: 杜利达
 * @date: 2020/3/13 15:44
 */
public interface PaymentMapper {
    int deleteByPrimaryKey(Long paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long paymentId);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}