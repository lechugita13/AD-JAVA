#ifndef BOLA_H
#define BOLA_H
#include <QColor>
#include <QImage>
#include <QPainter>
class Bola {
    public:
    float posX;
    float posY;
    float velX;
    float velY;
    
    QColor color;
    QImage image;
    float radio;
    int vida;
    float distancia(Bola otra);
    bool chocar(Bola *otra);
    void trompa();
    void pinta(QPainter &pintor);
    void ponImagen(QImage imagen);
    Bola(float posX,float posY,float velX,float velY,float radio,QColor color);

    Bola(float posX,float posY,float velX,float velY,float radio);
    void moverBola(int width,int height);

};

#endif 
