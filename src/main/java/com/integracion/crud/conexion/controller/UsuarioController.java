package com.integracion.crud.conexion.controller;

import com.integracion.crud.conexion.entity.Usuario;
import com.integracion.crud.conexion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getById(@PathVariable("usuarioId") Long usuarioId) {
        Optional<Usuario> usuario = usuarioService.getUsuario(usuarioId);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> saveOrUpdate(@RequestBody Usuario usuario) {
        usuarioService.saveOrUpdate(usuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> delete(@PathVariable("usuarioId") Long usuarioId) {
        usuarioService.delete(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
