package com.grupo6.nutriburger.dto;

import com.grupo6.nutriburger.model.Categoria;

import java.util.List;

/**
 * Data Transfer Object da entidade {@code Categoria},
 * utilizada para retornar as categorias com todos os
 * produtos que a referenciam.
 * <hr>
 * Os produtos são retornados como {@code ProdutoBasicoDTO},
 * ou seja, um objeto com os campos id, nome e preço (apenas)
 * da entidade {@code Produto}.
 */
public class CategoriaDTO {
    private final Integer id;
    private final String nome;
    private final List<ProdutoBasicoDTO> produtos;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.produtos = categoria.getProdutos().stream().map(
                p -> new ProdutoBasicoDTO(p.getId(), p.getNome(), p.getPreco(), p.getImagemUrl())
        ).toList();
    }

    public Integer getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<ProdutoBasicoDTO> getProdutos() {
        return produtos;
    }
}
