/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conexion;
import model.ModelRecuperacion;
import view.FrmUsuarioLogin;

/**
 *
 * @author LENOVO.USER
 */
public class CtrUsuarioRecuperarPass implements ActionListener{

    private FrmUsuarioLogin frmUserLogin;
    public String cedula;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public ResultSet RecuperacionCorreo(){
        ModelRecuperacion recu = new ModelRecuperacion();
        return recu.RecuperacionCorreo(cedula);
    }
    
    public boolean actualizarContrasena(String nuevaContrasena) {
        Connection con = Conexion.getInstance(); // Asegúrate de tener tu clase de conexión
        String sql = "UPDATE Usuario SET contrasenia = ? WHERE cedula = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, hashearContrasena(nuevaContrasena)); // Guardar con hash SHA-256
            ps.setString(2, cedula);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se actualizó la contraseña
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
    
    //Verifica que la contraseña este encriptada
    public String obtenerContrasena(String cedula) {
     Connection conn = Conexion.getInstance();
    String contrasena = null;
    String sql = "SELECT contrasenia FROM Usuario WHERE cedula = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, cedula);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            contrasena = rs.getString("contrasenia");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return contrasena;
}



    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
