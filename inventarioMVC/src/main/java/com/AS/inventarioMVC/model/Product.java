
package com.AS.inventarioMVC.model;

public class Product {
    private static long counter = 1;
    
    private Long id;
    private String name;
    private int quantity;
    private double price;
    private String category;
    private String supplier;

    public Product() {
         this.id = counter++; 
    }

    public Product(String name, int quantity, double price, String category, String supplier) {
        this.id = counter++;        
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", category=" + category + ", supplier=" + supplier + '}';
    }

     
    
}
