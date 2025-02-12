/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Telecomunicaciones;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrTelecomunicaciones implements ActionListener{
    private frmMenuBar frmConP;

    public CtrTelecomunicaciones(frmMenuBar frmContenedorPrincipal) {
        this.frmConP = frmContenedorPrincipal;
        this.frmConP.jMenuIT1.addActionListener(this);
        this.frmConP.jMenuIT2.addActionListener(this);
    }

  
  /*
  En el controller telecomunicaciones se trabajan los Menu items que se necesiten, este con el objetivo de que cada grupo obtenga individualidad
  En el caso de querer agregar más menu items se requiere agregarlo en la vista frmMenuBar, importante que en los layout sea de tipo null ya 
  que se trabaja cardLayout
  */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Boton Guardar
        
        if(e.getSource() == frmConP.jMenuIT1){
            
            Ctr1Telecomunicaciones ctrGuardarT = new Ctr1Telecomunicaciones(frmConP);
            ctrGuardarT.iniciar();
        }
        if(e.getSource() == frmConP.jMenuIT2){
            Ctr2Telecomunicaciones ctr2T = new Ctr2Telecomunicaciones(frmConP);
            ctr2T.iniciar();
        }
   
    }
}
