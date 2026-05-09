package com.example.tarea_1.controller;

import java.util.List;
import com.example.tarea_1.dto.PlatoRequestDTO;
import com.example.tarea_1.dto.PlatoResponseDTO;
import com.example.tarea_1.service.PlatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/platos")
public class PlatoController {

    // Inyectamos el service para usarlo en los endpoints
    private final PlatoService platoService;

    // Crea un nuevo plato
    @PostMapping
    public ResponseEntity<PlatoResponseDTO> crear(@RequestBody PlatoRequestDTO request) {
        PlatoResponseDTO response = platoService.crear(request);
        // Retornamos 201 CREATED con el plato creado
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Obtiene todos los platos
    @GetMapping
    public ResponseEntity<List<PlatoResponseDTO>> obtenerTodos() {
        List<PlatoResponseDTO> response = platoService.obtenerTodos();
        // Retornamos 200 OK con la lista de platos
        return ResponseEntity.ok(response);
    }

    // Obtiene un plato por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PlatoResponseDTO> obtenerPorId(@PathVariable Long id) {
        PlatoResponseDTO response = platoService.obtenerPorId(id);
        // Retornamos 200 OK con el plato encontrado
        return ResponseEntity.ok(response);
    }

    // Actualiza un plato existente
    @PutMapping("/{id}")
    public ResponseEntity<PlatoResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody PlatoRequestDTO request) {
        PlatoResponseDTO response = platoService.actualizar(id, request);
        // Retornamos 200 OK con el plato actualizado
        return ResponseEntity.ok(response);
    }

    // Elimina un plato por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        platoService.eliminar(id);
        // Retornamos 204 NO CONTENT porque no hay nada que retornar
        return ResponseEntity.noContent().build();
    }
}
