package pgv;

import java.util.concurrent.Semaphore;

public class Main {

    final static int COCHE = 8;
    final static int PLAZAS = 5;
    final static Parking parking = new Parking();

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(PLAZAS); // El pongo 5 ya que es el numero de plazas del Parking, eso significa
                                               // que, mientras no haya 5, el semáforo va a estar en verde

        for (int i = 0; i < COCHE; i++) {
            new hiloParking(i, sem, parking).start();
        }
    }
}
