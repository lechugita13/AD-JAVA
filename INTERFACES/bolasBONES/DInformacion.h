#ifndef DINFORMACION_H
#define DINFORMACION_H

#include <QDialog>
#include "ui_DInformacion.h"

class DInformacion : public QDialog,  public Ui::DInformacion {
Q_OBJECT
public:
    DInformacion(QString numBolas, QString tamanyoVentana, QWidget *parent=0);
	
	
};

#endif 
