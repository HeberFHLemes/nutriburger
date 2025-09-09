package com.grupo6.nutriburger.dto;

import com.grupo6.nutriburger.model.Ingrediente;
import com.grupo6.nutriburger.model.Produto;

import java.util.List;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double preco;
    private DadosNutricionaisDTO dadosNutricionais;
    private List<String> ingredientes;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        if (produto.getDadosNutricionais() != null) {
            this.dadosNutricionais = new DadosNutricionaisDTO(produto.getDadosNutricionais());
        }
        this.ingredientes = produto.getIngredientes()
                .stream()
                .map(Ingrediente::getNome)
                .toList();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

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