/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.CheckIn;

import controller.EspaciosComunes.ctr1EspaciosComunes;
import controller.EspaciosComunes.ctr2EspaciosComunes;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrCheckIn implements ActionListener {
    private FrmMenuBar frmConP;

    public CtrCheckIn(FrmMenuBar frmConP) {
        this.frmConP = frmConP;
        this.frmConP.jMenuICI1.addActionListener(this);
        this.frmConP.jMenuICI2.addActionListener(this);
        this.frmConP.jMenuICIModificar.addActionListener(this);
        this.frmConP.jMenuICIEliminar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        if(e.getSource() == frmConP.jMenuICI1){
            
            ctr1CheckIn ctr1 = new ctr1CheckIn(frmConP);
            ctr1.iniciar();
        }
        if(e.getSource() == frmConP.jMenuICI2){
            
            ctr2CheckIn ctr2 = new ctr2CheckIn(frmConP);
            ctr2.iniciar();
        }
    }
}
