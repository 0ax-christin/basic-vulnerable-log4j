package com.heroes.api.heroesapi.persistence;

import java.util.List;

import com.heroes.api.heroesapi.model.Product;

public interface ProductDAO {
    List <Product> getProducts();
    List <Product> getProduct(String productId);
}