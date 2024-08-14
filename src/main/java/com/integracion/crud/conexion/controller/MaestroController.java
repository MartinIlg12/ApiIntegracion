package com.integracion.crud.conexion.controller;

import com.integracion.crud.conexion.entity.Maestro;
import com.integracion.crud.conexion.service.MaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/maestros")
public class MaestroController {

    private final MaestroService maestroService;

    @Autowired
    public MaestroController(MaestroService maestroService) {
        this.maestroService = maestroService;
    }

    @GetMapping
    public List<Maestro> getAll() {
        return maestroService.getMaestros();
    }

    @GetMapping("/{maestroId}")
    public ResponseEntity<Maestro> getById(@PathVariable("maestroId") Long maestroId) {
        Optional<Maestro> maestro = maestroService.getMaestro(maestroId);
        return maestro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> saveOrUpdate(@RequestBody Maestro maestro) {
        maestroService.saveOrUpdate(maestro);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{maestroId}")
    public ResponseEntity<Void> delete(@PathVariable("maestroId") Long maestroId) {
        maestroService.delete(maestroId);
        return ResponseEntity.noContent().build();
    }
}
