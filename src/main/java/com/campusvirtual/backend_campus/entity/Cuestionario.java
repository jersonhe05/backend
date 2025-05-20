package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "cuestionarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuestionario")
    private Integer id;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_limite")
    private LocalDateTime fechaLimite;

    @Column(name = "tiempo_disponible")
    private LocalTime tiempoDisponible;

    @ManyToOne
    @JoinColumn(name = "idcurso", nullable = false)
    private Curso curso;
}