/********************************************************************************
** Form generated from reading UI file 'WidgetPRE.ui'
**
** Created by: Qt User Interface Compiler version 5.12.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_WIDGETPRE_H
#define UI_WIDGETPRE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QCheckBox>
#include <QtWidgets/QFrame>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_WidgetPRE
{
public:
    QVBoxLayout *verticalLayout_2;
    QGroupBox *groupBox;
    QHBoxLayout *horizontalLayout;
    QVBoxLayout *verticalLayout;
    QRadioButton *rBImagen;
    QRadioButton *rBColor;
    QRadioButton *radioButton;
    QSpacerItem *verticalSpacer;
    QCheckBox *chBoxMostrarNum;
    QLabel *label;
    QHBoxLayout *horizontalLayout_2;
    QFrame *frame;
    QSpacerItem *horizontalSpacer;

    void setupUi(QWidget *WidgetPRE)
    {
        if (WidgetPRE->objectName().isEmpty())
            WidgetPRE->setObjectName(QString::fromUtf8("WidgetPRE"));
        WidgetPRE->resize(229, 386);
        verticalLayout_2 = new QVBoxLayout(WidgetPRE);
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        groupBox = new QGroupBox(WidgetPRE);
        groupBox->setObjectName(QString::fromUtf8("groupBox"));
        horizontalLayout = new QHBoxLayout(groupBox);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        rBImagen = new QRadioButton(groupBox);
        rBImagen->setObjectName(QString::fromUtf8("rBImagen"));

        verticalLayout->addWidget(rBImagen);

        rBColor = new QRadioButton(groupBox);
        rBColor->setObjectName(QString::fromUtf8("rBColor"));

        verticalLayout->addWidget(rBColor);

        radioButton = new QRadioButton(groupBox);
        radioButton->setObjectName(QString::fromUtf8("radioButton"));

        verticalLayout->addWidget(radioButton);


        horizontalLayout->addLayout(verticalLayout);


        verticalLayout_2->addWidget(groupBox);

        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_2->addItem(verticalSpacer);

        chBoxMostrarNum = new QCheckBox(WidgetPRE);
        chBoxMostrarNum->setObjectName(QString::fromUtf8("chBoxMostrarNum"));

        verticalLayout_2->addWidget(chBoxMostrarNum);

        label = new QLabel(WidgetPRE);
        label->setObjectName(QString::fromUtf8("label"));

        verticalLayout_2->addWidget(label);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        frame = new QFrame(WidgetPRE);
        frame->setObjectName(QString::fromUtf8("frame"));
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(50);
        sizePolicy.setVerticalStretch(50);
        sizePolicy.setHeightForWidth(frame->sizePolicy().hasHeightForWidth());
        frame->setSizePolicy(sizePolicy);
        frame->setMinimumSize(QSize(150, 150));
        frame->setFrameShape(QFrame::StyledPanel);
        frame->setFrameShadow(QFrame::Raised);

        horizontalLayout_2->addWidget(frame);

        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_2->addItem(horizontalSpacer);


        verticalLayout_2->addLayout(horizontalLayout_2);


        retranslateUi(WidgetPRE);

        QMetaObject::connectSlotsByName(WidgetPRE);
    } // setupUi

    void retranslateUi(QWidget *WidgetPRE)
    {
        WidgetPRE->setWindowTitle(QApplication::translate("WidgetPRE", "Form", nullptr));
        groupBox->setTitle(QApplication::translate("WidgetPRE", "Aspecto", nullptr));
        rBImagen->setText(QApplication::translate("WidgetPRE", "Imagen", nullptr));
        rBColor->setText(QApplication::translate("WidgetPRE", "Color s\303\263lido", nullptr));
        radioButton->setText(QApplication::translate("WidgetPRE", "Trama", nullptr));
        chBoxMostrarNum->setText(QApplication::translate("WidgetPRE", "Mostrar Numero de Bola", nullptr));
        label->setText(QApplication::translate("WidgetPRE", "Posici\303\263n del n\303\272mero", nullptr));
    } // retranslateUi

};

namespace Ui {
    class WidgetPRE: public Ui_WidgetPRE {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_WIDGETPRE_H
