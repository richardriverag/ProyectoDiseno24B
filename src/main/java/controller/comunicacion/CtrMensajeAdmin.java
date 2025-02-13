package controller.comunicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.comunicacion.DbAnuncioGeneral;
import model.comunicacion.AnuncioGeneral;
import model.comunicacion.DbMensaje;
import model.comunicacion.Mensaje;
import model.comunicacion.UsuarioModel;
import view.comunicacion.FrmMensajeAdmin;

public class CtrMensajeAdmin implements ActionListener {
    private AnuncioGeneral anuncio;
    private DbAnuncioGeneral dbAnuncio;
    private Mensaje comunicado;
    private DbMensaje dbMensaje;
    private FrmMensajeAdmin frm;

    public CtrMensajeAdmin(AnuncioGeneral anuncio, DbAnuncioGeneral dbAnuncio, Mensaje comunicado, DbMensaje dbMensaje, FrmMensajeAdmin frm) {
        this.anuncio = anuncio;
        this.dbAnuncio = dbAnuncio;
        this.comunicado = comunicado;
        this.dbMensaje = dbMensaje;
        this.frm = frm;

        this.frm.btnEnviarAnuncioGeneral.addActionListener(this);
        this.frm.btnEnviarComunicado.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Administraci�n de Mensajes");
        frm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnEnviarAnuncioGeneral) {
            anuncio.setContenido(frm.txtAnuncioGeneral.getText());
            anuncio.setUsuario(new UsuarioModel(1, null, null, null, null, null, 0, null, null));

            if (dbAnuncio.generarAnuncioGeneral(anuncio)) {
                JOptionPane.showMessageDialog(null, "Anuncio enviado");
                limpiarAnuncio();
            } else {
                JOptionPane.showMessageDialog(null, "Error al enviar anuncio");
            }
        }

        if (e.getSource() == frm.btnEnviarComunicado) {
            comunicado.setContenido(frm.txtComunicadoEmpleados.getText());
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
