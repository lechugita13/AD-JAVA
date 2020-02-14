#ifndef DTABLAPRE_H
#define DTABLAPRE_H

#include "ui_DTablaPRE.h"
#include <QDialog>
#include "bola.h"
#include <QVariant>
#include <QVector>


class Modelo;

class DTablaPre : public QDialog, public Ui::DTablaPre {

	Q_OBJECT
	
public:

	DTablaPre(QVector<Bola*> *,QWidget * parent = 0);
	QVector<Bola*> * bolas;
	Modelo * modelo;
	


private:

public slots:
	void slotActualizar();

};


class Modelo : public QAbstractTableModel{
	
	Q_OBJECT

public:
	
	QVector<Bola*> * bolas;
	
	Modelo(QVector<Bola*> *,QObject *parent = nullptr);
	int rowCount(const QModelIndex &)const;
	int columnCount(const QModelIndex &)const;
	QVariant data(const QModelIndex &, int) const;
	QVariant headerData(int , Qt::Orientation , int ) const;
	
	
};
#endif