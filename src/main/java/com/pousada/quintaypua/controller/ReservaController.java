package com.pousada.quintaypua.controller;

import com.pousada.quintaypua.domain.Hospede;
import com.pousada.quintaypua.domain.Reserva;
import com.pousada.quintaypua.service.HospedeService;
import com.pousada.quintaypua.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reservas")
@RestController()
public class ReservaController {
    @Autowired
    ReservaService reservaService;

    @GetMapping("/")
    public ResponseEntity<List<Reserva>> getAll(){
        return new ResponseEntity<>(reservaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> gettById(@PathVariable Long id) {
        return reservaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
        Reserva created = reservaService.createOrUpdate(reserva);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Long id, @RequestBody Reserva reserva) {
        if (!reservaService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reserva.setId(id);
        Reserva update = reservaService.createOrUpdate(reserva);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (!reservaService.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
