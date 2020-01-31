#ifndef DTREEVIEW_H
#define DTREEVIEW_H
#include "ui_DTreeView.h"
#include <QDialog>
#include "bola.h"
#include <QAbstractItemModel>
#include <QModelIndex>
#include <QVector>
#include <QTableView>

class ModeloArbolBolas;

class DTreeView : public QDialog, public Ui::DTreeView {

	Q_OBJECT
	
public:

	
	DTreeView(QVector<Bola*> *,QWidget * parent = 0);
	QVector<Bola*> * bolas;
	ModeloArbolBolas * modelo;
	QTableView *tableView;
	
	
};

class ModeloArbolBolas: public QAbstractItemModel {
Q_OBJECT
public :
  QVector<Bola*> * bolas;
  ModeloArbolBolas(QVector<Bola*> *,QObject *parent = 0);
  QModelIndex * root;

/*When subclassing QAbstractItemModel, at the very least you must implement index(), parent(), rowCount(), columnCount(), and data(). These functions are used in all read-only models, and form the basis of editable models.*/

QModelIndex index ( int row, int column, const QModelIndex & parent = QModelIndex()) const;
QModelIndex parent ( const QModelIndex & index ) const ;
int rowCount ( const QModelIndex & parent = QModelIndex() ) const ;
int columnCount ( const QModelIndex & parent = QModelIndex() ) const ;
QVariant data ( const QModelIndex & index, int role = Qt::DisplayRole ) const;

};



#endif
