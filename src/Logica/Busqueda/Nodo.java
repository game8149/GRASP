/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Busqueda;

import java.util.ArrayList;

/**
 *
 * @author gavid
 */
public class Nodo {
    private int id;
    private int idCiudad;
    private int anterior;
    
    private double g;
    private double h;
    private ArrayList<Nodo> sucesores;
    
    public Nodo(int id,int idAnterior){
        this.id=id;
        this.anterior=idAnterior;
    }
    
    public int getID(){
        return id;
    }
    
    
    public int getIDAnt(){
        return anterior;
    }
    
    public double getF(){
        return g+h;
    }
    
    public double getG(){
        return g;
    }
    
    public double getH(){
        return h;
    }
    
    public void setH(double h){
        this.h=h;
    }
    
    public void setG(double g){
        this.g=g;
    }
    
    public void setIdAnt(int ID){
        this.anterior=ID;
    }
    
    public void setId(int ID){
        this.id=ID;
    }
    
}
