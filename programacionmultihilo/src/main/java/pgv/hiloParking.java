package pgv;

import java.util.concurrent.Semaphore;

public class hiloParking extends Thread {

    private int numero;
    private Semaphore sem;
    private Parking parking;

    public hiloParking(int coche, Semaphore semaphore, Parking park) {
        this.numero = coche;
        this.sem = semaphore;
        this.parking = park;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parking.cocheEntra(numero);
        System.out.println("Entra coche parking");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sale coche parking");

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parking.cocheSale(numero);
        sem.release();
        Thread.yield();
    }
}
