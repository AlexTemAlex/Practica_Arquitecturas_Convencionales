
package com.AS.inventarioMVC.service;

import com.AS.inventarioMVC.model.Product;
import java.util.List;

public interface ProductService {    
    public List<Product> getAll();
    public void add(Product product);
}
