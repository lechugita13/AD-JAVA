#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QTextEdit>
#include <QLabel>

class VentanaPrincipal : public QMainWindow {
Q_OBJECT
public:
        VentanaPrincipal(QWidget * parent = 0, Qt::WindowFlags flags = 0);
        //crearMenus();
        void crearBarrasHerramientas();
        void crearBarraEstado();
		void crearMenu();
private:
        QTextEdit *editorCentral;
         bool bandera = false;
        QAction * accionEscribir;
        QAction * accionEscribir2;
        QAction * accionEscribir3;
        QLabel * etiqueta;
        QAction * accionAbrir;
        QAction * accionSalir;
        void CloseEvent(QCloseEvent * event);
        QAction * accionDesigner;
public slots:
        void slotCerrar();
        void slotCopiar();
        void slotPegar();
        void slotCortar();
        void slotNuevo();
        void slotGuardar();
        void slotCambio();
        void slotEscribir();
        void slotRecalcularHerramientas();
        void slotAbrir();
        void slotDesigner();

};
#endif 
