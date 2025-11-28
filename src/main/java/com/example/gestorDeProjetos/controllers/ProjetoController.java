package com.example.gestorDeProjetos.controllers;
import com.example.gestorDeProjetos.controllers.in.ProjetoDtoIn;
import com.example.gestorDeProjetos.controllers.out.ProjetoDtoOut;
import com.example.gestorDeProjetos.services.ProjetoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController // controladro rest
@RequestMapping("/projetos")//endereço base

public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    // listar todos com o get
    @GetMapping
    public ResponseEntity<List<ProjetoDtoOut>> listarProjetos() {
        List<ProjetoDtoOut> projetos = projetoService.buscarTodos();
        return ResponseEntity.ok(projetos);
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDtoOut> buscarPorId(@PathVariable Long id) {
        ProjetoDtoOut projeto = projetoService.buscarPorId(id);
        return ResponseEntity.ok(projeto);
    }
    //para criar novo
    @PostMapping
    public ResponseEntity<ProjetoDtoOut> criarProjeto(@RequestBody ProjetoDtoOut projeto){
        ProjetoDtoOut novoProjeto = projetoService.criar(projeto);
        return ResponseEntity.ok(novoProjeto);
    }
    //atualizar
    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDtoOut> atualizarProjeto(@PathVariable long id, @RequestBody ProjetoDtoIn dadosAtualizados){
        ProjetoDtoOut projetoAtualizado = projetoService.atualizar(id, dadosAtualizados);
        return ResponseEntity.ok(projetoAtualizado);
    }

}
