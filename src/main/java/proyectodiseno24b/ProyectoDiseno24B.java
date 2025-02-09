/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyectodiseno24b;


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
        
        
        frm.setVisible(true);
        frm1.setVisible(true);
        frma.setVisible(true);
    }
}
