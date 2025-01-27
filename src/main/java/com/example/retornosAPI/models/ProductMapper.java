package com.example.retornosAPI.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public final class ProductMapper {

    public static ProductEntity fromDtoToEntity(@Valid ProductDTO dto) {
        return new ProductEntity(
                null,
                dto.name(),
                dto.description(),
                dto.price(),
                dto.category()
        );
    }

    public static ProductDTO fromEntityToDto(ProductEntity entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCategoryDescription()
        );
    }
}
