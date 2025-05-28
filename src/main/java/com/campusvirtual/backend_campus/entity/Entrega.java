package com.campusvirtual.backend_campus.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "entregas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identregas;

    @ManyToOne
    @JoinColumn(name = "idcurso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @CreationTimestamp
    private LocalDateTime fechaEntrega;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Archivo> archivos;

}
