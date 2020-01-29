/********************************************************************************
** Form generated from reading UI file 'DTreeView.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DTREEVIEW_H
#define UI_DTREEVIEW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTreeView>

QT_BEGIN_NAMESPACE

class Ui_Dialog
{
public:
    QDialogButtonBox *buttonBox;
    QTreeView *treeView;
    QPushButton *refreshTree;

    void setupUi(QDialog *Dialog)
    {
        if (Dialog->objectName().isEmpty())
            Dialog->setObjectName(QString::fromUtf8("Dialog"));
        Dialog->resize(622, 482);
        buttonBox = new QDialogButtonBox(Dialog);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(240, 430, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        treeView = new QTreeView(Dialog);
        treeView->setObjectName(QString::fromUtf8("treeView"));
        treeView->setGeometry(QRect(10, 10, 601, 361));
        refreshTree = new QPushButton(Dialog);
        refreshTree->setObjectName(QString::fromUtf8("refreshTree"));
        refreshTree->setGeometry(QRect(210, 390, 201, 25));

        retranslateUi(Dialog);
        QObject::connect(buttonBox, SIGNAL(accepted()), Dialog, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), Dialog, SLOT(reject()));

        QMetaObject::connectSlotsByName(Dialog);
    } // setupUi

    void retranslateUi(QDialog *Dialog)
    {
        Dialog->setWindowTitle(QApplication::translate("Dialog", "Dialog", nullptr));
        refreshTree->setText(QApplication::translate("Dialog", "Recargar Arbol", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Dialog: public Ui_Dialog {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DTREEVIEW_H
