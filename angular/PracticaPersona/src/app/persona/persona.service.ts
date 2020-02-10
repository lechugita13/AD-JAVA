import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from './persona';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private urlGet = 'http://localhost:8080/personas';
  private urlPost = 'http://localhost:8080/personasadd';

  constructor(private http:HttpClient) { }

  getPersonaList(){
    this.http.get<Persona>(this.urlGet);
  }

  addPersona(persona: Persona){
    return this.http.post<Persona>(this.urlPost,persona);
  }
}
