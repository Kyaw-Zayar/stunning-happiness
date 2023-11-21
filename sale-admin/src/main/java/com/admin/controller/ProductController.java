package com.admin.controller;

import com.data.model.domain.entity.Product;
import com.data.model.repo.ProductRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping
    public String productPage(ModelMap model) {
        model.put("title", "Product List");
        model.put("products", productRepo.findAll());
        return "index";
    }

    @GetMapping("/manage-product")
    public String home(@ModelAttribute("productEntity") Product product,
                       @RequestParam(required = false) Optional<Long> id,
                       ModelMap model) {
        model.put("title", id.isPresent() ? "Update Product" : "Create Product");
        return "manage-product";
    }

    @PostMapping("/manage-product")
    public String manageProduct(@Valid @ModelAttribute("productEntity") Product product,
                                BindingResult bindingResult,
                                ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.put("title", product.getId() != null ? "Update Product" : "Create Product");
            return "manage-product";
        }

        productRepo.save(product);

        return "redirect:/";
    }

    @GetMapping("delete-product")
    public String deleteProduct(@RequestParam Long id) {
        productRepo.findById(id).ifPresent(value -> productRepo.delete(value));
        return "redirect:/";
    }

    @ModelAttribute("productEntity")
    public Product findProduct(@RequestParam(required = false) Optional<Long> id) {
        return id.map(aLong -> productRepo.findById(aLong).orElseGet(Product::new)).orElseGet(Product::new);
    }


}
