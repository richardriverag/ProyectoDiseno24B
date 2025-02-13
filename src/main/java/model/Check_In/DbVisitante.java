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
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, v.getNombre());
            ps.setString(2, v.getIdentificacion());
            ps.setString(3, v.getDetallesContacto());
            ps.setString(4, v.getMotivoVisita());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                v.setId(rs.getInt(1)); // Asigna el ID generado al objeto Visitante
            }

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

    public int obtenerUltimoId() {
        Connection con = Conexion.getInstance();
        String sql = "SELECT MAX(id) AS id FROM Visitante";
        Statement st = null;
        ResultSet rs = null;
        int ultimoId = -1;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                ultimoId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el último ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return ultimoId;
    }

    public Visitante buscarPorId(int id) {
        Connection con = Conexion.getInstance();
        String sql = "SELECT * FROM Visitante WHERE id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Visitante visitante = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                visitante = new Visitante();
                visitante.setId(rs.getInt("id"));
                visitante.setNombre(rs.getString("nombre"));
                visitante.setIdentificacion(rs.getString("identificacion"));
                visitante.setDetallesContacto(rs.getString("detalles_contacto"));
                visitante.setMotivoVisita(rs.getString("motivo_visita"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar visitante: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return visitante;
    }
}
