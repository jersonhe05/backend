package com.campusvirtual.backend_campus.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForoDTO {
    private Integer idforos;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaPublicacion;
    private Integer cursoId;      
    private String nombreCurso;   
}
