package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.dto.ForoDTO;

import java.util.List;

public interface ForoService {
    ForoDTO crearForo(ForoDTO foroDTO);
    ForoDTO obtenerForoPorId(Integer id);
    List<ForoDTO> listarForos();
    void eliminarForo(Integer id);
}