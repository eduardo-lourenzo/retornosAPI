package com.example.retornosAPI.models;

public final class ProductMapper {

    public static ProductEntity fromDtoToEntity(ProductDTO dto) {
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
