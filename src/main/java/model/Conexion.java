/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Richard
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    /*private final String base = "sistemaunificado";
    private final String user = "root";
    private final String password = "admin";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;
    
    public Connection getConexion(){
        try{
            con = DriverManager.getConnection(this.url, this.user, this.password);
            
        }catch(SQLException e){
            System.err.println(e);
        }
        return con;
    }*/
    private static String url = "jdbc:mysql://bsifaecly7cl2qm8ent0-mysql.services.clever-cloud.com:3306/bsifaecly7cl2qm8ent0";
    private static String user = "u3cuki32eefgdj5y";
    private static String password = "gbXtPlxPG15rpOmYbqgU";
    private static Connection myConn = null;

    public static Connection getInstance() {
        if (myConn == null) {
            try {
                myConn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexión exitosa a la base de datos en Clever Cloud.");
            } catch (SQLException e) {
                System.out.println("Existio un error al conectar a la base de datos" + e.getMessage());
            }
        }
        return myConn;
    }
}
