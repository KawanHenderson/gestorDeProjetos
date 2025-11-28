package com.example.gestorDeProjetos.repositories;

import com.example.gestorDeProjetos.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, String> {
    //
}
