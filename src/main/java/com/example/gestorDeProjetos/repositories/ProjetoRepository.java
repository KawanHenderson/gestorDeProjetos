package com.example.gestorDeProjetos.repositories;


import com.example.gestorDeProjetos.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {}
