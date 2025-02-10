/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Pagos;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class ctr2Pagos implements ActionListener{
        private FrmMenuBar frmConP;

    public ctr2Pagos(FrmMenuBar frmConP) {
        this.frmConP = frmConP;
    }
    public void iniciar(){
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        cardLayout.show(frmConP.PanelPrincipal, "card14"); // Mostrar el panel de guardar
        System.out.println("Panel 2 Pagos mostrado.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
