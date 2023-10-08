package com.heroes.api.heroesapi.controller;

import java.util.List;

import com.heroes.api.heroesapi.model.Hero;
import com.heroes.api.heroesapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.heroes.api.heroesapi.persistence.ProductDAO;

@RestController
@RequestMapping("products")
@EnableTransactionManagement
public class ProductController {
    private static final Logger LOG = LogManager.getLogger(HeroController.class.getName());

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productDAO.getAllProducts();
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {
        LOG.info("GET /products?id=" + productId);
        //int id = Integer.parseInt(productId, 0);
        Product product = productDAO.getProduct(productId);
        if (product != null)
            return new ResponseEntity<Product>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
