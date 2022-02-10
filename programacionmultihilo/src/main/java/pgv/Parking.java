package pgv;

import java.util.ArrayList;

public class Parking {
    private static int PLAZAS = 6;
    private ArrayList<Integer> huecos = new ArrayList<Integer>();

    public Parking() {
        int j = 0;
        for (int i = 0; j < PLAZAS; j++) {
            huecos.add(i);
        }
    }

    public synchronized void cocheEntra(int coche) {
        int pos = 0;
        if (huecos.contains(0)) {
            pos = huecos.indexOf(0);
            System.out.println("Coche " + coche + " entra a parking. Posición: " + pos);
            huecos.remove(pos);
            huecos.add(pos, coche);
        }
    }

    public synchronized void cocheSale(int coche) {

        int pos = 0;
        if (huecos.contains(coche)) {
            pos = huecos.indexOf(coche);
            System.out.println("Coche " + coche + " sale del parking. Posición: " + pos);
            huecos.remove(pos);
            huecos.add(pos, 0);
        }

    }
}
