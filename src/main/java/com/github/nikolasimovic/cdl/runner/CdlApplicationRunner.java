package com.github.nikolasimovic.cdl.runner;

import com.github.nikolasimovic.cdl.service.CheckoutService;
import com.github.nikolasimovic.cdl.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CdlApplicationRunner implements CommandLineRunner {

    private ProductService productService;
    private CheckoutService checkoutService;

    public CdlApplicationRunner(ProductService productService, CheckoutService checkoutService) {
        this.productService = productService;
        this.checkoutService = checkoutService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Scan product: ");
            checkoutService.addToCart(productService.getProduct(scanner.next()));
            System.out.println("Total: " + checkoutService.calculateTotalPrice());
            System.out.print("Finish purchase(y/n): ");
            if(scanner.next().equalsIgnoreCase("y")) {
                System.out.println("Thank you for your purchase. Your final bill is: " + checkoutService.calculateTotalPrice());
                System.exit(0);
            }
        }
    }
}
