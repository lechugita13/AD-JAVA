#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QTextEdit>

class VentanaPrincipal : public QMainWindow {
Q_OBJECT
public:
        VentanaPrincipal(QWidget * parent = 0, Qt::WindowFlags flags = 0);


private:
        QTextEdit *editorCentral;
         bool bandera = false;
public slots:
        void slotCerrar();
        void slotCopiar();
        void slotPegar();
        void slotCortar();
        void slotNuevo();
        void slotGuardar();
        void slotCambio();

};
#endif 
