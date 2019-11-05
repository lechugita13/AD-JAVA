package potGaletes;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class potGaletes {

	// pot de galetes inicialment ple
	private static int galetes = 10;

	// semafor indicador que no hi ha galetes
	private static final Semaphore NO_HI_HA_GALETES = new Semaphore(0);

	// semafor indicador que ja hi ha galetes

	private static final Semaphore HI_HA_GALETES = new Semaphore(1);

	// semafor per a lacces en exclusio mutua
	private static final Semaphore MUTEX = new Semaphore(1);

	// proces que executa cada xiquet
	static class Xiquet extends Thread {
		// attribut identificador
		private int id;

		// constructor
		public Xiquet(int id) {

		}

		@Override
		public void run() {
			// per controlar que el xxiquet realment es menja la galeta
			boolean galetaMenjada;

			for (int i = 0; i < 20; i++) {
				galetaMenjada = false;
				try {
					while (!galetaMenjada) {
						// intenta agadar galetes del pot
						HI_HA_GALETES.acquire();
						// intenta accedir en exclusio mutua al pot
						MUTEX.acquire();

						if (galetes == 0) {
							System.out.println("Xiquet " + i + " ,Mare s' han acabat les galetes");
							MUTEX.release();
							NO_HI_HA_GALETES.release();
							
						} else {
							// el xiquet esta anfambrat
							galetes--;
							// indica que els altres ja poden accedir al pot
							
							System.out.println("Que fantasia lo bona que estaba la gaeleta COMPANEYR " + galetes
									+ " el travieso que se la ha menjat " + i);
							MUTEX.release();
							HI_HA_GALETES.release();
							galetaMenjada=true;
						}
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

	// proces que executa per a la mare
	static class Mare extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					// espera que algun xiquet avise
					NO_HI_HA_GALETES.acquire();
					// ha de plenar el pot
					MUTEX.acquire();
					galetes = 10;
					MUTEX.release();
					System.out.println("Galletes PA EVERY BODY");

					HI_HA_GALETES.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {

		// posem en marxa la mare
		new Mare().start();
		// posem en marxa els xiquets
		for (int i = 0; i < 5; i++) {

			new Xiquet(i).start();

		}
	}

}
