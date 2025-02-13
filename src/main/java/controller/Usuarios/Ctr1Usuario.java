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
import model.Usuarios.Rol;
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
        frmConP.btnEliminarUsuario.addActionListener(this);

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
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña no coincide");
            }
            u.setFechaContrato(frmConP.jDateChooser1.getDate());
            String rolSeleccionado = (String) frmConP.comboRolUsuario.getSelectedItem();
            int idRol = 0;
            
            switch (rolSeleccionado) {
                case "Residente" -> idRol = 1;
                case "Administrador" -> idRol = 2;
                case "Limpieza" -> idRol = 3;
                case "Mantenimiento" -> idRol = 4;
                case "Guardia" -> idRol = 5;
                default -> throw new IllegalArgumentException("Rol desconocido: " + rolSeleccionado);
            }
            u.setRol(new Rol(idRol, rolSeleccionado));

            if (rolSeleccionado.equals("Residente")) {
                u.setSalario(0);
                u.setFechaContrato(null);
            }else{
                u.setSalario(Double.parseDouble(frmConP.txtSueldo.getText()));
                u.setFechaContrato(frmConP.jDateChooser1.getDate());
            }

            if (dbu.guardar(u)) {
                JOptionPane.showMessageDialog(null, "Usuario Guardado");
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar ");
                //limpiar();
            }

        }

        if (e.getSource() == frmConP.btnEliminarUsuario) {
            u.setCedula(frmConP.txtCedulaUsuario.getText().trim());
            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro de que desea eliminar al usuario con cédula " + u.getCedula() + "?",
                    "Confirmación de eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                if (dbu.eliminar(u)) {
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un problema al eliminar el usuario.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
            }

        }
    }
}
