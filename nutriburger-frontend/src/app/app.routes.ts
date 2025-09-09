import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { Cardapio } from './components/cardapio/cardapio';

export const routes: Routes = [
    { path: '', component: Home},
    { path: 'cardapio', component: Cardapio }
];