package com.lida.cloud.mapper;

import com.lida.cloud.domain.Order;

/**
 * @author: 杜利达
 * @date: 2020/3/22 0:04
 */
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}