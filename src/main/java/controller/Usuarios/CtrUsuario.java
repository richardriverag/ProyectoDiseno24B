/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Usuarios;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuarios.DbUsuario;
import model.Usuarios.Usuario;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrUsuario implements ActionListener{
    private frmMenuBar frmConP;
    private Usuario u = new Usuario();
    private DbUsuario dbu = new DbUsuario();
    
    public CtrUsuario(frmMenuBar frmContenedorPrincipal) {
        this.frmConP = frmContenedorPrincipal;
        this.frmConP.jMenuIUsuarios1.addActionListener(this);
        this.frmConP.jMenuIUsuarios2.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmConP.jMenuIUsuarios1){
             Ctr1Usuario ctr1 = new Ctr1Usuario(frmConP,u, dbu);
            ctr1.iniciar();
        }   
        
    }
}
