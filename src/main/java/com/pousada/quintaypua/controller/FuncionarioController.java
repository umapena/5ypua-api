package com.pousada.quintaypua.controller;

import com.pousada.quintaypua.domain.Funcionario;
import com.pousada.quintaypua.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/funcionarios")
@RestController()
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/")
    public ResponseEntity<List<Funcionario>> getAll(){
        return new ResponseEntity<>(funcionarioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long id) {
        return funcionarioService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario) {
        Funcionario created = funcionarioService.createOrUpdate(funcionario);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if (!funcionarioService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setId(id);
        Funcionario update = funcionarioService.createOrUpdate(funcionario);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (!funcionarioService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
