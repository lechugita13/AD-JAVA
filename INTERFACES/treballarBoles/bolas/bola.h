#ifndef BOLA_H
#define BOLA_H

#include <QPainter>
#include <QVector>
class Bola{

public:
	static int numBolas;
	int numBola;
	QVector<Bola*> hijas;
	Bola *padre;

    Bola(bool, float , float , float , float, float);
	Bola(bool, float , float , float , float, float, QColor );
	Bola(bool, float , float , float , float, float, QImage );
	void pintarBola(QPainter &);
	void mover(float, float);
	bool chocar(Bola &);
	float calcDistancia(Bola );
	static const int vidaInicial = 100;

	int vida;
        float x;
	float y;
	float vX;
	float vY;
	float radio;
	bool jugador;
	QColor color;
	bool resaltada = false;
	QImage imagen;
	int numColisiones;

private:

};

#endif 
