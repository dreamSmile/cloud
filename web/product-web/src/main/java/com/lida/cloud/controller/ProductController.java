package com.lida.cloud.controller;

import com.lida.cloud.common.ReMsg;
import com.lida.cloud.domain.Product;
import com.lida.cloud.domain.ProductForm;
import com.lida.cloud.service.IProductService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 杜利达
 * @date: 2020/3/11 13:02
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Reference(version = "0.0.1")
    private IProductService productService;

    @PostMapping(value = "/add")
    public ReMsg<Product> add(@RequestBody ProductForm productForm) {
        return ReMsg.ok(productService.add(productForm));
    }

    @GetMapping(value = "/get/{productId}")
    public ReMsg<Product> getById(@PathVariable Long productId) {
        return ReMsg.ok(productService.findById(productId));
    }

}
