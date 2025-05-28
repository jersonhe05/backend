package com.campusvirtual.backend_campus.controller;

import com.campusvirtual.backend_campus.dto.AsignacionDTO;
import com.campusvirtual.backend_campus.services.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    private final AsignacionService asignacionService;

    @Autowired
    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping
    public ResponseEntity<List<AsignacionDTO>> getAllAsignaciones() {
        List<AsignacionDTO> asignaciones = asignacionService.getAllAsignaciones();
        return ResponseEntity.ok(asignaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionDTO> getAsignacionById(@PathVariable Integer id) {
        return asignacionService.getAsignacionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AsignacionDTO> createAsignacion(@RequestBody AsignacionDTO asignacionDto) {
        AsignacionDTO created = asignacionService.createAsignacion(asignacionDto);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionDTO> updateAsignacion(@PathVariable Integer id, @RequestBody AsignacionDTO asignacionDto) {
        try {
            AsignacionDTO updated = asignacionService.updateAsignacion(id, asignacionDto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignacion(@PathVariable Integer id) {
        asignacionService.deleteAsignacion(id);
        return ResponseEntity.noContent().build();
    }
}

