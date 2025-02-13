/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuarios.Usuario;

/**
 *
 * @author LENOVO.USER
 */
public class DbUsuario {
    
    private Connection conn = new Conexion().getInstance();
  
    
    public Usuario loginUsuario(String user, String password){
        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM usuario WHERE cedula = ? AND contrasenia = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2,password);
            
            rs = stmt.executeQuery();
            
            //verficar si existe el usuario en base de datos
            if(rs.next()){
                //Si exitste creamos un nuevo user
                usuario =  new Usuario(
                        rs.getInt("id")
                        ,rs.getString("cedula"),
                        rs.getString("contrasenia"));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }  
        return usuario;
    }
}
