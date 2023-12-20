package com.pousada.quintaypua.controller;

import com.pousada.quintaypua.domain.Acomodacao;
import com.pousada.quintaypua.domain.Funcionario;
import com.pousada.quintaypua.service.AcomodacaoService;
import com.pousada.quintaypua.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/acomodacoes")
@RestController()
public class AcomodacaoController {
    @Autowired
    AcomodacaoService acomodacaoService;

    @GetMapping("/")
    public ResponseEntity<List<Acomodacao>> getAll(){
        return new ResponseEntity<>(acomodacaoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acomodacao> getById(@PathVariable Long id) {
        return acomodacaoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Acomodacao> create(@RequestBody Acomodacao acomodacao) {
        Acomodacao created = acomodacaoService.createOrUpdate(acomodacao);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acomodacao> update(@PathVariable Long id, @RequestBody Acomodacao acomodacao) {
        if (!acomodacaoService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        acomodacao.setId(id);
        Acomodacao update = acomodacaoService.createOrUpdate(acomodacao);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (!acomodacaoService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        acomodacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}