package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignacion")
    private Integer id;

    @Column(name = "titulo", length = 45)
    private String titulo;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 255)
    private EstadoAsignacion estado;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_limite")
    private LocalDateTime fechaLimite;

    @Column(name = "calificacion")
    private float calificacion;

    @ManyToOne
    @JoinColumn(name = "idcurso", nullable = false)
    private Curso curso;


    public enum EstadoAsignacion {
    PENDIENTE,
    ENTREGADO,
    CALIFICADO
 }
}
