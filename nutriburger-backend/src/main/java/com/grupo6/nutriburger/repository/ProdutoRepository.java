package com.grupo6.nutriburger.repository;

import com.grupo6.nutriburger.dto.ProdutoBasicoDTO;
import com.grupo6.nutriburger.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT new com.grupo6.nutriburger.dto.ProdutoBasicoDTO(p.id, p.nome, p.preco, p.imagemUrl) FROM Produto p")
    List<ProdutoBasicoDTO> buscarProdutosBasicos();

}