package com.example.tarea_1.service.Impl;

import com.example.tarea_1.damain.entity.Plato;
import com.example.tarea_1.dto.PlatoRequestDTO;
import com.example.tarea_1.dto.PlatoResponseDTO;
import com.example.tarea_1.repository.PlatoRepository;
import com.example.tarea_1.service.PlatoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements PlatoService {

    // automáticamente para inyectar el repository
    private final PlatoRepository platoRepository;

    @Override
    public PlatoResponseDTO crear(PlatoRequestDTO request) {
        // Convertimos el DTO a entidad para guardarlo en la BD
        Plato plato = Plato.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .disponible(request.getDisponible())
                .build();

        // Guardamos en la BD y convertimos el resultado a ResponseDTO
        Plato guardado = platoRepository.save(plato);
        return convertirAResponseDTO(guardado);
    }

    @Override
    public List<PlatoResponseDTO> obtenerTodos() {
        // Obtenemos todos los platos y los convertimos a ResponseDTO
        return platoRepository.findAll()
                .stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlatoResponseDTO obtenerPorId(Long id) {
        // Buscamos el plato, si no existe lanzamos una excepcion
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plato no encontrado con ID: " + id));

        return convertirAResponseDTO(plato);
    }

    @Override
    public PlatoResponseDTO actualizar(Long id, PlatoRequestDTO request) {
        // Verificamos que el plato existe antes de actualizar
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plato no encontrado con ID: " + id));

        // Actualizamos los campos con los nuevos valores
        plato.setNombre(request.getNombre());
        plato.setDescripcion(request.getDescripcion());
        plato.setPrecio(request.getPrecio());
        plato.setDisponible(request.getDisponible());

        // Guardamos los cambios y retornamos el ResponseDTO
        Plato actualizado = platoRepository.save(plato);
        return convertirAResponseDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        // Verificamos que existe antes de eliminar
        if (!platoRepository.existsById(id)) {
            throw new EntityNotFoundException("Plato no encontrado con ID: " + id);
        }
        platoRepository.deleteById(id);
    }

    // Entidad Plato a PlatoResponseDTO
    private PlatoResponseDTO convertirAResponseDTO(Plato plato) {
        return PlatoResponseDTO.builder()
                .id(plato.getId())
                .nombre(plato.getNombre())
                .descripcion(plato.getDescripcion())
                .precio(plato.getPrecio())
                .disponible(plato.getDisponible())
                .build();
    }

}