package com.grupo6.nutriburger.dto;

import com.grupo6.nutriburger.model.Ingrediente;
import com.grupo6.nutriburger.model.Produto;

import java.util.List;

public class ProdutoDTO {
    private final Integer id;
    private final String nome;
    private final String descricao;
    private final Double preco;
    private DadosNutricionaisDTO dadosNutricionais;
    private final List<String> ingredientes;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        if (produto.getDadosNutricionais() != null) {
            this.dadosNutricionais = new DadosNutricionaisDTO(produto.getDadosNutricionais());
        }
        this.ingredientes = produto.getIngredientes()
                .stream()
                .map(Ingrediente::getNome)
                .toList();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() { return descricao; }

    public Double getPreco() {
        return preco;
    }

    public DadosNutricionaisDTO getDadosNutricionais() {
        return dadosNutricionais;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }
}