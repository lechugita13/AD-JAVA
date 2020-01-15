#include "bola.h"
#include <math.h>

Bola::Bola(float pX,float pY, float vX, float vY, int v, int id) : velX(vX),posX(pX),posY(pY),velY(vY),vida(v){

	color = QColor(rand()%256,rand()%256,rand()%256);



}

Bola::Bola(float pX,float pY, float vX, float vY ,QColor col , int vida, int id) : Bola(pX,pY,vX,vY,vida,id){

	color = col;
}

void Bola::mover(int anchura,int altura){

	if(posX > anchura){
		velX = -fabs(velX);
	}
	if(posX < 0){
		velX = fabs(velX);
	}
	if(posY > altura){
		velY = -fabs(velY);
	}
	if(posY < 0){
		velY = fabs(velY);
	}
	
	posX = posX + velX;
	posY = posY + velY;

}
float Bola::distancia(Bola otra){

	float distancia = sqrtf(pow((posX - otra.posX),2)+pow((posY - otra.posY),2));
	return distancia;

}
bool Bola::chocar(Bola & otra){

	bool chocar = false;
	Bola * izquierda;
	Bola * derecha;  
	
	if(distancia(otra)>50) return false;

	if(posX > otra.posX){
		izquierda = &otra;
		derecha = this;
	}else{

		izquierda = this;
		derecha = &otra;
	}
	
	if(izquierda->velX > derecha->velX){

		float aux = izquierda->velX;
		izquierda->velX = derecha->velX;
		derecha->velX = aux;
		chocar = true;		
				
	}
	
	if(izquierda->velY > derecha->velY){
		float aux2 = izquierda->velY;
		izquierda->velY = derecha->velY;
		derecha->velY = aux2;
		chocar = true;

	}

	return chocar;
}
