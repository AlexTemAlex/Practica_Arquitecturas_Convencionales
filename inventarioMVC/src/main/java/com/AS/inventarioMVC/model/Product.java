
package com.AS.inventarioMVC.model;

public class Product {
    private String name;
    private int quantity;
    private double price;
    private String category;
    private String supplier;

    public Product() {
    }

    public Product(String name, int quantity, double price, String category, String supplier) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + ", category=" + category + ", supplier=" + supplier + '}';
    }    
    
}
