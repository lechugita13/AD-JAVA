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

class Ui_DTreeView
{
public:
    QDialogButtonBox *buttonBox;
    QTreeView *treeView;
    QPushButton *refreshTree;

    void setupUi(QDialog *DTreeView)
    {
        if (DTreeView->objectName().isEmpty())
            DTreeView->setObjectName(QString::fromUtf8("DTreeView"));
        DTreeView->resize(622, 482);
        buttonBox = new QDialogButtonBox(DTreeView);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(240, 430, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        treeView = new QTreeView(DTreeView);
        treeView->setObjectName(QString::fromUtf8("treeView"));
        treeView->setGeometry(QRect(10, 10, 601, 361));
        refreshTree = new QPushButton(DTreeView);
        refreshTree->setObjectName(QString::fromUtf8("refreshTree"));
        refreshTree->setGeometry(QRect(210, 390, 201, 25));

        retranslateUi(DTreeView);
        QObject::connect(buttonBox, SIGNAL(accepted()), DTreeView, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DTreeView, SLOT(reject()));

        QMetaObject::connectSlotsByName(DTreeView);
    } // setupUi

    void retranslateUi(QDialog *DTreeView)
    {
        DTreeView->setWindowTitle(QApplication::translate("DTreeView", "Dialog", nullptr));
        refreshTree->setText(QApplication::translate("DTreeView", "Recargar Arbol", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DTreeView: public Ui_DTreeView {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DTREEVIEW_H
