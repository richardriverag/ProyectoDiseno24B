/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CheckIn.CtrCheckIn;
import controller.EspaciosComunes.CtrEspaciosC;
import controller.Inmuebles.CtrInmuebles;
import controller.Pagos.CtrPagos;
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
        new CtrInmuebles(this);
        new CtrPagos(this);
        new CtrEspaciosC(this);
        new CtrCheckIn(this);
    }

    private void inicializacionItemsMenuBar() {
       
        
        jMenuUsuario = new javax.swing.JMenu();        
        jMenuTelecomunicaciones = new javax.swing.JMenu();
        jMenuPagos = new javax.swing.JMenu();
        jMenuInmuebles = new javax.swing.JMenu();
        jMenuEspaciosComunes = new javax.swing.JMenu();
        jMenuCheckIn = new javax.swing.JMenu();
        
        jMenuIUsuarios1 = new javax.swing.JMenuItem();
        jMenuIUsuarios2 = new javax.swing.JMenuItem();
        jMenuIUsuarios3 = new javax.swing.JMenuItem();
        jMenuIUsuarios4 = new javax.swing.JMenuItem();
        
        jMenuIT1 = new javax.swing.JMenuItem();
        jMenuIT2 = new javax.swing.JMenuItem();
        jMenuITModificar = new javax.swing.JMenuItem();
        jMenuITEliminar = new javax.swing.JMenuItem();

        jMenuIP1 = new javax.swing.JMenuItem();
        jMenuIP2 = new javax.swing.JMenuItem();
        jMenuIPModificar = new javax.swing.JMenuItem();
        jMenuIPEliminar = new javax.swing.JMenuItem();

        jMenuII1 = new javax.swing.JMenuItem();
        jMenuII2 = new javax.swing.JMenuItem();
        jMenuIIModificar = new javax.swing.JMenuItem();
        jMenuIIEliminar = new javax.swing.JMenuItem();

        jMenuIEC1 = new javax.swing.JMenuItem();
       jMenuIEC2 = new javax.swing.JMenuItem();
        jMenuIECModificar = new javax.swing.JMenuItem();
        jMenuIECEliminar = new javax.swing.JMenuItem();

        jMenuICI1 = new javax.swing.JMenuItem();
        jMenuICI2 = new javax.swing.JMenuItem();
        jMenuICIModificar = new javax.swing.JMenuItem();
        jMenuICIEliminar = new javax.swing.JMenuItem();

        
        jMenuUsuario.setText("Usuario");
        jMenuUsuario.setIcon(obtenerImagen(logo_Usuario));
        jMenuUsuario.setOpaque(true);
        jMenuUsuario.setBackground(mColorFondoMenu);
        jMenuUsuario.setForeground(Color.WHITE);
        jMenuUsuario.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        //MenuItems     
        jMenuIUsuarios1.setText("MenuItem1");
        jMenuIUsuarios2.setText("MenuItem2");
        jMenuIUsuarios3.setText("MenuItem3");
        jMenuIUsuarios4.setText("MenuItem4");
        
        //MenuTelecomunicaciones
        jMenuTelecomunicaciones.setText("Telecomunicaciones");
        jMenuTelecomunicaciones.setIcon(obtenerImagen(logo_Usuario));
        jMenuTelecomunicaciones.setOpaque(true);
        jMenuTelecomunicaciones.setBackground(mColorFondoMenu);
        jMenuTelecomunicaciones.setForeground(Color.WHITE);
        jMenuTelecomunicaciones.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
       
        jMenuIT1.setText("MenuItem1");
        jMenuIT2.setText("MenuItem2");
        jMenuITModificar.setText("MenuItem3");
        jMenuITEliminar.setText("MenuItem4");
        
        //MenuPagos
        jMenuPagos.setText("Pagos");
        jMenuPagos.setIcon(obtenerImagen(logo_Usuario));
        jMenuPagos.setOpaque(true);
        jMenuPagos.setBackground(mColorFondoMenu);
        jMenuPagos.setForeground(Color.WHITE);
        jMenuPagos.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuIP1.setText("MenuItem1");
        jMenuIP2.setText("MenuItem2");
        jMenuIPModificar.setText("MenuItem3");
        jMenuIPEliminar.setText("MenuItem4");
        
        //MenuInmuebles
        jMenuInmuebles.setText("Inmuebles");
        jMenuInmuebles.setIcon(obtenerImagen(logo_Usuario));
        jMenuInmuebles.setOpaque(true);
        jMenuInmuebles.setBackground(mColorFondoMenu);
        jMenuInmuebles.setForeground(Color.WHITE);
        jMenuInmuebles.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuII1.setText("MenuItem1");
        jMenuII2.setText("MenuItem2");
        jMenuIIModificar.setText("MenuItem3");
        jMenuIIEliminar.setText("MenuItem4");
        
        //MenuEspaciosComunes
        jMenuEspaciosComunes.setText("Espacios Comunes");
        jMenuEspaciosComunes.setIcon(obtenerImagen(logo_Usuario));
        jMenuEspaciosComunes.setOpaque(true);
        jMenuEspaciosComunes.setBackground(mColorFondoMenu);
        jMenuEspaciosComunes.setForeground(Color.WHITE);
        jMenuEspaciosComunes.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuIEC1.setText("MenuItem1");
       jMenuIEC2.setText("MenuItem2");
        jMenuIECModificar.setText("MenuItem3");
        jMenuIECEliminar.setText("MenuItem4");
        
        //MenuEspaciosComunes
        jMenuCheckIn.setText("Check-In");
        jMenuCheckIn.setIcon(obtenerImagen(logo_Usuario));
        jMenuCheckIn.setOpaque(true);
        jMenuCheckIn.setBackground(mColorFondoMenu);
        jMenuCheckIn.setForeground(Color.WHITE);
        jMenuCheckIn.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuICI1.setText("MenuItem1");
        jMenuICI2.setText("MenuItem2");
        jMenuICIModificar.setText("MenuItem3");
        jMenuICIEliminar.setText("MenuItem4");
        
        //Botones
        
        //Usuarios
        jMenuUsuario.addActionListener((ActionEvent e) -> {
            cambiarPanel("Usuarios");
        });
        
        jMenuUsuario.add(jMenuIUsuarios1);
        jMenuUsuario.add(jMenuIUsuarios2);
        //jMenuUsuario.add(jMenuIUsuarios3);
        //jMenuUsuario.add(jMenuIUsuarios4);
        
        //Telecomunicaciones
        jMenuTelecomunicaciones.addActionListener((ActionEvent e) -> {
            cambiarPanel("Telecomunicaciones");
        });
        
        jMenuTelecomunicaciones.add(jMenuIT1);
        jMenuTelecomunicaciones.add(jMenuIT2);
        //jMenuTelecomunicaciones.add(jMenuITModificar);
        //jMenuTelecomunicaciones.add(jMenuITEliminar);
        
        //Pagos
        jMenuPagos.addActionListener((ActionEvent e) -> {
            cambiarPanel("Pagos");
        });
        
        jMenuPagos.add(jMenuIP1);
        jMenuPagos.add(jMenuIP2);
        //jMenuPagos.add(jMenuIPModificar);
        //jMenuPagos.add(jMenuIPEliminar);
        
        //Inmuebles
        jMenuInmuebles.addActionListener((ActionEvent e) -> {
            cambiarPanel("Inmuebles");
        });
        
        jMenuInmuebles.add(jMenuII1); 
        jMenuInmuebles.add(jMenuII2); 
        //jMenuInmuebles.add(jMenuIIModificar); 
        //jMenuInmuebles.add(jMenuIIEliminar); 
        
        //Espacios Comunes
        jMenuEspaciosComunes.addActionListener((ActionEvent e) -> {
            cambiarPanel("Espacios Comunes");
        });
        
        jMenuEspaciosComunes.add(jMenuIEC1); 
        jMenuEspaciosComunes.add(jMenuIEC2); 
        //jMenuEspaciosComunes.add(jMenuIECModificar); 
        //jMenuEspaciosComunes.add(jMenuIECEliminar); 
        
        //Check-In
        jMenuCheckIn.addActionListener((ActionEvent e) -> {
            cambiarPanel("Check In"); 
        });
        
        jMenuCheckIn.add(jMenuICI1); 
        jMenuCheckIn.add(jMenuICI2); 
        //jMenuCheckIn.add(jMenuICIModificar); 
        //jMenuCheckIn.add(jMenuICIEliminar); 
       
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
        jMenuIUsuarios1.setFont(font1);
        jMenuIUsuarios2.setFont(font1);
        jMenuIUsuarios3.setFont(font1);
        jMenuIUsuarios4.setFont(font1);*/

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
        PanelT1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        PanelT2 = new javax.swing.JPanel();
        PanelPagos = new javax.swing.JPanel();
        PanelP1 = new javax.swing.JPanel();
        PanelP2 = new javax.swing.JPanel();
        PanelInmuebles = new javax.swing.JPanel();
        PanelI1 = new javax.swing.JPanel();
        PanelI2 = new javax.swing.JPanel();
        PanelEspaciosComunes = new javax.swing.JPanel();
        PanelEC1 = new javax.swing.JPanel();
        PanelEC2 = new javax.swing.JPanel();
        PanelCheckIn = new javax.swing.JPanel();
        PanelCheckIn1 = new javax.swing.JPanel();
        PanelCheckIn2 = new javax.swing.JPanel();
        mbMenuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(128, 105, 70));
        PanelPrincipal.setLayout(new java.awt.CardLayout());

        PanelUsuarios.setBackground(new java.awt.Color(80, 200, 120));
        PanelPrincipal.add(PanelUsuarios, "card2");

        PanelGuardar.setBackground(new java.awt.Color(89, 116, 112));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Source Code Pro Light", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Guardar ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelGuardar.add(jLabel1);

        PanelPrincipal.add(PanelGuardar, "card3");

        PanerBuscar.setBackground(new java.awt.Color(85, 107, 47));

        jLabel2.setFont(new java.awt.Font("Source Code Pro Light", 0, 48)); // NOI18N
        jLabel2.setText("Buscar");
        PanerBuscar.add(jLabel2);

        PanelPrincipal.add(PanerBuscar, "card2");

        PanelModificar.setBackground(new java.awt.Color(96, 128, 117));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Source Code Pro ExtraLight", 0, 48)); // NOI18N
        jLabel3.setText("Modificar");
        PanelModificar.add(jLabel3);

        PanelPrincipal.add(PanelModificar, "card5");

        PanelEliminar.setBackground(new java.awt.Color(24, 60, 34));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Source Code Pro ExtraLight", 0, 48)); // NOI18N
        jLabel4.setText("Eliminar");
        PanelEliminar.add(jLabel4);

        PanelPrincipal.add(PanelEliminar, "card6");

        PanelTelecomunicaciones.setBackground(new java.awt.Color(0, 153, 153));
        PanelPrincipal.add(PanelTelecomunicaciones, "card7");

        PanelT1.setBackground(new java.awt.Color(51, 255, 51));

        btnGuardar.setText("jButton1");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PanelT1.add(btnGuardar);

        PanelPrincipal.add(PanelT1, "card8");
        PanelPrincipal.add(PanelT2, "card9");
        PanelPrincipal.add(PanelPagos, "card12");
        PanelPrincipal.add(PanelP1, "card13");

        PanelP2.setBackground(new java.awt.Color(204, 255, 204));
        PanelPrincipal.add(PanelP2, "card14");

        PanelInmuebles.setBackground(new java.awt.Color(0, 153, 153));
        PanelPrincipal.add(PanelInmuebles, "card17");

        PanelI1.setBackground(new java.awt.Color(255, 153, 153));
        PanelPrincipal.add(PanelI1, "panel1Inmuebles");
        PanelPrincipal.add(PanelI2, "card19");
        PanelPrincipal.add(PanelEspaciosComunes, "card22");
        PanelPrincipal.add(PanelEC1, "card23");
        PanelPrincipal.add(PanelEC2, "card24");
        PanelPrincipal.add(PanelCheckIn, "card25");
        PanelPrincipal.add(PanelCheckIn1, "card26");
        PanelPrincipal.add(PanelCheckIn2, "card27");

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
    private javax.swing.JPanel PanelCheckIn;
    private javax.swing.JPanel PanelCheckIn1;
    private javax.swing.JPanel PanelCheckIn2;
    private javax.swing.JPanel PanelEC1;
    private javax.swing.JPanel PanelEC2;
    private javax.swing.JPanel PanelEliminar;
    private javax.swing.JPanel PanelEspaciosComunes;
    public javax.swing.JPanel PanelGuardar;
    private javax.swing.JPanel PanelI1;
    private javax.swing.JPanel PanelI2;
    private javax.swing.JPanel PanelInmuebles;
    private javax.swing.JPanel PanelModificar;
    private javax.swing.JPanel PanelP1;
    private javax.swing.JPanel PanelP2;
    private javax.swing.JPanel PanelPagos;
    public javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelT1;
    private javax.swing.JPanel PanelT2;
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
    public javax.swing.JMenuItem jMenuIUsuarios1;
    public javax.swing.JMenuItem jMenuIUsuarios2;
    public javax.swing.JMenuItem jMenuIUsuarios3;
    public javax.swing.JMenuItem jMenuIUsuarios4;
    
    public javax.swing.JMenu jMenuTelecomunicaciones;
    public javax.swing.JMenuItem jMenuIT1;
    public javax.swing.JMenuItem jMenuITEliminar;
    public javax.swing.JMenuItem jMenuITModificar;
    public javax.swing.JMenuItem jMenuIT2;
    
    public javax.swing.JMenu jMenuPagos;
    public javax.swing.JMenuItem jMenuIP1;
    public javax.swing.JMenuItem jMenuIPEliminar;
    public javax.swing.JMenuItem jMenuIPModificar;
    public javax.swing.JMenuItem jMenuIP2;
    
    public javax.swing.JMenu jMenuInmuebles;
    public javax.swing.JMenuItem jMenuII1;
    public javax.swing.JMenuItem jMenuII2;
    public javax.swing.JMenuItem jMenuIIEliminar;
    public javax.swing.JMenuItem jMenuIIModificar;

   
    public javax.swing.JMenu jMenuEspaciosComunes;
    public javax.swing.JMenuItem jMenuIEC1;
    public javax.swing.JMenuItem jMenuIEC2;
    public javax.swing.JMenuItem jMenuIECEliminar;
    public javax.swing.JMenuItem jMenuIECModificar;
   
    public javax.swing.JMenu jMenuCheckIn;
    public javax.swing.JMenuItem jMenuICI1;
    public javax.swing.JMenuItem jMenuICI2;
    public javax.swing.JMenuItem jMenuICIEliminar;
    public javax.swing.JMenuItem jMenuICIModificar;
    
    public String logo_Usuario= "/imagenes/clientes.png";

   
    public Color mColorFondoMenu= new Color(47, 79, 79);


    // End of variables declaration         
}