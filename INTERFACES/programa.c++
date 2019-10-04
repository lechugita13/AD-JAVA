

#include <stdio.h>
#include <iostream>

using namespace std;
//Es per a gastar la biblioteca que esta dins de un paquet


int main (int argc, char *argv[] ) {

	int a = 'w';
	int numeros[] ;
	numeros = new int[10];
	//int b = 0;
    //	Trau el valor en numero de la w
    //	printf(" El valor de la variable a es %d \n", a);
    //	Esto seria en java
    //	System.out.printls("el valor es " + a );
    //	Esta es la manera nova per a ferlo
	cout << "teclea un número ";
	cin >> a;
	//cout << "teclea un número ";
	//cin >> b;
	cout << "El valor de la variable a es: " << a << endl;
	//cout << "El valor de la variable a es: " << b << endl;
	/*if (a<10){
		cout << "el numero es menor de diez" << endl;
		}
	else{
		cout << "el numero es mayor de diez" << endl;		
		}
	
	*/
	//int x = a*b;
	//cout << a << "x" << b << "=" << x << endl;
	for (int i=1;i<=10;i++){
		cout << a << "x" << i << "=" << a*i << endl;
	};
}
