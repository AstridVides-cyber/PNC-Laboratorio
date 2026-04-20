package com.example.laboratorio_1.common;

import com.example.laboratorio_1.domain.entitie.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductList {
    private final List<Product> products;

    public ProductList() {
        this.products = new ArrayList<>();

        this.products.add(Product.builder()
                .id(1L)
                .nombre("Pollo")
                .categoria("Comida")
                .precio(85)
                .direccion("Volcán de Eldin")
                .rareza("Raro")
                .build());

        this.products.add(Product.builder()
                .id(2L)
                .nombre("Diamante")
                .categoria("Mineral")
                .precio(15)
                .direccion("Volcán de Eldin")
                .rareza("Poco Común")
                .build());

        this.products.add(Product.builder()
                .id(3L)
                .nombre("Tiburon")
                .categoria("Parte de Monstruo")
                .precio(10)
                .direccion("Cordillera de Hebra")
                .rareza("Legendario")
                .build());

        this.products.add(Product.builder()
                .id(4L)
                .nombre("Flor princesa")
                .categoria("Planta")
                .precio(5)
                .direccion("Desierto Gerudo")
                .rareza("Común")
                .build());
    }

    public List<Product> getProducts() {
        return products;
    }
}

