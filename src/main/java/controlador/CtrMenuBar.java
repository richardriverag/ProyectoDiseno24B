/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.frmMenuBar;


/**
 *
 * @author RIBZ
 */
public class CtrMenuBar  implements ActionListener{
    private frmMenuBar frmConP;
    
    
    public CtrMenuBar(frmMenuBar frmContenedorPrincipal){
        this.frmConP = frmContenedorPrincipal;
        //this.frmConP.jMenuTelecomunicaciones.addActionListener(this);
    }
    public void iniciar() {
        frmConP.setTitle("Administrador");
        frmConP.setLocation(100,100);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
           
        }
    }

