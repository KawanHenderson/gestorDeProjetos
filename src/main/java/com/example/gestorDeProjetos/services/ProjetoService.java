package com.example.gestorDeProjetos.services;

import com.example.gestorDeProjetos.models.Projeto;
import com.example.gestorDeProjetos.repositories.ProjetoRepository;
import com.example.gestorDeProjetos.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto criarProjeto(Projeto projeto) {
        if (projeto.getNome() == null || projeto.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do projeto é obrigatório.");
        }

        projeto.setCriadoEm(LocalDateTime.now());
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }


    public Projeto buscarProjeto(Integer id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado: " + id));
    }

    public Projeto atualizarProjeto(Integer id, Projeto dadosAtualizados) {
        Projeto projeto = buscarProjeto(id);

        if (dadosAtualizados.getNome() != null) {
            projeto.setNome(dadosAtualizados.getNome());
        }
        if (dadosAtualizados.getDescricao() != null) {
            projeto.setDescricao(dadosAtualizados.getDescricao());
        }

        return projetoRepository.save(projeto);
    }
    
    public void deletarProjeto(Integer id) {
        Projeto projeto = buscarProjeto(id);
        projetoRepository.delete(projeto);
    }
}
