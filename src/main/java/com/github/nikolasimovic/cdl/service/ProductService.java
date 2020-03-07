package com.github.nikolasimovic.cdl.service;

import com.github.nikolasimovic.cdl.model.Product;

public interface ProductService {

    /**
     * <p>Return product based on SKU.</p>
     *
     * @return {@link Product} product instance
     */
    Product getProduct(String sku);

}
