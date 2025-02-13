package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Martin
 */
public class DbReserva extends Conexion {
    
    public void reservar(String fecha, String horaInicio, String horaFin, String espacio){
        PreparedStatement ps;
        ResultSet rs;
        int id_usuario, id_espacio;
        id_usuario = buscarIdUsuario();
        id_espacio = buscarIdEspacio(espacio);
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO ReservaEspacio (usuario_id, espacio_id, fecha, hora_inicio, hora_fin, estado) "
                + "VALUES (?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(id_usuario));
            ps.setString(2, Integer.toString(id_espacio));
            ps.setString(3, fecha);
            ps.setString(4, horaInicio);
            ps.setString(5, horaFin);
            ps.setString(6, "pendiente");
            ps.execute();
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
            
        }
       
    }
    
    public int buscarIdUsuario(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getInstance();
        String sql = "SELECT id FROM Usuario WHERE cedula = 1000000000";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return Integer.parseInt(rs.getString("id"));
            }
            return 0;
        }catch(SQLException e){
            System.err.println(e);
            return 0;
        }
        
    }
        
    
    
    public int buscarIdEspacio(String espacio){
    
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getInstance();
        String sql = "SELECT id FROM EspacioComun WHERE nombre = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, espacio);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return Integer.parseInt(rs.getString("id"));
            }
            return 0;
        }catch(SQLException e){
            System.err.println(e);
            return 0;
        }
    }
    
    public boolean estaReservado(String fecha, String hora_inicio, String hora_fin, String espacio){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getInstance();
        String sql = "SELECT COUNT(*) FROM ReservaEspacio "
                + "WHERE espacio_id = ? AND fecha = ? AND hora_inicio = ? AND hora_fin = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(buscarIdEspacio(espacio)));
            ps.setString(2, fecha);
            ps.setString(3, hora_inicio);
            ps.setString(4, hora_fin);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1) > 0;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
            return true;
        }
    }
    
}
