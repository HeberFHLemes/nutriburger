package com.grupo6.nutriburger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NutriburgerController {

    @RequestMapping("/")
    public String home(){
        return "Bem-vindo!";
    }

    /*
    TODO: criar as rotas
      - /: tela inicial, talvez uma mensagem de boas-vindas ou logo o /cardapio.
      - /cardapio: listagem dos produtos
      - /dados: dados do produto selecionado
     */
}