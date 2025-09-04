package com.grupo6.nutriburger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* TODO: definir como será o relacionamento/query para mostrar
    *   tanto os produtos como os seus dados nutricionais,
    *   considerando seus ingredientes. Caso entidade separada, utilizar esta, caso não,
    *   incluir campos e alterações necessárias nas entidades Produto e Ingrediente. */
}