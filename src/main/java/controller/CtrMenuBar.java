/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Usuarios.Usuario;
import view.frmMenuBar;


/**
 *
 * @author RIBZ
 */
public class CtrMenuBar  implements ActionListener{
    private frmMenuBar frmConP;
    
    
    public CtrMenuBar(frmMenuBar frmContenedorPrincipal){
        this.frmConP = frmContenedorPrincipal;
       
    }
    public void iniciar() {
        Usuario usuario = Usuario.getInstance();
        frmConP.setTitle("Administrador");
        frmConP.setLocation(100,100);
        frmConP.setVisible(true);
        if (usuario.getRol().getId() != 2) {
            System.out.println("Ingreso de admin");
            frmConP.jMenuIUsuarios1.setEnabled(false);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
