package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "profesores")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Profesor extends Usuario {

    @OneToMany(targetEntity = Curso.class, mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Curso> cursos;


}
