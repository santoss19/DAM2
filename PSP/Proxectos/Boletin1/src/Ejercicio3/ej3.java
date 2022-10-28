package Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ej3 {
    public static void main(String[] args) throws IOException {
        
        Runtime r = Runtime.getRuntime();
        String comm = "CMD /C ping 192.168.56.1";
        Process p = r.exec(comm);
        InputStream is = p.getInputStream();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
        String linea = null;
        
        while((linea = bfr.readLine()) != null) {
            System.out.println(linea);
        }

    }
}
