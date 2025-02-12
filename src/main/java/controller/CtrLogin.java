/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.DbUsuario;
import model.Usuario;

/**
 *
 * @author LENOVO.USER
 */
public class CtrLogin {
    private DbUsuario dbUsuario = new DbUsuario();
    
    public boolean loginUsuario(String user, String password){
        
        Usuario usuario = dbUsuario.loginUsuario(user, password);
        
        return usuario != null;    
    }
}
