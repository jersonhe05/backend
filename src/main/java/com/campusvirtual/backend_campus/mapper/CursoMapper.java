package com.campusvirtual.backend_campus.mapper;

import com.campusvirtual.backend_campus.dto.CursoDTO;
import com.campusvirtual.backend_campus.entity.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mapping(target = "idProfesor", source = "profesor.id")
    CursoDTO toDto(Curso curso);

    Curso toEntity(CursoDTO cursoDTO);
}
