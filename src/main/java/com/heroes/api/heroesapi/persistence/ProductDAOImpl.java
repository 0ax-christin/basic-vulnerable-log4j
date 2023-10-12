package com.heroes.api.heroesapi.persistence;

import com.heroes.api.heroesapi.model.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getProducts() {
        return jdbcTemplate.query("SELECT * FROM Products", new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public List<Product> getProduct(String productId) {
        String sql = "SELECT * FROM Products WHERE ProductID = " + productId + ";";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
    }

}