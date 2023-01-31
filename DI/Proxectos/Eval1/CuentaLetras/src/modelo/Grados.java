package modelo;

public class Grados {
    
    double gCent = 0;
    double gFar = 0;

    public double pasaCentToFar() {
        return Math.round(((gCent * 9)/5) + 32);
    }

    public double pasaFarToCent() {
        return Math.round(((gFar - 32) * 5)/9);
    }

    public double getgCent() {
        return gCent;
    }

    public void setgCent(double gCent) {
        this.gCent = gCent;
    }

    public double getgFar() {
        return gFar;
    }

    public void setgFar(double gFar) {
        this.gFar = gFar;
    }
}
