package com.erzan.first_spring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String name;
    
    private Double price;

    private Long userId;
}
