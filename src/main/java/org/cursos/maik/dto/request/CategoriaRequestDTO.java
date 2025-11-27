package org.cursos.maik.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CategoriaRequestDTO {

    @NotBlank
    @Size(min = 1, max = 50)
    private Long id_categoria;

    @NotBlank
    @Size(min = 3, max = 50)
    private String nombreCategoria;

}
