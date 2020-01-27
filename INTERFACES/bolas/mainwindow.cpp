#include <QPainter>
#include <QColor>
#include <QTimer>
#include <QMenuBar>
#include <math.h>
#include "mainwindow.h"
#include "DInformacion.h"
#include "DControlBolas.h"
#include "DGraficoBolas.h"
MainWindow::MainWindow(
        QWidget * parent ,
        Qt::WindowFlags flags ) : QMainWindow(parent,flags) {
            QTimer * temporizador = new QTimer();
            /*programare el temporizador */
            temporizador->setInterval(10);
            temporizador->setSingleShot(false);
            temporizador->start();
            QMenuBar  *barra = this->menuBar();
            menuArchivo = menuBar()->addMenu("Archivo");
            menuGrafico = menuBar()->addMenu("Grafico");

            barra->addMenu(menuArchivo);
            barra->addMenu(menuGrafico);
           
            accionGraficoBolas = new QAction("Grafico Bolas",this);
            accionInformacion = new QAction("ver Info",this);
            accionTabBolas = new QAction("Tab Bolas",this);
            menuArchivo->addAction(accionInformacion);
            menuArchivo ->addAction(accionTabBolas);
            menuGrafico->addAction(accionGraficoBolas);
            /*arrancare el temporizador*/

            connect(temporizador,SIGNAL(timeout()),this,SLOT(slotRepintar()));
            connect(accionInformacion,SIGNAL(triggered()),this,SLOT(slotMostrarDialogoInfo()));
            connect(accionTabBolas,SIGNAL(triggered()),this,SLOT(slotMostrarDControlBolas()));
            connect(accionGraficoBolas,SIGNAL(triggered()),this,SLOT(slotMostrarGraficoBolas()));

            resize(800,600);

          
        for (int i = 0; i < 5; i++)
        {
            float velX1 = aleatorizador.bounded(-3,3);
            float velY1 = aleatorizador.bounded(-3,3);
            float posX1 = aleatorizador.bounded(0,800);
            float posY1 = aleatorizador.bounded(0,600);
            float radio1 = aleatorizador.bounded(10,60);
            

            bolas.append(new BolaYWidget(posX1,posY1,velX1,velY1,50));
        }
        


}

void MainWindow::paintEvent(QPaintEvent *event){
      
        
       
         QPainter pintor(this);
         for (int i = 0; i < bolas.size(); i++)
         {
                 float anchoVerde= ((float)bolas[i]->vida / 100) * bolas[i]->radio;
                  float anchoRojo = (1 * bolas[i]->radio);
                  pintor.setBrush(QBrush(bolas[i]->color));
               pintor.drawEllipse(
                   bolas[i]->posX,
                   bolas[i]->posY,
                   bolas[i]->radio,
                   bolas[i]->radio);
                    
                   bolas[i]->moverBola(width(),height());
                    
                    pintor.setBrush(Qt::red);
                    pintor.drawRect(bolas[i]->posX ,bolas[i]->posY,anchoRojo,5);
                    pintor.setBrush(Qt::green);
                    pintor.drawRect(bolas[i]->posX,bolas[i]->posY,anchoVerde,5);

                  
                    for (int j = 0; j < bolas.size(); j++)
                     {
                          if(bolas[i]->chocar(bolas[j])){
                          bolas[i]->trompa();    
                           bolas[j]->trompa();       
                          }
                    }

         }
        
         
}
    

void MainWindow::slotRepintar(){

    /* Ominpresent perfavor pinta la pantalla*/
    update();
    for (int i = 0; i < bolas.size(); i++)
    {
        if (bolas[i]->vida <=0)
        {
            bolas.removeAt(i);
        
            return;
        }
        
    }
    

}
void MainWindow::slotMostrarDialogoInfo(){

    
    DInformacion dialogo(bolas.size(),this->width(),this->height());
    
    dialogo.exec();

}

void MainWindow::slotMostrarDControlBolas(){

    DControlBolas *dialog= new DControlBolas(bolas);

    dialog->show();
    

}

void MainWindow::mouseDoubleClickEvent(QMouseEvent *e){

    float mouseX, mouseY;
    int radio=40;
    mouseX =  e->x() -radio/2;
    mouseY =  e->y() - radio/2;


    BolaYWidget * nueva = new BolaYWidget(mouseX,mouseY,(rand()%100-50)/50.1,(rand()%100-50)/50.1,50);
    bolas.append(nueva);

}

void MainWindow:: mousePressEvent(QMouseEvent * event){
    eventoInicial = new QMouseEvent(*event);

}

void MainWindow::mouseReleaseEvent(QMouseEvent * event){
    if (eventoInicial == NULL ) return;
      int radio=40;
    bolas.append(new BolaYWidget((float)eventoInicial->x() - radio/2,
                (float)eventoInicial->y() - radio/2,
                ( (float)event->x() - eventoInicial->x() ) / 50.2,
                ( (float)event->y() - eventoInicial->y() ) / 50.3,40));



}

void MainWindow::slotMostrarGraficoBolas(){

    DGraficoBolas *dialog = new DGraficoBolas(bolas);

    dialog->show();

}
