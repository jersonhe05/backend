package com.campusvirtual.backend_campus.mapper;

import com.campusvirtual.backend_campus.dto.ContenidoDTO;
import com.campusvirtual.backend_campus.entity.Archivo;
import com.campusvirtual.backend_campus.entity.Contenido;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ContenidoMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "descripcion", target = "descripcion"),
        @Mapping(source = "curso.id", target = "idCurso"),
        @Mapping(source = "contenidoPadre.id", target = "idContenidoPadre"),
        @Mapping(source = "archivos", target = "archivosIds")
    })
    public abstract ContenidoDTO toContenidoDTO(Contenido contenido);

    public abstract List<ContenidoDTO> toContenidoDTOList(List<Contenido> contenidos);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "descripcion", target = "descripcion"),
        @Mapping(source = "idCurso", target = "curso.id"),
        @Mapping(source = "idContenidoPadre", target = "contenidoPadre.id"),
        @Mapping(target = "archivos", ignore = true) 
    })
    public abstract Contenido toContenido(ContenidoDTO contenidoDTO);

    protected List<Integer> map(List<Archivo> archivos) {
        if (archivos == null) return null;
        return archivos.stream()
                .map(Archivo::getId)
                .map(Long::intValue)
                .collect(Collectors.toList());
    }
}
