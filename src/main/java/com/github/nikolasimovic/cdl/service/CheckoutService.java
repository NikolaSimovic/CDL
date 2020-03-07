package com.github.nikolasimovic.cdl.service;

import com.github.nikolasimovic.cdl.model.Product;

public interface CheckoutService {

    /**
     * <p>Compute the final price amount based on the products contained in the cart.</p>
     *
     * @return {@link Double} total amount
     */
    Double  calculateTotalPrice();

    /**
     * <p>Add product to cart.</p>
     *
     * @param  {@link Product} product to be inserted in cart
     * @return {@link Void}
     */
    void addToCart(Product product);
}
