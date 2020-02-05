import { Component, OnInit } from '@angular/core';
import{ActivatedRoute, Params} from '@angular/router';
@Component({
  selector: 'app-componente-dos-dos',
  templateUrl: './componente-dos-dos.component.html',
  styleUrls: ['./componente-dos-dos.component.css']
})
export class ComponenteDosDosComponent implements OnInit {

  nombre: string;
  constructor(private rutaActiva:ActivatedRoute) { }

  ngOnInit() {
    this.rutaActiva.params.subscribe(
      (parms:Params) =>{
        this.nombre = this.rutaActiva.snapshot.params.nombre;
      }
    );
   
  }

}
