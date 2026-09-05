import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';


@Injectable({
  providedIn: 'root',

})


export class Hamburguer {


  private http = inject(HttpClient);

  listar() {
    return this.http.get('http://localhost:8080/hamburgueres');


  }

  criar(hamburguer: any){
    return this.http.post('http://localhost:8080/hamburgueres', hamburguer);


  }

  buscarPorId(id: number){
    return this.http.get(`http://localhost:8080/hamburgueres/${id}`);

  }

  atualizar(id: number, hamburguer: any){
    return this.http.put(`http://localhost:8080/hamburgueres/${id}`, hamburguer);
  }
}
