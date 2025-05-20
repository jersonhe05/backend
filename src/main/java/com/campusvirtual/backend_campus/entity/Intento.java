package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "intentos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Intento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_finalizacion", nullable = false)
    private LocalDateTime fechaFinalizacion;

    @Column(name = "calificacion", precision = 50)
    private Double calificacion;

    @Column(name = "comentarios", length = 45)
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idcuestionario", nullable = false)
    private Cuestionario cuestionario;
}
