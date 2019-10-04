#include <stdio.h>
#include <iostream>

using namespace std;

int * maximo(int * a, int * b) {

    if ( * a > ( * b)) {
        return a;
    }
    return b;

}

int main(int argc, const char ** argv) {

    int a = 10;
    int b = 5;

    std::cout << "a vale " << a << std::endl;
    std::cout << "b vale " << b << std::endl;

    *maximo(& a, & b) = 0;
    std::cout << "a vale " << a << std::endl;
    std::cout << "b vale " << b << std::endl;
}
