package com.example.laboratorio_1.repositories;

import com.example.laboratorio_1.common.ProductList;
import com.example.laboratorio_1.domain.entitie.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final ProductList productList;

    public List<Product> getProducts() {
        return productList.getProducts();
    }
}

