
package com.AS.inventarioMVC.repository.impl;

import com.AS.inventarioMVC.model.Product;
import com.AS.inventarioMVC.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {    
    private final List<Product> inventory = new ArrayList<>();

    public ProductRepositoryImpl() {
        inventory.add(new Product("Manzanas", 50, 0.50, "Frutas", "Proveedor A"));
        inventory.add(new Product("Arroz", 100, 0.90, "Granos", "Proveedor C"));
        inventory.add(new Product("Pan", 40, 0.40, "Panadería", "Proveedor D"));
        inventory.add(new Product("Fideos", 20, 5.00, "Carnes", "Proveedor E"));
    }
    
    @Override
    public List<Product> findAll(){
        return this.inventory;
    }
    
    @Override
    public void save(Product product){
        this.inventory.add(product);
    }
}

