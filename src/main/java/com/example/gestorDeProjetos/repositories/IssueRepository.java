package com.example.gestorDeProjetos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestorDeProjetos.models.Issue;
public interface IssueRepository extends JpaRepository<Issue, Integer>{}
  
