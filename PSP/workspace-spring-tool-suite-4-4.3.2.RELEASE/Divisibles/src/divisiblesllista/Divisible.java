package divisiblesllista;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Divisible {

	// Objecte que ha de realitzar la tasca
	// Com va a retornar valor, ha de ser Callable retorna un valor

	static class Multiplicacio implements Callable<Boolean> {
		// atribus de la classe valors dels operands
		private int operador1;

		// constructor
		public Multiplicacio(int operador1) {
			this.operador1 = operador1;

		}

		// funcio obligatoria call()
		@Override
		public Boolean call() throws Exception {
			// TODO Auto-generated method stub
			return (operador1 % 2) == 0;
		}

	}
	
	static class Divisio implements Callable<Boolean> {
		// atribus de la classe valors dels operands
		private int operador1;

		// constructor
		public Divisio(int operador1) {
			this.operador1 = operador1;

		}

		// funcio obligatoria call()
		@Override
		public Boolean call() throws Exception {
			// TODO Auto-generated method stub
			return (operador1 % 3) == 0;
		}

	}
	
	
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Creem una instacia del gestor de fills ThreadPoolExectutor
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
		ThreadPoolExecutor executor2 = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);

		// Creem una llista dobjectes Multiplicacio (Callable)
		List<Multiplicacio> listaTasques2 = new ArrayList<Multiplicacio>();
		List<Multiplicacio> listaTasques3 = new ArrayList<Multiplicacio>();

		for (int i = 0; i < 100; i++) {

			// creem objecte amb 2 valors aleatoris
			Multiplicacio m = new Multiplicacio(i);
			// Afegim a la llista
			listaTasques2.add(m);

		}
		for (int i = 0; i < 100; i++) {

			// creem objecte amb 2 valors aleatoris
			Divisio m = new Divisio(i);
			// Afegim a la llista
			//listaTasques3.add(m);

		}

		// Creem una llista de resultats futurs no es pot accedir fins que tots acaben

		List<Future<Boolean>> llistaResultats2;
		List<Future<Boolean>> llistaResultats3;

		// Posem en martxa els objectes i enllacem els resltats

		llistaResultats2 = executor.invokeAll(listaTasques2);
		llistaResultats3 = executor2.invokeAll(listaTasques2);

		// no es poden afegir noves execucuins a les ja existents
		executor.shutdown();
		executor2.shutdown();

		// recorreguem la array per obternir el resultat de les eleccions
		for (int i = 0; i < llistaResultats2.size(); i++) {
			// obtenim un valor
			// utilitzem la funcio get()
			Future<Boolean> resultat = llistaResultats2.get(i);

			// mostrem el resultat
			if (resultat.get() == true) {
				System.out.println("resultat tasca: " + i + " es " + resultat.get());
			}

		}

	}

}
