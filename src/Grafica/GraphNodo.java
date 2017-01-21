
package Grafica;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class GraphNodo{
    private int SERIE;
    private final int tipo=1;
    private String nombre;
    private int maxTok;
    private Boolean estadoTok=false;
    private Ellipse2D circPlaza;
    private Ellipse2D cirTok;
  
    private final int width=40,height=40;
    private final int widthT=10,heightT=10;
    private int posX,posY;
    private int posXCentral,posYCentral;
    private Color coPlaza,coTok;
    
    
    public GraphNodo(String nombre, int x, int y,int serie){
    
        this.posX=x;
        this.posY=y;
        this.posXCentral=this.posX+(width/2);
        this.posYCentral=this.posY+(height/2);
        this.circPlaza= new Ellipse2D.Double(x, y,width, height);
        this.cirTok= new Ellipse2D.Double(posXCentral,posYCentral,widthT, heightT);
        this.nombre=nombre;
        this.SERIE=serie;
        this.coPlaza=new Color(153,153,153);
        this.coTok=Color.WHITE;}
    
    public void setName(String name){
        this.nombre=name;
    }
    
    public int getCX() {
        return this.posXCentral;
    }

    public int getCY() {
        return this.posYCentral;
    }

    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }
    
    public void setEstadoTok(boolean k){
        this.estadoTok=k;
    }
    
    public boolean contiene(int x, int y){
        return circPlaza.getBounds2D().contains(x, y);
    }
    
    public Shape getShape() {
       return circPlaza;
    }

    public Shape getShapeTok() {
       return cirTok;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getSerie(){
        return SERIE;
    }
    
    public Color getColor(){
        return this.coPlaza;
    }
    
    public Color getColorT(){
        return this.coTok;
    }
    
    public boolean tokenActivado(){
        return this.estadoTok;
    }

    public int getHeight() {
        return height;
    }

    public int getHeightT() {
        return heightT;
    }
    
    public void setMaxTok(int max){
        if(max==0){
            this.setEstadoTok(false);
        }
        else{
            this.setEstadoTok(true);
        }
        this.maxTok=max;
    }
    
    public String getTokMax(){
        return String.valueOf(this.maxTok);
    }
    public void addPoint(int x, int y) {
        this.posX+=x;
        this.posY+=y;
        this.posXCentral=this.posX+(width/2);
        this.posYCentral=this.posY+(height/2);
        circPlaza.setFrame(this.posX,this.posY,width, height);
        cirTok.setFrame(posXCentral,posYCentral,widthT,heightT);
    }

}
