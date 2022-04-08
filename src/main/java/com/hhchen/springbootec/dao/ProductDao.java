package com.hhchen.springbootec.dao;

import com.hhchen.springbootec.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
