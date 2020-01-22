import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SOY JOSE';
  nombre:string = 'Guillem';
  edad:number = 17;
  numeros:number[]=[1,2,3,4];

  contador:number=1;
  direccion():string{
    
    return 'Calle La Reina';
  }

  incrementar(){
    this.contador++;

  }
  decrementar(){
    this.contador--;

  }
  
}
