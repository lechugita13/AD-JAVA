package potGaletes;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class potGaletes {
	
	//pot de galetes inicialment ple
	private static int galetes=10;
	
	
	//semafor indicador que no hi ha galetes
	private static final Semaphore NO_HI_HA_GALETES = new Semaphore(0);
	
	
	//semafor indicador que ja hi ha galetes
	
	private static final Semaphore HI_HA_GALETES = new Semaphore(1);
	
	
	//semafor per a lacces en exclusio mutua
	private static final Semaphore MUTEX = new Semaphore(1);

	
	//proces que executa cada xiquet
	static class Xiquet extends Thread{
		//attribut identificador
		private int id;
		//constructor
		public Xiquet(int id) {
			
		}
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				
				try {
					//intenta agadar galetes del pot
					HI_HA_GALETES.acquire();
					//intenta accedir en exclusio mutua al pot
					MUTEX.acquire();
					
					if (galetes==0) {
						System.out.println("Xiquet "+id+" ,Mare s' han acabat les galetes");
						NO_HI_HA_GALETES.release();
					}else {
						//el xiquet esta anfambrat
						galetes--;
						//indica que els altres ja poden accedir al pot
						MUTEX.release();
						System.out.println("Que fantasia lo bona que estaba la gaeleta COMPANEYR "+galetes+" el travieso que se la ha menjat "+id);
						
						HI_HA_GALETES.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				try {
					Random rntemps = new Random();
					int temps = rntemps.nextInt(1000);
					Thread.sleep(temps);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	//proces que executa per a la mare
	static class Mare extends Thread{
		
	}
	public static void main(String[] args) {
	
		//posem en marxa la mare
		new Mare().start();
		//posem en marxa els xiquets
		for (int i = 0; i < 5; i++) {
			
			new Xiquet(i).start();
			
		}
	}

}
