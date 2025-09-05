package com.grupo6.nutriburger.controller;

import com.grupo6.nutriburger.model.Produto;
import com.grupo6.nutriburger.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getCardapio(){
        return ResponseEntity.ok().body(produtoService.getAll());
    }
}