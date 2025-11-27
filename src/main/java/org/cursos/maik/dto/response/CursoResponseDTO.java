package org.cursos.maik.dto.response;

import lombok.Data;

@Data
public class CursoResponseDTO {

    private Long id_curso;
    private String titulo;
    private String descripcion;
    private String nombre_categoria;
}
