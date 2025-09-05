package com.grupo6.nutriburger.dto;

import com.grupo6.nutriburger.model.DadosNutricionais;

public class DadosNutricionaisDTO {

    private Double carboidratos;
    private Double proteinas;
    private Double acucares;
    private Double sodio;

    // private Boolean semGluten;
    // private Boolean semLactose;

    public DadosNutricionaisDTO() {}

    public DadosNutricionaisDTO(DadosNutricionais dados) {
        this.carboidratos = dados.getCarboidratos();
        this.proteinas = dados.getProteinas();
        this.acucares = dados.getAcucares();
        this.sodio = dados.getSodio();
        // this.semGluten = dados.getSemGluten();
        // this.semLactose = dados.getSemLactose();
    }

    public Double getCarboidratos() { return carboidratos; }
    public Double getProteinas() { return proteinas; }
    public Double getAcucares() { return acucares; }
    public Double getSodio() { return sodio; }
}
