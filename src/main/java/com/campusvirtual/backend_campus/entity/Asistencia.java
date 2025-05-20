package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "asistencias")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idasistencia;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario", nullable = false,
        foreignKey = @ForeignKey(name = "fk_asistencias_usuarios"))
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcurso", nullable = false,
        foreignKey = @ForeignKey(name = "fk_asistencias_cursos"))
    private Curso curso;
}