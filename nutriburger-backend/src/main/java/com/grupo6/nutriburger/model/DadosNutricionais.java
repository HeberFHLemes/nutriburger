package com.grupo6.nutriburger.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity @Immutable
@Table(name = "produto_dados_nutricionais")
public final class DadosNutricionais {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(insertable = false, updatable = false, nullable = false)
    private Double acucares;

    @Column(insertable = false, updatable = false, nullable = false)
    private Double carboidratos;

    @Column(insertable = false, updatable = false, nullable = false)
    private Double proteinas;

    @Column(insertable = false, updatable = false, nullable = false)
    private Double sodio;

    private DadosNutricionais() {}

    public DadosNutricionais(Produto produto, Double carboidratos, Double proteinas,
                                    Double acucares, Double sodio) {
        this.produto = produto;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.acucares = acucares;
        this.sodio = sodio;
    }

    public Integer getId() { return id; }
    public Produto getProduto() { return produto; }
    public Double getCarboidratos() { return carboidratos; }
    public Double getProteinas() { return proteinas; }
    public Double getAcucares() { return acucares; }
    public Double getSodio() { return sodio; }
}
