package com.example.laboratorio_2.controller;

import com.example.laboratorio_2.domain.entity.Product;
import com.example.laboratorio_2.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    // create
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    // getAll
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAllSorcerers());
    }

    // getById
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable UUID id) {
        Optional<Product> product = productService.getSorcererById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable UUID id, @RequestBody Product product) {
        try {
            Product updated = productService.updateSorcerer(id, product);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // getBySchool
    @GetMapping("/school/{school}")
    public ResponseEntity<List<Product>> getBySchool(@PathVariable String school) {
        return ResponseEntity.ok(productService.getBySchool(school));
    }

    // getByGrade
    @GetMapping("/grade/{grade}")
    public ResponseEntity<List<Product>> getByGrade(@PathVariable String grade) {
        return ResponseEntity.ok(productService.getByGrade(grade));
    }

    // getActive
    @GetMapping("/active")
    public ResponseEntity<List<Product>> getActive() {
        return ResponseEntity.ok(productService.getActiveSorcerers());
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

