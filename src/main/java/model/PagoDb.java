/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Usuarios.Usuario;

/**
 *
 * @author User
 */
public class PagoDb extends Conexion{

    

    public static boolean insertar(Pago p){
        Usuario usuario = Usuario.getInstance();
       PreparedStatement ps;
       Connection con = getInstance();
       System.out.println("Entro en insertar es de tipo: " + (p.getTipo()));
       
    int metodo = 0;
    if (p.getTipo().equals("pago")){
        if (p.getMetodo().equals("Efectivo")){
         metodo = 3;
        }else if (p.getMetodo().equals("Tarjeta de credito")){
         metodo = 1;
        }else if (p.getMetodo().equals("Transferencia bancaria")){
         metodo = 2;
        }
    }
       
    int idusuario = 0;
    String sql2 = "select id from usuario where cedula = '" + p.getCedula() + "'";
    try {
        ps = con.prepareStatement(sql2);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idusuario = rs.getInt("id");
        }
        ps.close();
    } catch (SQLException e) {
        System.err.println(e);
        return false;
    }
       if (p.getTipo() == "pago" ){
        

               
            String sql = "INSERT INTO `pago` (`usuario_id`, `monto`, `fecha`, `metodo_pago_id`)"
                + "VALUES (?, ?, ?, ?);";
              try{
                 ps = con.prepareStatement(sql);
                 ps.setInt(1, idusuario);
                 ps.setString(2, p.getMonto());
                 ps.setString(3, p.getFecha());
                 ps.setInt(4, metodo);
                 ps.execute();
                 ps.close();
                 return true;
                }catch(SQLException e){
                 System.err.println(e);
                 return false;
                }
       }else {
            String sql = "INSERT INTO `multa` (`usuario_id`, `monto`,`descripcion`, `fecha`) "
                    + "VALUES (?, ?, ?, ?);";
            try{
                ps = con.prepareStatement(sql);
                ps.setInt(1, idusuario);
                ps.setString(2, p.getMonto());
                ps.setString(3, p.getDesc());
                ps.setString(4, p.getFecha());
                ps.execute();
                ps.close();
                /*String sql3 = "INSERT INTO `cuota` (`cedula`, `monto`, `fecha_emision`, `tipo`,`descripcion`, `estado`) "
                    + "VALUES (?, ?, ?, ?,?,?);";
                try{
                    ps = con.prepareStatement(sql3);
                    ps.setString(1, usuario.getCedula());
                    ps.setString(2, p.getMonto());
                    ps.setString(3, p.getFecha());
                    ps.setString(4, p.getMetodo());
                    ps.setString(5, p.getDesc());
                    ps.setString(6, "Pendiente");
                    ps.execute();
                    ps.close();
                }catch(SQLException e){
                    System.err.println(e);
                    return false;
                }*/
                return true;
            }catch(SQLException e){
                System.err.println(e);
                return false;
            }
       }
       
       
       
    }
    public static boolean leerP (String id,Pago p){
        PreparedStatement ps;
       ResultSet rs;
        Connection con = getInstance();
        String sql = "Select * from cuota where id="+id;
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                p.setCedula(rs.getString("id"));
                p.setMonto(rs.getString("monto"));
                p.setFecha(rs.getString("fecha_pago"));
                p.setTipo(rs.getString("estado"));
                //p.setDesc(rs.getString("descripcion"));
                ps.close();
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public static boolean actualizar(Pago p,String id){



        System.out.println("Entro en actualizar");
        PreparedStatement ps;
        Connection con = getInstance();

        String sql = "UPDATE multa SET estado='Pagado' "
            + "WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, id);

            ps.execute();
            ps.close();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public static boolean eliminar(String id, String tipo){
        System.out.println("Entro en actualizar");
        PreparedStatement ps;
        Connection con = getInstance();

        

        if (tipo.equals("pago")){
            String sql = "DELETE FROM pago where id="+id;
            try{
               ps = con.prepareStatement(sql); 
               ps.execute();
               ps.close();
               return true;
            }catch(SQLException e){
                 System.err.println(e);
                 return false;
            }
        } else if (tipo.equals("multa")){
            String sql = "DELETE FROM multa where id="+id;
            try{
               ps = con.prepareStatement(sql); 
               ps.execute();
               ps.close();
               return true;
            }catch(SQLException e){
                 System.err.println(e);
                 return false;
            }
        }
                return false; 
    }


    public static void mostrar(JTable tabla,String cedula){
        System.out.println("Entro en el metodo para mostrar");
       PreparedStatement ps;
       ResultSet rs;
        Connection con = getInstance();
        //String sql = "Select * from pago where cedula_usuario="+cedula;
        String sql = "SELECT " +
            "p.id AS id, " +
            "u.cedula, " +
            "p.monto, " +
            "p.fecha AS fecha_emision, " +
            "mp.tipo AS tipo, " +
            "NULL AS descripcion, " +
            "'Pago' AS estado " +
            "FROM Usuario u " +
            "JOIN Pago p ON u.id = p.usuario_id " +
            "JOIN MetodoPago mp ON p.metodo_pago_id = mp.id " +
            "WHERE u.cedula = '" + cedula + "' " +
            "UNION ALL " +
            "SELECT " +
            "m.id AS id, " +
            "u.cedula, " +
            "m.monto, " +
            "m.fecha AS fecha_emision, " +
            "'Multa' AS tipo, " +
            "m.descripcion, " +
            "'Pendiente' AS estado " +
            "FROM Usuario u " +
            "JOIN Multa m ON u.id = m.usuario_id " +
            "WHERE u.cedula = '" + cedula + "' " +
            "UNION ALL " +
            "SELECT " +
            "c.id AS id, " +
            "u.cedula, " +
            "c.monto, " +
            "c.fecha_pago AS fecha_emision, " +
            "'Cuota' AS tipo, " +
            "NULL AS descripcion, " +
            "c.estado " +
            "FROM Usuario u " +
            "JOIN Pago p ON u.id = p.usuario_id " +
            "JOIN Cuota c ON p.id = c.pago_id " +
            "WHERE u.cedula = '" + cedula + "'";

            
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("cedula");
        model.addColumn("monto");
        model.addColumn("fecha de emision");
        model.addColumn("tipo");
        model.addColumn("descripcion");
        model.addColumn("estado");
        tabla.setModel(model);
        String[] datos = new String[7];
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Entro en el while");
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6); 
                datos[6]=rs.getString(7);

                
                
                model.addRow(datos);
            }
            ps.close();
        }catch(SQLException e){
             System.err.println(e);
        }
    }
        
}
