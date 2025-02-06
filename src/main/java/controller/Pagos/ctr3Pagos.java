/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Pagos;

import java.awt.CardLayout;
import view.FrmMenuBar;

/**
 *
 * @author LENOVO.USER
 */
public class ctr3Pagos {
    private FrmMenuBar frmConP;

    public ctr3Pagos(FrmMenuBar frmConP) {
        this.frmConP = frmConP;
    }
    
    public void iniciar(){
        CardLayout cardLayout = (CardLayout) frmConP.PanelPrincipal.getLayout();
        cardLayout.show(frmConP.PanelPrincipal, "card15"); // Mostrar el panel de guardar
        System.out.println("Panel 3 Pagos mostrado.");
    }
}
