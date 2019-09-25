#include <iostream>
using namespace std;

class  Cuenta {
public:
    string titular;
    string numCuenta;
    float saldo;
private:
    float interes;
};

void mostrar (Cuenta * c){

 cout << " la cuenta " << c->numCuenta << " de " << c->titular
        << " tiene " << c->saldo << " euros " <<endl;
}
//No fa falta que se retorne la cuenta
void ingresar(Cuenta * c,int numeroIngresar){
    
    c->saldo=c->saldo+numeroIngresar;
    

}
bool reintegrar(Cuenta * c,int numeroRetirar){
    if(c->saldo<numeroRetirar) return false;
    c->saldo=c->saldo-numeroRetirar;
    return true;



}
/*mostrar ();
ingresar ();
mostrar()
reintegrar()
mostrar()
*/
int main(int argc, char *argv[]) {

cout << "bienvenido al banco" <<endl;

    Cuenta * c = new Cuenta();
    c->titular = "Guillem";
    c->numCuenta ="001";
    c->saldo = 1000 ;
    mostrar(c);
    ingresar(c,2000);
    mostrar(c);
    reintegrar(c,100);
    mostrar(c);

  
}

