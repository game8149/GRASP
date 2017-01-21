/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Grafica.PanelGraph;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexis
 */
public class Hilo implements Runnable {
    PanelGraph p;
    Thread hilo;
    
    public Hilo(PanelGraph h){
        this.p=h;
        start();
    }
    
    public void start(){
        hilo=new Thread(this);
        hilo.start();
    }
    
    public void stop(){
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        p.repaint();
    }
    
}
