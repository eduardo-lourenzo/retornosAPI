package com.example.retornosAPI.services;

import com.example.retornosAPI.models.ProductDTO;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.models.ProductMapper;
import com.example.retornosAPI.repositories.ProductRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity newEntity = ProductMapper.fromDtoToEntity(productDTO);

        ProductEntity savedEntity = repository.save(newEntity);

        return ProductMapper.fromEntityToDto(savedEntity);
    }

    public ProductDTO getProductById(Long id) {
        ProductEntity foundEntity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID:" + id + " não foi encontrado."));
        return ProductMapper.fromEntityToDto(foundEntity);
    }

    public List<ProductDTO> getAllProducts() {
        return repository.findAll().stream()
                .map(ProductMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long id) {
        ProductEntity foundEntity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID:" +id + " para deleção não foi encontrado."));

        repository.deleteById(id);
    }

    // Atualizar um produto existente
    public ProductDTO updateProduct(Long id, ProductDTO updatedProductDTO) {
        // Verificar se o produto existe
        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID:" + id + " para atualização não foi encontrado"));

        // Atualizar os dados do produto
        existingEntity.setName(updatedProductDTO.name());
        existingEntity.setDescription(updatedProductDTO.description());
        existingEntity.setPrice(updatedProductDTO.price());
        existingEntity.setCategory(updatedProductDTO.category());

        // Salvar as alterações no banco de dados
        ProductEntity savedEntity = repository.save(existingEntity);

        // Retornar o produto atualizado
        return ProductMapper.fromEntityToDto(savedEntity);
    }

    // Buscar produtos pelo nome
    public List<ProductDTO> getProductsByName(@NotBlank(message = "O nome do produto é obrigatório.") String name) {
        List<ProductEntity> entities = repository.findByNameContainingIgnoreCase(name);

        return entities.stream()
                .map(ProductMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }
}