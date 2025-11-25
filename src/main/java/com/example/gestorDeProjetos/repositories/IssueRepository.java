package com.example.gestorDeProjetos.repositories;

import com.example.gestorDeProjetos.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {}