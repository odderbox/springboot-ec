package com.hhchen.springbootec.dao.impl;

import com.hhchen.springbootec.dao.ProductDao;
import com.hhchen.springbootec.dto.ProductQueryParams;
import com.hhchen.springbootec.dto.ProductRequest;
import com.hhchen.springbootec.model.Product;
import com.hhchen.springbootec.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer countProduct(ProductQueryParams params) {

        String sql = "SELECT COUNT(*) FROM product WHERE 1=1";
        Map<String, Object> map = new HashMap<>();

        sql = addFilterSql(sql, map, params);

        Integer total = namedParameterJdbcTemplate.queryForObject(sql,map, Integer.class);

        return total;
    }

    @Override
    public List<Product> getProducts(ProductQueryParams params) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        sql = addFilterSql(sql, map, params);

        sql += " ORDER BY " + params.getOrderBy() + " " + params.getSort();
        sql += " LIMIT :limit OFFSET :offset";
        map.put("limit", params.getLimit());
        map.put("offset", params.getOffset());

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE product_id = :productId ";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if(productList.size() > 0){
            return productList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql ="INSERT INTO product(product_name, category, image_url, price, stock, description, created_date, last_modified_date)" +
                "VALUES(:productName, :category, :imageUrl, :price, :stock, :description, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().name());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("createdDate", new Date());
        map.put("lastModifiedDate", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET " +
                "product_name = :productName, " +
                "category = :category, " +
                "image_url = :imageUrl, " +
                "price = :price, " +
                "stock = :stock, " +
                "description = :description, " +
                "last_modified_date = :lastModifiedDate " +
                "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().name());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void deleteProduct(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId ";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }

    private String addFilterSql(String sql, Map<String,Object> map, ProductQueryParams params){
        if(params.getSearch() != null){
            sql += " AND product_name LIKE :search";
            map.put("search", "%" + params.getSearch() + "%");
        }
        if(params.getCategory() != null){
            sql += " AND category = :category";
            map.put("category", params.getCategory().name());
        }
        return sql;
    }
}
