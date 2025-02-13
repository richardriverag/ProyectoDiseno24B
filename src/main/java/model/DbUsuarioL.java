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
import model.Usuarios.Usuario;

/**
 *
 * @author LENOVO.USER
 */
public class DbUsuarioL {
    //no me muevan la clase porfa, o denme metiendo esta DB en la otra jajaja
    private Connection conn = new Conexion().getInstance();
  
    
    public Usuario loginUsuario(String user, String password){
        Usuario usuario = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        String sql = "SELECT * FROM usuario WHERE TRIM(email) = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);
        rs = stmt.executeQuery();

        // Verificar si el usuario existe
        if (rs.next()) {
            String hashAlmacenado = rs.getString("contrasenia"); // Obtener el hash almacenado
            String hashIngresado = hashearContrasena(password); // Hashear la contraseña ingresada

            if (hashAlmacenado.equals(hashIngresado)) { // Comparar los hashes
                usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("email"),
                        hashAlmacenado // Guardar el hash, aunque realmente no lo necesitarías aquí
                );
            }
        }

    } catch (Exception e) {
        System.out.println(e);
    }
    return usuario;
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
