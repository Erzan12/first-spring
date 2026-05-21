package com.erzan.first_spring.service;

import com.erzan.first_spring.dto.ProductRequest;
import com.erzan.first_spring.entity.Product;
import com.erzan.first_spring.entity.User;
import com.erzan.first_spring.repository.ProductRepository;
import com.erzan.first_spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository,
                          UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Product createProduct(ProductRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .user(user)
                .build();

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Long id, ProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User user = userRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        product.setName((request.getName()));
        product.setPrice((request.getPrice()));
        product.setUser(user);

        return productRepository.save(product);
    }
}
