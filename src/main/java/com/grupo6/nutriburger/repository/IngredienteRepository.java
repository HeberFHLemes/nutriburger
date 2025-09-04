package com.grupo6.nutriburger.repository;

import com.grupo6.nutriburger.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}