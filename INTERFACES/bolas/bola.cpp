

#include "bola.h"
#include <math.h>

Bola::Bola(float posX,float posY,float velX,float velY,float radio){

    this->posX = posX;
    this->posY = posY;
    this->velX = velX;
    this->velY = velY;
    this->radio = radio;
    color =  QColor(rand()%256,rand()%256,rand()%256);
}
Bola::Bola(float posX,float posY,float velX,float velY,float radio,QColor color):
    Bola(posX,posY,velX,velY,radio){
       this->color = color;

}

void Bola::moverBola(int width,int height){
    //float diametro = this->radio *2;
    if (this->posX>=width-radio)
        this->velX = -fabs(this->velX);

    if ( this->posX<=0)
        velX = fabs(this->velX);
    
    if (this->posY<= 0)
        this->velY = fabs(this->velY);
    
    if (this->posY>=height-radio)
        this->velY = -fabs(this->velY);
     this->posX+=this->velX;
    this->posY+=this->velY;
}

void Bola::chocar(Bola *otra){
    Bola * izquierda;
    Bola * derecha;
    Bola * arriba;
    Bola * abajo;

    
    if (distancia(*otra)>(this->radio + otra->radio)/2) return;
    if (this->posX > otra->posX)
    {
        izquierda = otra;
        derecha = this;
    }else{
         derecha = otra;
        izquierda = this;}  

    if (this->posY > otra->posY)
    {
        arriba = otra;
        abajo = this;
    }else{
         arriba = this;
        abajo = otra;
       
    }
    if (izquierda->velX > derecha->velX)
    {
        float aux = izquierda->velX;
        izquierda -> velX = derecha->velX;
        derecha->velX = aux;

    }if (arriba->velY > abajo->velY)
    {
        float auxY = arriba->velY;
        arriba -> velY = abajo->velY;
        abajo->velY = auxY;
    }
   
}
float Bola::distancia(Bola otra){

    float x = this->posX - otra.posX;
    float y = this->posY - otra.posY;
     return sqrt(powf(x,2)+powf(y,2));

}