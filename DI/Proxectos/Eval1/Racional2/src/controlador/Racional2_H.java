package controlador;

import modelo.Racional;

public class Racional2_H {

    private Racional r1;
    private Racional r2;
    private Racional r3;


    public Racional2_H(Racional r1, Racional r2) {
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = new Racional();
    }

    public Racional sumarRacionales() {
        r3.setNumerador((r1.getNumerador() * r2.getDenominador()) + (r1.getDenominador() * r2.getNumerador()));
        r3.setDenominador((r1.getDenominador() * r2.getDenominador())); 
        return r3;
    }

    public Racional restarRacionales() {
        r3.setNumerador((r1.getNumerador() * r2.getDenominador()) - (r1.getDenominador() * r2.getNumerador()));
        r3.setDenominador((r1.getDenominador() * r2.getDenominador())); 
        return r3;
    }

    public Racional multiplicarRacionales() {
        r3.setNumerador((r1.getNumerador() * r2.getNumerador()));
        r3.setDenominador( (r1.getDenominador() * r2.getDenominador()));
        return r3;
    }

    public Racional dividirRacionales() {
        r3.setNumerador((r1.getNumerador() * r2.getDenominador()));
        r3.setDenominador((r1.getDenominador() * r2.getNumerador()));
        return r3;
    }
}
