package com.sweetmanagementsystem.product;

import java.util.HashMap;
import java.util.Map;

public class ProductManagementService {

    private Map<String, Product> products;

    public ProductManagementService() {
        products = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    // Update an existing product
    public boolean updateProduct(String productName, double newPrice, int newQuantity) {
        Product product = products.get(productName);
        if (product != null) {
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    // Remove a product
    public boolean removeProduct(String productName) {
        return products.remove(productName) != null;
    }

    // Retrieve all products
    public Map<String, Product> getAllProducts() {
        return products;
    }

    // Print all products
    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
}
