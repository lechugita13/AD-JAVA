package filraul;

import java.util.Random;

// La classe Fil hereta de la classe Thread
public class Fil extends Thread {

	public void run() {
		// per obtenir un valor aleatori
		Random rn = new Random();
		// On guardar el valor de temps aleatori d'espera
		long espera = 0;
		for (int x = 0; x < 10; x++) {
			System.out.println(this.getName() + ": " + x);			
			espera = rn.nextInt(500);
			try {
				Thread.sleep(espera);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Dades del fil que acaba
		System.out.println("Dades "+this.getName()+": "+this.toString());
		// System.out.println("Grup "+this.getName()+": "+this.getThreadGroup());
	}

	public static void main(String[] args) {
		// Creem dos nous fils
		Thread primer = new Fil();
		Thread segon = new Fil();
		// N'establim el nom
		primer.setName("Fil 1");
		segon.setName("Fil 2");
		primer.setDaemon(true);
		// Establim prioritats
		primer.setPriority(MIN_PRIORITY);
		segon.setPriority(MAX_PRIORITY);
		// Hem creat dos fils primer i segon, però no s'han executat.
		// Per poder-lo executar s'ha de cridar al mètode start()
		primer.start();
		segon.start();
		// Si no fem el join(), el més normal és que s'execute abans l'eixida del
		// principal que les dels fils fills
		try {
			primer.join(); // esperem que acabe el primer per continuar
			segon.join(); // esperem que acabe el segon per continuar
		} catch (Exception e) {
			e.printStackTrace();
		}
		//amb els join, aquesta eixida sempre serà la última.
		System.out.println("Final Fil Principal");

	}
}
