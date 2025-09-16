import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrencyPipe } from '@angular/common';
import { KeyValuePipe } from '@angular/common';
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { environment } from '../../../environments/environment';
import { HttpHeaders } from '@angular/common/http';

registerLocaleData(localePt);

interface Produto {
  id: number;
  nome: string;
  descricao: string;
  preco: number;
  imagemUrl: string;
  dadosNutricionais: { [key: string]: string | number };
  ingredientes: string[];
}

interface ProdutoBasico {
  id: number;
  nome: string;
  preco: number;
}

@Component({
  selector: 'app-cardapio',
  standalone: true,
  imports: [CurrencyPipe, KeyValuePipe],
  templateUrl: './cardapio.html',
  styleUrl: './cardapio.css'
})

export class Cardapio implements OnInit{
  produtos: Produto[] = [];

  produtosBasicos: ProdutoBasico[] = [];
  produtoDados: Produto | undefined;
  selectedId?: number;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getCardapio();
    this.getCardapioBasico();
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
        },
        error: () => {
          alert('Erro ao carregar dados do produto...');
        }
      });
  }

  abrirModal(id: number) {
    this.getProdutoDados(id);
    
    if (this.produtoDados){
      this.produtoDados.imagemUrl = "assets/produtos/nutriburger.jpg"
      // this.produtoDados.imagemUrl = "assets/produtos/" + this.produtoDados.id + ".jpg";
    }
  }

  tiposDadosNutricionais = ["acucares", "carboidratos", "proteinas", "sodio"];
  formatarDadosNutricionais(dados: { [key: string]: string | number }): string[] {
    let dadosArray = Object.keys(dados).map(key => {
        switch (key) {
          case 'acucares':
            return `Açúcares: ${dados[key]} g`;
          case 'carboidratos':
            return `Carboidratos: ${dados[key]} g`;
          case 'proteinas':
            return `Proteínas: ${dados[key]} g`;
          case 'sodio':
            return `Sódio: ${dados[key]} mg`;
          default:
            return `${key}: ${dados[key]}`;
      }
    });
    return dadosArray;
  }
}