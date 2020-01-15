
#include "DControlBolas.h"
#include "WidgetBola.h"
#include <QColor>

DControlBolas::DControlBolas(QVector <Bola *>bolas,QWidget *parent){
     setupUi(this);
    
    tabBolas ->clear();
    bolasGastar=bolas;
    for (int i = 0; i < bolas.size(); i++)
    {
        tabBolas->insertTab(i,new WidgetBola(bolas[i]),QString("Bola "+QString::number(i)));
    }
    
    //connect(tabBolas,SIGNAL(tabBarClicked(int)),this,SLOT(slotCambiarColorSel()));
}


//void DControlBolas::slotCambiarColorSel(int i){

    
//}