#include <QApplication>

 #include "calculadora.h"

 int main(int argc, char *argv[])
 {
     QApplication app(argc, argv);
     Calculadora *dialog = new Calculadora;

    dialog->show();
     return app.exec();
 }
