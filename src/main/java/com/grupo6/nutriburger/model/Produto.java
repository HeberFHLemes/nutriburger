package com.grupo6.nutriburger.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    /* TODO: incluir os campos/atributos necessários para as consultas retornadas
     *   do banco de dados - entidade Produto */
}