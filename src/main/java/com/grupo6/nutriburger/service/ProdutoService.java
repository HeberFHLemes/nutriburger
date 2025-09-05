package com.grupo6.nutriburger.service;

import com.grupo6.nutriburger.model.Produto;
import com.grupo6.nutriburger.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    // TODO: implementar regras de negócio e uso da classe de persistência para a entidade Produto.

    @Autowired
    private ProdutoRepository produtoRepository;

    // public ProdutoService(ProdutoRepository produtoRepository){ this.produtoRepository=produtoRepository; }

    public List<Produto> getAll(){
        return this.produtoRepository.findAll();
    }
}