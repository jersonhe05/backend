package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.dto.AsignacionDTO;
import java.util.List;
import java.util.Optional;

public interface AsignacionService {

    List<AsignacionDTO> getAllAsignaciones();

    Optional<AsignacionDTO> getAsignacionById(Integer id);

    AsignacionDTO createAsignacion(AsignacionDTO asignacionDto);

    AsignacionDTO updateAsignacion(Integer id, AsignacionDTO asignacionDto);

    void deleteAsignacion(Integer id);
}

