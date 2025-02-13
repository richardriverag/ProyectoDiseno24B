/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        Conexion conn = new Conexion();
        ModelRecuperacion recu = new ModelRecuperacion();
        return recu.RecuperacionCorreo(cedula);
    }
    public boolean actualizarContrasena(String nuevaContrasena) {
        Connection con = Conexion.getInstance(); 
        String sql = "UPDATE usuario SET contrasenia = ? WHERE cedula = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Almacenamos la contraseña directamente sin encriptarla
            ps.setString(1, nuevaContrasena); // Guarda la contraseña directamente
            ps.setString(2, cedula); // Usa la cédula del usuario para encontrar el registro

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se actualizó la contraseña
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String obtenerContrasena(String cedula) {
     Connection conn = Conexion.getInstance();
    String contrasena = null;
    String sql = "SELECT contrasenia FROM usuario WHERE cedula = ?";
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
