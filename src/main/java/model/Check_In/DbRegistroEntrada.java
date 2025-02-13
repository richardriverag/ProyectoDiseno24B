/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Check_In;

import model.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manejo de la base de datos para RegistroEntrada
 * @author User
 */
public class DbRegistroEntrada extends Conexion {

    public boolean guardar(RegistroEntrada r) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO RegistroEntrada (fecha_registro, visitante_id, usuario_id) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(r.getFechaRegistro().getTime()));
            ps.setInt(2, r.getVisitanteId());
            ps.setInt(3, r.getUsuarioId());
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

    public List<RegistroEntrada> obtenerRegistros() {
        Connection con = Conexion.getInstance();
        List<RegistroEntrada> registros = new ArrayList<>();
        String sql = """
            SELECT re.fecha_registro, v.id, v.nombre, v.identificacion, v.detalles_contacto, 
                   v.motivo_visita, ve.placa, ve.modelo, ve.color
            FROM RegistroEntrada re
            JOIN Visitante v ON re.visitante_id = v.id
            JOIN Vehiculo ve ON v.id = ve.visitante_id
        """;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RegistroEntrada registro = new RegistroEntrada();
                registro.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                
                Visitante visitante = new Visitante();
                visitante.setId(rs.getInt("id"));
                visitante.setNombre(rs.getString("nombre"));
                visitante.setIdentificacion(rs.getString("identificacion"));
                visitante.setDetallesContacto(rs.getString("detalles_contacto"));
                visitante.setMotivoVisita(rs.getString("motivo_visita"));

                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setColor(rs.getString("color"));

                registro.setVisitante(visitante);
                registro.setVehiculo(vehiculo);
                
                registros.add(registro);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener registros: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return registros;
    }
}
