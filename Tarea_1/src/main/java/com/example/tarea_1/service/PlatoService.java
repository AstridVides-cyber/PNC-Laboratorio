package com.example.tarea_1.service;

import com.example.tarea_1.dto.PlatoRequestDTO;
import com.example.tarea_1.dto.PlatoResponseDTO;

import java.util.List;

public interface PlatoService {

    // Crear un nuevo plato
    PlatoResponseDTO crear(PlatoRequestDTO request);

    // Obtener todos los platos
    List<PlatoResponseDTO> obtenerTodos();

    // Obtener un plato por su ID
    PlatoResponseDTO obtenerPorId(Long id);

    // Actualizar un plato existente
    PlatoResponseDTO actualizar(Long id, PlatoRequestDTO request);

    // Eliminar un plato por su ID
    void eliminar(Long id);

}
