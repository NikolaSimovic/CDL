package com.github.nikolasimovic.cdl.service.impl;

import com.github.nikolasimovic.cdl.model.Product;
import com.github.nikolasimovic.cdl.repository.ProductRepository;
import com.github.nikolasimovic.cdl.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public Product getProduct(String sku) {
        return ProductRepository.productTypes.stream()
                .filter(product -> product.getSku().equalsIgnoreCase(sku))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Product " + sku + " does not exist in collection.");
                    return null;
                });
    }
}
