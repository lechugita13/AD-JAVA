package Semafors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class Invertir implements Runnable {

	private String linia;
	private int cont = 0;

	private static final Semaphore MUTEX = new Semaphore(1);
	private static final Semaphore MUTEX2 = new Semaphore(0);

	@Override
	public void run() {

		File fitxer = new File("lineesrepas.txt");
		File resultat = new File("textinvertit.txt");

		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fitxer));
			FileWriter pw = new  FileWriter(resultat,true);
			// demane permis per escriure
			MUTEX.acquire();

			while ((linia = br.readLine()) != null) {
				
					StringBuilder sb = new StringBuilder();
					sb.append(linia);
					sb.reverse().toString();
					System.out.println(sb);
					pw.write(sb + "\n");	
			}
			// alliberem semafor
			MUTEX2.release();
		
			br.close();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// Gestor de fils
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		// Variable cuantitat de procesos
		int N = 10;
		for (int i = 0; i < N; i++) {
			executor.execute(new Invertir());
		}
		executor.shutdown();
	}

}
