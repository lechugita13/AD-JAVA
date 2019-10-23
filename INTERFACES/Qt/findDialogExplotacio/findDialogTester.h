#ifndef FINDDIALOGTESTER_H
#define FINDDIALOGTESTER_H

 #include <QDialog>

 class QListWidget;
 class QLabel;

 class FindDialogTester : public QDialog
{
     Q_OBJECT

 public:
     FindDialogTester(QWidget *parent = 0);
     QLabel *backward;
     QLabel *forward;
     QListWidget * listaIzq;
     QListWidget *listaDere;


public slots:

void findPrevious(const QString &str, Qt::CaseSensitivity cs);
void findNext(const QString &str, Qt::CaseSensitivity cs);
    

};
#endif

