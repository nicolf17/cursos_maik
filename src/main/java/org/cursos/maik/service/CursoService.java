package org.cursos.maik.service;

import org.cursos.maik.dto.request.CursoRequestDTO;
import org.cursos.maik.dto.response.CursoResponseDTO;
import org.cursos.maik.entity.Categoria;
import org.cursos.maik.entity.Curso;
import org.cursos.maik.repository.CategoriaRepository;
import org.cursos.maik.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CursoResponseDTO crearCurso(CursoRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getId_categoria()).get();

        Curso curso = new Curso();
        curso.setTitulo(dto.getTitulo());
        curso.setDescripcion(dto.getDescripcion());
        curso.setCategoria(categoria);

        cursoRepository.save(curso);

        CursoResponseDTO response = new CursoResponseDTO();
        response.setId_curso(curso.getId_curso());
        response.setTitulo(curso.getTitulo());
        response.setDescripcion(curso.getDescripcion());
        response.setNombre_categoria(curso.getCategoria().getNombre_categoria());


        return response;
    }

    public CursoResponseDTO actualizarCurso(Long id, CursoRequestDTO dto) {

        Curso curso = cursoRepository.findById(id).get();
        Categoria categoria = categoriaRepository.findById(dto.getId_categoria()).get();

        curso.setTitulo(dto.getTitulo());
        curso.setDescripcion(dto.getDescripcion());
        curso.setCategoria(categoria);

        cursoRepository.save(curso);

        CursoResponseDTO response = new CursoResponseDTO();
        response.setId_curso(curso.getId_curso());
        response.setTitulo(curso.getTitulo());
        response.setDescripcion(curso.getDescripcion());
        response.setNombre_categoria(curso.getCategoria().getNombre_categoria());

        return response;
    }

    public List<CursoResponseDTO> listarCursos() {
        return cursoRepository.findAll()
                .stream()
                .map(c -> {
                    CursoResponseDTO dto = new CursoResponseDTO();
                    dto.setId_curso(c.getId_curso());
                    dto.setTitulo(c.getTitulo());
                    dto.setDescripcion(c.getDescripcion());
                    dto.setNombre_categoria(c.getCategoria().getNombre_categoria());
                    
                    return dto;
                }).toList();
    }

    public CursoResponseDTO buscarPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        CursoResponseDTO dto = new CursoResponseDTO();
        dto.setId_curso(curso.getId_curso());
        dto.setTitulo(curso.getTitulo());
        dto.setDescripcion(curso.getDescripcion());
        dto.setNombre_categoria(curso.getCategoria().getNombre_categoria());
        
        return dto;
    }

    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
}
