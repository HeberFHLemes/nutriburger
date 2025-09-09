package com.grupo6.nutriburger.repository;

import com.grupo6.nutriburger.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}