package com.grupo6.nutriburger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /* TODO: incluir os campos/atributos necessários para as consultas retornadas
     *   do banco de dados - entidade Ingrediente (dados nutricionais) */
}