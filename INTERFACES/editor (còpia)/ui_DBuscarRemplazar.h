/********************************************************************************
** Form generated from reading UI file 'DBuscarRemplazar.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DBUSCARREMPLAZAR_H
#define UI_DBUSCARREMPLAZAR_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>

QT_BEGIN_NAMESPACE

class Ui_DBuscarRemplazar
{
public:
    QDialogButtonBox *buttonBox;
    QLabel *label;
    QLabel *label_2;
    QLineEdit *leBuscar;
    QLineEdit *leRemplazar;

    void setupUi(QDialog *DBuscarRemplazar)
    {
        if (DBuscarRemplazar->objectName().isEmpty())
            DBuscarRemplazar->setObjectName(QString::fromUtf8("DBuscarRemplazar"));
        DBuscarRemplazar->resize(400, 300);
        buttonBox = new QDialogButtonBox(DBuscarRemplazar);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(30, 240, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        label = new QLabel(DBuscarRemplazar);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(60, 90, 67, 17));
        label_2 = new QLabel(DBuscarRemplazar);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(60, 130, 67, 17));
        leBuscar = new QLineEdit(DBuscarRemplazar);
        leBuscar->setObjectName(QString::fromUtf8("leBuscar"));
        leBuscar->setGeometry(QRect(160, 90, 113, 25));
        leRemplazar = new QLineEdit(DBuscarRemplazar);
        leRemplazar->setObjectName(QString::fromUtf8("leRemplazar"));
        leRemplazar->setGeometry(QRect(160, 130, 113, 25));

        retranslateUi(DBuscarRemplazar);
        QObject::connect(buttonBox, SIGNAL(accepted()), DBuscarRemplazar, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DBuscarRemplazar, SLOT(reject()));

        QMetaObject::connectSlotsByName(DBuscarRemplazar);
    } // setupUi

    void retranslateUi(QDialog *DBuscarRemplazar)
    {
        DBuscarRemplazar->setWindowTitle(QApplication::translate("DBuscarRemplazar", "Dialog", nullptr));
        label->setText(QApplication::translate("DBuscarRemplazar", "Buscar", nullptr));
        label_2->setText(QApplication::translate("DBuscarRemplazar", "Remplazar", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DBuscarRemplazar: public Ui_DBuscarRemplazar {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DBUSCARREMPLAZAR_H
