/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO.USER
 */
public class ModelRecuperacion {
    public ResultSet RecuperacionCorreo(String usuario, String ip, String port,  String db, String user, String pwd){
        Conexion con;
        PreparedStatement ps;

        try{
            con = (Conexion) Conexion.getInstance();
            String query= "Select email FROM usuario WHERE cedula = ?";
            
        }catch(Exception e){
            System.out.println("error"+ e);
            return null;
        }
        return null;
    }
    
}
