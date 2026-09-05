import { Component, inject, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Bebida } from '../../services/bebida';

@Component({
  selector: 'app-bebida-lista',
  imports: [FormsModule],
  templateUrl: './bebida-lista.html',
  styleUrl: './bebida-lista.css',

})


export class BebidaLista implements OnInit {

  private bebidaService = inject(Bebida);
  bebidas = signal<any[]>([]);

  novoCodigo = '';
  novaDescricao = '';
  novoPreco = 0;
  novoContemAcucar = false;

  ngOnInit() {
    this.bebidaService.listar().subscribe((dados: any) => {
      this.bebidas.set(dados);

    });


  }

  salvar() {
    const bebida = {
      codigo: this.novoCodigo,
      descricao: this.novaDescricao,
      precoUnitario: this.novoPreco,
      contemAcucar: this.novoContemAcucar
    };

    this.bebidaService.criar(bebida).subscribe((dados: any) => {
      this.bebidaService.listar().subscribe((lista: any) => {
        this.bebidas.set(lista);
      });
    });
  }
}
