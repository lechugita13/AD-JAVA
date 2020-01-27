/********************************************************************************
** Form generated from reading UI file 'DGraficoBolas.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DGRAFICOBOLAS_H
#define UI_DGRAFICOBOLAS_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>

QT_BEGIN_NAMESPACE

class Ui_DGraficoBolas
{
public:

    void setupUi(QDialog *DGraficoBolas)
    {
        if (DGraficoBolas->objectName().isEmpty())
            DGraficoBolas->setObjectName(QString::fromUtf8("DGraficoBolas"));
        DGraficoBolas->resize(400, 300);

        retranslateUi(DGraficoBolas);

        QMetaObject::connectSlotsByName(DGraficoBolas);
    } // setupUi

    void retranslateUi(QDialog *DGraficoBolas)
    {
        DGraficoBolas->setWindowTitle(QApplication::translate("DGraficoBolas", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DGraficoBolas: public Ui_DGraficoBolas {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DGRAFICOBOLAS_H
