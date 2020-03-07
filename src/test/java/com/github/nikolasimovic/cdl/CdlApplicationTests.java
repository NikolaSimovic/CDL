package com.github.nikolasimovic.cdl;

import com.github.nikolasimovic.cdl.model.Product;
import com.github.nikolasimovic.cdl.model.Rule;
import com.github.nikolasimovic.cdl.repository.ProductRepository;
import com.github.nikolasimovic.cdl.service.CheckoutService;
import com.github.nikolasimovic.cdl.service.ProductService;
import com.github.nikolasimovic.cdl.service.impl.CheckoutServiceImpl;
import com.github.nikolasimovic.cdl.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = {ProductServiceImpl.class, CheckoutServiceImpl.class})
class CdlApplicationTests {

	@Autowired
	private ProductService productService;

	@Autowired
	private CheckoutService checkoutService;

	@BeforeEach
	void init() {
		ProductRepository.cart.clear();
	}

	@Test
	void getProductTest() {
		Product mockedProduct = new Product("A", 50.0, new Rule(3, 130.0));

		assertEquals(productService.getProduct("A"), mockedProduct);
	}

	@Test
	void addToCartTest() {
		Product a = productService.getProduct("A");
		Product f = productService.getProduct("F");

		checkoutService.addToCart(a);
		checkoutService.addToCart(f);

		assertEquals(ProductRepository.cart.size(), 1);
	}

	@Test
	void calculateTotalPriceTest() {
		Product a = productService.getProduct("A");
		Product b = productService.getProduct("B");
		Product c = productService.getProduct("C");
		Product d = productService.getProduct("D");

		checkoutService.addToCart(a);
		checkoutService.addToCart(b);
		checkoutService.addToCart(a);
		checkoutService.addToCart(b);
		checkoutService.addToCart(a);
		checkoutService.addToCart(c);
		checkoutService.addToCart(d);

		assertEquals(210.0, checkoutService.calculateTotalPrice());
	}

}
