/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Usuarios;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrUsuario implements ActionListener{
    private FrmMenuBar frmConP;

    public CtrUsuario(FrmMenuBar frmContenedorPrincipal) {
        this.frmConP = frmContenedorPrincipal;
        this.frmConP.jMenuIUsuarios1.addActionListener(this);
        this.frmConP.jMenuIUsuarios2.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmConP.jMenuIUsuarios1){
             Ctr1Usuario ctr1 = new Ctr1Usuario(frmConP);
            ctr1.iniciar();
        }   
    }
}
