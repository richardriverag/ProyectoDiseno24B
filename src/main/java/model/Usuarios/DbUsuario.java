/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Usuarios;

import model.Conexion;
import java.sql.*;

/**
 *
 * @author User
 */
public class DbUsuario extends Conexion {

    public boolean guardar(Usuario u) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO usuario (cedula,nombre,email,contrasenia,celular,rol_id, salario,fecha_contratacion) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getCedula());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getContrasenia());
            ps.setString(5, u.getTelefono());
            String rol = u.getRol();
            int idRol;

            switch (rol) {
                case "Residente":
                    idRol = 1;
                    break;
                case "Administrador":
                    idRol = 2;
                    break;
                case "Limpieza":
                    idRol = 3;
                    break;
                case "Mantenimiento":
                    idRol = 4;
                    break;
                case "Guardia":
                    idRol = 5;
                    break;
                default:
                    throw new IllegalArgumentException("Rol desconocido: " + rol);
            }
            ps.setInt(6, idRol);
            ps.setDouble(7, u.getSalario());
            ps.setDate(8, (Date) u.getFechaContratacion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error en la inserción: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close(); // Cierra solo el `PreparedStatement`
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }

}
