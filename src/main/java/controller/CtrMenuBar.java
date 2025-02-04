/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.FrmMenuBar;


/**
 *
 * @author RIBZ
 */
public class CtrMenuBar  implements ActionListener{
    private FrmMenuBar frmConP;
    
    
    public CtrMenuBar(FrmMenuBar frmContenedorPrincipal){
        this.frmConP = frmContenedorPrincipal;
        this.frmConP.jMenuIUGuardar.addActionListener(this);
        this.frmConP.jMenuIUBuscar.addActionListener(this);
        this.frmConP.jMenuIUModificar.addActionListener(this);
        this.frmConP.jMenuIUEliminar.addActionListener(this);
    }
    public void iniciar() {
        frmConP.setTitle("Administrador");
        frmConP.setLocation(100,100);
        frmConP.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmConP.jMenuUsuario) {
            CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
            cardLayout.show(frmConP.PanelPrincipal, "Usuario");
        } 
        if (e.getSource() == frmConP.jMenuIUGuardar) {
            CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
            cardLayout.show(frmConP.PanelPrincipal, "Buscar");
        } 
        if (e.getSource() == frmConP.jMenuIUGuardar) {
            CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
            cardLayout.show(frmConP.PanelPrincipal, "Guardar");
        } 
        if (e.getSource() == frmConP.jMenuIUModificar) {
            CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
            cardLayout.show(frmConP.PanelPrincipal, "Modificar");
        } 
        if (e.getSource() == frmConP.jMenuIUEliminar) {
            CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
            cardLayout.show(frmConP.PanelPrincipal, "Eliminar");
        } 
    }

}
