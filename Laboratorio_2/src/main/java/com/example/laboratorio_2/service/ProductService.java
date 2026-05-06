package com.example.laboratorio_2.service;

import com.example.laboratorio_2.domain.entity.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    void createProduct(Product product);
    List<Product> getAllSorcerers();
    Optional<Product> getSorcererById(UUID id);
    Product updateSorcerer(UUID id, Product product);
    List<Product> getBySchool(String school);
    List<Product> getByGrade(String grade);
    List<Product> getActiveSorcerers();
    void deleteProduct(UUID id);
}
