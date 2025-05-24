package com.campusvirtual.backend_campus.controller;

import com.campusvirtual.backend_campus.dto.CursoDTO;
import com.campusvirtual.backend_campus.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public CursoDTO crearCurso(@RequestBody CursoDTO cursoDTO) {
        return cursoService.crearCurso(cursoDTO);
    }

    @GetMapping("/{id}")
    public CursoDTO obtenerCurso(@PathVariable Integer id) {
        return cursoService.obtenerCursoPorId(id);
    }

    @GetMapping
    public List<CursoDTO> listarCursos() {
        return cursoService.listarCursos();
    }

    @PutMapping("/{id}")
    public CursoDTO actualizarCurso(@PathVariable Integer id, @RequestBody CursoDTO cursoDTO) {
        return cursoService.actualizarCurso(id, cursoDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Integer id) {
        cursoService.eliminarCurso(id);
    }
}

