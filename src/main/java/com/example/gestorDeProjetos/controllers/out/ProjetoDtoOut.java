package com.example.gestorDeProjetos.controllers.out;

import com.example.gestorDeProjetos.models.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public  class ProjetoDtoOut {

    private Integer id;
    private String nome;
    private String descricao;

    public ProjetoDtoOut(Projeto projeto) {
        this.id = projeto.getIdProjeto();
        this.nome = projeto.getNome();
        this.descricao = projeto.getDescricao();
    }
}

