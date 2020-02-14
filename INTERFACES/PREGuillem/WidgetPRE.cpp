#include "WidgetPRE.h"
#include <QColorDialog>


WidgetPRE::WidgetPRE(Bola * b, QWidget * parent):QDialog(parent){
	setupUi(this);
	
	bola =b;
	
    connect(rBColor,SIGNAL(clicked()),this,SLOT(slotElegirColor()));
    connect(chBoxMostrarNum,SIGNAL(stateChanged(int)),this,SLOT(slotCheckBoxText));
}


void WidgetPRE::slotElegirColor(){

    	
	QColorDialog *dialogColor = new QColorDialog();
	dialogColor->open();
	QColor colorSelec =  dialogColor->getColor();
	bola->color=colorSelec;
    bola->radio=50;
		
}

void WidgetPRE::slotElegirImagen(){


}

void WidgetPRE::slotCheckBoxText(){

    bola->numBola=NULL;
    

}




