package com.sweetmanagementsystem.management.product;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import com.sweetmanagementsystem.product.Product;
import com.sweetmanagementsystem.product.ProductManagementService;
import com.sweetmanagementsystem.product.SalesService;

public class ProductManagementStepDefinitions {

    private ProductManagementService productService;
    private SalesService salesService;
    private Product product;

    @Given("the store owner is logged in for product management")
    public void the_store_owner_is_logged_in_for_product_management() {
        productService = new ProductManagementService();  // Initialize productService here
    }

    @When("the store owner adds a product")
    public void the_store_owner_adds_a_product() {
        product = new Product("Chocolate Cake", 15.0, 100);
        productService.addProduct(product);
    }

    @Then("the product should be added successfully")
    public void the_product_should_be_added_successfully() {
        Map<String, Product> allProducts = productService.getAllProducts();
        assertNotNull(allProducts.get(product.getName()));
        System.out.println("Product added: " + product.getName());
    }

    @Given("the store owner has a product in the system")
    public void the_store_owner_has_a_product_in_the_system() {
        // Initialize productService if it hasn't been done yet
        if (productService == null) {
            productService = new ProductManagementService();
        }
        productService.addProduct(new Product("Chocolate Cake", 15.0, 100));
    }

    @When("the store owner updates the product")
    public void the_store_owner_updates_the_product() {
        boolean isUpdated = productService.updateProduct("Chocolate Cake", 12.0, 120);
        assertTrue(isUpdated);
    }

    @Then("the product should be updated successfully")
    public void the_product_should_be_updated_successfully() {
        Product updatedProduct = productService.getAllProducts().get("Chocolate Cake");
        assertTrue(updatedProduct.getQuantity() == 120);
        System.out.println("Product updated: " + updatedProduct.getName());
    }

    @When("the store owner removes the product")
    public void the_store_owner_removes_the_product() {
        boolean isRemoved = productService.removeProduct("Chocolate Cake");
        assertTrue(isRemoved);
    }

    @Then("the product should be removed from the system")
    public void the_product_should_be_removed_from_the_system() {
        Map<String, Product> allProducts = productService.getAllProducts();
        assertTrue(!allProducts.containsKey("Chocolate Cake"));
        System.out.println("Product removed: Chocolate Cake");
    }

    @Given("the store owner has sales data")
    public void the_store_owner_has_sales_data() {
        // Initialize productService and salesService if not done yet
        if (productService == null) {
            productService = new ProductManagementService();
        }
        productService.addProduct(new Product("Chocolate Cake", 15.0, 100));
        productService.addProduct(new Product("Vanilla Cake", 10.0, 80));

        salesService = new SalesService(productService.getAllProducts());

        // Record some sales
        salesService.recordSale("Chocolate Cake");
        salesService.recordSale("Chocolate Cake");
        salesService.recordSale("Vanilla Cake");
    }

    @When("the store owner checks the best-selling product")
    public void the_store_owner_checks_the_best_selling_product() {
        Product bestSeller = salesService.getBestSellingProduct();
        assertNotNull(bestSeller);
        System.out.println("Best-selling product: " + bestSeller.getName());
    }

    @Then("the best-selling product should be displayed")
    public void the_best_selling_product_should_be_displayed() {
        // Output was displayed in the previous step
    }
}