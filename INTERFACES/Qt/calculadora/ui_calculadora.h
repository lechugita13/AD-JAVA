/********************************************************************************
** Form generated from reading UI file 'calculadora.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CALCULADORA_H
#define UI_CALCULADORA_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Calculadora
{
public:
    QPushButton *b1;
    QPushButton *b2;
    QPushButton *b3;
    QPushButton *b4;
    QPushButton *b6;
    QPushButton *b5;
    QPushButton *b7;
    QPushButton *b9;
    QPushButton *b8;

    void setupUi(QWidget *Calculadora)
    {
        if (Calculadora->objectName().isEmpty())
            Calculadora->setObjectName(QString::fromUtf8("Calculadora"));
        Calculadora->resize(434, 313);
        b1 = new QPushButton(Calculadora);
        b1->setObjectName(QString::fromUtf8("b1"));
        b1->setGeometry(QRect(40, 210, 89, 25));
        b2 = new QPushButton(Calculadora);
        b2->setObjectName(QString::fromUtf8("b2"));
        b2->setGeometry(QRect(130, 210, 89, 25));
        b3 = new QPushButton(Calculadora);
        b3->setObjectName(QString::fromUtf8("b3"));
        b3->setGeometry(QRect(220, 210, 89, 25));
        b4 = new QPushButton(Calculadora);
        b4->setObjectName(QString::fromUtf8("b4"));
        b4->setGeometry(QRect(40, 180, 89, 25));
        b6 = new QPushButton(Calculadora);
        b6->setObjectName(QString::fromUtf8("b6"));
        b6->setGeometry(QRect(220, 180, 89, 25));
        b5 = new QPushButton(Calculadora);
        b5->setObjectName(QString::fromUtf8("b5"));
        b5->setGeometry(QRect(130, 180, 89, 25));
        b7 = new QPushButton(Calculadora);
        b7->setObjectName(QString::fromUtf8("b7"));
        b7->setGeometry(QRect(40, 150, 89, 25));
        b9 = new QPushButton(Calculadora);
        b9->setObjectName(QString::fromUtf8("b9"));
        b9->setGeometry(QRect(220, 150, 89, 25));
        b8 = new QPushButton(Calculadora);
        b8->setObjectName(QString::fromUtf8("b8"));
        b8->setGeometry(QRect(130, 150, 89, 25));

        retranslateUi(Calculadora);

        QMetaObject::connectSlotsByName(Calculadora);
    } // setupUi

    void retranslateUi(QWidget *Calculadora)
    {
        Calculadora->setWindowTitle(QApplication::translate("Calculadora", "Form", nullptr));
        b1->setText(QApplication::translate("Calculadora", "1", nullptr));
        b2->setText(QApplication::translate("Calculadora", "2", nullptr));
        b3->setText(QApplication::translate("Calculadora", "3", nullptr));
        b4->setText(QApplication::translate("Calculadora", "4", nullptr));
        b6->setText(QApplication::translate("Calculadora", "6", nullptr));
        b5->setText(QApplication::translate("Calculadora", "5", nullptr));
        b7->setText(QApplication::translate("Calculadora", "7", nullptr));
        b9->setText(QApplication::translate("Calculadora", "9", nullptr));
        b8->setText(QApplication::translate("Calculadora", "8", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Calculadora: public Ui_Calculadora {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CALCULADORA_H
