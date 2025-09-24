package com.grupo6.nutriburger.service;

import com.grupo6.nutriburger.dto.DadosNutricionaisDTO;
import com.grupo6.nutriburger.dto.ProdutoBasicoDTO;
import com.grupo6.nutriburger.dto.ProdutoDTO;
import com.grupo6.nutriburger.model.Produto;
import com.grupo6.nutriburger.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoBasicoDTO> getProdutosBasicos(){
        return produtoRepository.buscarProdutosBasicos();
    }

    public List<ProdutoDTO> getAll(){
        return toListDTO(this.produtoRepository.findAll());
    }

    public ProdutoDTO getById(final Integer id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado..."));
        return toDTO(produto);
    }

    private List<ProdutoDTO> toListDTO(List<Produto> produto){
        return produto.stream().map(p -> toDTO(p)).toList();
    }

    private ProdutoDTO toDTO(Produto produto){
        
        List<DadosNutricionaisDTO> dadosNutricionais = produto.getNutrientes()
            .stream().map(pn -> new DadosNutricionaisDTO(
                pn.getNutriente().getNome(), 
                pn.getDadoNutricional(),
                pn.getNutriente().getUnidadeMedida())).toList();

        return new ProdutoDTO(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getImagemUrl(),
            dadosNutricionais
        );
    }
}