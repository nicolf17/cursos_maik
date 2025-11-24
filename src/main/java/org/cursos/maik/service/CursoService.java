package org.cursos.maik.service;

import org.cursos.maik.dto.CursoRequestDTO;
import org.cursos.maik.dto.CursoResponseDTO;
import org.cursos.maik.entity.Curso;
import org.cursos.maik.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoResponseDTO crearCurso(CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setDuracion(dto.getDuracion());

        cursoRepository.save(curso);

        CursoResponseDTO response = new CursoResponseDTO();
        response.setId(curso.getId());
        response.setNombre(curso.getNombre());
        response.setDescripcion(curso.getDescripcion());
        response.setDuracion(curso.getDuracion());

        return response;
    }

    public List<CursoResponseDTO> listarCursos() {
        return cursoRepository.findAll()
                .stream()
                .map(c -> {
                    CursoResponseDTO dto = new CursoResponseDTO();
                    dto.setId(c.getId());
                    dto.setNombre(c.getNombre());
                    dto.setDescripcion(c.getDescripcion());
                    dto.setDuracion(c.getDuracion());
                    return dto;
                }).toList();
    }

    public CursoResponseDTO buscarPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        CursoResponseDTO dto = new CursoResponseDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setDuracion(curso.getDuracion());
        return dto;
    }

    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
}
