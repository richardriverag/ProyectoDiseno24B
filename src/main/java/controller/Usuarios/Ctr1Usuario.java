/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Usuarios;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Usuarios.DbUsuario;
import model.Usuarios.Usuario;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class Ctr1Usuario implements ActionListener {

    private frmMenuBar frmConP;
    private Usuario u = new Usuario();
    private DbUsuario dbu = new DbUsuario();

    public Ctr1Usuario(frmMenuBar frmConP, Usuario u, DbUsuario dbu) {
        this.frmConP = frmConP;
        this.u = u;
        this.dbu = dbu;
    }

    public void iniciar() {
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        cardLayout.show(frmConP.PanelPrincipal, "card3");  // PanelGuardar
        System.out.println("Menu Item1 usuarios funcionando");

        frmConP.btnCrearUsuario.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmConP.btnCrearUsuario) {
            u.setCedula(frmConP.txtCedulaUsuario.getText().trim());
            u.setNombre(frmConP.txtNombreUsuario.getText());
            u.setCorreo(frmConP.txtCorreoUsuario.getText());
            u.setTelefono(frmConP.txtTelefonoUsuario.getText());
            if (String.valueOf(frmConP.txtPassUsuario.getPassword())
                    .equals(String.valueOf(frmConP.txtPassConfirmarUsuario.getPassword()))) {

                u.setCedula(String.valueOf(frmConP.txtPassUsuario.getPassword()));
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña no coincide");
            }
            u.setFechaContratacion(frmConP.jDateChooser1.getDate());
            String rolSeleccionado = (String) frmConP.comboRolUsuario.getSelectedItem();
            u.setRol(rolSeleccionado);
            
            if(rolSeleccionado.equals("Residente")){
                u.setSalario(0);
                u.setFechaContratacion(null);
            }else{
                u.setSalario(Double.parseDouble(frmConP.txtSueldo.getText()));
                u.setFechaContratacion(frmConP.jDateChooser1.getDate());
            }
            
            if(dbu.guardar(u)){
               JOptionPane.showMessageDialog(null, "Usuario Guardado");
                //limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar ");
                //limpiar();
            }

        }
    }
}
