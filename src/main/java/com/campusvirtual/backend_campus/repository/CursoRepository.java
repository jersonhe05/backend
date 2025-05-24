package com.campusvirtual.backend_campus.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.campusvirtual.backend_campus.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
   
}
