/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CtrUsuarioRecuperarPass;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author ferkhan
 */
public class FrmUsuarioRecuperarPass extends javax.swing.JFrame {

    String codigoVerificacion;
    FrmUsuarioLogin frmUsuarioLogin ;
    /**
     * Creates new form FrmUsuarioRecuperar
     */
    String clave;
    public FrmUsuarioRecuperarPass() {
        
        this.frmUsuarioLogin = frmUsuarioLogin;
        initComponents();
       
        txtNuevaContrasena.setEnabled(false);
        txtConfirmarContrasena.setEnabled(false);
        btnRecuperar.setEnabled(false);
    }
    
    final void EnviarCorreo(){
        CtrUsuarioRecuperarPass ctrPass  = new CtrUsuarioRecuperarPass(); 
        ctrPass.cedula = txtCedula.getText();
        if (ctrPass.cedula.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa una cédula.");
        return;
        }

        try{
            try {
                ResultSet rs = ctrPass.RecuperacionCorreo();
                if (rs.next()) { // Verifica que hay datos
                    lblCorreoRemitente.setText(rs.getString("email"));
                    
                    System.out.println("Correo encontrado: " + lblCorreoRemitente.getText());
                    //System.out.println("Contraseña recuperada: " + clave);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un usuario con esa cédula.");
                    return; 
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al capturar los datos: " + e.getMessage());
            }
            
            // Generar código de verificación de 6 dígitos
            codigoVerificacion = generarCodigoVerificacion();
            System.out.println("Código generado: " + codigoVerificacion);
            
            Properties props = new Properties() ;
            props.put("mail.smtp.host", "smtp.gmail.com"); // O el host de tu servidor SMTP
            props.put("mail.smtp.auth", "true"); // Habilitar autenticación
            props.put("mail.smtp.starttls.enable", "true"); // Habilitar TLS
            props.put("mail.smtp.port", "587"); // Puerto SMTP (587 es común para TLS)
            
            //props.put("mail.debug", "true");
            //System.out.println(".....");
            //Email por el que se va mandar las verificaciones, importante que el pass sea una contraseña temporal de "contraseñas de aplicación"
   
            String correoRemitente = "sistemaunificadocondominio@gmail.com";
            String passRemitente = "wduhuteghuhcvxwv";
            
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    System.out.println(".-.-.-.-");
                    return new javax.mail.PasswordAuthentication(correoRemitente, passRemitente);    
                }
            });

            try {
                String correoReceptor = lblCorreoRemitente.getText();
                String asunto = "Recuperación de contraseña";
                String mensaje = "Tu código de recuperación es: " + codigoVerificacion;

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correoRemitente));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
                message.setSubject(asunto);
                message.setText(mensaje);
                Transport.send(message);
                JOptionPane.showMessageDialog(null, "Código de verificación enviado al correo");
            } catch (Exception e) {
                e.printStackTrace();  // Captura el error si ocurre
                 JOptionPane.showMessageDialog(null, "Error al enviar el correo: " + e.getMessage());
            }
        }catch(Exception e){
            System.out.println("error "+ e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al recuperar el correo: " + e.getMessage());
        }
    }
     private String generarCodigoVerificacion() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000); // Genera un número de 6 dígitos
        return String.valueOf(codigo);
    }

    // Método para verificar el código ingresado por el usuario
    public boolean validarCodigo(String codigoIngresado) {
        return codigoVerificacion != null && codigoVerificacion.equals(codigoIngresado);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        txtConfirmarContrasena = new javax.swing.JPasswordField();
        btnRecuperar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodValidacion = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        btnValidarCorreo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        txtNuevaContrasena = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtContrasena2 = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblCorreoRemitente = new java.awt.Label();
        btnVerificar = new java.awt.Button();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin1.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenCondominio.png"))); // NOI18N
        panelLogin1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 770, 720));

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel8.setText("CONFIRMAR contRaseña");
        panelLogin1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, 50));

        jLabel9.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel9.setText("recuperar contraseña");
        panelLogin1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, 50));

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel10.setText("Cédula");
        panelLogin1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        txtCedula.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(204, 204, 204));
        txtCedula.setBorder(null);
        panelLogin1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 280, 30));
        panelLogin1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 280, 10));
        panelLogin1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 280, 10));

        txtConfirmarContrasena.setForeground(new java.awt.Color(204, 204, 204));
        txtConfirmarContrasena.setBorder(null);
        panelLogin1.add(txtConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 280, 30));

        btnRecuperar.setBackground(new java.awt.Color(94, 159, 180));
        btnRecuperar.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnRecuperar.setForeground(new java.awt.Color(255, 255, 255));
        btnRecuperar.setText("RECUPERAR CONTRASEÑA");
        btnRecuperar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });
        panelLogin1.add(btnRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, -1, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenCandado.png"))); // NOI18N
        panelLogin1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenUsuario.png"))); // NOI18N
        panelLogin1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jLabel13.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel13.setText("código de validación");
        panelLogin1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, 30));

        txtCodValidacion.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        txtCodValidacion.setForeground(new java.awt.Color(204, 204, 204));
        txtCodValidacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCodValidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodValidacionActionPerformed(evt);
            }
        });
        panelLogin1.add(txtCodValidacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 280, 30));
        panelLogin1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 280, 10));

        jLabel14.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel14.setText("nUEVA contaseña");
        panelLogin1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, 50));

        btnValidarCorreo.setBackground(new java.awt.Color(94, 159, 180));
        btnValidarCorreo.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnValidarCorreo.setForeground(new java.awt.Color(255, 255, 255));
        btnValidarCorreo.setText("Enviar ");
        btnValidarCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnValidarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarCorreoActionPerformed(evt);
            }
        });
        panelLogin1.add(btnValidarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 160, 40));
        panelLogin1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 280, 10));

        txtNuevaContrasena.setForeground(new java.awt.Color(204, 204, 204));
        txtNuevaContrasena.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLogin1.add(txtNuevaContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 280, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenCandado.png"))); // NOI18N
        panelLogin1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, -1));
        panelLogin1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 280, 10));

        txtContrasena2.setForeground(new java.awt.Color(204, 204, 204));
        txtContrasena2.setText("jPasswordField1");
        txtContrasena2.setBorder(null);
        panelLogin1.add(txtContrasena2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 280, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenCandado.png"))); // NOI18N
        panelLogin1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenUsuario.png"))); // NOI18N
        panelLogin1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        lblCorreoRemitente.setBackground(new java.awt.Color(204, 204, 255));
        panelLogin1.add(lblCorreoRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 280, 30));

        btnVerificar.setBackground(new java.awt.Color(94, 159, 180));
        btnVerificar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnVerificar.setForeground(new java.awt.Color(255, 255, 255));
        btnVerificar.setLabel("Validar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        panelLogin1.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 140, 30));
        btnVerificar.getAccessibleContext().setAccessibleName("Validar");

        btnSalir.setBackground(new java.awt.Color(94, 159, 180));
        btnSalir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelLogin1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 670, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean actualizarContrasena(String nuevaContrasena) {
        try {
            CtrUsuarioRecuperarPass ctrPass = new CtrUsuarioRecuperarPass();
            ctrPass.cedula = txtCedula.getText();
            return ctrPass.actualizarContrasena(nuevaContrasena);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        String nuevaContrasena = new String(txtNuevaContrasena.getPassword());
        String confirmarContrasena = new String(txtConfirmarContrasena.getPassword());

    if (nuevaContrasena.isEmpty() || confirmarContrasena.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, llena todos los campos.");
        return;
    }

    if (!nuevaContrasena.equals(confirmarContrasena)) {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
        return;
    }

    if (actualizarContrasena(nuevaContrasena)) {
        JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente.");
        this.dispose();
        if (frmUsuarioLogin == null) {
            frmUsuarioLogin = new FrmUsuarioLogin(); // Asegúrate de que la instancia no sea nula
        }
        frmUsuarioLogin.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña.");
    }

    }//GEN-LAST:event_btnRecuperarActionPerformed

    private void btnValidarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarCorreoActionPerformed
        EnviarCorreo();
    }//GEN-LAST:event_btnValidarCorreoActionPerformed

    private void txtCodValidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodValidacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodValidacionActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        String codigoIngresado = txtCodValidacion.getText().trim();

    if (codigoIngresado.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa el código de verificación.");
        return;
    }

    if (validarCodigo(codigoIngresado)) {
        JOptionPane.showMessageDialog(null, "Código correcto. Ahora puedes restablecer tu contraseña.");
   
        txtCedula.setEditable(false);
        txtNuevaContrasena.setEnabled(true);
        txtConfirmarContrasena.setEnabled(true);
        btnRecuperar.setEnabled(true);
        // Aquí puedes redirigir al usuario a una nueva ventana para cambiar la contraseña
        
    } else {
        JOptionPane.showMessageDialog(null, "Código incorrecto. Inténtalo de nuevo.");
    }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (frmUsuarioLogin == null) {
            frmUsuarioLogin = new FrmUsuarioLogin(); // Asegúrate de que la instancia no sea nula
        }
        frmUsuarioLogin.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUsuarioRecuperarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarioRecuperarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarioRecuperarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarioRecuperarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmUsuarioRecuperarPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecuperar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnValidarCorreo;
    private java.awt.Button btnVerificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private java.awt.Label lblCorreoRemitente;
    private javax.swing.JPanel panelLogin1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodValidacion;
    private javax.swing.JPasswordField txtConfirmarContrasena;
    private javax.swing.JPasswordField txtContrasena2;
    private javax.swing.JPasswordField txtNuevaContrasena;
    // End of variables declaration//GEN-END:variables
}
