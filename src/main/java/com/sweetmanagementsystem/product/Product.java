package com.sweetmanagementsystem.product;

public class Product {

    private String name;
    private double price;
    private int quantity;
    private int salesCount;
    private double discountPercentage;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.salesCount = 0;
        this.discountPercentage = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price * (1 - discountPercentage / 100);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void incrementSalesCount() {
        this.salesCount++;
    }

    public void applyDiscount(double percentage) {
        this.discountPercentage = percentage;
    }

    public void resetDiscount() {
        this.discountPercentage = 0.0;
    }

	public void setPrice(double newPrice) {
		// TODO Auto-generated method stub
		this.price = newPrice;
		
	}
}
