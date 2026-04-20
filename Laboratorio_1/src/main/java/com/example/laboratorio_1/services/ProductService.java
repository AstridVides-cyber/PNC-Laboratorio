package com.example.laboratorio_1.services;

import com.example.laboratorio_1.domain.entitie.Product;
import com.example.laboratorio_1.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProduct(){
        return  productRepository.getProducts();
    }


}

