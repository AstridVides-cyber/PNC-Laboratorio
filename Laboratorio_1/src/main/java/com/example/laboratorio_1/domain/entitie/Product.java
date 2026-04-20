package com.example.laboratorio_1.domain.entitie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String nombre;
    private String categoria;
    private double precio;
    private String direccion;
    private String rareza;
}
