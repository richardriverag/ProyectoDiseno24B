/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Inmuebles;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class ctr1Inmuebles implements ActionListener {

    private frmMenuBar frmConP;

    public ctr1Inmuebles(frmMenuBar frmConP) {
        this.frmConP = frmConP;
    }
    
    public void iniciar(){
        
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        // Cambiar a la pestaña
        cardLayout.show(frmConP.PanelPrincipal, "panel1Inmuebles"); 
        System.out.println("Panel MenuItem1 mostrado.");

        // Forzar actualización
        frmConP.PanelPrincipal.revalidate();
        frmConP.PanelPrincipal.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
