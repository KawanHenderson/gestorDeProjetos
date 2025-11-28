package com.example.gestorDeProjetos.controllers;

import com.example.gestorDeProjetos.controllers.in.IssueDtoIn;
import com.example.gestorDeProjetos.controllers.out.IssueDtoOut;
import com.example.gestorDeProjetos.models.Issue;
import com.example.gestorDeProjetos.services.IssueService;
import com.example.gestorDeProjetos.exceptions.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping("/projeto/{idProjeto}/issues")
    public ResponseEntity<?> criarIssue(
            @PathVariable Integer idProjeto,
            @RequestBody IssueDtoIn issueDtoIn) {
        try {
            Issue issue = new Issue();
            issue.setTitulo(issueDtoIn.getTitulo());
            issue.setDescricao(issueDtoIn.getDescricao());

            Issue novaIssue = issueService.criarIssue(idProjeto, issue);
            return ResponseEntity.status(HttpStatus.CREATED).body(new IssueDtoOut(novaIssue));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/projeto/{idProjeto}/issues")
    public ResponseEntity<?> listarIssuesPorProjeto(@PathVariable Integer idProjeto) {
        try {
            List<Issue> issues = issueService.listarIssuesPorProjeto(idProjeto);
            List<IssueDtoOut> issuesDtoOut = issues.stream()
                    .map(IssueDtoOut::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(issuesDtoOut);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/issues/{id}")
    public ResponseEntity<?> buscarIssue(@PathVariable Integer id) {
        try {
            Issue issue = issueService.buscarIssue(id);
            return ResponseEntity.ok(new IssueDtoOut(issue));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/issues/{id}")
    public ResponseEntity<?> atualizarIssue(@PathVariable Integer id, @RequestBody IssueDtoIn issueDtoIn) {
        try {
            Issue dadosAtualizados = new Issue();
            dadosAtualizados.setTitulo(issueDtoIn.getTitulo());
            dadosAtualizados.setDescricao(issueDtoIn.getDescricao());

            Issue issueAtualizada = issueService.atualizarIssue(id, dadosAtualizados);
            return ResponseEntity.ok(new IssueDtoOut(issueAtualizada));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}