package org.cursos.maik.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;


@Data
public class EstudianteRequestDTO {

    @NotBlank
    @Size(min = 3, max = 50)
    private String nombre_estudiante;

    @NotBlank
    @Size(min = 10, max = 200)
    private String email;

    @NotBlank
    @Size(min = 10, max = 50)
    private List<Long> id_curso;
}
