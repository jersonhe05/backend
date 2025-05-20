package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "respuestas_seleccionadas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaSeleccionada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrespuestas_seleccionada")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idrespuesta", nullable = false)
    private Respuesta respuesta;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;
}

