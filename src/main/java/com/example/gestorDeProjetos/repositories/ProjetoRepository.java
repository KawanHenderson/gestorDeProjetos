package com.example.gestorDeProjetos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestorDeProjetos.models.Projeto;
public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{}
