#include <stdio.h>
#include <iostream>


//& davant de la variable passa la direccio de ixa mateixa
//* davant de una direccio marca el contingut de ixa mateixa

int max(int * a, int *b) {

    if (*a > *b) {
        return *a;
    }
    return *b;

}

int & max2(int & a, int & b) {
    if (a > b) {
        return a;
    }
    return b;

}

int * max3 (int * a,int *b){

       if (*a > *b) {
        return a;
    }
    return b;

}
void incrementar(int & num) {

    num++;
}

int main(int argc, char const *argv[]) {
    /*int i=0;
    std::cout <<  "a vale " << i << " antes de incrementar" << std::endl;
    //& davant de una declaracio de variable crea una referencia
    //* davant de una declaracio declara un punter
    incrementar(i);

    std::cout <<  "a vale " << i << " despues de incrementar" << std::endl;
    */

    int a = 5;
    int b = 9;
    //Ell sa creat un puntero de c i de d no una variable int
    int c;
    
    int * devuelto;

    std::cout <<  "a vale " <<  a<< std::endl;
    std::cout <<  "b vale " <<  b << std::endl;

   c = max(&a,&b);
   c++;

    int & d= max2(a,b);
    d++;

    std::cout <<  "c per punteros = a el maximo entre a i b +1 " <<  b << std::endl;
    std::cout <<  "d per referencia = a el maximo entre a i b +1 " <<  b << std::endl;

    devuelto = max3(&a,&b);
    //important quan se suma un puntero els parentesis
    (*devuelto)++;
    std::cout <<  "devuelto = a el maximo entre a i b +1 " <<  b << std::endl;

    
}

