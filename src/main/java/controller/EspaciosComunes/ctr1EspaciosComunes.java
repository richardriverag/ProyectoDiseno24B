/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.EspaciosComunes;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class ctr1EspaciosComunes implements ActionListener{
    private FrmMenuBar frmConP;

    public ctr1EspaciosComunes(FrmMenuBar frmConP) {
        this.frmConP = frmConP;
    }
    
    public void iniciar(){
        
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        // Cambiar a la pestaña
        cardLayout.show(frmConP.PanelPrincipal, "card23"); 
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
