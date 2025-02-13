/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Check_In;
import model.Conexion;
import java.sql.*;

/**
 *
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
}
