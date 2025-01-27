package com.example.retornosAPI.models;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String category
) {
}