package com.pousada.quintaypua.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/health")
@RestController()
public class HealthCheckController {
    @GetMapping()
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}

