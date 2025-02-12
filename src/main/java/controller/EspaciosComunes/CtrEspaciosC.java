/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.EspaciosComunes;

import controller.Inmuebles.ctr1Inmuebles;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrEspaciosC implements ActionListener{
    private frmMenuBar frmConP;

    public CtrEspaciosC(frmMenuBar frmConP) {
        this.frmConP = frmConP;
        this.frmConP.jMenuIEC1.addActionListener(this);
        this.frmConP.jMenuIEC2.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        if(e.getSource() == frmConP.jMenuIEC1){
            
            ctr1EspaciosComunes ctr1 = new ctr1EspaciosComunes(frmConP);
            ctr1.iniciar();
        }
        if(e.getSource() == frmConP.jMenuIEC2){
            
            ctr2EspaciosComunes ctr2 = new ctr2EspaciosComunes(frmConP);
            ctr2.iniciar();
        }
    }
}
