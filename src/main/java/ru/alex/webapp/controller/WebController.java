package ru.alex.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alex.webapp.model.Product;
import ru.alex.webapp.service.ProductService;

import java.util.List;

@Controller
public class WebController {
    private final ProductService productService;

    @Autowired
    public WebController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String findAll(Model model) {
         List<Product> products = productService.findAll();
         model.addAttribute("products",products);
         return "product-list";
    }

    @GetMapping("/product-create")
    public String createProductForm(Product product) {
        return "product-create";

    }

    @PostMapping("/product-create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";

    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("product-delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
