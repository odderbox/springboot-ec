package com.hhchen.springbootec.dao;

import com.hhchen.springbootec.dto.ProductQueryParams;
import com.hhchen.springbootec.dto.ProductRequest;
import com.hhchen.springbootec.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams params);

    List<Product> getProducts(ProductQueryParams params);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

    void updateStock(Integer productId, Integer stock);
}
