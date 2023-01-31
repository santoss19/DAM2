import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Aleatorio {
    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String cadena = "";

        try {
            System.out.print("Introduzca una linea: ");
            cadena = br.readLine();
            while(!cadena.equals("fin")) {
                System.out.println("Sigue leyendo");
                Process p = r.exec("java AleatorioHijo.java");
                InputStream ip = p.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(ip));
                System.out.println(bf.readLine());
                System.out.print("Introduzca una linea: ");
                cadena = br.readLine();
            }
        } catch(IOException ex) {
            System.out.println("ERROR:" + ex);
            System.exit(-1);
        }
    }
}