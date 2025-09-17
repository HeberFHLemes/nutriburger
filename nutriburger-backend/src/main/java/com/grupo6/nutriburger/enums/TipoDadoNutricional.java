package com.grupo6.nutriburger.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDadoNutricional {
    ACUCARES("Açúcares", "g"),
    CARBOIDRATOS("Carboidratos", "g"),
    PROTEINAS("Proteínas", "g"),
    SODIO("Sódio", "mg");
    
    String nome;
    String unidade;
    
    private TipoDadoNutricional(String nome, String unidade){
        this.nome=nome;
        this.unidade=unidade;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getUnidade(){
        return this.unidade;
    }

    /**
     * Para apresentar da melhor forma os dados nutricionais na API
     * @return Map com os dados nutricionais formatados, de acordo com os valores do enum TipoDadoNutricional
     */
    public static Map<String, String> getDadosMapeados(Map<TipoDadoNutricional, Double> dadosNutricionais){
        Map<String, String> dados = new HashMap<>();
        for (TipoDadoNutricional tipo : TipoDadoNutricional.values()) {
           dados.put(tipo.getNome(), dadosNutricionais.get(tipo) + " " + tipo.getUnidade());
        }
        return dados;
    }
}
