
package Logica;


public class AsignadorDeConector {
    int contador=0;
    
    public PuntoEnlace getConector(int objectID,int objectType){
        contador++;
        return new PuntoEnlace(contador,objectID,objectType);
    }
            
}
