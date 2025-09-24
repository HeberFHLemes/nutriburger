package com.grupo6.nutriburger.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity @Immutable
@Table(name = "produto_nutriente")
public final class ProdutoNutriente {

    @EmbeddedId
    private ProdutoNutrienteId id;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id", insertable = false, updatable = false)
    private Produto produto;

    @ManyToOne
    @MapsId("nutrienteId")
    @JoinColumn(name = "nutriente_id", insertable = false, updatable = false)
    private Nutriente nutriente;

    @Column(name = "dado_nutricional")
    private Double dadoNutricional;

    public ProdutoNutriente() {}

    public ProdutoNutrienteId getId() { return id; }
    public Produto getProduto() { return produto; }
    public Nutriente getNutriente() { return nutriente; }
    public Double getDadoNutricional() { return dadoNutricional; }
}
