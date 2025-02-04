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
        this.frmConP.jMenuIUGuardar.addActionListener(this);
        this.frmConP.jMenuIUBuscar.addActionListener(this);
        this.frmConP.jMenuIUModificar.addActionListener(this);
        this.frmConP.jMenuIUEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        if (e.getSource() == frmConP.jMenuIUGuardar) {
            cardLayout.show(frmConP.PanelPrincipal, "card3");  // PanelGuardar
        }
        if (e.getSource() == frmConP.jMenuIUBuscar) {
            cardLayout.show(frmConP.PanelPrincipal, "card2");  // PanelBuscar
        }
        if (e.getSource() == frmConP.jMenuIUModificar) {
            cardLayout.show(frmConP.PanelPrincipal, "card5");  // PanelModificar
        }
        if (e.getSource() == frmConP.jMenuIUEliminar) {
            cardLayout.show(frmConP.PanelPrincipal, "card6");  // PanelEliminar
        }
    }
}
