package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "archivos_contenidos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchivoContenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarchivos_contenido")
    private Integer id;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "url", length = 45, nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "contenidos_idcontenido", nullable = false)
    private Contenido contenido;
}
