
#include <QApplication>

 #include "dialogoViernes.h"

 int main(int argc, char *argv[])
 {
     QApplication app(argc, argv);
     DialogoViernes *dialog = new DialogoViernes;
    dialog->show();
     return app.exec();
 }

