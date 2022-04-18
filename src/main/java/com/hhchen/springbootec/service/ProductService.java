package com.hhchen.springbootec.service;

import com.hhchen.springbootec.dto.ProductQueryParams;
import com.hhchen.springbootec.dto.ProductRequest;
import com.hhchen.springbootec.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams params);

    List<Product> getProducts(ProductQueryParams params);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
