
package Grafica;

import Logica.AsignadorDeConector;
import Logica.Ciudad;
import Logica.Enlace;
import Logica.Grafo;
import Logica.PuntoEnlace;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Stack;
import javax.swing.JPanel;

public class PanelGraph extends JPanel implements Runnable{
    
    private Dictionary<Integer,GraphNodo> nodosG;
    private Dictionary<Integer,GraphEnlace> lineasG;
    private GraphEnlace lineaTemporal;
    
    int actionA,objetoA;
    private int objTipoSelect=1;
    private int idObjSelect=-1;
    private int objIndexSelect;
    
    
    private boolean isStopDraw=false;
    
    public Grafo grafo;
    
    private AsignadorDeConector asigCon=new AsignadorDeConector();
    
    Color fondoColor=Color.WHITE;
    
    private Stack<String> nombrePlaza;
    private Stack<String> nombreTrans;
    VentanaPrincipal gui;
    Thread hilo;
    
    
    public void start(){
        this.hilo=new Thread(this);
        hilo.start();
    }
    
    public void stop() throws InterruptedException{
        hilo.join();
    }
    
    private void stopDraw(){
        this.isStopDraw=true;
    }
    
    private boolean isStopDraw(){
        return isStopDraw;
    }
    
    private void resumeDraw(){
        this.isStopDraw=false;
    } 
    
    public PanelGraph(){
        MouseAdapter ma=new MouseAdapter(){
            int iniObjIndex,idObjIni,iniObjTipo;
            int finObjIndex,finObjSerie,finObjTipo;
            int posX,posY;
            int iniPx,iniPy;
            int finPx,finPy;
            String tmp;
            
            
            
            public boolean setObjSelected(int x, int y){
                int temp;
                for(temp=0;temp<nodosG.size();temp++){
                    if(nodosG.get(temp).contiene(x,y)){
                        posX=nodosG.get(temp).getCX();
                        posY=nodosG.get(temp).getCY();
                        idObjSelect=nodosG.get(temp).getSerie();
                        objTipoSelect=1;
                        objIndexSelect=temp;
                        return true;
                    }
                }
                for(temp=0;temp<lineasG.size();temp++){
                    if(lineasG.get(temp).contiene(x,y)){
                        idObjSelect=lineasG.get(temp).getSerie();
                        objTipoSelect=3;
                        objIndexSelect=temp;
                        return true;
                    }
                }
                idObjSelect=-1;
                objIndexSelect=-1;
                objTipoSelect=-1;
                return false;
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
                setObjSelected(posX,posY);
                switch(getAction()){
                    case 1:
                        // Si queremos hacer alguna accion en especial sobre el objeto
                        if(e.getClickCount()==2){ 
                            if(idObjSelect!=-1){
                                switch(objTipoSelect){
                                    case 1:
                                        //Verificar info si es Plaza
//                                        activarOpPlaza(objSerieSelect);
                                        break;
                                    case 2:
                                        //Verificar info si es Transicion
//                                        activarOpTrans(objSerieSelect);
                                        break;
                                    case 3:
//                                        activarOpArco(objSerieSelect);
                                        break;
                                }
                            }
                        }
                        break;
                    case 2:
                        //Agregar una Nodo sobre el panel
                        tmp=getNombreCiudad();
                        int key= grafo.addCiudad(tmp,new Point(posX,posY));
                        nodosG.put(key,new GraphNodo(tmp,posX,posY,key));
                        break;
                    case 4:
                        //Agregar Enlace
                        if(objIndexSelect!=-1){
                            iniObjIndex=objIndexSelect;
                            idObjIni=idObjSelect;
                            iniObjTipo=objTipoSelect;
                            if(objTipoSelect==1){
                                lineaTemporal=new GraphEnlace(-1,-1,-1,-1,-1);
                                iniPx=posX;
                                iniPy=posY;
                                lineaTemporal.actualizarP1(iniPx,iniPy);
                            }
                        }
                        break;
                    case 5:
                        dropGraph(objIndexSelect,objTipoSelect,idObjSelect);
                        break;                    
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e){
                finPx = e.getX();
                finPy = e.getY();
                switch(getAction()){
                    case 4:
                        setObjSelected(finPx,finPy);
                        if(idObjSelect!=-1){
                            if(iniObjTipo==1&&objTipoSelect==1){
                                //Inicio: Nodo Fin: Nodo      
                                PuntoEnlace in=asigCon.getConector(idObjIni,iniObjTipo);
                                PuntoEnlace out=asigCon.getConector(idObjSelect,objTipoSelect);
                                double distancia=Grafo.getDistancia(grafo.getCiudad(idObjIni).getCoordenada(),grafo.getCiudad(idObjSelect).getCoordenada());
                                System.out.println(distancia);
                                int key=grafo.addEnlace(in,out,distancia);
                                lineasG.put(key,new GraphEnlace(key,iniPx,iniPy,posX,posY));               
                                lineasG.get(key).setIn(in);
                                lineasG.get(key).setOut(out);
                            }
                        }
                        break;
                }
                finObjSerie=-1;
                finObjTipo=-1;
                finObjIndex=-1;
                idObjIni=-1;
                iniObjTipo=-1;
                iniObjIndex=-1;
                lineaTemporal=new GraphEnlace(-1,-1,-1,-1,-1);
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int dx=e.getX()-posX;
                int dy=e.getY()-posY;
                if(idObjSelect!=-1){
                    switch(getAction()){
                        case 1:
                            switch(objTipoSelect){
                                case 1:
                                    nodosG.get(objIndexSelect).addPoint(dx,dy);
                                    actualizarPosArista(objIndexSelect,idObjSelect, objTipoSelect);
                                    break;  
                            }
                            break;
                        case 4:
                            finPx=e.getX();
                            finPy=e.getY();
                            //Obtener punto desplazado para linea temporal
                            lineaTemporal.actualizarP2(finPx,finPy);
                            lineaTemporal.updateLine();
                            break;
                    }
                }
                repaint();
                posX+=dx;
                posY+=dy;
            }
        };
        this.addMouseMotionListener(ma);
        this.addMouseListener(ma);
        this.setLayout(new BorderLayout());
        this.setSize(934,673);
        setBackground(fondoColor);
        grafo=new Grafo();
        this.validate();
        nodosG=new Hashtable();
        lineasG=new Hashtable();
        nombrePlaza=new Stack();
        nombreTrans=new Stack();
        initPilaNombres();
       
    }
    
    public void dropObject(int serie, int tipo){
        switch(tipo){
            case 1:
                grafo.dropCiudad(serie, tipo);
                break;
            case 2:
                grafo.dropCiudad(serie, tipo);
                break;
            case 3:
                grafo.dropCiudad(serie, tipo);
                break;
        }
    }
    
    
    public VentanaPrincipal getGui() {
        return gui;
    }

    public void setGui(VentanaPrincipal gui) {
        this.gui = gui;
    }
    
  
    
    public void initer(){
        nodosG=new Hashtable();
        lineasG=new Hashtable();
        nombrePlaza=new Stack();
        nombreTrans=new Stack();
        initPilaNombres();
    }
    
    public void initPilaNombres(){
        for(int i=50;i>0;i--){
            nombrePlaza.add("P"+i);
        }
        for(int i=90;i>64;i--){
            nombreTrans.add(String.valueOf((char)i));
        }
    }
    
    public String getNombreCiudad(){
        return nombrePlaza.pop();
    }
    
    public String getIDTrans(){
        return nombreTrans.pop();
    }
    
    public void dropIDPlaza(String k){
        nombrePlaza.push(k);
    }
    
    public void dropIDTrans(String k){
        nombreTrans.push(k);
    }
    
    public int getAction(){
        return gui.actionID;
    }
    
    public GraphEnlace getLineAux(){
        return lineaTemporal;
    }
    
    public void dropRutaLine(int serie,int tipe){
        
//        for(int i=0;i<lineasG.size();i++){
//            if(getLine(i).getInTipe()==tipe&&getLine(i).getInSerie()==serie){
//                lineasG.remove(i);
//                dropRutaLine(serie,tipe);
//            }
//            else if(getLine(i).getOutTipe()==tipe&&getLine(i).getOutSerie()==serie){
//                lineasG.remove(i);
//                dropRutaLine(serie,tipe);
//            }
//        }
        gui.actualizarTexto();
    }
    
    public void dropGraph(int index, int tipo, int serie){
        if(serie!=-1){
            stopDraw();
            switch(tipo){
                case 1:
                    //salvar nombre de plaza
                    dropIDPlaza(getPlazaID(index));
                    //eliminar lineas relacionadas
                    dropRutaLine(getPlaza(index).getSerie(),tipo);
                    nodosG.remove(index);
                    dropObject(serie, tipo);
                    gui.actualizarTexto();
                    break;
                case 3:
                    lineasG.remove(index);
                    dropObject(serie, tipo);
                    gui.actualizarTexto();
                    break;
                default:

            }
            resumeDraw();
        }
    }
    
    public void actualizarScreen(){
        this.repaint();
    }
    
    
    public void actualizarPosArista(int index,int serie, int tipe){
        
        for(int i=0;i<lineasG.size();i++){
            switch(tipe){
                case 1:
                    
                    if(lineasG.get(i).getInSerie()==serie&&lineasG.get(i).getInTipe()==1){
                        lineasG.get(i).actualizarP1(getPlazaCX(index),getPlazaCY(index));
                        grafo.getEnlace(lineasG.get(i).SERIE).setDistancia(lineasG.get(i).updateLine());
                    }
                    if(lineasG.get(i).getOutSerie()==serie&&lineasG.get(i).getOutTipe()==1){
                        lineasG.get(i).actualizarP2(getPlazaCX(index),getPlazaCY(index));
                        grafo.getEnlace(lineasG.get(i).SERIE).setDistancia(lineasG.get(i).updateLine());
                    }
                    break;
            }      
        }
    }
    
    
    
    /// Metodos Plaza
    public int sizeLPlaza(){
        return nodosG.size();
    }
    
    public int getIndexPlaza(int serie){
        for(int i=0;i<sizeLPlaza();i++){
            if(nodosG.get(i).getSerie()==serie)return i;
        }
        return -1;
    }
    
    public String getPlazaID(int i){
        return nodosG.get(i).getNombre();
    }
    
    public GraphNodo getPlaza(int index){
        return nodosG.get(index);
    }
    
    public int getPlazaX(int i){
        return nodosG.get(i).getX();
    }
    
    public int getPlazaY(int i){
        return nodosG.get(i).getY();
    }
    
    public int getPlazaCX(int i){
        return nodosG.get(i).getCX();
    }
    
    public int getPlazaCY(int i){
        return nodosG.get(i).getCY();
    }
    
    public Shape getPlazaShpe(int i){
        return nodosG.get(i).getShape();
    }
    
    private void doDrawing(Graphics g) {
        int u;
        Graphics2D g2d = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        if(!this.isStopDraw()){
            Font font = new Font("Arial", Font.BOLD,12);
            g2d.setFont(font);
            if(getLineAux()!=null){
                g2d.setPaint(getLineAux().color);
                g2d.fill(getLineAux().getLineShape());
            }
            ArrayList<GraphEnlace> k=Collections.list(lineasG.elements());
            for(GraphEnlace link:k){
                g2d.setPaint(link.color);
                g2d.fill(link.getLineShape());
                g2d.setPaint(Color.BLACK);
                g2d.drawString(String.valueOf((int)grafo.getEnlace(link.getSerie()).getDistancia()),link.getPxC(),link.getPyC()-15);
            }

            for(u=0;u<nodosG.size();u++){
                if(getPlaza(u)!=null){
                    g2d.setPaint(Color.YELLOW);
                    g2d.fill(getPlazaShpe(u));
                    g2d.setColor(getPlaza(u).getColor());
                    g2d.draw(getPlazaShpe(u));
                    g2d.setPaint(Color.BLACK);
                    g2d.drawString(getPlazaID(u), getPlazaX(u)+15, getPlazaY(u)+23);
                }
            }   
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);        
    }

    @Override
    public void run() {
        
    }
        
}
