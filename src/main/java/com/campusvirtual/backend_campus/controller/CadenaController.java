package com.campusvirtual.backend_campus.controller;

import com.campusvirtual.backend_campus.dto.CadenaDTO;
import com.campusvirtual.backend_campus.services.CadenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cadenas")
public class CadenaController {

    @Autowired
    private CadenaService cadenaService;

    @PostMapping
    public CadenaDTO crearCadena(@RequestBody CadenaDTO cadenaDTO) {
        return cadenaService.guardar(cadenaDTO);
    }

    @GetMapping("/{id}")
    public CadenaDTO obtenerCadena(@PathVariable Integer id) {
        return cadenaService.obtenerPorId(id);
    }

    @GetMapping
    public List<CadenaDTO> obtenerTodasLasCadenas() {
        return cadenaService.obtenerTodas();
    }

    @DeleteMapping("/{id}")
    public void eliminarCadena(@PathVariable Integer id) {
        cadenaService.eliminar(id);
    }
}
