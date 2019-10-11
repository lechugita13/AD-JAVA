#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <sstream>
#include <math.h>
using namespace std;

class Complejo {
public:
    float p_real;
    float p_imag;

    string toString() {
        stringstream ss;
        ss << "(" << p_real<<","<<p_imag<<")" ;
        return ss.str();
    }

    Complejo (float r, float i){
        p_real = r;
        p_imag = i;
    }
    Complejo(){}
    Complejo operator+ (Complejo segundo){

    Complejo fantasia(p_real+segundo.p_real,p_imag+segundo.p_imag);
    return fantasia;



    }

/*Complejo operator- (Complejo segundo){


    return Complejo (p_real-segundo.p_real,p_imag-segundo.p_imag);
}
Complejo operator- (){

    return Complejo (-p_real,-p_imag);
}
Complejo operator+= (Complejo  segundo){
    p_real = p_real +segundo.p_real;
    p_imag = p_imag + segundo.p_imag;
    return this;
}*/
double modulo (){

    double resultat;
    resultat = (p_real*p_real) + (p_imag*p_imag);
    resultat = sqrt(resultat);
    return resultat;

}
bool operator< (Complejo c){

    return modulo() > c.modulo();
}

bool operator> (Complejo c){

    return !(operator<(c));
}
};



int main (int argc, char *argv[] ) {

    Complejo a(-2,8);
    Complejo b(3,5);
    Complejo c(4,-3);
    
    //Complejo res;
    //Complejo d;
  
    //b += a;
    
    std::cout << a.operator<(b) << std::endl;

    std::cout << a.operator>(b) << std::endl;
   




}
