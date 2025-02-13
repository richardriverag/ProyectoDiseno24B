package controller.comunicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import model.comunicacion.DbReporteMensaje;
import model.comunicacion.ReporteMensaje;
import model.comunicacion.UsuarioModel;
import view.comunicacion.FrmReporte;

public class CtrReporte implements ActionListener {
    private ReporteMensaje reporte;
    private DbReporteMensaje dbReporte;
    private FrmReporte frm;

    public CtrReporte(ReporteMensaje reporte, DbReporteMensaje dbReporte, FrmReporte frm) {
        this.reporte = reporte;
        this.dbReporte = dbReporte;
        this.frm = frm;
        this.frm.btnGenerarReporte.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Generar Reportes");
        frm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGenerarReporte) {
            Date fechaInicio = frm.jDateChooserInicio.getDate();
            Date fechaFinal = frm.jDateChooserFinal.getDate();
            String contenido = "Reporte generado"; // Puedes agregar detalles personalizados

            reporte.setFechaInicio(fechaInicio);
            reporte.setFechaFinal(fechaFinal);
            reporte.setContenido(contenido);
            reporte.setUsuario(new UsuarioModel(1, null, null, null, null, null, 0, null, null));

            if (dbReporte.generarReporte(reporte)) {
                JOptionPane.showMessageDialog(null, "Reporte generado con �xito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al generar el reporte");
            }
        }
    }
}
