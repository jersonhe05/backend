package com.campusvirtual.backend_campus.config.security;

import com.campusvirtual.backend_campus.exception.UsuarioNotFoundException;
import com.campusvirtual.backend_campus.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityBeansInjector {
    private final AuthenticationConfiguration authenticationConfiguration;
    private final UsuarioRepository usuarioRepository;

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return (correo -> {
            return usuarioRepository.findByCorreoEqualsIgnoreCase(correo)
                    .orElseThrow(() -> new UsuarioNotFoundException("Error userDetailsService, Usuario no encontrado"));

        });
    }
}
