
package com.AS.inventarioMVC.controller;

import com.AS.inventarioMVC.model.Product;
import com.AS.inventarioMVC.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productServ;

    public ProductController(ProductService productServ) {
        this.productServ = productServ;
    }
    
     @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productServ.getAll());
        return "index";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam int quantity,
                             @RequestParam double price,
                             @RequestParam String category,
                             @RequestParam String supplier) {

        productServ.add(new Product(name, quantity, price, category, supplier));
        return "redirect:/";
    }
}
