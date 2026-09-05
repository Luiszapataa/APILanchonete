import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Bebida {

  private http = inject(HttpClient);

  listar() {
    return this.http.get('http://localhost:8080/bebidas');


  }

  criar(bebida: any){
    return this.http.post('http://localhost:8080/bebidas', bebida);

  }

  buscarPorId(id: number){
    return this.http.get(`http://localhost:8080/bebidas/${id}`);

  }

  atualizar(id: number, bebida: any){
    return this.http.put(`http://localhost:8080/bebidas/${id}`, bebida);
  }
}
