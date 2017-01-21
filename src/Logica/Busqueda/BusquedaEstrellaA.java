/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Busqueda;

import Logica.Grafo;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author InfoLabC
 */
public class BusquedaEstrellaA {

    Grafo graf;
    ArrayList<Nodo> abierto=new ArrayList();
    ArrayList<Nodo> cerrado=new ArrayList();
    ArrayList<Nodo> sucesoresMejorNodo=new ArrayList();
    Nodo ini;
    Nodo fin;

    public Grafo getGraf() {
        return graf;
    }

    public void setGraf(Grafo graf) {
        this.graf = graf;
    }
    
    
    
    private double calcularG(Nodo nodo){
        int acum=0;
        Nodo actual=nodo;
        int idTemp=actual.getID();
        while(idTemp!=ini.getID()){
            Point A=graf.getCiudad(nodo.getID()).getCoordenada();
            Point B=graf.getCiudad(nodo.getIDAnt()).getCoordenada();
            acum+=Math.sqrt( Math.pow(A.x-B.x,2) +  Math.pow(A.y-B.y,2));
            idTemp=actual.getIDAnt();
            actual=this.getNodoAbierto(idTemp);
            if(actual==null)
                actual=this.getNodoCerrado(idTemp);
        }
        System.out.println("InitG ->"+acum);
        return acum;
    }
    
    private double calcularH(Nodo actual,Nodo fin){
        Point A=graf.getCiudad(actual.getID()).getCoordenada();
        Point B=graf.getCiudad(fin.getID()).getCoordenada();
        System.out.println("InitH ->"+Math.sqrt( Math.pow(A.x-B.x,2) +  Math.pow(A.y-B.y,2)));
        return Math.sqrt(Math.pow(A.x-B.x,2) +  Math.pow(A.y-B.y,2));
    }
        
    public Nodo getNodoMinF(){
        int min=999999;
        int idSelect=-1;
        for(int i=0;i<abierto.size();i++){
            if(min>=abierto.get(i).getF()){
                min=(int)abierto.get(i).getF();
                idSelect=i;
            }
        }
        return abierto.remove(idSelect);
    }
    
    private boolean enAbierto(Nodo nodo){
        for(Nodo n:abierto)
            if(n.getID()==nodo.getID()) return true;
        return false;
    }
    
    private boolean enCerrado(Nodo nodo){
        for(Nodo n:cerrado)
            if(n.getID()==nodo.getID()) return true;
        return false;
    }
    
    
    private Nodo getNodoAbierto(int id){
        for(Nodo n:abierto)
            if(n.getID()==id) return n;
        return null;
    }
    
    private Nodo getNodoCerrado(int id){
        for(Nodo n:cerrado)
            if(n.getID()==id) return n;
        return null;
    }
    
    public ArrayList<Nodo> getSolucion(int idCiudadInicial,int idCiudadFinal){
        System.out.println("Init:"+idCiudadInicial+" , Final:"+idCiudadFinal);
        
        ini=new Nodo(idCiudadInicial,idCiudadInicial);
        fin=new Nodo(idCiudadFinal,idCiudadFinal); 
        
        ini.setH(calcularH(ini,fin));
        ini.setG(calcularG(ini));
        
        Nodo actual=null;
        abierto.clear();
        cerrado.clear();
        
        abierto.add(ini);
        
        while(!abierto.isEmpty()){
            actual=getNodoMinF();
            cerrado.add(actual);
            System.out.println("Actual: " +actual.getID()+" <--Anterior: "+actual.getIDAnt());
            if(actual.getID()==fin.getID()) return cerrado;
            else{
                System.out.println(" No termina aun");
                ArrayList<Nodo> sucesores=new ArrayList();
                for(int id:graf.getVecinos(actual.getID())){
                    Nodo nod=new Nodo(id,actual.getID());
                    sucesores.add(nod);
                    System.out.println("Actual: "+actual.getID()+" Sucesor: "+nod.getID());
                }
                for(Nodo nodoS:sucesores){
                    if(!enAbierto(nodoS)&&!enCerrado(nodoS)){
                        nodoS.setG(calcularG(nodoS));
                        nodoS.setH(calcularH(nodoS,fin));
                        abierto.add(nodoS);
                        System.out.println("Actual: "+actual.getID()+" Sucesor: "+nodoS.getID()+" F:"+nodoS.getF());
                    }
                    else if(enAbierto(nodoS)){
                        Nodo nodoEnAbier=getNodoAbierto(nodoS.getID());
                        double temp=calcularG(nodoS);
                        if(temp<nodoEnAbier.getG()){
                            sucesoresMejorNodo.add(new Nodo(nodoEnAbier.getID(),nodoEnAbier.getIDAnt()));
                            nodoEnAbier.setG(temp);
                            nodoEnAbier.setH(calcularH(nodoS,fin));
                            nodoEnAbier.setId(nodoS.getID());
                            //dropRuta(nodoEnAbier);
                        }
                    }
                    else if(enCerrado(nodoS)){
                        Nodo nodoEnCerrado=getNodoCerrado(nodoS.getID());
                        double temp=calcularG(nodoS);
                        if(temp<nodoEnCerrado.getG()){
                            sucesoresMejorNodo.add(new Nodo(nodoEnCerrado.getID(),nodoEnCerrado.getIDAnt()));
                            nodoEnCerrado.setG(temp);
                            nodoEnCerrado.setH(calcularH(nodoS,fin));
                            nodoEnCerrado.setId(nodoS.getID());
                            //dropRuta(nodoEnCerrado);
                        }
                    }
                        
                }
                System.out.println("Finalizado Actual: "+actual.getID());
            }
        }
        return cerrado;
    }
    
    
    public boolean tieneReferencia(Nodo act){
        int count=0;
        for(Nodo n:cerrado){
            if(n.getIDAnt()==act.getID()) count++;
        }
        for(Nodo n:abierto){
            if(n.getIDAnt()==act.getID()) count++;
        }
        if(count>1) return true;
        return false;
    }
    
    private void dropRuta(Nodo nodo){
        Nodo actual=nodo;
        while(actual!=null&&enAbierto(actual)){
            int idTemp=actual.getIDAnt();
            if(tieneReferencia(actual)){
                actual=getNodoAbierto(idTemp);
            }
            if(enAbierto(actual))
                abierto.remove(actual);
            else 
                cerrado.remove(actual);
        }
    }
}
