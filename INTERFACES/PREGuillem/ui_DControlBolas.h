/********************************************************************************
** Form generated from reading UI file 'DControlBolas.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DCONTROLBOLAS_H
#define UI_DCONTROLBOLAS_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_DControlBolas
{
public:
    QDialogButtonBox *buttonBox;
    QTabWidget *tabBolas;
    QWidget *tab;
    QWidget *tab_2;
    QPushButton *botonPararTodas;

    void setupUi(QDialog *DControlBolas)
    {
        if (DControlBolas->objectName().isEmpty())
            DControlBolas->setObjectName(QString::fromUtf8("DControlBolas"));
        DControlBolas->resize(536, 373);
        buttonBox = new QDialogButtonBox(DControlBolas);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(150, 290, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        tabBolas = new QTabWidget(DControlBolas);
        tabBolas->setObjectName(QString::fromUtf8("tabBolas"));
        tabBolas->setGeometry(QRect(40, 50, 361, 181));
        tab = new QWidget();
        tab->setObjectName(QString::fromUtf8("tab"));
        tabBolas->addTab(tab, QString());
        tab_2 = new QWidget();
        tab_2->setObjectName(QString::fromUtf8("tab_2"));
        tabBolas->addTab(tab_2, QString());
        botonPararTodas = new QPushButton(DControlBolas);
        botonPararTodas->setObjectName(QString::fromUtf8("botonPararTodas"));
        botonPararTodas->setGeometry(QRect(410, 260, 89, 25));

        retranslateUi(DControlBolas);
        QObject::connect(buttonBox, SIGNAL(accepted()), DControlBolas, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DControlBolas, SLOT(reject()));

        QMetaObject::connectSlotsByName(DControlBolas);
    } // setupUi

    void retranslateUi(QDialog *DControlBolas)
    {
        DControlBolas->setWindowTitle(QApplication::translate("DControlBolas", "Dialog", nullptr));
        tabBolas->setTabText(tabBolas->indexOf(tab), QApplication::translate("DControlBolas", "Tab 1", nullptr));
        tabBolas->setTabText(tabBolas->indexOf(tab_2), QApplication::translate("DControlBolas", "Tab 2", nullptr));
        botonPararTodas->setText(QApplication::translate("DControlBolas", "Parar todas", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DControlBolas: public Ui_DControlBolas {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DCONTROLBOLAS_H
