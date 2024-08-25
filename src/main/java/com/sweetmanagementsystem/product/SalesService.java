package com.sweetmanagementsystem.product;

import java.util.Map;

public class SalesService {

    private Map<String, Product> products;

    public SalesService(Map<String, Product> products) {
        this.products = products;
    }

    // Track sales of a product
    public void recordSale(String productName) {
        Product product = products.get(productName);
        if (product != null && product.getQuantity() > 0) {
            product.incrementSalesCount();
            product.setQuantity(product.getQuantity() - 1);
        }
    }

    // Get the best-selling product
    public Product getBestSellingProduct() {
        Product bestProduct = null;
        for (Product product : products.values()) {
            if (bestProduct == null || product.getSalesCount() > bestProduct.getSalesCount()) {
                bestProduct = product;
            }
        }
        return bestProduct;
    }
}
