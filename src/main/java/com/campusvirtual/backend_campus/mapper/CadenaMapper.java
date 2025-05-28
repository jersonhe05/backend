package com.campusvirtual.backend_campus.mapper;

import com.campusvirtual.backend_campus.dto.CadenaDTO;
import com.campusvirtual.backend_campus.entity.Cadena;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CadenaMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "titulo", target = "titulo"),
        @Mapping(source = "contenido", target = "contenido"),
        @Mapping(source = "usuario.id", target = "idUsuario"),
        @Mapping(source = "foro.idforos", target = "idForo"),
        @Mapping(source = "cadenaPadre.id", target = "idCadenaPadre")
    })
    CadenaDTO toCadenaDTO(Cadena cadena);

    List<CadenaDTO> toCadenaDTOList(List<Cadena> cadenas);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "titulo", target = "titulo"),
        @Mapping(source = "contenido", target = "contenido"),
        @Mapping(source = "idUsuario", target = "usuario.id"),
        @Mapping(source = "idForo", target = "foro.idforos"),
        @Mapping(source = "idCadenaPadre", target = "cadenaPadre.id")
    })
    Cadena toCadena(CadenaDTO cadenaDTO);
}
