package com.grupo6.nutriburger.repository;

import com.grupo6.nutriburger.model.DadosNutricionais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosNutricionaisRepository extends JpaRepository<DadosNutricionais, Long> {
}
