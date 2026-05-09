package com.example.tarea_1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlatoResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Boolean disponible;
}
