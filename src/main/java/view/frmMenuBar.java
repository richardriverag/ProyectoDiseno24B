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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Usuarios.Usuario;
import view.comunicacion.FrmMensaje;
import view.comunicacion.FrmMensajeAdmin;
import view.inmuebles.FrmPantalla;

/**
 *
 * @author RIBZ
 */
public class frmMenuBar extends javax.swing.JFrame {

     private CardLayout cardLayout;  // Declaración a nivel de clase

    public frmMenuBar() {
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

        // Instancia de los frames
        // Telecomunicaciones
        FrmMensaje frmMensaje = new FrmMensaje();
        FrmMensajeAdmin frmMensajeAdmin = new FrmMensajeAdmin();
        // FrmReporte frmReporte = new FrmReporte();
        // Inmmuebles
        FrmPantalla frmPantallaIn = new FrmPantalla();
        // Pagos
        FrmFinanzas frmFinanzas = new FrmFinanzas();
        // Espacios Comunes
        // FrmCancelarReserva frmReservaCancelada = new FrmCancelarReserva();
        // FrmReserva frmReserva = new FrmReserva();
        // Check-in
        FrmCheckIn frmCheckIn = new FrmCheckIn();

        // Configuración de los frames
        // Telecomunicaciones
        PanelT1.setLayout(new java.awt.BorderLayout());
        PanelT1.add(frmMensaje.getContentPane(), java.awt.BorderLayout.CENTER);
        PanelT1.setVisible(false);
        PanelT1.repaint();
        PanelT1.revalidate();

        PanelT2.setLayout(new java.awt.BorderLayout());
        PanelT2.add(frmMensajeAdmin.getContentPane(), java.awt.BorderLayout.CENTER);
        PanelT2.setVisible(false);
        PanelT2.repaint();
        PanelT2.revalidate();
        /*
         * PanelT3.setLayout(new java.awt.BorderLayout());
         * PanelT3.add(frmReporte.getContentPane(), java.awt.BorderLayout.CENTER);
         * PanelT3.setVisible(false);
         * PanelT3.repaint();
         * PanelT3.revalidate();
         */
        // Inmmuebles
        PanelI1.setLayout(new java.awt.BorderLayout());
        PanelI1.add(frmPantallaIn.getContentPane(), java.awt.BorderLayout.CENTER);
        PanelI1.setVisible(false);
        PanelI1.repaint();
        PanelI1.revalidate();

        // Pagos
        PanelPagos.setLayout(new java.awt.BorderLayout());
        PanelPagos.add(frmFinanzas.getContentPane(), java.awt.BorderLayout.CENTER);
        PanelPagos.setVisible(false);
        PanelPagos.repaint();
        PanelPagos.revalidate();

        // Espacios Comunes
        /*
         * PanelEC1.setLayout(new java.awt.BorderLayout());
         * PanelEC1.add(frmReserva.getContentPane(), java.awt.BorderLayout.CENTER);
         * PanelEC1.setVisible(false);
         * PanelEC1.repaint();
         * PanelEC1.revalidate();
         * 
         * PanelEC2.setLayout(new java.awt.BorderLayout());
         * PanelEC2.add(frmReservaCancelada.getContentPane(),
         * java.awt.BorderLayout.CENTER);
         * PanelEC2.setVisible(false);
         * PanelEC2.repaint();
         * PanelEC2.revalidate();
         */
        // Check-in
        PanelCheckIn1.setLayout(new java.awt.BorderLayout());
        PanelCheckIn1.add(frmCheckIn.getContentPane(), java.awt.BorderLayout.CENTER);
        PanelCheckIn1.setVisible(false);
        PanelCheckIn1.repaint();
        PanelCheckIn1.revalidate();
    }

    private void inicializacionItemsMenuBar() {
       
        
        jMenuUsuario = new javax.swing.JMenu();        
        jMenuTelecomunicaciones = new javax.swing.JMenu();
        jMenuPagos = new javax.swing.JMenu();
        jMenuInmuebles = new javax.swing.JMenu();
        jMenuEspaciosComunes = new javax.swing.JMenu();
        jMenuCheckIn = new javax.swing.JMenu();
        //jMenuConfig = new javax.swing.JMenu();
        
        jMenuIUsuarios1 = new javax.swing.JMenuItem();
        jMenuIUsuarios2 = new javax.swing.JMenuItem();
        jMenuIUsuarios3 = new javax.swing.JMenuItem();
        jMenuIUsuarios4 = new javax.swing.JMenuItem();
        
        jMenuIT1 = new javax.swing.JMenuItem();
        jMenuIT2 = new javax.swing.JMenuItem();
        jMenuITModificar = new javax.swing.JMenuItem();
        jMenuITEliminar = new javax.swing.JMenuItem();

        jMenuIPGuardar = new javax.swing.JMenuItem();
        jMenuIPBuscar = new javax.swing.JMenuItem();
        jMenuIPModificar = new javax.swing.JMenuItem();
        jMenuIPEliminar = new javax.swing.JMenuItem();
        jMenuIPsoloVer = new javax.swing.JMenuItem();
        jMenuIPpagar = new javax.swing.JMenuItem();
        
               // Se asume que comboTipoPG es el combo de la izquierda (pago/multa)
        comboTipoPG.addItemListener(e -> {
            if ("pago".equals(comboTipoPG.getSelectedItem())) {
            comboMetodoPago.setEnabled(true); // Activa el combo de métodos de pago
            txtDescripcionPG.setEnabled(false); // Activa el campo de descripción
            } else {
            comboMetodoPago.setEnabled(false); // Desactiva el combo de métodos de pago
            txtDescripcionPG.setEnabled(true); // Desactiva el campo de descripción
            }
        });

        

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
        
        //jMenuISalir = new javax.swing.JMenuItem();
        //jMenuIModoV = new javax.swing.JMenuItem();

        
        jMenuUsuario.setText("Usuario");
        jMenuUsuario.setIcon(obtenerImagen(logo_Usuario));
        jMenuUsuario.setOpaque(true);
        jMenuUsuario.setBackground(mColorFondoMenu);
        jMenuUsuario.setForeground(Color.WHITE);
        jMenuUsuario.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        //MenuItems     
        jMenuIUsuarios1.setText("Gestionar Cuentas");
        /*jMenuIUsuarios2.setText("MenuItem2");
        jMenuIUsuarios3.setText("MenuItem3");
        jMenuIUsuarios4.setText("MenuItem4");*/
        
        //MenuTelecomunicaciones
        jMenuTelecomunicaciones.setText("Telecomunicaciones");
        jMenuTelecomunicaciones.setIcon(obtenerImagen(logo_Telecomunicaciones));
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
        jMenuPagos.setIcon(obtenerImagen(logo_Pagos));
        jMenuPagos.setOpaque(true);
        jMenuPagos.setBackground(mColorFondoMenu);
        jMenuPagos.setForeground(Color.WHITE);
        jMenuPagos.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50));

        jMenuIPGuardar.setText("Generar un nuevo pago");
        jMenuIPBuscar.setText("Buscar un nuevo pago");
        jMenuIPModificar.setText("Modificar un pago");
        jMenuIPEliminar.setText("Eliminar un pago");
        jMenuIPsoloVer.setText("Solo ver");
        jMenuIPpagar.setText("Pagar");
        
        //MenuInmuebles
        jMenuInmuebles.setText("Inmuebles");
        jMenuInmuebles.setIcon(obtenerImagen(logo_Inmuebles));
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
        jMenuEspaciosComunes.setIcon(obtenerImagen(logo_EspaciosComunes));
        jMenuEspaciosComunes.setOpaque(true);
        jMenuEspaciosComunes.setBackground(mColorFondoMenu);
        jMenuEspaciosComunes.setForeground(Color.WHITE);
        jMenuEspaciosComunes.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuIEC1.setText("MenuItem1");
       jMenuIEC2.setText("MenuItem2");
        jMenuIECModificar.setText("MenuItem3");
        jMenuIECEliminar.setText("MenuItem4");
        
        //MenuCheckIn
        jMenuCheckIn.setText("Check-In");
        jMenuCheckIn.setIcon(obtenerImagen(logo_CheckIn));
        jMenuCheckIn.setOpaque(true);
        jMenuCheckIn.setBackground(mColorFondoMenu);
        jMenuCheckIn.setForeground(Color.WHITE);
        jMenuCheckIn.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        jMenuICI1.setText("MenuItem1");
        jMenuICI2.setText("MenuItem2");
        jMenuICIModificar.setText("MenuItem3");
        jMenuICIEliminar.setText("MenuItem4");
        
        //MenuCheckIn
        jMenuCheckIn.setText("Check-In");
        jMenuCheckIn.setIcon(obtenerImagen(logo_CheckIn));
        jMenuCheckIn.setOpaque(true);
        jMenuCheckIn.setBackground(mColorFondoMenu);
        jMenuCheckIn.setForeground(Color.WHITE);
        jMenuCheckIn.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50)); 
        
        //jMenuISalir.setText("Cerrar Sesión");
        //jMenuIModoV.setText("modo");
        
        //Botones
        
        //Usuarios
        jMenuUsuario.addActionListener((ActionEvent e) -> {
            //cambiarPanel("Usuarios");
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
            //cambiarPanel("Pagos");
        });

        Usuario user = Usuario.getInstance();
        //system.out.println(user.getId());
        if (user.getRol() != null)
            System.out.println("el rol es:" +  user.getRol().getId());
        
        //administrador
        if (user.getRol().getId() == 1) {
            jMenuPagos.add(jMenuIPGuardar);
            jMenuPagos.add(jMenuIPBuscar);
            jMenuPagos.add(jMenuIPModificar);
            jMenuPagos.add(jMenuIPEliminar);
        //Usuario
        } else if (user.getRol().getId() == 2) {
            jMenuPagos.add(jMenuIPsoloVer);
            jMenuPagos.add(jMenuIPpagar);
            
        }else if (user.getRol().getId() == 3) {
            jMenuPagos.add(jMenuIPsoloVer);
            jMenuPagos.add(jMenuIPpagar);
        }
        

        // Inmuebles
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
        
        mbMenuBar.setPreferredSize(new java.awt.Dimension(this.getWidth(), 50));
        mbMenuBar.setLayout(new GridLayout(1, 7)); // Alinear elementos a la izquierda
       
        // Ancho igual al frame y altura 50
        // Crear una nueva fuente
        /*java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.BOLD, 16); // Tamaño de fuente 14 y estilo negrita

        // Establecer la fuente para cada JMenu
        jMenuUsuario.setFont(font);
        java.awt.Font font1 = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 16); // Tamaño de fuente 14 y estilo negrita
        jMenuIUsuarios1.setFont(font1);
        jMenuIUsuarios2.setFont(font1);
        jMenuIUsuarios3.setFont(font1);
        jMenuIUsuarios4.setFont(font1);*/
        
        //////////////////////////
        btnSalir.setFocusable(false);
        btnSalir.setBackground(Color.RED);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorderPainted(false);
        //mbMenuBar.add(btnSalir);
        
        panelBotones.setBackground(new Color(47, 79, 79));
        //panelBotones.setLayout(new GridLayout(1, 2));
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));

        panelBotones.add(Box.createHorizontalGlue());  // Agrega espacio flexible antes de los bo
        panelBotones.add(btnSalir);
        panelBotones.add(Box.createHorizontalGlue());  // Agrega espacio flexible después de los botones


        mbMenuBar.add(panelBotones);
        
        btnSalir.addActionListener((ActionEvent e) ->{
            FrmUsuarioLogin login = new FrmUsuarioLogin();
            login.setVisible(true);
            
            this.dispose();
        });
    }

    
    private void cambiarPanel(String Panel) {
        cardLayout.show(PanelPrincipal, Panel);
    }

    private void cambiarPanelFrm(String panel) {

        if (panel.equals("Telecomunicaciones")) {
            PanelT1.setVisible(true);
            PanelT2.setVisible(true);
            // PanelT3.setVisible(true);
        }
        if (panel.equals("Inmuebles")) {
            PanelI1.setVisible(true);
        }
        if (panel.equals("Pagos")) {
            jMenuIPGuardar.setVisible(true);
        }
        if (panel.equals("Espacios Comunes")) {
            PanelEC1.setVisible(true);
            PanelEC2.setVisible(true);
        }

        if (panel.equals("Check In")) {
            PanelCheckIn1.setVisible(true);
        }
    }

    private Icon obtenerImagen(String ruta) {
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
        jPanel1 = new javax.swing.JPanel();
        btnCrearUsuario = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        comboRolUsuario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        txtCorreoUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelefonoUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPassConfirmarUsuario = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCedulaUsuario = new javax.swing.JTextField();
        txtPassUsuario = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnBuscarUsuario = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
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
        PanelGuardarP = new javax.swing.JPanel();
        txtCedulaPG = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtMontoPG = new javax.swing.JTextField();
        txtFechaPG = new javax.swing.JTextField();
        comboTipoPG = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtDescripcionPG = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        buttonCrearPG = new javax.swing.JToggleButton();
        comboMetodoPago = new javax.swing.JComboBox<>();
        PanelBuscarP = new javax.swing.JPanel();
        txtBuscarP = new javax.swing.JTextField();
        buttonBuscarP = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaP = new javax.swing.JTable();
        PanelModificarP = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtCedulaPM = new javax.swing.JTextField();
        txtMontoPM = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtFechaPM = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        comboTipoPM = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtDescripcionPM = new javax.swing.JTextField();
        buttonModifiarP = new javax.swing.JToggleButton();
        jLabel24 = new javax.swing.JLabel();
        txtIdPM = new javax.swing.JTextField();
        buttonBuscarPM = new javax.swing.JToggleButton();
        PanelEliminarP = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtIdPE = new javax.swing.JTextField();
        buttonBuscarPE = new javax.swing.JToggleButton();
        comboEliminarPago = new javax.swing.JComboBox<>();
        PagosSoloVer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSoloVer = new javax.swing.JTable();
        PagosBotonSoloVer = new javax.swing.JButton();
        mbMenuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(128, 105, 70));
        PanelPrincipal.setLayout(new java.awt.CardLayout());

        PanelUsuarios.setBackground(new java.awt.Color(80, 200, 120));
        PanelPrincipal.add(PanelUsuarios, "card2");

        PanelGuardar.setBackground(new java.awt.Color(255, 248, 237));
        PanelGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnCrearUsuario.setText("Crear");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel13.setText("Fecha contratación");

        comboRolUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Residente", "Administrador", "Guardia", "Limpieza", "Mantenimiento" }));
        comboRolUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRolUsuarioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Rol");

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel14.setText("Sueldo");

        txtSueldo.setText(" ");
        txtSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoActionPerformed(evt);
            }
        });

        txtCorreoUsuario.setText(" ");
        txtCorreoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoUsuarioActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setText("Correo electrónico");

        txtTelefonoUsuario.setText(" ");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel10.setText("Teléfono");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Confirmar contraseña");

        txtNombreUsuario.setText(" ");
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setText("Nombre");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Número de cédula");

        txtCedulaUsuario.setText(" ");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setText("Contraseña");

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Source Code Pro Light", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar Cuentas");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtPassUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(txtPassConfirmarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(txtTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel5)
                        .addGap(11, 11, 11)
                        .addComponent(comboRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel14)
                        .addGap(156, 156, 156)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1)))
                .addGap(118, 118, 118))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassConfirmarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(comboRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearUsuario)
                    .addComponent(btnModificarUsuario)
                    .addComponent(btnEliminarUsuario)
                    .addComponent(btnBuscarUsuario))
                .addGap(29, 29, 29))
        );

        PanelGuardar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 840, 540));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/images_checkin/builds.jpg"))); // NOI18N
        PanelGuardar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1242, -1));

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

        PanelGuardarP.setLayout(null);
        PanelGuardarP.add(txtCedulaPG);
        txtCedulaPG.setBounds(340, 70, 430, 22);

        jLabel26.setText("Cedula");
        PanelGuardarP.add(jLabel26);
        jLabel26.setBounds(270, 70, 60, 30);
        PanelGuardarP.add(txtMontoPG);
        txtMontoPG.setBounds(350, 120, 110, 22);

        txtFechaPG.setText("AAAA-MM-DD");
        PanelGuardarP.add(txtFechaPG);
        txtFechaPG.setBounds(350, 170, 100, 22);

        comboTipoPG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pago", "multa" }));
        PanelGuardarP.add(comboTipoPG);
        comboTipoPG.setBounds(350, 210, 72, 22);

        jLabel15.setText("Monto");
        PanelGuardarP.add(jLabel15);
        jLabel15.setBounds(270, 120, 60, 16);

        jLabel16.setText("Fecha");
        PanelGuardarP.add(jLabel16);
        jLabel16.setBounds(270, 170, 60, 16);

        jLabel17.setText("Tipo");
        PanelGuardarP.add(jLabel17);
        jLabel17.setBounds(270, 210, 50, 16);

        txtDescripcionPG.setText("Ingrese la descripcion");
        PanelGuardarP.add(txtDescripcionPG);
        txtDescripcionPG.setBounds(340, 260, 440, 90);

        jLabel18.setText("Descripcion");
        PanelGuardarP.add(jLabel18);
        jLabel18.setBounds(260, 290, 70, 16);

        buttonCrearPG.setText("Crear pago");
        PanelGuardarP.add(buttonCrearPG);
        buttonCrearPG.setBounds(440, 410, 200, 23);

        comboMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta de credito", "Transferencia bancaria", "Efectivo" }));
        PanelGuardarP.add(comboMetodoPago);
        comboMetodoPago.setBounds(470, 210, 152, 22);

        PanelPrincipal.add(PanelGuardarP, "card13");

        PanelBuscarP.setLayout(null);

        txtBuscarP.setText("Ingrese un numero de cedula");
        PanelBuscarP.add(txtBuscarP);
        txtBuscarP.setBounds(270, 50, 290, 22);

        buttonBuscarP.setText("Buscar");
        PanelBuscarP.add(buttonBuscarP);
        buttonBuscarP.setBounds(140, 50, 120, 23);

        tablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaP);

        PanelBuscarP.add(jScrollPane1);
        jScrollPane1.setBounds(120, 80, 1040, 402);

        PanelPrincipal.add(PanelBuscarP, "card14");

        PanelModificarP.setLayout(null);

        jLabel19.setText("Cedula");
        PanelModificarP.add(jLabel19);
        jLabel19.setBounds(270, 70, 60, 30);
        PanelModificarP.add(txtCedulaPM);
        txtCedulaPM.setBounds(340, 70, 430, 22);
        PanelModificarP.add(txtMontoPM);
        txtMontoPM.setBounds(350, 120, 110, 22);

        jLabel20.setText("Monto");
        PanelModificarP.add(jLabel20);
        jLabel20.setBounds(270, 120, 60, 16);

        jLabel21.setText("Fecha");
        PanelModificarP.add(jLabel21);
        jLabel21.setBounds(270, 170, 60, 16);

        txtFechaPM.setText("AAAA-MM-DD");
        PanelModificarP.add(txtFechaPM);
        txtFechaPM.setBounds(350, 170, 100, 22);

        jLabel22.setText("Tipo");
        PanelModificarP.add(jLabel22);
        jLabel22.setBounds(270, 210, 50, 16);

        comboTipoPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pago", "multa" }));
        PanelModificarP.add(comboTipoPM);
        comboTipoPM.setBounds(350, 210, 72, 22);

        jLabel23.setText("Descripcion");
        PanelModificarP.add(jLabel23);
        jLabel23.setBounds(260, 290, 70, 16);

        txtDescripcionPM.setText("Ingrese la descripcion");
        PanelModificarP.add(txtDescripcionPM);
        txtDescripcionPM.setBounds(340, 260, 440, 90);

        buttonModifiarP.setText("Guardar cambios");
        PanelModificarP.add(buttonModifiarP);
        buttonModifiarP.setBounds(390, 390, 240, 23);

        jLabel24.setText("Id");
        PanelModificarP.add(jLabel24);
        jLabel24.setBounds(270, 40, 10, 16);

        txtIdPM.setText("Ingrese el id del pago a modificar");
        txtIdPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPMActionPerformed(evt);
            }
        });
        PanelModificarP.add(txtIdPM);
        txtIdPM.setBounds(340, 40, 200, 22);

        buttonBuscarPM.setText("Buscar");
        PanelModificarP.add(buttonBuscarPM);
        buttonBuscarPM.setBounds(570, 40, 200, 23);

        PanelPrincipal.add(PanelModificarP, "card15");

        PanelEliminarP.setLayout(null);

        jLabel25.setText("Ingrese el id del pago a eliminar");
        PanelEliminarP.add(jLabel25);
        jLabel25.setBounds(200, 100, 180, 30);

        txtIdPE.setText("id");
        PanelEliminarP.add(txtIdPE);
        txtIdPE.setBounds(390, 110, 71, 22);

        buttonBuscarPE.setText("Eliminar");
        PanelEliminarP.add(buttonBuscarPE);
        buttonBuscarPE.setBounds(490, 110, 160, 23);

        comboEliminarPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pago", "multa" }));
        PanelEliminarP.add(comboEliminarPago);
        comboEliminarPago.setBounds(100, 110, 72, 22);

        PanelPrincipal.add(PanelEliminarP, "card16");

        tablaSoloVer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaSoloVer);

        PagosBotonSoloVer.setText("Buscar");

        javax.swing.GroupLayout PagosSoloVerLayout = new javax.swing.GroupLayout(PagosSoloVer);
        PagosSoloVer.setLayout(PagosSoloVerLayout);
        PagosSoloVerLayout.setHorizontalGroup(
            PagosSoloVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PagosSoloVerLayout.createSequentialGroup()
                .addGap(479, 479, 479)
                .addComponent(PagosBotonSoloVer)
                .addContainerGap(729, Short.MAX_VALUE))
            .addGroup(PagosSoloVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PagosSoloVerLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PagosSoloVerLayout.setVerticalGroup(
            PagosSoloVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PagosSoloVerLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(PagosBotonSoloVer)
                .addContainerGap(633, Short.MAX_VALUE))
            .addGroup(PagosSoloVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PagosSoloVerLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PanelPrincipal.add(PagosSoloVer, "card27");

        getContentPane().add(PanelPrincipal, java.awt.BorderLayout.CENTER);
        setJMenuBar(mbMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPMActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void txtCorreoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoUsuarioActionPerformed

    private void txtSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void comboRolUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRolUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRolUsuarioActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed


    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmMenuBar().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton PagosBotonSoloVer;
    private javax.swing.JPanel PagosSoloVer;
    private javax.swing.JPanel PanelBuscarP;
    private javax.swing.JPanel PanelCheckIn;
    private javax.swing.JPanel PanelCheckIn1;
    private javax.swing.JPanel PanelEC1;
    private javax.swing.JPanel PanelEC2;
    private javax.swing.JPanel PanelEliminar;
    private javax.swing.JPanel PanelEliminarP;
    private javax.swing.JPanel PanelEspaciosComunes;
    public javax.swing.JPanel PanelGuardar;
    private javax.swing.JPanel PanelGuardarP;
    private javax.swing.JPanel PanelI1;
    private javax.swing.JPanel PanelI2;
    private javax.swing.JPanel PanelInmuebles;
    private javax.swing.JPanel PanelModificar;
    private javax.swing.JPanel PanelModificarP;
    private javax.swing.JPanel PanelP1;
    private javax.swing.JPanel PanelP2;
    private javax.swing.JPanel PanelPagos;
    public javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelT1;
    private javax.swing.JPanel PanelT2;
    private javax.swing.JPanel PanelTelecomunicaciones;
    public javax.swing.JPanel PanelUsuarios;
    private javax.swing.JPanel PanerBuscar;
    public javax.swing.JButton btnBuscarUsuario;
    public javax.swing.JButton btnCrearUsuario;
    public javax.swing.JButton btnEliminarUsuario;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificarUsuario;
    public javax.swing.JToggleButton buttonBuscarP;
    public javax.swing.JToggleButton buttonBuscarPE;
    public javax.swing.JToggleButton buttonBuscarPM;
    public javax.swing.JToggleButton buttonCrearPG;
    public javax.swing.JToggleButton buttonModifiarP;
    public javax.swing.JComboBox<String> comboEliminarPago;
    public javax.swing.JComboBox<String> comboMetodoPago;
    public javax.swing.JComboBox<String> comboRolUsuario;
    public javax.swing.JComboBox<String> comboTipoPG;
    public javax.swing.JComboBox<String> comboTipoPM;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar mbMenuBar;
    public javax.swing.JTable tablaP;
    public javax.swing.JTable tablaSoloVer;
    public javax.swing.JTextField txtBuscarP;
    public javax.swing.JTextField txtCedulaPG;
    public javax.swing.JTextField txtCedulaPM;
    public javax.swing.JTextField txtCedulaUsuario;
    public javax.swing.JTextField txtCorreoUsuario;
    public javax.swing.JTextField txtDescripcionPG;
    public javax.swing.JTextField txtDescripcionPM;
    public javax.swing.JTextField txtFechaPG;
    public javax.swing.JTextField txtFechaPM;
    public javax.swing.JTextField txtIdPE;
    public javax.swing.JTextField txtIdPM;
    public javax.swing.JTextField txtMontoPG;
    public javax.swing.JTextField txtMontoPM;
    public javax.swing.JTextField txtNombreUsuario;
    public javax.swing.JPasswordField txtPassConfirmarUsuario;
    public javax.swing.JPasswordField txtPassUsuario;
    public javax.swing.JTextField txtSueldo;
    public javax.swing.JTextField txtTelefonoUsuario;
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
    public javax.swing.JMenuItem jMenuIPGuardar;
    public javax.swing.JMenuItem jMenuIPEliminar;
    public javax.swing.JMenuItem jMenuIPModificar;
    public javax.swing.JMenuItem jMenuIPBuscar;
    public javax.swing.JMenuItem jMenuIPsoloVer;
    public javax.swing.JMenuItem jMenuIPpagar;

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
    
    //public javax.swing.JMenu jMenuConfig;
    //public javax.swing.JMenuItem jMenuISalir;
    
    public String logo_Usuario= "/imagenes/clientes.png";
    public String logo_Telecomunicaciones= "/imagenes/telecomunicaciones.png";
    public String logo_Pagos= "/imagenes/metodo-de-pago.png";
    public String logo_Inmuebles= "/imagenes/enlace.png";
    public String logo_EspaciosComunes= "/imagenes/pesa.png";
    public String logo_CheckIn= "/imagenes/portapapeles.png";

   
    public Color mColorFondoMenu= new Color(47, 79, 79);
    
    // Crear los botones con iconos
        JButton btnSalir = new JButton("Salir");
    // End of variables declaration         
        JPanel panelBotones = new JPanel();
       
}