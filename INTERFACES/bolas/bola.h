#ifndef BOLA_H
#define BOLA_H
#include <QColor>


class Bola {
    public:
    float posX;
    float posY;
    float velX;
    float velY;
    QColor color;
    float radio;
    float distancia(Bola otra);
    void chocar(Bola *otra);

    Bola(float posX,float posY,float velX,float velY,float radio,QColor color);

    Bola(float posX,float posY,float velX,float velY,float radio);
    void moverBola(int width,int height);

};

#endif 
