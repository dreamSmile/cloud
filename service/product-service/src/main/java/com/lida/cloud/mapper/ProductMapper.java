package com.lida.cloud.mapper;

import com.lida.cloud.domain.Product;

/**
 * @author: 杜利达
 * @date: 2020/3/13 15:47
 */
public interface ProductMapper {
    int deleteByPrimaryKey(Long productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}