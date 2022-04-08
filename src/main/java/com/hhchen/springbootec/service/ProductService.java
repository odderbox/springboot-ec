package com.hhchen.springbootec.service;

import com.hhchen.springbootec.dto.ProductRequest;
import com.hhchen.springbootec.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
