/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Check_In;

import model.Conexion;
import java.sql.*;

/**
 * CRUD para la base de datos de Check-In
 * @author User
 */
public class DbVisitante extends Conexion {

    public boolean guardar(Visitante v) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO Visitante (nombre, identificacion, detalles_contacto, motivo_visita) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getNombre());
            ps.setString(2, v.getIdentificacion());
            ps.setString(3, v.getDetallesContacto());
            ps.setString(4, v.getMotivoVisita());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error en la inserción: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }
}
