#ifndef DEXAMENDAM_H
#define DEXAMENDAM_H

#include <QDialog>
#include "ui_DExamenDAM.h"

class DExamenDAM : public QDialog,  public Ui::DExamenDAM {
Q_OBJECT
public:
    DExamenDAM(QWidget *parent=0);
	
	
  

public slots:
      void cambiarNumero();
      void restarProgressBar();
      void realizarAccion();
};

#endif 

//He fet el aparecer spin cambia finalizar cierra el programa cutre