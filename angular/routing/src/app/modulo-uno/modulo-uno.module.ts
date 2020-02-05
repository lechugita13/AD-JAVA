import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComponenteUnoUnoComponent } from './componente-uno-uno/componente-uno-uno.component';
import { ComponenteUnoDosComponent } from './componente-uno-dos/componente-uno-dos.component';



@NgModule({
  declarations: [ComponenteUnoUnoComponent, ComponenteUnoDosComponent],
  imports: [
    CommonModule
  ],
  exports : [
    ComponenteUnoDosComponent,
    ComponenteUnoUnoComponent
  ]
})
export class ModuloUnoModule { }
