#ifndef DEXAMEN_H
#define DEXAMEN_H

#include <QDialog>
#include "ui_DExamen.h"

class DExamen : public QDialog,  public Ui::DExamen {
Q_OBJECT
public:
    DExamen(QWidget *parent=0);
	
	
};

#endif 
