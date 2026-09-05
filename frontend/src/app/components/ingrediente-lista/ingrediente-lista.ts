import { Component, inject, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Ingrediente } from '../../services/ingrediente';

@Component({
  selector: 'app-ingrediente-lista',
  imports: [FormsModule],
  templateUrl: './ingrediente-lista.html',
  styleUrl: './ingrediente-lista.css',

})


export class IngredienteLista implements OnInit {

  private ingredienteService = inject(Ingrediente);

  ingredientes = signal<any[]>([]);

  novoCodigo = '';
  novaDescricao = '';
  novoPreco = 0;
  novoItemAdicional = false;

  ngOnInit() {
    this.ingredienteService.listar().subscribe((dados: any) => {
      this.ingredientes.set(dados);


    });
  }

  salvar() {

    let ingrediente: any = {};
    ingrediente.codigo = this.novoCodigo;
    ingrediente.descricao = this.novaDescricao;
    ingrediente.precoUnitario = this.novoPreco;
    ingrediente.itemAdicional = this.novoItemAdicional;

    this.ingredienteService.criar(ingrediente).subscribe((resposta: any) => {
      this.ingredienteService.listar().subscribe((lista: any) => {
        this.ingredientes.set(lista);

      });


    });

  }
}
