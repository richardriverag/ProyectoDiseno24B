/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Reservas;

import com.toedter.calendar.JDateChooser;
import model.ReservaEspacioDAO;
import com.toedter.calendar.JDateChooser;
import controller.Reservas.CtrReserva;
import model.ReservaEspacioDAO;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conexion;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author jerem
 */
public class FrmCancelarReserva extends javax.swing.JFrame {

    /**
     * Creates new form FrmCancelarReserva
     */
    public FrmCancelarReserva() {
        initComponents();
        setTitle("Cancelar Reservas");
        this.setSize(1280, 720);
        this.setResizable(false);
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.getDateEditor().setEnabled(false); // Bloquea la escritura manual
        JDateChooser jDateChooser1 = new JDateChooser(); 
    
        // Cargar datos en la tabla
        //cargarReservasEnTabla();
    }
    
        // Método para cargar las reservas en la jTable1
        private void cargarReservasEnTabla(String fechaSeleccionada) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de insertar datos

    String sql;
    boolean filtrarPorFecha = fechaSeleccionada != null && !fechaSeleccionada.isEmpty();

    if (filtrarPorFecha) {
        sql = "SELECT espacio_id, fecha, CONCAT(hora_inicio, ' - ', hora_fin) AS horario " +
              "FROM ReservaEspacio WHERE fecha = ?";
    } else {
        sql = "SELECT espacio_id, fecha, CONCAT(hora_inicio, ' - ', hora_fin) AS horario FROM ReservaEspacio";
    }

    try (Connection conn = Conexion.getInstance();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        if (filtrarPorFecha) {
            pstmt.setString(1, fechaSeleccionada); // Asigna la fecha ingresada por el usuario
        }

        try (ResultSet rs = pstmt.executeQuery()) {
            boolean hayRegistros = false;
            
            while (rs.next()) {
                int espacioId = rs.getInt("espacio_id");
                String fecha = rs.getString("fecha");
                String horario = rs.getString("horario");
                String nombreEspacio = obtenerNombreEspacio(espacioId);

                model.addRow(new Object[]{fecha, horario, nombreEspacio});
                hayRegistros = true;
            }

            // Si no hay registros para la fecha ingresada, cargar todas las reservas
            if (!hayRegistros && filtrarPorFecha) {
                cargarReservasEnTabla(null); // Cargar todas las reservas
            }

        }
    } catch (SQLException e) {
        System.err.println("Error al cargar las reservas en la tabla: " + e.getMessage());
    }
    
        }
        
        
private Object[] obtenerReservaSeleccionada() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada != -1) { // Si hay una fila seleccionada
        return new Object[]{
            jTable1.getValueAt(filaSeleccionada, 0), // Fecha
            jTable1.getValueAt(filaSeleccionada, 1), // Horario
            jTable1.getValueAt(filaSeleccionada, 2)  // Espacio
        };
    } else {
        return null;
    }
}

private void eliminarReservaSeleccionada() {
    int filaSeleccionada = jTable1.getSelectedRow();
    
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una reserva para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que quiere eliminar esta reserva?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        try (Connection conn = Conexion.getInstance()) { 
            // Verificación de conexión
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos");
            } else {
                System.out.println("Conexión fallida");
                return; // Si no hay conexión, no continuar
            }

            // Modificamos la consulta para que solo elimine por la fecha
            String sql = "DELETE FROM reservas WHERE fecha = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Asignamos el valor de la fecha de la fila seleccionada
                stmt.setObject(1, jTable1.getValueAt(filaSeleccionada, 0)); // Fecha
                
                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Reserva eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Refrescar la tabla después de eliminar la reserva
                    // actualizarTabla(); // Método para refrescar los datos de la tabla
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la reserva en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1268, 653));

        jDateChooser1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDateChooser1.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione una fecha ");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenesEspaciosComunes/calendario.png"))); // NOI18N

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Área"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenesEspaciosComunes/edificios.png"))); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 102, 255));

        jButton1.setBackground(new java.awt.Color(94, 159, 180));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(94, 159, 180));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jButton2.setText("Cancelar Reserva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(360, 360, 360)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(667, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(535, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // Obtener la fecha seleccionada
        Date fechaSeleccionada = jDateChooser1.getDate();

        if (fechaSeleccionada != null) {
            // Formatear la fecha a "yyyy-MM-dd"
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = formato.format(fechaSeleccionada);

            System.out.println("Fecha seleccionada: " + fechaFormateada);
            cargarReservasEnTabla(fechaFormateada);
        } else {
            System.out.println("No se ha seleccionado ninguna fecha.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
eliminarReservaSeleccionada();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCancelarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCancelarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCancelarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCancelarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCancelarReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private String obtenerNombreEspacio(int espacioId) {
        switch (espacioId) {
        case 1: return "Piscina";
        case 2: return "Barbacoa";
        case 3: return "Gimnasio";
        case 4: return "Canchas";
        case 5: return "Salón";
        default: return "Desconocido";
    }
    }

}
