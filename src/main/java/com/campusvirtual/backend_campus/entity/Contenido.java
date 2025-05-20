package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contenidos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontenido")
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "descripcion", length = 45)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idcurso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idcontenido_padre")
    private Contenido contenidoPadre;
}