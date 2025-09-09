package com.grupo6.nutriburger.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(insertable = false, updatable = false, nullable = false)
    private String nome;

    @Column(insertable = false, updatable = false, nullable = false)
    private Double preco;

    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DadosNutricionais dadosNutricionais;

    @ManyToMany
    @JoinTable(
            name = "produtos_ingredientes",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    @OrderBy("id ASC")
    private Set<Ingrediente> ingredientes = new HashSet<>();

    protected Produto(){}

    public Produto(String nome, Double preco){
        this.nome=nome;
        this.preco=preco;
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

    public DadosNutricionais getDadosNutricionais() { return dadosNutricionais; }

    protected void setDadosNutricionais(DadosNutricionais dados) {
        this.dadosNutricionais = dados;
    }

    public Set<Ingrediente> getIngredientes() { return ingredientes; }
}