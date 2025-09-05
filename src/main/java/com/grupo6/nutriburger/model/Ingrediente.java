package com.grupo6.nutriburger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(insertable = false, updatable = false)
    private String nome;

    @Column(insertable = false, updatable = false)
    private Double carboidratos;

    @Column(insertable = false, updatable = false)
    private Double proteinas;

    @Column(insertable = false, updatable = false)
    private Double acucares;

    @Column(insertable = false, updatable = false)
    private Double sodio;

    @ManyToMany(mappedBy = "ingredientes")
    @JsonIgnore
    private Set<Produto> produtos = new HashSet<>();

    protected Ingrediente(){}

    public Ingrediente(String nome, Double carboidratos, Double proteinas, Double acucares, Double sodio) {
        this.nome = nome;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.acucares = acucares;
        this.sodio = sodio;
    }

    public Long getId() {
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