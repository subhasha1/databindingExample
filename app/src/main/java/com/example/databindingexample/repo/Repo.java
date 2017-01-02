package com.example.databindingexample.repo;

import com.example.databindingexample.models.Product;
import com.example.databindingexample.models.ProductDetail;

/**
 * Braindigit
 * Created on 1/2/17.
 */

public class Repo {

    public ProductDetail getProductDetail(){
        return null;
    }

    public Product getProduct(){
        Product product = new Product();
        product.id = 123;
        product.image = "";

        return new Product();
    }
}
