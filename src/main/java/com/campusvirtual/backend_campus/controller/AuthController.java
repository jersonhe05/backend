package com.campusvirtual.backend_campus.controller;

import com.campusvirtual.backend_campus.config.security.service.AuthService;
import com.campusvirtual.backend_campus.dto.LoginRequest;
import com.campusvirtual.backend_campus.dto.LoginResponse;
import com.campusvirtual.backend_campus.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(
            @RequestBody @Valid LoginRequest authenticationRequest){

        return ResponseEntity.ok(authService.login(authenticationRequest));
    }
}

