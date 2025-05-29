package com.campusvirtual.backend_campus.controller;

import com.campusvirtual.backend_campus.dto.ContenidoDTO;
import com.campusvirtual.backend_campus.services.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {

    private final ContenidoService contenidoService;

    @Autowired
    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContenidoDTO> obtenerContenido(@PathVariable Integer id) {
        ContenidoDTO contenidoDTO = contenidoService.obtenerContenidoPorId(id);
        return new ResponseEntity<>(contenidoDTO, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ContenidoDTO>> obtenerTodosLosContenidos() {
        List<ContenidoDTO> contenidoDTOs = contenidoService.obtenerTodosLosContenidos();  // Llama al servicio
        return new ResponseEntity<>(contenidoDTOs, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ContenidoDTO> crearContenido(@RequestBody ContenidoDTO contenidoDTO) {
        ContenidoDTO creado = contenidoService.crearContenido(contenidoDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContenidoDTO> actualizarContenido(@PathVariable Integer id, @RequestBody ContenidoDTO contenidoDTO) {
        ContenidoDTO actualizado = contenidoService.actualizarContenido(id, contenidoDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContenido(@PathVariable Integer id) {
        contenidoService.eliminarContenido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

