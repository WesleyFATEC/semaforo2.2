package control;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pessoas extends Thread{
	private static final Random rd = new Random ();
	private static final Semaphore semaphore = new Semaphore(1);
	
	private final int ID;
	private double dist;
	private double distPerc;
	
	private final double TIME_TO_PORTA;
	
	public Pessoas (int id) {
        this.ID = id;
        this.dist = 4 + (2 * rd.nextDouble()); ;
        this.TIME_TO_PORTA = 1 + (rd.nextDouble());;
        
    }
	
	public void run() {
		try {
			System.out.println("A pessoa " + ID );
			distPerc += dist;
			long startTime = System.currentTimeMillis();
			long tempofinal;
			do {
				tempofinal = System.currentTimeMillis()-startTime;
				System.out.println("Pessoa " + ID + " está andando.  Distancia para porta:" + dist );
			} while (distPerc < 200);
			
			 System.out.println("Pessoa " + ID + " chegou na porta.");
	         semaphore.acquire();
	
	         System.out.println("Pessoa " + ID + " está atravessando a porta.");
	         
	         Thread.sleep((long) (TIME_TO_PORTA * 1000));
	
	         System.out.println("Pessoa " + ID + " atravessou a porta.");
		}
		catch (Exception e) {
            e.getMessage();
        }
		finally {
			semaphore.release();
		}
		
	}
}
