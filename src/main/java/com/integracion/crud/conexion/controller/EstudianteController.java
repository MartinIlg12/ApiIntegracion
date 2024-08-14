package com.integracion.crud.conexion.controller;

import com.integracion.crud.conexion.entity.Estudiante;
import com.integracion.crud.conexion.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> getAll() {
        return estudianteService.getEstudiantes();
    }

    @GetMapping("/{estudianteId}")
    public ResponseEntity<Estudiante> getById(@PathVariable("estudianteId") Long estudianteId) {
        Optional<Estudiante> estudiante = estudianteService.getEstudiante(estudianteId);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> saveOrUpdate(@RequestBody Estudiante estudiante) {
        estudianteService.saveOrUpdate(estudiante);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{estudianteId}")
    public ResponseEntity<Void> delete(@PathVariable("estudianteId") Long estudianteId) {
        estudianteService.delete(estudianteId);
        return ResponseEntity.noContent().build();
    }
}
