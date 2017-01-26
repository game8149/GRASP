package Logica.Grasp;


import java.util.LinkedList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gavid
 */
public class VRPSolucion extends SolucionGrasp{
    
    
    public VRPSolucion(int init){
        solucion=new LinkedList<Integer>();
        ((LinkedList<Integer>)solucion).add(init);
    }    
    
    public void Clear(){
        ((LinkedList<Integer>)solucion).clear();
    }
    
    public void AddCiudad(int id){
        ((LinkedList<Integer>)solucion).add(id);
    }
    
    public int GetCiudadActual(){
        return ((LinkedList<Integer>)solucion).getLast();
    }

    public int GetCiudadInit(){
        return ((LinkedList<Integer>)solucion).getFirst();
    }
    
     
    
}
