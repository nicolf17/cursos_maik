package org.cursos.maik.dto;

import lombok.Data;

@Data
public class CursoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer duracion;
}
