#include  "DExamenDAM.h"

DExamenDAM::DExamenDAM(QWidget *parent) : QDialog(parent) {
    	setupUi(this);
    
     progressBar->setFormat(QString("%m"));
     connect(spinBolas,SIGNAL(valueChanged(int)),this,SLOT(cambiarNumero()));
     connect(BotonFinalizar,SIGNAL(clicked()),this,SLOT(restarProgressBar()));
    
     connect(progressBar,SIGNAL(valueChanged(int)),this,SLOT(restarProgressBar()));
     connect(botonRealizar,SIGNAL(clicked()),this,SLOT(realizarAccion()));
}

void DExamenDAM::cambiarNumero(){


     lcdBolas->display(QString::number(spinBolas->value()));
     
}
void DExamenDAM::restarProgressBar(){
     

    
     progressBar->setValue(1);
     
     this->close();
       
}

void DExamen::realizarAccion(){

     if (comboAccion->count()==1)
     {
          if(rbRato->isChecked()){
               int r = QMessageBox::warning(this,"Tarde","Establecer lento o rapido?\n",QMessageBox::Yes | QMessageBox::No
    | QMessageBox::Cancel);
    if (r == QMessageBox::Yes){
     QString titulo("Setear");
          }
     }
     
}


