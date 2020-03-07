package com.github.nikolasimovic.cdl.repository;

import com.github.nikolasimovic.cdl.model.Product;
import com.github.nikolasimovic.cdl.model.Rule;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public static List<Product> productTypes = new ArrayList<>();
    public static List<Product> cart = new ArrayList<>();

    static{
        productTypes.add(new Product("A", 50.0, new Rule(3, 130.0)));
        productTypes.add(new Product("B", 30.0, new Rule(2, 45.0)));
        productTypes.add(new Product("C", 20.0));
        productTypes.add(new Product("D", 15.0));
    }
}
