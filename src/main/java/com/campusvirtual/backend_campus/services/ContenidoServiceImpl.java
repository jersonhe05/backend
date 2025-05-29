package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.dto.ContenidoDTO;
import com.campusvirtual.backend_campus.entity.Contenido;
import com.campusvirtual.backend_campus.mapper.ContenidoMapper;
import com.campusvirtual.backend_campus.repository.ContenidoRepository;
import com.campusvirtual.backend_campus.services.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoServiceImpl implements ContenidoService {

    private final ContenidoRepository contenidoRepository;
    private final ContenidoMapper contenidoMapper;

    @Autowired
    public ContenidoServiceImpl(ContenidoRepository contenidoRepository, ContenidoMapper contenidoMapper) {
        this.contenidoRepository = contenidoRepository;
        this.contenidoMapper = contenidoMapper;
    }

    @Override
    public ContenidoDTO obtenerContenidoPorId(Integer id) {
        Optional<Contenido> contenido = contenidoRepository.findById(id);
        return contenido.map(contenidoMapper::toContenidoDTO).orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
    }


    @Override
    public ContenidoDTO crearContenido(ContenidoDTO contenidoDTO) {
        Contenido contenido = contenidoMapper.toContenido(contenidoDTO);
        Contenido contenidoGuardado = contenidoRepository.save(contenido);
        return contenidoMapper.toContenidoDTO(contenidoGuardado);
    }

    @Override
    public ContenidoDTO actualizarContenido(Integer id, ContenidoDTO contenidoDTO) {
        if (!contenidoRepository.existsById(id)) {
            throw new RuntimeException("Contenido no encontrado");
        }
        Contenido contenido = contenidoMapper.toContenido(contenidoDTO);
        contenido.setId(id);
        Contenido contenidoActualizado = contenidoRepository.save(contenido);
        return contenidoMapper.toContenidoDTO(contenidoActualizado);
    }

    @Override
    public void eliminarContenido(Integer id) {
        if (!contenidoRepository.existsById(id)) {
            throw new RuntimeException("Contenido no encontrado");
        }
        contenidoRepository.deleteById(id);
    }

    @Override
    public List<ContenidoDTO> obtenerTodosLosContenidos() {
        List<Contenido> contenidos = contenidoRepository.findAll();  
        return contenidoMapper.toContenidoDTOList(contenidos);
    }
}

