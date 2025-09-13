package com.grupo6.nutriburger.service;

import com.grupo6.nutriburger.dto.CategoriaDTO;
import com.grupo6.nutriburger.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> getAll(){
        return categoriaRepository.findAll().stream().map(CategoriaDTO::new).toList();
    }
}
