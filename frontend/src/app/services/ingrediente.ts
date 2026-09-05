import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';


@Injectable({
  providedIn: 'root',

})


export class Ingrediente {

  private http = inject(HttpClient);

  listar() {
    return this.http.get('http://localhost:8080/ingredientes');

  }

  criar(ingrediente: any){
    return this.http.post('http://localhost:8080/ingredientes', ingrediente);

  }

  buscarPorId(id: number){
    return this.http.get(`http://localhost:8080/ingredientes/${id}`);

  }

  atualizar(id: number, ingrediente: any){
    return this.http.put(`http://localhost:8080/ingredientes/${id}`, ingrediente);
  }
}
