package proyectoLecturaEscritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Lectura {
    
    public static void main(String[] args) {
        
        Socket canal = null;
        BufferedReader entrada = null;
        String valorEntrada = null;
        Process process;
        Runtime builder = Runtime.getRuntime();
        String [] cmd= {"cmd.exe","/c","sort /r"};


        try {
            canal = new Socket("localhost",12345);

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (canal != null) {
            try  {
                entrada = new BufferedReader(new InputStreamReader(canal.getInputStream()));

                process = builder.exec(cmd);
                BufferedWriter bw = null;

                Writer entradaProceso = new OutputStreamWriter((process.getOutputStream()));

                bw = new BufferedWriter(entradaProceso);
                while ((valorEntrada = entrada.readLine()) != null) {
                    bw.write(valorEntrada);
                    System.out.println(valorEntrada);
                }
                bw.close();

                BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linea;
                while ((linea = bf.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }finally{
                try{
                    if(entrada != null) {
                        entrada.close();
                    }
                }catch (IOException e){
                    System.err.println(e.toString());
                }
                if (canal != null) {
                    try {
                        canal.close();
                    } catch (Exception e) {
                        System.err.println(e.toString());
                    }
                }
            }
        }
       
    }
}
