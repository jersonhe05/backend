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
public class ArchivoAsignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "archivos_asignacion")
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "url", length = 45, nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "idasignacion", nullable = false)
    private Asignacion asignacion;
}
