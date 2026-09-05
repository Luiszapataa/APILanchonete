import { Component, inject, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Hamburguer } from '../../services/hamburguer';


@Component({
  selector: 'app-hamburguer-lista',
  imports: [FormsModule],
  templateUrl: './hamburguer-lista.html',
  styleUrl: './hamburguer-lista.css',
})

export class HamburguerLista implements OnInit{

  private hamburguerService = inject(Hamburguer);

  hamburgueres = signal<any[]>([]);

  novoCodigo = '';
  novaDescricao = '';
  novoValor = 0;
  novosIdsIngredientes = '';

  ngOnInit() {
    this.hamburguerService.listar().subscribe((dados: any) =>{
      this.hamburgueres.set(dados);
    });

  }

  salvar() {

    let textoIds = this.novosIdsIngredientes;
    let partesTexto = textoIds.split(',');

    let listaIngredientes: any[] = [];

    for (let parte of partesTexto) {
      let numeroId = Number(parte);
      let objetoIngrediente: any = {};
      objetoIngrediente.id = numeroId;
      listaIngredientes[listaIngredientes.length] = objetoIngrediente;

    }

    let hamburguer: any = {};
    hamburguer.codigo = this.novoCodigo;
    hamburguer.descricao = this.novaDescricao;
    hamburguer.valor = this.novoValor;
    hamburguer.hamburguerIngrediente = listaIngredientes;

    this.hamburguerService.criar(hamburguer).subscribe((resposta: any) =>{
      this.hamburguerService.listar().subscribe((lista: any) => {
        this.hamburgueres.set(lista);

      });

    });
  }
}
