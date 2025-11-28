package com.example.gestorDeProjetos.services;

import com.example.gestorDeProjetos.controllers.in.ProjetoDtoIn;
import com.example.gestorDeProjetos.controllers.out.ProjetoDtoOut;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjetoService {

    public List<ProjetoDtoOut> buscarTodos(){
        //por enquanto esta retornando null vamo alterar glr, pois no controller estava dando erro
        //depois quem for fazer o service coloca aq
        return null;
    }

    public ProjetoDtoOut buscarPorId(Long id){
        //adc dps
        return null;
    }

    public ProjetoDtoOut criar(ProjetoDtoOut projeto){
        return null;
    }

    public ProjetoDtoOut atualizar(Long id, ProjetoDtoOut projeto){
        return null;
    }

    public void deletar(Long id){

    }

    public ProjetoDtoOut atualizar(long id, ProjetoDtoIn dadosAtualizados) {

        return null;
    }
}
