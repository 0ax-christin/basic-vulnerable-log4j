package com.heroes.api.heroesapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private int ProductID;
    private String ProductName;
    private String Price;
    private String Stock;

    public Product(int productID, String productName, float price, int stock) {
        this.ProductID = productID;
        this.ProductName = productName;
        this.Price = Float.toString(price);
        this.Stock = Integer.toString(stock);
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
        this.Price = Float.toString(price);
    }
    public String getPrice() {
        return this.Price;
    }
    public void setStock(int stock) {
        this.Stock = Integer.toString(stock);
    }
    public String getStock() {
        return this.Stock;
    }
}