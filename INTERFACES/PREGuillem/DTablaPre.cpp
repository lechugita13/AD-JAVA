#include "DTablaPre.h"


DTablaPre::DTablaPre(QVector<Bola*> *bolas,QWidget * parent):QDialog(parent){
	
	setupUi(this);

	
	this->bolas = bolas;
	modelo = new Modelo(bolas);
	tabla->setModel(modelo);
	this->adjustSize();
	spinNumBolas->setRange(0,bolas->size());
	connect(spinNumBolas,SIGNAL(valueChanged(int)),this,SLOT(slotActualizar()));
	

	
	
}


void DTablaPre::slotActualizar(){

	

}

Modelo::Modelo(QVector<Bola*> * bolas,QObject *parent) : QAbstractTableModel(parent){

	this->bolas = bolas;

		
}

int Modelo::rowCount(const QModelIndex &parent)const{
	
		
	return bolas->size();
	
}

int Modelo::columnCount(const QModelIndex &parent)const{
	
		
	return 4;
	
}

QVariant Modelo::data(const QModelIndex &index, int role) const{
	
	
	if( role != Qt::DisplayRole ) return QVariant();
	
		if(index.column() == 0){
			
			return QString::number(bolas->at(index.row())->Bola::x);
			
			
			
		}else if(index.column() == 1){
			
			return QString::number(bolas->at(index.row())->Bola::y);
		}else if(index.column() == 2){
			
			return QString::number(bolas->at(index.row())->vX);
		}else if(index.column() == 3){
			
			return QString::number(bolas->at(index.row())->vY);
		}
	
}

QVariant Modelo::headerData(int section, Qt::Orientation orientation, int role = Qt::DisplayRole) const{


	if(role != Qt::DisplayRole ) return QVariant();

	if(orientation == Qt::Horizontal){
		if(section == 0) return QString("PosX");
		if(section == 1) return QString("PosY");
		if(section == 2) return QString("VelX");
		if(section == 3) return QString("VelY");
	}else if(orientation == Qt::Vertical){

		
		for(int i=0;i<section;i++){
			
			return QString("Bola ").append(QString::number(section));
		}
	}

}