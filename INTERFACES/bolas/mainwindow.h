#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPaintEvent>
#include "bola.h"
#include "BolaYWidget.h"
#include <QVector>
#include <QAction>
#include <QMenu>
#include <QRandomGenerator>
#include <QMouseEvent>



class MainWindow : public QMainWindow {
Q_OBJECT
public:
        MainWindow(QWidget * parent = 0, Qt::WindowFlags flags = 0);
          void paintEvent(QPaintEvent *);       
       float  posX;
       float  posY;
       float  velX;
       float velY;
       BolaYWidget * b;
       
       QMouseEvent * eventoInicial;
      
       QVector<BolaYWidget *>bolas;
       QRandomGenerator aleatorizador;
            

       QMenu * menuArchivo;
       QMenu * menuGrafico;
       QAction *accionGraficoBolas;
       QAction * accionInformacion;
       QAction * accionTabBolas;
        void mouseDoubleClickEvent(QMouseEvent *e);
        void mousePressEvent(QMouseEvent * event);
       void mouseReleaseEvent(QMouseEvent * event);
       
public slots:

       void slotRepintar();
       void slotMostrarDialogoInfo();
       void slotMostrarDControlBolas();
      void slotMostrarGraficoBolas();
};
#endif 
