package org.cursos.maik.controller;

import org.cursos.maik.dto.request.CursoRequestDTO;
import org.cursos.maik.dto.response.CursoResponseDTO;
import org.cursos.maik.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/crear")
    public ResponseEntity<CursoResponseDTO> crearCurso(@RequestBody CursoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.crearCurso(dto));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CursoResponseDTO> actualizarCurso(@PathVariable Long id, @RequestBody CursoRequestDTO dto) {
        return ResponseEntity.ok(cursoService.actualizarCurso(id, dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CursoResponseDTO>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CursoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.buscarPorId(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.ok("Curso eliminado");
    }
}
