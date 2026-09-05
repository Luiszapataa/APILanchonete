import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BebidaLista } from './components/bebida-lista/bebida-lista';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, BebidaLista],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('lanchonete-frontend');
}
