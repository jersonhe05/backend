package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpersona;

    @Column(name = "primer_nombre", length = 45, nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 45)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 45, nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 45)
    private String segundoApellido;

    @OneToOne
    @JoinColumn(name = "usuarios_idusuarios", nullable = false, unique = true)
    private Usuario usuario;
}
