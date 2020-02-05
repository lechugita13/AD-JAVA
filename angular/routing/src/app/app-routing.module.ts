import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ComponenteUnoUnoComponent } from './modulo-uno/componente-uno-uno/componente-uno-uno.component';
import { ComponenteUnoDosComponent } from './modulo-uno/componente-uno-dos/componente-uno-dos.component';
import { ComponenteDosUnoComponent } from './modulo-dos/componente-dos-uno/componente-dos-uno.component';
import { ComponenteDosDosComponent } from './modulo-dos/componente-dos-dos/componente-dos-dos.component';


const routes: Routes = [
  {path:'componente-uno-uno',component:ComponenteUnoUnoComponent},
  {path:'componente-uno-dos',component:ComponenteUnoDosComponent},
  {path:'componente-dos-uno',component:ComponenteDosUnoComponent},
  {path:'componente-dos-dos',component:ComponenteDosDosComponent},
  {path:'componente-dos-dos/:nombre',component:ComponenteDosDosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
