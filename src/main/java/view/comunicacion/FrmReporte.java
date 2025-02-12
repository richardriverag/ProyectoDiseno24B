/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.comunicacion;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.*;  // O el tema que prefieras (FlatDarkLaf, FlatIntelliJLaf, etc.)
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author manue
 */
public class FrmReporte extends javax.swing.JFrame {

    /**
     * Creates new form FrmReporte
     */
    public FrmReporte() {
        setTitle("Reportes");

        initComponents();
        configurarBoton();
//        configurarDateChoosers();
        configurarTabla();
        personalizarMenu();

        
        this.setSize(1280, 720);

        // Evitar que la ventana sea redimensionable
        this.setResizable(false);
    }

    private void configurarBoton() {
        // Quita el fondo y el borde para que solo se vea la imagen
        // Configurar el fondo y apariencia inicial
        btnGenerarReporte.setOpaque(true); // Permite que el color de fondo se aplique
        btnGenerarReporte.setContentAreaFilled(true); // Permite ver el fondo
        btnGenerarReporte.setBorderPainted(false);
        btnGenerarReporte.setFocusPainted(false);
        btnGenerarReporte.setBackground(new java.awt.Color(200, 200, 200));

        // Evento para cambiar la apariencia cuando se presiona el botón
        btnGenerarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGenerarReporte.setBackground(new java.awt.Color(180, 180, 180)); // Gris más oscuro al presionar
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGenerarReporte.setBackground(new java.awt.Color(200, 200, 200)); // Vuelve al gris original
            }
        });
    }

//    private void configurarDateChoosers() {
//
//        try {
//            // Aplicar FlatLaf solo para los JDateChooser
//            UIManager.setLookAndFeel(new FlatLightLaf());
//            SwingUtilities.updateComponentTreeUI(jDateChooserInicio);
//            SwingUtilities.updateComponentTreeUI(jDateChooserFinal);
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//        // Crear un ImageIcon con la imagen personalizada (con fondo transparente)
//        ImageIcon iconoCalendario = new ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/calendario2.png"));
//
//        // Cambiar el ícono del botón del calendario
//        jDateChooserInicio.getCalendarButton().setIcon(iconoCalendario);
//        jDateChooserFinal.getCalendarButton().setIcon(iconoCalendario);
//
//        // Eliminar el fondo del JDateChooser
//        jDateChooserInicio.setOpaque(false);
//        jDateChooserFinal.setOpaque(false);
//
//        // Eliminar el borde alrededor del JDateChooser
//        jDateChooserInicio.setBorder(null);
//        jDateChooserFinal.setBorder(null);
//
//        jDateChooserInicio.getCalendarButton().setContentAreaFilled(false);
//        jDateChooserInicio.getCalendarButton().setBorderPainted(false);
//        jDateChooserInicio.getCalendarButton().setFocusPainted(false);
//
//        jDateChooserFinal.getCalendarButton().setContentAreaFilled(false);
//        jDateChooserFinal.getCalendarButton().setBorderPainted(false);
//        jDateChooserFinal.getCalendarButton().setFocusPainted(false);
//    }

    private void configurarTabla() {
        // Personaliza el modelo de la tabla (opcional, según los datos que quieras mostrar)
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Fecha");
        modelo.addColumn("Destinatario");
        modelo.addColumn("Contenido");

        // datos de ejemplo 
        modelo.addRow(new Object[]{"Dato 1", "Dato 2", "Dato 3"});
        modelo.addRow(new Object[]{"Dato 4", "Dato 5", "Dato 6"});

        // Establecer el modelo en la tabla
        tblReportes.setModel(modelo);

        // Personalizar el fondo de las filas alternadas
        tblReportes.setRowSelectionAllowed(true);
        tblReportes.setSelectionBackground(new java.awt.Color(60, 115, 160));

        // Establecer borde en las celdas
        tblReportes.setShowGrid(true);
        tblReportes.setGridColor(new java.awt.Color(200, 200, 200)); // Color de las líneas de la tabla

        // Establecer un fondo de la tabla y del encabezado
        tblReportes.setBackground(new java.awt.Color(255, 255, 255)); // Fondo blanco para la tabla
        tblReportes.getTableHeader().setBackground(new java.awt.Color(100, 150, 200)); // Fondo del encabezado
        tblReportes.getTableHeader().setForeground(new java.awt.Color(255, 255, 255)); // Color de texto del encabezado
        tblReportes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14)); // Fuente del encabezado

        // Establecer el color del texto en las celdas
        tblReportes.setForeground(new java.awt.Color(50, 50, 50)); // Color de texto de las celdas
        tblReportes.setFont(new Font("Segoe UI", Font.PLAIN, 12)); // Fuente de las celdas

        // Configurar el tamaño de las columnas
        tblReportes.getColumnModel().getColumn(0).setPreferredWidth(150);
        tblReportes.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblReportes.getColumnModel().getColumn(2).setPreferredWidth(200);

        // Configurar el alto de las filas
        tblReportes.setRowHeight(30); // Alto de las filas

        // Establecer la opción de ordenación (si es necesario)
        tblReportes.setAutoCreateRowSorter(true);
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

        jMenuBar1.setLayout(new java.awt.GridLayout(1, 2)); // 1 fila, 2 columnas
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReportes = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Fecha Inicio");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Fecha Final");

        btnGenerarReporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenescomunicacion/generarReportes.png"))); // NOI18N
        btnGenerarReporte.setText("Generar Reporte");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235)
                .addComponent(btnGenerarReporte)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnGenerarReporte)))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha", "Destinatario", "Contenido"
            }
        ));
        jScrollPane1.setViewportView(tblReportes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGenerarReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
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
    public javax.swing.JTable tblReportes;
    // End of variables declaration//GEN-END:variables
}
