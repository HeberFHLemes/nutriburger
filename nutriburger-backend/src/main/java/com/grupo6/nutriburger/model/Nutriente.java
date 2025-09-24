package com.grupo6.nutriburger.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Immutable
@Table(name = "nutriente")
public final class Nutriente {
    
    @Id
    private Integer id;

    @Column(insertable = false, updatable = false, nullable = false)
    private String nome;

    @Column(name = "unidade_medida", insertable = false, updatable = false, nullable = false)
    private String unidadeMedida;

    @OneToMany(mappedBy = "nutriente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoNutriente> produtos = new ArrayList<>();
    
    public Nutriente(){}

    public Nutriente(String nome, String unidadeMedida){
        this.nome=nome;
        this.unidadeMedida=unidadeMedida;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    } 
    
    public List<ProdutoNutriente> getProdutos() {
        return produtos;
    }
}
