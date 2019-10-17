package acumulador;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class acumulador {
	
	static class Sumador implements Runnable{
		//variable comuna a tots els procesos
		private static int valorSuma=0;
		//atribut
		private static final Semaphore MUTEX = new Semaphore(1);
		
		private int id;
		
		//constructor
		public Sumador(int id) {
			this.id= id;
		}
		
		@Override
		public void run() {
			try {
				MUTEX.acquire();
				valorSuma++;
				System.out.println("Proces"+id+": valor suma"+valorSuma);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MUTEX.release();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
		//variable quantitat de procesos
		int N = 100000;
		//Hem de cridar a N processs sumador
		for (int i = 0; i <N ; i++) {
			executor.execute(new Sumador(i));
		}
		executor.shutdown();
	}

}
