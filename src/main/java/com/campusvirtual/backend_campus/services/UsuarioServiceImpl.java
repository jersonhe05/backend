package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.entity.Usuario;
import com.campusvirtual.backend_campus.exception.UsuarioNotFoundException;
import com.campusvirtual.backend_campus.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario getUsuarioByCorreo(String correo) {
        return usuarioRepository.findByCorreoEqualsIgnoreCase(correo)
                .orElseThrow(() -> new UsuarioNotFoundException("Error al obtener el usuario con correo "+correo));
    }
}
