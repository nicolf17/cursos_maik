package org.cursos.maik.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CursoRequestDTO {

    @NotBlank
    @Size(min = 3, max = 50)
    private String nombre;

    @NotBlank
    @Size(min = 10, max = 200)
    private String descripcion;

    @NotNull
    @Min(1)
    @Max(300)
    private Integer duracion;
}
