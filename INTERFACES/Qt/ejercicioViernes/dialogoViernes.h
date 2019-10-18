#ifndef DIALOGOVIERNES_H
#define DIALOGOVIERNES_H

#include <QDialog>

class QCheckBox;
class QLCDNumber;
class QPushButton;
class QSlider;

class DialogoViernes : public QDialog{

    Q_OBJECT

    public:
    DialogoViernes(QWidget *parent=0);
    QLCDNumber * number;
    QPushButton * okButton;
    QPushButton * cancellButton;
    QCheckBox * activoCheckBox1;
    QCheckBox * activoCheckBox2;
    QCheckBox * activoCheckBox3;
    QSlider * slider1;
    QSlider * slider2;
    QSlider * slider3;
    QPushButton *unoButton;
    QPushButton *dosButton;
    
    public slots:
        void establecerLCD(int);
   
};
#endif // DEBUG