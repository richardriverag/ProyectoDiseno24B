/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Pagos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrPagos implements ActionListener {
    private FrmMenuBar frmConP;

    public CtrPagos(FrmMenuBar frmConP) {
        this.frmConP = frmConP;
        this.frmConP.jMenuIPGuardar.addActionListener(this);
        this.frmConP.jMenuIPBuscar.addActionListener(this);
        this.frmConP.jMenuIPModificar.addActionListener(this);
        this.frmConP.jMenuIPEliminar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmConP.jMenuIPGuardar){
            ctr1Pagos ctr1 = new ctr1Pagos(frmConP);
            ctr1.iniciar();
        }
        if(e.getSource() == frmConP.jMenuIPBuscar){
            ctr2Pagos ctr2 = new ctr2Pagos(frmConP);
            ctr2.iniciar();
        }
        if(e.getSource() == frmConP.jMenuIPModificar){
            ctr3Pagos ctr3 = new ctr3Pagos(frmConP);
            ctr3.iniciar();
        }
        if(e.getSource() == frmConP.jMenuIPEliminar){
            ctr4Pagos ctr4 = new ctr4Pagos(frmConP);
            ctr4.iniciar();
        }
    }
    
    
}
