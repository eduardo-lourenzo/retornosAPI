package com.example.retornosAPI.models;

public record ProductDTO(
        Long id,
        String name,
        String description,
        Double price,
        String category
) {
}