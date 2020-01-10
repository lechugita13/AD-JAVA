
#include "DControlBolas.h"
#include "WidgetBola.h"
#include <QColor>

DControlBolas::DControlBolas(QVector <BolaYWidget *>bolas,QWidget *parent){
     setupUi(this);
    
    tabBolas ->clear();
    
    for (int i = 0; i < bolas.size(); i++)
    {
        tabBolas->insertTab(i,(bolas[i]),QString("Bola "+QString::number(i)));
    }
    
    connect(pararTodas,SIGNAL(clicked()),this,SLOT(stopAll()));

}

void DControlBolas::stopAll(){

    if (pararTodas->text() == "Josep Jose")
    {
         for (int i = 0; i < tabBolas->count(); i++)
    {
        WidgetBola *widge = (WidgetBola*) tabBolas->widget(i);
        widge->bolaSel->velX =2;
        widge->bolaSel->velY =2;
        pararTodas->setText("Stop ALL");
    }
    }else
    {
         
        for (int i = 0; i < tabBolas->count(); i++)
         {
             WidgetBola *widge = (WidgetBola*) tabBolas->widget(i);
                widge->bolaSel->velX =0;
                widge->bolaSel->velY =0;
         }
             pararTodas->setText("Josep Jose");
    }
    
   


    
}