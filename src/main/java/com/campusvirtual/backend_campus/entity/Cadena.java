package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cadenas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cadena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcadena")
    private Integer id;

    @Column(name = "titulo", length = 45)
    private String titulo;

    @Column(name = "contenido", length = 200)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idforo", nullable = false)
    private Foro foro;

    @ManyToOne
    @JoinColumn(name = "idcadena_padre")
    private Cadena cadenaPadre;
}