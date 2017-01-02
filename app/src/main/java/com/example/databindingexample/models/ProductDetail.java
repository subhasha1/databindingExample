package com.example.databindingexample.models;


import java.util.HashMap;
import java.util.List;

public class ProductDetail {
    public int id;
    public String title;
    public String offer;
    public List<String> images;
    public List<Product> relatedProducts;
    public HashMap<String, String> attributes;
    public float newPrice;
    public float oldPrice;
    public List<Variation> variations;
}
