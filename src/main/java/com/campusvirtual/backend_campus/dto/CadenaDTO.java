package com.campusvirtual.backend_campus.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadenaDTO {

    private Integer id;
    private String titulo;
    private String contenido;
    private Long idUsuario;
    private Integer idForo;
    private Integer idCadenaPadre; 
}

