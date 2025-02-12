/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comunicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import model.Conexion;
import java.sql.Timestamp;

/**
 *
 * @author Grupo Comunicacion
 */
public class DbMensaje{
    
    // Métodos de funcionalidad

    public boolean enviar(Mensaje mensaje) { 
        Connection con = Conexion.getInstance();
        String sqlMensaje = "INSERT INTO Mensaje (contenido, fechaEnvio) VALUES (?,?)";
        String sqlMensajeUsuario = "INSERT INTO MensajeUsuario (idMensaje, idUsuario_Remitente, idUsuario_Emisor) VALUES (?,?,?)";
        PreparedStatement psMensaje = null;
        PreparedStatement psMensajeUsuario = null;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false); //Inicio Transacción
            //Primer INSERT 
            psMensaje = con.prepareStatement(sqlMensaje, Statement.RETURN_GENERATED_KEYS);
            psMensaje.setString(1, mensaje.getContenido());
            mensaje.setFechaEnvio(new Date());
            psMensaje.setTimestamp(2, new Timestamp(mensaje.getFechaEnvio().getTime()));
            psMensaje.execute();
            
            //Obtener ID de tabla Mensaje (Mensaje generado)
            rs = psMensaje.getGeneratedKeys(); 
            int mensajeId = -1;
            if (rs.next()) {
                mensajeId = rs.getInt(1); // El ID generado automáticamente
            } else {
                throw new SQLException("No se pudo obtener el ID del mensaje insertado.");
            }
            
            psMensajeUsuario = con.prepareStatement(sqlMensajeUsuario);
            psMensajeUsuario.setInt(1, mensajeId);
            psMensajeUsuario.setInt(2, mensaje.getRemitente().getId());
            psMensajeUsuario.setInt(3, mensaje.getDestinatario().getId());
            psMensajeUsuario.executeUpdate();
            
            //Finalizar Transaccion porque commit no esta en automatico
            con.commit();
            return true;
        } catch (SQLException e) {
            try {
                con.rollback(); //Revertir cambios si hay error
            } catch (SQLException rollbackEx) {
                System.err.println("Error en rollback: " + rollbackEx.getMessage());
            }
            System.err.println("Error en la inserción: " + e.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (psMensaje != null) psMensaje.close();
                if (psMensajeUsuario != null) psMensajeUsuario.close();
            con.setAutoCommit(true); // Restablecer modo automático para futuras transacciones
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }
    

   public boolean editar(Mensaje mensaje, String nuevoContenido) { 
        Connection con = Conexion.getInstance();
        String sql = "UPDATE Mensaje SET contenido = ? WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevoContenido);
            ps.setInt(2, mensaje.getId());
            ps.executeUpdate();
            // Actualizar el objeto Mensaje con el nuevo contenido
            mensaje.setContenido(nuevoContenido);
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
   
       
    public boolean eliminar(Mensaje mensaje) {
        Connection con = Conexion.getInstance();
        String sql = "DELETE FROM Mensaje WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mensaje.getId());
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
