/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Pagos;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Pago;
import model.PagoDb;
import view.frmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class CtrPagos implements ActionListener{
    private frmMenuBar frmConP;
    private PagoDb pagodb;

    public CtrPagos(frmMenuBar frmContenedorPrincipal) {
        this.frmConP = frmContenedorPrincipal;
        //this.pagodb = pago;
        
        this.frmConP.jMenuIPGuardar.addActionListener(this);
        this.frmConP.jMenuIPBuscar.addActionListener(this);
        this.frmConP.jMenuIPModificar.addActionListener(this);
        this.frmConP.jMenuIPEliminar.addActionListener(this);
        this.frmConP.buttonBuscarP.addActionListener(this);
        this.frmConP.buttonCrearPG.addActionListener(this);
        this.frmConP.buttonBuscarPM.addActionListener(this);
        this.frmConP.buttonModifiarP.addActionListener(this);
        this.frmConP.buttonBuscarPE.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        if (e.getSource() == frmConP.jMenuIPGuardar) {
            cardLayout.show(frmConP.PanelPrincipal, "card13");  // PanelGuardar
        }
        if (e.getSource() == frmConP.jMenuIPBuscar) {
            System.out.println("Entro");
            cardLayout.show(frmConP.PanelPrincipal, "card14");  // PanelBuscar
        }
        if (e.getSource() == frmConP.jMenuIPModificar) {
            cardLayout.show(frmConP.PanelPrincipal, "card15");  // PanelModificar
            frmConP.buttonModifiarP.setVisible(false);
        }
        if (e.getSource() == frmConP.jMenuIPEliminar) {
            cardLayout.show(frmConP.PanelPrincipal, "card16");  // PanelEliminar
        }
        if (e.getSource() == frmConP.buttonBuscarP){
            System.out.println("Entro en el boton buttonBuscarP");
            pagodb.mostrar(frmConP.tablaP,frmConP.txtBuscarP.getText());
        }
        if (e.getSource() == frmConP.buttonCrearPG){
            Pago p = new Pago();
            p.setCedula(frmConP.txtCedulaPG.getText());
            p.setMonto(frmConP.txtMontoPG.getText());
            p.setFecha(frmConP.txtFechaPG.getText());
            p.setDesc(frmConP.txtDescripcionPG.getText());
            String tipo = (String) frmConP.comboTipoPG.getSelectedItem();
            p.setTipo(tipo);
            String metodo = (String) frmConP.comboMetodoPago.getSelectedItem();
            p.setMetodo(metodo);
            if(pagodb.insertar(p)){
                JOptionPane.showMessageDialog(frmConP, "Se creo el pago");
            }else{
                JOptionPane.showMessageDialog(frmConP, "No se creo el pago");
            }
            frmConP.txtCedulaPG.setText("");
            frmConP.txtMontoPG.setText("");
            frmConP.txtFechaPG.setText("AAAA-MM-DD");
            frmConP.txtDescripcionPG.setText("");
        }
        if(e.getSource() == frmConP.buttonBuscarPM){
            Pago p = new Pago();
            if(pagodb.leerP(frmConP.txtIdPM.getText(),p)){
                frmConP.txtCedulaPM.setText(p.getCedula());
                frmConP.txtMontoPM.setText(p.getMonto());
                frmConP.txtFechaPM.setText(p.getFecha());
                frmConP.txtDescripcionPM.setText(p.getDesc());
                frmConP.buttonModifiarP.setVisible(true);
                frmConP.comboTipoPM.setSelectedItem(p.getTipo());
                frmConP.txtIdPM.setEditable(false);
            }else{
                JOptionPane.showMessageDialog(frmConP, "No se encontro el pago");
            }
        }
        if(e.getSource()==frmConP.buttonModifiarP){
            Pago p = new Pago();
            p.setCedula(frmConP.txtCedulaPM.getText());
            p.setMonto(frmConP.txtMontoPM.getText());
            p.setFecha(frmConP.txtFechaPM.getText());
            p.setTipo(frmConP.txtCedulaPM.getText());
            p.setDesc(frmConP.txtDescripcionPM.getText());
            String tipo = (String) frmConP.comboTipoPM.getSelectedItem();
            p.setTipo(tipo);
            if(pagodb.actualizar(p,frmConP.txtIdPM.getText())){
               JOptionPane.showMessageDialog(frmConP, "Se actualizo el pago");
               frmConP.buttonModifiarP.setVisible(false);
               frmConP.txtIdPM.setEditable(true);
            }else{
               JOptionPane.showMessageDialog(frmConP, "No se actualizo el pago");  
            }
        }
        if(e.getSource()==frmConP.buttonBuscarPE){
            String tipoComboString = (String) frmConP.comboEliminarPago.getSelectedItem();
            if(pagodb.eliminar(frmConP.txtIdPE.getText(), tipoComboString)){
                JOptionPane.showMessageDialog(frmConP, "Se elimino el pago");
            }else{
                JOptionPane.showMessageDialog(frmConP, "No de pudo eliminar el pago");
            }
        }
    }
}
