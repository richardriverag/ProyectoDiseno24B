/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Usuarios;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import model.Usuarios.DbUsuario;
import model.Usuarios.RolModel;
import model.Usuarios.Usuario;
import model.Usuarios.UsuarioDAC;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class Ctr1Usuario implements ActionListener {

    private frmMenuBar frmConP;
    private UsuarioDAC u = new UsuarioDAC();
    private DbUsuario dbu = new DbUsuario();

    public Ctr1Usuario(frmMenuBar frmConP, UsuarioDAC u, DbUsuario dbu) {
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
        frmConP.btnBuscarUsuario.addActionListener(this);
        frmConP.btnModificarUsuario.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmConP.btnCrearUsuario) {
            u.setCedula(frmConP.txtCedulaUsuario.getText().trim());
            u.setNombre(frmConP.txtNombreUsuario.getText());
            u.setEmail(frmConP.txtCorreoUsuario.getText());
            u.setCelular(frmConP.txtTelefonoUsuario.getText());
            if (String.valueOf(frmConP.txtPassUsuario.getPassword())
                    .equals(String.valueOf(frmConP.txtPassConfirmarUsuario.getPassword()))) {
                u.setContrasenia(hashearContrasena(String.valueOf(frmConP.txtPassUsuario.getPassword())));
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña no coincide");
                return;
            }
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
            u.setRol(new RolModel(idRol, rolSeleccionado));

            if (rolSeleccionado.equals("Residente") || rolSeleccionado.equals("Administrador")) {
                u.setSalario(0);
                u.setFechaContrato(null);
            }else{
                u.setSalario(Double.parseDouble(frmConP.txtSueldo.getText()));
                u.setFechaContrato(frmConP.jDateChooser1.getDate());
            }

            if (dbu.guardar(u)) {
                JOptionPane.showMessageDialog(null, "Usuario Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar ");
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
        
        if (e.getSource() == frmConP.btnBuscarUsuario) {
            UsuarioDAC usuario = dbu.buscar(frmConP.txtCedulaUsuario.getText().trim());
            if (usuario != null) {
                System.out.println(usuario.getNombre());
                frmConP.txtPassUsuario.setText(usuario.getContrasenia());
                frmConP.txtPassConfirmarUsuario.setText(usuario.getContrasenia());
                frmConP.txtNombreUsuario.setText(usuario.getNombre());
                frmConP.txtCorreoUsuario.setText(usuario.getEmail());
                frmConP.txtTelefonoUsuario.setText(usuario.getCelular());
                frmConP.txtSueldo.setText(String.format("%f",usuario.getSalario()));
                frmConP.jDateChooser1.setDate(usuario.getFechaContrato());
                frmConP.comboRolUsuario.setSelectedItem(usuario.getRol().getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
            }            
        }
        
        
        if (e.getSource() == frmConP.btnModificarUsuario) {
            u.setCedula(frmConP.txtCedulaUsuario.getText().trim());
            u.setNombre(frmConP.txtNombreUsuario.getText());
            u.setEmail(frmConP.txtCorreoUsuario.getText());
            u.setCelular(frmConP.txtTelefonoUsuario.getText());
            if (String.valueOf(frmConP.txtPassUsuario.getPassword())
                    .equals(String.valueOf(frmConP.txtPassConfirmarUsuario.getPassword()))) {
                u.setContrasenia(hashearContrasena(String.valueOf(frmConP.txtPassUsuario.getPassword())));
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña no coincide");
                return;
            }
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
            u.setRol(new RolModel(idRol, rolSeleccionado));

            if (rolSeleccionado.equals("Residente")) {
                u.setSalario(0);
                u.setFechaContrato(null);
            }else{
                u.setSalario(Double.parseDouble(frmConP.txtSueldo.getText()));
                u.setFechaContrato(frmConP.jDateChooser1.getDate());
            }

            if (dbu.modificar(u)) {
                JOptionPane.showMessageDialog(null, "Datos de usuario modificados con éxito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se puedo modificar los datos del usuario ");
            }
        }

    }
    
    public void limpiar() {
        frmConP.txtCedulaUsuario.setText("");
        frmConP.txtPassUsuario.setText("");
        frmConP.txtPassConfirmarUsuario.setText("");
        frmConP.txtNombreUsuario.setText("");
        frmConP.txtCorreoUsuario.setText("");
        frmConP.txtTelefonoUsuario.setText("");
        frmConP.txtSueldo.setText("");
        frmConP.jDateChooser1.setDate(null);
        frmConP.comboRolUsuario.setSelectedItem("Residente");
    }
    
    private String hashearContrasena(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contrasena.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
