#include "mainwindow.h"
#include <QStatusBar>
#include <QMenuBar>
#include <QMessageBox>
#include <QAction>
#include <QMenu>

VentanaPrincipal::VentanaPrincipal(
        QWidget * parent ,
        Qt::WindowFlags flags ) : QMainWindow(parent,flags) {

        editorCentral = new QTextEdit(this);
        setCentralWidget(editorCentral);
        QAction *accionSalir = new QAction("F to the chat");
        QAction *accionCopiar = new QAction("Copiar");
        QAction *accionPegar = new QAction("Pegar");
        QAction *accionCortar = new QAction("Cortar");
        QAction *accionNuevo = new QAction("New");
        QAction *accionGuardar = new QAction("Save");
        
        accionGuardar ->setShortcut(QKeySequence::Save);
        accionCopiar ->setShortcut(QKeySequence::Copy);
        accionSalir ->setShortcut(QKeySequence::Close);
        accionCortar ->setShortcut(QKeySequence::Cut);
        accionPegar ->setShortcut(QKeySequence::Paste);
        accionNuevo ->setShortcut(QKeySequence::New);

        connect(accionCopiar,SIGNAL(triggered()),this,SLOT(slotCopiar()));
        connect(accionPegar,SIGNAL(triggered()),this,SLOT(slotPegar()));
        connect(accionCortar,SIGNAL(triggered()),this,SLOT(slotCortar()));
        connect(accionNuevo,SIGNAL(triggered()),this,SLOT(slotNuevo()));
        connect(accionSalir,SIGNAL(triggered()),this,SLOT(slotCerrar()));
        connect(accionGuardar,SIGNAL(triggered()),this,SLOT(slotGuardar()));
        connect(editorCentral,SIGNAL(textChanged()),this,SLOT(slotCambio()));

        QMenu *menuArchivo;
        //QMenu *menuCortar;
        //QMenu *menuPegar;
        //QMenu *menuCopiar;
        QMenu *menuEditar;

        menuArchivo = menuBar() ->addMenu("Archivo");
        menuEditar = menuBar() ->addMenu("Editar");
        //menuEditar = menuBar() ->addMenu("Pegar");
        //menuEditar = menuBar() ->addMenu("Copiar");
       
        menuArchivo ->addAction(accionSalir);
        menuEditar ->addAction(accionCortar);
        menuEditar ->addAction(accionCopiar);
        menuEditar ->addAction(accionPegar);
        menuArchivo ->addAction(accionNuevo);
        menuArchivo ->addAction(accionGuardar);

    setWindowIcon(QIcon(":/images/icon.png"));
}

void VentanaPrincipal::slotCerrar (){
    this -> close();
}
void VentanaPrincipal::slotCopiar (){
    editorCentral ->copy();
}
void VentanaPrincipal::slotPegar (){
    editorCentral ->paste();
}
void VentanaPrincipal::slotCortar (){
    editorCentral ->cut();
}
void VentanaPrincipal::slotNuevo (){    
    if (bandera==true)
    {
    
      editorCentral ->clear();
    }
}
void VentanaPrincipal::slotGuardar (){
  int r = QMessageBox::warning(this,"Editor Clase","Quieres guardar el documento PENK?\n",QMessageBox::Yes | QMessageBox::No
    | QMessageBox::Cancel);
    if (r == QMessageBox::Yes) bandera=true;
    if (!bandera) editorCentral->clear();
   
}

void VentanaPrincipal::slotCambio (){
    bandera =false;
}

