#include "WidgetBola.h"
#include <QColorDialog>

WidgetBola::WidgetBola(Bola * bola,QWidget *parent): QDialog(parent){
     setupUi(this);
    
    bolaSel = bola;
    connect(botonParar,SIGNAL(clicked()),this,SLOT(slotPararBola()));
    connect(botonColor,SIGNAL(clicked()),this,SLOT(cambiarColor()));

}

void WidgetBola::slotPararBola(){
    bolaSel->velY=0;
    bolaSel->velX=0;

}

void WidgetBola::cambiarColor(){

    QColorDialog *dialogColor;
    dialogColor = new QColorDialog;

    QColor color = dialogColor->getColor();
    bolaSel->color=color;
}


