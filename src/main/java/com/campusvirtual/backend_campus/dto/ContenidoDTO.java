package com.campusvirtual.backend_campus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContenidoDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer idCurso;
    private Integer idContenidoPadre;
    private List<Integer> archivosIds;

}

