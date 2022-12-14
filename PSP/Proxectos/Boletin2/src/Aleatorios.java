import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Aleatorios {
    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime();
        InputStreamReader isr = new InputStreamReader(System.in); //InputStreamReader del sistema
        BufferedReader br = new BufferedReader(isr); //Buffer del Sistema
        String cadena = "";
        Process p = null;

        try {
            System.out.print("Introduzca una linea: ");
            cadena = br.readLine();
            while(!cadena.equals("fin")) {
                System.out.println("Sigue leyendo");
                p = r.exec("java src/AleatorioHijo.java"); // Importante poner SRC/ delante del nombre del archivo
                InputStream ip = p.getInputStream(); // InputStream del Proceso
                BufferedReader bf = new BufferedReader(new InputStreamReader(ip)); //Buffer del proceso
                System.out.println(bf.readLine());
                System.out.print("Introduzca una linea: ");
                cadena = br.readLine();
            }
            System.out.println("Estatus de término: " + p.exitValue());
        } catch(IOException ex) {
            System.out.println("ERROR:" + ex);
            System.exit(-1);
        }
    }
}
