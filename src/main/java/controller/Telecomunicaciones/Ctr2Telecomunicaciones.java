/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Telecomunicaciones;

import controller.Pagos.ctr1Pagos;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class Ctr2Telecomunicaciones implements ActionListener{
    private frmMenuBar frmConP;
    


    public Ctr2Telecomunicaciones(frmMenuBar frmConP) {
        this.frmConP = frmConP;
    }
    
    public void iniciar(){

        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        cardLayout.show(frmConP.PanelPrincipal, "card9"); //Importante que coincida la asignacion del panel, el nombre se pude conocer el la vusta frmMenuBar
        System.out.println("Panel 2 mostrado.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
