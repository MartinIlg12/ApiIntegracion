package com.integracion.crud.conexion.controller;

import com.integracion.crud.conexion.entity.Nota;
import com.integracion.crud.conexion.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/notas")
public class NotaController {

    private final NotaService notaService;

    @Autowired
    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public List<Nota> getAll() {
        return notaService.getNotas();
    }

    @GetMapping("/{notaId}")
    public ResponseEntity<Nota> getById(@PathVariable("notaId") Long notaId) {
        Optional<Nota> nota = notaService.getNota(notaId);
        return nota.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> saveOrUpdate(@RequestBody Nota nota) {
        notaService.saveOrUpdate(nota);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{notaId}")
    public ResponseEntity<Void> delete(@PathVariable("notaId") Long notaId) {
        notaService.delete(notaId);
        return ResponseEntity.noContent().build();
    }
}
