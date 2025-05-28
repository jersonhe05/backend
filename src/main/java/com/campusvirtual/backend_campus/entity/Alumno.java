package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "alumnos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alumno extends  Usuario {

    //cursos matriculados
    @OneToMany(mappedBy = "alumno")
    private List<Matricula> matriculas;

    //Entregas realizadas
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrega> entregas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cadena> cadenas;
}
