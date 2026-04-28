
package com.AS.inventarioMVC.repository.impl;

import com.AS.inventarioMVC.model.Product;
import com.AS.inventarioMVC.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {    
    private final List<Product> inventory = new ArrayList<>();

    // database simulation
    public ProductRepositoryImpl() {

        inventory.add(new Product("Manzanas", 50, 0.50, "Frutas", "Proveedor A"));
        inventory.add(new Product("Plátanos", 80, 0.30, "Frutas", "Proveedor A"));
        inventory.add(new Product("Naranjas", 60, 0.40, "Frutas", "Proveedor B"));

        inventory.add(new Product("Arroz", 100, 0.90, "Granos", "Proveedor C"));
        inventory.add(new Product("Lentejas", 70, 1.10, "Granos", "Proveedor C"));
        inventory.add(new Product("Fréjol", 65, 1.20, "Granos", "Proveedor D"));

        inventory.add(new Product("Espagueti", 40, 1.50, "Pastas", "Proveedor E"));
        inventory.add(new Product("Macarrones", 35, 1.40, "Pastas", "Proveedor E"));
        inventory.add(new Product("Fideos", 50, 1.30, "Pastas", "Proveedor F"));
    }
    
    @Override
    public List<Product> findAll(){
        return this.inventory;
    }
    
    @Override
    public void save(Product product){
        this.inventory.add(product);
    }

    @Override
    public void del(int idx) {
        this.inventory.remove(idx);
    }

    @Override
    public Product findByIndex(int idx) {
        return this.inventory.get(idx);
    }
    
}

