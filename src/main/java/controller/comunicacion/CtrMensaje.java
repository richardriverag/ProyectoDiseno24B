package controller.comunicacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.comunicacion.DbAnuncioGeneral;
import model.comunicacion.AnuncioGeneral;
import model.comunicacion.DbMensaje;
import model.comunicacion.Mensaje;
import model.comunicacion.UsuarioModel;
import view.comunicacion.FrmMensaje;

public class CtrMensaje implements ActionListener {
    private AnuncioGeneral anuncio;
    private DbAnuncioGeneral dbAnuncio;
    private Mensaje comunicado;
    private DbMensaje dbMensaje;
    private FrmMensaje frm;

    public CtrMensaje(AnuncioGeneral anuncio, DbAnuncioGeneral dbAnuncio, Mensaje comunicado, DbMensaje dbMensaje, FrmMensaje frm) {
        this.anuncio = anuncio;
        this.dbAnuncio = dbAnuncio;
        this.comunicado = comunicado;
        this.dbMensaje = dbMensaje;
        this.frm = frm;

        this.frm.btnAnuncioGeneral.addActionListener(this);
        this.frm.btnComunicado.addActionListener(this);
        this.frm.btnResidentes.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Mensajes");
        frm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnAnuncioGeneral) {
            anuncio.setContenido(frm.lsUsuarios.getName());
            anuncio.setUsuario(new UsuarioModel(1, null, null, null, null, null, 0, null, null));

            if (dbAnuncio.generarAnuncioGeneral(anuncio)) {
                JOptionPane.showMessageDialog(null, "Anuncio enviado");
                limpiarAnuncio();
            } else {
                JOptionPane.showMessageDialog(null, "Error al enviar anuncio");
            }
        }

        if (e.getSource() == frm.btnComunicado) {
            comunicado.setContenido(frm.lsUsuarios.getName());
            comunicado.setRemitente(new UsuarioModel(1, null, null, null, null, null, 0, null, null));

            if (dbMensaje.enviar(comunicado)) {
                JOptionPane.showMessageDialog(null, "Comunicado enviado");
                limpiarComunicado();
            } else {
                JOptionPane.showMessageDialog(null, "Error al enviar comunicado");
            }
        }
    }

    public void limpiarAnuncio() {
        frm.txtAnuncioGeneral.setText(null);
    }

    public void limpiarComunicado() {
        frm.txtComunicadoEmpleados.setText(null);
    }
}
