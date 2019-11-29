#ifndef BOLA_H
#define BOLA_H



class Bola {
    public:
    float posX;
    float posY;
    float velX;
    float velY;
    
    float radio;
    float distancia(Bola otra);
    void chocar(Bola *otra);

    Bola(float posX,float posY,float velX,float velY,float radio);
    void moverBola(int width,int height);

};

#endif 
