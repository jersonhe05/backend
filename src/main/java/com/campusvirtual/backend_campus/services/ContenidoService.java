package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.dto.ContenidoDTO;

import java.util.List;

public interface ContenidoService {
    ContenidoDTO obtenerContenidoPorId(Integer id);
    ContenidoDTO crearContenido(ContenidoDTO contenidoDTO);
    ContenidoDTO actualizarContenido(Integer id, ContenidoDTO contenidoDTO);
    void eliminarContenido(Integer id);
    List<ContenidoDTO> obtenerTodosLosContenidos();
}

