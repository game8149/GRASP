/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Logica.Busqueda.BusquedaEstrellaA;
import Logica.Busqueda.Nodo;
import Logica.Ciudad;
import Logica.Grafo;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author alexis
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    
    private PanelGraph tPanel;
    private OpRun opRun;// Ventanas de ingreso
    ArrayList<JLabel> btns=new ArrayList();
    String btn_actualClick,pnl_actualClik;
    Color pnl_pressed,pnl_entered,pnl_actual; 
    Color btn_pressed,btn_entered,btn_actual,btn_released; 
    CardLayout card;
    public int actionID;
    BusquedaEstrellaA busq;
            
     
    public VentanaPrincipal() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        btns.add(btn_mouse);
        btns.add(btn_arc);
        btns.add(btn_plaz);
        btns.add(btn_help);
        btn_pressed=new Color(97,97,97);
        btn_entered=new Color(126,126,126);
        btn_actual=new Color(51,51,51);
        btn_released=new Color(255,165,0);
        
        btn_mouse.setName("1");
        btn_plaz.setName("3");
        btn_arc.setName("4");
        btn_help.setName("7");
        
        inite();
        glassInstance();
        this.setLocationRelativeTo(null);
        opRun=new OpRun(this,true);
    }
    
    public void restartLabels(){
        for (JLabel btn : btns) {
            if (!btn.getName().equals(btn_actualClick)) {
                btn.setBackground(btn_actual);
            }
        }
    }
    
    public void glassInstance(){
        this.getRootPane().setGlassPane(new JComponent(){
            @Override
            public void paintComponent(Graphics g){
                g.setColor(new Color(0,0,0,100));
                g.fillRect(0, 0,this.getWidth(), this.getHeight());
                super.paintComponent(g);
            }
        });
    }
    
    public void inite(){
//        opplaza=new OpPlaza(this, true,this);
//        optrans=new OpTrans(this, true,this);
//        oparco=new OpArco(this,true,this);
        tPanel=new PanelGraph();
        busq=new BusquedaEstrellaA();
        
        tPanel.setGui(this);
        panelScreen.add(tPanel);
        busq.setGraf(tPanel.grafo);
        card=new CardLayout();
        Principal.setLayout(card);
        Principal.add(P1,"p1");
        Principal.add(P2,"p2");
        card.show(Principal,"p1");
        this.btn_actualClick=btn_mouse.getName();
        restartLabels();
    }

//    
    public void activarOpPlaza(int serie){
//        opplaza.setTitle(rdp.searchPlaza(serie).getNombre());
//        opplaza.setNameText(rdp.searchPlaza(serie).getNombre());
//        opplaza.setToken(rdp.searchPlaza(serie).getNumTokens());
//        opplaza.setSerie(serie);
//        opplaza.setTipo(rdp.searchPlaza(serie).getTipo());
        
        opRun.setVisible(true);
    }
//    
//    public void desactivarOpPlaza(int numTok,String nombre,int tipo){
//        rdp.saveNumTokens(opplaza.getSerie(), numTok);
//        rdp.searchPlaza(opplaza.getSerie()).setTipo(tipo);
//        tPanel.getPlaza(tPanel.getIndexPlaza(opplaza.getSerie())).setName(rdp.searchPlaza(opplaza.getSerie()).getNombre());
//        tPanel.getPlaza(tPanel.getIndexPlaza(opplaza.getSerie())).setMaxTok(numTok);
//        opplaza.setVisible(false);
//    }
//    
//    public void activarOpTrans(int serie){
//        optrans.setTitle(rdp.searchTrans(serie).getNombre());
//        optrans.setNombre(rdp.searchTrans(serie).getNombre());
//        optrans.setCapacidad(rdp.searchTrans(serie).getCapacidad());
//        optrans.setTiempo(String.valueOf(rdp.searchTrans(serie).getTiempo()));
//        optrans.setSerie(serie);
//        optrans.setVisible(true);
//    }
//    
//    public void desactivarOpTrans(String nombre,int tm,int capacidad){
//        rdp.searchTrans(optrans.getSerie()).setNombre(nombre);
//        rdp.searchTrans(optrans.getSerie()).setTiempo(tm);
//        rdp.searchTrans(optrans.getSerie()).setCapacidad(capacidad);
//        tPanel.getTrans(tPanel.getIndexTrans(optrans.getSerie())).setTiempo(tm);
//        tPanel.getTrans(tPanel.getIndexTrans(optrans.getSerie())).setCapacidad(capacidad);        
//        optrans.setVisible(false);
//    }
//    
//    public void desactivarOpArco(int numTok){
//        rdp.searchArc(oparco.getSerie()).setSizeTok(numTok);
//        tPanel.getLine(tPanel.getIndexLine(oparco.getSerie())).setMaxTokens(numTok);
//        oparco.setVisible(false);
//    }
//    
//    public void activarOpArco(int serie){
//        oparco.setTitle("Configuración");
//        oparco.setSerie(serie);
//        oparco.setTokensB(rdp.searchArc(serie).getSizeTok());
//        oparco.setVisible(true);
//    }
//    
    public void actualizarTexto(){
//        salida.setText(rdp.getFormalPlaza());
//        salida.append(rdp.getFormalTrans());
//        salida.append(rdp.getFormalArco());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        P2 = new javax.swing.JPanel();
        panelSimul = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_plaz1 = new javax.swing.JLabel();
        btn_config1 = new javax.swing.JLabel();
        btn_arc1 = new javax.swing.JLabel();
        bn_drop2 = new javax.swing.JLabel();
        btn_help1 = new javax.swing.JLabel();
        btn_mouse1 = new javax.swing.JLabel();
        bn_drop3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        P1 = new javax.swing.JPanel();
        panelUI = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_plaz = new javax.swing.JLabel();
        btn_arc = new javax.swing.JLabel();
        btn_help = new javax.swing.JLabel();
        btn_mouse = new javax.swing.JLabel();
        panelScreen = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Principal = new javax.swing.JPanel();

        jLabel1.setText("Propiedades");

        jLabel2.setText("Serie");

        jLabel3.setText("Tipo");

        jLabel4.setText("Nombre");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        salida.setColumns(20);
        salida.setRows(5);
        jScrollPane1.setViewportView(salida);

        P2.setMinimumSize(new java.awt.Dimension(583, 321));
        P2.setName(""); // NOI18N
        P2.setPreferredSize(new java.awt.Dimension(583, 321));

        panelSimul.setBackground(new java.awt.Color(255, 255, 255));
        panelSimul.setMinimumSize(new java.awt.Dimension(583, 321));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        btn_plaz1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconPlaz.png"))); // NOI18N
        btn_plaz1.setOpaque(true);
        btn_plaz1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_plaz1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_plaz1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_plaz1MousePressed(evt);
            }
        });

        btn_config1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconSetting.png"))); // NOI18N
        btn_config1.setOpaque(true);
        btn_config1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_config1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_config1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_config1MousePressed(evt);
            }
        });

        btn_arc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconLink.png"))); // NOI18N
        btn_arc1.setOpaque(true);
        btn_arc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_arc1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_arc1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_arc1MousePressed(evt);
            }
        });

        bn_drop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconDrop.png"))); // NOI18N
        bn_drop2.setOpaque(true);
        bn_drop2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_drop2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_drop2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bn_drop2MousePressed(evt);
            }
        });

        btn_help1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconHelp.png"))); // NOI18N
        btn_help1.setOpaque(true);
        btn_help1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_help1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_help1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_help1MousePressed(evt);
            }
        });

        btn_mouse1.setBackground(new java.awt.Color(255, 165, 0));
        btn_mouse1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconPunt.png"))); // NOI18N
        btn_mouse1.setOpaque(true);
        btn_mouse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mouse1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mouse1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_mouse1MousePressed(evt);
            }
        });

        bn_drop3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconDrop.png"))); // NOI18N
        bn_drop3.setOpaque(true);
        bn_drop3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bn_drop3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bn_drop3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bn_drop3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_plaz1)
                    .addComponent(btn_config1)
                    .addComponent(btn_arc1)
                    .addComponent(bn_drop2)
                    .addComponent(btn_help1)
                    .addComponent(btn_mouse1)
                    .addComponent(bn_drop3))
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_mouse1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 30, Short.MAX_VALUE)
                .addComponent(btn_plaz1)
                .addGap(2, 2, 2)
                .addComponent(btn_arc1)
                .addGap(2, 2, 2)
                .addComponent(bn_drop3)
                .addGap(2, 2, 2)
                .addComponent(bn_drop2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 31, Short.MAX_VALUE)
                .addComponent(btn_help1)
                .addGap(2, 2, 2)
                .addComponent(btn_config1)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSimulLayout = new javax.swing.GroupLayout(panelSimul);
        panelSimul.setLayout(panelSimulLayout);
        panelSimulLayout.setHorizontalGroup(
            panelSimulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSimulLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        panelSimulLayout.setVerticalGroup(
            panelSimulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSimulLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout P2Layout = new javax.swing.GroupLayout(P2);
        P2.setLayout(P2Layout);
        P2Layout.setHorizontalGroup(
            P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSimul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        P2Layout.setVerticalGroup(
            P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSimul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        P1.setMinimumSize(new java.awt.Dimension(583, 321));

        panelUI.setBackground(new java.awt.Color(255, 255, 255));
        panelUI.setMinimumSize(new java.awt.Dimension(583, 321));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        btn_plaz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconPlaz.png"))); // NOI18N
        btn_plaz.setOpaque(true);
        btn_plaz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_plazMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_plazMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_plazMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_plazMouseReleased(evt);
            }
        });

        btn_arc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconLink.png"))); // NOI18N
        btn_arc.setOpaque(true);
        btn_arc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_arcMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_arcMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_arcMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_arcMouseReleased(evt);
            }
        });

        btn_help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconHelp.png"))); // NOI18N
        btn_help.setOpaque(true);
        btn_help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_helpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_helpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_helpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_helpMouseReleased(evt);
            }
        });

        btn_mouse.setBackground(new java.awt.Color(97, 97, 97));
        btn_mouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconPunt.png"))); // NOI18N
        btn_mouse.setOpaque(true);
        btn_mouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mouseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mouseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_mouseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_mouseMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_plaz)
                    .addComponent(btn_arc)
                    .addComponent(btn_help)
                    .addComponent(btn_mouse))
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_mouse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_plaz)
                .addGap(2, 2, 2)
                .addComponent(btn_arc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(btn_help)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout panelScreenLayout = new javax.swing.GroupLayout(panelScreen);
        panelScreen.setLayout(panelScreenLayout);
        panelScreenLayout.setHorizontalGroup(
            panelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        panelScreenLayout.setVerticalGroup(
            panelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelUILayout = new javax.swing.GroupLayout(panelUI);
        panelUI.setLayout(panelUILayout);
        panelUILayout.setHorizontalGroup(
            panelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUILayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        panelUILayout.setVerticalGroup(
            panelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelUILayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout P1Layout = new javax.swing.GroupLayout(P1);
        P1.setLayout(P1Layout);
        P1Layout.setHorizontalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        P1Layout.setVerticalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(897, 500));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        Principal.setMinimumSize(new java.awt.Dimension(583, 321));
        Principal.setPreferredSize(new java.awt.Dimension(583, 321));

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mouseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mouseMouseEntered
        if(!this.btn_actualClick.equals(btn_mouse.getName())){
            btn_mouse.setBackground(btn_entered);
        }
    }//GEN-LAST:event_btn_mouseMouseEntered

    private void btn_mouseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mouseMouseExited
        if(!this.btn_actualClick.equals(btn_mouse.getName())){
            btn_mouse.setBackground(btn_actual);
        }
    }//GEN-LAST:event_btn_mouseMouseExited

    private void btn_mouseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mouseMousePressed
        btn_mouse.setBackground(btn_pressed); 
    }//GEN-LAST:event_btn_mouseMousePressed

    private void btn_plazMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plazMouseEntered
        if(!this.btn_actualClick.equals(btn_plaz.getName())){
            btn_plaz.setBackground(btn_entered);
        }
    }//GEN-LAST:event_btn_plazMouseEntered

    private void btn_plazMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plazMouseExited
        if(!this.btn_actualClick.equals(btn_plaz.getName())){
            btn_plaz.setBackground(btn_actual);
        }
    }//GEN-LAST:event_btn_plazMouseExited

    private void btn_plazMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plazMousePressed
        btn_plaz.setBackground(btn_pressed);
    }//GEN-LAST:event_btn_plazMousePressed

    private void btn_arcMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_arcMouseEntered
        if(!this.btn_actualClick.equals(btn_arc.getName())){
            btn_arc.setBackground(btn_entered);
        }
    }//GEN-LAST:event_btn_arcMouseEntered

    private void btn_arcMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_arcMouseExited
        if(!this.btn_actualClick.equals(btn_arc.getName())){
            btn_arc.setBackground(btn_actual);
        }
    }//GEN-LAST:event_btn_arcMouseExited

    private void btn_arcMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_arcMousePressed
        btn_arc.setBackground(btn_pressed);
    }//GEN-LAST:event_btn_arcMousePressed

    private void btn_plaz1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plaz1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_plaz1MouseEntered

    private void btn_plaz1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plaz1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_plaz1MouseExited

    private void btn_plaz1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plaz1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_plaz1MousePressed

    private void btn_config1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_config1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_config1MouseEntered

    private void btn_config1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_config1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_config1MouseExited

    private void btn_config1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_config1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_config1MousePressed

    private void btn_arc1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_arc1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_arc1MouseEntered

    private void btn_arc1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_arc1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_arc1MouseExited

    private void btn_arc1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_arc1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_arc1MousePressed

    private void bn_drop2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_drop2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bn_drop2MouseEntered

    private void bn_drop2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_drop2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_bn_drop2MouseExited

    private void bn_drop2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_drop2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bn_drop2MousePressed

    private void btn_help1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_help1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_help1MouseEntered

    private void btn_help1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_help1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_help1MouseExited

    private void btn_help1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_help1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_help1MousePressed

    private void btn_mouse1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mouse1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mouse1MouseEntered

    private void btn_mouse1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mouse1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mouse1MouseExited

    private void btn_mouse1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mouse1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mouse1MousePressed

    private void bn_drop3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_drop3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bn_drop3MouseEntered

    private void bn_drop3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_drop3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_bn_drop3MouseExited

    private void bn_drop3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bn_drop3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bn_drop3MousePressed

    private void btn_mouseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mouseMouseReleased
        this.actionID=1;
        btn_mouse.setBackground(btn_released);
        btn_actualClick=btn_mouse.getName();
        restartLabels();
    }//GEN-LAST:event_btn_mouseMouseReleased

    private void btn_plazMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_plazMouseReleased
        this.actionID=2;
        btn_plaz.setBackground(btn_released);
        btn_actualClick=btn_plaz.getName();
        restartLabels();
    }//GEN-LAST:event_btn_plazMouseReleased

    private void btn_arcMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_arcMouseReleased
        this.actionID=4;
        btn_arc.setBackground(btn_released);
        btn_actualClick=btn_arc.getName();
        restartLabels();
    }//GEN-LAST:event_btn_arcMouseReleased

    private void btn_helpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_helpMouseReleased
        this.actionID=6;
        //btn_help.setBackground(btn_released);
        btn_actualClick=btn_help.getName();
        restartLabels();
        opRun.clearList();
        for(Ciudad c:Collections.list(tPanel.grafo.getCiudades())){
            opRun.addDestino(c.getID(),c.getNombre());
            opRun.addOrigen(c.getID(),c.getNombre());
        }
        opRun.setVisible(true);
        int idInit=opRun.getOrigen(),idFin=opRun.getDestino();
        ArrayList<Nodo> ruta=busq.getSolucion(idInit, idFin);
        if(ruta!=null){
            for(Nodo nod:ruta){
                System.out.println("Init "+tPanel.grafo.getCiudad(nod.getIDAnt()).getNombre()+" luego"+tPanel.grafo.getCiudad(nod.getID()).getNombre()+" con G"+(int)nod.getG()+" y H"+(int)nod.getH());
            }
        }
    }//GEN-LAST:event_btn_helpMouseReleased

    private void btn_helpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_helpMousePressed
        btn_help.setBackground(btn_pressed);
    }//GEN-LAST:event_btn_helpMousePressed

    private void btn_helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_helpMouseExited
        if(!this.btn_actualClick.equals(btn_help.getName())){
            btn_help.setBackground(btn_actual);
        }
    }//GEN-LAST:event_btn_helpMouseExited

    private void btn_helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_helpMouseEntered
        if(!this.btn_actualClick.equals(btn_help.getName())){
            btn_help.setBackground(btn_entered);
        }
    }//GEN-LAST:event_btn_helpMouseEntered

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel P1;
    private javax.swing.JPanel P2;
    private javax.swing.JPanel Principal;
    private javax.swing.JLabel bn_drop2;
    private javax.swing.JLabel bn_drop3;
    private javax.swing.JLabel btn_arc;
    private javax.swing.JLabel btn_arc1;
    private javax.swing.JLabel btn_config1;
    private javax.swing.JLabel btn_help;
    private javax.swing.JLabel btn_help1;
    private javax.swing.JLabel btn_mouse;
    private javax.swing.JLabel btn_mouse1;
    private javax.swing.JLabel btn_plaz;
    private javax.swing.JLabel btn_plaz1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel panelScreen;
    private javax.swing.JPanel panelSimul;
    private javax.swing.JPanel panelUI;
    private javax.swing.JTextArea salida;
    // End of variables declaration//GEN-END:variables
}
