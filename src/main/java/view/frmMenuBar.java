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
import view.Reservas.FrmCancelarReserva;
import view.Reservas.FrmReserva;
import view.comunicacion.FrmMensaje;
import view.comunicacion.FrmMensajeAdmin;
import view.comunicacion.FrmReporte;
import view.inmuebles.FrmPantalla;

/**
 *
 * @author RIBZ
 */
public class frmMenuBar extends javax.swing.JFrame {

    private CardLayout cardLayout; // Declaración a nivel de clase

    public frmMenuBar() {
        initComponents();
        this.setSize(1280, 720);
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
        PanelP1.setLayout(new java.awt.BorderLayout());
        PanelP1.add(frmFinanzas.getContentPane(), java.awt.BorderLayout.CENTER);
        PanelP1.setVisible(false);
        PanelP1.repaint();
        PanelP1.revalidate();

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
        // jMenuConfig = new javax.swing.JMenu();

        jMenuIUsuarios1 = new javax.swing.JMenuItem();
        jMenuIUsuarios2 = new javax.swing.JMenuItem();
        jMenuIUsuarios3 = new javax.swing.JMenuItem();
        jMenuIUsuarios4 = new javax.swing.JMenuItem();

        jMenuIT1 = new javax.swing.JMenuItem();
        jMenuIT2 = new javax.swing.JMenuItem();
        // jMenuIT3 = new javax.swing.JMenuItem();
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

        // jMenuISalir = new javax.swing.JMenuItem();
        // jMenuIModoV = new javax.swing.JMenuItem();
        jMenuUsuario.setText("Usuario");
        jMenuUsuario.setIcon(obtenerImagen(logo_Usuario));
        jMenuUsuario.setOpaque(true);
        jMenuUsuario.setBackground(mColorFondoMenu);
        jMenuUsuario.setForeground(Color.WHITE);
        jMenuUsuario.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50));
        // MenuItems
        jMenuIUsuarios1.setText("Crear cuenta");
        jMenuIUsuarios2.setText("MenuItem2");
        jMenuIUsuarios3.setText("MenuItem3");
        jMenuIUsuarios4.setText("MenuItem4");

        // MenuTelecomunicaciones
        jMenuTelecomunicaciones.setText("Telecomunicaciones");
        jMenuTelecomunicaciones.setIcon(obtenerImagen(logo_Telecomunicaciones));
        jMenuTelecomunicaciones.setOpaque(true);
        jMenuTelecomunicaciones.setBackground(mColorFondoMenu);
        jMenuTelecomunicaciones.setForeground(Color.WHITE);
        jMenuTelecomunicaciones.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50));

        jMenuIT1.setText("Mensaje");
        jMenuIT2.setText("Mensaje Admin");
        // jMenuIT3.setText("Reporte");
        jMenuITModificar.setText("MenuItem3");
        jMenuITEliminar.setText("MenuItem4");

        // MenuPagos
        jMenuPagos.setText("Pagos");
        jMenuPagos.setIcon(obtenerImagen(logo_Pagos));
        jMenuPagos.setOpaque(true);
        jMenuPagos.setBackground(mColorFondoMenu);
        jMenuPagos.setForeground(Color.WHITE);
        jMenuPagos.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50));

        jMenuIP1.setText("Pagos");
        jMenuIP2.setText("MenuItem2");
        jMenuIPModificar.setText("MenuItem3");
        jMenuIPEliminar.setText("MenuItem4");

        // MenuInmuebles
        jMenuInmuebles.setText("Inmuebles");
        jMenuInmuebles.setIcon(obtenerImagen(logo_Inmuebles));
        jMenuInmuebles.setOpaque(true);
        jMenuInmuebles.setBackground(mColorFondoMenu);
        jMenuInmuebles.setForeground(Color.WHITE);
        jMenuInmuebles.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50));

        jMenuII1.setText("Inmueble");
        jMenuIIModificar.setText("MenuItem3");
        jMenuIIEliminar.setText("MenuItem4");

        // MenuEspaciosComunes
        jMenuEspaciosComunes.setText("Espacios Comunes");
        jMenuEspaciosComunes.setIcon(obtenerImagen(logo_EspaciosComunes));
        jMenuEspaciosComunes.setOpaque(true);
        jMenuEspaciosComunes.setBackground(mColorFondoMenu);
        jMenuEspaciosComunes.setForeground(Color.WHITE);
        jMenuEspaciosComunes.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50));

        jMenuIEC1.setText("Reserva");
        jMenuIEC2.setText("Reserva Cancelada");
        jMenuIECModificar.setText("MenuItem3");
        jMenuIECEliminar.setText("MenuItem4");

        // MenuCheckIn
        jMenuCheckIn = new javax.swing.JMenu();
        jMenuCheckIn.setText("Check-In");
        jMenuCheckIn.setIcon(obtenerImagen(logo_CheckIn));
        jMenuCheckIn.setOpaque(true);
        jMenuCheckIn.setBackground(mColorFondoMenu);
        jMenuCheckIn.setForeground(Color.WHITE);
        jMenuCheckIn.setMaximumSize(new java.awt.Dimension(Short.MAX_VALUE, 50));

        jMenuICI1.setText("Check In");
        jMenuICIModificar.setText("MenuItem3");
        jMenuICIEliminar.setText("MenuItem4");

        // jMenuISalir.setText("Cerrar Sesión");
        // jMenuIModoV.setText("modo");
        // Botones
        // Usuarios
        jMenuUsuario.addActionListener((ActionEvent e) -> {
            cambiarPanel("Usuarios");
        });

        jMenuUsuario.add(jMenuIUsuarios1);
        jMenuUsuario.add(jMenuIUsuarios2);
        // jMenuUsuario.add(jMenuIUsuarios3);
        // jMenuUsuario.add(jMenuIUsuarios4);

        // Telecomunicaciones
        jMenuTelecomunicaciones.addActionListener((ActionEvent e) -> {
            cambiarPanelFrm("Telecomunicaciones");
        });

        jMenuTelecomunicaciones.add(jMenuIT1);
        jMenuTelecomunicaciones.add(jMenuIT2);
        // jMenuTelecomunicaciones.add(jMenuIT3);
        // jMenuTelecomunicaciones.add(jMenuITModificar);
        // jMenuTelecomunicaciones.add(jMenuITEliminar);

        // Pagos
        jMenuPagos.addActionListener((ActionEvent e) -> {
            cambiarPanel("Pagos");
        });

        jMenuPagos.add(jMenuIP1);
        jMenuPagos.add(jMenuIP2);
        // jMenuPagos.add(jMenuIPModificar);
        // jMenuPagos.add(jMenuIPEliminar);

        // Inmuebles
        jMenuInmuebles.addActionListener((ActionEvent e) -> {
            cambiarPanelFrm("Inmuebles");
        });

        jMenuInmuebles.add(jMenuII1);
        jMenuInmuebles.add(jMenuII2);
        // jMenuInmuebles.add(jMenuIIModificar);
        // jMenuInmuebles.add(jMenuIIEliminar);

        // Espacios Comunes
        jMenuEspaciosComunes.addActionListener((ActionEvent e) -> {
            cambiarPanelFrm("Espacios Comunes");
        });

        jMenuEspaciosComunes.add(jMenuIEC1);
        jMenuEspaciosComunes.add(jMenuIEC2);
        // jMenuEspaciosComunes.add(jMenuIECModificar);
        // jMenuEspaciosComunes.add(jMenuIECEliminar);

        // Check-In
        jMenuCheckIn.addActionListener((ActionEvent e) -> {
            cambiarPanelFrm("Check In");
        });
        jMenuCheckIn.add(jMenuICI1);

        // jMenuCheckIn.add(jMenuICIModificar);
        // jMenuCheckIn.add(jMenuICIEliminar);
        // Modulos en el Menu Bar
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
        /*
         * java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.BOLD, 16); //
         * Tamaño de fuente 14 y estilo negrita
         * 
         * // Establecer la fuente para cada JMenu
         * jMenuUsuario.setFont(font);
         * java.awt.Font font1 = new java.awt.Font("Arial",
         * java.awt.Font.ROMAN_BASELINE, 16); // Tamaño de fuente 14 y estilo negrita
         * jMenuIUsuarios1.setFont(font1);
         * jMenuIUsuarios2.setFont(font1);
         * jMenuIUsuarios3.setFont(font1);
         * jMenuIUsuarios4.setFont(font1);
         */
        //////////////////////////
        btnSalir.setFocusable(false);
        btnSalir.setBackground(Color.RED);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorderPainted(false);
        // mbMenuBar.add(btnSalir);

        panelBotones.setBackground(new Color(47, 79, 79));
        // panelBotones.setLayout(new GridLayout(1, 2));
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));

        panelBotones.add(Box.createHorizontalGlue()); // Agrega espacio flexible antes de los bo
        panelBotones.add(btnSalir);
        panelBotones.add(Box.createHorizontalGlue()); // Agrega espacio flexible después de los botones

        mbMenuBar.add(panelBotones);

        btnSalir.addActionListener((ActionEvent e) -> {
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
            PanelP1.setVisible(true);
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelUsuarios = new javax.swing.JPanel();
        PanelGuardar = new javax.swing.JPanel();
        txtCedulaUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtCorreoUsuario = new javax.swing.JTextField();
        txtPassUsuario = new javax.swing.JPasswordField();
        txtPassConfirmarUsuario = new javax.swing.JPasswordField();
        txtTelefonoUsuario = new javax.swing.JTextField();
        comboRolUsuario = new javax.swing.JComboBox<>();
        txtSueldo = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnCrearUsuario = new javax.swing.JButton();
        PanerBuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelModificar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PanelEliminar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PanelTelecomunicaciones = new javax.swing.JPanel();
        PanelT1 = new javax.swing.JPanel();
        PanelT2 = new javax.swing.JPanel();
        PanelPagos = new javax.swing.JPanel();
        PanelP1 = new javax.swing.JPanel();
        PanelP2 = new javax.swing.JPanel();
        PanelInmuebles = new javax.swing.JPanel();
        PanelI1 = new javax.swing.JPanel();
        PanelEspaciosComunes = new javax.swing.JPanel();
        PanelEC1 = new javax.swing.JPanel();
        PanelEC2 = new javax.swing.JPanel();
        PanelCheckIn = new javax.swing.JPanel();
        PanelCheckIn1 = new javax.swing.JPanel();
        mbMenuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(128, 105, 70));
        PanelPrincipal.setLayout(new java.awt.CardLayout());

        PanelUsuarios.setBackground(new java.awt.Color(80, 200, 120));
        PanelPrincipal.add(PanelUsuarios, "card2");

        PanelGuardar.setBackground(new java.awt.Color(255, 248, 237));

        txtCedulaUsuario.setText(" ");

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Source Code Pro Light", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear cuenta");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtNombreUsuario.setText(" ");
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        txtCorreoUsuario.setText(" ");
        txtCorreoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoUsuarioActionPerformed(evt);
            }
        });

        txtTelefonoUsuario.setText(" ");

        comboRolUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Residente", "Administrador", "Guardia", "Limpieza", "Mantenimiento" }));

        txtSueldo.setText(" ");
        txtSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Rol");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Número de cédula");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Confirmar contraseña");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setText("Nombre");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setText("Contraseña");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel10.setText("Teléfono");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setText("Correo electrónico");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel13.setText("Fecha contratación");

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel14.setText("Sueldo");

        btnCrearUsuario.setText("Crear");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGuardarLayout = new javax.swing.GroupLayout(PanelGuardar);
        PanelGuardar.setLayout(PanelGuardarLayout);
        PanelGuardarLayout.setHorizontalGroup(
                PanelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                .addGap(402, 402, 402)
                                .addGroup(PanelGuardarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addGroup(PanelGuardarLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(PanelGuardarLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(txtCedulaUsuario)
                                                                .addComponent(jLabel6,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(jLabel8)
                                                        .addComponent(txtNombreUsuario,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 163,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(59, 59, 59)
                                                .addGroup(PanelGuardarLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(txtPassUsuario,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 159,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtPassConfirmarUsuario,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 160,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addGroup(PanelGuardarLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                                .addGroup(PanelGuardarLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(txtCorreoUsuario)
                                                                        .addComponent(jLabel11))
                                                                .addGap(58, 58, 58)
                                                                .addGroup(PanelGuardarLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel10,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addGroup(PanelGuardarLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(txtTelefonoUsuario,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        161,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(195, 195, 195))))
                                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                                .addGroup(PanelGuardarLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtSueldo,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                157,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel14))
                                                                .addGap(59, 59, 59)
                                                                .addGroup(PanelGuardarLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel13)
                                                                        .addComponent(jDateChooser1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                177,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(134, 134, 134))))
                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                .addGroup(PanelGuardarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addGap(436, 436, 436)
                                                .addComponent(jLabel1))
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addGap(530, 530, 530)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGuardarLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(503, 503, 503)));
        PanelGuardarLayout.setVerticalGroup(
                PanelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addGroup(PanelGuardarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCedulaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPassUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelGuardarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPassConfirmarUsuario,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelGuardarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelGuardarLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel10)
                                                .addGap(5, 5, 5)
                                                .addComponent(txtTelefonoUsuario,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28,
                                        Short.MAX_VALUE)
                                .addGroup(PanelGuardarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelGuardarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelGuardarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(btnCrearUsuario)
                                .addGap(75, 75, 75)));

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
        PanelPrincipal.add(PanelT1, "card8");
        PanelPrincipal.add(PanelT2, "card9");

        PanelPagos.setBackground(new java.awt.Color(153, 255, 255));
        PanelPrincipal.add(PanelPagos, "card12");

        PanelP1.setBackground(new java.awt.Color(0, 102, 255));
        PanelPrincipal.add(PanelP1, "card13");

        PanelP2.setBackground(new java.awt.Color(255, 0, 255));
        PanelPrincipal.add(PanelP2, "card14");

        PanelInmuebles.setBackground(new java.awt.Color(0, 153, 153));
        PanelPrincipal.add(PanelInmuebles, "card17");

        PanelI1.setBackground(new java.awt.Color(255, 153, 153));
        PanelPrincipal.add(PanelI1, "panel1Inmuebles");
        PanelPrincipal.add(PanelEspaciosComunes, "card22");
        PanelPrincipal.add(PanelEC1, "card23");
        PanelPrincipal.add(PanelEC2, "card24");

        PanelCheckIn.setBackground(new java.awt.Color(204, 204, 204));
        PanelPrincipal.add(PanelCheckIn, "card25");

        PanelCheckIn1.setBackground(new java.awt.Color(102, 0, 102));
        PanelPrincipal.add(PanelCheckIn1, "card26");

        getContentPane().add(PanelPrincipal, java.awt.BorderLayout.CENTER);
        setJMenuBar(mbMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmMenuBar().setVisible(true));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCheckIn;
    private javax.swing.JPanel PanelCheckIn1;
    private javax.swing.JPanel PanelEC1;
    private javax.swing.JPanel PanelEC2;
    private javax.swing.JPanel PanelEliminar;
    private javax.swing.JPanel PanelEspaciosComunes;
    public javax.swing.JPanel PanelGuardar;
    private javax.swing.JPanel PanelI1;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar mbMenuBar;
    public javax.swing.JTextField txtCedulaUsuario;
    public javax.swing.JTextField txtCorreoUsuario;
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

    // public javax.swing.JMenu jMenuConfig;
    // public javax.swing.JMenuItem jMenuISalir;
    public String logo_Usuario = "/imagenes/clientes.png";
    public String logo_Telecomunicaciones = "/imagenes/telecomunicaciones.png";
    public String logo_Pagos = "/imagenes/metodo-de-pago.png";
    public String logo_Inmuebles = "/imagenes/enlace.png";
    public String logo_EspaciosComunes = "/imagenes/pesa.png";
    public String logo_CheckIn = "/imagenes/portapapeles.png";

    public Color mColorFondoMenu = new Color(47, 79, 79);

    // Crear los botones con iconos
    JButton btnSalir = new JButton("Salir");
    // End of variables declaration
    JPanel panelBotones = new JPanel();

}
