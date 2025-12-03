package com.example.gestorDeProjetos.controllers.in;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IssueDtoIn {

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    private Integer idProjeto;

}
