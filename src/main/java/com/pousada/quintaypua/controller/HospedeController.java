package com.pousada.quintaypua.controller;

import com.pousada.quintaypua.domain.Acomodacao;
import com.pousada.quintaypua.domain.Hospede;
import com.pousada.quintaypua.service.AcomodacaoService;
import com.pousada.quintaypua.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hospedes")
@RestController()
public class HospedeController {
    @Autowired
    HospedeService hospedeService;

    @GetMapping("/")
    public ResponseEntity<List<Hospede>> getAll(){
        return new ResponseEntity<>(hospedeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> gettById(@PathVariable Long id) {
        return hospedeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Hospede> create(@RequestBody Hospede hospede) {
        Hospede created = hospedeService.createOrUpdate(hospede);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospede> update(@PathVariable Long id, @RequestBody Hospede hospede) {
        if (!hospedeService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        hospede.setId(id);
        Hospede update = hospedeService.createOrUpdate(hospede);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (!hospedeService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        hospedeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
