#include  "DInformacion.h"

DInformacion::DInformacion(QString num, QString tamanyo, QWidget *parent) : QDialog(parent) {
    setupUi(this);
	numBolas->setText(num);
	tamanyoVentana->setText(tamanyo);
}

