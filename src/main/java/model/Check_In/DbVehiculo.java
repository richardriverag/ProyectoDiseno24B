/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Check_In;

import model.Conexion;
import java.sql.*;

/**
 * Manejo de la base de datos para Vehiculo
 * @author User
 */
public class DbVehiculo extends Conexion {

    public boolean guardar(Vehiculo v) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO Vehiculo (placa, modelo, color, visitante_id) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getModelo());
            ps.setString(3, v.getColor());
            ps.setInt(4, v.getVisitanteId());
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

    public Vehiculo buscarPorVisitanteId(int visitanteId) {
        Connection con = Conexion.getInstance();
        String sql = "SELECT placa, modelo, color FROM Vehiculo WHERE visitante_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vehiculo vehiculo = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, visitanteId);
            rs = ps.executeQuery();

            if (rs.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setColor(rs.getString("color"));
                vehiculo.setVisitanteId(visitanteId);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar el vehículo: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return vehiculo;
    }
}
