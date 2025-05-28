package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "archivos_asignaciones")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "url", length = 45, nullable = false)
    private String url;

    //relacion con asignacion
    @ManyToOne
    @JoinColumn(name = "id_asignacion", nullable = false)
    private Asignacion asignacion;

    //relacion con entrega
    @ManyToOne
    @JoinColumn(name = "id_entrega")
    private Entrega entrega;

    @ManyToOne
    @JoinColumn(name = "id_contenido")
    private Contenido contenido;
}
