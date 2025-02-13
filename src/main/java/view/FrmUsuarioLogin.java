/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CtrLogin;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class FrmUsuarioLogin extends javax.swing.JFrame {
    
    FrmUsuarioRecuperarPass frmPass = new FrmUsuarioRecuperarPass();
    /**
     * Creates new form Inicial
     */
    public FrmUsuarioLogin() {
        initComponents();
    }
    
    private int intentos = 0;
    private static final int MAX_INTENTOS = 3;
    
    public void loginUsuario(){
            String user = txtNombreUser.getText().trim();
            String pass = txtContrasena.getText().trim();
            
            //Instancear controlador
            CtrLogin login = new CtrLogin();
            frmMenuBar frmConP = new frmMenuBar();   
            if(user.isEmpty() || pass.isEmpty()){
                intentos++;
                JOptionPane.showMessageDialog(null, "Ingrese un usuario y/o contraseña. Intento "+intentos+" de "+MAX_INTENTOS);
                txtNombreUser.setText("");
                txtContrasena.setText("");
                
            }else if(login.loginUsuario(user, pass)){
                JOptionPane.showMessageDialog(null, "Bienvenido");
                intentos = 0;
                frmConP.setVisible(true);
                this.dispose();      
            }else{
                intentos++;
                JOptionPane.showMessageDialog(null, "El usuario no existe. Intento " + intentos+ " de " + MAX_INTENTOS);
                txtNombreUser.setText("");
                txtContrasena.setText("");
            }         
            if(intentos >= MAX_INTENTOS){
                JOptionPane.showMessageDialog(null, "Demasiados intentos fallidos, el sistema se cerrará");
                System.exit(0);
            }            
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        txtContrasena = new javax.swing.JPasswordField();
        btnRecuperarPass = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnLogin1 = new javax.swing.JButton();
        txtNombreUser = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        panelLogin1.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin1.setPreferredSize(new java.awt.Dimension(1280, 720));
        panelLogin1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenCondominio.png"))); // NOI18N
        panelLogin1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 770, 720));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenLogo.png"))); // NOI18N
        panelLogin1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, 180));

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel8.setText("contaseña");
        panelLogin1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, 50));

        jLabel9.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel9.setText("LOGIN ");
        panelLogin1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel10.setText("Cédula");
        panelLogin1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));
        panelLogin1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 280, 10));
        panelLogin1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 280, 10));

        txtContrasena.setForeground(new java.awt.Color(204, 204, 204));
        txtContrasena.setBorder(null);
        panelLogin1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 280, 30));

        btnRecuperarPass.setBackground(new java.awt.Color(94, 159, 180));
        btnRecuperarPass.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnRecuperarPass.setForeground(new java.awt.Color(255, 255, 255));
        btnRecuperarPass.setText("reCUPERAR CONTRASEÑA");
        btnRecuperarPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecuperarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarPassActionPerformed(evt);
            }
        });
        panelLogin1.add(btnRecuperarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, 200, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenCandado.png"))); // NOI18N
        panelLogin1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenUsuario.png"))); // NOI18N
        panelLogin1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, -1));

        btnLogin1.setBackground(new java.awt.Color(94, 159, 180));
        btnLogin1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin1.setText("ENTRAR");
        btnLogin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        panelLogin1.add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 160, 40));

        txtNombreUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNombreUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUserActionPerformed(evt);
            }
        });
        panelLogin1.add(txtNombreUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 280, 30));

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

    private void btnRecuperarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarPassActionPerformed
        
        if (frmPass == null) {
            frmPass = new FrmUsuarioRecuperarPass(); // Pass the reference when needed
        }
        frmPass.setVisible(true);
    }//GEN-LAST:event_btnRecuperarPassActionPerformed

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
       loginUsuario();
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void txtNombreUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUserActionPerformed
        
    }//GEN-LAST:event_txtNombreUserActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUsuarioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuarioLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLogin1;
    public javax.swing.JButton btnRecuperarPass;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelLogin1;
    private javax.swing.JPasswordField txtContrasena;
    private java.awt.TextField txtNombreUser;
    // End of variables declaration//GEN-END:variables
}
