/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForkJoin_RecursiveTask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Guillem
 */
public class forkjoin extends RecursiveTask<Short>{
    
    private static final int LLINDAR = 10000000;

    
    private short[] arr;
    private int inici, fi;

    public forkjoin(short[] arr, int inici, int fi) {
        this.arr = arr;
        this.inici = inici;
        this.fi = fi;
    }
    private short getMaxSeq(){
        short max = arr[inici];
        for (int i = inici+1; i < fi; i++) {
            if (arr[i]>max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    private short getMaxReq(){
        forkjoin task1;
        forkjoin task2;
        int mig = (inici+fi) /2+1;
        task1 = new forkjoin(arr, inici, fi);
        task1.fork();
        task2 = new forkjoin(arr, inici, fi);
        task2.fork();
        return (short) Math.max(task1.join(), task2.join());
    }
    @Override
    protected Short compute() {
     
        if (fi -inici <= LLINDAR) {
            return getMaxSeq();
        }else{
            return getMaxReq();
        }
    }
    
    public static void main(String[] args) {
        
        short[]dades = createArray(10000000);
        System.out.println("Inici calcul");
        ForkJoinPool pool = new ForkJoinPool();
        int inici = 0;
        int fi = dades.length;
        forkjoin tasca = new forkjoin(dades, inici, fi);
        long time = System.currentTimeMillis();
        //crida la tasca i espera que es completen
        
        int result1 = pool.invoke(tasca);
        //maxim
        
        int result = tasca.join();
        
        System.out.println("Temps utilitzat: "+(System.currentTimeMillis()-time));
        System.out.println("Maxim es de "+result);
    }
    
    private static short[] createArray(int i) {
      short[] ret = new short[i];
        for (int j = 0; j < i; j++) {
            ret[j] = (short) (1000* Math.random());
            if (j == ((short) (i*0.9))) {
                ret[j]=1005;
            }
        }
        return ret;
    }
    
    
}
