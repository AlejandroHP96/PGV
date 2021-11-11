package proyectoLecturaEscritura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Escritura {

    public static void main(String[] args) {
        ServerSocket conexion = null;
        Socket canal = null;
        PrintWriter salida = null;
        Process nuevoProcess = null;
        String [] cmd1= {"cmd.exe","/c","dir /p"};
        Runtime builder = Runtime.getRuntime();
        BufferedReader bf;

        //Aqui creo la conexión con un puerto, en este caso 12345
        try {
            conexion = new ServerSocket(12345);
        } catch (IOException e) {
            System.err.println("No se ha podido abrir el puerto de escucha");
            System.err.println(e.toString());
        }
        if (conexion != null) {
            try {
                System.out.println("Esperando la conexion del proceso lector");
                canal = conexion.accept();
                salida = new PrintWriter(canal.getOutputStream());
                nuevoProcess = builder.exec(cmd1);
                bf = new BufferedReader(new InputStreamReader(nuevoProcess.getInputStream()));
                String linea;
                while ((linea = bf.readLine()) != null) {
                    salida.println(linea);
                    salida.flush();
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            } finally {

                if (salida != null) {
                    salida.close();
                }
                if (canal != null) {
                    try {
                        canal.close();
                    } catch (Exception e) {
                        System.err.println("Error al cerrar el socket");
                    }
                }
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Exception e) {
                        System.err.println(e.toString());
                    }
                }
            }
        }
    }
}
