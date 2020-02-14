/********************************************************************************
** Form generated from reading UI file 'DTablaPRE.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DTABLAPRE_H
#define UI_DTABLAPRE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QCheckBox>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QSpinBox>
#include <QtWidgets/QTableView>
#include <QtWidgets/QVBoxLayout>

QT_BEGIN_NAMESPACE

class Ui_DTablaPre
{
public:
    QVBoxLayout *verticalLayout;
    QTableView *tabla;
    QHBoxLayout *horizontalLayout;
    QCheckBox *chPosX;
    QCheckBox *chPosY;
    QLabel *label;
    QSpinBox *spinNumBolas;
    QSpacerItem *horizontalSpacer;
    QDialogButtonBox *buttonBox;

    void setupUi(QDialog *DTablaPre)
    {
        if (DTablaPre->objectName().isEmpty())
            DTablaPre->setObjectName(QString::fromUtf8("DTablaPre"));
        DTablaPre->resize(516, 471);
        verticalLayout = new QVBoxLayout(DTablaPre);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        tabla = new QTableView(DTablaPre);
        tabla->setObjectName(QString::fromUtf8("tabla"));

        verticalLayout->addWidget(tabla);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        chPosX = new QCheckBox(DTablaPre);
        chPosX->setObjectName(QString::fromUtf8("chPosX"));

        horizontalLayout->addWidget(chPosX);

        chPosY = new QCheckBox(DTablaPre);
        chPosY->setObjectName(QString::fromUtf8("chPosY"));

        horizontalLayout->addWidget(chPosY);

        label = new QLabel(DTablaPre);
        label->setObjectName(QString::fromUtf8("label"));

        horizontalLayout->addWidget(label);

        spinNumBolas = new QSpinBox(DTablaPre);
        spinNumBolas->setObjectName(QString::fromUtf8("spinNumBolas"));

        horizontalLayout->addWidget(spinNumBolas);

        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer);


        verticalLayout->addLayout(horizontalLayout);

        buttonBox = new QDialogButtonBox(DTablaPre);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);

        verticalLayout->addWidget(buttonBox);


        retranslateUi(DTablaPre);
        QObject::connect(buttonBox, SIGNAL(accepted()), DTablaPre, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DTablaPre, SLOT(reject()));

        QMetaObject::connectSlotsByName(DTablaPre);
    } // setupUi

    void retranslateUi(QDialog *DTablaPre)
    {
        DTablaPre->setWindowTitle(QApplication::translate("DTablaPre", "Dialog", nullptr));
        chPosX->setText(QApplication::translate("DTablaPre", "PosX", nullptr));
        chPosY->setText(QApplication::translate("DTablaPre", "PosY", nullptr));
        label->setText(QApplication::translate("DTablaPre", "Numero de Bolas", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DTablaPre: public Ui_DTablaPre {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DTABLAPRE_H
