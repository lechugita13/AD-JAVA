#include <QtGui>
#include <QCheckBox>
#include <QLabel>
#include <QLineEdit>
#include <QPushButton>
#include <QDialog>
#include <QHBoxLayout>
#include <QVBoxLayout>
#include <QListWidget>
#include "findDialogTester.h"

FindDialogTester::FindDialogTester(QWidget *parent)
        : QDialog(parent)
{
    backward = new QLabel("BackWard");
    forward = new QLabel("ForWard");
    listaIzq = new QListWidget();
    listaDere = new QListWidget();
    QHBoxLayout *layoutTotal = new QHBoxLayout;

    

    QVBoxLayout *layoutLeft = new QVBoxLayout;
    QVBoxLayout *layoutRight = new QVBoxLayout;
    layoutLeft->addWidget(backward);
    layoutRight->addWidget(forward);

    layoutLeft->addWidget(listaIzq);
    layoutRight->addWidget(listaDere);
    layoutTotal->addLayout(layoutLeft);
    layoutTotal->addLayout(layoutRight);
    setLayout(layoutTotal);
}
void FindDialogTester::findNext(const QString &str, Qt::CaseSensitivity cs){

    listaDere->addItem(str);

}

void FindDialogTester::findPrevious(const QString &str, Qt::CaseSensitivity cs){
 listaIzq->addItem(str);
}
