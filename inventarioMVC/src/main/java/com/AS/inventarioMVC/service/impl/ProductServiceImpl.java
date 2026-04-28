
package com.AS.inventarioMVC.service.impl;

import com.AS.inventarioMVC.model.Product;
import com.AS.inventarioMVC.repository.impl.ProductMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
    private final ProductMapper productRepo;

    public ProductServiceImpl(ProductMapper productRepo) {
        this.productRepo = productRepo;
    }
    
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public void add(Product product) {
        productRepo.save(product);
    } 
}
