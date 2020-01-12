#ifndef DCONTROLBOLAS_H
#define DCONTROLBOLAS_H

#include <QDialog>
#include "ui_DControlBolas.h"
#include "bola.h"
#include "BolaYWidget.h"

class DControlBolas : public QDialog,  public Ui::DControlBolas {
Q_OBJECT
public:

    DControlBolas(QVector<BolaYWidget *> bolas,QWidget *parent=0);
    QVector<BolaYWidget *> bolasGastar;
        
public slots:
    void stopAll();
};

#endif  //DINFORMACION_H