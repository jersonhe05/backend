package com.campusvirtual.backend_campus.services;

import com.campusvirtual.backend_campus.entity.Usuario;

public interface UsuarioService {
    Usuario getUsuarioByCorreo(String correo);
}
