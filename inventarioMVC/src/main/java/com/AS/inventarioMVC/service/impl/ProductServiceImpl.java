
package com.AS.inventarioMVC.service.impl;

import com.AS.inventarioMVC.model.Product;
import com.AS.inventarioMVC.repository.impl.ProductRepositoryImpl;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
    private final ProductRepositoryImpl productRepoImpl;

    public ProductServiceImpl(ProductRepositoryImpl productRepo) {
        this.productRepoImpl = productRepo;
    }
    
    public List<Product> getAll() {
        return productRepoImpl.findAll();
    }

    public Product findByIndex(int idx) {
        return productRepoImpl.findByIndex(idx-1);
    }
    
    public void add(Product product) {
        productRepoImpl.save(product);
    } 
    
    public double sell(int index, int quantity) {
        try {

            Product p = productRepoImpl.findByIndex(index-1);

            if (p == null) {
                System.out.println("Producto no encontrado");
                return 0;
            }

            if (quantity <= 0) {
                System.out.println("Cantidad inválida");
                return 0;
            }

            if (p.getQuantity() < quantity) {
                System.out.println("Stock insuficiente");
                return 0;
            }

            double total = quantity * p.getPrice();
            
            // discounts by type and quantity
            switch (p.getCategory().toLowerCase()) {
                case "granos" -> total *= 0.95;
                case "pastas" -> total *= 0.90;
            }

            if (quantity > 10) total *= 0.85;

            p.setQuantity(p.getQuantity() - quantity);

            return total;

        } catch (Exception e) {
            System.out.println("Error en venta: " + e.getMessage());
            return 0;
        }
    }

    public void delete(int idx) {
        try {
            productRepoImpl.del(idx - 1);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
