package com.hhchen.springbootec.dao;

import com.hhchen.springbootec.dto.ProductRequest;
import com.hhchen.springbootec.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
