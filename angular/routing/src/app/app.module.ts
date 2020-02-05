import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ModuloUnoModule} from './modulo-uno/modulo-uno.module';
import {ModuloDosModule} from './modulo-dos/modulo-dos.module';

import {RouterLinkActive} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ModuloUnoModule,
    ModuloDosModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
