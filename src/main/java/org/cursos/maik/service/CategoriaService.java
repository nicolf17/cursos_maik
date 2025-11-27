package org.cursos.maik.service;

import org.cursos.maik.dto.request.CategoriaRequestDTO;
import org.cursos.maik.dto.response.CategoriaResponseDTO;
import org.cursos.maik.entity.Categoria;
import org.cursos.maik.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaResponseDTO crearCategoria(CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNombre_categoria(dto.getNombreCategoria());

        categoriaRepository.save(categoria);

        CategoriaResponseDTO response = new CategoriaResponseDTO();
        response.setId_categoria(categoria.getId_categoria());
        response.setNombre_categoria(categoria.getNombre_categoria());

        return response;
    }

    public List<CategoriaResponseDTO> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoria -> {
                    CategoriaResponseDTO response = new CategoriaResponseDTO();
                    response.setId_categoria(categoria.getId_categoria());
                    response.setNombre_categoria(categoria.getNombre_categoria());
                    return response;
                }).toList();
    }

    public CategoriaResponseDTO buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();

        CategoriaResponseDTO response = new CategoriaResponseDTO();
        response.setId_categoria(categoria.getId_categoria());
        response.setNombre_categoria(categoria.getNombre_categoria());

        return response;
    }

    public CategoriaResponseDTO actualizarCategoria(Long id, CategoriaRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(id).get();

        categoria.setNombre_categoria(dto.getNombreCategoria());

        categoriaRepository.save(categoria);

        CategoriaResponseDTO response = new CategoriaResponseDTO();
        response.setId_categoria(categoria.getId_categoria());
        response.setNombre_categoria(categoria.getNombre_categoria());

        return response;
    }

    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}