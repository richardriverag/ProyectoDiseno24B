/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyectodiseno24b;

import controller.CtrMenuBar;
import model.InmueblesModel;
import view.FrmUsuarioLogin;
import view.FrmUsuarioRecuperarPass;
import view.FrmMenuBar;

/**
 *
 * @author Richard
 */
public class ProyectoDiseno24B {

    public static void main(String[] args) {
        FrmUsuarioLogin frmLogin = new FrmUsuarioLogin();    
        FrmUsuarioRecuperarPass frmRecuperarPass = new FrmUsuarioRecuperarPass();
        FrmMenuBar frMenu = new FrmMenuBar();
        CtrMenuBar menu = new CtrMenuBar(frMenu);
        menu.iniciar();
    }
}
