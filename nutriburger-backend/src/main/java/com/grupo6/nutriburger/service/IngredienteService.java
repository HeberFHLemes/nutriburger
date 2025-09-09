package com.grupo6.nutriburger.service;

import com.grupo6.nutriburger.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {

    @SuppressWarnings("unused")
    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository){
        this.ingredienteRepository = ingredienteRepository;
    }
}