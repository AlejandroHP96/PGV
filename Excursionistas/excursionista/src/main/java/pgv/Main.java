package pgv;

import java.util.concurrent.CyclicBarrier;

/**
 * Hello world!
 *
 */
public class Main {
    final static int PARTICIPANTE = 5;

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTE);

        for (int i = 0; i < PARTICIPANTE; i++) {
            new hiloExcursion("Participantes " + i, barrier).start();
        }
    }
}
