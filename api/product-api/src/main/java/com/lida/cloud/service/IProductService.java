package com.lida.cloud.service;

import com.lida.cloud.domain.Product;
import com.lida.cloud.domain.ProductForm;

/**
 * @author: 杜利达
 * @date: 2020/3/13 14:26
 */
public interface IProductService {
    Product add(ProductForm productForm);

    Product findById(Long id);

    /**
     * 减库存
     * @param productId
     * @param productNum
     * @return
     */
    void reduce(Long productId, Integer productNum);
}
