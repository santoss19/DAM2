package Ejercicio2;

import java.io.File;
import java.io.IOException;

public class ej2 {
    public static void main(String[] args) throws IOException {

        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
        File fOut = new File("salida.txt");
        File fErr = new File("err.txt");

        pb.redirectOutput(fOut);
        pb.redirectError(fErr);

        pb.start();
    }
}
