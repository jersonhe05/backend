package com.campusvirtual.backend_campus.repository;

import com.campusvirtual.backend_campus.entity.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Integer> {
    
}
