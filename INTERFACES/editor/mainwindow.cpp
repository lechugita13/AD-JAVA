#include "mainwindow.h"
#include <QStatusBar>
#include <QMenuBar>
#include <QMessageBox>
#include <QAction>
#include <QMenu>
#include <QToolBar>
#include <QLabel>
#include <QDialog>
#include <QFileDialog>
#include <QDebug>
#include <QUrl>
#include <QTextStream>
#include <QTextDocument>
#include <QTextBlock>
#include <QFile>
#include <QApplication>
#include "DBuscarRemplazar.h"

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
        

        accionEscribir = new QAction ("Fantasia 1",this);
        accionEscribir ->  setIcon(QIcon(":/images/icon.png"));
        accionEscribir2 = new QAction ("Fantasia 2",this);
         accionEscribir2 ->  setIcon(QIcon(":/images/icon.png"));
        accionEscribir3 = new QAction ("Fantasia 3",this);
         accionEscribir3 ->  setIcon(QIcon(":/images/icon.png"));
        
        accionDesigner = new QAction("BuscarRemplazar",this);

        connect(accionEscribir,SIGNAL(triggered()),this,SLOT(slotEscribir()));
        connect(accionEscribir2,SIGNAL(triggered()),this,SLOT(slotEscribir()));
        connect(accionEscribir3,SIGNAL(triggered()),this,SLOT(slotEscribir()));

        connect(accionCopiar,SIGNAL(triggered()),this,SLOT(slotCopiar()));
        connect(accionPegar,SIGNAL(triggered()),this,SLOT(slotPegar()));
        connect(accionCortar,SIGNAL(triggered()),this,SLOT(slotCortar()));
        connect(accionNuevo,SIGNAL(triggered()),this,SLOT(slotNuevo()));
        connect(accionSalir,SIGNAL(triggered()),this,SLOT(slotCerrar()));
        connect(accionGuardar,SIGNAL(triggered()),this,SLOT(slotGuardar()));
        
        connect(editorCentral,SIGNAL(textChanged()),this,SLOT(slotCambio()));
        connect(editorCentral,SIGNAL(textChanged()),this,SLOT(slotRecalcularHerramientas()));
        connect(editorCentral,SIGNAL(cursorPositionChanged()),this,SLOT(slotRecalcularHerramientas()));
        accionAbrir = new QAction("Abrir",this);
        accionAbrir->setShortcut(QKeySequence::Open);
        connect(accionAbrir,SIGNAL(triggered()),this,SLOT(slotAbrir()));

        connect(accionDesigner,SIGNAL(triggered()),this,SLOT(slotDesigner()));

        QMenu *menuArchivo;
        QMenu *menuEditar;
        crearBarraEstado();
        menuArchivo = menuBar() ->addMenu("Archivo");
        menuEditar = menuBar() ->addMenu("Editar");
       
        menuArchivo ->addAction(accionAbrir);
        menuArchivo ->addAction(accionSalir);
        menuEditar ->addAction(accionCortar);
        menuEditar ->addAction(accionCopiar);
        menuEditar ->addAction(accionPegar);
        menuArchivo ->addAction(accionNuevo);
        menuArchivo ->addAction(accionGuardar);
        menuArchivo -> addAction(accionDesigner);

        editorCentral-> addAction(accionNuevo);
        editorCentral->setContextMenuPolicy(Qt::ActionsContextMenu);

        QToolBar *barraPrincipal;
        barraPrincipal = this->addToolBar("Prinsipa");
        barraPrincipal->addAction(accionNuevo);
        barraPrincipal->addAction(accionEscribir);
        barraPrincipal->addAction(accionEscribir2);
        barraPrincipal->addAction(accionEscribir3);
        
        
    setWindowIcon(QIcon(":/images/icon.png"));
}


void VentanaPrincipal::slotCerrar (){

    qDebug()<<"Error";
    if (!bandera) slotGuardar();
    QApplication::exit;

    //this -> close();
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
void VentanaPrincipal::CloseEvent(QCloseEvent * event){

    qDebug()<<"Error";
    if (bandera) slotGuardar();
    QApplication::exit;
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
    if (r == QMessageBox::Yes){
     QString titulo("abrir un documentillo");
    QString rutaFichero;
    rutaFichero = 
    QFileDialog::getSaveFileName(this,titulo);
    QFile fichero(rutaFichero);
    QTextStream stream(&fichero);
     if(!fichero.open(QIODevice::WriteOnly)){
        qDebug()<<"Algo va mal con el fichero";
        return;
    }
        for(int i=0;i<editorCentral->document()->blockCount();i++){
            stream<< editorCentral->document()->findBlockByNumber(i).text()<<endl;
        }

    fichero.close();
    }
    if (!bandera) editorCentral->clear();
   
}

void VentanaPrincipal::slotCambio (){
    bandera =false;
}


/*void VentanaPrincipal::crearBarrasHerramientas(){
    QToolBar *barraPrincipal;
    barraPrincipal = this->addToolBar("Prinsipa");
    barraPrincipal->addAction(accionNuevo);
}*/

void VentanaPrincipal::slotEscribir (void){

    //display->setText(display->text()+qobject_cast<QPushButton*>(sender())->text());
    
    QAction * culpable = qobject_cast<QAction *>( sender());
    QString texto = culpable->text();
    editorCentral->append(texto);
}

void VentanaPrincipal::crearBarraEstado(){
   etiqueta = new QLabel("");
    statusBar()->addWidget(etiqueta);
}

void VentanaPrincipal::slotAbrir(){
    QString titulo("abrir un documentillo");
     qDebug() << "Antes de abrir el dialogo";
     QString rutaFichero;
     rutaFichero = 
    QFileDialog::getOpenFileName(this,titulo);
    qDebug() << "Fcihero= "<< rutaFichero;
    //QFileDialog * dialogo = new QFileDialog();
   //QUrl ruta = QFileDialog::directoryUrl();


    editorCentral->clear();
    QFile fichero(rutaFichero);
    if(!fichero.open(QIODevice::ReadOnly)){
        qDebug()<<"Algo va mal con el fichero";
        return;


    }
    QTextStream stream(&fichero);
    
     QString line;
    while (stream.readLineInto(&line)) {
     editorCentral->append(line);
    }

    qDebug() << stream.readLine();
    fichero.close();
}
void VentanaPrincipal::slotRecalcularHerramientas(){
  
   
    QString texto("");
    int numParrafos = editorCentral->document()->blockCount();
    texto = QString ("parrafos: ")+ QString::number(numParrafos);   
    int col = editorCentral->textCursor().columnNumber();
    texto = texto + QString(" columna: ")+ QString::number(col);
    int fila = editorCentral->textCursor().blockNumber();
    texto = texto + QString(" fila: ")+ QString::number(fila);
    
    etiqueta->setText(texto);
    
}

void VentanaPrincipal::slotDesigner(void){
        QString texto = editorCentral->textCursor().selectedText();
        DBuscarRemplazar *dbr = new DBuscarRemplazar(texto);
        dbr->show();  
}