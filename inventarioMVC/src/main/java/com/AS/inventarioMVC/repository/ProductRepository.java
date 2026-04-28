
package com.AS.inventarioMVC.repository;

import com.AS.inventarioMVC.model.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
    public List<Product> findAll();
    public void save(Product product);
    public void del(Long idx);
    public Product findByIndex(Long idx);
}
