package com.sweetmanagementsystem.order;

public class Order {

    private String orderId;
    private String productName;
    private int quantity;
    private String status;

    public Order(String orderId, String productName, int quantity) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.status = "Pending"; // Default status
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
