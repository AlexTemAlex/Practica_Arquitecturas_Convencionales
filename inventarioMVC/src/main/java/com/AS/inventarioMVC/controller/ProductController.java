package com.AS.inventarioMVC.controller;

import com.AS.inventarioMVC.model.Product;
import com.AS.inventarioMVC.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductServiceImpl productServ;

    public ProductController(ProductServiceImpl productServ) {
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

    @PostMapping("/sell")
    public String sellProduct(@RequestParam Long index,
    @RequestParam int quantity,
    Model model) {

        double total = productServ.sell(index, quantity);

        if (total == 0) {
            model.addAttribute("error", "No se pudo realizar la venta");
        } else {

            Product soldProduct = productServ.findByIndex(index);

            model.addAttribute("success",
            "Venta realizada: " + soldProduct.getName()
            + " | Cantidad vendida: " + quantity
            + " | Stock restante: " + soldProduct.getQuantity()
            + " | Total: $" + total);
        }

        model.addAttribute("products", productServ.getAll());

        return "index";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long index) {

        productServ.delete(index);

        return "redirect:/";
    }
}
