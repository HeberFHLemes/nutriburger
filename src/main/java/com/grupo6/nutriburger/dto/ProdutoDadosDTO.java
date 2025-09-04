package com.grupo6.nutriburger.dto;

/*
Data Transfer Object que apresentará os dados do produto.
Atributos são exemplos e podem ser alterados.
 */
public record ProdutoDadosDTO(
        String nome,
        String descricao,
        Double preco,
        String imagem,
        String dadosNutricionais // A modelar!!!
) {
}