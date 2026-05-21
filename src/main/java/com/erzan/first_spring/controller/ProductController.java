package com.erzan.first_spring.controller;

import com.erzan.first_spring.dto.ProductRequest;
import com.erzan.first_spring.entity.Product;
import com.erzan.first_spring.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody ProductRequest request) {
        return productService.updateProduct(id, request);
    }
}
