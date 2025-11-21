package com.example.gestorDeProjetos.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProjeto;

    private String nome;
    private String descricao;

    private LocalDateTime criadoEm;

    @OneToMany(mappedBy = "projeto")
    private List<Issue> issues;
}
