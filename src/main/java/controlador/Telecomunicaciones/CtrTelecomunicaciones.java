/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Telecomunicaciones;

import java.awt.CardLayout;
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
        this.frmConP.jMenuITGuardar.addActionListener(this);
        this.frmConP.btnGuardar.addActionListener(this);
    }
  public void iniciar() {
        // Opcional: Lógica para inicializar este módulo
        System.out.println("Módulo de Telecomunicaciones iniciado.");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Boton Guardar
        
        if(e.getSource() == frmConP.jMenuITGuardar){
            
            CtrMenuGuardarTelecom ctrGuardarT = new CtrMenuGuardarTelecom(frmConP);
            ctrGuardarT.iniciar();
        }
        
    }
}
