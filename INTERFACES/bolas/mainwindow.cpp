#include <QPainter>
#include <QColor>
#include <QTimer>
#include <math.h>
#include "mainwindow.h"


MainWindow::MainWindow(
        QWidget * parent ,
        Qt::WindowFlags flags ) : QMainWindow(parent,flags) {
            QTimer * temporizador = new QTimer();
            /*programare el temporizador */
            temporizador->setInterval(50);
            temporizador->setSingleShot(false);
            temporizador->start();

            /*arrancare el temporizador*/
            connect(temporizador,SIGNAL(timeout()),this,SLOT(slotRepintar()));
            resize(800,600);
        posX = 100;
        posY = 100;
        velX = 10;
        velY = 10;
        bool derecha = true;


}

void MainWindow::paintEvent(QPaintEvent *event){
    

        QPainter pintor(this);
        pintor.drawEllipse(posX,posY,20,20);
       
     
    
    if (posX>=780)
        velX = -fabs(velX);

    if (posX<=0)
        velX = fabs(velX);
    
    if (posY<= 0)
        velY = fabs(velY);
    
    if (posY>=580)
        velY = -fabs(velY);
    posX+=velX;
    posY+=velY;
      
}
    

void MainWindow::slotRepintar(){

    /* Ominpresent perfavor pinta la pantalla*/
    update();

}