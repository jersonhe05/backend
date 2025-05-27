package com.campusvirtual.backend_campus.repository;

import com.campusvirtual.backend_campus.entity.Foro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForoRepository extends JpaRepository<Foro, Integer> {
}

