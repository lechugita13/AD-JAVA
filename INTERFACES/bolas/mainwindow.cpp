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
            temporizador->setInterval(10);
            temporizador->setSingleShot(false);
            temporizador->start();

            /*arrancare el temporizador*/
            connect(temporizador,SIGNAL(timeout()),this,SLOT(slotRepintar()));
            resize(800,600);

           b =new Bola(100.0,100.0,10.0,10.0,20);
        for (int i = 0; i < 200; i++)
        {
            float velX1 = aleatorizador.bounded(-3,3);
            float velY1 = aleatorizador.bounded(-3,3);
            float posX1 = aleatorizador.bounded(0,800);
            float posY1 = aleatorizador.bounded(0,600);
            //float radio1 = aleatorizador.bounded(10,60);
            bolas.append(new Bola(posX1,posY1,velX1,velY1,20));
        }
        


}

void MainWindow::paintEvent(QPaintEvent *event){
      
        
       
         QPainter pintor(this);
         for (int i = 0; i < bolas.size(); i++)
         {
               pintor.drawEllipse(
                   bolas[i]->posX,
                   bolas[i]->posY,
                   bolas[i]->radio,
                   bolas[i]->radio);
                   bolas[i]->moverBola(width(),height());
                    for (int j = 0; j < bolas.size(); j++)
                     {
                          bolas[i]->chocar(bolas[j]);
                    }
         }
        
         
}
    

void MainWindow::slotRepintar(){

    /* Ominpresent perfavor pinta la pantalla*/
    update();

}