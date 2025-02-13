package model.Usuarios;

import model.Conexion;
import java.sql.*;

public class DbUsuario extends Conexion {

    public boolean eliminar(UsuarioDAC u) {
        PreparedStatement ps;
        Connection con = Conexion.getInstance();
        String sql = "DELETE FROM Usuario WHERE cedula =  ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getCedula());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean guardar(UsuarioDAC u) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO Usuario (cedula,nombre,email,contrasenia,celular,rol_id, salario,fecha_contrato) VALUES (?,?,?,?,?,?,?,?)";
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
            if (u.getFechaContrato() != null) {
                ps.setDate(8, new java.sql.Date(u.getFechaContrato().getTime()));
            } else {
                ps.setNull(8, java.sql.Types.DATE);
            }
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
        String sql = "SELECT COUNT(*) FROM Usuario WHERE email = ?";

        try (Connection con = Conexion.getInstance(); PreparedStatement stmt = con.prepareStatement(sql)) {

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
        String sql = "UPDATE Usuario SET contrasenia = ? WHERE email = ?";

        try (Connection con = Conexion.getInstance(); PreparedStatement stmt = con.prepareStatement(sql)) {

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

    public Usuario loginUsuario(String user, String password) {
        Connection conn = Conexion.getInstance();
        Usuario usuario = Usuario.getInstance();
        PreparedStatement stmt;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM Usuario WHERE email = ? AND contrasenia = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            //verficar si existe el usuario en base de datos
            if (rs.next()) {
                //Si existe creamos un nuevo user
                usuario.setId(rs.getInt("id"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setSalario(Double.parseDouble(rs.getString("salario")));
                usuario.setRol(new Rol(rs.getInt("rol_id")));
                java.sql.Date fechaSQL = rs.getDate("fecha_contrato");
                usuario.setFechaContrato((fechaSQL != null) ? new Date(fechaSQL.getTime()) : null);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
    }

    public UsuarioDAC buscar(String cedula) {
        Connection con = Conexion.getInstance();
        String sql = "SELECT * FROM Usuario u join Roles r ON u.rol_id = r.id WHERE cedula = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioDAC usuario = new UsuarioDAC();
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setSalario(rs.getDouble("salario"));

                java.sql.Date fechaContratoSQL = rs.getDate("fecha_contrato");
                if (fechaContratoSQL != null) {
                    usuario.setFechaContrato(new java.util.Date(fechaContratoSQL.getTime()));
                }
                Rol rol = new Rol(rs.getInt("rol_id"), rs.getString("r.nombre"));
                usuario.setRol(rol);
                return usuario;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return null;
    }

    public boolean verUsuarios() {
        Connection conn = Conexion.getInstance();
        PreparedStatement stmt;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM Usuario join Roles on Usuario.rol_id = Roles.id";

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            //verficar si existe el usuario en base de datos
            while (rs.next()) {
                //Si existe creamos un nuevo user
                System.out.println("------------------------------------------");
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("cedula"));
                System.out.println(rs.getString("contrasenia"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("celular"));
                System.out.println(Double.parseDouble(rs.getString("salario")));
                System.out.println(rs.getString("rol_id"));
                System.out.println(rs.getString("fecha_contrato"));
            }
            return true;
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean guardarRol(String nombre) {
        Connection con = Conexion.getInstance();
        String sql = "INSERT INTO Roles (nombre) VALUES (?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
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

    public boolean verRoles() {
        Connection conn = Conexion.getInstance();
        PreparedStatement stmt;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM Roles";

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            //verficar si existe el usuario en base de datos
            while (rs.next()) {
                //Si existe creamos un nuevo user
                System.out.println("------------------------------------------");
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nombre"));
            }
            return true;
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    
}
