package model.Usuarios;

import model.Conexion;
import java.sql.*;

public class DbUsuario extends Conexion {

    public boolean eliminar (Usuario u){
        PreparedStatement ps; 
        Connection con= Conexion.getInstance();
        String sql= "DELETE FROM usuario WHERE cedula =  ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getCedula());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    public boolean guardar(Usuario u) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO usuario (cedula,nombre,email,contrasenia,celular,rol_id, salario,fecha_contrato) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getCedula());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getContrasenia());
            ps.setString(5, u.getCelular());
            Rol rol = u.getRol();            
            ps.setInt(6, rol.getId());
            ps.setDouble(7, u.getSalario());
            ps.setDate(8, new java.sql.Date(u.getFechaContrato().getTime()));

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error en la insercion: " + e.getMessage());
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

    public boolean existeUsuarioPorCorreo(String correo) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE email = ?";

        try (Connection con = Conexion.getInstance();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar usuario por correo: " + e.getMessage());
        }
        return false;
    }

    public boolean actualizarContrasena(String correo, String nuevaPass) {
        String sql = "UPDATE usuario SET contrasenia = ? WHERE email = ?";

        try (Connection con = Conexion.getInstance();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nuevaPass);
            stmt.setString(2, correo);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar contrase�a: " + e.getMessage());
        }
        return false;
    }
    
    public boolean verificarCodigo2FA(String correo, String codigo) {
        return TwoFactorAuth.validarCodigo(correo, codigo);
    }  
    
    public Usuario loginUsuario(String user, String password){
        Connection conn = Conexion.getInstance();
        Usuario usuario = Usuario.getInstance();
        PreparedStatement stmt;
        ResultSet rs;
        
        try{
            String sql = "SELECT * FROM usuario WHERE email = ? AND contrasenia = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2,password);
            
            rs = stmt.executeQuery();
            
            //verficar si existe el usuario en base de datos
            if(rs.next()){
                //Si existe creamos un nuevo user
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setSalario(Double.parseDouble(rs.getString("salario")));
                usuario.setRol(new Rol(Integer.parseInt(rs.getString("idRol"))));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }  
        return usuario;
    }
}

