package org.cursos.maik.service;

import org.cursos.maik.dto.response.CursoResponseDTO;
import org.cursos.maik.dto.request.EstudianteRequestDTO;
import org.cursos.maik.dto.response.EstudianteResponseDTO;
import org.cursos.maik.entity.Curso;
import org.cursos.maik.entity.Estudiante;
import org.cursos.maik.repository.CursoRepository;
import org.cursos.maik.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public EstudianteResponseDTO crearEstudiante(EstudianteRequestDTO dto) {
        List<Curso> curso = cursoRepository.findAllById(dto.getId_curso());

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre_estudiante(dto.getNombre_estudiante());
        estudiante.setEmail(dto.getEmail());
        estudiante.setCurso(curso);

        estudianteRepository.save(estudiante);

        EstudianteResponseDTO response = new EstudianteResponseDTO();
        response.setId_estudiante(estudiante.getId_estudiante());
        response.setNombre_estudiante(estudiante.getNombre_estudiante());
        response.setEmail(estudiante.getEmail());

        List<CursoResponseDTO> cursoDTO = estudiante.getCurso().stream().map(c -> {
            CursoResponseDTO cdto = new CursoResponseDTO();
            cdto.setId_curso(c.getId_curso());
            cdto.setTitulo(c.getTitulo());
            cdto.setDescripcion(c.getDescripcion());
            cdto.setNombre_categoria(c.getCategoria().getNombre_categoria());

            return cdto;
        }).toList();

        response.setCurso(cursoDTO);

        return response;
    }

    public List<EstudianteResponseDTO> listarEstudiantes() {
        return estudianteRepository.findAll()
                .stream()
                .map(estudiante -> {
                    EstudianteResponseDTO response = new EstudianteResponseDTO();
                    response.setId_estudiante(estudiante.getId_estudiante());
                    response.setNombre_estudiante(estudiante.getNombre_estudiante());
                    response.setEmail(estudiante.getEmail());

                    List<CursoResponseDTO> cursoDTO = estudiante.getCurso().stream().map(c -> {
                        CursoResponseDTO cdto = new CursoResponseDTO();
                        cdto.setId_curso(c.getId_curso());
                        cdto.setTitulo(c.getTitulo());
                        cdto.setDescripcion(c.getDescripcion());
                        cdto.setNombre_categoria(c.getCategoria().getNombre_categoria());

                        return cdto;
                    }).toList();

                    response.setCurso(cursoDTO);

                    return response;
                }).toList();
    }

    public EstudianteResponseDTO buscarPorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id).get();

        EstudianteResponseDTO response = new EstudianteResponseDTO();
        response.setId_estudiante(estudiante.getId_estudiante());
        response.setNombre_estudiante(estudiante.getNombre_estudiante());
        response.setEmail(estudiante.getEmail());

        List<CursoResponseDTO> cursoDTO = estudiante.getCurso().stream().map(c -> {
            CursoResponseDTO cdto = new CursoResponseDTO();
            cdto.setId_curso(c.getId_curso());
            cdto.setTitulo(c.getTitulo());
            cdto.setDescripcion(c.getDescripcion());
            cdto.setNombre_categoria(c.getCategoria().getNombre_categoria());

            return cdto;
        }).toList();

        response.setCurso(cursoDTO);

        return response;
    }

    public EstudianteResponseDTO actualizarEstudiante(Long id, EstudianteRequestDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(id).get();

        estudiante.setNombre_estudiante(dto.getNombre_estudiante());
        estudiante.setEmail(dto.getEmail());

        estudianteRepository.save(estudiante);

        EstudianteResponseDTO response = new EstudianteResponseDTO();
        response.setId_estudiante(estudiante.getId_estudiante());
        response.setNombre_estudiante(estudiante.getNombre_estudiante());
        response.setEmail(estudiante.getEmail());

        List<CursoResponseDTO> cursoDTO = estudiante.getCurso().stream().map(c -> {
            CursoResponseDTO cdto = new CursoResponseDTO();
            cdto.setId_curso(c.getId_curso());
            cdto.setTitulo(c.getTitulo());
            cdto.setDescripcion(c.getDescripcion());
            cdto.setNombre_categoria(c.getCategoria().getNombre_categoria());

            return cdto;
        }).toList();

        response.setCurso(cursoDTO);

        return response;
    }

    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }

    public List<CursoResponseDTO> listarCursosPorEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id).get();

        return estudiante.getCurso().stream().map(c -> {
            CursoResponseDTO cdto = new CursoResponseDTO();
            cdto.setId_curso(c.getId_curso());
            cdto.setTitulo(c.getTitulo());
            cdto.setDescripcion(c.getDescripcion());
            cdto.setNombre_categoria(c.getCategoria().getNombre_categoria());

            return cdto;
        }).toList();
    }
}