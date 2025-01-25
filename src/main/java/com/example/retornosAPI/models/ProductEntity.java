package com.example.retornosAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.NoSuchElementException;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome do produto deve ter entre 3 e 100 caracteres.")
    private String name;

    @Size(max = 500, message = "A descrição do produto deve ter no máximo 500 caracteres.")
    private String description;

    @DecimalMin(value = "0.00", inclusive = false, message = "O preço do produto deve ser maior que zero")
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @Min(value = 0, message = "A quantidade do produto em estoque deve ser um número maior ou igual a zero.")
    private int stockQuantity;

    @NotNull(message = "A Categoria do produto é obrigatória e não foi encontrada.")
    @Enumerated(EnumType.STRING)
    private Category category;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, Double price, @NotBlank(message = "A categoria do produto é obrigatória.") String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        setCategory(category);
        // this.category = Category.searchCategory(category)
        //         .orElseThrow(() -> new NoSuchElementException("A categoria do produto não foi encontrada."));
        // Criar um manipulador global de exceções
        //A @ControllerAdvice
        // @ExceptionHandler(CategoryNotFoundException.class)

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = Category.searchCategory(category)
                .orElseThrow(() -> new NoSuchElementException("A categoria do produto não foi encontrada."));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getCategoryDescription() {
        return category.getDescription();
    }
}