/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.comunicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author manue
 */
public class FrmMensajeAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FrmMensaje
     */
    public FrmMensajeAdmin() {
        setTitle("Chats Administrador");
        initComponents();
        configurarBoton();
        personalizarMenu();
        configurarScrollPane();
        configurarPanelMensajes();

        // Establecer el tamaño de la ventana a 800x600 píxeles
        this.setSize(1280, 720);

        // Evitar que la ventana sea redimensionable
        this.setResizable(false);

        //datos de prueba
        agregarAnuncio("Bienvenido al sistema de anuncios.");
        agregarAnuncio("Bienvenido al sistema de anuncios.");

        agregarComunicado("Bienvenido al sistema de anuncios.");
        agregarComunicado("Bienvenido al sistema de anuncios.");

    }

    private void configurarBoton() {
        // Quita el fondo y el borde para que solo se vea la imagen
        btnEnviarAnuncioGeneral.setContentAreaFilled(false);
        btnEnviarAnuncioGeneral.setBorderPainted(false);
        btnEnviarAnuncioGeneral.setFocusPainted(false);

        btnEnviarComunicado.setContentAreaFilled(false);
        btnEnviarComunicado.setBorderPainted(false);
        btnEnviarComunicado.setFocusPainted(false);

        // Efecto visual al presionar el botón
        btnEnviarAnuncioGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEnviarAnuncioGeneral.setOpaque(true);
                btnEnviarAnuncioGeneral.setBackground(new java.awt.Color(200, 200, 200));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEnviarAnuncioGeneral.setOpaque(false);
                btnEnviarAnuncioGeneral.setBackground(null);
            }
        });

        btnEnviarComunicado.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEnviarComunicado.setOpaque(true);
                btnEnviarComunicado.setBackground(new java.awt.Color(200, 200, 200));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEnviarComunicado.setOpaque(false);
                btnEnviarComunicado.setBackground(null);
            }
        });

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

    private void configurarScrollPane() {
        // Para el jScrollPaneAnuncio
        jScrollPaneAnuncio.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPaneAnuncio.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Para el jScrollPaneComunicado
        jScrollPaneComunicado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPaneComunicado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    }

    private void configurarPanelMensajes() {
        // Configurar el panel que contendrá los mensajes
        jPanelAnuncio.setLayout(new BoxLayout(jPanelAnuncio, BoxLayout.Y_AXIS));
        jPanelAnuncio.setBackground(Color.WHITE);
        jPanelComunicado.setLayout(new BoxLayout(jPanelComunicado, BoxLayout.Y_AXIS));
        jPanelComunicado.setBackground(Color.WHITE);

        // Agregar el panel a un JScrollPane
        jScrollPaneAnuncio.setViewportView(jPanelAnuncio);
        jScrollPaneAnuncio.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPaneComunicado.setViewportView(jPanelComunicado);
        jScrollPaneComunicado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void agregarAnuncio(String mensaje) {
        JPanel panelAnuncio = new JPanel(new BorderLayout()); // Usamos BorderLayout en el contenedor principal
        panelAnuncio.setBackground(Color.WHITE);

        // Ajustar tamaño de panel de anuncio para que se adapte al contenido
        panelAnuncio.setMaximumSize(new Dimension(jPanelAnuncio.getWidth(), 50));

        // Panel para el mensaje (alineado a la izquierda)
        JPanel panelMensaje = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelMensaje.setBackground(Color.WHITE);

        JLabel lblMensaje = new JLabel(mensaje);
        JTextField txtEditar = new JTextField(mensaje, 20);
        txtEditar.setVisible(false);

        // Icono de los tres puntos
        ImageIcon iconoOpciones = new ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/tres-puntos.png"));
        JLabel lblIcono = new JLabel(iconoOpciones);

        // Menú emergente
        JPopupMenu menuOpciones = new JPopupMenu();
        JMenuItem opcionEditar = new JMenuItem("Editar");
        JMenuItem opcionEliminar = new JMenuItem("Eliminar");

        menuOpciones.add(opcionEditar);
        menuOpciones.add(opcionEliminar);

        // Mostrar menú al hacer clic en los tres puntos
        lblIcono.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuOpciones.show(lblIcono, e.getX(), e.getY());
            }
        });

        // Acción para editar
        opcionEditar.addActionListener(e -> {
            lblMensaje.setVisible(false);
            txtEditar.setVisible(true);
            txtEditar.requestFocus();
        });

        // Guardar edición al presionar Enter
        txtEditar.addActionListener(e -> {
            lblMensaje.setText(txtEditar.getText());
            lblMensaje.setVisible(true);
            txtEditar.setVisible(false);
        });

        // Acción para eliminar
        opcionEliminar.addActionListener(e -> {
            jPanelAnuncio.remove(panelAnuncio);
            jPanelAnuncio.revalidate();
            jPanelAnuncio.repaint();
        });

        // Agregar elementos
        panelMensaje.add(lblMensaje);
        panelMensaje.add(txtEditar);

        panelAnuncio.add(panelMensaje, BorderLayout.WEST); // Mensaje a la izquierda
        panelAnuncio.add(lblIcono, BorderLayout.EAST); // Icono a la derecha

        jPanelAnuncio.add(panelAnuncio);
        jPanelAnuncio.revalidate();
        jPanelAnuncio.repaint();

    }

    private void agregarComunicado(String mensaje) {
        JPanel panelComunicado = new JPanel(new BorderLayout()); // Contenedor principal con BorderLayout
        panelComunicado.setBackground(Color.WHITE); // Color diferente para distinguirlo
        panelComunicado.setMaximumSize(new Dimension(jPanelComunicado.getWidth(), 50)); // Tamaño ajustado

        // Panel para el mensaje (alineado a la izquierda)
        JPanel panelMensaje = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelMensaje.setBackground(Color.WHITE);

        JLabel lblMensaje = new JLabel(mensaje);
        JTextField txtEditar = new JTextField(mensaje, 20);
        txtEditar.setVisible(false);

        // Icono de los tres puntos
        ImageIcon iconoOpciones = new ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/tres-puntos.png"));
        JLabel lblIcono = new JLabel(iconoOpciones);

        // Menú emergente
        JPopupMenu menuOpciones = new JPopupMenu();
        JMenuItem opcionEditar = new JMenuItem("Editar");
        JMenuItem opcionEliminar = new JMenuItem("Eliminar");

        menuOpciones.add(opcionEditar);
        menuOpciones.add(opcionEliminar);

        // Mostrar menú al hacer clic en los tres puntos
        lblIcono.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuOpciones.show(lblIcono, e.getX(), e.getY());
            }
        });

        // Acción para editar
        opcionEditar.addActionListener(e -> {
            lblMensaje.setVisible(false);
            txtEditar.setVisible(true);
            txtEditar.requestFocus();
        });

        // Guardar edición al presionar Enter
        txtEditar.addActionListener(e -> {
            lblMensaje.setText(txtEditar.getText());
            lblMensaje.setVisible(true);
            txtEditar.setVisible(false);
        });

        // Acción para eliminar
        opcionEliminar.addActionListener(e -> {
            jPanelComunicado.remove(panelComunicado);
            jPanelComunicado.revalidate();
            jPanelComunicado.repaint();
        });

        // Agregar elementos
        panelMensaje.add(lblMensaje);
        panelMensaje.add(txtEditar);

        panelComunicado.add(panelMensaje, BorderLayout.WEST); // Mensaje a la izquierda
        panelComunicado.add(lblIcono, BorderLayout.EAST); // Icono a la derecha

        jPanelComunicado.add(panelComunicado);
        jPanelComunicado.revalidate();
        jPanelComunicado.repaint();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAnuncioGeneral = new javax.swing.JTextField();
        txtComunicadoEmpleados = new javax.swing.JTextField();
        btnEnviarAnuncioGeneral = new javax.swing.JButton();
        btnEnviarComunicado = new javax.swing.JButton();
        jScrollPaneAnuncio = new javax.swing.JScrollPane();
        jPanelAnuncio = new javax.swing.JPanel();
        jScrollPaneComunicado = new javax.swing.JScrollPane();
        jPanelComunicado = new javax.swing.JPanel();
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Anuncio General");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Comunicado Empleados");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/trabajadores.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/altavoz.png"))); // NOI18N

        txtAnuncioGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtComunicadoEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnEnviarAnuncioGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/mensaje.png"))); // NOI18N

        btnEnviarComunicado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/mensaje.png"))); // NOI18N
        btnEnviarComunicado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarComunicadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAnuncioLayout = new javax.swing.GroupLayout(jPanelAnuncio);
        jPanelAnuncio.setLayout(jPanelAnuncioLayout);
        jPanelAnuncioLayout.setHorizontalGroup(
            jPanelAnuncioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );
        jPanelAnuncioLayout.setVerticalGroup(
            jPanelAnuncioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        jScrollPaneAnuncio.setViewportView(jPanelAnuncio);

        javax.swing.GroupLayout jPanelComunicadoLayout = new javax.swing.GroupLayout(jPanelComunicado);
        jPanelComunicado.setLayout(jPanelComunicadoLayout);
        jPanelComunicadoLayout.setHorizontalGroup(
            jPanelComunicadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );
        jPanelComunicadoLayout.setVerticalGroup(
            jPanelComunicadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        jScrollPaneComunicado.setViewportView(jPanelComunicado);

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(70, 40));

        mbUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/grupo.png"))); // NOI18N
        mbUsuarios.setText("Usuarios");
        mbUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbUsuarios);

        mbComunicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/grupo.png"))); // NOI18N
        mbComunicacion.setText("Comunicación");
        mbComunicacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mbChats.setText("Chats              ");
        mbChats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbChatsActionPerformed(evt);
            }
        });
        mbComunicacion.add(mbChats);

        mbAdministrador.setBackground(new java.awt.Color(0, 0, 0));
        mbAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        mbAdministrador.setText("Administrador");

        mbChatsAdministrador.setText("Chats");
        mbAdministrador.add(mbChatsAdministrador);

        mbReportes.setText("Reportes");
        mbAdministrador.add(mbReportes);

        mbComunicacion.add(mbAdministrador);

        jMenuBar1.add(mbComunicacion);

        mbPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/grupo.png"))); // NOI18N
        mbPagos.setText("Pagos");
        mbPagos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbPagos);

        mbInmuebles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/grupo.png"))); // NOI18N
        mbInmuebles.setText("Inmuebles");
        mbInmuebles.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbInmuebles);

        mbEspaciosComunes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/grupo.png"))); // NOI18N
        mbEspaciosComunes.setText("Espacios Comunes");
        mbEspaciosComunes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbEspaciosComunes);

        mbCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/grupo.png"))); // NOI18N
        mbCheckIn.setText("Check-In");
        mbCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(mbCheckIn);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(299, 299, 299))))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneAnuncio)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtAnuncioGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviarAnuncioGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(177, 177, 177)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtComunicadoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviarComunicado, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneComunicado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneComunicado, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneAnuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnuncioGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarAnuncioGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComunicadoEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarComunicado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mbChatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbChatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbChatsActionPerformed

    private void btnEnviarComunicadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarComunicadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarComunicadoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMensajeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMensajeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMensajeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMensajeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMensajeAdmin().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEnviarAnuncioGeneral;
    public javax.swing.JButton btnEnviarComunicado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    public javax.swing.JPanel jPanelAnuncio;
    public javax.swing.JPanel jPanelComunicado;
    private javax.swing.JScrollPane jScrollPaneAnuncio;
    private javax.swing.JScrollPane jScrollPaneComunicado;
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
    public javax.swing.JTextField txtAnuncioGeneral;
    public javax.swing.JTextField txtComunicadoEmpleados;
    // End of variables declaration//GEN-END:variables
}
