package com.grupo6.nutriburger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Entity @Immutable
@Table(name = "ingredientes")
public final class Ingrediente {

    @Id
    private Integer id;

    @Column(insertable = false, updatable = false)
    private String nome;

    @Column(insertable = false, updatable = false)
    private Double acucares;

    @Column(insertable = false, updatable = false)
    private Double carboidratos;

    @Column(insertable = false, updatable = false)
    private Double proteinas;

    @Column(insertable = false, updatable = false)
    private Double sodio;

    @ManyToMany(mappedBy = "ingredientes")
    @JsonIgnore
    private Set<Produto> produtos = new HashSet<>();

    private Ingrediente(){}

    public Ingrediente(String nome, Double carboidratos, Double proteinas, Double acucares, Double sodio) {
        this.nome = nome;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.acucares = acucares;
        this.sodio = sodio;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getCarboidratos() {
        return carboidratos;
    }

    public Double getProteinas() {
        return proteinas;
    }

    public Double getAcucares() {
        return acucares;
    }

    public Double getSodio() {
        return sodio;
    }
}