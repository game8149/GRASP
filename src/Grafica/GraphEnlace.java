
package Grafica;

import Logica.Grafo;
import Logica.PuntoEnlace;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

public class GraphEnlace {
    int SERIE;
    private Point p1,p2;
    private int ID=3;
    private int tipo;
    private BasicStroke k;
    private Line2D line;
    Color color=new Color(126,126,126);
    private double pendiente;
    int xTemp,yTemp,xAnt,yAnt;
    private PuntoEnlace in;
    private PuntoEnlace out;
    int maxTokens=1;
    
            
    public GraphEnlace(int serie,int x1, int y1,int x2, int y2){
        this.SERIE=serie;
        this.k=new BasicStroke(2f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
        this.tipo=3;
        this.p1=new Point(x1,y1);
        this.p2=new Point(x2,y2);
        this.line = new Line2D.Double(x1,y1,x2,y2);
    }

    public void setIn(PuntoEnlace in) {
        this.in = in;
    }

    public void setOut(PuntoEnlace out) {
        this.out = out;
    }

    
    public void setX1(int x){
        this.p1.x=x;
    }
    
    public void setY1(int y){
        this.p1.y=y;
    }
    
    public void setX2(int x){
        this.p2.x=x;
    }
    
    public void setY2(int y){
        this.p2.y=y;
    }
    
    public double getX1() {
        return this.p1.x;
    }

    public double getY1() {
        return this.p1.y;
    }
    
    public double getX2() {
        return this.p2.x;
    }

    public double getY2() {
        return this.p2.y;
    }
    
    public boolean contiene(int x, int y){
        return line.getBounds2D().contains(x, y);
    }

    public Shape getLineShape() {
       return k.createStrokedShape(line);
    }
   
    public int getSerie(){
        return SERIE;
    }
    
    public double updateLine(){
        xTemp=p2.x;
        yTemp=p2.y;
        line.setLine(p1.x,p1.y,xTemp,yTemp);
        return Grafo.getDistancia(p1,new Point(xTemp,yTemp));
    }
    
    public void actualizarP1(int x1, int y1){
        this.p1.x=x1;
        this.p1.y=y1;
    }
    
    public void actualizarP2(int x2, int y2){
        xAnt=this.p2.x;
        yAnt=this.p2.y;
        this.p2.x=x2;
        this.p2.y=y2;
    }
    
    public double getM(){
        return pendiente;
    }
    
    public int getInSerie(){
        return in.getObjId();
    }
    
    public int getInTipe(){
        return in.getObjType();
    }
    
    public int getOutSerie(){
        return out.getObjId();
    }
    
    public int getOutTipe(){
        return out.getObjType();
    }

    
    public PuntoEnlace getIn() {
        return in;
    }

    public PuntoEnlace getOut() {
        return out;
    }
    
    public int getMaxTokens() {
        return maxTokens;
    }

    
    public int getPxC(){
        return (p1.x+p2.x)/2;
    }
    
    public int getPyC(){
        return (p1.y+p2.y)/2;
    }
    
    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }
    
    
}
