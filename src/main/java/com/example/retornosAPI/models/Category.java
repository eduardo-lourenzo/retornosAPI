package com.example.retornosAPI.models;

import java.util.Optional;
import java.util.stream.Stream;

public enum Category {
    ACCESSORIES("Acessórios"),
    APPLIANCES("Eletrodomésticos"),
    AUTOMOTIVE("Automotivo"),
    BEAUTY("Beleza"),
    BOOKS("Livros"),
    CLEANING("Limpeza"),
    CLOTHING("Roupas"),
    CONSTRUCTION("Construção"),
    DECORATION("Decoração"),
    DRINKS("Bebidas"),
    ELECTRONICS("Eletrônicos"),
    FOOD("Alimentos"),
    FURNITURE("Móveis"),
    GAMES("Jogos"),
    HEALTH("Saúde"),
    HYGIENE("Higiene"),
    IT("Informática"),
    LEISURE("Lazer"),
    MOVIES("Filmes"),
    MUSIC("Músicas"),
    SPORTS("Esportes"),
    STATIONERY("Papelaria"),
    TOOLS("Ferramentas"),
    TOYS("Brinquedos"),
    TRAVEL("Viagem"),
    UTILITIES("Utilidades");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Optional<Category> searchCategory(String description) {
        return Stream.of(Category.values())
                .filter(
                        category -> category.getDescription().equalsIgnoreCase(description)
                ).findAny();
    }
}
