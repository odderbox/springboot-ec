package com.hhchen.springbootec.service.impl;

import com.hhchen.springbootec.dao.ProductDao;
import com.hhchen.springbootec.model.Product;
import com.hhchen.springbootec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
