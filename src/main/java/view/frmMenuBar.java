/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Telecomunicaciones.CtrTelecomunicaciones;
import controller.Usuarios.CtrUsuario;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author RIBZ
 */
public class FrmMenuBar extends javax.swing.JFrame {

     private CardLayout cardLayout;  // Declaración a nivel de clase

    public FrmMenuBar() {
        initComponents();
            this.setSize(1280,720);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializacionItemsMenuBar();
        cardLayout = (CardLayout) PanelPrincipal.getLayout();
        new CtrUsuario(this);
        new CtrTelecomunicaciones(this);
    }

    private void inicializacionItemsMenuBar() {
       
        
        jMenuUsuario = new javax.swing.JMenu();        
        jMenuTelecomunicaciones = new javax.swing.JMenu();
        jMenuPagos = new javax.swing.JMenu();
        jMenuInmuebles = new javax.swing.JMenu();
        jMenuEspaciosComunes = new javax.swing.JMenu();
        jMenuCheckIn = new javax.swing.JMenu();
        
        jMenuIUGuardar = new javax.swing.JMenuItem();
        jMenuIUBuscar = new javax.swing.JMenuItem();
        jMenuIUModificar = new javax.swing.JMenuItem();
        jMenuIUEliminar = new javax.swing.JMenuItem();
        
        jMenuITGuardar = new javax.swing.JMenuItem();
        jMenuITBuscar = new javax.swing.JMenuItem();
        jMenuITModificar = new javax.swing.JMenuItem();
        jMenuITEliminar = new javax.swing.JMenuItem();

        jMenuIPGuardar = new javax.swing.JMenuItem();
        jMenuIPBuscar = new javax.swing.JMenuItem();
        jMenuIPModificar = new javax.swing.JMenuItem();
        jMenuIPEliminar = new javax.swing.JMenuItem();

        jMenuIIGuardar = new javax.swing.JMenuItem();
        jMenuIIBuscar = new javax.swing.JMenuItem();
        jMenuIIModificar = new javax.swing.JMenuItem();
        jMenuIIEliminar = new javax.swing.JMenuItem();

        jMenuIECGuardar = new javax.swing.JMenuItem();
        jMenuIECBuscar = new javax.swing.JMenuItem();
        jMenuIECModificar = new javax.swing.JMenuItem();
        jMenuIECEliminar = new javax.swing.JMenuItem();

        jMenuICIGuardar = new javax.swing.JMenuItem();
        jMenuICIBuscar = new javax.swing.JMenuItem();
        jMenuICIModificar = new javax.swing.JMenuItem();
        jMenuICIEliminar = new javax.swing.JMenuItem();

        
        jMenuUsuario.setText("Usuario");
        jMenuUsuario.setIcon(obtenerImagen(logo_Usuario));
        jMenuUsuario.setOpaque(true);
        jMenuUsuario.setBackground(mColorFondoMenu);
        jMenuUsuario.setForeground(Color.WHITE);
        jMenuUsuario.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        //MenuItems     
        jMenuIUGuardar.setText("Guardar");
        jMenuIUBuscar.setText("Buscar");
        jMenuIUModificar.setText("Modificar");
        jMenuIUEliminar.setText("Eliminar");
        
        //MenuTelecomunicaciones
        jMenuTelecomunicaciones.setText("Telecomunicaciones");
        jMenuTelecomunicaciones.setIcon(obtenerImagen(logo_Usuario));
        jMenuTelecomunicaciones.setOpaque(true);
        jMenuTelecomunicaciones.setBackground(mColorFondoMenu);
        jMenuTelecomunicaciones.setForeground(Color.WHITE);
        jMenuTelecomunicaciones.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
       
        jMenuITGuardar.setText("Guardar");
        jMenuITBuscar.setText("Buscar");
        jMenuITModificar.setText("Modificar");
        jMenuITEliminar.setText("Eliminar");
        
        //MenuPagos
        jMenuPagos.setText("Pagos");
        jMenuPagos.setIcon(obtenerImagen(logo_Usuario));
        jMenuPagos.setOpaque(true);
        jMenuPagos.setBackground(mColorFondoMenu);
        jMenuPagos.setForeground(Color.WHITE);
        jMenuPagos.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuIPGuardar.setText("Guardar");
        jMenuIPBuscar.setText("Buscar");
        jMenuIPModificar.setText("Modificar");
        jMenuIPEliminar.setText("Eliminar");
        
        //MenuInmuebles
        jMenuInmuebles.setText("Inmuebles");
        jMenuInmuebles.setIcon(obtenerImagen(logo_Usuario));
        jMenuInmuebles.setOpaque(true);
        jMenuInmuebles.setBackground(mColorFondoMenu);
        jMenuInmuebles.setForeground(Color.WHITE);
        jMenuInmuebles.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuIIGuardar.setText("Guardar");
        jMenuIIBuscar.setText("Buscar");
        jMenuIIModificar.setText("Modificar");
        jMenuIIEliminar.setText("Eliminar");
        
        //MenuEspaciosComunes
        jMenuEspaciosComunes.setText("Espacios Comunes");
        jMenuEspaciosComunes.setIcon(obtenerImagen(logo_Usuario));
        jMenuEspaciosComunes.setOpaque(true);
        jMenuEspaciosComunes.setBackground(mColorFondoMenu);
        jMenuEspaciosComunes.setForeground(Color.WHITE);
        jMenuEspaciosComunes.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuIECGuardar.setText("Guardar");
        jMenuIECBuscar.setText("Buscar");
        jMenuIECModificar.setText("Modificar");
        jMenuIECEliminar.setText("Eliminar");
        
        //MenuEspaciosComunes
        jMenuCheckIn.setText("Check-In");
        jMenuCheckIn.setIcon(obtenerImagen(logo_Usuario));
        jMenuCheckIn.setOpaque(true);
        jMenuCheckIn.setBackground(mColorFondoMenu);
        jMenuCheckIn.setForeground(Color.WHITE);
        jMenuCheckIn.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuICIGuardar.setText("Guardar");
        jMenuICIBuscar.setText("Buscar");
        jMenuICIModificar.setText("Modificar");
        jMenuICIEliminar.setText("Eliminar");
        
        //Botones
        
        //Usuarios
        jMenuUsuario.addActionListener((ActionEvent e) -> {
            cambiarPanel("Usuarios");
        });
        
        jMenuUsuario.add(jMenuIUGuardar);
        jMenuUsuario.add(jMenuIUBuscar);
        jMenuUsuario.add(jMenuIUModificar);
        jMenuUsuario.add(jMenuIUEliminar);
        
        //Telecomunicaciones
        jMenuTelecomunicaciones.addActionListener((ActionEvent e) -> {
            cambiarPanel("Telecomunicaciones");
        });
        
        jMenuTelecomunicaciones.add(jMenuITGuardar);
        jMenuTelecomunicaciones.add(jMenuITBuscar);
        jMenuTelecomunicaciones.add(jMenuITModificar);
        jMenuTelecomunicaciones.add(jMenuITEliminar);
        
        //Pagos
        jMenuPagos.addActionListener((ActionEvent e) -> {
            cambiarPanel("Pagos");
        });
        
        jMenuPagos.add(jMenuIPGuardar);
        jMenuPagos.add(jMenuIPBuscar);
        jMenuPagos.add(jMenuIPModificar);
        jMenuPagos.add(jMenuIPEliminar);
        
        //Inmuebles
        jMenuInmuebles.addActionListener((ActionEvent e) -> {
            cambiarPanel("Inmuebles");
        });
        
        jMenuInmuebles.add(jMenuIIGuardar); 
        jMenuInmuebles.add(jMenuIIBuscar); 
        jMenuInmuebles.add(jMenuIIModificar); 
        jMenuInmuebles.add(jMenuIIEliminar); 
        
        //Espacios Comunes
        jMenuEspaciosComunes.addActionListener((ActionEvent e) -> {
            cambiarPanel("Espacios Comunes");
        });
        
        jMenuEspaciosComunes.add(jMenuIECGuardar); 
        jMenuEspaciosComunes.add(jMenuIECBuscar); 
        jMenuEspaciosComunes.add(jMenuIECModificar); 
        jMenuEspaciosComunes.add(jMenuIECEliminar); 
        
        //Check-In
        jMenuCheckIn.addActionListener((ActionEvent e) -> {
            cambiarPanel("Check In"); 
        });
        
        jMenuCheckIn.add(jMenuICIGuardar); 
        jMenuCheckIn.add(jMenuICIBuscar); 
        jMenuCheckIn.add(jMenuICIModificar); 
        jMenuCheckIn.add(jMenuICIEliminar); 
       
        //Modulos en el Menu Bar
        mbMenuBar.add(jMenuUsuario);
        mbMenuBar.add(jMenuTelecomunicaciones);
        mbMenuBar.add(jMenuPagos);
        mbMenuBar.add(jMenuInmuebles);
        mbMenuBar.add(jMenuEspaciosComunes);
        mbMenuBar.add(jMenuCheckIn);
        
        mbMenuBar.setPreferredSize(new java.awt.Dimension(this.getWidth(), 50)); // Ancho igual al frame y altura 50
        // Crear una nueva fuente
        /*java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.BOLD, 16); // Tamaño de fuente 14 y estilo negrita

        // Establecer la fuente para cada JMenu
        jMenuUsuario.setFont(font);
        java.awt.Font font1 = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 16); // Tamaño de fuente 14 y estilo negrita
        jMenuIUGuardar.setFont(font1);
        jMenuIUBuscar.setFont(font1);
        jMenuIUModificar.setFont(font1);
        jMenuIUEliminar.setFont(font1);*/

    }

    private void cambiarPanel(String Panel) {
        cardLayout.show(PanelPrincipal, Panel);
    }

    private Icon obtenerImagen(String ruta){
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(30, 30, 0));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelUsuarios = new javax.swing.JPanel();
        PanelGuardar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanerBuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelModificar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PanelEliminar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PanelTelecomunicaciones = new javax.swing.JPanel();
        PanelGuardarT = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        PanelBuscarT = new javax.swing.JPanel();
        PanelModificarT = new javax.swing.JPanel();
        PanelEliminarT = new javax.swing.JPanel();
        PanelPagos = new javax.swing.JPanel();
        PanelGuardarP = new javax.swing.JPanel();
        PanelBuscarP = new javax.swing.JPanel();
        PanelModificarP = new javax.swing.JPanel();
        PanelEliminarP = new javax.swing.JPanel();
        PanelInmuebles = new javax.swing.JPanel();
        PanelGuardarI = new javax.swing.JPanel();
        PanelBuscarI = new javax.swing.JPanel();
        PanelModificarI = new javax.swing.JPanel();
        PanelEliminarI = new javax.swing.JPanel();
        mbMenuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(128, 105, 70));
        PanelPrincipal.setLayout(new java.awt.CardLayout());

        PanelUsuarios.setBackground(new java.awt.Color(80, 200, 120));
        PanelUsuarios.setLayout(null);
        PanelPrincipal.add(PanelUsuarios, "card2");

        PanelGuardar.setBackground(new java.awt.Color(89, 116, 112));
        PanelGuardar.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Source Code Pro Light", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Guardar ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelGuardar.add(jLabel1);
        jLabel1.setBounds(440, 270, 390, 80);

        PanelPrincipal.add(PanelGuardar, "card3");

        PanerBuscar.setBackground(new java.awt.Color(85, 107, 47));
        PanerBuscar.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Source Code Pro Light", 0, 48)); // NOI18N
        jLabel2.setText("Buscar");
        PanerBuscar.add(jLabel2);
        jLabel2.setBounds(520, 240, 320, 190);

        PanelPrincipal.add(PanerBuscar, "card2");

        PanelModificar.setBackground(new java.awt.Color(96, 128, 117));
        PanelModificar.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Source Code Pro ExtraLight", 0, 48)); // NOI18N
        jLabel3.setText("Modificar");
        PanelModificar.add(jLabel3);
        jLabel3.setBounds(480, 240, 310, 150);

        PanelPrincipal.add(PanelModificar, "card5");

        PanelEliminar.setBackground(new java.awt.Color(24, 60, 34));
        PanelEliminar.setLayout(null);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Source Code Pro ExtraLight", 0, 48)); // NOI18N
        jLabel4.setText("Eliminar");
        PanelEliminar.add(jLabel4);
        jLabel4.setBounds(530, 260, 390, 160);

        PanelPrincipal.add(PanelEliminar, "card6");

        PanelTelecomunicaciones.setBackground(new java.awt.Color(0, 153, 153));
        PanelTelecomunicaciones.setLayout(null);
        PanelPrincipal.add(PanelTelecomunicaciones, "card7");

        PanelGuardarT.setBackground(new java.awt.Color(51, 255, 51));
        PanelGuardarT.setLayout(null);

        btnGuardar.setText("jButton1");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PanelGuardarT.add(btnGuardar);
        btnGuardar.setBounds(540, 120, 75, 23);

        PanelPrincipal.add(PanelGuardarT, "card8");
        PanelPrincipal.add(PanelBuscarT, "card9");
        PanelPrincipal.add(PanelModificarT, "card10");
        PanelPrincipal.add(PanelEliminarT, "card11");
        PanelPrincipal.add(PanelPagos, "card12");
        PanelPrincipal.add(PanelGuardarP, "card13");
        PanelPrincipal.add(PanelBuscarP, "card14");
        PanelPrincipal.add(PanelModificarP, "card15");
        PanelPrincipal.add(PanelEliminarP, "card16");
        PanelPrincipal.add(PanelInmuebles, "card17");
        PanelPrincipal.add(PanelGuardarI, "card18");
        PanelPrincipal.add(PanelBuscarI, "card19");
        PanelPrincipal.add(PanelModificarI, "card20");
        PanelPrincipal.add(PanelEliminarI, "card21");

        getContentPane().add(PanelPrincipal, java.awt.BorderLayout.CENTER);
        setJMenuBar(mbMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmMenuBar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBuscarI;
    private javax.swing.JPanel PanelBuscarP;
    private javax.swing.JPanel PanelBuscarT;
    private javax.swing.JPanel PanelEliminar;
    private javax.swing.JPanel PanelEliminarI;
    private javax.swing.JPanel PanelEliminarP;
    private javax.swing.JPanel PanelEliminarT;
    public javax.swing.JPanel PanelGuardar;
    private javax.swing.JPanel PanelGuardarI;
    private javax.swing.JPanel PanelGuardarP;
    private javax.swing.JPanel PanelGuardarT;
    private javax.swing.JPanel PanelInmuebles;
    private javax.swing.JPanel PanelModificar;
    private javax.swing.JPanel PanelModificarI;
    private javax.swing.JPanel PanelModificarP;
    private javax.swing.JPanel PanelModificarT;
    private javax.swing.JPanel PanelPagos;
    public javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTelecomunicaciones;
    public javax.swing.JPanel PanelUsuarios;
    private javax.swing.JPanel PanerBuscar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar mbMenuBar;
    // End of variables declaration//GEN-END:variables
 // Declaración de los menús
    public javax.swing.JMenu jMenuUsuario;
    public javax.swing.JMenuItem jMenuIUGuardar;
    public javax.swing.JMenuItem jMenuIUBuscar;
    public javax.swing.JMenuItem jMenuIUModificar;
    public javax.swing.JMenuItem jMenuIUEliminar;
    
    public javax.swing.JMenu jMenuTelecomunicaciones;
    public javax.swing.JMenuItem jMenuITGuardar;
    public javax.swing.JMenuItem jMenuITEliminar;
    public javax.swing.JMenuItem jMenuITModificar;
    public javax.swing.JMenuItem jMenuITBuscar;
    
    public javax.swing.JMenu jMenuPagos;
    public javax.swing.JMenuItem jMenuIPGuardar;
    public javax.swing.JMenuItem jMenuIPEliminar;
    public javax.swing.JMenuItem jMenuIPModificar;
    public javax.swing.JMenuItem jMenuIPBuscar;
    
    public javax.swing.JMenu jMenuInmuebles;
    public javax.swing.JMenuItem jMenuIIGuardar;
    public javax.swing.JMenuItem jMenuIIBuscar;
    public javax.swing.JMenuItem jMenuIIEliminar;
    public javax.swing.JMenuItem jMenuIIModificar;

   
    public javax.swing.JMenu jMenuEspaciosComunes;
    public javax.swing.JMenuItem jMenuIECGuardar;
    public javax.swing.JMenuItem jMenuIECBuscar;
    public javax.swing.JMenuItem jMenuIECEliminar;
    public javax.swing.JMenuItem jMenuIECModificar;
   
    public javax.swing.JMenu jMenuCheckIn;
    public javax.swing.JMenuItem jMenuICIGuardar;
    public javax.swing.JMenuItem jMenuICIBuscar;
    public javax.swing.JMenuItem jMenuICIEliminar;
    public javax.swing.JMenuItem jMenuICIModificar;
    
    public String logo_Usuario= "/imagenes/clientes.png";

   
    public Color mColorFondoMenu= new Color(47, 79, 79);


    // End of variables declaration         
}