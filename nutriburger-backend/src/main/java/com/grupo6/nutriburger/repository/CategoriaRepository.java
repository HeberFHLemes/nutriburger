package com.grupo6.nutriburger.repository;

import com.grupo6.nutriburger.model.Categoria;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @NonNull @EntityGraph(attributePaths = "produtos")
    List<Categoria> findAll();

}