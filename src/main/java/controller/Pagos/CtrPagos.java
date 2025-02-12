/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Pagos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrPagos implements ActionListener {
    
    private frmMenuBar frmConP;

    public CtrPagos(frmMenuBar frmConP) {
        this.frmConP = frmConP;
        this.frmConP.jMenuIP1.addActionListener(this);
        this.frmConP.jMenuIP2.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmConP.jMenuIP1){
            ctr1Pagos ctr1 = new ctr1Pagos(frmConP);
            ctr1.iniciar();
        }
        if(e.getSource() == frmConP.jMenuIP2){
            ctr2Pagos ctr2 = new ctr2Pagos(frmConP);
            ctr2.iniciar();
        }
    }
       
}
