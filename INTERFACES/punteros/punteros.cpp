#include <stdio.h>
#include <iostream>

using namespace std;



bool esPositivo (int num){
     
     return num>=0;

}

void hazPositivo(int *puntero){
   
   if ( ! esPositivo(*puntero))
    *puntero = -*puntero;
    
}

int main (int argc, char *argv[]) {
    int i;
    i = 8;
    //Forma de declarar punteros linea 10 int * p;
    int * p;
    //Forma de asignar una variable a una posicio de memoria
    p = &i;

    cout << "i vale " << i << endl;
   

    *p=-10;
    i = -10;
    if (esPositivo(i)){
        std::cout << " i ya es positivo, nada que tocar" << std::endl;
    }else
        {
          hazPositivo(&i);
        }
            
    if ( ! esPositivo(i)){
        std::cout << " Rayos, truenos  y centellas!!!" << std::endl;        
    }
    std::cout << "i vale " << *p << std::endl;
    std::cout << "i esta en la posicion: " << p << " de ram" <<std::endl;
}