import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrencyPipe } from '@angular/common';
//import { KeyValuePipe } from '@angular/common';
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { environment } from '../../../environments/environment';
import { HttpHeaders } from '@angular/common/http';
import { RouterLink } from '@angular/router';

registerLocaleData(localePt);

interface DadoNutricional {
  nome: string;
  valor: string;
}

interface Produto {
  id: number;
  nome: string;
  descricao: string;
  preco: number;
  imagemUrl?: string;
  dadosNutricionais: DadoNutricional[];
  ingredientes: string[];
}

interface ProdutoBasico {
  id: number;
  nome: string;
  preco: number;
  imagemUrl?: string;
}

interface Categoria {
  id: number;
  nome: string;
  produtos: ProdutoBasico[];
}

@Component({
  selector: 'app-cardapio',
  standalone: true,
  imports: [CurrencyPipe, RouterLink],
  templateUrl: './cardapio.html',
  styleUrl: './cardapio.css'
})

export class Cardapio implements OnInit{

  /* 
    Atributos para que, ao clicar em um modal,
    carregam-se os dados completos do produto selecionado
    (nome, descrição, preço, ingredientes, dados nutricionais)
    para exibir em um modal.
  */
  produtoDados: Produto | undefined;
  selectedId?: number;

  /**
   * Atributo para armazenar as categorias e seus produtos.
   * Utilizado para implementar a listagem geral de produtos,
   * divididos por suas categorias, sendo que os produtos apresentam
   * apenas os seus dados básicos (id, nome, preço e imagem).
   */
  categorias: Categoria[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getCardapioPorCategoria();
  }

  /**
   * Obtém o cardápio completo, dividido por categorias.
   * Cada categoria contém uma lista de produtos com seus dados básicos
   * (id, nome, preço e imagem).
   * Os dados completos de cada produto são obtidos apenas quando o usuário
   * clica no produto para ver mais detalhes.
   */
  getCardapioPorCategoria(){
    const headers = new HttpHeaders({
      'X-Frontend-URL': window.location.href
    });

    this.http.get<Categoria[]>(`${environment.apiUrl}/cardapio/categorias`, { headers })
      .subscribe({
        next: (data) => {
          this.categorias = data;
        },
        error: () => {
          alert('Erro ao carregar o cardápio...');
        }
      }); 
  }

  /**
   * Obtém os dados completos de um produto.
   * @param id ID do produto a ser buscado
   * @returns Dados completos do produto (nome, descrição, preço, ingredientes, dados nutricionais)
   */
  getProdutoDados(id: number){
    const headers = new HttpHeaders({
      'X-Frontend-URL': window.location.href
    });
    this.selectedId = id;
    this.http.get<Produto>(`${environment.apiUrl}/cardapio/${id}`, { headers })
      .subscribe({
        next: (data) => {
          this.produtoDados = data;
        },
        error: () => {
          alert('Erro ao carregar dados do produto...');
        }
      });
  }

  /**
   * Abre o modal com os dados do produto clicado.
   * @param id ID do produto clicado
   */
  abrirModal(id: number) {
    this.getProdutoDados(id);
  }

  /**
   * Função que formata os dados nutricionais para o formato brasileiro.
   * (decimal com vírgula, uma casa decimal)
   * @param dado Dado nutricional no formato "valor unidade", ex: "250.0 kcal"
   * @returns Dado nutricional formatado, ex: "250,0 kcal"
   */
  formatarDadoNutricional(dado: string): string{
    if (!dado) return '';

    const [valor, unidade] = dado.split(" ");
    if (!valor) return dado;

    const valorFormatado = Number(valor).toLocaleString('pt-BR', { minimumFractionDigits: 1, maximumFractionDigits: 1 });
    return unidade ? `${valorFormatado} ${unidade}` : valorFormatado;
  }
}