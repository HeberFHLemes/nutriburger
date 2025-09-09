package com.grupo6.nutriburger.controller;

import com.grupo6.nutriburger.dto.ProdutoDTO;
import com.grupo6.nutriburger.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getCardapio() {
        return ResponseEntity.ok().body(produtoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getDadosProduto(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.getById(id));
    }
}