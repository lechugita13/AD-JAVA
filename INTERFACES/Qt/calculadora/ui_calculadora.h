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
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSplitter>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Calculadora
{
public:
    QHBoxLayout *horizontalLayout_2;
    QVBoxLayout *verticalLayout;
    QLineEdit *display;
    QGridLayout *gridLayout;
    QPushButton *b7;
    QPushButton *b8;
    QPushButton *b9;
    QPushButton *b4;
    QPushButton *b5;
    QPushButton *b6;
    QPushButton *b1;
    QPushButton *b2;
    QPushButton *b3;
    QHBoxLayout *horizontalLayout;
    QPushButton *b0;
    QPushButton *bpunto;
    QSplitter *splitter;
    QPushButton *bmenos;
    QPushButton *bmas;
    QPushButton *bigual;

    void setupUi(QWidget *Calculadora)
    {
        if (Calculadora->objectName().isEmpty())
            Calculadora->setObjectName(QString::fromUtf8("Calculadora"));
        Calculadora->resize(434, 313);
        horizontalLayout_2 = new QHBoxLayout(Calculadora);
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        display = new QLineEdit(Calculadora);
        display->setObjectName(QString::fromUtf8("display"));

        verticalLayout->addWidget(display);

        gridLayout = new QGridLayout();
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        b7 = new QPushButton(Calculadora);
        b7->setObjectName(QString::fromUtf8("b7"));

        gridLayout->addWidget(b7, 0, 0, 1, 1);

        b8 = new QPushButton(Calculadora);
        b8->setObjectName(QString::fromUtf8("b8"));

        gridLayout->addWidget(b8, 0, 1, 1, 1);

        b9 = new QPushButton(Calculadora);
        b9->setObjectName(QString::fromUtf8("b9"));

        gridLayout->addWidget(b9, 0, 2, 1, 1);

        b4 = new QPushButton(Calculadora);
        b4->setObjectName(QString::fromUtf8("b4"));

        gridLayout->addWidget(b4, 1, 0, 1, 1);

        b5 = new QPushButton(Calculadora);
        b5->setObjectName(QString::fromUtf8("b5"));

        gridLayout->addWidget(b5, 1, 1, 1, 1);

        b6 = new QPushButton(Calculadora);
        b6->setObjectName(QString::fromUtf8("b6"));

        gridLayout->addWidget(b6, 1, 2, 1, 1);

        b1 = new QPushButton(Calculadora);
        b1->setObjectName(QString::fromUtf8("b1"));

        gridLayout->addWidget(b1, 2, 0, 1, 1);

        b2 = new QPushButton(Calculadora);
        b2->setObjectName(QString::fromUtf8("b2"));

        gridLayout->addWidget(b2, 2, 1, 1, 1);

        b3 = new QPushButton(Calculadora);
        b3->setObjectName(QString::fromUtf8("b3"));

        gridLayout->addWidget(b3, 2, 2, 1, 1);


        verticalLayout->addLayout(gridLayout);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        b0 = new QPushButton(Calculadora);
        b0->setObjectName(QString::fromUtf8("b0"));

        horizontalLayout->addWidget(b0);

        bpunto = new QPushButton(Calculadora);
        bpunto->setObjectName(QString::fromUtf8("bpunto"));

        horizontalLayout->addWidget(bpunto);


        verticalLayout->addLayout(horizontalLayout);


        horizontalLayout_2->addLayout(verticalLayout);

        splitter = new QSplitter(Calculadora);
        splitter->setObjectName(QString::fromUtf8("splitter"));
        splitter->setOrientation(Qt::Vertical);
        bmenos = new QPushButton(splitter);
        bmenos->setObjectName(QString::fromUtf8("bmenos"));
        splitter->addWidget(bmenos);
        bmas = new QPushButton(splitter);
        bmas->setObjectName(QString::fromUtf8("bmas"));
        splitter->addWidget(bmas);
        bigual = new QPushButton(splitter);
        bigual->setObjectName(QString::fromUtf8("bigual"));
        splitter->addWidget(bigual);

        horizontalLayout_2->addWidget(splitter);


        retranslateUi(Calculadora);

        QMetaObject::connectSlotsByName(Calculadora);
    } // setupUi

    void retranslateUi(QWidget *Calculadora)
    {
        Calculadora->setWindowTitle(QApplication::translate("Calculadora", "Form", nullptr));
        b7->setText(QApplication::translate("Calculadora", "7", nullptr));
        b8->setText(QApplication::translate("Calculadora", "8", nullptr));
        b9->setText(QApplication::translate("Calculadora", "9", nullptr));
        b4->setText(QApplication::translate("Calculadora", "4", nullptr));
        b5->setText(QApplication::translate("Calculadora", "5", nullptr));
        b6->setText(QApplication::translate("Calculadora", "6", nullptr));
        b1->setText(QApplication::translate("Calculadora", "1", nullptr));
        b2->setText(QApplication::translate("Calculadora", "2", nullptr));
        b3->setText(QApplication::translate("Calculadora", "3", nullptr));
        b0->setText(QApplication::translate("Calculadora", "0", nullptr));
        bpunto->setText(QApplication::translate("Calculadora", ".", nullptr));
        bmenos->setText(QApplication::translate("Calculadora", "-", nullptr));
        bmas->setText(QApplication::translate("Calculadora", "+", nullptr));
        bigual->setText(QApplication::translate("Calculadora", "=", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Calculadora: public Ui_Calculadora {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CALCULADORA_H
