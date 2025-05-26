package com.campusvirtual.backend_campus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CursoDTO {
    private Integer id;
    private String nombre;
    private String grupo;
    private String carrera;
    private String profesor;
    private String descripcion;
}