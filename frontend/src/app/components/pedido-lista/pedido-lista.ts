import { Component, inject, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Pedido } from '../../services/pedido';

@Component({
  selector: 'app-pedido-lista',
  imports: [FormsModule],
  templateUrl: './pedido-lista.html',
  styleUrl: './pedido-lista.css',

})

export class PedidoLista implements OnInit {

  private pedidoService = inject(Pedido);

  pedidos = signal<any[]>([]);

  novoCodigo = '';
  novaData = '';
  novaDescricao = '';
  novoNomeCliente = '';
  novoEnderecoCliente = '';
  novoTelefoneCliente = '';
  novoIdHamburguer = 0;
  novaQuantidadeHamburguer = 1;
  novoIdBebida = 0;
  novaQuantidadeBebida = 1;

  ngOnInit(){

    this.pedidoService.listar().subscribe((dados: any) =>{
      this.pedidos.set(dados);

    });

  }

  salvar() {

    let hamburguerEscolhido: any = {};
    hamburguerEscolhido.id = this.novoIdHamburguer;



    let itemHamburguer: any = {};
    itemHamburguer.hamburguer = hamburguerEscolhido;
    itemHamburguer.quantidade = this.novaQuantidadeHamburguer;


    let listaHamburguerPedidos: any[] = [];
    listaHamburguerPedidos[0] = itemHamburguer;


    let bebidaEscolhida: any = {};
    bebidaEscolhida.id = this.novoIdBebida;



    let itemBebida: any = {};
    itemBebida.bebida = bebidaEscolhida;
    itemBebida.quantidade = this.novaQuantidadeBebida;


    let listaBebidaPedidos: any[] = [];
    listaBebidaPedidos[0] = itemBebida;

    let pedido: any = {};

    pedido.codigo = this.novoCodigo;
    pedido.dataPedido = this.novaData;
    pedido.descricao = this.novaDescricao;
    pedido.nomeCliente = this.novoNomeCliente;
    pedido.enderecoCliente = this.novoEnderecoCliente;
    pedido.telefoneCliente = this.novoTelefoneCliente;
    pedido.hamburguerPedidos = listaHamburguerPedidos;
    pedido.bebidaPedidos = listaBebidaPedidos;


    this.pedidoService.criar(pedido).subscribe((resposta: any) =>{

      this.pedidoService.listar().subscribe((lista: any) =>{

        this.pedidos.set(lista);


      });

    });


  }



}
