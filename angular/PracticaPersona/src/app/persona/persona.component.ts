import { Component, OnInit } from '@angular/core';
import { PersonaService } from './persona.service';
import { Persona } from './persona';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  auxPersona: Persona= new Persona();
  constructor(private personaService: PersonaService) { }

  ngOnInit() {
  }
guardarPersona(){
  this.auxPersona.nombre="Guillem";
  this.auxPersona.apellido="Clar";
  this.auxPersona.email="pepe@pepe.com";

  this.personaService.addPersona(this.auxPersona).subscribe(data=>{
    this.auxPersona.id = data.id;

  }
  );

}
}
