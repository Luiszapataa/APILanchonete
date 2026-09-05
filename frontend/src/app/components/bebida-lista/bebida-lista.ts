import { Component, inject, OnInit, signal } from '@angular/core';

import { Bebida } from '../../services/bebida';

@Component({
  selector: 'app-bebida-lista',
  imports: [],
  templateUrl: './bebida-lista.html',
  styleUrl: './bebida-lista.css',

})


export class BebidaLista implements OnInit {

  private bebidaService = inject(Bebida);
  bebidas = signal<any[]>([]);



  ngOnInit() {
    this.bebidaService.listar().subscribe((dados: any) => {
      this.bebidas.set(dados);

    });


  }
}
