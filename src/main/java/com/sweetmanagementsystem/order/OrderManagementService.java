package com.sweetmanagementsystem.order;

import java.util.HashMap;
import java.util.Map;

public class OrderManagementService {

    private Map<String, Order> orders;

    public OrderManagementService() {
        orders = new HashMap<>();
    }

    // Add a new order
    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    // Update the status of an order
    public boolean updateOrderStatus(String orderId, String newStatus) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
            return true;
        }
        return false;
    }

    // Retrieve an order by its ID
    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    // Retrieve all orders
    public Map<String, Order> getAllOrders() {
        return orders;
    }

    // Print all orders
    public void printAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            for (Order order : orders.values()) {
                System.out.println("Order ID: " + order.getOrderId() + ", Product: " + order.getProductName() + ", Quantity: " + order.getQuantity() + ", Status: " + order.getStatus());
            }
        }
    }
}
