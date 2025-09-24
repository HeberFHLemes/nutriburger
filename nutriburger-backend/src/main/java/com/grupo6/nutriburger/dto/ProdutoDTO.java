package com.grupo6.nutriburger.dto;

import java.util.List;

public class ProdutoDTO {
    private final Integer id;
    private final String nome;
    private final String descricao;
    private final Double preco;
    private final String imagemUrl;
    
    private List<DadosNutricionaisDTO> dadosNutricionais;

    private final List<String> ingredientes;

    public ProdutoDTO(Integer id, String nome, String descricao, Double preco, String imagemUrl, 
        List<DadosNutricionaisDTO> dadosNutricionais, List<String> ingredientes){
            this.id = id;
            this.nome = nome;
            this.descricao = descricao;
            this.preco = preco;
            this.imagemUrl = imagemUrl;
            this.dadosNutricionais = dadosNutricionais;
            this.ingredientes = ingredientes;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public List<DadosNutricionaisDTO> getDadosNutricionais() {
        return dadosNutricionais;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }
}