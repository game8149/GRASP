
package Logica;

public class PuntoEnlace {
    private int ID;
    private int serieObject,tipeObject;

    public PuntoEnlace(int id, int objId,int objType) {
        this.serieObject = objId;
        this.tipeObject = objType;
        this.ID=id;
    }

    public int getObjId() {
        return serieObject;
    }

    public int getObjType() {
        return tipeObject;
    }
    
    public int getID(){
        return ID;
    }
            
}
