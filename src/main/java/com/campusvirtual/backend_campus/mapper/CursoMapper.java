package com.campusvirtual.backend_campus.mapper;

import com.campusvirtual.backend_campus.dto.CursoDTO;
import com.campusvirtual.backend_campus.entity.Curso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoDTO toDto(Curso curso);

    Curso toEntity(CursoDTO cursoDTO);
}
