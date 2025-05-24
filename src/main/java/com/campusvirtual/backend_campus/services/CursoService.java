package com.campusvirtual.backend_campus.services;

import java.util.List;

import com.campusvirtual.backend_campus.dto.CursoDTO;

public interface CursoService {
    CursoDTO crearCurso(CursoDTO cursoDTO);
    CursoDTO obtenerCursoPorId(Integer id);
    List<CursoDTO> listarCursos();
    CursoDTO actualizarCurso(Integer id, CursoDTO cursoDTO);
    void eliminarCurso(Integer id);
}
