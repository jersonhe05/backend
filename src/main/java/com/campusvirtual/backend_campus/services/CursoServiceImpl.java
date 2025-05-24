package com.campusvirtual.backend_campus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusvirtual.backend_campus.dto.CursoDTO;
import com.campusvirtual.backend_campus.entity.Curso;
import com.campusvirtual.backend_campus.mapper.CursoMapper;
import com.campusvirtual.backend_campus.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;

    @Override
    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        Curso curso = cursoMapper.toEntity(cursoDTO);
        return cursoMapper.toDto(cursoRepository.save(curso));
    }

    @Override
    public CursoDTO obtenerCursoPorId(Integer id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        return cursoMapper.toDto(curso);
    }

    @Override
    public List<CursoDTO> listarCursos() {
        return cursoRepository.findAll().stream()
                .map(cursoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CursoDTO actualizarCurso(Integer id, CursoDTO cursoDTO) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        curso.setNombre(cursoDTO.getNombre());
        curso.setGrupo(cursoDTO.getGrupo());
        curso.setCarrera(cursoDTO.getCarrera());

        return cursoMapper.toDto(cursoRepository.save(curso));
    }

    @Override
    public void eliminarCurso(Integer id) {
        cursoRepository.deleteById(id);
    }
}