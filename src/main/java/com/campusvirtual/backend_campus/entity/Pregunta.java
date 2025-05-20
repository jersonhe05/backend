package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "preguntas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpregunta")
    private Integer id;

    @Column(name = "pregunta", length = 45)
    private String pregunta;

    @ManyToOne
    @JoinColumn(name = "idcuestionario", nullable = false)
    private Cuestionario cuestionario;
}
