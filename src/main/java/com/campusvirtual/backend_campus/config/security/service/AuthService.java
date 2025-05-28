package com.campusvirtual.backend_campus.config.security.service;

import com.campusvirtual.backend_campus.dto.LoginRequest;
import com.campusvirtual.backend_campus.dto.LoginResponse;
import com.campusvirtual.backend_campus.entity.Usuario;
import com.campusvirtual.backend_campus.exception.UsuarioNotFoundException;
import com.campusvirtual.backend_campus.repository.UsuarioRepository;
import com.campusvirtual.backend_campus.services.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioService usuarioService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public LoginResponse login(@Valid LoginRequest loginRequest){
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        authenticationManager.authenticate(authentication);

        Usuario usuario = usuarioRepository.findByEmailEqualsIgnoreCase(loginRequest.getEmail())
                .orElseThrow(() -> new UsuarioNotFoundException("Error en el Login, Usuario no encontrado"));

        // Generar nuevo sessionId
        String nuevoSessionId = UUID.randomUUID().toString();
        usuario.setSessionId(nuevoSessionId);
        usuarioRepository.save(usuario);

        // Claims con sessionId incluido
        String jwt = jwtService.generarToken(usuario, generarExtraClaims(usuario));

        return new LoginResponse(jwt);
    }

    private Map<String, Object> generarExtraClaims(Usuario persona) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("id", persona.getId());
        extraClaims.put("nombre", persona.getPrimerNombre() + " " + persona.getPrimerApellido());
        extraClaims.put("rol", persona.getRol().name());
        extraClaims.put("sessionId", persona.getSessionId());
        return extraClaims;
    }

    public Usuario findAuthenticatedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();

        return usuarioRepository.findByEmailEqualsIgnoreCase(correo)
                .orElseThrow(() -> new UsuarioNotFoundException("Error al buscar al usuario autenticado, no encontrado en BD"));
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public void resetPasswordByAdmin(Long idUsuario, @NotBlank String newPassword) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException("Error al resetear la contraseña, Usuario no encontrado"));

        String hashedPassword = passwordEncoder.encode(newPassword);
        usuario.setContrasenaHash(hashedPassword);
        usuarioRepository.save(usuario);
    }
}