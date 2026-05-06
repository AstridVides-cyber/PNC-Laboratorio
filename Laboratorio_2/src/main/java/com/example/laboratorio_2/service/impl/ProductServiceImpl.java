package com.example.laboratorio_2.service.impl;

import com.example.laboratorio_2.domain.enttity.Product;
import com.example.laboratorio_2.repository.ProductRepository;
import com.example.laboratorio_2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
