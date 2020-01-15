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
    QLabel *tituloBolas;
    QLabel *tituloTamanyo;
    QLabel *numBolas;
    QLabel *tamanyoVentana;

    void setupUi(QDialog *DInformacion)
    {
        if (DInformacion->objectName().isEmpty())
            DInformacion->setObjectName(QString::fromUtf8("DInformacion"));
        DInformacion->resize(400, 300);
        buttonBox = new QDialogButtonBox(DInformacion);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(30, 240, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        tituloBolas = new QLabel(DInformacion);
        tituloBolas->setObjectName(QString::fromUtf8("tituloBolas"));
        tituloBolas->setGeometry(QRect(80, 90, 141, 17));
        tituloTamanyo = new QLabel(DInformacion);
        tituloTamanyo->setObjectName(QString::fromUtf8("tituloTamanyo"));
        tituloTamanyo->setGeometry(QRect(80, 130, 131, 17));
        numBolas = new QLabel(DInformacion);
        numBolas->setObjectName(QString::fromUtf8("numBolas"));
        numBolas->setGeometry(QRect(230, 90, 67, 17));
        tamanyoVentana = new QLabel(DInformacion);
        tamanyoVentana->setObjectName(QString::fromUtf8("tamanyoVentana"));
        tamanyoVentana->setGeometry(QRect(230, 130, 67, 17));

        retranslateUi(DInformacion);
        QObject::connect(buttonBox, SIGNAL(accepted()), DInformacion, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DInformacion, SLOT(reject()));

        QMetaObject::connectSlotsByName(DInformacion);
    } // setupUi

    void retranslateUi(QDialog *DInformacion)
    {
        DInformacion->setWindowTitle(QApplication::translate("DInformacion", "Dialog", nullptr));
        tituloBolas->setText(QApplication::translate("DInformacion", "N\303\272meros de bolas:", nullptr));
        tituloTamanyo->setText(QApplication::translate("DInformacion", "Tama\303\261o ventana:", nullptr));
        numBolas->setText(QApplication::translate("DInformacion", "6", nullptr));
        tamanyoVentana->setText(QApplication::translate("DInformacion", "800x600", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DInformacion: public Ui_DInformacion {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DINFORMACION_H
