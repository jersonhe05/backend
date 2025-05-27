package com.campusvirtual.backend_campus.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "foros")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Foro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idforos;

    @Column(length = 255)
    private String titulo;

    @Column(length = 1000)
    private String descripcion;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}
