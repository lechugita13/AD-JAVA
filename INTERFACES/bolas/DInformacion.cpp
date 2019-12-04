#include  "DInformacion.h"

DInformacion::DInformacion(int numBolas,int anch, int alt, QWidget *parent){
     setupUi(this);
    NumBolasModificar->setText(QString::number(numBolas));
    
    QString textoTamanyo = QString::number(anch) + "X" +QString::number(alt);

    ResolucionPantalla->setText(textoTamanyo);

   
}