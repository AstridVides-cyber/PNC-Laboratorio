package com.example.laboratorio_2.service.impl;

import com.example.laboratorio_2.domain.enttity.Product;
import com.example.laboratorio_2.repository.ProductRepository;
import com.example.laboratorio_2.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllSorcerers() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getSorcererById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateSorcerer(UUID id, Product updated) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hechicero no encontrado: " + id));

        existing.setName(updated.getName());
        existing.setGrade(updated.getGrade());
        existing.setCursedTechnique(updated.getCursedTechnique());
        existing.setSchool(updated.getSchool());
        existing.setCursedEnergy(updated.getCursedEnergy());
        existing.setIsActive(updated.getIsActive());

        return productRepository.save(existing);
    }

    @Override
    public List<Product> getBySchool(String school) {
        return productRepository.findAll().stream()
                .filter(p -> p.getSchool().equalsIgnoreCase(school))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getByGrade(String grade) {
        return productRepository.findAll().stream()
                .filter(p -> p.getGrade().equalsIgnoreCase(grade))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getActiveSorcerers() {
        return productRepository.findAll().stream()
                .filter(p -> Boolean.TRUE.equals(p.getIsActive()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
