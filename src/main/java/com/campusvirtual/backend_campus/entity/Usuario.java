package com.campusvirtual.backend_campus.entity;

import com.campusvirtual.backend_campus.entity.util.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "primer_nombre", length = 45, nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 45)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 45, nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 45)
    private String segundoApellido;


    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "contraseña_hash", length = 255, nullable = false)
    private String contrasenaHash;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private String sessionId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (getRol() == null) return Collections.emptyList();

        List<GrantedAuthority> authorities = new ArrayList<>();

        // Agregar el rol con el prefijo "ROLE_"
        authorities.add(new SimpleGrantedAuthority("ROLE_" + getRol().name()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.contrasenaHash;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
