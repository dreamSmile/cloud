package com.lida.cloud.service.impl;

import com.lida.cloud.domain.Product;
import com.lida.cloud.domain.ProductForm;
import com.lida.cloud.exception.ServiceException;
import com.lida.cloud.mapper.ProductMapper;
import com.lida.cloud.service.IProductService;
import com.lida.cloud.utils.IDWorker;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * @author: 杜利达
 * @date: 2020/3/11 15:03
 */
@Service(version = "0.0.1")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private IDWorker idWorker;

    @Override
    public Product add(ProductForm productForm) {
        Product product = new Product();
        BeanUtils.copyProperties(productForm, product);
        product.setAddTime(LocalDateTime.now());
        product.setProductId(idWorker.nextId());
        int num = productMapper.insert(product);
        if (num == 1) {
            return product;
        } else {
            throw new ServiceException("添加失败");
        }

    }

    @Override
    public Product findById(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public Product reduce(Long productId, Integer productNum) {
        //这里其实最好起码加乐观锁，暂时不考虑该问题
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            throw new ServiceException("商品不存在");
        }
        if (product.getProductNumber() < productNum) {
            throw new ServiceException("库存不足");
        }
        //减库存
        product.setProductNumber(product.getProductNumber() - productNum);
        int resultNum = productMapper.updateByPrimaryKey(product);
        if (resultNum != 1) {
            throw new ServiceException("减库存失败");
        }
        return product;
    }
}
