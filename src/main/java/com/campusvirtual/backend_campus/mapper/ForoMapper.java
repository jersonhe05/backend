package com.campusvirtual.backend_campus.mapper;

import com.campusvirtual.backend_campus.dto.ForoDTO;
import com.campusvirtual.backend_campus.entity.Foro;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ForoMapper {

    @Mapping(source = "curso.nombre", target = "nombreCurso")
    @Mapping(source = "curso.id", target = "cursoId")
    ForoDTO toDto(Foro foro);

    @InheritInverseConfiguration
    @Mapping(target = "curso", ignore = true) // Se asigna manualmente en el service
    Foro toEntity(ForoDTO foroDTO);
}
