import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrencyPipe } from '@angular/common';
import { KeyValuePipe } from '@angular/common';
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { environment } from '../../../environments/environment';
import { HttpHeaders } from '@angular/common/http';
import { RouterLink } from '@angular/router';

registerLocaleData(localePt);

interface Produto {
  id: number;
  nome: string;
  descricao: string;
  preco: number;
  imagemUrl?: string;
  dadosNutricionais: { [key: string]: string };
  ingredientes: string[];
}

interface ProdutoBasico {
  id: number;
  nome: string;
  preco: number;
}

interface Categoria {
  id: number;
  nome: string;
  produtos: ProdutoBasico[];
}

@Component({
  selector: 'app-cardapio',
  standalone: true,
  imports: [CurrencyPipe, KeyValuePipe, RouterLink],
  templateUrl: './cardapio.html',
  styleUrl: './cardapio.css'
})

export class Cardapio implements OnInit{
  /* 
    Atributo para a listagem completa com todos os dados dos produtos.
    Atualmente não está sendo utilizado, mas pode ser útil para futuras implementações.
  */
  produtos: Produto[] = [];

  /* 
    Atributos para a listagem geral com dados básicos (id, nome, preço)
    e, ao clicar em um, carregam-se os dados completos 
    (descrição, ingredientes, dados nutricionais)
    para exibir em um modal.
  */
  produtosBasicos: ProdutoBasico[] = [];
  produtoDados: Produto | undefined;
  selectedId?: number;

  /**
   * Atributo para armazenar as categorias e seus produtos.
   * Utilizado para implementar a listagem geral de produtos,
   * divididos por suas categorias.
   */
  categorias: Categoria[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    // this.getCardapio();
    this.getCardapioBasico();
    this.getCardapioPorCategoria();
  }

  getCardapio(){
    const headers = new HttpHeaders({
      'X-Frontend-URL': window.location.href
    });

    this.http.get<Produto[]>(`${environment.apiUrl}/cardapio`, { headers })
      .subscribe({
        next: (data) => (this.produtos = data),
        error: () => {
          alert('Erro ao carregar o cardápio...');
        }
      });
  }

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

  getCardapioBasico(){
    const headers = new HttpHeaders({
          'X-Frontend-URL': window.location.href
    });

    this.http.get<ProdutoBasico[]>(`${environment.apiUrl}/cardapio/basico`, { headers })
      .subscribe({
        next: (data) => (this.produtosBasicos = data),
        error: () => {
          alert('Erro ao carregar o cardápio...');
          this.http.get(`/`);
        }
      });
  }

  getProdutoDados(id: number){
    const headers = new HttpHeaders({
      'X-Frontend-URL': window.location.href
    });
    this.selectedId = id;
    this.http.get<Produto>(`${environment.apiUrl}/cardapio/${id}`, { headers })
      .subscribe({
        next: (data) => {
          this.produtoDados = data;
        
          this.produtoDados.imagemUrl = this.produtoDados.imagemUrl ? this.produtoDados.imagemUrl : 'assets/nutriburger.jpg';
        },
        error: () => {
          alert('Erro ao carregar dados do produto...');
        }
      });
  }

  abrirModal(id: number) {
    this.getProdutoDados(id);
  }

  formatarDadoNutricional(dado: string): string{
    if (!dado) return '';

    const [valor, unidade] = dado.split(" ");
    if (!valor) return dado;

    const valorFormatado = Number(valor).toLocaleString('pt-BR', { minimumFractionDigits: 1, maximumFractionDigits: 1 });
    return unidade ? `${valorFormatado} ${unidade}` : valorFormatado;
  }
}