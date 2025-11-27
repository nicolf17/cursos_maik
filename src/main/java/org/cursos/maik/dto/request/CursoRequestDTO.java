package org.cursos.maik.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CursoRequestDTO {

    @NotBlank
    @Size(min = 3, max = 50)
    private String titulo;

    @NotBlank
    @Size(min = 10, max = 200)
    private String descripcion;

    @NotBlank
    @Size(min = 10, max = 200)
    private Long id_categoria;

}
