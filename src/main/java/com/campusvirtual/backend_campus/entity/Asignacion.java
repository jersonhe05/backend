package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "asignaciones")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignacion")
    private Integer id;

    @Column(name = "titulo", length = 45)
    private String titulo;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_limite")
    private LocalDateTime fechaLimite;

    @ManyToOne
    @JoinColumn(name = "idcurso", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "asignacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Archivo> archivos;
}
