#ifndef BOLAYWIDGET_H
#define BOLAYWIDGET_H


#include "WidgetBola.h"
#include "bola.h"

class BolaYWidget : public WidgetBola,  public Bola {
Q_OBJECT
public:
    BolaYWidget(float x,float y, float vx, float vy,float radio,QWidget *parent=0);
    
};

#endif  //DINFORMACION_H