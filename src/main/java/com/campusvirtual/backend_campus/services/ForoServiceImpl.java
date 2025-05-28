package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.dto.ForoDTO;
import com.campusvirtual.backend_campus.entity.Curso;
import com.campusvirtual.backend_campus.entity.Foro;
import com.campusvirtual.backend_campus.mapper.ForoMapper;
import com.campusvirtual.backend_campus.repository.CursoRepository;
import com.campusvirtual.backend_campus.repository.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForoServiceImpl implements ForoService {

    @Autowired
    private ForoRepository foroRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ForoMapper foroMapper;

    @Override
    public ForoDTO crearForo(ForoDTO foroDTO) {
        Curso curso = cursoRepository.findById(foroDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + foroDTO.getCursoId()));

        Foro foro = foroMapper.toEntity(foroDTO);
        foro.setCurso(curso);

        Foro guardado = foroRepository.save(foro);
        return foroMapper.toDto(guardado);
    }

    @Override
    public ForoDTO obtenerForoPorId(Integer id) {
        Foro foro = foroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foro no encontrado con id: " + id));
        return foroMapper.toDto(foro);
    }

    @Override
    public List<ForoDTO> listarForos() {
        return foroRepository.findAll()
                .stream()
                .map(foroMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarForo(Integer id) {
        if (!foroRepository.existsById(id)) {
            throw new RuntimeException("No existe foro con id: " + id);
        }
        foroRepository.deleteById(id);
    }
}
