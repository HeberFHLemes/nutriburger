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
@Table(name = "ingrediente")
public final class Ingrediente {

    @Id
    private Integer id;

    @Column(insertable = false, updatable = false)
    private String nome;

    @ManyToMany(mappedBy = "ingredientes")
    @JsonIgnore
    private Set<Produto> produtos = new HashSet<>();

    public Ingrediente(){}

    public Ingrediente(String nome){
        this.nome=nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}