package com.campusvirtual.backend_campus.dto;

import com.campusvirtual.backend_campus.entity.Asignacion.EstadoAsignacion;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignacionDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private EstadoAsignacion estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaLimite;
    private float calificacion;
    private Integer idCurso;      
    private String nombreCurso;   
}
