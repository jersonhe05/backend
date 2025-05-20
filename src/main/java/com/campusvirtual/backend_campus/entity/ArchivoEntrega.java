package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "archivos_entrega")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchivoEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarchivos_entrega")
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "url", length = 45, nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "identrega", nullable = false)
    private Entrega entrega;
}
