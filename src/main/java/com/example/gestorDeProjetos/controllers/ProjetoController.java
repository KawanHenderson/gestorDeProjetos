package com.example.gestorDeProjetos.controllers;

import com.example.gestorDeProjetos.controllers.in.ProjetoDtoIn;
import com.example.gestorDeProjetos.controllers.out.ProjetoDtoOut;
import com.example.gestorDeProjetos.models.Projeto;
import com.example.gestorDeProjetos.services.ProjetoService;
import com.example.gestorDeProjetos.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
        List<Projeto> projetos = projetoService.listarProjetos();

        List<ProjetoDtoOut> projetosDtoOut = projetos.stream()
                .map(ProjetoDtoOut::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(projetosDtoOut);
    } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao listar projetos.");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            Projeto projeto = projetoService.buscarProjeto(id);
            return ResponseEntity.ok(new ProjetoDtoOut(projeto));

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProjetoDtoIn projetoDtoIn) {
        try {
            Projeto projeto = new Projeto();
            projeto.setNome(projetoDtoIn.getNome());
            projeto.setDescricao(projetoDtoIn.getDescricao());

            Projeto novoProjeto = projetoService.criarProjeto(projeto);

            return ResponseEntity.status(HttpStatus.CREATED).body(new ProjetoDtoOut(novoProjeto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar projeto.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody ProjetoDtoIn projetoDtoIn
    ) {
        try {
            Projeto dadosAtualizados = new Projeto();
            dadosAtualizados.setNome(projetoDtoIn.getNome());
            dadosAtualizados.setDescricao(projetoDtoIn.getDescricao());

            Projeto atualizado = projetoService.atualizarProjeto(id, dadosAtualizados);

            return ResponseEntity.ok(new ProjetoDtoOut(atualizado));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar projeto.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            projetoService.deletarProjeto(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
