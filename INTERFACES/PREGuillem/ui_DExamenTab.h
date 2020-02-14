/********************************************************************************
** Form generated from reading UI file 'DExamenTab.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DEXAMENTAB_H
#define UI_DEXAMENTAB_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QTableWidget>

QT_BEGIN_NAMESPACE

class Ui_DExamenTab
{
public:
    QDialogButtonBox *buttonBox;
    QTableWidget *tableWidget;

    void setupUi(QDialog *DExamenTab)
    {
        if (DExamenTab->objectName().isEmpty())
            DExamenTab->setObjectName(QString::fromUtf8("DExamenTab"));
        DExamenTab->resize(530, 366);
        buttonBox = new QDialogButtonBox(DExamenTab);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(160, 300, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        tableWidget = new QTableWidget(DExamenTab);
        tableWidget->setObjectName(QString::fromUtf8("tableWidget"));
        tableWidget->setGeometry(QRect(30, 20, 471, 251));

        retranslateUi(DExamenTab);
        QObject::connect(buttonBox, SIGNAL(accepted()), DExamenTab, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DExamenTab, SLOT(reject()));

        QMetaObject::connectSlotsByName(DExamenTab);
    } // setupUi

    void retranslateUi(QDialog *DExamenTab)
    {
        DExamenTab->setWindowTitle(QApplication::translate("DExamenTab", "Dialog", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DExamenTab: public Ui_DExamenTab {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DEXAMENTAB_H
