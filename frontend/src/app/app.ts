import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BebidaLista } from './components/bebida-lista/bebida-lista';
import { IngredienteLista } from './components/ingrediente-lista/ingrediente-lista';
import { HamburguerLista } from './components/hamburguer-lista/hamburguer-lista';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, BebidaLista, IngredienteLista, HamburguerLista],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('lanchonete-frontend');
}
