package com.grupo6.nutriburger.dto;

public class DadosNutricionaisDTO {

    private String nome;
    private String valor;
    
    public DadosNutricionaisDTO(String nomeNutriente, Double valor, String unidadeMedida) {
        this.nome = nomeNutriente;
        this.valor = valor + " " + unidadeMedida;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }
}