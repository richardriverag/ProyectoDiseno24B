/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.comunicacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author manue
 */
public class FrmMensaje extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private JPanel panelContenido; // Contenedor de los diferentes paneles

    /**
     * Creates new form FrmMensaje
     */
    public FrmMensaje() {
        setTitle("Chats");
        initComponents();
        cargarUsuarios();
        configurarBoton();
        configurarCardLayout();
        personalizarMenu();

        
        this.setSize(1280, 720);

        // Evitar que la ventana sea redimensionable
        this.setResizable(false);

    }

    private void configurarCardLayout() {
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);

        // Agregar paneles al CardLayout
        panelContenido.add(crearPanelResidentes(), "Residentes");
        panelContenido.add(crearPanelAnuncioGeneral(), "AnuncioGeneral");
        panelContenido.add(crearPanelComunicado(), "Comunicado");

        // Agregar el panelContenido a la parte derecha de la ventana
        jPanel3.setLayout(new BorderLayout());
        jPanel3.add(panelContenido, BorderLayout.CENTER);
    }

    private JPanel crearPanelResidentes() {
        // Crear el panel principal de la sección
        JPanel panelResidentes = new JPanel();
        panelResidentes.setLayout(new BorderLayout());

        // Panel superior con el JLabel
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alineación a la izquierda
        JLabel labelSuperior = new JLabel("Destinatario");
        labelSuperior.setFont(new Font("Arial", Font.PLAIN, 18)); // Ajusta el tamaño y el tipo de fuente

        // Agregar el JLabel al panel
        panelSuperior.add(labelSuperior);

        // Panel central con JScrollPane y JPanel para los mensajes
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        // Crear el JScrollPane para los mensajes
        JScrollPane scrollPanelMensajes = new JScrollPane();
        JPanel panelMensajes = new JPanel();
        panelMensajes.setLayout(new BoxLayout(panelMensajes, BoxLayout.Y_AXIS)); // Para apilar los mensajes verticalmente
        panelMensajes.setBackground(Color.WHITE);

        // Agregar panelMensajes dentro del JScrollPane
        scrollPanelMensajes.setViewportView(panelMensajes);

        // Ajuste del JScrollPane
        scrollPanelMensajes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanelMensajes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelCentral.add(scrollPanelMensajes, BorderLayout.CENTER);

        // Panel inferior con un JTextField y un botón con imagen
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField txtMensaje = new JTextField(50);
        txtMensaje.setPreferredSize(new java.awt.Dimension(300, 55));
        txtMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panelInferior.add(txtMensaje);

        // Crear el botón con una imagen
        JButton btnEnviarMensaje = new JButton();
        ImageIcon iconoEnviar = new ImageIcon(getClass().getResource("/imagenescomunicacion/mensaje.png")); // Ruta de la imagen
        btnEnviarMensaje.setIcon(iconoEnviar);
        btnEnviarMensaje.setContentAreaFilled(false);
        btnEnviarMensaje.setBorderPainted(false);
        btnEnviarMensaje.setFocusPainted(false);

        // Agregar el botón al panel inferior
        panelInferior.add(btnEnviarMensaje);

        // Efecto visual al presionar el botón
        btnEnviarMensaje.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEnviarMensaje.setOpaque(true);
                btnEnviarMensaje.setBackground(new java.awt.Color(200, 200, 200));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEnviarMensaje.setOpaque(false);
                btnEnviarMensaje.setBackground(null);
            }
        });

        // Agregar mensajes de prueba (remitente y receptor)
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);
        agregarMensaje(panelMensajes, "Mensaje de prueba del remitente.", true); // Remitente
        agregarMensaje(panelMensajes, "Respuesta de prueba del receptor.", false);

        // Agregar los paneles al panelResidentes
        panelResidentes.add(panelSuperior, BorderLayout.NORTH);
        panelResidentes.add(panelCentral, BorderLayout.CENTER);
        panelResidentes.add(panelInferior, BorderLayout.SOUTH);

        return panelResidentes;
    }

    private JPanel crearPanelAnuncioGeneral() {
        // Crear el panel principal de la sección
        JPanel panelAnuncioGeneral = new JPanel();
        panelAnuncioGeneral.setLayout(new BorderLayout());

        // Panel central con JScrollPane y JPanel para los mensajes
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        // Panel superior con el JLabel
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alineación a la izquierda
        JLabel labelSuperior = new JLabel("Anuncios Generales");
        labelSuperior.setFont(new Font("Arial", Font.PLAIN, 18)); // Ajusta el tamaño y el tipo de fuente

        // Agregar el JLabel al panel
        panelSuperior.add(labelSuperior);

        // Crear el JScrollPane para los mensajes
        JScrollPane scrollPanelMensajes = new JScrollPane();
        JPanel panelMensajes = new JPanel();
        panelMensajes.setLayout(new BoxLayout(panelMensajes, BoxLayout.Y_AXIS)); // Para apilar los mensajes verticalmente
        panelMensajes.setBackground(Color.CYAN);

        // Agregar panelMensajes dentro del JScrollPane
        scrollPanelMensajes.setViewportView(panelMensajes);

        // Ajuste del JScrollPane
        scrollPanelMensajes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanelMensajes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelCentral.add(scrollPanelMensajes, BorderLayout.CENTER);

        panelAnuncioGeneral.add(panelSuperior, BorderLayout.NORTH);
        panelAnuncioGeneral.add(panelCentral, BorderLayout.CENTER);
        return panelAnuncioGeneral;
    }

    private JPanel crearPanelComunicado() {
        // Crear el panel principal de la sección
        JPanel panelComunicado = new JPanel();
        panelComunicado.setLayout(new BorderLayout());

        // Panel central con JScrollPane y JPanel para los mensajes
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        // Panel superior con el JLabel
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alineación a la izquierda
        JLabel labelSuperior = new JLabel("Comunicado Empleados");
        labelSuperior.setFont(new Font("Arial", Font.PLAIN, 18)); // Ajusta el tamaño y el tipo de fuente

        // Agregar el JLabel al panel
        panelSuperior.add(labelSuperior);

        // Crear el JScrollPane para los mensajes
        JScrollPane scrollPanelMensajes = new JScrollPane();
        JPanel panelMensajes = new JPanel();
        panelMensajes.setLayout(new BoxLayout(panelMensajes, BoxLayout.Y_AXIS)); // Para apilar los mensajes verticalmente
        panelMensajes.setBackground(Color.WHITE);

        // Agregar panelMensajes dentro del JScrollPane
        scrollPanelMensajes.setViewportView(panelMensajes);

        // Ajuste del JScrollPane
        scrollPanelMensajes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanelMensajes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelCentral.add(scrollPanelMensajes, BorderLayout.CENTER);

        panelComunicado.add(panelSuperior, BorderLayout.NORTH);
        panelComunicado.add(panelCentral, BorderLayout.CENTER);
        return panelComunicado;
    }

    private void configurarBoton() {

        btnResidentes.setContentAreaFilled(false);
        btnResidentes.setBorderPainted(false);
        btnResidentes.setFocusPainted(false);
        btnResidentes.addActionListener(e -> cardLayout.show(panelContenido, "Residentes"));

        btnAnuncioGeneral.setContentAreaFilled(false);
        btnAnuncioGeneral.setBorderPainted(false);
        btnAnuncioGeneral.setFocusPainted(false);
        btnAnuncioGeneral.addActionListener(e -> cardLayout.show(panelContenido, "AnuncioGeneral"));

        btnComunicado.setContentAreaFilled(false);
        btnComunicado.setBorderPainted(false);
        btnComunicado.setFocusPainted(false);
        btnComunicado.addActionListener(e -> cardLayout.show(panelContenido, "Comunicado"));

        // Efecto visual al presionar el botón
        btnResidentes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnResidentes.setOpaque(true);
                btnResidentes.setBackground(new java.awt.Color(200, 200, 200));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnResidentes.setOpaque(false);
                btnResidentes.setBackground(null);
            }
        });

        // Efecto visual al presionar el botón
        btnAnuncioGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnuncioGeneral.setOpaque(true);
                btnAnuncioGeneral.setBackground(new java.awt.Color(200, 200, 200));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAnuncioGeneral.setOpaque(false);
                btnAnuncioGeneral.setBackground(null);
            }
        });

        // Efecto visual al presionar el botón
        btnComunicado.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnComunicado.setOpaque(true);
                btnComunicado.setBackground(new java.awt.Color(200, 200, 200));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnComunicado.setOpaque(false);
                btnComunicado.setBackground(null);
            }
        });

    }

    private void agregarMensaje(JPanel panelMensajes, String mensaje, boolean esRemitente) {
        // Crear un panel para cada mensaje
        JPanel panelMensaje = new JPanel(new FlowLayout(esRemitente ? FlowLayout.RIGHT : FlowLayout.LEFT));

        // Crear el JLabel con el mensaje
        JLabel labelMensaje = new JLabel(mensaje);
        labelMensaje.setFont(new Font("Arial", Font.PLAIN, 14)); // Ajusta la fuente si es necesario
        labelMensaje.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Espaciado alrededor del texto

        // Establecer un color diferente según si es remitente o receptor
        if (esRemitente) {
            labelMensaje.setBackground(new Color(173, 216, 230)); // Azul claro para el remitente
            labelMensaje.setOpaque(true);
        } else {
            labelMensaje.setBackground(new Color(220, 220, 220)); // Gris claro para el receptor
            labelMensaje.setOpaque(true);
        }

        // Crear el botón con la imagen
        JButton btnMenu = new JButton();
        ImageIcon iconoMenu = new ImageIcon(getClass().getResource("/imagenescomunicacion/tres-puntos.png")); // Ruta de la imagen del menú
        btnMenu.setIcon(iconoMenu);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusPainted(false);

        // Crear el menú emergente (popup) con opciones de Editar y Eliminar
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem editarItem = new JMenuItem("Editar");
        popupMenu.add(editarItem);

        JMenuItem eliminarItem = new JMenuItem("Eliminar");
        popupMenu.add(eliminarItem);

        // Agregar un listener para mostrar el popup cuando se presione el botón
        btnMenu.addActionListener(e -> popupMenu.show(btnMenu, 0, btnMenu.getHeight())); // Muestra el menú al hacer clic en el botón

        // Añadir el JLabel y el botón al panel del mensaje
        panelMensaje.add(labelMensaje);
        // El botón se añade a la derecha del mensaje
        if (esRemitente) {
            panelMensaje.add(btnMenu);
        }

        // Añadir el panel del mensaje al panel de mensajes
        panelMensajes.add(panelMensaje);

        // Actualizar la vista
        panelMensajes.revalidate();
        panelMensajes.repaint();

        // Desplazar hacia abajo para mostrar el último mensaje
        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalScrollBar = ((JScrollPane) panelMensajes.getParent().getParent()).getVerticalScrollBar();
            verticalScrollBar.setValue(verticalScrollBar.getMaximum());
        });
    }

    // Modelos para las listas
    public DefaultListModel<String> modeloUsuarios;

    private void cargarUsuarios() {
        modeloUsuarios = new DefaultListModel<>();
        modeloUsuarios.addElement("Usuario 1");
        modeloUsuarios.addElement("Usuario 2");
        modeloUsuarios.addElement("Usuario 3");
        modeloUsuarios.addElement("Usuario 3");

        lsUsuarios.setModel(modeloUsuarios); // Inicialmente muestra usuarios
        lsUsuarios.setCellRenderer(new UsuarioRenderer());
    }

    private static class UsuarioRenderer extends DefaultListCellRenderer {

        private final ImageIcon icono;

        public UsuarioRenderer() {
            // Cargar el icono por defecto desde recursos
            icono = new ImageIcon(getClass().getResource("/imagenescomunicacion/usuario.png"));
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Escalar la imagen para que tenga un tamaño adecuado
            Image imagen = icono.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(imagen));

            // Cambiar tamaño de letra y agregar espaciado
            label.setFont(new Font("Arial", Font.PLAIN, 18));
            label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            return label;
        }
    }

    public void personalizarMenu() {

        for (int i = 0; i < jMenuBar1.getMenuCount(); i++) {
            JMenu menu = jMenuBar1.getMenu(i);
            if (menu != null) {
                menu.setForeground(Color.WHITE); // Color del texto blanco

                // Agregar efecto de cambio de color al seleccionar
                menu.addChangeListener(e -> {
                    if (menu.isSelected()) {
                        menu.setForeground(Color.BLACK); // Negro al seleccionar
                    } else {
                        menu.setForeground(Color.WHITE); // Blanco cuando no está seleccionado
                    }
                });

                for (int j = 0; j < menu.getItemCount(); j++) {
                    JMenuItem item = menu.getItem(j);
                    if (item != null) {
                        item.setForeground(Color.WHITE);
                        item.setBackground(Color.DARK_GRAY);
                    }
                }
            }
        }

        jMenuBar1.setLayout(new java.awt.GridLayout(1, 6)); 
        jMenuBar1.add(mbUsuarios);
        jMenuBar1.add(mbComunicacion);
        jMenuBar1.add(mbPagos);
        jMenuBar1.add(mbInmuebles);
        jMenuBar1.add(mbEspaciosComunes);
        jMenuBar1.add(mbCheckIn);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnResidentes = new javax.swing.JButton();
        btnAnuncioGeneral = new javax.swing.JButton();
        btnComunicado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsUsuarios = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mbUsuarios = new javax.swing.JMenu();
        mbComunicacion = new javax.swing.JMenu();
        mbChats = new javax.swing.JMenuItem();
        mbAdministrador = new javax.swing.JMenu();
        mbChatsAdministrador = new javax.swing.JMenuItem();
        mbReportes = new javax.swing.JMenuItem();
        mbPagos = new javax.swing.JMenu();
        mbInmuebles = new javax.swing.JMenu();
        mbEspaciosComunes = new javax.swing.JMenu();
        mbCheckIn = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("File");
        jMenuBar5.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar5.add(jMenu10);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnResidentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/chatUsuarios.png"))); // NOI18N

        btnAnuncioGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/altavoz.png"))); // NOI18N

        btnComunicado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/trabajadores.png"))); // NOI18N

        lsUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lsUsuarios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lsUsuarios.setMinimumSize(new java.awt.Dimension(46, 150));
        jScrollPane1.setViewportView(lsUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnResidentes)
                        .addGap(27, 27, 27)
                        .addComponent(btnAnuncioGeneral)
                        .addGap(18, 18, 18)
                        .addComponent(btnComunicado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResidentes)
                    .addComponent(btnAnuncioGeneral)
                    .addComponent(btnComunicado))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 971, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(70, 40));

        mbUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/grupo.png"))); // NOI18N
        mbUsuarios.setText("Usuarios");
        mbUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbUsuarios);

        mbComunicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/grupo.png"))); // NOI18N
        mbComunicacion.setText("Comunicación");
        mbComunicacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mbChats.setText("Chats              ");
        mbChats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbChatsActionPerformed(evt);
            }
        });
        mbComunicacion.add(mbChats);

        mbAdministrador.setText("Administrador");

        mbChatsAdministrador.setText("Chats");
        mbAdministrador.add(mbChatsAdministrador);

        mbReportes.setText("Reportes");
        mbAdministrador.add(mbReportes);

        mbComunicacion.add(mbAdministrador);

        jMenuBar1.add(mbComunicacion);

        mbPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/grupo.png"))); // NOI18N
        mbPagos.setText("Pagos");
        mbPagos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbPagos);

        mbInmuebles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/grupo.png"))); // NOI18N
        mbInmuebles.setText("Inmuebles");
        mbInmuebles.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbInmuebles);

        mbEspaciosComunes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/grupo.png"))); // NOI18N
        mbEspaciosComunes.setText("Espacios Comunes");
        mbEspaciosComunes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbEspaciosComunes);

        mbCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenescomunicacion/grupo.png"))); // NOI18N
        mbCheckIn.setText("Check-In");
        mbCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbCheckIn);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mbChatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbChatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbChatsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * FjpUsuariosils see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMensaje().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAnuncioGeneral;
    public javax.swing.JButton btnComunicado;
    public javax.swing.JButton btnResidentes;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JList<String> lsUsuarios;
    private javax.swing.JMenu mbAdministrador;
    public javax.swing.JMenuItem mbChats;
    private javax.swing.JMenuItem mbChatsAdministrador;
    public javax.swing.JMenu mbCheckIn;
    public javax.swing.JMenu mbComunicacion;
    public javax.swing.JMenu mbEspaciosComunes;
    public javax.swing.JMenu mbInmuebles;
    public javax.swing.JMenu mbPagos;
    private javax.swing.JMenuItem mbReportes;
    public javax.swing.JMenu mbUsuarios;
    // End of variables declaration//GEN-END:variables
}
