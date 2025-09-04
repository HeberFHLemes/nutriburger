package com.grupo6.nutriburger.service;

import com.grupo6.nutriburger.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    // TODO: implementar regras de negócio e uso da classe de persistência para a entidade Produto.
    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository=produtoRepository;
    }
}
