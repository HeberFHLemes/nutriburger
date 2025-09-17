package com.grupo6.nutriburger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Entity @Immutable
@Table(name = "produtos")
public final class Produto {

    @Id
    private Integer id;

    @Column(insertable = false, updatable = false, nullable = false)
    private String nome;

    @Column(insertable = false, updatable = false, nullable = false)
    private String descricao;

    @Column(insertable = false, updatable = false, nullable = false)
    private Double preco;

    @Column(name = "imagem_url", insertable = false, updatable = false)
    private String imagemUrl;

    @OneToOne(mappedBy = "produto", fetch = FetchType.EAGER)
    private DadosNutricionais dadosNutricionais;

    @ManyToMany
    @JoinTable(
            name = "produto_ingrediente",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    @OrderBy("id ASC")
    private Set<Ingrediente> ingredientes = new HashSet<>();

    @ManyToOne @JsonIgnore
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    protected Produto(){}

    public Produto(String nome, Double preco){
        this.nome=nome;
        this.preco=preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() { return descricao; }

    public Double getPreco() {
        return preco;
    }

    public DadosNutricionais getDadosNutricionais() { return dadosNutricionais; }

    public Set<Ingrediente> getIngredientes() { return ingredientes; }
}