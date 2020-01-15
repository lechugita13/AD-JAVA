#ifndef BOLA_H
#define BOLA_H

#include <QColor>
#include <QString>


class Bola{

public:

	float posX, posY, velX, velY;
	Bola(float px,float py,float vx,float vy,int vida, int id);
	Bola(float px,float py,float vx,float vy, QColor, int vida, int id);
 
	int anchura, altura, id,vida;
	void mover(int altura, int anchura);
	bool chocar(Bola & otra);
	float distancia(Bola otra);
	
	
	QColor color;
		
};

#endif 
