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
public class CtrInmuebles implements ActionListener{


    private frmMenuBar frmConP;

    public CtrInmuebles(frmMenuBar frmConP) {
        this.frmConP = frmConP;
        this.frmConP.jMenuII1.addActionListener(this);
        this.frmConP.jMenuII2.addActionListener(this);
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        if(e.getSource() == frmConP.jMenuII1){
            
            ctr1Inmuebles ctr1 = new ctr1Inmuebles(frmConP);
            ctr1.iniciar();
        }
        if(e.getSource() == frmConP.jMenuII2){
            
            ctr2Inmuebles ctr2 = new ctr2Inmuebles(frmConP);
            ctr2.iniciar();
        }
    }
}
    
    
   
