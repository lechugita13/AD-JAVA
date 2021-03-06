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
#include <QDragEnterEvent>
#include <QDropEvent>
#include <QPoint>

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
       QPoint startPos;
       QVector<Bola *>bolas;
       QRandomGenerator aleatorizador;
            

       QMenu * menuArchivo;
       QAction * accionInformacion;
       QAction * accionTabBolas;
        void mouseDoubleClickEvent(QMouseEvent *e);
        void mousePressEvent(QMouseEvent * event);
       void mouseReleaseEvent(QMouseEvent * event);
         void dragEnterEvent(QDragEnterEvent *event);
        void mouseMoveEvent(QMouseEvent *event);
      void dropEvent(QDropEvent *event);
      void performDrag();
      void dragEnterEvent(QDragEnterEvent *event);
       
public slots:

       void slotRepintar();
       void slotMostrarDialogoInfo();
       void slotMostrarDControlBolas();
     
};
#endif 
