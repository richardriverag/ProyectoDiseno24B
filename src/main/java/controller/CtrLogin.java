/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.JOptionPane;
import model.DbUsuarioL;
import model.Usuarios.DbUsuario;
import model.Usuarios.Usuario;
import view.FrmUsuarioLogin;
import view.FrmUsuarioRecuperarPass;

/**
 *
 * @author LENOVO.USER
 */
public class CtrLogin implements ActionListener{
    private DbUsuarioL dbUsuario = new DbUsuarioL();
    private FrmUsuarioLogin frmLogin;
    private FrmUsuarioRecuperarPass frmPass;

    public CtrLogin(FrmUsuarioLogin frmLogin) {
        this.frmLogin = frmLogin;
        this.frmPass = new FrmUsuarioRecuperarPass();
        this.frmLogin.btnRecuperarPass.addActionListener(this);
        this.frmLogin.btnLogin1.addActionListener(this);
    }

    public CtrLogin() {
    }
    
    
    public boolean loginUsuario(String user, String password){
        
        Usuario usuario = dbUsuario.loginUsuario(user, password);
        
        return usuario != null;    
    }
   @Override
    public void actionPerformed(ActionEvent e) {

    }
}
