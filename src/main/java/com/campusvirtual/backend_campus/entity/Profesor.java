package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "profesores")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profesor extends Usuario {

    @OneToMany(targetEntity = Profesor.class, mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Curso> cursos;


}
