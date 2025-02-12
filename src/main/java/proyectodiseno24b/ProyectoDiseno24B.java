/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyectodiseno24b;


import controller.CtrMenuBar;
import view.FrmMenuBar;
import view.comunicacion.FrmReporte;
import view.comunicacion.FrmMensaje;
import view.comunicacion.FrmMensajeAdmin;

/**
 *
 * @author Richard
 */
public class ProyectoDiseno24B {

    public static void main(String[] args) {
        FrmMensaje frm1 = new FrmMensaje();
        FrmMensajeAdmin frma = new FrmMensajeAdmin();
        FrmReporte frm = new FrmReporte();
        FrmMenuBar frmConP = new FrmMenuBar();
        
        CtrMenuBar menu = new CtrMenuBar(frmConP);
        menu.iniciar();
        
        //frm.setVisible(true);
        //frm1.setVisible(true);
        //frma.setVisible(true);
    }
}
