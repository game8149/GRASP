
package Logica;

public class Enlace {
    int ID;
    
    PuntoEnlace in;
    PuntoEnlace out;
    
    private double distancia;

    public Enlace(int id,PuntoEnlace in,PuntoEnlace out, double distancia) {
        this.ID = id;
        this.in=in;
        this.out=out;
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
