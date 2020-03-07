package com.github.nikolasimovic.cdl.service.impl;

import com.github.nikolasimovic.cdl.model.Product;
import com.github.nikolasimovic.cdl.repository.ProductRepository;
import com.github.nikolasimovic.cdl.service.CheckoutService;
import com.github.nikolasimovic.cdl.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.groupingBy;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private ProductService productService;

    public CheckoutServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Double calculateTotalPrice() {
        Map<String, List<Product>> productsBySku = ProductRepository.cart.stream()
                .collect(groupingBy(Product::getSku));

        AtomicReference<Double> result = new AtomicReference<>(0.00);

        productsBySku.entrySet().stream()
                .filter(pe -> !pe.getValue().isEmpty())
                .forEach(p -> {
                    Integer quantity = p.getValue().size();
                    Product product = productService.getProduct(p.getKey());
                    if(nonNull(product.getPricingRule())) {
                        result.set(result.get() + getSpecialPrice(product, p.getValue()));
                    } else {
                        result.set(result.get() + product.getPrice()*quantity);
                    }

        });
        return result.get();
    }

    private Double getSpecialPrice(Product product, List<Product> products) {
        Integer quantity = product.getPricingRule().getQuantity();
        return products.size()%quantity*product.getPrice()
                + products.size()/quantity*product.getPricingRule().getPrice();
    }

    @Override
    public void addToCart(Product product) {
        if (nonNull(product))
            ProductRepository.cart.add(product);
    }
}
