package com.grupo6.nutriburger.dto;

import com.grupo6.nutriburger.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Teste para verificação de quais atributos estão sendo retornados
 * após consulta com JPA para ProdutoBasicoDTO, em vez de Produto.
 */
@SpringBootTest
public class ProdutoBasicoTest {

    @Autowired
    private ProdutoService produtoService;

    private static final Logger logger = LoggerFactory.getLogger(ProdutoBasicoTest.class);

    private List<ProdutoBasicoDTO> realizarConsulta(){
        long inicioConsulta = System.nanoTime();

        List<ProdutoBasicoDTO> produtosBasicos = produtoService.getProdutosBasicos();

        long fimConsulta = System.nanoTime();
        long duracaoMs = (fimConsulta - inicioConsulta) / 1_000_000;

        int numRegistros = produtosBasicos.size();
        logger.info("Consulta efetuada. {} registros retornados em {} ms.", numRegistros, duracaoMs);

        return produtosBasicos;
    }

    @Test
    public void testarConsulta(){
        List<ProdutoBasicoDTO> produtosBasicos = realizarConsulta();
        int numRegistros = produtosBasicos.size();
        if (numRegistros == 0){
            logger.info("Encerrando teste...");
            return;
        }

        ProdutoBasicoDTO produtoExemplo = produtosBasicos.getFirst();
        logger.info("Testando com um dos produtos retornados.");

        assertThat(produtoExemplo.id()).isNotNull();
        assertThat(produtoExemplo.nome()).isNotNull();
        assertThat(produtoExemplo.preco()).isNotNull();
        logger.info("Os atributos id, nome e preco foram retornado não-nulos.");

        logger.info("Produto de exemplo: ID = {}; NOME = {}; PRECO = {}",
                produtoExemplo.id(),
                produtoExemplo.nome(),
                produtoExemplo.preco()
        );

        logger.info("Medindo tempo de retorno após mais algumas consultas...");
        realizarConsulta();

        realizarConsulta();

        logger.info("Teste encerrado.");
    }
}