#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPaintEvent>
#include "bola.h"
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
       Bola * b;
       
       QMouseEvent * eventoInicial;
      
       QVector<Bola *>bolas;
       QRandomGenerator aleatorizador;
       QMenu * examenMenu;

       QMenu * menuArchivo;
       QAction * accionInformacion;
       QAction * accionExamen;
        void mouseDoubleClickEvent(QMouseEvent *e);
        void mousePressEvent(QMouseEvent * event);
       void mouseReleaseEvent(QMouseEvent * event);
       
public slots:

       void slotRepintar();
       void slotMostrarDialogoInfo();
      void slotMostrarDialogoExamen();
};
#endif 
