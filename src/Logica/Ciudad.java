
package Logica;

import java.awt.Point;

public class Ciudad {
    
    private int ID;
    private String nombre;
    private int tipo;
    private Point coordenada;
    
    public Ciudad(String nombre,int ID,Point coordenada) {
        this.ID=ID;
        this.nombre = nombre;
        this.coordenada=coordenada;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSerie() {
        return ID;
    }

    public void setSerie(int seriePlaza) {
        this.ID = seriePlaza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Point getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
    }
    
}
