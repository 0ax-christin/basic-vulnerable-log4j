package com.heroes.api.heroesapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private int ProductID;
    private String ProductName;
    private float Price;
    private int Stock;

    public Product(int productID, String productName, float price, int stock) {
        this.ProductID = productID;
        this.ProductName = productName;
        this.Price = price;
        this.Stock = stock;
    }

    public void setProductID(int productID) {
        this.ProductID = productID;
    }
    public int getProductID() {
        return this.ProductID;
    }
    public void setProductName(String productName) {
        this.ProductName = productName;
    }
    public String getProductName() {
        return this.ProductName;
    }
    public void setPrice(float price) {
        this.Price = price;
    }
    public float getPrice() {
        return this.Price;
    }
    public void setStock(int stock) {
        this.Stock = stock;
    }
    public int getStock() {
        return this.Stock;
    }
}