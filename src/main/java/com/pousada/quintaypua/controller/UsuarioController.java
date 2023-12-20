package com.pousada.quintaypua.controller;

import com.pousada.quintaypua.domain.Reserva;
import com.pousada.quintaypua.domain.Usuario;
import com.pousada.quintaypua.service.ReservaService;
import com.pousada.quintaypua.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuarios")
@RestController()
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getAll(){
        return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> gettById(@PathVariable Long id) {
        return usuarioService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario created = usuarioService.createOrUpdate(usuario);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!usuarioService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuario update = usuarioService.createOrUpdate(usuario);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (!usuarioService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
