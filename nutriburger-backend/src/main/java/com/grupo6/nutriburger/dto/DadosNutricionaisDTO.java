package com.grupo6.nutriburger.dto;

import com.grupo6.nutriburger.model.DadosNutricionais;

public class DadosNutricionaisDTO {

    private Double acucares;
    private Double carboidratos;
    private Double proteinas;
    private Double sodio;

    public DadosNutricionaisDTO() {}

    public DadosNutricionaisDTO(DadosNutricionais dados) {
        this.acucares = dados.getAcucares();
        this.carboidratos = dados.getCarboidratos();
        this.proteinas = dados.getProteinas();
        this.sodio = dados.getSodio();
    }

    public Double getAcucares() { return acucares; }
    public Double getCarboidratos() { return carboidratos; }
    public Double getProteinas() { return proteinas; }
    public Double getSodio() { return sodio; }
}
