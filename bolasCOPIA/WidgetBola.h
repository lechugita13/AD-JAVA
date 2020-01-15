#ifndef WIDGETBOLA_H
#define WIDGETBOLA_H

#include <QDialog>
#include "ui_WidgetBola.h"
#include "bola.h"


class WidgetBola : public QDialog,  public Ui::WidgetBola {
Q_OBJECT
public:
    Bola * bolaSel;
    WidgetBola(Bola * bola,QWidget *parent=0);
    
public slots:
    void slotPararBola();
  
};

#endif  //DINFORMACION_H