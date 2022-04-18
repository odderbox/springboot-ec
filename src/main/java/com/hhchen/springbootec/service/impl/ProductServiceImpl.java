package com.hhchen.springbootec.service.impl;

import com.hhchen.springbootec.dao.ProductDao;
import com.hhchen.springbootec.dto.ProductQueryParams;
import com.hhchen.springbootec.dto.ProductRequest;
import com.hhchen.springbootec.model.Product;
import com.hhchen.springbootec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countProduct(ProductQueryParams params) {
        return productDao.countProduct(params);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams params) {
        return productDao.getProducts(params);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
