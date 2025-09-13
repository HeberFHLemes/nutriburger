package com.grupo6.nutriburger.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.util.ArrayList;
import java.util.List;

@Entity @Immutable
@Table(name = "categorias")
public final class Categoria {

    @Id
    private Integer id;

    @Column(insertable = false, updatable = false, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos = new ArrayList<>();

    public Categoria(String nome) {
        this.nome = nome;
    }

    private Categoria(){}

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}