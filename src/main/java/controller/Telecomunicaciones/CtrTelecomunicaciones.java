/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Telecomunicaciones;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrTelecomunicaciones implements ActionListener{
    private FrmMenuBar frmConP;

    public CtrTelecomunicaciones(FrmMenuBar frmContenedorPrincipal) {
        this.frmConP = frmContenedorPrincipal;
        this.frmConP.jMenuITGuardar.addActionListener(this);
        this.frmConP.jMenuITEliminar.addActionListener(this);
        this.frmConP.jMenuITBuscar.addActionListener(this);
        this.frmConP.jMenuITModificar.addActionListener(this);
        this.frmConP.btnGuardar.addActionListener(this);
    }
  public void iniciar() {
        // Opcional: Lógica para inicializar este módulo
        System.out.println("Módulo de Telecomunicaciones iniciado.");
    }
  
  /*
  En el controller telecomunicaciones se trabajan los Menu items que se necesiten, este con el objetivo de que cada grupo obtenga individualidad
  En el caso de querer agregar más menu items se requiere agregarlo en la vista FrmMenuBar, importante que en los layout sea de tipo null ya 
  que se trabaja cardLayout
  */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Boton Guardar
        
        if(e.getSource() == frmConP.jMenuITGuardar){
            
            CtrMenuGuardarTelecom ctrGuardarT = new CtrMenuGuardarTelecom(frmConP);
            ctrGuardarT.iniciar();
        }
        if(e.getSource() == frmConP.jMenuITBuscar){
            Ctr2Telecomunicaciones ctr2T = new Ctr2Telecomunicaciones(frmConP);
            ctr2T.iniciar();
        }
        
        if(e.getSource() == frmConP.jMenuITModificar){
            Ctr3Telecomunicaciones ctr3T = new Ctr3Telecomunicaciones(frmConP);
            ctr3T.iniciar();
        }
        
        if(e.getSource() == frmConP.jMenuITEliminar){
            Ctrl4Telecomunicaciones ctr4T = new Ctrl4Telecomunicaciones(frmConP);
            ctr4T.iniciar();
        }
    }
}
