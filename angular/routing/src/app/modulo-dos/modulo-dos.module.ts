import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComponenteDosDosComponent } from './componente-dos-dos/componente-dos-dos.component';
import { ComponenteDosUnoComponent } from './componente-dos-uno/componente-dos-uno.component';


@NgModule({
  declarations: [ComponenteDosDosComponent, ComponenteDosUnoComponent],
  imports: [
    CommonModule
  ],
  exports: [
    ComponenteDosDosComponent,
    ComponenteDosUnoComponent
  ]
})
export class ModuloDosModule { }
