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
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        if (e.getSource() == frmConP.jMenuIUsuarios1) {
            cardLayout.show(frmConP.PanelPrincipal, "card3");  // PanelGuardar
        }
        if (e.getSource() == frmConP.jMenuIUsuarios2) {
            cardLayout.show(frmConP.PanelPrincipal, "card2");  // PanelBuscar
        }
    }
}
