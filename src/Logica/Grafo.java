
package Logica;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

public class Grafo {
    
    private int countEnlaces=0;
    private int countNodos=0;
    
    private Dictionary<Integer,Enlace> enlaces=new Hashtable();
    private Dictionary<Integer,Ciudad> ciudad=new Hashtable();
    
    private Object lastObject=null;
    
    // MANEJO DE ENLACEs
    public int addEnlace(PuntoEnlace in,PuntoEnlace out, double distancia){
        enlaces.put(countEnlaces,new Enlace(countEnlaces,in,out,distancia));
        lastObject=getEnlace(countEnlaces);
        countEnlaces++;
        return countEnlaces-1;
    }
    
    public Enlace getEnlace(int ID){
        return enlaces.get(ID);
    }
       
    // MANEJO DE NODOS
    public int addCiudad(String nombre, Point pos){
           ciudad.put(countNodos,new Ciudad(nombre,countNodos,pos));
           lastObject=getCiudad(countNodos);
           countNodos++;
           return countNodos-1;
    }
    
    public Ciudad getCiudad(int ID){
        return ciudad.get(ID);
    }
    
    public Enumeration<Ciudad> getCiudades(){
        return ciudad.elements();
    }
    
    public String dropEnlace(int ID, int type){
        Stack<Enlace> temp=new Stack();
                for(int i=0;i<enlaces.size();i++){
                    if(enlaces.get(i).in.getObjId()==ID&&enlaces.get(i).in.getObjType()==type){
                        System.out.println("Encontrado Salida de "+enlaces.get(i).in.getObjId()+" tipo "+enlaces.get(i).in.getObjType());
                        temp.add(enlaces.get(i));
                    }
                    if(enlaces.get(i).out.getObjId()==ID&&enlaces.get(i).out.getObjType()==type){
                        System.out.println("Encontrado Entrada de "+enlaces.get(i).out.getObjId()+" tipo "+enlaces.get(i).out.getObjType());
                        temp.add(enlaces.get(i));
                    }
                }
                if(!temp.empty()){
                    for(Enlace k: temp){
                        enlaces.remove(k);
                    }
                    System.out.println("Removidooooo");
                    return "Arcos removidos...";
                }
                else{
                    return "No tiene arcos...";
                }
    }
    
    public String dropCiudad(int serie, int tipo){
        String tmp="No se encuentra este tipo";
        switch(tipo){
            case 1:
                System.out.println(dropEnlace(serie,tipo));
                for(int i=0;i<ciudad.size();i++){
                    if(ciudad.get(i).getSerie()==serie){
                        ciudad.remove(i);
                        return "Eliminación Exitosa...";
                    }
                }
                return "No se encuentra Plaza...";
            case 3:
                for(int i=0;i<enlaces.size();i++){
                    if(enlaces.get(i).ID==serie){
                        enlaces.remove(i);
                        return "Eliminación Exitosa...";
                    }
                }
                return "No se encuentra Arco...";
        }
        return tmp;
    }
    
    public Object lastObject(){
        return lastObject;
    }
    
    public void setLastObject(Object last){
        this.lastObject=last;
    }
    
    public ArrayList<Integer> getVecinos(int idCiudad){
        ArrayList<Enlace> k=Collections.list(enlaces.elements());
        ArrayList<Integer> vecinos=new ArrayList();
        for(Enlace link:k){
            if(link.in.getObjType()==1&&link.in.getObjId()==idCiudad){
                vecinos.add(link.out.getObjId());
            }
            else if(link.out.getObjType()==1&&link.out.getObjId()==idCiudad){
                vecinos.add(link.in.getObjId());
            }
        }
        return vecinos;
    }
    
    static public double getDistancia(Point A,Point B){
        return Math.sqrt(Math.pow(A.x-B.x,2) +  Math.pow(A.y-B.y,2));
    }
    
}
