package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.dto.CadenaDTO;

import java.util.List;

public interface CadenaService {
    CadenaDTO guardar(CadenaDTO cadenaDTO);
    CadenaDTO obtenerPorId(Integer id);
    List<CadenaDTO> obtenerTodas();
    void eliminar(Integer id);
}

