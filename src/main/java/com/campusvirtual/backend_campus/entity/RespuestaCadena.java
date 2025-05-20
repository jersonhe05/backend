package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "respuestas_cadenas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaCadena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrespuesta")
    private Integer id;

    @Column(name = "titulo", length = 45)
    private String titulo;

    @Column(name = "cuerpo", length = 45)
    private String cuerpo;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idcadena", nullable = false)
    private Cadena cadena;

    @ManyToOne
    @JoinColumn(name = "idrespuesta_padre")
    private RespuestaCadena respuestaPadre;
}
