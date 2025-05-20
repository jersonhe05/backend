package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "respuestas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrespuesta")
    private Integer id;

    @Column(name = "respuesta", length = 45)
    private String respuesta;

    @Column(name = "es_correcta")
    private Short esCorrecta;

    @ManyToOne
    @JoinColumn(name = "idpregunta", nullable = false)
    private Pregunta pregunta;
}
