package com.campusvirtual.backend_campus.repository;

import com.campusvirtual.backend_campus.entity.Cadena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadenaRepository extends JpaRepository<Cadena, Integer> {
}
