package com.heroes.api.heroesapi.persistence;

import java.util.List;

import com.heroes.api.heroesapi.model.Product;

public interface ProductDAO {
    List <Product> getAllProducts();
    Product getProduct(int productId);
}