package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.dto.AsignacionDTO;
import com.campusvirtual.backend_campus.entity.Asignacion;
import com.campusvirtual.backend_campus.mapper.AsignacionMapper;
import com.campusvirtual.backend_campus.repository.AsignacionRepository;
import com.campusvirtual.backend_campus.services.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignacionServiceImpl implements AsignacionService {

    private final AsignacionRepository asignacionRepository;
    private final AsignacionMapper asignacionMapper;

    @Autowired
    public AsignacionServiceImpl(AsignacionRepository asignacionRepository, AsignacionMapper asignacionMapper) {
        this.asignacionRepository = asignacionRepository;
        this.asignacionMapper = asignacionMapper;
    }

    @Override
    public List<AsignacionDTO> getAllAsignaciones() {
        return asignacionRepository.findAll()
                .stream()
                .map(asignacionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AsignacionDTO> getAsignacionById(Integer id) {
        return asignacionRepository.findById(id)
                .map(asignacionMapper::toDto);
    }

    @Override
    public AsignacionDTO createAsignacion(AsignacionDTO asignacionDto) {
        Asignacion asignacion = asignacionMapper.toEntity(asignacionDto);
        Asignacion saved = asignacionRepository.save(asignacion);
        return asignacionMapper.toDto(saved);
    }

    @Override
    public AsignacionDTO updateAsignacion(Integer id, AsignacionDTO asignacionDto) {
        Optional<Asignacion> optionalAsignacion = asignacionRepository.findById(id);
        if (optionalAsignacion.isEmpty()) {
            throw new RuntimeException("Asignacion no encontrada con id " + id);
        }

        Asignacion asignacionToUpdate = optionalAsignacion.get();
        // Actualizar campos (podrías usar mapper con @MappingTarget también)
        asignacionToUpdate.setTitulo(asignacionDto.getTitulo());
        asignacionToUpdate.setDescripcion(asignacionDto.getDescripcion());
        asignacionToUpdate.setEstado(asignacionDto.getEstado());
        asignacionToUpdate.setFechaInicio(asignacionDto.getFechaInicio());
        asignacionToUpdate.setFechaLimite(asignacionDto.getFechaLimite());
        asignacionToUpdate.setCalificacion(asignacionDto.getCalificacion());
        
        // Actualizar curso solo por id
        if (asignacionDto.getIdCurso() != null) {
            // Solo seteamos el id del curso, asumiendo que existe
            // Idealmente deberías validar que ese curso existe antes
            asignacionToUpdate.getCurso().setId(asignacionDto.getIdCurso());
        }

        Asignacion updated = asignacionRepository.save(asignacionToUpdate);
        return asignacionMapper.toDto(updated);
    }

    @Override
    public void deleteAsignacion(Integer id) {
        asignacionRepository.deleteById(id);
    }
}

