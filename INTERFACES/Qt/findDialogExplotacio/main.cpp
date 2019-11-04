
#include <QApplication>

 #include "findDialog.h"
#include "findDialogTester.h"
 int main(int argc, char *argv[])
 {
     QApplication app(argc, argv);
     FindDialog *dialog = new FindDialog;
      dialog->show();
     FindDialogTester *dialog2= new FindDialogTester;
   
    dialog2->show();

    QObject::connect(dialog ,SIGNAL(findNext(const QString &,Qt::CaseSensitivity)),dialog2,SLOT(findNext(const QString, Qt::CaseSensitivity)));
    QObject::connect(dialog ,SIGNAL(findPrevious(const QString &,Qt::CaseSensitivity)),dialog2,SLOT(findPrevious(const QString, Qt::CaseSensitivity)));
    
    
    
    
    return app.exec();
   
 }

