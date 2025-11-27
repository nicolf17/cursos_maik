package org.cursos.maik.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class EstudianteResponseDTO {

    private Long id_estudiante;
    private String nombre_estudiante;
    private String email;
    private List<CursoResponseDTO> curso;

}
