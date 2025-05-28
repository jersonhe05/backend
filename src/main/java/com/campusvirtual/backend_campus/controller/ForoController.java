package com.campusvirtual.backend_campus.controller;

import com.campusvirtual.backend_campus.dto.ForoDTO;
import com.campusvirtual.backend_campus.services.ForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foros")
@CrossOrigin(origins = "http://localhost:5173")
public class ForoController {

    @Autowired
    private ForoService foroService;

    @PostMapping
    public ForoDTO crearForo(@RequestBody ForoDTO foroDTO) {
        return foroService.crearForo(foroDTO);
    }

    @GetMapping("/{id}")
    public ForoDTO obtenerForo(@PathVariable Integer id) {
        return foroService.obtenerForoPorId(id);
    }

    @GetMapping
    public List<ForoDTO> listarForos() {
        return foroService.listarForos();
    }

    @DeleteMapping("/{id}")
    public void eliminarForo(@PathVariable Integer id) {
        foroService.eliminarForo(id);
    }
}

