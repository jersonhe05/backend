package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "foros")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Foro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idforos;

    @Column(length = 255)
    private String tema;

    @Column(length = 1000)
    private String descripcion;
}
