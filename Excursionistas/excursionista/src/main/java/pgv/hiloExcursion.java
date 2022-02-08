package pgv;

import java.util.concurrent.CyclicBarrier;

public class hiloExcursion extends Thread {

    CyclicBarrier barrier;
    private String nombre;
    final static int EXCURSIONES = 4;

    public hiloExcursion(String nom, CyclicBarrier barrier) {
        this.barrier = barrier;
        this.nombre = nom;
    }

    @Override
    public void run() {
        for (int i = 0; i < EXCURSIONES; i++) {
            System.out.println("Excursion: " + i + " " + nombre);

            try {
                barrier.await();
            } catch (Exception e) {
                e.getStackTrace();
            }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
