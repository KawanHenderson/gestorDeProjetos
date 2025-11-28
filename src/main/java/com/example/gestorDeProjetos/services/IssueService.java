package com.example.gestorDeProjetos.services;

import com.example.gestorDeProjetos.models.Issue;
import com.example.gestorDeProjetos.models.Projeto;
import com.example.gestorDeProjetos.models.IssueStatus;
import com.example.gestorDeProjetos.repositories.IssueRepository;
import com.example.gestorDeProjetos.repositories.ProjetoRepository;
import com.example.gestorDeProjetos.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;
    private final ProjetoRepository projetoRepository;

    public IssueService(IssueRepository issueRepository, ProjetoRepository projetoRepository) {
        this.issueRepository = issueRepository;
        this.projetoRepository = projetoRepository;
    }

    public Issue criarIssue(Integer idProjeto, Issue issue) {
        Projeto projeto = projetoRepository.findById(idProjeto)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado para criar issue."));

        issue.setProjeto(projeto);
        issue.setStatus(IssueStatus.ABERTO);
        issue.setCriadoEm(LocalDateTime.now());

        return issueRepository.save(issue);
    }

    public List<Issue> listarIssuesPorProjeto(Integer idProjeto) {
        Projeto projeto = projetoRepository.findById(idProjeto)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado."));

        return projeto.getIssues();
    }

    public Issue buscarIssue(Integer id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Issue não encontrada: " + id));
    }

    public Issue atualizarIssue(Integer id, Issue dados) {
        Issue issue = buscarIssue(id);

        if (dados.getTitulo() != null) issue.setTitulo(dados.getTitulo());
        if (dados.getDescricao() != null) issue.setDescricao(dados.getDescricao());
        if (dados.getStatus() != null) issue.setStatus(dados.getStatus());

        return issueRepository.save(issue);
    }
}