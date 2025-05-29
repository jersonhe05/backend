package com.campusvirtual.backend_campus.repository;

import com.campusvirtual.backend_campus.entity.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {
    
}
