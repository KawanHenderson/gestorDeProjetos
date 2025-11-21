package com.example.gestorDeProjetos.controllers.out;

import com.example.gestorDeProjetos.models.Issue;
import com.example.gestorDeProjetos.models.IssueStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IssueDtoOut {

    private Integer id;
    private String titulo;
    private String descricao;
    private IssueStatus status;
    private Integer idProjeto;

    public IssueDtoOut(Issue issue) {
        this.id = issue.getId();
        this.titulo = issue.getTitulo();
        this.descricao = issue.getDescricao();
        this.status = issue.getStatus();
        this.idProjeto = issue.getProjeto() != null ? issue.getProjeto().getIdProjeto() : null;
    }
}
