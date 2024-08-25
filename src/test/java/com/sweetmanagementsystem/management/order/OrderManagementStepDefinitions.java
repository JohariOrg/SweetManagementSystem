package com.sweetmanagementsystem.management.order;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import com.sweetmanagementsystem.order.Order;
import com.sweetmanagementsystem.order.OrderManagementService;

import static org.junit.Assert.assertNotNull;

public class OrderManagementStepDefinitions {

    private OrderManagementService orderService;
    private Order order;

    @Given("the store owner has received an order")
    public void the_store_owner_has_received_an_order() {
        orderService = new OrderManagementService();
        order = new Order("123", "Chocolate Cake", 2);
        orderService.addOrder(order);
    }

    @When("the store owner updates the order status to shipped")
    public void the_store_owner_updates_the_order_status_to_shipped() {
        boolean isUpdated = orderService.updateOrderStatus(order.getOrderId(), "Shipped");
        assertTrue(isUpdated);
    }

    @Then("the order status should be updated successfully")
    public void the_order_status_should_be_updated_successfully() {
        Order updatedOrder = orderService.getOrder(order.getOrderId());
        
        // Debugging print statements
        if (updatedOrder != null) {
            System.out.println("Order ID: " + updatedOrder.getOrderId());
            System.out.println("Expected Status: " + updatedOrder.getStatus());
        } else {
            System.out.println("Order not found.");
        }

        // Continue with assertions
        assertNotNull("Order should not be null", updatedOrder);
        assertTrue("Order status should be updated", updatedOrder.getStatus().equals("Shipped") || updatedOrder.getStatus().equals("Completed"));
        System.out.println("Order status updated to: " + updatedOrder.getStatus());
    }


    @When("the store owner updates the order status to completed")
    public void the_store_owner_updates_the_order_status_to_completed() {
        boolean isUpdated = orderService.updateOrderStatus(order.getOrderId(), "Completed");
        assertTrue(isUpdated);
    }

    @Then("the order status should be updated to completed successfully")
    public void the_order_status_should_be_updated_to_completed_successfully() {
        Order updatedOrder = orderService.getOrder(order.getOrderId());
        assertNotNull(updatedOrder);
        assertTrue(updatedOrder.getStatus().equals("Completed"));
        System.out.println("Order status updated to: " + updatedOrder.getStatus());
    }
}
