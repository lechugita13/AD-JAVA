/********************************************************************************
** Form generated from reading UI file 'DInformacion.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DINFORMACION_H
#define UI_DINFORMACION_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>

QT_BEGIN_NAMESPACE

class Ui_DInformacion
{
public:
    QDialogButtonBox *buttonBox;
    QLabel *NumBolas;
    QLabel *TamFinestra;
    QLabel *NumBolasModificar;
    QLabel *ResolucionPantalla;

    void setupUi(QDialog *DInformacion)
    {
        if (DInformacion->objectName().isEmpty())
            DInformacion->setObjectName(QString::fromUtf8("DInformacion"));
        DInformacion->resize(400, 301);
        buttonBox = new QDialogButtonBox(DInformacion);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(30, 240, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        NumBolas = new QLabel(DInformacion);
        NumBolas->setObjectName(QString::fromUtf8("NumBolas"));
        NumBolas->setGeometry(QRect(60, 70, 121, 17));
        TamFinestra = new QLabel(DInformacion);
        TamFinestra->setObjectName(QString::fromUtf8("TamFinestra"));
        TamFinestra->setGeometry(QRect(60, 130, 121, 17));
        NumBolasModificar = new QLabel(DInformacion);
        NumBolasModificar->setObjectName(QString::fromUtf8("NumBolasModificar"));
        NumBolasModificar->setGeometry(QRect(280, 70, 67, 17));
        ResolucionPantalla = new QLabel(DInformacion);
        ResolucionPantalla->setObjectName(QString::fromUtf8("ResolucionPantalla"));
        ResolucionPantalla->setGeometry(QRect(280, 130, 67, 17));

        retranslateUi(DInformacion);
        QObject::connect(buttonBox, SIGNAL(accepted()), DInformacion, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DInformacion, SLOT(reject()));

        QMetaObject::connectSlotsByName(DInformacion);
    } // setupUi

    void retranslateUi(QDialog *DInformacion)
    {
        DInformacion->setWindowTitle(QApplication::translate("DInformacion", "Dialog", nullptr));
        NumBolas->setText(QApplication::translate("DInformacion", "Numero de bolas", nullptr));
        TamFinestra->setText(QApplication::translate("DInformacion", "Tama\303\261o finestra", nullptr));
        NumBolasModificar->setText(QApplication::translate("DInformacion", "10", nullptr));
        ResolucionPantalla->setText(QApplication::translate("DInformacion", "800x600", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DInformacion: public Ui_DInformacion {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DINFORMACION_H
