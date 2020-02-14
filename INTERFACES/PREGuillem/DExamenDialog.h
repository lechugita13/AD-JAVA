#ifndef DEXAMENDIALOG_H
#define DEXAMENDIALOG_H

#include "ui_DExamenDialog.h"
#include <QDialog>
#include <QDialog>
#include <QVector>
#include "bola.h"
#include "WidgetPRE.h"

class DExamenDialog : public QDialog, public Ui::DExamenDialog {

	Q_OBJECT
	
public:

	DExamenDialog(QVector<Bola*> * bolas, QWidget * parent = 0);
	QVector <Bola*> *bolas;
	bool bolasMov;

public slots:
	void slotBotoClicked();

};

#endif