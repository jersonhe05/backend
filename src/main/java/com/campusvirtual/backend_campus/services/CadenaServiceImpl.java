package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.dto.CadenaDTO;
import com.campusvirtual.backend_campus.entity.Cadena;
import com.campusvirtual.backend_campus.entity.Foro;
import com.campusvirtual.backend_campus.entity.Usuario;
import com.campusvirtual.backend_campus.mapper.CadenaMapper;
import com.campusvirtual.backend_campus.repository.CadenaRepository;
import com.campusvirtual.backend_campus.repository.ForoRepository;
import com.campusvirtual.backend_campus.repository.UsuarioRepository;
import com.campusvirtual.backend_campus.services.CadenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadenaServiceImpl implements CadenaService {

    @Autowired
    private CadenaRepository cadenaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ForoRepository foroRepository;

    @Autowired
    private CadenaMapper cadenaMapper;

    @Override
    public CadenaDTO guardar(CadenaDTO cadenaDTO) {
        Usuario usuario = usuarioRepository.findById(cadenaDTO.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Foro foro = foroRepository.findById(cadenaDTO.getIdForo())
                .orElseThrow(() -> new RuntimeException("Foro no encontrado"));

        Cadena cadena = Cadena.builder()
                .id(cadenaDTO.getId())
                .titulo(cadenaDTO.getTitulo())
                .contenido(cadenaDTO.getContenido())
                .usuario(usuario)
                .foro(foro)
                .build();

        return cadenaMapper.toCadenaDTO(cadenaRepository.save(cadena));
    }

    @Override
    public CadenaDTO obtenerPorId(Integer id) {
        Cadena cadena = cadenaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cadena no encontrada"));
        return cadenaMapper.toCadenaDTO(cadena);
    }

    @Override
    public List<CadenaDTO> obtenerTodas() {
        return cadenaMapper.toCadenaDTOList(cadenaRepository.findAll());
    }

    @Override
    public void eliminar(Integer id) {
        cadenaRepository.deleteById(id);
    }
}
