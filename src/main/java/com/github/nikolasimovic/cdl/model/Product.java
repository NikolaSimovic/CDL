package com.github.nikolasimovic.cdl.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    String sku;
    Double price;
    Rule pricingRule;

    public Product(String sku, Double price) {
        this.sku = sku;
        this.price = price;
    }
}
