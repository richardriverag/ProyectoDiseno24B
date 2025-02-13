/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyectodiseno24b;


import controller.CtrLogin;
import controller.CtrMenuBar;
import model.Conexion;
import model.Usuarios.DbUsuario;
import view.FrmUsuarioLogin;
import view.frmMenuBar;
import view.comunicacion.FrmReporte;
import view.comunicacion.FrmMensaje;
import view.comunicacion.FrmMensajeAdmin;
import view.frmMenuBar;

/**
 *
 * @author Richard
 */
public class ProyectoDiseno24B {

    public static void main(String[] args) {

        DbUsuario db = new DbUsuario();
        db.verUsuarios();
        db.verRoles();



        
//        FrmUsuarioLogin frmLogin = new FrmUsuarioLogin();
//        CtrLogin controlador = new CtrLogin(frmLogin); // 
//        frmLogin.setVisible(true);


//        frmMenuBar frmMB = new frmMenuBar();
//        frmMB.setVisible(true);
//        FrmMensaje frm1 = new FrmMensaje();
//        FrmMensajeAdmin frma = new FrmMensajeAdmin();
//        FrmReporte frm = new FrmReporte();
        frmMenuBar frmConP = new frmMenuBar();
        CtrMenuBar menu = new CtrMenuBar(frmConP);
        menu.iniciar();
        
        
        //frm.setVisible(true);
        //frm1.setVisible(true);
        //frma.setVisible(true);
    }
}
