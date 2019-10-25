 #include "calculadora.h"

 Calculadora::Calculadora(QWidget *parent):QWidget(parent){


     setupUi(this);
    
    
    //connect(b1,SIGNAL(clicked()),this,SLOT(apagaBoto()));
    connect(b1,SIGNAL(clicked()),this,SLOT(carregaLineEditN()));
    connect(b2,SIGNAL(clicked()),this,SLOT(carregaLineEditN()));

 }


 void Calculadora::carregaLineEditN(){

    display->setText(display->text()+qobject_cast<QPushButton*>(sender())->text());

 };
 