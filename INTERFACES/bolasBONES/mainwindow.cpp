#include "mainwindow.h"
#include "DInformacion.h"
#include "DExamen.h"

#include <QPainter>
#include <QTimer>
#include <math.h>
#include <QMenu>
#include <QMenuBar>
#include <QDebug>


MainWindow::MainWindow(
        QWidget * parent ,
        Qt::WindowFlags flags ) : QMainWindow(parent,flags) {

	QTimer * temporizador = new QTimer();
	/* programar temporizador*/

	temporizador->setInterval(5);
	temporizador->setSingleShot(false);
	temporizador->start();


	/* arrancar temporizador*/

	connect(temporizador,SIGNAL(timeout()),
		this, SLOT(slotRepintar()));

	resize(800,600);

	//b = new Bola (100,100,4,4);

	for (int i=0; i < 100;i++){
	
		bolas.append(new Bola(numAleatorio.bounded(0,800)
		,numAleatorio.bounded(0,600),
		numAleatorio.bounded(-2,4),
		numAleatorio.bounded(-2,4),
		100,i));
	}
	crearAcciones();
	crearMenus();
}

void MainWindow::paintEvent(QPaintEvent *){


	QPainter pintor(this);
	//pintor.fillRect(posX,posY,56,34, QColor(255,0,0));
	//pintor.drawImage(QRect(posX,posY, 50, 50), QImage(":/images/rajoy.png"));
	//pintor.drawEllipse(b->posX, b->posY, 50, 50);

	
	
	for (int i=0; i<bolas.size();i++){

		pintor.setBrush(QBrush(bolas[i]->color));
		pintor.drawEllipse(bolas[i]->posX, bolas[i]->posY, 50, 50);
		bolas[i]->mover(width()-50,height()-50);
		
		int  ancho = 50;
    		float anchoVerde= (((float)bolas[i]->vida) / 100) * (float)ancho;
    		float anchoRojo = (ancho - (float)anchoVerde);

		pintor.drawText(bolas[i]->posX,bolas[i]->posY,QString::number(bolas[i]->vida));
    		pintor.setBrush(Qt::green);
    		pintor.drawRect(bolas[i]->posX,bolas[i]->posY,anchoVerde,5);
    		pintor.setBrush(Qt::red);
    		pintor.drawRect(bolas[i]->posX + anchoVerde,bolas[i]->posY,anchoRojo,5);

		

		
	}

}
void MainWindow::slotRepintar(){

	update();
	for (int i=0; i<bolas.size();i++){

		for(int j=0; j < bolas.size(); j++){
			
			if(bolas[i]->chocar(*(bolas[j]))){
				
				bolas[i]->vida -= 5;
				bolas[j]->vida -= 5;
				
			}
					
		}
	}

	for (int i=0; i<bolas.size();i++){
		if(bolas[i]->vida <= 0){
			bolas.removeAt(i);
		}
	}
}

void MainWindow::crearAcciones(){

	accionMostrarInfo = new QAction("Información",this);
	connect(accionMostrarInfo,SIGNAL(triggered()),
		this, SLOT(slotMostrarDialogoInfo()));

	accionMostrarExamen = new QAction("Examen",this);
	connect(accionMostrarExamen,SIGNAL(triggered()),
		this, SLOT(slotMostrarDialogoExamen()));


}
void MainWindow::crearMenus(){

	QMenu *menuArchivo;
	menuArchivo = menuBar()->addMenu("Archivo");
	menuArchivo->addAction(accionMostrarInfo);
	menuArchivo->addAction(accionMostrarExamen);

}

void MainWindow::slotMostrarDialogoInfo(){

	QString numBolas = QString::number(bolas.size());
	QString tamanyoVentana = QString::number(width()) + "x" + QString::number(height());


	info = new DInformacion(numBolas,tamanyoVentana);
	info->show();
}

void MainWindow::slotMostrarDialogoExamen(){
	
	examen = new DExamen();
	examen->show();

}
void MainWindow::mouseDoubleClickEvent(QMouseEvent *e){

    float mouseX, mouseY;
    mouseX =  e->x() - 50/2;
    mouseY =  e->y() - 50/2;


    Bola * nueva = new Bola(mouseX,mouseY,(rand()%100-50)/50.1,
            (rand()%100-50)/50.1,100,bolas.size());
    bolas.append(nueva);

}



