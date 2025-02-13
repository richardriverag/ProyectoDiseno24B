package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO.USER
 */

public class ModelRecuperacion {
   private Connection conn = new Conexion().getInstance();

    public ResultSet RecuperacionCorreo(String cedula){       
        PreparedStatement ps;

        try{
            String query= "SELECT email, contrasenia FROM usuario WHERE cedula = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            return rs;
            
        }catch(SQLException e){
            System.out.println("error"+ e);
            return null;
        }    
    }
}
