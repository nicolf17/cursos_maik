package org.cursos.maik.controller;

import org.cursos.maik.dto.request.EstudianteRequestDTO;
import org.cursos.maik.dto.response.CursoResponseDTO;
import org.cursos.maik.dto.response.EstudianteResponseDTO;
import org.cursos.maik.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/crear")
    public ResponseEntity<EstudianteResponseDTO> crearEstudiante(@RequestBody EstudianteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estudianteService.crearEstudiante(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EstudianteResponseDTO>> listarEstudiantes() {
        return ResponseEntity.ok(estudianteService.listarEstudiantes());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<EstudianteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.buscarPorId(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EstudianteResponseDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteRequestDTO dto) {
        return ResponseEntity.ok(estudianteService.actualizarEstudiante(id, dto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return ResponseEntity.ok("Estudiante eliminado");
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<CursoResponseDTO>> listarCursosPorEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.listarCursosPorEstudiante(id));
    }
}