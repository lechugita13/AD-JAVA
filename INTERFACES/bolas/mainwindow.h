#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPaintEvent>
#include "bola.h"
#include <QVector>
#include <QAction>
#include <QMenu>
#include <QRandomGenerator>

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
       QVector<Bola *>bolas;
       QRandomGenerator aleatorizador;
       QMenu * menuArchivo;
      QAction * accionInformacion;

public slots:
       void slotRepintar();
       void slotMostrarDialogoInfo();

};
#endif 
