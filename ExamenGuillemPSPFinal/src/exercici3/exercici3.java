/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici3;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.Semaphore;

/**
 *
 * @author vesprada
 */
public class exercici3  extends RecursiveAction {

    // llindar execuci� recursiva / iterativa
    private static final int LLINDAR = 5;
    // per guardar la quantitat de n�meros parells i imparells i n�mero concret
    static String cadenabase = "abbcccddddeeeeeffffgggiijkklllmmmmnnnnnooooqqqrrsttuuuvvvvwwwwwxxxxyyyzz";
    
    static int numeros = 0;
    // atributs per al constructor
    private static String cadenaLLarga;
    private int inici, fi;
    private int num;

    // Acc�s en exclusi� m�tua als acumuladors
   
    private static final Semaphore MUTEX_NUMERO = new Semaphore(1);

    // constructor
    public exercici3(String cadenaLLarga, int num, int inici, int fi) {
        this.cadenaLLarga = cadenaLLarga;
        this.num = num;
        this.inici = inici;
        this.fi = fi;
    }
    
    @Override
    protected void compute() {
        if ((fi - inici) <= LLINDAR) {
            // cas trivial, sumem comprovem directament els valors del car�cter
            // en el fragment de cadena
            for (int i = inici; i < fi; i++) {
                // acumulem el valor en la variable est�tica quantitat
                // comprovem si s�n imparells o parells
                try {
                    if ((cadenaLLarga.length() % 2) == 0) {
                        // accedir en exclusi� m�tua
                       
                        // incrementar valor variable parells
                        
                        // alliberem el sem�for
                        
                    } else {
                        // n�mero imparell
                 
                    }
                    //per comprovar si coincideix amb el n�mero triat en cada execuci�
                    if (cadenaLLarga.length() == num) {
                        // accedir en exclusi� m�tua
                        MUTEX_NUMERO.acquire();
                        // incrementar valor variable num
                        numeros++;
                        // alliberem el sem�for
                        MUTEX_NUMERO.release();
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            // entrem en el cas recursiu
            // partim l'array per la meitat i cridem a les 2 parts
            int meitat = (inici + fi) / 2 + 1;
            // hem de crear una nova tasca per a la primera part:
            exercici3 tasca1 = new exercici3(cadenaLLarga, num, inici, meitat);
            // creem una altra per la segona meitat
            exercici3 tasca2 = new exercici3(cadenaLLarga, num, meitat, fi);
            // fiquem les tasquen en la cua d'execuci�
            tasca1.fork();
            tasca2.fork();
            // i ara esperem a que acaben
            tasca1.join();
            tasca2.join();
        }
    }
    
    public static void main(String[] args) {
        int longitud = 500000;
        //array de nombres
        int arrayNombres[] = new int[longitud];
        ///Per obtenir els valors aleaoris
        Random rn = new Random();
        int numero = rn.nextInt(cadenabase.length());
        //inicialitzem l'array amb valors aleatoris
        for (int i = 0; i < cadenabase.length(); i++) {
            //valor aleatori entre 1 i 10
            if (numero == i) {
                char letra = cadenabase.charAt(i);
            }
            
        }

        // creem un nou gestor de fils forkjoin
        ForkJoinPool pool = new ForkJoinPool();
        // inicialitzem valors inici i fi
        int inici = 0;
        int fi = arrayNombres.length;
        // creem la tasca inicial per a tot l'array
        // valor aleatori a trobar:
        //valor aleatori entre 1 i 10
        
        exercici3 tasca = new exercici3(cadenaLLarga, numero, inici, fi);
        // cridem a la tasca
        pool.invoke(tasca);
        // esperem que la tasca acabe
        tasca.join();
        // mostrem el resultat
      
        
    }
}
