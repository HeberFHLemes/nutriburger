package com.grupo6.nutriburger.dto;

/*
Data Transfer Object que será apresentado na listagem principal do cardápio.
Atributos são exemplos e podem ser alterados.
 */
public record ProdutoCardapioDTO(
        String nome,
        Double preco,
        String imagem
) {
}