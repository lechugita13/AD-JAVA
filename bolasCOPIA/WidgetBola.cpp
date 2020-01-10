#include "WidgetBola.h"


WidgetBola::WidgetBola(Bola * bola,QWidget *parent): QDialog(parent){
     setupUi(this);
    
    bolaSel = bola;
    connect(botonParar,SIGNAL(clicked()),this,SLOT(slotPararBola()));
    

}

void WidgetBola::slotPararBola(){
    bolaSel->velY=0;
    bolaSel->velX=0;

}



