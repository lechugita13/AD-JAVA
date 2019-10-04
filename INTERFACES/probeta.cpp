#include <stdio.h>
#include <iostream>
using namespace std;


void intercambiar(int numeros[10],int pos1,int pos2){

    int aux =numeros[pos1];
    numeros[pos1]=numeros[pos2];
    numeros[pos2]=aux;
    for (int i = 0; i < 10; i++)
    {
            cout << "Este es el numero: " << numeros[i] << " Esta es la posicio: " << i << endl;      
    }

}
void mostrar(int numsPasados[10]) {

    for (int i = 0; i < 10; i++) {

        cout << "Este es el numero: " << numsPasados[i] << " Esta es la posicio: " << i << endl;
    }

}
void mostrarPosMax(int guardarPosio) {

    std::cout << "La posicio maxima es: " << guardarPosio << std::endl;

}
void mostrarPosMin(int guardarPosio) {

    std::cout << "La posicio minima es: " << guardarPosio << std::endl;

}
int posicionMax(int numsPasados[10]) {
    int guardarPosi = 2;
    for (int i = 0; i < 10; i++) {
        int numProba = numsPasados[0];

        if (numsPasados[i] > numProba) {
            numProba = numsPasados[i];
            guardarPosi = i;
        }

    }
    mostrarPosMax(guardarPosi);
    return guardarPosi;

}
int posicionMin(int numsPasados[10]) {
    int guardarPosi = 2;

    for (int i = 0; i < 10; i++) {
        int numProba = numsPasados[0];

        if (numsPasados[i] < numProba) {
            numProba = numsPasados[i];
            guardarPosi = i;
        }

    }
    mostrarPosMin(guardarPosi);
    return guardarPosi;

}

int main(int argc, const char ** argv) {

    int numeros[10];
    int numero2;
    numero2 = 0;
    int media = 0;
    /* inicializacion */

    for (int i = 0; i < 10; i++) {

        numero2 = random() % 10;
        numeros[i] = numero2;
        media = media + numero2;

    }

    mostrar(numeros);
    float numMedia = 0;
    numMedia = media / 10.0;
    std::cout << "La media es " << numMedia << std::endl;
    /* mostrar el valor dels elements del vector */
    posicionMax(numeros);
    posicionMin(numeros);
    intercambiar(numeros,4,8);
}
