package com.hhchen.springbootec.service;

import com.hhchen.springbootec.constant.ProductCategory;
import com.hhchen.springbootec.dto.ProductRequest;
import com.hhchen.springbootec.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(String search, ProductCategory category);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
