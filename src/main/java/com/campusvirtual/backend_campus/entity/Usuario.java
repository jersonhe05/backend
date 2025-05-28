package com.campusvirtual.backend_campus.entity;

import com.campusvirtual.backend_campus.entity.util.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

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

}
