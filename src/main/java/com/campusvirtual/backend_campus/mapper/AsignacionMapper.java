package com.campusvirtual.backend_campus.mapper;

import com.campusvirtual.backend_campus.dto.AsignacionDTO;
import com.campusvirtual.backend_campus.entity.Asignacion;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AsignacionMapper {

    @Mapping(source = "curso.id", target = "idCurso")
    @Mapping(source = "curso.nombre", target = "nombreCurso")
    AsignacionDTO toDto(Asignacion asignacion);

    @Mapping(source = "idCurso", target = "curso.id")
    // No seteamos el nombreCurso porque es redundante para la entidad
    @Mapping(target = "curso.nombre", ignore = true)
    Asignacion toEntity(AsignacionDTO dto);
}

