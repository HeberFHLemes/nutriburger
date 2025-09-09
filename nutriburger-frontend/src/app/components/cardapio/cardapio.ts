import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrencyPipe } from '@angular/common';
import { KeyValuePipe } from '@angular/common';
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { environment } from '../../../environments/environment';

registerLocaleData(localePt);

interface Produto {
  id: number;
  nome: string;
  preco: number;
  dadosNutricionais: { [key: string]: string | number };
  ingredientes: string[];
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

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getCardapio();
  }

  getCardapio(){
    this.http.get<Produto[]>(`${environment.apiUrl}/cardapio`)
      .subscribe({
        next: (data) => (this.produtos = data),
        error: () => { 
          alert('Erro ao carregar o cardápio...');
        }
      });
  }
}
