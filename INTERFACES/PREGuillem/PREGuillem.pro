######################################################################
# Automatically generated by qmake (3.1) Wed Feb 12 16:40:16 2020
######################################################################

TEMPLATE = app
TARGET = PREGuillem
INCLUDEPATH += .

# The following define makes your compiler warn you if you use any
# feature of Qt which has been marked as deprecated (the exact warnings
# depend on your compiler). Please consult the documentation of the
# deprecated API in order to know how to port your code away from it.
DEFINES += QT_DEPRECATED_WARNINGS

# You can also make your code fail to compile if you use deprecated APIs.
# In order to do so, uncomment the following line.
# You can also select to disable deprecated APIs only up to a certain version of Qt.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

# Input
HEADERS += bola.h \
           BolaYWidget.h \
           DControlBolas.h \
           DExamenDAM.h \
           DExamenDialog.h \
           DialogoGraficos.h \
           DialogoTabla.h \
           DTablaPre.h \
           DTreeView.h \
           InfoDialog.h \
           mainwindow.h \
           WidgetBola.h \
           WidgetPRE.h
FORMS += DControlBolas.ui \
         DExamenDAM.ui \
         DExamenDialog.ui \
         DExamenTab.ui \
         DialogoGraficos.ui \
         DialogoTabla.ui \
         DTablaPRE.ui \
         DTreeView.ui \
         InfoDialog.ui \
         WidgetBola.ui \
         WidgetPRE.ui
SOURCES += bola.cpp \
           BolaYWidget.cpp \
           DControlBolas.cpp \
           DExamenDAM.cpp \
           DExamenDialog.cpp \
           DialogoGraficos.cpp \
           DialogoTabla.cpp \
           DTablaPre.cpp \
           DTreeView.cpp \
           InfoDialog.cpp \
           main.cpp \
           mainwindow.cpp \
           WidgetBola.cpp \
           WidgetPRE.cpp
QT += widgets charts
