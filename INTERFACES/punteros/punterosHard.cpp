#include <stdio.h>
#include <iostream>

using namespace std;

int *maximo(int *numeros, int *ultimo) {

    int *posicion=numeros;
    /*int cont=0;
    for (int i = 0; i < 10; i++) {
        if (numeros[i] > numeros[posicion]) {

            cont=i;
        }

    }*/

    while (numeros<=ultimo) {

        if (*numeros > *posicion) {

            posicion=numeros;
        }

        numeros++;
    }

    // & marca la direccio de memoria IMPORTANT!!!!!
    // * davant marca el valor dins de la direccio de memoria 
    // return &(numeros[cont]);
    return posicion;
}


void mostrar(int numsPasados[10]) {
    for (int i=0; i<10 ; i++ )
      cout  << numsPasados[i] << " "  ;cout << endl;

}

int main (int argc, char *argv[]) {

    int numeros[10];
    
    /* inicialización */
    for (int i=0; i< 10 ; i++) {
        int numero = random() % 10;
        numeros[i] = numero;
    }

    mostrar(numeros);

    int * max = maximo (&numeros[0],&numeros[9]);
    *max = 0;
    
    mostrar(numeros);
   
}
