
package com.AS.inventarioMVC.repository.impl;

import com.AS.inventarioMVC.model.Product;
import com.AS.inventarioMVC.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductMapper implements ProductRepository {    
    private List<Product> inventory = new ArrayList<>();
    
    public List<Product> findAll(){
        return this.inventory;
    }
    
    public void save(Product product){
        this.inventory.add(product);
    }
}

