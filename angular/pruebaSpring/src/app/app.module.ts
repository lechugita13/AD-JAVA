import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {PersonaComponent} from './persona/persona.component';
import { PersonaModule } from './persona/persona.module';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PersonaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
