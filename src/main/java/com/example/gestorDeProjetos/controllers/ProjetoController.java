package com.example.gestorDeProjetos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @GetMapping
    public ResponseEntity<?> getAll() {


        return ResponseEntity.status(HttpStatus.OK).body("Exemplo");
    }

}
