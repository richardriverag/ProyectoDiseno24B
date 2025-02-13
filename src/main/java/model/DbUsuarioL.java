/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuarios.RolModel;
import model.Usuarios.Usuario;

/**
 *
 * @author LENOVO.USER
 */
public class DbUsuarioL {
    //no me muevan la clase porfa, o denme metiendo esta DB en la otra jajaja
    private Connection conn = new Conexion().getInstance();
  
    
    public boolean loginUsuario(String user, String password){
        Usuario usuario = Usuario.getInstance();
        PreparedStatement stmt = null;
        ResultSet rs = null;

    try {
        String sql = "SELECT * FROM Usuario u JOIN Roles r ON u.rol_id = r.id WHERE TRIM(email) = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);
        rs = stmt.executeQuery();

        // Verificar si el usuario existe
        if (rs.next()) {
            String hashAlmacenado = rs.getString("contrasenia"); // Obtener el hash almacenado
            String hashIngresado = hashearContrasena(password); // Hashear la contraseña ingresada
            System.out.println(hashIngresado);
            if (hashAlmacenado.equalsIgnoreCase(hashIngresado)) { // Comparar los hashes
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setSalario(rs.getDouble("salario"));

                java.sql.Date fechaContratoSQL = rs.getDate("fecha_contrato");
                if (fechaContratoSQL != null) {
                    usuario.setFechaContrato(new java.util.Date(fechaContratoSQL.getTime()));
                }
                RolModel rol = new RolModel(rs.getInt("rol_id"), rs.getString("r.nombre"));
                usuario.setRol(rol);
            }
        }
        System.out.println(usuario.getRol().getNombre());
        return true;
    } catch (Exception e) {
        System.out.println(e);
    }
    return false;
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
