#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPaintEvent>
#include <QVector>
#include <QRandomGenerator>
#include "DInformacion.h"
#include "bola.h"
#include "DExamen.h"


class MainWindow : public QMainWindow{
Q_OBJECT
public:
        MainWindow(QWidget * parent = 0, Qt::WindowFlags flags = 0);
	void paintEvent(QPaintEvent *);
	Bola * b;
	DInformacion * info;
	DExamen * examen;

	QVector <Bola*> bolas;
	QRandomGenerator  numAleatorio;
	QAction *accionMostrarInfo, *accionMostrarExamen;

	void crearAcciones();
	void crearMenus();
	void mouseDoubleClickEvent(QMouseEvent *e);


private slots:
	void slotRepintar();
	void slotMostrarDialogoInfo();
	void slotMostrarDialogoExamen();

	
};

#endif 
