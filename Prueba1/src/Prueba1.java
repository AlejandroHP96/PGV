import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Process;
import java.lang.Runtime;

public class Prueba1 {

    public static void main(String[] args) {
        crearProceso();
    }

    public static void crearProceso() {

        String cmd = "tasklist";

        // Gestionar el entorno de ejecución de la aplicación java
        Runtime builder = Runtime.getRuntime();
        Process nuevoProcess;

        try {
            nuevoProcess = builder.exec(cmd);
            BufferedReader bf = new BufferedReader(new InputStreamReader(nuevoProcess.getInputStream()));
            String linea = bf.readLine();

            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}