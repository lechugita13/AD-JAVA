#ifndef DCONTROLBOLAS_H
#define DCONTROLBOLAS_H

#include <QDialog>
#include "ui_DControlBolas.h"
#include "bola.h"

class DControlBolas : public QDialog,  public Ui::DControlBolas {
Q_OBJECT
public:

    DControlBolas(QVector<Bola *> bolas,QWidget *parent=0);
    QVector<Bola *> bolasGastar;
        
public slots:
     void slotCambiarColorSel();
};

#endif  //DINFORMACION_H