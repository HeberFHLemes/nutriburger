package com.grupo6.nutriburger.controller;

import com.grupo6.nutriburger.dto.ProdutoDTO;
import com.grupo6.nutriburger.service.ProdutoService;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cardapio")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET})
public class CardapioController {

    private static final Logger logger = LoggerFactory.getLogger(CardapioController.class);

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getCardapio(HttpServletRequest request){
        String frontendUrl = request.getHeader("X-Frontend-URL");
        logger.info("Requisição vinda de: " + frontendUrl);
        logger.info("Retornando cardápio completo...");
        return ResponseEntity.ok().body(produtoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getDadosProduto(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.getById(id));
    }
}