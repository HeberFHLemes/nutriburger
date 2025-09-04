package com.grupo6.nutriburger.service;

import com.grupo6.nutriburger.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {

    // TODO: (Se necessário, ) implementar regras de negócio e uso da classe de persistência para a entidade Ingrediente.
    private final IngredienteRepository ingredienteRepository;
    public IngredienteService(IngredienteRepository ingredienteRepository){
        this.ingredienteRepository = ingredienteRepository;
    }

}