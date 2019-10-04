
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>

#define BORRAPANTALLA(X) for (int i=0; i<X; i++, cout << endl);

using namespace std;

char * nombres[]={"juan","perico","andres","ramona","luci","pepi","mari","vengano","fulano","sotano"};

class Cuenta {
public:
    string titular;
    int numCuenta;
    float saldo;

    Cuenta(int numCuenta,float saldoInicial, string titular){
    this->numCuenta = numCuenta;
    saldo = saldoInicial;
    this->titular = titular;
    }
 
    Cuenta(){}

    bool  reintegrar(float cantidad){
      if (cantidad > saldo) return false;
      saldo -= cantidad;
      return true;
    }
    void ingresar(float cantidad) { saldo += cantidad; }
private:
    float interes;
};


void menu(void){
    BORRAPANTALLA(40);
    cout << "        1 - Elegir Cuenta " << endl;
    cout << "        2 - Ingresar " << endl;
    cout << "        3 - Reintegrar " << endl;
    cout << "        4 - Ver saldo " << endl;
    cout << "        5 - Seleccionar la cuenta con más saldo " << endl;
    cout << "        6 - mostrar Todas las cuentas "<< endl;
    cout << "        7 - Crear una cuenta nueva " << endl;
    cout << "        q - Salir a MSDOS " << endl;

    cout << " Pulsa una opción "<< endl;
    BORRAPANTALLA(10);
}


void inicializarCuentas( vector<Cuenta> & vectorcillo){
     for (int i = 0; i < 5; i++)
     {
       cuentas.push_back(Cuenta(100+i,1000*i,nombres[i]));
         
     }
     

    }
}

void mostrar(Cuenta cuentaMostrar){
    cout << "La cuenta " << cuentaMostrar.numCuenta
    << " de " << cuentaMostrar.titular
        << " tiene " << cuentaMostrar.saldo
    <<" euros " <<endl;
}

void mostrarCuentas(vector<Cuenta> cuentas){
   for (int i = 0; i < cuentas.size(); i++)
   {
       mostrar(cuentas[i]);
   }
   
             
}


void ingresar(Cuenta & c) {
    float cantidad;
    cout << "Dame la cantidad a ingresar en la cuent "<< c.numCuenta << endl;
    cin >> cantidad;
    c.ingresar(cantidad);    
}

bool reintegrar(Cuenta * c) {
    float cantidad;
    cout << " Introduce la cantidad a reintegrar:" << endl;
    cin >> cantidad;
    bool resultado =  c->reintegrar(cantidad);
    return resultado;
}

void mostrarSaldo(Cuenta c) {

}



int main (int argc, char *argv[] ) {

  //Cuenta cuentas[10];

  vector<Cuenta> cuentas;

  inicializarCuentas(cuentas);
    mostrarCuentas(cuentas);
  char opcion;
  /*while ( true ) {
   menu();
   cin >> opcion;
   switch (opcion) {
    case '1': // opción uno es la de seleccionar una cuenta
            //cuentaSeleccionada = seleccionarCuenta(cuentas);
        break;

    case '2': //if (cuentaSeleccionada != NULL)
            //ingresar( *cuentaSeleccionada ); break;

    case '3'://if ((cuentaSeleccionada!=NULL)&&( !reintegrar(cuentaSeleccionada)))
            //cout << "Error sacando pasta" << endl;
          break;

    case '4': //if (cuentaSeleccionada!=NULL ) mostrar(*cuentaSeleccionada); break;
    case '5':   //mostrar(*maxSaldo(cuentas));break;
    case '6': //mostrarCuentas(cuentas); break;
    //case '7': crearCuenta(cuentas);break;
//    case '8': eliminarCuenta(cuentas,cuentaSeleccionada);
    //      cuentaSeleccionada = NULL; break;
        case 'q': exit(0);
  };// switch
  cout << "Pulse una tecla y enter para seguir" << endl;
  cin >> opcion ;
  */
 }//while
} // main


