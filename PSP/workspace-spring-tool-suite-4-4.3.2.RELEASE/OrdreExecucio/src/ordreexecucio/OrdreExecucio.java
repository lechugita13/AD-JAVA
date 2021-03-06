package ordreexecucio;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class OrdreExecucio {
	static class Ordre implements Runnable{
		
		private int ordre;
		//constructor
		
		public Ordre(int ordre) {
			// TODO Auto-generated constructor stub
			this.ordre= ordre;
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
		try {
			int millisegons = (int) (Math.random()*1000);
			System.out.println("Tasca: "+this.ordre+" Dormint: "+millisegons+" ms");
			Thread.sleep(millisegons);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		System.out.println("Tasca "+this.ordre+" ha acabat");
		}
	}
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executor.execute(new Ordre(i));
		}
		System.out.println("Nombre de fils: "+executor.getPoolSize());
		executor.shutdown();
	}

}
