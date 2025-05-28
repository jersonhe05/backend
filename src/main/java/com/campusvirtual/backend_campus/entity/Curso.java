package com.campusvirtual.backend_campus.entity;

import com.campusvirtual.backend_campus.entity.util.Profesor;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 20)
    private String grupo;

    @Column(length = 100)
    private String carrera;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @Column(length = 255)
    private String descripcion;

    //El curso tiene muchas matriculas y cada matricula tiene curso y alumno
    @OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas;

}
