#ifndef CALCULADORA_H
#define CALCULADORA_H
#include <QWidget>
#include "ui_calculadora.h"

class Calculadora : public QWidget, public Ui::Calculadora{

    Q_OBJECT

public:
    Calculadora(QWidget *parent=NULL);


public slots:
    
    void carregaLineEditN();
    
};


#endif 