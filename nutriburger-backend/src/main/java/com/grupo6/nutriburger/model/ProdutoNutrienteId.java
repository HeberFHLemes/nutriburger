package com.grupo6.nutriburger.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
/** Classe para referenciar a chave primária composta da tabela produto_nutriente. */
@Embeddable
public class ProdutoNutrienteId implements Serializable {

    @Column(name = "produto_id")
    private Integer produtoId;

    @Column(name = "nutriente_id")
    private Integer nutrienteId;

    public ProdutoNutrienteId() {}

    public ProdutoNutrienteId(Integer produtoId, Integer nutrienteId) {
        this.produtoId = produtoId;
        this.nutrienteId = nutrienteId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((produtoId == null) ? 0 : produtoId.hashCode());
        result = prime * result + ((nutrienteId == null) ? 0 : nutrienteId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProdutoNutrienteId other = (ProdutoNutrienteId) obj;
        if (produtoId == null) {
            if (other.produtoId != null)
                return false;
        } else if (!produtoId.equals(other.produtoId))
            return false;
        if (nutrienteId == null) {
            if (other.nutrienteId != null)
                return false;
        } else if (!nutrienteId.equals(other.nutrienteId))
            return false;
        return true;
    }
}
