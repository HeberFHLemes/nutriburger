package com.grupo6.nutriburger.service;

import com.grupo6.nutriburger.dto.ProdutoBasicoDTO;
import com.grupo6.nutriburger.dto.ProdutoDTO;
import com.grupo6.nutriburger.model.Produto;
import com.grupo6.nutriburger.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoBasicoDTO> getProdutosBasicos(){
        return produtoRepository.buscarProdutosBasicos();
    }

    public List<ProdutoDTO> getAll(){
        return toListDTO(this.produtoRepository.findAll());
    }

    public ProdutoDTO getById(final Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado..."));
        return new ProdutoDTO(produto);
    }

    private List<ProdutoDTO> toListDTO(List<Produto> produto){
        return produto.stream().map(ProdutoDTO::new).toList();
    }
}