package com.campusvirtual.backend_campus.services;

import java.util.List;
import java.util.stream.Collectors;

import com.campusvirtual.backend_campus.entity.Profesor;
import com.campusvirtual.backend_campus.exception.UsuarioNotFoundException;
import com.campusvirtual.backend_campus.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusvirtual.backend_campus.dto.CursoDTO;
import com.campusvirtual.backend_campus.entity.Curso;
import com.campusvirtual.backend_campus.mapper.CursoMapper;
import com.campusvirtual.backend_campus.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    private final ProfesorRepository profesorRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository, CursoMapper cursoMapper, ProfesorRepository profesorRepository) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        Curso curso = cursoMapper.toEntity(cursoDTO);
        Curso cursoGuardado = cursoRepository.save(curso);
        return cursoMapper.toDto(cursoGuardado);
    }

    @Override
    public CursoDTO obtenerCursoPorId(Integer id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
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
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));

        Profesor profesor = profesorRepository.findById(cursoDTO.getIdProfesor())
                        .orElseThrow(() -> new UsuarioNotFoundException("profesor not found"));

        curso.setNombre(cursoDTO.getNombre());
        curso.setGrupo(cursoDTO.getGrupo());
        curso.setCarrera(cursoDTO.getCarrera());
        curso.setProfesor(profesor);
        curso.setDescripcion(cursoDTO.getDescripcion());

        Curso cursoActualizado = cursoRepository.save(curso);
        return cursoMapper.toDto(cursoActualizado);
    }

    @Override
    public void eliminarCurso(Integer id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Curso no encontrado con ID: " + id);
        }
        cursoRepository.deleteById(id);
    }
}
