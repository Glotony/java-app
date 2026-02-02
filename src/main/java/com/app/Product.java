package com.app;

public class Product {

    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // ===== getters =====
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // ===== setters =====
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return name + " - $" + price + " - Stock: " + stock;
    }
}
