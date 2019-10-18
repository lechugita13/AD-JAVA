#include <QtGui>
#include <QPushButton>
#include <QDialog>
#include <QLCDNumber>
#include <QCheckBox>
#include <QSlider>
#include "dialogoViernes.h"
#include <QVBoxLayout>
#include <QHBoxLayout>

DialogoViernes::DialogoViernes(QWidget *parent) : QDialog(parent)
{

    number = new QLCDNumber();
    slider1 = new QSlider(Qt::Horizontal);
    slider2 = new QSlider(Qt::Horizontal);
    slider3 = new QSlider(Qt::Horizontal);
    okButton = new QPushButton("OK");
    cancellButton = new QPushButton("Cancel");
    activoCheckBox1 = new QCheckBox("Activo");
    activoCheckBox2 = new QCheckBox("Activo");
    activoCheckBox3 = new QCheckBox("Activo");
    unoButton = new QPushButton("1");
    dosButton = new QPushButton("2");

    QVBoxLayout * mainLayout = new QVBoxLayout();

    QHBoxLayout * bottomLayout = new QHBoxLayout();
    QVBoxLayout * rightLayout = new QVBoxLayout();
    QHBoxLayout * rightTopLayout = new QHBoxLayout();
    QHBoxLayout * leftLayout = new QHBoxLayout();
    QHBoxLayout * dalt = new QHBoxLayout();
    QHBoxLayout * mitg = new QHBoxLayout();
    QHBoxLayout * baix = new QHBoxLayout();

    dalt->addWidget(slider1);
    dalt->addWidget(activoCheckBox1);

    mitg->addWidget(slider2);
    mitg->addWidget(activoCheckBox2);

    baix->addWidget(slider3);
    baix->addWidget(activoCheckBox3);

    leftLayout ->addLayout(dalt);
    leftLayout ->addLayout(mitg);
    leftLayout ->addLayout(baix);

    mainLayout->addLayout(leftLayout);

    rightTopLayout->addWidget(unoButton);
    rightTopLayout->addWidget(dosButton);
    rightLayout->addLayout(rightTopLayout);
    rightLayout->addWidget(number);

    mainLayout->addLayout(rightLayout);

    bottomLayout->addWidget(okButton);
    bottomLayout->addWidget(cancellButton);

    mainLayout->addLayout(bottomLayout);

    setLayout(mainLayout);


    connect(slider1,SIGNAL(valueChanged(int)),
        this , SLOT(establecerLCD(int)));

    connect(slider2,SIGNAL(valueChanged(int)),
        this , SLOT(establecerLCD(int)));
        
    connect(slider3,SIGNAL(valueChanged(int)),
        this , SLOT(establecerLCD(int)));


    
}

void DialogoViernes::establecerLCD(int cantidad){
    int suma = slider1->value() +slider2->value() +slider3->value();

    number->display(suma);
}