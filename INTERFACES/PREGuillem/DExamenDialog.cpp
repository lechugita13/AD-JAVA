#include "DExamenDialog.h"
#include "WidgetPRE.h"

DExamenDialog::DExamenDialog(QVector<Bola*> *bolas,QWidget * parent):QDialog(parent){
	
	setupUi(this);
	tabBolas->clear();
	
	for (int i=0; i < bolas->size(); i++){
		tabBolas->insertTab(i, new WidgetPRE(bolas->at(i)), QString("Bola") + QString::number(i));
	}
	

	connect(BMostrarTexto,SIGNAL(clicked()),this,SLOT(slotBotoClicked()));

}


void DExamenDialog::slotBotoClicked(){


		for (int i=0; i < bolas->size(); i++){
				bolas->at(i)->numBola=NULL;
			}
}