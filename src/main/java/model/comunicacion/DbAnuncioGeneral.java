/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comunicacionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import model.Conexion;


public class DbAnuncioGeneral{

    public boolean generarAnuncioGeneral(AnuncioGeneral anuncio) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO AnuncioGeneral (contenido, fechaCreacion, idUsuario) VALUES (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, anuncio.getContenido());
            anuncio.setFechaCreacion(new Date());
            ps.setTimestamp(2, new Timestamp(anuncio.getFechaCreacion().getTime()));
            ps.setInt(3, anuncio.getUsuario().getId());
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


    public boolean editar(AnuncioGeneral anuncio, String nuevoContenido) {
        Connection con = Conexion.getInstance();
        String sql = "UPDATE AnuncioGeneral SET contenido = ? WHERE idAnuncio = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevoContenido);
            ps.setInt(2, anuncio.getIdAnuncio());
            ps.executeUpdate();
            anuncio.setContenido(nuevoContenido);
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


    public boolean eliminar(AnuncioGeneral anuncio) {
        Connection con = Conexion.getInstance();
        String sql = "DELETE FROM AnuncioGeneral WHERE idAnuncio = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, anuncio.getIdAnuncio());
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
}

