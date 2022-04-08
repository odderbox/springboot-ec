package com.hhchen.springbootec.dao;

import com.hhchen.springbootec.dto.ProductRequest;
import com.hhchen.springbootec.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
