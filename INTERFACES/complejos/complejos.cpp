
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <sstream>
class Complejo
{
private:
    /* data */
public:

float p_real;
float p_imag;
    string mostrar() {
        stringstream ss;
        
        ss << "(" << p_real << "," << p_imag << ")";
       return ss.str();
    }

    Complejo (float r,float i ){
        p_real = r;
        p_imag =i;
    }
};

int main(int argc, const char* argv[]) {
Complejo c(2,4);
Complejo a(-2,4);
Complejo b(3,5);
a= b + c;
a +=b;
a << b;
a[1];
if(a==b)
if(a == 0)

a= -b;

std::cout << "c.mostrar()" << std::endl;
}