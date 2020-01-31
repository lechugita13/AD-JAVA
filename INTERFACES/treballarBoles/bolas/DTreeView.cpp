#include "DTreeView.h"

DTreeView::DTreeView(QVector<Bola*> *bolas, QWidget * parent):QDialog(parent){
	setupUi(this);
	
    
	this->bolas = bolas;
	modelo = new ModeloArbolBolas(bolas);
	tableView->setModel(modelo);
	this->adjustSize();
	
}

ModeloArbolBolas::ModeloArbolBolas(QVector<Bola*> * bolas,QObject *parent) : QAbstractItemModel(parent){

	this->bolas = bolas;

		
}

int ModeloArbolBolas::rowCount(const QModelIndex &parent)const{


	        /*Bola * bola = static_cast<Bola*>(parent.internalPointer());
            return bola->hijas.size();
            if (!parent.isValid())    return numeroBolasSinpadre();*/
            return 4;


	
}

int ModeloArbolBolas::columnCount(const QModelIndex &parent)const{
	
		
	return 4;
	
}

QVariant ModeloArbolBolas::data(const QModelIndex &index, int role) const{
	
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

QModelIndex ModeloArbolBolas::index(int row, int column, const QModelIndex & parent) const{
    /*Bola * padre = static_cast<Bola *>(parent.internalPointer());*/

    return QModelIndex();

    

}

QModelIndex ModeloArbolBolas::parent ( const QModelIndex & index ) const{
   /* if(!index.isValid()) return QModelIndex();
    if (index.internalPointer() == bolas) return QModelIndex();
    Bola * bola = static_cast<Bola*>(index.internalPointer());
    if (bola->padre == NULL) return QModelIndex();
    
    return createIndex(0,0, bola->padre);*/

    return QModelIndex();
    
    
}
