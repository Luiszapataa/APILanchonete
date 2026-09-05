import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';



@Injectable({
  providedIn: 'root',

})


export class Pedido {


  private http = inject(HttpClient);


  listar() {
    return this.http.get('http://localhost:8080/pedidos');

  }

  criar(pedido: any){
    return this.http.post('http://localhost:8080/pedidos', pedido);
  }


}
