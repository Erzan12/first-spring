package com.erzan.first_spring.repository;

import com.erzan.first_spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
