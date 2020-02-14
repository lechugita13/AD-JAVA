/********************************************************************************
** Form generated from reading UI file 'DExamenDialog.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DEXAMENDIALOG_H
#define UI_DEXAMENDIALOG_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_DExamenDialog
{
public:
    QDialogButtonBox *buttonBox;
    QTabWidget *tabBolas;
    QWidget *tab;
    QPushButton *BMostrarTexto;

    void setupUi(QDialog *DExamenDialog)
    {
        if (DExamenDialog->objectName().isEmpty())
            DExamenDialog->setObjectName(QString::fromUtf8("DExamenDialog"));
        DExamenDialog->resize(571, 583);
        buttonBox = new QDialogButtonBox(DExamenDialog);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(170, 520, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        tabBolas = new QTabWidget(DExamenDialog);
        tabBolas->setObjectName(QString::fromUtf8("tabBolas"));
        tabBolas->setGeometry(QRect(50, 40, 431, 411));
        tab = new QWidget();
        tab->setObjectName(QString::fromUtf8("tab"));
        tabBolas->addTab(tab, QString());
        BMostrarTexto = new QPushButton(DExamenDialog);
        BMostrarTexto->setObjectName(QString::fromUtf8("BMostrarTexto"));
        BMostrarTexto->setGeometry(QRect(60, 460, 391, 25));

        retranslateUi(DExamenDialog);
        QObject::connect(buttonBox, SIGNAL(accepted()), DExamenDialog, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DExamenDialog, SLOT(reject()));

        tabBolas->setCurrentIndex(0);


        QMetaObject::connectSlotsByName(DExamenDialog);
    } // setupUi

    void retranslateUi(QDialog *DExamenDialog)
    {
        DExamenDialog->setWindowTitle(QApplication::translate("DExamenDialog", "Dialog", nullptr));
        tabBolas->setTabText(tabBolas->indexOf(tab), QApplication::translate("DExamenDialog", "Tab 1", nullptr));
        BMostrarTexto->setText(QApplication::translate("DExamenDialog", "Mostrar Texto", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DExamenDialog: public Ui_DExamenDialog {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DEXAMENDIALOG_H
