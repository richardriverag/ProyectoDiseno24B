/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comunicacionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import model.Conexion;   
import model.comunicacion.UsuarioModel;

public class DbReporteMensaje {

    public boolean generarReporte(ReporteMensaje reporte) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO ReporteMensaje (fechaInicio, fechaFinal, contenido, idUsuario) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(reporte.getFechaInicio().getTime()));
            ps.setTimestamp(2, new Timestamp(reporte.getFechaFinal().getTime()));
            ps.setString(3, reporte.getContenido());
            ps.setInt(4, reporte.getUsuario().getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error en la inserción: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close(); // Cierra solo el `PreparedStatement`
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }

   
public boolean visualizarReporte(ReporteMensaje reporte) {
    ResultSet rs;
    Connection con = Conexion.getInstance();
    String sql = "SELECT * FROM ReporteMensaje WHERE idReporte = ?";
    PreparedStatement ps = null;
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, reporte.getIdReporte());
        rs = ps.executeQuery();
        if (rs.next()) {
            reporte.setIdReporte(rs.getInt("idReporte"));
            reporte.setFechaInicio(rs.getTimestamp("fechaInicio"));
            reporte.setFechaFinal(rs.getTimestamp("fechaFinal"));
            reporte.setContenido(rs.getString("contenido"));
            int idUsuario = rs.getInt("idUsuario");
            if (!rs.wasNull()) {
                reporte.setUsuario(new UsuarioModel(idUsuario, null, null, null, null, null, 0, null, null));
            } else {
                reporte.setUsuario(null);
            }
            return true;
        }
        return false;
    } catch (SQLException e) {
        System.err.println("Error en la inserción: " + e.getMessage());
        return false;
    } finally {
        try {
            if (ps != null) ps.close(); // Cierra solo el `PreparedStatement`
        } catch (SQLException e) {
            System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
        }
    }
}    
}

